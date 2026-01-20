package payroll;

import java.sql.*;
import java.util.*;
public class PayrollDBService {

    private static PayrollDBService payrollDBService;
    private Connection connection;

    private static final String DB_URL="jdbc:mysql://localhost:3306/payroll_service";
    private static final String USER="root";
    private static final String PASSWORD="root";

    private PayrollDBService(){}

    public static PayrollDBService getInstance() {
        if (payrollDBService == null)
            payrollDBService = new PayrollDBService();
        return payrollDBService;
    }
    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(DB_URL,USER,PASSWORD);
    }

    /* ---------- UC 2 ---------- */
    public List<EmployeePayrollData> readEmployeePayrollData() {
        List<EmployeePayrollData> list = new ArrayList<>();
        String sql = "SELECT * FROM employee_payroll";

        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new EmployeePayrollData(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("salary"),
                        rs.getString("gender"),
                        rs.getDate("start").toLocalDate()
                ));
            }
        } catch (SQLException e) {
            throw new PayrollException("UC2 Error: " + e.getMessage());
        }
        return list;
    }

    /* ---------- UC 3 ---------- */
    public int updateEmployeeSalary(String name, double salary) {
        String sql = String.format(
                "UPDATE employee_payroll SET salary = %f WHERE name = '%s'",
                salary, name);

        try (Connection con = getConnection();
             Statement stmt = con.createStatement()) {

            return stmt.executeUpdate(sql);

        } catch (SQLException e) {
            throw new PayrollException("UC3 Error: " + e.getMessage());
        }
    }


}
