drop database if exists manage_account_bank;
create database manage_account_bank;
use manage_account_bank;
create table customers(
	customer_number int,
    full_name varchar(50),
    address varchar(255),
    email varchar(255),
    phone int,
    constraint pk_customer_number primary key (customer_number)
);

create table accounts(
	account_number int,
    account_type varchar(255),
    date_account date,
    balance int,
    customer_number int,
    foreign key(customer_number) references customers(customer_number)
);

create table transactios(
	tran_number int,
    account_number int,
    time_tran datetime,
    amount double,
    descriptions varchar(255),
	foreign key (account_number) references customers(customer_number)
    
);