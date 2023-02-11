show databases;
use db1;
show tables;

select * from emp_add;
select * from dept;
select * from employee;

create table emp_add(address varchar(30),add_id int);
insert into emp_add values("hyderabad", 13) ,("vizag",11),("mumbai",19),("haryana",39);

-- Inner join 
select e.name,e.emp_id,e.salary,
d.dept_id,d.dept_name
FROM employee as e
join dept as d
ON e.dept_id = d.dept_id;


-- left join
select e.name,e.emp_id,e.salary,
d.dept_id,d.dept_name
from employee as e
left join dept as d
ON e.dept_id = d.dept_id;

-- right join

select e.name,e.emp_id,e.salary,
a.address,a.add_id
from employee as e
right join emp_add as a
ON e.add_id = a.add_id;


-- add address in employee table
alter table employee
add add_id int;


UPDATE employee
SET add_id = 19
WHERE emp_id = 26;


