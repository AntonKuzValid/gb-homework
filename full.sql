BEGIN;

DROP TABLE IF EXISTS product CASCADE;

CREATE TABLE product
(
    id      bigserial PRIMARY KEY,
    title   VARCHAR(255),
    cost    decimal,
    optlock integer
);

CREATE TABLE cost_group
(
    id      bigserial PRIMARY KEY,
    costGroup integer
);



do language plpgsql
$$
    declare
        i    int default 20;
        cost decimal;
        s    varchar default 'test_item';
    begin
        INSERT INTO product (title, cost, optlock)
        VALUES ('IPhone', 100, 0),
               ('Macbook', 200, 0),
               ('Xiaomi Notepad 12', 300, 0);
        while i > 0
            loop
                cost = round((random() * 100)::numeric, 2);
                insert into product(title, cost, optlock) values (s, cost, 0);

                i = i - 1;
            end loop;
    end
$$