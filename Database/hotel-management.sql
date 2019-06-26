create database hotel_management;
use hotel_management;
create table app_user(
	user_id bigint auto_increment,
    username varchar(50) not null,
    encryted_password varchar(125) not null,
    enabled bit not null,
    constraint user_pk primary key (user_id),
    constraint user_uk unique (username)
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
    constraint user_role_fk1 foreign key (user_id) references user(user_id),
    constraint user_role_fk2 foreign key (role_id) references role(role_id)
);
create table persistent_login(
	series varchar(64),
    username varchar(64) not null,
    token varchar(64) not null,
    last_used timestamp not null,
    constraint persistent_login_pk primary key (series)
);
create table check_in(
	check_in_id bigint auto_increment,
    check_in_date date,
    deposit varchar(25),
    note varchar(500),
    constraint check_in_pk primary key (check_in_id)
);
create table check_out(
	check_out_id bigint auto_increment,
    check_out_date date,
    note varchar(500),
    constraint check_out_pk primary key (check_out_id)
);
create table zone(
	zone_id bigint auto_increment,
    zone_name varchar(50),
    constraint zone_pk primary key (zone_id)
);
create table chamber(
	chamber_id bigint auto_increment,
    chamber_number varchar(10),
    chamber_type varchar(25),
    is_vip boolean,
    price_day varchar(25),
    chamber_area varchar(25),
    capacity varchar(10),
    note varchar(255),
    is_empty boolean not null,
    zone_id bigint,
    constraint chamber_pk primary key (chamber_id),
    constraint chamber_fk foreign key (zone_id) references zone(zone_id)
);
create table furniture(
	furniture_id bigint auto_increment,
    furniture_name varchar(125),
    constraint furniture_pk primary key (furniture_id)
);
create table chamber_furniture(
	chamber_furniture_id bigint auto_increment,
    chamber_furniture_status varchar(125),
    note varchar(255),
    furniture_id bigint,
    chamber_id bigint,
	constraint chamber_furniture_pk primary key (chamber_furniture_id),
    constraint chamber_furniture_fk foreign key (furniture_id) references furniture(furniture_id),
    constraint chamber_furniture_fk2 foreign key (chamber_id) references chamber(chamber_id)
);
create table guest(
	guest_id bigint auto_increment,
    guest_name varchar(125),
    birth date,
    id_cart varchar(25),
    passport varchar(25),
    address varchar(125),
    nationality varchar(50),
    phone_number varchar(25),
    is_vip boolean,
    constraint guest_pk primary key (guest_id)
);
create table desk(
	desk_id bigint auto_increment,
    location varchar(25),
    is_empty boolean,
    constraint desk_pk primary key (desk_id)
);
create table food_item(
	food_item_id bigint auto_increment,
    food_item_name varchar(50),
	category varchar(50),
    food_item_description varchar(125),
    price varchar(25),
    image varchar(255),
    constraint food_item_pk primary key (food_item_id)
);
create table order_food(
	order_food_id bigint auto_increment,
    quantity int,
    total_price varchar(25),
    discount varchar(25),
    guest_id bigint,
    constraint order_food_pk primary key (order_food_id),
    constraint order_food_fk foreign key (guest_id) references guest(guest_id)
);
create table menu(
	menu_id bigint auto_increment,
    quantity int,
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
    service_name varchar(125),
    price varchar(25),
    service_description varchar(125),
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
    method varchar(50),
    payment_date date,
    constraint payment_pk primary key (payment_id)
);
create table rental(
	rental_id bigint auto_increment,
    total_payment varchar(25),
    discount varchar(25),
    note varchar(255),
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
    section_name varchar(50),
    section_manager_id bigint,
    constraint section_pk primary key (section_id)
);
create table employee(
	employee_id bigint auto_increment,
    employee_name varchar(125),
    birth date,
    gender varchar(10),
    address varchar(125),
    employee_position varchar(25),
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
    work_name varchar(125),
    content varchar(255),
    constraint work_pk primary key (work_id)
);
create table employee_work(
	employee_work_id bigint auto_increment,
    start_date date,
    quality varchar(50),
    bonus varchar(10),
    work_id bigint ,
    employee_id bigint,
    constraint employee_work_pk primary key (employee_work_id),
    constraint employee_work_fk foreign key (work_id) references work_(work_id),
    constraint employee_work_fk2 foreign key (employee_id) references employee(employee_id)
)





















