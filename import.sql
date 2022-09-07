BEGIN;
DROP TABLE IF EXISTS product CASCADE;
CREATE TABLE product (id bigserial PRIMARY KEY, title VARCHAR(255), price int);
INSERT INTO product (title, price) VALUES ('box', 10),('sphere', 20),('maul', 100),('door', 50),('camera', 500);
COMMIT;