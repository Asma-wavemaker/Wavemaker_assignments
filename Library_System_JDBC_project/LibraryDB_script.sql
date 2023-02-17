create database LibrarySystemJDBC;
use LibrarySystemJDBC;

create table ( book_id int Primary key ,book_name varchar(30),author varchar(30),copies_available int);
insert into book_details values(154,"GAMEWORLD TRILOGY","SAMIT BASU",2);
select book_name from book_details where book_id=154;
select * from book_details;
alter table book_details
rename column copies_available to rating;