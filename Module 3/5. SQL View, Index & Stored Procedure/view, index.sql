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
explain select * from products;

create unique index product_code on products(product_name, product_price);
explain select * from products;

-- drop index product_code ;
-- show index from products;
