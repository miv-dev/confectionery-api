CREATE TABLE IF NOT EXISTS suppliers
(
    id            SERIAL PRIMARY KEY,
    name          VARCHAR(255) UNIQUE NOT NULL,
    address       TEXT,
    delivery_time INTEGER
);

CREATE TABLE IF NOT EXISTS tool_types
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);


CREATE TABLE IF NOT EXISTS tools
(
    id            SERIAL PRIMARY KEY,
    name          VARCHAR(255) UNIQUE NOT NULL,
    description   TEXT,
    supplier_id   INTEGER REFERENCES suppliers ON DELETE CASCADE,
    wear          INTEGER DEFAULT 0,
    type_id       INTEGER REFERENCES tool_types ON DELETE CASCADE,
    purchase_date DATE,
    quantity      INTEGER DEFAULT 0
);