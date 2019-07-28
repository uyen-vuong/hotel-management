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
    chamber_number nvarchar(10) unique,
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
    is_familiar varchar(10),-- add new
    is_vip nvarchar(10),
    constraint guest_pk primary key (guest_id)
);
create table payment(
	payment_id bigint auto_increment,
    method nvarchar(50),
    constraint payment_pk primary key (payment_id)
);
create table rental(
	rental_id bigint auto_increment,
    discount varchar(25),
    check_in_date date,
	check_out_date date,
    note nvarchar(255),
    paid varchar(25),
    guest_id bigint,
    payment_id bigint,
    constraint rental_pk primary key (rental_id),
    constraint rental_fk foreign key (guest_id) references guest(guest_id),
    constraint rental_fk2 foreign key (payment_id) references payment(payment_id)
);
select *  from rental;
select datediff('2019-07-25',check_in_date) from rental;
create table rental_chamber(
	rental_chamber_id bigint auto_increment,
    rental_id bigint,
    chamber_id bigint,
    constraint rental_chamber_id_pk primary key (rental_chamber_id),
    constraint rental_chamber_fk foreign key (rental_id)  references hotel_management.rental (rental_id),
    constraint rental_chamber_fk2 foreign key (chamber_id) references hotel_management.chamber (chamber_id)
);
create table category(
	category_id bigint auto_increment,
    category_name nvarchar(125),
    constraint category_pk primary key (category_id)
);
create table food_item(
	food_item_id bigint auto_increment,
    food_item_name nvarchar(50),
    food_item_description nvarchar(125),
    price varchar(25),
    image varchar(255),
	category_id bigint,
    constraint food_item_pk primary key (food_item_id),
    constraint food_item_fk foreign key (category_id) references category(category_id)
);
create table order_food(
	order_food_id bigint auto_increment,
    total_price varchar(25),
    people_number varchar(10),
    order_date nvarchar(30),
    discount varchar(25),
    note nvarchar(500),
    rental_id bigint,
    constraint order_food_pk primary key (order_food_id),
    constraint order_food_fk foreign key (rental_id) references rental(rental_id)
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
create table service(
	service_id bigint auto_increment,
    service_name nvarchar(125),
    price varchar(25),
    constraint service_pk primary key (service_id)
);
alter table service add note nvarchar(125);
alter table service add unit nvarchar(50);
alter table service add service_description nvarchar(1000);
create table service_bill(
	service_bill_id bigint auto_increment,
    total_price varchar(25),
    order_date nvarchar(30),
    discount varchar(25),
    note nvarchar(500),
    rental_id bigint,
    constraint service_bill_pk primary key (service_bill_id),
    constraint service_bill_fk foreign key (rental_id) references rental(rental_id)
);
create table detail_service_bill(
	detail_service_bill_id bigint auto_increment,
    service_id bigint,
    service_bill_id bigint,
    constraint detail_service_bill_pk primary key (detail_service_bill_id),
    constraint detail_service_bill_id_fk foreign key (service_id)  references service(service_id),
    constraint detail_service_bill_id_fk2 foreign key (service_bill_id) references service_bill(service_bill_id)
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
insert into hotel_management.guest(guest_name,birth,id_card,passport,address,nationality,phone_number,is_familiar,is_vip) values
('Nguyến Văn An','1998-10-02','123456789102',null,'Hà Nội','Việt Nam','0123456789','false','yes'),
('Nguyến Văn Nam','1998-10-02','123456789102','A01236','Viet Nam dsdad','Việt Nam','0123456789','false','no'),
('Yuki Mira','1998-10-02','123456789102','A01236','Hà Nội','Việt Nam','0123456789','false','yes'),
('Hoài Anh','1998-10-02','123456789102',null,'Hà Nội','Việt Nam','0123456789','false','yes'),
('Nghiêm Túc','1998-10-02','123456789102','A01236','Hà Nội','Việt Nam','0123456789','false','no'),
('Nguyến Văn An','1998-10-02','123456789102',null,'Hà Nội','Việt Nam','0123456789','false','yes'),
('Nguyến Văn An','1998-10-02','123456789102',null,'Hà Nội','Việt Nam','0123456789','false','yes'),
('Nguyến Văn An','1998-10-02','123456789102','A9086','Hà Nội','Việt Nam','0123456789','false','no'),
('Nguyến Văn Nam','1998-10-02','123456789102','A01236','Hà Nội','Việt Nam','0123456789','false','yes'),
('Nguyến Văn An','1998-10-02','123456789102',null,'Hà Nội','Việt Nam','0123456789','false','yes');

select count(*) from guest where guest.id_card = '123456789102' or guest.phone_number = '0123456789' or guest.passport = 'A9086';

delete from rental_chamber;
delete from rental;
delete from guest;
delete from chamber;
insert into hotel_management.chamber(chamber_number,chamber_type,is_vip,price_day,chamber_area,note,is_empty) values 
('101','single','true','1700000','70','Phòng này là phòng vip','true'),
('102','couple','true','1500000','65.5','Phòng đôi thường','true'),
('103','family','true','1700000','70','','true'),
('104','couple','true','1700000','70','','true'),
('105','single','true','5000000','70','Phòng này là phòng vip','true'),
('106','couple','true','1700000','70','Phòng này là phòng vip','true'),
('107','couple','true','3500000','70','Phòng này là phòng vip','true'),
('108','couple','true','1700000','45.6','Phòng này là phòng vip','true'),
('109','single','true','5500000','70','Phòng này là phòng vip','true'),
('110','family','false','1700000','70','Phòng này là phòng vip','true'),
('111','single','false','700000','70','Phòng này là phòng vip','true'),
('112','couple','false','1700000','70','','true'),
('113','couple','false','1700000','50.6','Phòng này là phòng vip','true'),
('114','family','false','5500000','70','Phòng này là phòng vip','true'),
('115','single','false','1700000','70','Phòng này là phòng vip','true'),
('116','couple','false','10000000','70.56','Phòng này là phòng vip','true');

select * from guest;
select * from rental;
select * from rental_chamber;
select * from chamber;
select * from hotel_management.persistent_login;
select * from guest where guest_name like '%no%' or birth like '%no%' or id_card like '%no%' or  passport like '%no%' or address like '%no%' or nationality like '%no%' or phone_number like '%no%'or is_vip like '%no%';

select * from hotel_management.check_in;
select * from hotel_management.chamber where cast(price_day as unsigned) < 1000000 and chamber_type = 'single' and is_vip = 'false' and is_empty = 'false';
select * from hotel_management.chamber where cast(price_day as unsigned) between 1000000 and 3000000 and chamber_type = 'couple' and is_vip = 'false' and is_empty = 'true';
select * from hotel_management.chamber where cast(price_day as unsigned) > 3000000 and chamber_type = 'couple' and is_vip = 'true' and is_empty = 'true';

select * from hotel_management.guest where  guest.passport = 'A01236' or guest.id_card = ''  or guest.phone_number = '';
select * from food_item;
insert into hotel_management.category(category_name) values('Đồ ăn'),('Đồ uống'),('Đồ chay'),('Món lẩu'),('Tráng miệng');
insert into hotel_management.food_item(food_item_name,food_item_description,price,image,category_id) 
values('Gà rán','Món gà rán ngon nhất Đông Nam á','500000','',1),
('Rượu Whisky','','1500000','',2),
('Đậu lăn tôm','','500000','',1),
('Đậu nành hầm măng','Món chay đặc biệt nhất','200000','',3),
('Kem cuộn','Nếu khách vip đc giảm 20%','120000','',5);
delete from hotel_management.food_item;
select * from food_item;
select g.guest_name,g.phone_number,g.is_vip,r.rental_id 
from rental r join rental_chamber rc on r.rental_id = rc.rental_id 
join chamber c on c.chamber_id = rc.chamber_id join guest g 
on g.guest_id = r.guest_id where r.paid = 'false' and c.chamber_number = '101';
select c.chamber_number from rental r join rental_chamber rc
 on r.rental_id = rc.rental_id 
join chamber c on c.chamber_id = rc.chamber_id where r.paid = 'false';
select * from order_food;
select * from service_bill;

select * from service;
insert into service(service_name,price,unit,service_description,note) 
values('Quầy bar','0','','Nơi khách hàng lui tới để thư giãn, thưởng thức các loại rượu, Cocktail và trò chuyện cùng nhau','miễn phí'),
('Dịch vụ Spa','2500000','giờ','Giúp khách thư giãn, nghỉ ngơi sau một ngày hoạt động ngoài trời',''),
('Fitness center','100000','ngày','Tập thể dục tăng cường sức khỏe hoặc tập thể hình để có một vóc dáng hoàn hảo của mọi người ngày càng tăng',''),
('Sân golf và sân tennis','200000','giờ','Khách hàng là doanh nhân thường rất thích đánh golf hoặc tennis',''),
('Hội họp, văn phòng','0','','Dịch vụ này nhằm mục đích phục vụ tốt nhu cầu của đối tượng khách là các doanh nghiệp, bao gồm các tiện ích văn phòng như: Máy tính kết nối Internet, máy in, máy photocopy…','Miễn phí'),
('Dịch vụ giặt ủi quần áo','0','','những khách lưu trú trong thời gian dài thì dịch vụ giặt áo quần áo là vô cùng cần thiết, mỗi loại trang phục sẽ có một đơn giá tính phí khác nhau','Tính phí theo loại quần áo');

select f.food_item_id,f.food_item_name,f.food_item_description,f.price,f.image,c.category_name from food_item f join category c on f.category_id = c.category_id;
select * from rental;
select * from service_bill;
select * from order_food;


delete from rental;
delete from service_bill;
delete from order_food;

select r.rental_id,r.check_in_date,r.note,o.total_price as food_total,s.total_price as service_total,g.guest_name,g.birth,
g.id_card,g.passport,g.address,g.nationality,g.phone_number,g.email,c.chamber_type,c.price_day,c.is_vip
 from rental r join service_bill s on r.rental_id = s.rental_id 
join order_food o on o.rental_id = r.rental_id join guest g on g.guest_id = r.guest_id 
join rental_chamber rc on rc.rental_id =  r.rental_id join chamber c
 on c.chamber_id = rc.chamber_id where c.chamber_number = 101;
 
select r.rental_id,r.check_in_date,r.note,g.guest_name,g.birth,g.id_card,g.passport,g.address,
g.nationality,g.phone_number,g.email,c.chamber_type,c.price_day,c.is_vip
 from rental r join guest g on g.guest_id = r.guest_id 
join rental_chamber rc on rc.rental_id =  r.rental_id join chamber c
 on c.chamber_id = rc.chamber_id where c.chamber_number = 101 and r.paid = 'false'; -- lay thong tin chung
 
 select sum(o.total_price) as total from rental r join order_food o on o.rental_id = r.rental_id
join rental_chamber rc on rc.rental_id =  r.rental_id join chamber c
 on c.chamber_id = rc.chamber_id where c.chamber_number = 101 and r.paid = 'false'; -- tinh tien an
 
select sum(s.total_price) as total from rental r join service_bill s on r.rental_id = s.rental_id
join rental_chamber rc on rc.rental_id =  r.rental_id join chamber c
 on c.chamber_id = rc.chamber_id where c.chamber_number = 101 and r.paid = 'false'; -- tinh tien dich vu
 
 update rental set check_in_date = '2019-07-23';
select datediff(now(),check_in_date) from rental r join rental_chamber rc on rc.rental_id =  r.rental_id join chamber c
on c.chamber_id = rc.chamber_id where c.chamber_number = 101 and r.paid = 'false'; -- Tinh so ngay

select r.rental_id,r.check_in_date,r.note,g.guest_name,g.birth,g.id_card,g.passport,g.address,g.nationality,g.phone_number,g.email,c.chamber_type,c.price_day,c.is_vip from rental r join guest g on g.guest_id = r.guest_id join rental_chamber rc on rc.rental_id =  r.rental_id join chamber c on c.chamber_id = rc.chamber_id where c.chamber_number = 101 and r.paid = 'false'

;select sum(s.total_price) as total from rental r join service_bill s on r.rental_id = s.rental_id join rental_chamber rc on rc.rental_id =  r.rental_id join chamber c on c.chamber_id = rc.chamber_id where c.chamber_number = 101  and r.paid = 'false'

 
 















