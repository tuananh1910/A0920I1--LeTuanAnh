drop database if exists view_index_store_procedure;
create database view_index_store_procedure;
use view_index_store_procedure;
create table products(
	id int primary key,
    product_code int,
    product_name varchar(20),
    product_price int ,
    product_amount int,
    product_description varchar(20),
    product_status varchar(20)
);
INSERT INTO products
 VALUES ('1', '28', 'nike', '200', '300', 'zxc', 'zxc');
INSERT INTO products
VALUES ('2', '29', 'converse', '400', '500', 'zxc', 'zxc');
-- explain select * from products;

-- create unique index product_code on products(product_name, product_price);
-- explain select * from products;

create view product_view as
select product_code, product_name, product_price, product_status
from products;
-- where product_name ='nike';

update product_view
set product_status = 'nike'
where product_name = 'nike';

select * from product_view;

drop view product_view;

-- delete from product_view
-- drop index product_code ;
-- show index from products;
