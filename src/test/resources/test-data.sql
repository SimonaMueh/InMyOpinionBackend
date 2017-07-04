delete from categories;
delete from topics;
delete from votes;

INSERT INTO categories (id, text) VALUES (1, 'world');
INSERT INTO categories (id, text) VALUES (2, 'politics');
INSERT INTO categories (id, text) VALUES (3, 'people');
INSERT INTO categories (id, text) VALUES (4, 'nature');
INSERT INTO categories (id, text) VALUES (5, 'kids');
INSERT INTO categories (id, text) VALUES (6, 'art');
INSERT INTO categories (id, text) VALUES (7, 'architecture');
INSERT INTO categories (id, text) VALUES (8, 'food');
INSERT INTO categories (id, text) VALUES (9, 'news');
INSERT INTO categories (id, text) VALUES (10,'food');
INSERT INTO categories (id, text) VALUES (11,'music');

INSERT INTO topics (id, date_created, text, token, category_id) VALUES (1, { ts '1950-01-26 00:00:00.00'}, 'I like  pink. \n', '1475eace-926a-45ee-b954-e72bfbb98ae3', 4);
INSERT INTO topics (id, date_created, text, token, category_id) VALUES (2, { ts '1945-07-31 00:00:00.00'}, 'I like chinese food. \n', '8df15654-21f2-42ae-85f0-d7802c8a6d4c', 2);
INSERT INTO topics (id, date_created, text, token, category_id) VALUES (3, { ts '1936-05-16 00:00:00.00'}, 'I like tattoos. \n', 'a2873348-029b-4a84-86f5-932aa5f80331', 3);
INSERT INTO topics (id, date_created, text, token, category_id) VALUES (4, { ts '1964-07-07 00:00:00.00'}, 'I have action figures in my rooms. \n', '68f16361-2c7b-443d-8ef5-e984eb4b74c7', 6);
INSERT INTO topics (id, date_created, text, token, category_id) VALUES (5, { ts '1910-12-12 00:00:00.00'}, 'I like watching GLEE. \n', '9df64932-04b1-42e1-a57c-914f4046a533', 10);
INSERT INTO topics (id, date_created, text, token, category_id) VALUES (6, { ts '1944-03-01 00:00:00.00'}, 'I like food.', '69c7e26a-7387-4c58-894f-3e43d91272c2', 3);
INSERT INTO topics (id, date_created, text, token, category_id) VALUES (7, { ts '1990-01-13 00:00:00.00'}, 'I want to climb a mountain?\n', 'eea7e104-3014-47b0-9ea2-1f107c960d88', 8);
INSERT INTO topics (id, date_created, text, token, category_id) VALUES (8, { ts '1989-05-08 00:00:00.00'}, 'I like dogs.\n', 'dd0ef324-68f9-4355-badf-ed0ae89ca153', 9);
INSERT INTO topics (id, date_created, text, token, category_id) VALUES (9, { ts '1924-12-17 00:00:00.00'}, 'I like tomatoes.\n', '18254258-bb8f-4bf9-9f63-9a6100bf2ab7', 10);
INSERT INTO topics (id, date_created, text, token, category_id) VALUES (10,{ ts '1929-01-20 00:00:00.00'}, 'I like rain.\n', '32d18247-f96b-42c4-a71f-66d0c1b40513', 3);
INSERT INTO topics (id, date_created, text, token, category_id) VALUES (11,{ ts '1927-01-06 00:00:00.00'}, 'I like the sea.\n', '8e4abe34-24ed-412d-8553-61825cc710ae', 5);

INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (1, { ts '1928-08-17 00:00:00.00' }, '3.86.150.224', 1, 94);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (2, { ts '1939-10-04 00:00:00.00' }, '91.114.43.52', 0, 2);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (3, { ts '1929-11-01 00:00:00.00' }, '8.235.215.83', 1, 3);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (4, { ts '1919-02-18 00:00:00.00' }, '204.247.198.4', 1, 3);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (5, { ts '1968-10-08 00:00:00.00' }, '177.22.209.116', 1, 38);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (6, { ts '1918-11-19 00:00:00.00' }, '184.201.179.99', 0, 6);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (7, { ts '1989-06-04 00:00:00.00' }, '44.13.207.245', 1, 71);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (8, { ts '1996-05-02 00:00:00.00' }, '188.50.88.53', 0, 10);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (9, { ts '1941-01-13 00:00:00.00' }, '19.249.148.141', 0, 32);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (10, { ts '1950-12-28 00:00:00.00'}, '160.10.168.254', 0, 15);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (11, { ts '1952-01-16 00:00:00.00'}, '146.255.159.149', 0, 29);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (12, { ts '1968-02-26 00:00:00.00'}, '39.179.145.35', 0, 44);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (13, { ts '1996-10-11 00:00:00.00'}, '141.194.235.187', 0, 86);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (14, { ts '1979-04-01 00:00:00.00'}, '193.86.106.80', 0, 58);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (15, { ts '2009-09-05 00:00:00.00'}, '207.197.133.122', 1, 61);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (16, { ts '1935-06-22 00:00:00.00'}, '15.161.248.198', 1, 37);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (17, { ts '1907-03-20 00:00:00.00'}, '191.151.249.124', 1, 83);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (18, { ts '1987-03-10 00:00:00.00'}, '220.22.41.230', 1, 64);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (19, { ts '2006-12-23 00:00:00.00'}, '197.88.191.50', 1, 84);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (20, { ts '1943-11-28 00:00:00.00'}, '64.16.51.207', 0, 94);

