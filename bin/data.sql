INSERT INTO categories (id, text) VALUES (1, 'world');
INSERT INTO categories (id, text) VALUES (2, 'politics');
INSERT INTO categories (id, text) VALUES (3, 'people');


INSERT INTO topics (id, date_created, text, token, category_id) VALUES (1, { ts '1950-01-26 00:00:00.00'}, 'I like  pink.', '1475eace-926a-45ee-b954-e72bfbb98ae3', 1);
INSERT INTO topics (id, date_created, text, token, category_id) VALUES (2, { ts '1945-07-31 00:00:00.00'}, 'I like chinese food.', '8df15654-21f2-42ae-85f0-d7802c8a6d4c', 2);
INSERT INTO topics (id, date_created, text, token, category_id) VALUES (3, { ts '1936-05-16 00:00:00.00'}, 'I like tattoos.', 'a2873348-029b-4a84-86f5-932aa5f80331', 3);


INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (1, {ts '2017-08-17 00:00:00.00' }, '3.86.150.224', 1, 1);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (2, {ts '2017-10-04 00:00:00.00' }, '91.114.43.52', 0, 2);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (3, {ts '2017-11-01 00:00:00.00' }, '8.235.215.83', 1, 3);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (4, {ts '2017-05-17 00:00:00.00' }, '3.85.150.224', 0, 1);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (5, {ts '2017-11-04 00:00:00.00' }, '91.154.43.52', 0, 2);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (6, {ts '2017-12-01 00:00:00.00' }, '8.255.215.83', 0, 3);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (7, {ts '2017-06-12 00:00:00.00' }, '3.86.150.254', 1, 1);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (8, {ts '2017-07-04 00:00:00.00' }, '91.114.43.55', 1, 2);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (9, {ts '2017-01-01 00:00:00.00' }, '8.235.215.85', 1, 3);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (10, {ts '2017-05-03 00:00:00.00' }, '3.85.150.225', 0, 1);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (11, {ts '2017-11-03 00:00:00.00' }, '91.154.43.55', 0, 2);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (12, {ts '2017-05-01 00:00:00.00' }, '8.255.215.85', 0, 3);


