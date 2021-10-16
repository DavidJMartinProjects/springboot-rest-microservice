-- insert cart
INSERT INTO cart (id, customer_id, total_price) VALUES (1, 1, 999.99);

-- insert product categories
INSERT INTO product_category (id, category, sku) VALUES (1, 'Electrical', 'A_00_01');
INSERT INTO product_category (id, category, sku) VALUES (2, 'Book', 'B_00_01');
INSERT INTO product_category (id, category, sku) VALUES (3, 'Lighting', 'C_00_01');

-- insert products
INSERT INTO product (id, product_category_id, name, description, price) VALUES (1, 1, 'Laptop', 'i5, 8Gb Ram, 1TB SSD', 999.99);
INSERT INTO product (id, product_category_id, name, description, price) VALUES (2, 2, 'Algorithms', 'Bhargana', 19.99);
INSERT INTO product (id, product_category_id, name, description, price) VALUES (3, 3, 'Desk Light', 'Multi-colour Desk Light', 99.99);

-- insert items
INSERT INTO item (id, product_id, quantity, cart_id) VALUES (1, 1, 3, 1);
INSERT INTO item (id, product_id, quantity, cart_id) VALUES (2, 2, 2, 1);
INSERT INTO item (id, product_id, quantity, cart_id) VALUES (3, 3, 1, 1);

