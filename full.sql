BEGIN;

DROP TABLE IF EXISTS product CASCADE;
CREATE TABLE product
(
    id    bigserial PRIMARY KEY,
    title VARCHAR(255),
    cost  varchar(255),
    optlock integer
);
INSERT INTO product (title, cost, optlock)

VALUES ('IPhone', '100', 0),
       ('Macbook', '200', 0),
       ('Xiaomi Notepad 12', '300', 0);

DROP TABLE IF EXISTS customer CASCADE;
CREATE TABLE customer
(
    id    bigserial PRIMARY KEY,
    name VARCHAR(255)
);
INSERT INTO customer (name)

VALUES ('Max'),
       ('Chad'),
       ('Brian');

DROP TABLE IF EXISTS "ordering" CASCADE;
CREATE TABLE orders
(
    id    bigserial PRIMARY KEY,
    customer_id bigint,
    order_details json,
    optlock integer
);
end;
COMMIT;