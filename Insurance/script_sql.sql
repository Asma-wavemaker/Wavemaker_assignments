create database insurance;
use insurance;
show tables;


select * from insurance_status;
select * from insurance_cycle;
drop table group_insurance;
select * from relations ;
select * from gpap_insurance;
select * from group_insurance gi ;


create table insurance_cycle(cycle_id int primary key,start_yr int  not null unique, end_yr int  not null unique,insurance_provider varchar(30));
create table top_up(top_up_id int primary key, top_up_value bigint not null unique);
create table marital_status(marital_status_id int primary key,marital_status varchar(10));
create table blood_group(b_group_id int primary key, b_group_name varchar(30) not null unique);
create table insurance_status(status_id int primary key, status_val varchar(10));
create table relations(rel_id int primary key, relation_name varchar(30) unique);

alter table group_insurance 
rename column nominee_name to dependent_name;


create table gpap_insurance(gpap_id int primary key,
emp_id int,foreign key(emp_id) references employee(emp_id),
nominee_name varchar(30),dob date,
cycle_id int,foreign key(cycle_id) references insurance_cycle(cycle_id),
rel_id int,foreign key(rel_id) references relations(rel_id));

insert into gpap_insurance values(1,51,"jorge",'1977-12-12',6,2);
insert into gpap_insurance values(2,52,"sam",'1997-11-10',6,3);



create table group_insurance(gid int primary key,
emp_id int,foreign key(emp_id) references employee(emp_id),
nominee_name varchar(30),dob date,
cycle_id int,foreign key(cycle_id) references insurance_cycle(cycle_id),
rel_id int,foreign key(rel_id) references relations(rel_id),
top_up_id int,foreign key(top_up_id) references top_up(top_up_id));

insert into group_insurance values(1,51,"jorge",'1977-12-12',6,2,1);
insert into group_insurance values(2,52,"sam",'1997-11-10',6,3,2);

create table employee(emp_id int primary key,
emp_name varchar(30),
b_group_id int, foreign key(b_group_id) references blood_group(b_group_id),
address varchar(40),description varchar(40),
marital_status int, foreign key(marital_status) references marital_status(marital_status_id),
status_id int, foreign key(status_id) references insurance_status(status_id),
cycle_id int, foreign key(cycle_id) references insurance_cycle(cycle_id));

insert into employee values(51,"John",1,"hyderabad","opted for Insurance policy",1,1,6);
insert into employee values(52,"watson",1,"new york","opted for Insurance policy",2,1,6);
insert into employee values(53,"sherlock",1,"seattle","yet to opt for Insurance policy",1,3,6);
insert into employee values(55,"sam",4,"washington","opted for Insurance policy",2,1,6);
insert into employee values(57,"emiley",3,"london","opted out for Insurance policy",2,2,6);




insert into insurance_status values(1 , "opt-in"),(2,"opt-out"),(3,"pending");

select * from insurance_cycle;

insert into blood_group values(1,"A+"),(2,"B+"),(3,"O+"),(4,"AB+"),(5,"A-"),(6,"B-"),(7,"O-"),(8,"AB-");

insert into marital_status values(0,"unmarried"),(1,"married"),(2,"divorced");

insert into top_up values(0,0),(1,50000),(2,75000),(3,100000),(4,125000),(5,150000);

insert into insurance_cycle values(1,2017,2018,"abc-bank"),(2,2018,2019,"rty-bank"),(3,2019,2020,"eod-bank"),(4,2020,2021,"eom-bank"),(5,2021,2022,"qopp-bank"),(6,2022,2023,"pppa-bank");

insert into relations values(1,"mother"),(2,"father"),(3,"daughter"),(4,"son"),(5,"mother-in-law"),(6,"father-in-law");



select * from gpap_insurance gi where gi.emp_id =51;

