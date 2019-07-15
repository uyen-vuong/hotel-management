create database hotel_management;
use hotel_management;
create table app_user(
	user_id bigint auto_increment,
    user_name varchar(50) not null,
    encryted_password varchar(125) not null,
    enabled bit not null,
    constraint user_pk primary key (user_id),
    constraint user_uk unique (user_name)
);
create table app_role(
	role_id bigint auto_increment,
    role_name varchar(50) not null,
    constraint role_pk primary key (role_id),
    constraint role_uk unique (role_name)
);
create table user_role(
	id bigint auto_increment,
    user_id bigint,
    role_id bigint,
    constraint user_role_pk primary key (id),
    constraint user_role_fk1 foreign key (user_id) references app_user(user_id),
    constraint user_role_fk2 foreign key (role_id) references app_role(role_id)
);
create table persistent_login(
	series varchar(64),
    user_name varchar(64) not null,
    token varchar(64) not null,
    last_used timestamp not null,
    constraint persistent_login_pk primary key (series)
);
create table chamber(
	chamber_id bigint auto_increment,
    chamber_number nvarchar(10),
    chamber_type nvarchar(25),
    is_vip nvarchar(10),
    price_day varchar(25),
    chamber_area varchar(25),
    note nvarchar(255),
    is_empty nvarchar(10) not null,
    constraint chamber_pk primary key (chamber_id)
);
create table guest(
	guest_id bigint auto_increment,
    guest_name nvarchar(125),
    birth nvarchar(25), 
    id_card varchar(25),
    passport varchar(25),
    address nvarchar(125),
    nationality nvarchar(50),
    phone_number varchar(25),
    email varchar(59),-- add new
    is_vip nvarchar(10),
    constraint guest_pk primary key (guest_id)
);
create table desk(
	desk_id bigint auto_increment,
    location nvarchar(25),
    is_empty nvarchar(10),
    constraint desk_pk primary key (desk_id)
);
create table food_item(
	food_item_id bigint auto_increment,
    food_item_name nvarchar(50),
	category nvarchar(50),
    food_item_description nvarchar(125),
    price varchar(25),
    image varchar(255),
    constraint food_item_pk primary key (food_item_id)
);
create table order_food(
	order_food_id bigint auto_increment,
    quantity varchar(10),
    total_price varchar(25),
    order_date nvarchar(30),
    discount varchar(25),
    guest_id bigint,
    constraint order_food_pk primary key (order_food_id),
    constraint order_food_fk foreign key (guest_id) references guest(guest_id)
);
create table menu(
	menu_id bigint auto_increment,
    quantity varchar(10),
    order_food_id bigint,
    food_item_id bigint,
    constraint menu_pk primary key (menu_id),
    constraint menu_fk foreign key (order_food_id) references order_food(order_food_id),
    constraint menu_fk2 foreign key (food_item_id) references food_item(food_item_id)
);
create table order_food_desk(
	order_food_desk_id bigint auto_increment,
    order_food_id bigint,
    desk_id bigint,
    constraint order_food_desk_pk primary key (order_food_desk_id),
    constraint order_food_desk_fk1 foreign key (order_food_id) references order_food(order_food_id),
    constraint order_food_desk_fk2 foreign key (desk_id) references desk(desk_id)
);
create table service(
	service_id bigint auto_increment,
    service_name nvarchar(125),
    price varchar(25),
    service_description nvarchar(125),
    discount varbinary(25),
    constraint service_pk primary key (service_id)
);
create table guest_service(
	guest_service_id bigint auto_increment,
    service_id bigint,
    guest_id bigint,
    constraint guest_service_pk primary key (guest_service_id),
    constraint guest_service_fk foreign key (service_id)  references service(service_id),
    constraint guest_service_fk2 foreign key (guest_id)  references guest(guest_id)
);
create table payment(
	payment_id bigint auto_increment,
    method nvarchar(50),
    -- payment_date varchar(25), -- nen bo
    constraint payment_pk primary key (payment_id)
);
create table rental(
	rental_id bigint auto_increment,
    discount varchar(25),
    check_in_date varchar(25),
	check_out_date varchar(25),
    note nvarchar(255),
    paid varchar(25),
    guest_id bigint,
    chamber_id bigint,
    payment_id bigint,
    constraint rental_pk primary key (rental_id),
    constraint rental_fk foreign key (guest_id) references guest(guest_id),
    constraint rental_fk1 foreign key (chamber_id) references chamber(chamber_id),
    constraint rental_fk2 foreign key (payment_id) references payment(payment_id)
);
create table section(
	section_id bigint auto_increment,
    section_name nvarchar(50),
    section_manager_id bigint,
    constraint section_pk primary key (section_id)
);
create table employee(
	employee_id bigint auto_increment,
    employee_number varchar(25),
    employee_name varchar(125),
    birth varchar(25),
    gender nvarchar(10),
    address nvarchar(125),
    employee_position nvarchar(25),
    email varchar(50),
    phone_number varchar(25),
    salary varchar(25),
    manager_id bigint,
    section_id bigint,
    constraint employee_pk primary key (employee_id),
    constraint employee_fk foreign key (section_id) references section(section_id)
);
create table work_(
	work_id bigint auto_increment,
    work_name nvarchar(125),
    content nvarchar(255),
    constraint work_pk primary key (work_id)
);
create table employee_work(
	employee_work_id bigint auto_increment,
    start_date varchar(25),
    quality varchar(50),
    bonus varchar(10),
    work_id bigint,
    employee_id bigint,
    constraint employee_work_pk primary key (employee_work_id),
    constraint employee_work_fk foreign key (work_id) references work_(work_id),
    constraint employee_work_fk2 foreign key (employee_id) references employee(employee_id)
);
insert into App_User (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED) values (2, 'user', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
insert into App_User (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED) values (3, 'admin', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
insert into hotel_management.guest(guest_name,birth,id_card,passport,address,nationality,phone_number,is_vip) values
('Nguyến Văn An','1998-10-02','123456789102',null,'Hà Nội','Việt Nam','0123456789','yes'),
('Nguyến Văn Nam','1998-10-02','123456789102','A01236','Viet Nam dsdad','Việt Nam','0123456789','no'),
('Yuki Mira','1998-10-02','123456789102','A01236','Hà Nội','Việt Nam','0123456789','yes'),
('Hoài Anh','1998-10-02','123456789102',null,'Hà Nội','Việt Nam','0123456789','yes'),
('Nghiêm Túc','1998-10-02','123456789102','A01236','Hà Nội','Việt Nam','0123456789','no'),
('Nguyến Văn An','1998-10-02','123456789102',null,'Hà Nội','Việt Nam','0123456789','yes'),
('Nguyến Văn An','1998-10-02','123456789102',null,'Hà Nội','Việt Nam','0123456789','yes'),
('Nguyến Văn An','1998-10-02','123456789102','A9086','Hà Nội','Việt Nam','0123456789','no'),
('Nguyến Văn Nam','1998-10-02','123456789102','A01236','Hà Nội','Việt Nam','0123456789','yes'),
('Nguyến Văn An','1998-10-02','123456789102',null,'Hà Nội','Việt Nam','0123456789','yes');

select count(*) from guest where guest.id_card = '123456789102' or guest.phone_number = '0123456789' or guest.passport = 'A9086';

delete from rental;
delete from guest;
delete from chamber;
insert into hotel_management.chamber(chamber_number,chamber_type,is_vip,price_day,chamber_area,note,is_empty) values 
('101','single','true','1700000','70','Phòng này là phòng vip','true'),
('102','couple','false','1500000','65.5','Phòng đôi thường','true'),
('103','family','true','1700000','70','','true'),
('104','couple','true','1700000','70','','true'),
('105','single','true','5000000','70','Phòng này là phòng vip','true'),
('106','couple','false','1700000','70','Phòng này là phòng vip','true'),
('107','couple','true','3500000','70','Phòng này là phòng vip','true'),
('108','couple','true','1700000','45.6','Phòng này là phòng vip','true'),
('109','single','true','5500000','70','Phòng này là phòng vip','true'),
('110','family','true','1700000','70','Phòng này là phòng vip','true'),
('111','single','false','700000','70','Phòng này là phòng vip','true'),
('112','couple','true','1700000','70','','true'),
('113','couple','false','1700000','50.6','Phòng này là phòng vip','true'),
('114','family','true','5500000','70','Phòng này là phòng vip','true'),
('115','single','true','1700000','70','Phòng này là phòng vip','true'),
('116','Couple','true','10000000','70.56','Phòng này là phòng vip','true');
insert into rental(rental.guest_id)value(11);

select * from guest;
select * from rental;
select * from chamber;
select * from hotel_management.persistent_login;
select * from guest where guest_name like '%no%' or birth like '%no%' or id_card like '%no%' or  passport like '%no%' or address like '%no%' or nationality like '%no%' or phone_number like '%no%'or is_vip like '%no%';

select * from hotel_management.check_in;
select * from hotel_management.chamber where cast(price_day as unsigned) < 1000000 and chamber_type = 'single' and is_vip = 'false' and is_empty = 'false';
select * from hotel_management.chamber where cast(price_day as unsigned) between 1000000 and 3000000 and chamber_type = 'couple' and is_vip = 'false' and is_empty = 'true';
select * from hotel_management.chamber where cast(price_day as unsigned) > 3000000 and chamber_type = 'couple' and is_vip = 'true' and is_empty = 'true';

select * from hotel_management.guest where  guest.passport = 'A01236' or guest.id_card = ''  or guest.phone_number = ''

















