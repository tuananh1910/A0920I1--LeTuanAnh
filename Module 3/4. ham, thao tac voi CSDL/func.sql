drop database if exists func;
create database func;
use func;
create table persons(
	id int primary key,
    full_name varchar(20),
    age int,
    course varchar(20),
    amount int
);

select sum(amount) from persons;

select * from persons where full_name='anh';

select t1.id, t1.full_name, t1.age, t1.course, t1.amount, t2.id, t2.full_name, t2.age, t2.course, t2.amount  -- self join
from persons t1, persons t2				-- from name_table1 right join name_table2   ON name_table1.field = name_table2.field; 
where t1.full_name = 'anh';

select * from persons
group by full_name;   -- group by nhom lai danh sach ten trong persons khong trung lap