# DROP TABLE If EXISTS user;
DROP TABLE IF EXISTS user;

CREATE TABLE user(userid int auto_increment primary key ,username varchar(20) not null unique );

# DELETE FROM `user`;