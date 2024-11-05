-- Create the customer table
CREATE TABLE customer
(
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(100)        NOT NULL,
    email       VARCHAR(100) UNIQUE NOT NULL,
    phone       VARCHAR(20),
    address     VARCHAR(255),
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create the bank_account table with a foreign key to the customer table
CREATE TABLE bank_account
(
    account_id     INT AUTO_INCREMENT PRIMARY KEY,
    customer_id    INT,
    account_number VARCHAR(20) UNIQUE NOT NULL,
    balance        DECIMAL(15, 2)     NOT NULL,
    status         ENUM ('ACTIVE', 'INACTIVE', 'CLOSED') DEFAULT 'ACTIVE',
    created_at     TIMESTAMP                             DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE SET NULL
);

-- Insert sample data into the customer table
INSERT INTO customer (name, email, phone, address)
VALUES ('Alice Smith', 'alice@example.com', '123-456-7890', '123 Main St'),
       ('Bob Johnson', 'bob@example.com', '234-567-8901', '456 Elm St'),
       ('Charlie Brown', 'charlie@example.com', '345-678-9012', '789 Oak St');

-- Insert sample data into the bank_account table
INSERT INTO bank_account (customer_id, account_number, balance, status)
VALUES (1, 'ACC1001', 1500.00, 'ACTIVE'),
       (2, 'ACC1002', 2500.50, 'ACTIVE'),
       (3, 'ACC1003', 0.00, 'INACTIVE');