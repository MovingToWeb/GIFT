DROP TABLE IF EXISTS USER_DETAILS;

CREATE TABLE USER_DETAILS
(
USERNAME VARCHAR(20),
USER_ID VARCHAR(20),
ADDRESS VARCHAR(20),
COUNTRY VARCHAR(20))
;

GRANT ALL ON USER_DETAILS TO sa;