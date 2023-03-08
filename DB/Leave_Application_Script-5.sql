show databases;
create database leaveProject;
use leaveProject;


-- holidays table
create table holidays (holiday_date date primary key,holiday_day varchar(20),holiday varchar(40) );
insert into holidays values('2023-03-22',"wednesday","Ugadi");
insert into holidays values('2023-05-01',"monday","May day"),('2023-08-15',"tuesday","Independence day");
select * from holidays;


-- leave_type table
create table leave_type(leave_type_id int primary key,leave_type varchar(20) not null);
insert into leave_type values(1,'compensatory'),(2,'loss of pay'),(3,'personal time off');


-- department table
create table department(dept_id int primary key auto_increment,dept_name varchar(30) not null unique key);
insert into department values(11,'finance'),(12,'HR'),(13,'Admin'),(14,'IT Services'),(15,'Product development'),(16,'sales and marketing');
insert into department values(17,'other');
select * from department;


-- gender table
create table gender(gender_id int primary key auto_increment, gender varchar(10) not null);
insert into gender values(21,'female'),(22,'male'),(23,'other');



-- employee table
create table employee(emp_id int primary key auto_increment,first_name varchar(30) not null,last_name varchar(30) not null,gender_id int not null,dob date not null,emp_mail varchar(60),designation varchar(20) not null,dept_id int not null,joining_date date not null,password varchar(20) not null,foreign key(gender_id) references gender(gender_id),foreign key(dept_id) references department(dept_id));
insert into employee values(41,'Tony','Stark',22,'2001-03-13','stark@gmail.com','intern',15,'2023-02-13','Stark@123');
select * from employee;


select * from employee;



-- months table
create table months(month_id int primary key auto_increment,month_name varchar(20));
insert into months values(51,'January'),(52,'febuary'),(53,'March'),(54,'April'),(55,'May'),(56,'June'),(57,'July'),(58,'August'),(59,'September'),(60,'October'),(61,'November'),(62,'December');


-- leaves history
-- drop table leave_history;
-- create table leave_history(lh_id int primary key auto_increment,emp_id int,leave_count int,month_id int,unique key(emp_id,month_id),foreign key(month_id) references months(month_id),foreign key(emp_id) references employee(emp_id));



-- leaves table
create table leaves(leave_id int primary key auto_increment,emp_id int not null,leave_type_id int not null,from_date date not null,to_date date not null,comments varchar(40),month_id int not null,foreign key(emp_id)references employee(emp_id),foreign key(leave_type_id) references leave_type(leave_type_id),foreign key(month_id) references months(month_id));
insert into leaves values(71,41,2,'2023-03-07','2023-03-08',"no comments",53);

select * from leaves;

alter table holidays
add month_id int;

alter table holidays 
add foreign key (month_id) references months(month_id);


















