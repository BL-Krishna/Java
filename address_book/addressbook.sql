-- =====================================
-- UC 1: Create Address Book Database
-- =====================================

CREATE DATABASE address_book_service;
SHOW DATABASES;
USE address_book_service;

-- =====================================
-- UC 2: Create Address Book Table
-- =====================================

CREATE TABLE address_book (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    address VARCHAR(150),
    city VARCHAR(50),
    state VARCHAR(50),
    zip VARCHAR(10),
    phone_number VARCHAR(15),
    email VARCHAR(100)
);

DESC address_book;

-- =====================================
-- UC 3: Insert New Contacts
-- =====================================

INSERT INTO address_book
(first_name, last_name, address, city, state, zip, phone_number, email)
VALUES
('Bill', 'Smith', 'Street 1', 'New York', 'NY', '10001', '9876543210', 'bill@gmail.com'),
('Charlie', 'Brown', 'Street 2', 'Los Angeles', 'CA', '90001', '9876543222', 'charlie@gmail.com'),
('Terisa', 'Jones', 'Street 3', 'New York', 'NY', '10002', '9876543333', 'terisa@gmail.com');

-- =====================================
-- UC 4: Edit Existing Contact Using Name
-- =====================================

UPDATE address_book
SET phone_number = '9999999999'
WHERE first_name = 'Bill';

-- =====================================
-- UC 5: Delete Contact Using Name
-- =====================================

DELETE FROM address_book
WHERE first_name = 'Charlie';

-- =====================================
-- UC 6: Retrieve Persons by City or State
-- =====================================

SELECT *
FROM address_book
WHERE city = 'New York';

SELECT *
FROM address_book
WHERE state = 'NY';

-- =====================================
-- UC 7: Count by City and State
-- =====================================

SELECT city, COUNT(*) AS total_contacts
FROM address_book
GROUP BY city;

SELECT state, COUNT(*) AS total_contacts
FROM address_book
GROUP BY state;

-- =====================================
-- UC 8: Sort Alphabetically by Name for a City
-- =====================================

SELECT *
FROM address_book
WHERE city = 'New York'
ORDER BY first_name ASC;

-- =====================================
-- UC 9: Add Address Book Name & Type
-- =====================================

ALTER TABLE address_book
ADD address_book_name VARCHAR(50),
ADD address_book_type VARCHAR(50);

UPDATE address_book
SET address_book_name = 'MyContacts',
    address_book_type = 'Family'
WHERE first_name = 'Bill';

UPDATE address_book
SET address_book_name = 'MyContacts',
    address_book_type = 'Friends'
WHERE first_name = 'Terisa';

-- =====================================
-- UC 10: Count Contacts by Type
-- =====================================

SELECT address_book_type, COUNT(*) AS total_contacts
FROM address_book
GROUP BY address_book_type;

-- =====================================
-- UC 11: Add Person to Both Friend & Family
-- (Same person stored with different types)
-- =====================================

INSERT INTO address_book
(first_name, last_name, address, city, state, zip, phone_number, email, address_book_name, address_book_type)
VALUES
('Sam', 'Wilson', 'Street 4', 'Chicago', 'IL', '60601', '8888888888', 'sam@gmail.com', 'MyContacts', 'Friends'),
('Sam', 'Wilson', 'Street 4', 'Chicago', 'IL', '60601', '8888888888', 'sam@gmail.com', 'MyContacts', 'Family');
