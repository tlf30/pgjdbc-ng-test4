CREATE TYPE CONDITION AS ENUM ('good', 'bad', 'unknown');

CREATE TYPE TEST_OBJ AS (
    cond CONDITION
);

CREATE TABLE data (
    tag VARCHAR(50),
    val REAL,
    ts TIMESTAMP,
    obj TEST_OBJ
);

INSERT INTO data VALUES('T_9945', 0.0, now(), ROW('unknown')::TEST_OBJ);
