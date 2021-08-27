BEGIN;

DROP TABLE IF EXISTS product CASCADE;
CREATE TABLE product
(
    id    bigserial PRIMARY KEY,
    title VARCHAR(255),
    cost  varchar(255),
    company varchar(255)
);
INSERT INTO product (title, cost, company)
VALUES ('one', '100', 'Apple'),
       ('two', '200', 'NLMK'),
       ('three', '300', 'Gazprom');

end;
COMMIT;