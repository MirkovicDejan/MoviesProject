-- User data
insert into User (user_id, user_name, first_name, last_name, adress, phone_number, email, password) values (100, 'U', 'First', 'Last', 'ulica', 'tel broj', 'user@', 'sifra');
insert into User (user_id, user_name, first_name, last_name, adress, phone_number, email, password) values (101, 'U1', 'First1', 'Last1', 'ulica1', 'tel broj1', 'user@1', 'sifra1');
insert into User (user_id, user_name, first_name, last_name, adress, phone_number, email, password) values (102, 'U2', 'First2', 'Last2', 'ulica2', 'tel broj2', 'user@2', 'sifra2');
insert into User (user_id, user_name, first_name, last_name, adress, phone_number, email, password) values (103, 'U3', 'First3', 'Last3', 'ulica3', 'tel broj3', 'user@3', 'sifra3');
insert into User (user_id, user_name, first_name, last_name, adress, phone_number, email, password) values (104, 'U4', 'First4', 'Last4', 'ulica4', 'tel broj4', 'user@4', 'sifra4');

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
INSERT INTO User_Role (user_role_id, role_id, user_id) VALUES (100, 1, 100);
INSERT INTO User_Role (user_role_id, role_id, user_id) VALUES (101, 4, 101);
INSERT INTO User_Role (user_role_id, role_id, user_id) VALUES (102, 4, 102);
INSERT INTO User_Role (user_role_id, role_id, user_id) VALUES (103, 3, 103);

-- Language data
INSERT INTO Language (language_id, name, code) VALUES (100, 'Serb', 'srb');
INSERT INTO Language (language_id, name, code) VALUES (101, 'Englisch', 'eng');
INSERT INTO Language (language_id, name, code) VALUES (102, 'Deutsch', 'ger');
INSERT INTO Language (language_id, name, code) VALUES (103, 'Croatian', 'cro');

insert into Country (country_id, name, code) values (100, 'Serbia', 'SRB');
insert into Country (country_id, name, code) values (101, 'Croatia', 'CRO');
insert into Country (country_id, name, code) values (102, 'Montenegro', 'MNE');
insert into Country (country_id, name, code) values (103, 'Germany', 'GER');
insert into Country (country_id, name, code) values (104, 'England', 'ENG');

insert into Content_Type (content_type_id, name) values (100, 'CRIME');
insert into Content_Type (content_type_id, name) values (101, 'SPORT');
insert into Content_Type (content_type_id, name) values (102, 'ACTION');
insert into Content_Type (content_type_id, name) values (103, 'Sci-Fi');

insert into Content (content_id, content_type_id, country_id, language_id, title, year, duration, release_date, rating, cover_link, trailer_link) values (100, 100, 100, 100, '4 covek', 2007, 107, '2007-05-05', 7.3, null, null);
insert into Content (content_id, content_type_id, country_id, language_id, title, year, duration, release_date, rating, cover_link, trailer_link) values (101, 102, 100, 100, 'Juzni Vetar', 2018, 130, '2018-07-06', 8, null, null);
insert into Content (content_id, content_type_id, country_id, language_id, title, year, duration, release_date, rating, cover_link, trailer_link) values (102, 100, 104, 101, 'Godfather', 1972, 175, '1972-08-20', 9.2, null, null);

insert into Content_Comment (comment_id, user_id, content_id, comment) values (100, 101, 101, 'Very good film, with to much actions and funny things');
insert into Content_Comment (comment_id, user_id, content_id, comment) values (101, 101, 101, 'Powerful action movie :D !');

insert into Genere (genere_id, name) values (100, 'ACTIONS');
insert into Genere (genere_id, name) values (101, 'SPORTS');
insert into Genere (genere_id, name) values (102, 'CRIMES');
insert into Genere (genere_id, name) values (103, 'ROMANTICS');

insert into Content_Genere (content_genere_id, genere_id, content_id) values (100, 100, 100);
insert into Content_Genere (content_genere_id, genere_id, content_id) values (101, 100, 101);

insert into Season (season_id, content_id, name, season_number) values (100, 100, '4 covek prvi deo', 1);
insert into Season (season_id, content_id, name, season_number) values (101, 100, '4 covek drugi deo', 2);
insert into Season (season_id, content_id, name, season_number) values (102, 100, '4 covek treci deo', 3);

insert into Review (review_id, user_id, content_id, rating, favourite) values (100, 102, 100, 7.3, true);
insert into Review (review_id, user_id, content_id, rating, favourite) values (101, 103, 101, 8, true);

insert into Movie_Role(movie_role_id, name) values (100, 'MAIN ACTOR');
insert into Movie_Role(movie_role_id, name) values (101, 'SUPPORTING ACTOR');
insert into Movie_Role(movie_role_id, name) values (102, 'SCENARIST');
insert into Movie_Role(movie_role_id, name) values (103, 'CAMERAMAN');


insert into Movie_People(movie_people_id, first_name, last_name, brith_date, gender) values (100, 'Jason', 'Statham','1967-09-26','1');
insert into Movie_People(movie_people_id, first_name, last_name, brith_date, gender) values (101, 'Angelina', 'Jolie','1975-06-04','2');
insert into Movie_People(movie_people_id, first_name, last_name, brith_date, gender) values (102, 'Sandra', 'Bullock','1964-07-26','2');
insert into Movie_People(movie_people_id, first_name, last_name, brith_date, gender) values (103, 'Al', 'Pacino','1940-04-25','1');

insert into Movie_People_Role (movie_people_role_id, movie_role_id, movie_people_id) values (100, 100, 100);
insert into Movie_People_Role (movie_people_role_id, movie_role_id, movie_people_id) values (101, 101, 101);
insert into Movie_People_Role (movie_people_role_id, movie_role_id, movie_people_id) values (102, 101, 102);

insert into Serie_Cast (serie_cast_id, season_id, movie_role_id, movie_people_id) values (100, 101, 102, 100);
insert into Serie_Cast (serie_cast_id, season_id, movie_role_id, movie_people_id) values (101, 102, 102, 101);

insert into Movie_Cast (movie_cast_id, content_id, movie_role_id, movie_people_id) values (100, 101, 100, 100);
insert into Movie_Cast (movie_cast_id, content_id, movie_role_id, movie_people_id) values (101, 100, 101, 102);

insert into Episode (episode_id, season_id, name, duration, episode_number) values (100, 101, 'some episode', 40, 3);
insert into Episode (episode_id, season_id, name, duration, episode_number) values (101, 102, 'some episode', 45, 4);
insert into Episode (episode_id, season_id, name, duration, episode_number) values (102, 100, 'some episode', 43, 2);







