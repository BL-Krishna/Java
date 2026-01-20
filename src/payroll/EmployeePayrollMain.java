package payroll;

public class EmployeePayrollMain {
    public static void main(String[] args) {

      PayrollDBService  service=PayrollDBService.getInstance();

      //uc2 reading the table data
        service.readEmployeePayrollData()
                .forEach(e -> System.out.println(e.name));

    }
}
