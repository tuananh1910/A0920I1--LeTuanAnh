drop database if exists case_study_JSPS_ervlet;
create database case_study_JSPS_ervlet;
use case_study_JSPS_ervlet;

create table employee(
	employee_id int auto_increment,
    employee_name  varchar(45),
    employee_birthday date,
    employee_id_card  varchar(45),
    employee_salary double,
    employee_phone varchar(45),
    employee_email varchar(45),
    employee_address varchar(45),
    position_id int,
    education_degree_id int,
    division_id int,
    username varchar(45),
    PRIMARY KEY (employee_id)
);

create table customer(
	customer_id varchar(50) primary key ,
    customer_type_id int,
    customer_name varchar(45),
    customer_birthday date,
    customer_gender varchar(10),
    customer_id_card varchar(45),
    customer_phone varchar(45),
    customer_email varchar(45),
    customer_address varchar(45)
);

create table positions(
	position_id int primary key auto_increment,
    position_name varchar(45)
);

create table education_degree(
	education_degree_id int primary key auto_increment,
    education_degree_name varchar(45)
);

create table division(
	division_id int primary key auto_increment,
    division_name varchar(45)
);

create table customer_type(
	customer_type_id int primary key auto_increment,
    customer_type_name varchar(45)
);

create table user(
	username varchar(255) primary key,
    password varchar(255)
);

create table role(
	role_id int primary key auto_increment,
    role_name varchar(45)
);

create table user_role(
	role_id int ,
    username varchar(255)
    );

create table contract(
	contract_id int primary key auto_increment,
    contract_start_date datetime,
    contract_end_date datetime,
    contract_deposit double,
    contract_total_money double,
    employee_id int,
    customer_id varchar(50),
    service_id varchar(50)
);

create table service(
	service_id varchar(50) primary key ,
    service_name varchar(45),
    service_area int,
    service_cost double,
    service_max_people int,
    rent_type_id int,
    service_type_id int,
    standard_room varchar(45),
    description_orther_convenience varchar(45),
    pool_area double,
    number_of_floor int
);

create table service_type(
	service_type_id int primary key auto_increment,
    service_type_name varchar(45)
);

create table rent_type(
	rent_type_id int primary key auto_increment,
    rent_type_name varchar(45),
    rent_type_cost double
);

create table contract_details(
	contract_details_id int primary key auto_increment,
    contract_id int,
    attach_service_id int,
    quality int
);

create table attach_service(
	attach_service_id int primary key auto_increment,
    attach_service_name varchar(45),
    attach_service_cost double,
    attach_service_unit int,
    attach_service_status varchar(45)
);

ALTER TABLE employee
ADD CONSTRAINT FK_position_id_employee
FOREIGN KEY (position_id) REFERENCES positions(position_id),
ADD CONSTRAINT FK_education_degree_id_employee
FOREIGN KEY (education_degree_id) REFERENCES education_degree(education_degree_id),
ADD CONSTRAINT FK_division_id_employee
FOREIGN KEY (division_id) REFERENCES division(division_id),
ADD CONSTRAINT FK_username_employee
FOREIGN KEY (username) REFERENCES user(username);


ALTER TABLE customer
ADD CONSTRAINT FK_customer_type_id_customer
FOREIGN KEY (customer_type_id) REFERENCES customer_type(customer_type_id);

ALTER TABLE user_role
ADD CONSTRAINT FK_role_id_user_role
FOREIGN KEY (role_id) REFERENCES role(role_id),
ADD CONSTRAINT FK_username_user_role
FOREIGN KEY (username) REFERENCES user(username);

ALTER TABLE contract
ADD CONSTRAINT FK_employee_id_contract
FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
ADD CONSTRAINT FK_customer_id_contract
FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
ADD CONSTRAINT FK_service_id_contract
FOREIGN KEY (service_id) REFERENCES service(service_id);

ALTER TABLE service
ADD CONSTRAINT FK_rent_type_id_service
FOREIGN KEY (rent_type_id) REFERENCES rent_type(rent_type_id),
ADD CONSTRAINT FK_service_type_id_service
FOREIGN KEY (service_type_id) REFERENCES service_type(service_type_id);

ALTER TABLE contract_details
ADD CONSTRAINT FK_contract_id_details
FOREIGN KEY (contract_id) REFERENCES contract(contract_id),
ADD CONSTRAINT FK_attach_service_id_details
FOREIGN KEY (attach_service_id) REFERENCES attach_service(attach_service_id);

INSERT INTO positions VALUES (1, 'Le Tan');
INSERT INTO positions VALUES ('2', 'Phuc vu');
INSERT INTO positions VALUES ('3', 'Chuyen Vien');
INSERT INTO positions VALUES ('4', 'Giam sat');
INSERT INTO positions VALUES ('5', 'Quan li');
INSERT INTO positions VALUES ('6', 'Giam doc');

INSERT INTO education_degree VALUES ('1', 'Trung Cap');
INSERT INTO education_degree VALUES ('2', 'Cao Dang');
INSERT INTO education_degree VALUES ('3', 'Dai Hoc');
INSERT INTO education_degree VALUES ('4', 'Sau Dai Hoc');

INSERT INTO division VALUES ('1', 'Sale-Marketing');
INSERT INTO division VALUES ('2', 'Hanh chinh');
INSERT INTO division VALUES ('3', 'Phuc vu');
INSERT INTO division VALUES ('4', 'Quan li');

