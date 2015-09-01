INSERT INTO user (name, password)VALUES ('demo', 'demo');
INSERT INTO user (name, password)VALUES ('test', 'test');
INSERT INTO role(NAME) VALUE ('ROLE_ADMIN')
INSERT INTO role(NAME) VALUE ('ROLE_USER')
INSERT INTO user_role(USER_ID,ROLE_ID) VALUES (1,1)
INSERT INTO user_role(USER_ID,ROLE_ID) VALUES (1,2)
INSERT INTO user_role(USER_ID,ROLE_ID) VALUES (2,1)