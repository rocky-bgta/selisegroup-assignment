INSERT INTO `user` (username, password) VALUES ('john_doe', 'password123');
INSERT INTO `user` (username, password) VALUES ('jane_doe', 'password456');


INSERT INTO role (role_name, role_fk) VALUES ('ROLE_USER', 1);  -- assuming user with id=1 exists
INSERT INTO role (role_name, role_fk) VALUES ('ROLE_ADMIN', 2); -- assuming user with id=2 exists


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