INSERT INTO role VALUES ('1', 'role A');
INSERT INTO role VALUES ('2', 'role B');
INSERT INTO role VALUES ('3', 'role C');
INSERT INTO role VALUES ('4', 'role  D');

INSERT INTO user VALUES ('Anh', '123');
INSERT INTO user VALUES ('Ha', '123');
INSERT INTO user VALUES ('Quan', '123');
INSERT INTO user VALUES ('Mai', '123');
INSERT INTO user VALUES ('Tri', '123');
INSERT INTO user VALUES ('Hue', '123');

INSERT INTO rent_type VALUES ('1', 'Home', '100');
INSERT INTO rent_type VALUES ('2', 'House', '200');
INSERT INTO rent_type VALUES ('3', 'Villa', '300');

INSERT INTO service_type VALUES ('1', 'Normal');
INSERT INTO service_type VALUES ('2', 'Hight');
INSERT INTO service_type VALUES ('3', 'Royal');

INSERT INTO customer_type VALUES ('1', 'Member');
INSERT INTO customer_type VALUES ('2', 'Silver');
INSERT INTO customer_type VALUES ('3', 'Gold');
INSERT INTO customer_type VALUES ('4', 'Platium');
INSERT INTO customer_type VALUES ('5', 'Diamond');

INSERT INTO employee  VALUES ('1', 'Anh', '2000-10-19', '123', '200', '0123456789', 'anh@gmail.com', 'Quang Tri', '1', '1', '1', 'Anh');
INSERT INTO employee  VALUES ('2', 'Ha', '2000-10-19', '124', '300', '0123456788', 'ha@gmail.com', 'HCM', '2', '2', '2', 'Ha');
INSERT INTO employee  VALUES ('3', 'Quan', '2000-10-19', '125', '400', '0123456655', 'quan@gmail.com', 'Da Nang', '3', '3', '3', 'Quan');
INSERT INTO employee  VALUES ('4', 'Mai','2000-10-19', '126', '500', '0231321023', 'mai@gmail.com', 'Hue', '4', '4', '4', 'Mai');
INSERT INTO employee  VALUES ('5', 'Tri', '2000-10-19', '125', '400', '0123456655', 'quan@gmail.com', 'Da Nang', '5', '3', '3', 'Tri');
INSERT INTO employee  VALUES ('6', 'Hue','2000-10-19', '126', '500', '0231321023', 'mai@gmail.com', 'Hue', '6', '4', '4', 'Hue');

INSERT INTO customer VALUES ('KH-0001', '1', 'Hung', '2000-10-19', 0, '1', '123151321', 'hung@gmail.com', 'Da Nang');
INSERT INTO customer VALUES ('KH-0002', '2', 'Huyen', '2000-10-19', 1, '2', '123112311', 'huyen@gmail.com', 'Hue');
INSERT INTO customer  VALUES ('KH-0003', '3', 'Hai','2000-10-19', 0, '3', '156188899', 'hai@gmail.com', 'Quang Nam');
INSERT INTO customer VALUES ('KH-0004', '4', 'Linh', '2000-10-19', 1, '4', '641563123', 'linh@gmail.com', 'Quang Tri');




INSERT INTO service(service_id, service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id) 
VALUES ('DV-00001', 'Room', '1000', '1000', '10', '1', '1');
INSERT INTO service (service_id, service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id, standard_room, description_orther_convenience, number_of_floor)
VALUES ('DV-00002', 'House', '2000', '2000', '20', '2', '2', 'House', 'close to nature', '2');
INSERT INTO service 
VALUES ('DV-00003', 'Villa', '3000', '3000', '30', '3', '3', 'Villa', 'close to nature', '50', '3');

INSERT INTO contract VALUES ('1', '2021-10-10', '2021-10-15', '100', '1000', '1', 'KH-0001', 'DV-00001');
INSERT INTO contract VALUES ('2',' 2021-10-10', '2021-10-15', '200', '2000', '2', 'KH-0002', 'DV-00002');
INSERT INTO contract VALUES ('3',' 2021-10-10',' 2021-10-15', '300', '3000', '3', 'KH-0003', 'DV-00003');
INSERT INTO contract VALUES ('4', '2021-10-10', '2021-10-15', '400', '4000', '4', 'KH-0004', 'DV-00003');

INSERT INTO user_role VALUES ('1', 'Anh');
INSERT INTO user_role VALUES ('2', 'Ha');
INSERT INTO user_role VALUES ('3', 'Quan');
INSERT INTO user_role VALUES ('4', 'Mai');
INSERT INTO user_role VALUES ('2', 'Tri');
INSERT INTO user_role VALUES ('2', 'Hue');

INSERT INTO attach_service VALUES ('1', 'massage', '100', '10', 'on');
INSERT INTO attach_service VALUES ('2', 'karaoke', '200', '20', 'on');
INSERT INTO attach_service VALUES ('3', 'food,drink', '300', '30', 'on');
INSERT INTO attach_service VALUES ('4', 'rent vehicle', '400', '40', 'on');


INSERT INTO contract_details VALUES ('1', '1', '1', '2');
INSERT INTO contract_details VALUES ('2', '2', '2', '3');
INSERT INTO contract_details VALUES ('3', '3', '3', '4');
INSERT INTO contract_details VALUES ('4', '4', '4', '5');








    


    
