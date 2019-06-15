
INSERT INTO user (password, username) VALUES ('$2a$10$y.9Bnm2HX2XBI4grbjjBZesi5ntrw2ICT4g5Ad3YjqKHoQhi5AZPq', 'user');
INSERT INTO user (password, username) VALUES ('$2a$10$y.9Bnm2HX2XBI4grbjjBZesi5ntrw2ICT4g5Ad3YjqKHoQhi5AZPq', 'user2');

INSERT INTO todo (content, user_id, created_date, updated_date) VALUES ('My inserted todo', 1, NOW(), NOW());
INSERT INTO todo (content, user_id, created_date, updated_date) VALUES ('My inserted todo 2', 1, NOW(), NOW());
INSERT INTO todo (content, user_id, created_date, updated_date) VALUES ('My inserted todo 3', 1, NOW(), NOW());