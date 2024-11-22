CREATE TABLE IF NOT EXISTS users
(
    id        uuid PRIMARY KEY,
    username  VARCHAR(255) UNIQUE NOT NULL,
    password  VARCHAR(255)        NOT NULL,
    full_name VARCHAR(255)        NOT NULL,
    role      INTEGER DEFAULT 0   NOT NULL
)