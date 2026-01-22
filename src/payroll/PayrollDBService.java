package payroll;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class PayrollDBService {

    private static PayrollDBService payrollDBService;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/payroll_service";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private PayrollDBService() {}

    public static PayrollDBService getInstance() {
        if (payrollDBService == null)
            payrollDBService = new PayrollDBService();
        return payrollDBService;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    /* ================= UC 2 ================= */
    public List<EmployeePayrollData> readEmployeePayrollData() {
        List<EmployeePayrollData> list = new ArrayList<>();

        String sql =
                "SELECT e.emp_id, e.name, e.gender, e.start_date, p.salary " +
                        "FROM employee e JOIN payroll p ON e.emp_id = p.emp_id " +
                        "WHERE e.is_active = true";

        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new EmployeePayrollData(
                        rs.getInt("emp_id"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getDate("start_date").toLocalDate(),
                        rs.getDouble("salary"),
                        getDepartments(con, rs.getInt("emp_id")),
                        true
                ));
            }
        } catch (SQLException e) {
            throw new PayrollException("UC2 Failed: " + e.getMessage());
        }
        return list;
    }

    /* ================= UC 3 ================= */
    public int updateEmployeeSalary(String name, double salary) {
        String sql =
                "UPDATE payroll p JOIN employee e ON p.emp_id = e.emp_id " +
                        "SET p.salary = ? WHERE e.name = ? AND e.is_active = true";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, salary);
            ps.setString(2, name);
            return ps.executeUpdate();

        } catch (SQLException e) {
            throw new PayrollException("UC3 Failed");
        }
    }

    /* ================= UC 4 ================= */
    public int updateEmployeeSalaryUsingPreparedStatement(String name, double salary) {
        return updateEmployeeSalary(name, salary);
    }

    /* ================= UC 5 ================= */
    public List<EmployeePayrollData> getEmployeesByDateRange(
            LocalDate start, LocalDate end) {

        List<EmployeePayrollData> list = new ArrayList<>();

        String sql =
                "SELECT e.emp_id, e.name, e.gender, e.start_date, p.salary " +
                        "FROM employee e JOIN payroll p ON e.emp_id = p.emp_id " +
                        "WHERE e.start_date BETWEEN ? AND ? AND e.is_active = true";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, java.sql.Date.valueOf(start));
            ps.setDate(2, java.sql.Date.valueOf(end));

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new EmployeePayrollData(
                        rs.getInt("emp_id"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getDate("start_date").toLocalDate(),
                        rs.getDouble("salary"),
                        getDepartments(con, rs.getInt("emp_id")),
                        true
                ));
            }
        } catch (SQLException e) {
            throw new PayrollException("UC5 Failed");
        }
        return list;
    }

    /* ================= UC 6 ================= */
    public Map<String, Double> getSalaryStatsByGender(String operation) {

        Map<String, Double> map = new HashMap<>();

        String sql = String.format(
                "SELECT e.gender, %s(p.salary) " +
                        "FROM employee e JOIN payroll p ON e.emp_id = p.emp_id " +
                        "WHERE e.is_active = true GROUP BY e.gender", operation);

        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next())
                map.put(rs.getString(1), rs.getDouble(2));

        } catch (SQLException e) {
            throw new PayrollException("UC6 Failed");
        }
        return map;
    }

    /* ================= UC 8 / UC 11 ================= */
    public EmployeePayrollData addEmployee(
            String name, String gender, LocalDate startDate,
            double salary, List<String> departments) {

        Connection con = null;

        try {
            con = getConnection();
            con.setAutoCommit(false); // TRANSACTION START

            // Insert employee
            String empSQL =
                    "INSERT INTO employee (name, gender, start_date) VALUES (?, ?, ?)";
            PreparedStatement empStmt =
                    con.prepareStatement(empSQL, Statement.RETURN_GENERATED_KEYS);

            empStmt.setString(1, name);
            empStmt.setString(2, gender);
            empStmt.setDate(3, java.sql.Date.valueOf(startDate));
            empStmt.executeUpdate();

            ResultSet rs = empStmt.getGeneratedKeys();
            rs.next();
            int empId = rs.getInt(1);

            // Derived payroll fields
            double deductions = salary * 0.20;
            double taxable = salary - deductions;
            double tax = taxable * 0.10;
            double netPay = salary - tax;

            String paySQL =
                    "INSERT INTO payroll (emp_id, salary, deductions, taxable_pay, tax, net_pay) " +
                            "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement payStmt = con.prepareStatement(paySQL);
            payStmt.setInt(1, empId);
            payStmt.setDouble(2, salary);
            payStmt.setDouble(3, deductions);
            payStmt.setDouble(4, taxable);
            payStmt.setDouble(5, tax);
            payStmt.setDouble(6, netPay);
            payStmt.executeUpdate();

            // Departments
            for (String dept : departments) {
                int deptId = getOrCreateDepartment(con, dept);

                String empDeptSQL =
                        "INSERT INTO employee_department (emp_id, dept_id) VALUES (?, ?)";
                PreparedStatement edStmt = con.prepareStatement(empDeptSQL);
                edStmt.setInt(1, empId);
                edStmt.setInt(2, deptId);
                edStmt.executeUpdate();
            }

            con.commit(); // SUCCESS

            return new EmployeePayrollData(
                    empId, name, gender, startDate, salary, departments, true);

        } catch (Exception e) {
            try {
                if (con != null) con.rollback();
            } catch (SQLException ignored) {}
            throw new PayrollException("UC8 / UC11 Failed");
        }
    }

    /* ================= UC 12 ================= */
    public void removeEmployee(int empId) {
        String sql = "UPDATE employee SET is_active = false WHERE emp_id = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, empId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new PayrollException("UC12 Failed");
        }
    }

    private int getOrCreateDepartment(Connection con, String dept) throws SQLException {
        String select = "SELECT dept_id FROM department WHERE dept_name = ?";
        PreparedStatement ps = con.prepareStatement(select);
        ps.setString(1, dept);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) return rs.getInt(1);

        String insert = "INSERT INTO department (dept_name) VALUES (?)";
        PreparedStatement ins =
                con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
        ins.setString(1, dept);
        ins.executeUpdate();
        ResultSet gen = ins.getGeneratedKeys();
        gen.next();
        return gen.getInt(1);
    }

    private List<String> getDepartments(Connection con, int empId) throws SQLException {
        List<String> list = new ArrayList<>();
        String sql =
                "SELECT d.dept_name FROM department d " +
                        "JOIN employee_department ed ON d.dept_id = ed.dept_id " +
                        "WHERE ed.emp_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, empId);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
            list.add(rs.getString(1));
        return list;
    }
}
