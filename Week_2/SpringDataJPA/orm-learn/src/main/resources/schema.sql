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

CREATE TABLE department (
    dp_id INT AUTO_INCREMENT PRIMARY KEY,
    dp_name VARCHAR(50) NOT NULL
);

CREATE TABLE employee (
    em_id INT AUTO_INCREMENT PRIMARY KEY,
    em_name VARCHAR(50) NOT NULL,
    em_salary NUMERIC(10,2),
    em_permanent BOOLEAN,
    em_date_of_birth DATE,
    em_dp_id INT,
    FOREIGN KEY (em_dp_id) REFERENCES department(dp_id)
);

CREATE TABLE skill (
    sk_id INT AUTO_INCREMENT PRIMARY KEY,
    sk_name VARCHAR(50) NOT NULL
);

CREATE TABLE employee_skill (
    es_em_id INT,
    es_sk_id INT,
    PRIMARY KEY (es_em_id, es_sk_id),
    FOREIGN KEY (es_em_id) REFERENCES employee(em_id),
    FOREIGN KEY (es_sk_id) REFERENCES skill(sk_id)
);

