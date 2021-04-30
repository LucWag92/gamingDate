DROP TABLE IF EXISTS AccountData;
CREATE TABLE AccountData(accountDataId serial PRIMARY KEY, eMail VARCHAR(255), hashedPassword VARCHAR(255));