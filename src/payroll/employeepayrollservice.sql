CREATE DATABASE IF NOT EXISTS payroll_service;
USE payroll_service;

-- Employee table
CREATE TABLE employee (
    emp_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    gender CHAR(1) NOT NULL,
    start_date DATE NOT NULL,
    is_active BOOLEAN DEFAULT TRUE
);

-- Payroll details (derived fields)
CREATE TABLE payroll (
    payroll_id INT AUTO_INCREMENT PRIMARY KEY,
    emp_id INT NOT NULL,
    salary DOUBLE NOT NULL,
    deductions DOUBLE NOT NULL,
    taxable_pay DOUBLE NOT NULL,
    tax DOUBLE NOT NULL,
    net_pay DOUBLE NOT NULL,

    FOREIGN KEY (emp_id)
        REFERENCES employee(emp_id)
        ON DELETE CASCADE
);

-- Department table
CREATE TABLE department (
    dept_id INT AUTO_INCREMENT PRIMARY KEY,
    dept_name VARCHAR(50) UNIQUE NOT NULL
);

-- Employee ↔ Department (M:N)
CREATE TABLE employee_department (
    emp_id INT,
    dept_id INT,
    PRIMARY KEY (emp_id, dept_id),
    FOREIGN KEY (emp_id) REFERENCES employee(emp_id),
    FOREIGN KEY (dept_id) REFERENCES department(dept_id)
);
