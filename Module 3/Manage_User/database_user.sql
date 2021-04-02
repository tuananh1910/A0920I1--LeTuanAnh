drop database if exists user_database;
create database user_database;
use user_database;

create table users(
	id int(3) not null auto_increment,
      name varchar(120)	not null,
      email varchar(220) not null,
      country varchar(120),
      primary key(id)
);

insert into users(name, email, country) values('Anh','anh@gmail.com','Viet Nam');
insert into users(name, email, country) values('ha','ha@gmail.com','Viet nam');

