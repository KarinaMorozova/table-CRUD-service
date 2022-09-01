# table-CRUD-service

Create a program powered by Spring. You should implement data storage with interface with single public method:
String query(String queryString)
This method allows us to perform SQL-like requests. It should support next operations:
CREATE TABLE table_name (
	column1,
	column2,
	column3,
   ....
);

INSERT INTO table_name (column1, column2, column3, ...)
VALUES (value1, value2, value3, ...);

SELECT column1, column2, ...
FROM table_name;

DELETE FROM table_name WHERE condition;

This storage supports only String types.
For select method should return String in next format:
column1Row1, column2Row1, …; column1Row2, column2Row2, …

Initially the program should initialize one table ‘city’ with fields (id, name, countryCode, district, population). 
Please provide CRUD operations to this table with Rest API.
