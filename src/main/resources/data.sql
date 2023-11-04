INSERT INTO address (street, postal_code, city) VALUES ('Hall Gardens 120', '12345', 'Ravenstone');
INSERT INTO address (street, postal_code, city) VALUES ('Sköntorpsvägen 130', '23456', 'Årsta');
INSERT INTO address (street, postal_code, city) VALUES ('Järntorget 140', '21456', 'Göteborg');

INSERT INTO member (first_name, last_name, address_id, email, phone, date_of_birth) VALUES ('Connie', 'Churchill', 1, 'connie.churchil@fakemail.com', '0701234567', '1990-01-01');
INSERT INTO member (first_name, last_name, address_id, email, phone, date_of_birth) VALUES ('Bertil', 'Bengtsson', 2, 'bertil.bengtsson@fakemail.com', '0701234568', '1981-02-02');
INSERT INTO member (first_name, last_name, address_id, email, phone, date_of_birth) VALUES ('Bengt', 'Bertilsson', 3, 'bertil.bengtsson@fakemail.com', '0701234568', '1981-02-02');

INSERT INTO user_credentials (username, password, role, member_id) VALUES ('connie', '$2a$10$Tt7HIVn2arAfmUPzPQjN2OGkJtXhCAKy1Q4h5lYjiHRUVi9Bt32aq', 'ROLE_USER', 1);
INSERT INTO user_credentials (username, password, role, member_id) VALUES ('bertil', '$2a$10$Tt7HIVn2arAfmUPzPQjN2OGkJtXhCAKy1Q4h5lYjiHRUVi9Bt32aq', 'ROLE_ADMIN', 2);
INSERT INTO user_credentials (username, password, role, member_id) VALUES ('bengt', '$2a$10$Tt7HIVn2arAfmUPzPQjN2OGkJtXhCAKy1Q4h5lYjiHRUVi9Bt32aq', 'ROLE_USER', 3);