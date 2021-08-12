create database 'C:\data\test.fdb' page_size 8192
user 'sysdba' password '...';

------------------------------------

connect 'C:\data\test.fdb'
user 'sysdba' password '...';

------------------------------------

create table owner (name varchar(100), feetsize int, shoe varchar(100));

create table shoe (brand varchar(100), size int, issold int);

insert into owner values ('Peter', 45, null);
insert into shoe values ('Armani', 42, 0);