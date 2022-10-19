INSERT INTO users (username,password,enabled)
VALUES
('user','password',true),
('admin','password',true);


INSERT INTO authorities (username,authority)
VALUES
('user','ROLE_USER'),
('admin','ROLE_ADMIN');