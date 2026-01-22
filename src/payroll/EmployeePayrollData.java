package payroll;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class EmployeePayrollData {

    public int empId;
    public String name;
    public String gender;
    public LocalDate startDate;
    public double salary;
    public List<String> departments;
    public boolean isActive;

    public EmployeePayrollData(int empId, String name, String gender,
                               LocalDate startDate, double salary,
                               List<String> departments, boolean isActive) {
        this.empId = empId;
        this.name = name;
        this.gender = gender;
        this.startDate = startDate;
        this.salary = salary;
        this.departments = departments;
        this.isActive = isActive;
    }

    // Needed for JUnit comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeePayrollData)) return false;
        EmployeePayrollData that = (EmployeePayrollData) o;
        return empId == that.empId &&
                Double.compare(that.salary, salary) == 0 &&
                Objects.equals(name, that.name) &&
                Objects.equals(gender, that.gender);
    }
}
