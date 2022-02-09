-- User data
INSERT INTO User (user_id, user_name, first_name, last_name, adress, phone_number, email, password) values (1, 'U', 'First', 'Last', 'ulica', 'tel broj', 'user@', 'sifra');
SELECT nextval('hibernate_sequence');
INSERT INTO User (user_id, user_name, first_name, last_name, adress, phone_number, email, password) values (2, 'U1', 'First1', 'Last1', 'ulica1', 'tel broj1', 'user@1', 'sifra1');
SELECT nextval('hibernate_sequence');
INSERT INTO User (user_id, user_name, first_name, last_name, adress, phone_number, email, password) values (3, 'U2', 'First2', 'Last2', 'ulica2', 'tel broj2', 'user@2', 'sifra2');
SELECT nextval('hibernate_sequence');
INSERT INTO User (user_id, user_name, first_name, last_name, adress, phone_number, email, password) values (4, 'U3', 'First3', 'Last3', 'ulica3', 'tel broj3', 'user@3', 'sifra3');
SELECT nextval('hibernate_sequence');
INSERT INTO User (user_id, user_name, first_name, last_name, adress, phone_number, email, password) values (5, 'U4', 'First4', 'Last4', 'ulica4', 'tel broj4', 'user@4', 'sifra4');
SELECT nextval('hibernate_sequence');
-- Role data
INSERT INTO Role (role_id, name) VALUES (1, 'TEST');
SELECT nextval('hibernate_sequence');
INSERT INTO Role (role_id, name) VALUES (2, 'GUEST');
SELECT nextval('hibernate_sequence');
INSERT INTO Role (role_id, name) VALUES (3, 'ADMIN');
SELECT nextval('hibernate_sequence');
INSERT INTO Role (role_id, name) VALUES (4, 'USER');
SELECT nextval('hibernate_sequence');
INSERT INTO Role (role_id, name) VALUES (5, 'SUPER_USER');
SELECT nextval('hibernate_sequence');
-- UserRole data
INSERT INTO User_Role (user_role_id, role_id, user_id) VALUES (1, 1, 1);
SELECT nextval('hibernate_sequence');
INSERT INTO User_Role (user_role_id, role_id, user_id) VALUES (2, 4, 2);
SELECT nextval('hibernate_sequence');
INSERT INTO User_Role (user_role_id, role_id, user_id) VALUES (3, 4, 3);
SELECT nextval('hibernate_sequence');
INSERT INTO User_Role (user_role_id, role_id, user_id) VALUES (4, 3, 4);
SELECT nextval('hibernate_sequence');
-- Language data
INSERT INTO Language (language_id, name, code) VALUES (1, 'Serb', 'srb');
SELECT nextval('hibernate_sequence');
INSERT INTO Language (language_id, name, code) VALUES (2, 'Englisch', 'eng');
SELECT nextval('hibernate_sequence');
INSERT INTO Language (language_id, name, code) VALUES (3, 'Deutsch', 'ger');
SELECT nextval('hibernate_sequence');
INSERT INTO Language (language_id, name, code) VALUES (4, 'Croatian', 'cro');
SELECT nextval('hibernate_sequence');

