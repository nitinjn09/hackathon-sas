CREATE TABLE tnpsdb.node(
    id BIGINT PRIMARY KEY   NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL
);


CREATE TABLE tnpsdb.physicallinkbundle(
    id BIGINT PRIMARY KEY   NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    aendnodeid VARCHAR(20) NOT NULL,
    zendnodeid VARCHAR(20) NOT NULL
);

CREATE TABLE tnpsdb.tnpsfiledata(
    id BIGINT PRIMARY KEY   NOT NULL AUTO_INCREMENT,
    filename VARCHAR(20) NOT NULL,
    data BLOB
);