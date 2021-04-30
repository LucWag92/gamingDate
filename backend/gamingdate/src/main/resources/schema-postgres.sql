DROP TABLE IF EXISTS AccountData;
-- CREATE TABLE accountdata(accountdataid serial PRIMARY KEY, email VARCHAR(255), hashedpassword VARCHAR(255));
CREATE TABLE AccountData(accountDataId serial PRIMARY KEY, eMail VARCHAR(255), hashedPassword VARCHAR(255));