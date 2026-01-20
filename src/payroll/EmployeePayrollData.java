package payroll;

import java.time.LocalDate;

public class EmployeePayrollData {
    public int id;
    public String name;
    public double salary;
    public String gender;
    public LocalDate startDate;

    public EmployeePayrollData(int id, String name, double salary, String gender, LocalDate startDate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.startDate = startDate;
    }
}
