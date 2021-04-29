DROP TABLE IF EXISTS accountdata;
CREATE TABLE accountdata(accountdataid serial PRIMARY KEY, email VARCHAR(255), hashedpassword VARCHAR(255));