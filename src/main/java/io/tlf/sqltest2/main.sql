/**
 * Author:  Trevor
 * Created: Apr 22, 2019
 */

CREATE TYPE R AS (
    a BIGINT,
    b BIGINT,
    c VARCHAR(100),
    d INT[]
);

CREATE TYPE S AS (
    a VARCHAR(100),
    b VARCHAR(100),
    c BIGINT,
    d REAL,
    e REAL,
    f REAL,
    g R[],
    h BOOLEAN
);

CREATE TYPE II AS (
    a VARCHAR,
    b INT,
    c S[]
);

CREATE TYPE L AS (
    x REAL,
    y REAL,
    z REAL,
    i REAL,
    j REAL,
    k REAL,
    a VARCHAR(100)
);

/* --------Rendering types-------- */

CREATE TYPE MO AS (
    name VARCHAR(100),
    value REAL
);

CREATE TYPE G AS (
    a VARCHAR(100),
    b VARCHAR(100),
    c VARCHAR(100)[],
    d MO[]
);

CREATE TYPE M AS (
    a VARCHAR(512),
    b REAL,
    x REAL,
    y REAL,
    z REAL,
    i REAL,
    j REAL,
    k REAL,
    c G[]
);


CREATE TYPE QI AS (
    key VARCHAR(100),
    value INT
);

CREATE TYPE QF AS (
    key VARCHAR(100),
    value REAL
);

CREATE TYPE QS AS (
    key VARCHAR(100),
    value TEXT
);

CREATE TYPE Q AS (
    a VARCHAR(100),
    b VARCHAR(100),
    c TEXT,
    d BOOLEAN,
    e BOOLEAN,
    f BOOLEAN,
    g VARCHAR(100)[],
    h VARCHAR(100),
    i QI[],
    j QF[],
    k QS[],
    l INT
);

/* --------Character types-------- */
CREATE TYPE CHARA AS (
    a II[],
    b Q[],
    c S[],
    d L,
    e M
);

/*
 * Create user tables
 */
CREATE TABLE users (
    id SERIAL,
    a VARCHAR(100),
    b VARCHAR(100),
    data CHARA,
    PRIMARY KEY (id)
);
CREATE UNIQUE INDEX ON users (a);
ALTER TABLE users OWNER TO test2;

INSERT INTO users (a, b, data) VALUES (
    'temp1', 
    'temp2',
    ROW(
        array[]::II[],
        array[]::Q[],
        array[              
            ROW('a', 'A', 0, 1.0, 0.0, 1.0, array[ROW(0::BIGINT, 1000::BIGINT, 'n1'::VARCHAR, array[1, 0]::INT[])::R], true)::S,
            ROW('b', 'B', 0, 1.0, 0.0, 1.0, array[ROW(0::BIGINT, 1000::BIGINT, 'n2'::VARCHAR, array[1, 0]::INT[])::R], true)::S,
            ROW('c', 'C', 0, 1.0, 0.0, 1.0, array[ROW(0::BIGINT, 1000::BIGINT, 'n3'::VARCHAR, array[1, 0]::INT[])::R], true)::S
        ],  /*  S[]   */
        ROW(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 'abc'),  /*  L */
        NULL /*  M*/
    )
);
