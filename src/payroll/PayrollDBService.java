package payroll;

import java.sql.*;
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


}
