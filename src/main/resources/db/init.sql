drop table if exists test;
drop table if exists customers;
create table test(
	id number(10) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	val VARCHAR(200)
);
create table customers(
	id number(10) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	val VARCHAR(200)
);
