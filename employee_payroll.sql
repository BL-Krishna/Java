create database employees_payroll;
use employees_payroll;

CREATE TABLE employee_parroll (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(110),
gender char(1),
salary DOUBLE,
start_date DATE
);

rename table employee_parroll to employee_payroll;

INSERT INTO employee_payroll (name, gender, salary, start_date) VALUES
('Kiran Kumar', 'M', 35000.00, '2022-01-15'),
('Priyanka', 'F', 42000.50, '2021-11-01'),
('Ramesh Naidu', 'M', 50000.00, '2020-06-10'),
('Sneha Latha', 'M', 48000.75, '2023-03-25'),
('Vikramaditya', 'M', 60000.00, '2019-09-05');

ALTER TABLE employee_payroll
ADD phone VARCHAR(15),
ADD address VARCHAR(150) DEFAULT 'Not Provided',
ADD department VARCHAR(50) NOT NULL;

UPDATE employee_payroll SET phone = '9014302544', address = 'Chennai', department = 'IT' WHERE name = 'Kiran Kumar';
UPDATE employee_payroll SET phone = '9014302545', address = 'Madurai', department = 'HR' WHERE name = 'Priyanka';
UPDATE employee_payroll SET phone = '9014302546', address = 'Coimbatore', department = 'Finance' WHERE name = 'Ramesh Naidu';
UPDATE employee_payroll SET phone = '9014302547', address = 'Trichy', department = 'Admin' WHERE name = 'Sneha Latha';
UPDATE employee_payroll SET phone = '9014302548', address = 'Bengaluru', department = 'Management' WHERE name = 'Vikramaditya';

ALTER TABLE employee_payroll
ADD basic_pay DECIMAL(10,2),
ADD deductions DECIMAL(10,2),
ADD taxable_pay DECIMAL(10,2),
ADD income_tax DECIMAL(10,2),
ADD net_pay DECIMAL(10,2);

UPDATE employee_payroll
SET basic_pay = 35000,
    deductions = 2000,
    taxable_pay = basic_pay - deductions,
    income_tax = taxable_pay * 0.10,
    net_pay = taxable_pay - income_tax
WHERE id = 1;

UPDATE employee_payroll
SET basic_pay = 30000,
    deductions = 1000,
    taxable_pay = basic_pay - deductions,
    income_tax = taxable_pay * 0.10,
    net_pay = taxable_pay - income_tax
WHERE id = 2;

UPDATE employee_payroll
SET basic_pay = 40000,
    deductions = 1500,
    taxable_pay = basic_pay - deductions,
    income_tax = taxable_pay * 0.20,
    net_pay = taxable_pay - income_tax
WHERE id = 3;

UPDATE employee_payroll
SET basic_pay = 45000,
    deductions = 2500,
    taxable_pay = basic_pay - deductions,
    income_tax = taxable_pay * 0.25,
    net_pay = taxable_pay - income_tax
WHERE id = 4;

UPDATE employee_payroll
SET basic_pay = 55000,
    deductions = 3500,
    taxable_pay = basic_pay - deductions,
    income_tax = taxable_pay * 0.35,
    net_pay = taxable_pay - income_tax
WHERE id = 5;

ALTER TABLE employee_payroll DROP COLUMN department;

CREATE TABLE department (
    dept_id INT AUTO_INCREMENT PRIMARY KEY,
    dept_name VARCHAR(50) NOT NULL UNIQUE);

INSERT INTO department (dept_name) VALUES
('IT'),
('HR'),
('Finance'),
('Sales'),
('Marketing');

CREATE TABLE employee_department (
    emp_id INT,
    dept_id INT,
    PRIMARY KEY (emp_id, dept_id),
    FOREIGN KEY (emp_id) REFERENCES employee_payroll(id),
    FOREIGN KEY (dept_id) REFERENCES department(dept_id)
);



select * from department;
select * from employee_payroll;