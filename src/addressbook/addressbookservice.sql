-- =========================================
-- Address Book System Database
-- =========================================

DROP DATABASE IF EXISTS addressbook_service;
CREATE DATABASE addressbook_service;
USE addressbook_service;

-- =========================================
-- Address Book Table
-- UC 5: Multiple Address Books
-- =========================================
CREATE TABLE address_book (
    address_book_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL
);

-- =========================================
-- Contact Table
-- UC 1–UC 4, UC 12+
-- =========================================
CREATE TABLE contact (
    contact_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    address VARCHAR(150),
    city VARCHAR(50),
    state VARCHAR(50),
    zip VARCHAR(10),
    phone VARCHAR(15),
    email VARCHAR(100),
    date_added DATE DEFAULT (CURRENT_DATE),

    CONSTRAINT unique_contact UNIQUE (first_name, last_name)
);

-- =========================================
-- AddressBook ↔ Contact (Many-to-Many)
-- UC 5, UC 19 (Transaction)
-- =========================================
CREATE TABLE address_book_contact (
    address_book_id INT,
    contact_id INT,
    PRIMARY KEY (address_book_id, contact_id),

    FOREIGN KEY (address_book_id)
        REFERENCES address_book(address_book_id)
        ON DELETE CASCADE,

    FOREIGN KEY (contact_id)
        REFERENCES contact(contact_id)
        ON DELETE CASCADE
);

-- =========================================
-- Indexes for Performance (Search/Count)
-- UC 7, UC 8, UC 9, UC 18
-- =========================================
CREATE INDEX idx_city ON contact(city);
CREATE INDEX idx_state ON contact(state);
CREATE INDEX idx_date_added ON contact(date_added);

-- =========================================
-- Sample Seed Data (Optional)
-- =========================================
INSERT INTO address_book (name) VALUES ('Personal'), ('Office');

INSERT INTO contact
(first_name, last_name, address, city, state, zip, phone, email)
VALUES
('Krishna', 'Sai', 'Street 1', 'Bangalore', 'KA', '560001', '9999999999', 'krishna@gmail.com'),
('Ravi', 'Kumar', 'Street 2', 'Hyderabad', 'TS', '500001', '8888888888', 'ravi@gmail.com');

INSERT INTO address_book_contact VALUES (1, 1), (1, 2);
