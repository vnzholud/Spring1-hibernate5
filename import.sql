BEGIN;
DROP TABLE IF EXISTS product CASCADE;
CREATE TABLE product (id bigserial PRIMARY KEY, title VARCHAR(255), price int);
INSERT INTO product (title, price) VALUES ('box', 10),('sphere', 20),('maul', 100),('door', 50),('camera', 500);

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (id bigserial PRIMARY KEY, username VARCHAR(255));
INSERT INTO users (username) VALUES ('Vasya'),('Petya'),('Dima');
COMMIT;