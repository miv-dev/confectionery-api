CREATE TABLE IF NOT EXISTS topping_types
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);


CREATE TABLE IF NOT EXISTS toppings
(
    id                SERIAL PRIMARY KEY,
    article           VARCHAR(255) NOT NULL,
    type_id           INTEGER REFERENCES topping_types ON DELETE CASCADE,
    name              VARCHAR(255) NOT NULL,
    quantity          INTEGER,
    unit              VARCHAR(255),
    purchase_price    DECIMAL(10, 2),
    supplier_id       INTEGER REFERENCES suppliers ON DELETE CASCADE,
    delivery_duration INTEGER,
    shelf_life  DATE
);
