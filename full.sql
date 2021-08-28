BEGIN;

DROP TABLE IF EXISTS product CASCADE;
CREATE TABLE product
(
    id    bigserial PRIMARY KEY,
    title VARCHAR(255),
    cost  varchar(255),
    company varchar(255),
    optlock integer
);
INSERT INTO product (title, cost, company, optlock)
VALUES ('one', '100', 'Apple',0),
       ('two', '200', 'NLMK',0),
       ('three', '300', 'Gazprom',0);

end;
COMMIT;