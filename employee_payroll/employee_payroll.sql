-- =====================================
-- UC 1: Create Payroll Service Database
-- =====================================

CREATE DATABASE payroll_service;
SHOW DATABASES;
USE payroll_service;

-- =====================================
-- UC 2: Create Employee Payroll Table
-- =====================================

CREATE TABLE employee_payroll (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    salary DOUBLE,
    start DATE
);

DESC employee_payroll;

-- =====================================
-- UC 3: Insert Employee Payroll Data
-- =====================================

INSERT INTO employee_payroll (name, salary, start)
VALUES
('Bill', 100000.00, '2018-01-03'),
('Terisa', 200000.00, '2019-11-13'),
('Charlie', 300000.00, '2020-05-21');

-- =====================================
-- UC 4: Retrieve All Payroll Data
-- =====================================

SELECT * FROM employee_payroll;

-- =====================================
-- UC 5: Salary & Date Range Queries
-- =====================================

-- Salary of Bill
SELECT salary
FROM employee_payroll
WHERE name = 'Bill';

-- Employees joined between date range
SELECT *
FROM employee_payroll
WHERE start BETWEEN CAST('2018-01-01' AS DATE) AND DATE(NOW());

-- =====================================
-- UC 6: Add Gender & Update Records
-- =====================================

ALTER TABLE employee_payroll
ADD gender CHAR(1) AFTER name;

UPDATE employee_payroll
SET gender = 'M'
WHERE name = 'Bill' OR name = 'Charlie';

UPDATE employee_payroll
SET gender = 'F'
WHERE name = 'Terisa';

SELECT * FROM employee_payroll;

-- =====================================
-- UC 7: Aggregate Functions by Gender
-- =====================================

SELECT gender, SUM(salary) AS total_salary
FROM employee_payroll
GROUP BY gender;

SELECT gender, AVG(salary) AS average_salary
FROM employee_payroll
GROUP BY gender;

SELECT gender, MIN(salary) AS min_salary
FROM employee_payroll
GROUP BY gender;

SELECT gender, MAX(salary) AS max_salary
FROM employee_payroll
GROUP BY gender;

SELECT gender, COUNT(*) AS employee_count
FROM employee_payroll
GROUP BY gender;
