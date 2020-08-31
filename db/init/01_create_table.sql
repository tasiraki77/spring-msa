CREATE TABLE account (
    id bigserial,
    uname VARCHAR(30),
    token  VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
