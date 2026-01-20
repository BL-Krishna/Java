package payroll;

import java.time.LocalDate;

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

        //UC 5
        service.getEmployeesByDateRange(
                LocalDate.of(2025,1,1),
                LocalDate.now());
        //UC 6
        System.out.println(service.getSalaryStatsByGender("SUM"));
    }
}
