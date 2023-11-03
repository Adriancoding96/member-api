
CREATE TABLE IF NOT EXISTS address (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    street VARCHAR(100),
    postal_code VARCHAR(10),
    city VARCHAR(100)
    );


CREATE TABLE IF NOT EXISTS member (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(15),
    date_of_birth DATE,
    address_id BIGINT,
    FOREIGN KEY (address_id) REFERENCES address(id)
    );
