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
create table check_in(
	check_in_id bigint auto_increment,
    check_in_date varchar(25),
    deposit varchar(25),
    note nvarchar(500),
    constraint check_in_pk primary key (check_in_id)
);
create table check_out(
	check_out_id bigint auto_increment,
    check_out_date varchar(25),
    note nvarchar(500),
    constraint check_out_pk primary key (check_out_id)
);
create table zone(
	zone_id bigint auto_increment,
    zone_name nvarchar(50),
    constraint zone_pk primary key (zone_id)
);
create table chamber(
	chamber_id bigint auto_increment,
    chamber_number nvarchar(10),
    chamber_type nvarchar(25),
    is_vip nvarchar(10),
    price_day varchar(25),
    chamber_area varchar(25),
    capacity varchar(10),
    note nvarchar(255),
    is_empty nvarchar(10) not null,
    zone_id bigint,
    constraint chamber_pk primary key (chamber_id),
    constraint chamber_fk foreign key (zone_id) references zone(zone_id)
);
create table furniture(
	furniture_id bigint auto_increment,
    furniture_name nvarchar(125),
    constraint furniture_pk primary key (furniture_id)
);
create table chamber_furniture(
	chamber_furniture_id bigint auto_increment,
    chamber_furniture_status nvarchar(125),
    note nvarchar(255),
    furniture_id bigint,
    chamber_id bigint,
	constraint chamber_furniture_pk primary key (chamber_furniture_id),
    constraint chamber_furniture_fk foreign key (furniture_id) references furniture(furniture_id),
    constraint chamber_furniture_fk2 foreign key (chamber_id) references chamber(chamber_id)
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
    payment_date varchar(25),
    constraint payment_pk primary key (payment_id)
);
create table rental(
	rental_id bigint auto_increment,
    total_payment varchar(25),
    discount varchar(25),
    note nvarchar(255),
    guest_id bigint,
    check_in_id bigint,
    check_out_id bigint,
    chamber_id bigint,
    payment_id bigint,
    constraint rental_pk primary key (rental_id),
    constraint rental_fk foreign key (guest_id) references guest(guest_id),
    constraint rental_fk2 foreign key (check_in_id) references check_in(check_in_id),
    constraint rental_fk3 foreign key (check_out_id) references check_out(check_out_id),
    constraint rental_fk4 foreign key (chamber_id) references chamber(chamber_id),
    constraint rental_fk5 foreign key (payment_id) references payment(payment_id)
);
create table section(
	section_id bigint auto_increment,
    section_name nvarchar(50),
    section_manager_id bigint,
    constraint section_pk primary key (section_id)
);
create table employee(
	employee_id bigint auto_increment,
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
('Nguyến Văn Nam','1998-10-02','123456789102','A01236','Hà Nội','Việt Nam','0123456789','no'),
('Yuki Mira','1998-10-02','123456789102','A01236','Hà Nội','Việt Nam','0123456789','yes'),
('Hoài Anh','1998-10-02','123456789102',null,'Hà Nội','Việt Nam','0123456789','yes'),
('Nghiêm Túc','1998-10-02','123456789102','A01236','Hà Nội','Việt Nam','0123456789','no'),
('Nguyến Văn An','1998-10-02','123456789102',null,'Hà Nội','Việt Nam','0123456789','yes'),
('Nguyến Văn An','1998-10-02','123456789102',null,'Hà Nội','Việt Nam','0123456789','yes'),
('Nguyến Văn An','1998-10-02','123456789102','A9086','Hà Nội','Việt Nam','0123456789','no'),
('Nguyến Văn Nam','1998-10-02','123456789102','A01236','Hà Nội','Việt Nam','0123456789','yes'),
('Nguyến Văn An','1998-10-02','123456789102',null,'Hà Nội','Việt Nam','0123456789','yes');
delete from guest;
select * from guest;
select * from guest where guest_name like '%no%' or birth like '%no%' or id_card like '%no%' or  passport like '%no%' or address like '%no%' or nationality like '%no%' or phone_number like '%no%'or is_vip like '%no%';


















