CREATE TABLE country (
    co_code VARCHAR(2) PRIMARY KEY,
    co_name VARCHAR(50) NOT NULL
);

CREATE TABLE stock (
    st_id INT AUTO_INCREMENT PRIMARY KEY,
    st_code VARCHAR(10),
    st_date DATE,
    st_open NUMERIC(10,2),
    st_close NUMERIC(10,2),
    st_volume BIGINT
);
