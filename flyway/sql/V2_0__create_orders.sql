CREATE TABLE IF NOT EXISTS orders
(
    id          uuid PRIMARY KEY,
    order_date  DATE NOT NULL,
    status      INTEGER DEFAULT 0 NOT NULL,
    customer_id INTEGER REFERENCES users ON DELETE CASCADE NOT NULL,
    total       DECIMAL(10, 2),
    planned_completion_date DATE,
    manager_id  INTEGER REFERENCES users ON DELETE CASCADE
);