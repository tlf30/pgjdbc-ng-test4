CREATE TYPE CONDITION AS ENUM ('good', 'bad', 'unknown');

CREATE TABLE data (
    tag VARCHAR(50),
    val REAL,
    ts TIMESTAMP,
    cond CONDITION
);

INSERT INTO data VALUES('T_9945', 0.0, now(), 'unknown');