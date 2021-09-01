BEGIN;

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), trade_company VARCHAR(255), price int);
INSERT INTO products (title, trade_company, price) VALUES
                                            ('Avocado', 'Fruits and Co', 10),
                                            ('Banana', 'Turkey Fruits Company', 4),
                                            ('Kiwi', 'Thai plants', 7),
                                            ('Pomegranate', 'Azerbaijan export', 15),
                                            ('Orange', 'Greece foods', 3);

COMMIT;