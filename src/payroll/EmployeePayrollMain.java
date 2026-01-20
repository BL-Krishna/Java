package payroll;

public class EmployeePayrollMain {
    public static void main(String[] args) {

      PayrollDBService  service=PayrollDBService.getInstance();

        //uc2 reading the employee payroll data
        service.readEmployeePayrollData()
                .forEach(e -> System.out.println(e.name));

        // UC 3
        service.updateEmployeeSalary("Krishna", 3000000.00);
        // UC 3
        service.updateEmployeeSalary("Dattathreya", 4000000.00);

        //UC 4
        service.updateEmployeeSalaryUsingPreparedStatement(
                "Krishna", 5000000.00);


    }
}
