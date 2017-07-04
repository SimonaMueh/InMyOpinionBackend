INSERT INTO categories (id, text) VALUES (1, 'world');
INSERT INTO categories (id, text) VALUES (2, 'politics');
INSERT INTO categories (id, text) VALUES (3, 'people');


INSERT INTO topics (id, date_created, text, token, category_id) VALUES (1, { ts '1950-01-26 00:00:00.00'}, 'I like  pink.', '1475eace-926a-45ee-b954-e72bfbb98ae3', 1);
INSERT INTO topics (id, date_created, text, token, category_id) VALUES (2, { ts '1945-07-31 00:00:00.00'}, 'I like chinese food.', '8df15654-21f2-42ae-85f0-d7802c8a6d4c', 2);
INSERT INTO topics (id, date_created, text, token, category_id) VALUES (3, { ts '1936-05-16 00:00:00.00'}, 'I like tattoos.', 'a2873348-029b-4a84-86f5-932aa5f80331', 3);


INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (1, { ts '2017-08-17 00:00:00.00' }, '3.86.150.224', 1, 1);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (2, { ts '2017-10-04 00:00:00.00' }, '91.114.43.52', 0, 2);
INSERT INTO votes (id, date_created, ip, selection, topic_id) VALUES (3, { ts '2017-11-01 00:00:00.00' }, '8.235.215.83', 1, 3);

