CREATE TABLE IF NOT EXISTS brands (brand_id INT PRIMARY KEY);

INSERT INTO brands (brand_id) VALUES (1);

CREATE TABLE IF NOT EXISTS prices (price_id INT AUTO_INCREMENT PRIMARY KEY,brand_id INT NOT NULL,start_date TIMESTAMP NOT NULL,end_date TIMESTAMP NOT NULL,price FLOAT NOT NULL,product_id INT NOT NULL,price_list INT NOT NULL,priority INT NOT NULL,curr VARCHAR(3));

ALTER TABLE prices ADD FOREIGN KEY (brand_id) REFERENCES brands(brand_id);

INSERT INTO prices (brand_id, start_date, end_date, price_list, product_id, priority, price, curr) VALUES (1, '2020-06-14 00:00:00.000000', '2020-12-31 23:59:59.000000', 1, 35455, 0, 35.50, 'EUR');
INSERT INTO prices (brand_id, start_date, end_date, price_list, product_id, priority, price, curr) VALUES (1, '2020-06-14 15:00:00.000000', '2020-06-14 18:30:00.000000', 2, 35455, 1, 25.45, 'EUR');
INSERT INTO prices (brand_id, start_date, end_date, price_list, product_id, priority, price, curr) VALUES (1, '2020-06-15 00:00:00.000000', '2020-06-15 11:00:00.000000', 3, 35455, 1, 30.50, 'EUR');
INSERT INTO prices (brand_id, start_date, end_date, price_list, product_id, priority, price, curr) VALUES (1, '2020-06-15 16:00:00.000000', '2020-12-31 23:59:59.000000', 4, 35455, 1, 38.95, 'EUR');