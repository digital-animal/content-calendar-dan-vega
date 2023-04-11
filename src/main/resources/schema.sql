DROP TABLE IF EXISTS programmer;
DROP TABLE IF EXISTS language;

CREATE TABLE IF NOT EXISTS programmer (
    id SERIAL,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS language (
    id SERIAL,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO programmer (name) VALUES ('Zahidul Islam Jewel');
INSERT INTO programmer (name) VALUES ('Tonmoy Hasan Robi');
INSERT INTO programmer (name) VALUES ('Ariful Hasan Limon');

INSERT INTO language (name) VALUES ('C');
INSERT INTO language (name) VALUES ('C++');
INSERT INTO language (name) VALUES ('C#');
INSERT INTO language (name) VALUES ('Java');
INSERT INTO language (name) VALUES ('JavaScript');
INSERT INTO language (name) VALUES ('Python');
INSERT INTO language (name) VALUES ('Go');
INSERT INTO language (name) VALUES ('Rust');
INSERT INTO language (name) VALUES ('Ruby');
INSERT INTO language (name) VALUES ('R');