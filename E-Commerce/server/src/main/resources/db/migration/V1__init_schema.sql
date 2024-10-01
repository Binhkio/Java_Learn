# INSERT INTO cart
# VALUES ();
#
# INSERT INTO user (id, email, username, password, cart_id)
# VALUES (1, 'admin@gmail.com', 'Admin', '$2a$10$r.XIN4K9vTioiuYQwaTop.UVQ5r5FvrKk2V5Orm9Hc6n4i9Tvjthy', 1);

INSERT INTO category (name)
VALUES ('Electronics'),
       ('Books'),
       ('Clothing'),
       ('Home & Garden'),
       ('Sports & Outdoors'),
       ('Health & Beauty'),
       ('Toys & Games'),
       ('Automotive'),
       ('Music'),
       ('Jewelry');

INSERT INTO product (name, brand, made_in, price, category_id)
VALUES ('Smartphone', 'Brand A', 'USA', 699.99, 1),
       ('Novel', 'Author B', 'UK', 19.99, 2),
       ('T-Shirt', 'Brand C', 'China', 9.99, 3),
       ('Garden Tools', 'Brand D', 'Germany', 49.99, 4),
       ('Basketball', 'Brand E', 'USA', 29.99, 5),
       ('Face Cream', 'Brand F', 'France', 24.99, 6),
       ('Board Game', 'Brand G', 'Canada', 34.99, 7),
       ('Car Tires', 'Brand H', 'Japan', 199.99, 8),
       ('Vinyl Record', 'Brand I', 'UK', 29.99, 9),
       ('Necklace', 'Brand J', 'Italy', 89.99, 10);
