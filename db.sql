drop table Product;
drop table Customer;
drop table C_order;
drop table Publication;
drop table Publication_author;
drop table Author;
drop table Typography;
drop table Product_type;
drop table Customer_type;

create table Product_type (
    id int not null primary key auto_increment,
    product_title varchar(16)
);
insert into Product_type(product_title) values 
('Book'),
('Kniga'),
('The Book'),
('Eto Kniga'),
('Listok A3'),
('A3 Sheet');

create table Product (
    id int not null primary key auto_increment,
    type_id int,
    product_name VARCHAR(32),

    foreign key (type_id) references Product_type(id) on delete set null
);
insert into Product(id,type_id,product_name) values
(1,1,'Kak brosit Sql'),
(2,2,'Kak nachat Sql'),
(3,2,'Kak ne nachinat Sql'),
(4,3,'Kak pridumat nazvanie knigi'),
(5,6,'Obichny listok'),
(6,6,'Neobichny listok');

create table Customer_type (
    id int auto_increment primary key,
    type_name varchar(32)
);
insert into Customer_type(id, type_name) values 
(1, 'частное лицо'),
(2, 'организация');

create table Customer (
    id int auto_increment primary key,
    first_name varchar(20),
    last_name varchar(20),
    type_id int not null,
    address varchar(64),
    num varchar(15),
    fax_num varchar(10),

    foreign key (type_id) references Customer_type(id) on delete cascade
);
insert into Customer(type_id,first_name,last_name,address,num,fax_num) values
(1,'first_name1','last_name1','улица кукушкина дом колотушкина 6','88005553535','1234567890'),
(1,'first_name2','last_name2','улица ушкина дом кок-тушкина 5','88005553536','123123'),
(2,'first_name3','last_name3','улица укушкина д. кик-шкина 4','88005553537','0987654321'),
(2,'first_name4','last_name4','улица сущ13 все1234123','88005553538','5678901234'),
(2,'first_name5','last_name5','улица существ235213 все1234123','88003538','5678901234'),
(1,'first_name6','last_name6','у сущеwef13 все14123','88003538','5678901234'),
(2,'first_name7','last_name7','улица сущес35213 все1234123','880553538','5678901234'),
(2,'first_name8','last_name8','улица существует 1235213 все1234123','88005553538','56789034'),
(1,'first_name9','last_name9','улица суще35213 все1234123','88005553538','56781234'),
(1,'first_name10','last_name10','ул существует 1235213 все1234123','88005538','5678901234'),
(2,'first_name11','last_name11','ул существует 1235 все1234123','880053538','5678901234');

create table Author
(
    id int auto_increment primary key,
    first_name varchar (10),
    last_name varchar(10),
    address varchar(64)
);

insert into Author(first_name,last_name,address) values
('anton','antonov','где то живет1'),
('mihail','mihailov','где то живет2'),
('egor','egorov','где то живет3'),
('denis','denisov','где то живет4'),
('swef','author','где то живет11'),
('Bobby','Kotick','Activision Blizzard'),
('egogg','ege','где то живет33');


create table Typography(
    id int auto_increment primary key,
    typography_name varchar(16),
    address varchar(64),
    num varchar(15)
);
insert into Typography(typography_name,address,num) values 
('name 1','address 1','8888812'),
('name 2','address 2','88882812'),
('name 3','address 3','8888312'),
('name 4','address 4','88853212'),
('name 5','addr 31','88883612'),
('name 6','addr 30','8888312'),
('name 7','address 33','888833412'),
('name 8','address 32','88312312'),
('name 9','address 34','889883512'),
('типография 10','address 35','88435688312');

create table Publication (
    id int auto_increment primary key,
    product_id int,
    typography_id int,
    amount_pages int,
    circulation int,

    foreign key (product_id) references Product(id) on delete cascade,
    foreign key (typography_id) references Typography(id) on delete cascade
);
insert into Publication(product_id,amount_pages,circulation,typography_id) values
(1,100,12,1),
(2,200,4,2),
(2,300,3,3),
(3,224,2,4),
(1,32,11,1),
(2,15,5,2),
(2,23,3,1),
(3,44,1,8),
(1,55,7,3),
(2,786,4,4),
(2,66,3,3),
(3,50,2,6);

create table C_order (
    id int auto_increment primary key,
    customer_id int ,
    publication_id int,
    cost int,
    acceptance_date date,
    completion_date date,
    completed boolean,

    foreign key (customer_id) references Customer(id) on delete cascade,
    foreign key (publication_id) references Publication(id) on delete set null
);

insert into C_order(customer_id,publication_id,cost,acceptance_date,completion_date,completed) values
(1,1,10,'2021-09-01','2021-10-01',0),
(2,4,100,current_date(),'2021-10-01',0),
(3,3,11,current_date(),'2022-10-02',0),
(2,6,111,'2020-10-01','2020-10-02',1),
(4,2,320,current_date(),'2024-10-01',0),
(2,3,444,current_date(),'2025-10-01',0),
(5,8,555,'2019-10-01','2026-10-01',0),
(6,7,7000,current_date(),'2027-10-01',0),
(4,3,9123,current_date(),'2028-10-01',0),
(2,2,31,current_date(),'2029-10-01',0);



create table Publication_Author (
    id int auto_increment primary key,
    publication_id int,
    author_id int,

    foreign key (publication_id) references Publication(id) on delete cascade,
    foreign key (author_id) references Author(id) on delete cascade
);
insert into Publication_Author(publication_id,author_id) values
(1,2),
(2,3),
(3,2),
(4,1),
(5,2),
(6,3),
(7,4);