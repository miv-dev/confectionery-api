CREATE TABLE IF NOT EXISTS products
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description TEXT,
    width       DECIMAL(10, 2),
    height      DECIMAL(10, 2)
);

CREATE TABLE IF NOT EXISTS orders
(
    id          uuid PRIMARY KEY,
    order_date  DATE NOT NULL,
    status      INTEGER DEFAULT 0 NOT NULL,
    customer_id uuid REFERENCES users ON DELETE CASCADE NOT NULL,
    total       DECIMAL(10, 2),
    planned_completion_date DATE,
    manager_id  uuid REFERENCES users ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS order_references(
    id          SERIAL PRIMARY KEY,
    order_id    uuid REFERENCES orders ON DELETE CASCADE NOT NULL,
    url         VARCHAR(255) NOT NULL
);