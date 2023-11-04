INSERT INTO address (street, postal_code, city) VALUES ('Tallstigen 1', '34567', 'Stockholm');
INSERT INTO address (street, postal_code, city) VALUES ('Granvägen 2', '45678', 'Göteborg');
INSERT INTO address (street, postal_code, city) VALUES ('Björkbacken 3', '56789', 'Umeå');
INSERT INTO address (street, postal_code, city) VALUES ('Aspgatan 4', '67890', 'Sundsvall');
INSERT INTO address (street, postal_code, city) VALUES ('Ekallén 5', '78901', 'Malmö');

INSERT INTO member (first_name, last_name, address_id, email, phone, date_of_birth) VALUES ('Alice', 'Andersson', 1, 'alice.andersson@fakemail.com', '0701234575', '1991-03-03');
INSERT INTO member (first_name, last_name, address_id, email, phone, date_of_birth) VALUES ('Adrian', 'Nilsson', 2, 'adrian.nilsson@fakemail.com', '0701234576', '1996-04-04');
INSERT INTO member (first_name, last_name, address_id, email, phone, date_of_birth) VALUES ('Cecilia', 'Carlsson', 3, 'cecilia.carlsson@fakemail.com', '0701234577', '1993-05-05');
INSERT INTO member (first_name, last_name, address_id, email, phone, date_of_birth) VALUES ('Daniel', 'Dahlgren', 4, 'daniel.dahlgren@fakemail.com', '0701234578', '1994-06-06');
INSERT INTO member (first_name, last_name, address_id, email, phone, date_of_birth) VALUES ('Eva', 'Eriksson', 5, 'eva.eriksson@fakemail.com', '0701234579', '1995-07-07');

INSERT INTO user_credentials (username, password, role, member_id) VALUES ('alice', '$2a$10$Tt7HIVn2arAfmUPzPQjN2OGkJtXhCAKy1Q4h5lYjiHRUVi9Bt32aq', 'ROLE_USER', 1);
INSERT INTO user_credentials (username, password, role, member_id) VALUES ('adrian', '$2a$10$Tt7HIVn2arAfmUPzPQjN2OGkJtXhCAKy1Q4h5lYjiHRUVi9Bt32aq', 'ROLE_ADMIN', 2);
INSERT INTO user_credentials (username, password, role, member_id) VALUES ('cecilia', '$2a$10$Tt7HIVn2arAfmUPzPQjN2OGkJtXhCAKy1Q4h5lYjiHRUVi9Bt32aq', 'ROLE_USER', 3);
INSERT INTO user_credentials (username, password, role, member_id) VALUES ('daniel', '$2a$10$Tt7HIVn2arAfmUPzPQjN2OGkJtXhCAKy1Q4h5lYjiHRUVi9Bt32aq', 'ROLE_USER', 4);
INSERT INTO user_credentials (username, password, role, member_id) VALUES ('eva', '$2a$10$Tt7HIVn2arAfmUPzPQjN2OGkJtXhCAKy1Q4h5lYjiHRUVi9Bt32aq', 'ROLE_USER', 5);

