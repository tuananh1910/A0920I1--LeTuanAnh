drop database if exists shop_car;
create database shop_car;
use shop_car;
create table customers(  -- khach hang
	customerNumber int primary key not null,
    customerName  varchar(50) not null,   -- ten cong ty khach hang
    contactLastName varchar(50) not null,			-- ten khach hang
    contactFirstName varchar (50) not null,				-- ten khach hang
    phone varchar (50) not null,
    addressLine1  varchar(50) not null,
    addressLine2  varchar(50) ,
    city varchar(50) not null,   -- thanh pho
    state varchar(50) not null,   -- bang/ vung
    postalCode varchar(15) not null,  -- ma vung
    country varchar(50) not null,
    creditLimit double , -- han muc tin dung
    
    salesRepEmployeeNumber text,
    foreign key (salesRepEmployeeNumber ) references employees(employeeNumber)
);

create table productline(  -- loai san pham
	productLine  varchar(50) not null,		-- ma loai san pham
    textDescription text
    -- image 
);

create table products(    -- san pham
	productCode   varchar(15) primary key not null ,
    productName  varchar(70) not null,
    productScale varchar(10) not null, 		-- ti le/pham vi san pham
    productVendor  varchar(50) not null,
    productDescription text not null,
    quantityInStock  int not null,
    buyPrice  double not null, 			-- gia nhap
    MSRP  double not null	,		-- gia ban le
    productLine varchar(15),
    foreign key (productLine) references productLine(productLine )
);

create table orders(
	orderNumber varchar(10) primary key unique not null,
    order_date date not null,         -- ngay dat hang
    requiredDate date not null,        -- ngay yeu cau giao hang
    shippedDate  date,             -- ngay giao hang thuc te
    status varchar(15) not null,
    comments text,
    quantityOrdered  int not null,                    -- so luong don
    priceEach double not null ,          -- don gia
    customerNumber int, 
    foreign key(customerNumber) references customer(customerNumber)
);

create table orderDetails(
	orderNumber varchar(10),
    productCode varchar(15),
    primary key (orderNumber, productCode),
    foreign key (orderNumber) references orders(orderNumber),
    foreign key (productCode) references products(productCode) 
);

create table payments(          -- thanh toan
	customerNumber  int not null, 
    checkNumber varchar(50) not null,
    paymentDate  date not null, 			-- ngay thanh toan
    amount double not null,					-- so tien
    foreign key (customerNumber) references customers(customerNumber)
);

create table employees(
	employeeNumber  int primary key not null ,
	lastName  varchar(50) not null,
    firstName  varchar(50) not null,
    email  varchar(100) unique not null ,
    jobTitle  varchar(50) not null,
    
    -- reportTo text,
    officeCode int,
    foreign key (officeCode ) references offices(officeCode)
    
);

create table offices(
	officeCode  varchar(10) not null,
    city  varchar(50) not null,
    phone  varchar(50) not null,
    addressLine1 varchar(50) not null,
    addressLine2 varchar(50),
    state varchar(50),			-- bang/vung
    country varchar (50) not null,
    postalCode varchar(15) not null		
);

