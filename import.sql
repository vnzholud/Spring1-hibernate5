BEGIN;
DROP TABLE IF EXISTS product CASCADE;
CREATE TABLE product (id bigserial PRIMARY KEY, title VARCHAR(255), price int);
INSERT INTO product (title, price) VALUES ('box', 10),('sphere', 20),('maul', 100),('door', 50),('camera', 500);

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (id bigserial PRIMARY KEY, username VARCHAR(255));
INSERT INTO users (username) VALUES ('Vasya'),('Petya'),('Dima');
COMMIT;

DROP TABLE IF EXISTS users_product CASCADE;
CREATE TABLE users_product (user_id bigint, product_id bigint, FOREIGN KEY (user_id) REFERENCES users (id), FOREIGN KEY (product_id) REFERENCES product (id));
INSERT INTO users_product (user_id, product_id) VALUES (1, 1),(2, 1),(3, 1),(1, 4),(2, 4), (2, 5), (3, 5),(1, 2);