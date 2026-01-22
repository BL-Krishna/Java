package payroll;

import java.time.LocalDate;
import java.util.Arrays;

public class EmployeePayrollMain {

    public static void main(String[] args) {

        PayrollDBService service = PayrollDBService.getInstance();

        // UC 8 / UC 11
        EmployeePayrollData emp =
                service.addEmployee(
                        "Krishna",
                        "M",
                        LocalDate.of(2025, 1, 10),
                        500000,
                        Arrays.asList("IT", "HR")
                );

        // UC 2
        service.readEmployeePayrollData()
                .forEach(e -> System.out.println(e.name + " " + e.salary));

        // UC 3 / UC 4
        service.updateEmployeeSalary("Krishna", 700000);

        // UC 5
        service.getEmployeesByDateRange(
                LocalDate.of(2024, 1, 1),
                LocalDate.now()
        );

        // UC 6
        System.out.println(service.getSalaryStatsByGender("SUM"));

        // UC 12
        service.removeEmployee(emp.empId);
    }
}
