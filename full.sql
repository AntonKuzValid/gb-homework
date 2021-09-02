BEGIN;

DROP TABLE IF EXISTS product CASCADE;
CREATE TABLE product (id bigserial PRIMARY KEY, title VARCHAR(255), company VARCHAR(255), cost INTEGER);
INSERT INTO product (title, company, cost) VALUES
                                            ('Avocado', 'Fruits and Co', 10),
                                            ('Banana', 'Turkey Fruits Company', 4),
                                            ('Kiwi', 'Thai plants', 7),
                                            ('Pomegranate', 'Azerbaijan export', 15),
                                            ('Orange', 'Greece foods', 3);

COMMIT;