--to fill agency.client table
INSERT INTO client  VALUES (1,'opile0', 'bharbert0');
INSERT INTO client  VALUES (2,'iubsdall1', 'eandersen1');
INSERT INTO client  VALUES (3,'mstrewther2', 'mdykas2');

--INSERT INTO country (name) VALUES ('Ireland');
INSERT INTO country (name) VALUES (1,'China');
INSERT INTO country (name) VALUES (2,'China');
INSERT INTO country (name) VALUES (3,'Nigeria');


 --to fill agency.hotel table
INSERT INTO hotel (name, stars, website, lalitude, longitude, features) VALUES ('Mertz, Mitchell and Schultz', 1, 'https://ehow.com', -28.2674857, -52.4626809, 'fitness center,');
INSERT INTO hotel (name, stars, website, lalitude, longitude, features) VALUES ('Welch Inc', 2, 'https://tiny.cc', 1.3350205, 34.3976356, 'fitness center,');
INSERT INTO hotel (name, stars, website, lalitude, longitude, features) VALUES ('Purdy, Bruen and Reichert', 2, 'https://zdnet.com', '-6.57018', '111.03254', 'business center,airport transfer,fitness center,');

 --to fill agency.tour table
INSERT INTO tour (photo, date, duration, description, cost, tour_type, hotel_id, country_id) VALUES ('vouhtwz.png', '2017-10-28', 17, 'In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat. Curabitur gravida nisi at nibh.', 531.2, 'bus', 1, 1);
INSERT INTO tour (photo, date, duration, description, cost, tour_type, hotel_id, country_id) VALUES ('meovd.jpg', '2017-08-16', 72, 'Etiam faucibus cursus urna. Ut tellus. Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi. Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit.', 677.1, 'bus', 3, 2);
INSERT INTO tour (photo, date, duration, description, cost, tour_type, hotel_id, country_id) VALUES ('wgjcozn.png', '2017-08-18', 102, 'Pellentesque ultrices mattis odio. Donec vitae nisi. Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus.', 34.15, 'festival', 2, 3);

--to fill agency.tour table
INSERT INTO review (date, text, client_id, tour_id) VALUES ('2017-10-28', 'Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.', 1, 1);
INSERT INTO review (date, text, client_id, tour_id) VALUES ('2018-04-30', 'In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.', 2, 3);
INSERT INTO review (date, text, client_id, tour_id) VALUES ('2018-01-18', 'Nulla mollis molestie lorem. Quisque ut erat. Curabitur gravida nisi at nibh.', 3, 3);

--to fill agency.client_tour table
INSERT INTO client_tour (client_id, tour_id) VALUES (1, 3);
INSERT INTO client_tour (client_id, tour_id) VALUES (2, 1);
INSERT INTO client_tour (client_id, tour_id) VALUES (3, 2);
