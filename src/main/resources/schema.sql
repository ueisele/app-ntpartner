CREATE TABLE IF NOT EXISTS Partner (
  id        INT(11)     NOT NULL AUTO_INCREMENT,
  firstname VARCHAR(80) NOT NULL,
  lastname  VARCHAR(80) NOT NULL,
  street   VARCHAR(80) NOT NULL,
  streetNo VARCHAR(40) NOT NULL,
  zipCode  VARCHAR(40) NOT NULL,
  city     VARCHAR(80) NOT NULL,
  PRIMARY KEY (id)
);