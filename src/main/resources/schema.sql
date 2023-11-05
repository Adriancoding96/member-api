CREATE TABLE IF NOT EXISTS address (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    street VARCHAR(100),
    postal_code VARCHAR(10),
    city VARCHAR(100)
    );

CREATE TABLE IF NOT EXISTS member (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(15),
    date_of_birth DATE NOT NULL,
    address_id BIGINT NOT NULL,
    FOREIGN KEY (address_id) REFERENCES address(id)
    );


CREATE TABLE IF NOT EXISTS user_credentials (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(200) NOT NULL,
    role VARCHAR(20) NOT NULL,
    member_id BIGINT UNIQUE,
    FOREIGN KEY (member_id) REFERENCES member(id)
    );

