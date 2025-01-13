# create database vttp_2025;

use vttp_2025;



create table tv_shows (
	prog_id int not null auto_increment,
    title char(64) not null,
    lang char(64) not null,
    official_site varchar(255),
    rating enum('G', 'PG', 'NC13', 'M18', 'R21') not null,
    user_rating float default '0.0',
    release_date date,
    image blob,
    constraint pk_prog_id primary key (prog_id),
    constraint chk_user_rating check(user_rating between 0.0 and 10.0)
);

select * from information_schema.table_constraints
where table_name = 'tv_shows'


create table tutorial (
	id int not null auto_increment,
    title varchar(100) not null,
    author varchar(80) not null,
    submission_date date,
    constraint pk_tutorial_id primary key (id)
);

insert into tutorial (title, author, submission_date) values ('CS1001', 'Chuk', '2025-02-01');
insert into tutorial (title, author, submission_date) values ('CS1002', 'Cheesy', '2025-02-05');
insert into tutorial (title, author, submission_date) values ('CS1003', 'Chris', '2025-02-28');
insert into tutorial (title, author, submission_date) values ('CS1004', 'Christy', '2025-03-01');
insert into tutorial (title, author, submission_date) values ('CS1005', 'Melvin', '2025-03-08');
insert into tutorial (title, author, submission_date) values ('CS1006', 'Melcomn', '2025-03-15');
insert into tutorial (title, author, submission_date) values ('CS2001', 'Daisy', '2025-02-01');
insert into tutorial (title, author, submission_date) values ('CS2002', 'Damien', '2025-02-05');
insert into tutorial (title, author, submission_date) values ('CS2003', 'Daniel', '2025-02-28');
insert into tutorial (title, author, submission_date) values ('CS2004', 'Derrick', '2025-03-01');
insert into tutorial (title, author, submission_date) values ('CS2005', 'Darren', '2025-03-08');
insert into tutorial (title, author, submission_date) values ('CS2006', 'Dark Knight', '2025-03-15');

select * from tutorial limit 5 offset 10;

select * from tutorial where author = 'chris';

select * from tutorial where author like '%da%';

select * from tutorial 
where submission_date >= '2025-02-01' and submission_date <= '2025-02-28'
order by id desc, author asc;

select * from tutorial where title in ('cs2001', 'cs1001', 'cs2004');

select * from tutorial 
where submission_date between '2025-02-01' and '2025-02-28'
and author like '%da%';

select * from tutorial 
where submission_date not between '2025-02-01' and '2025-02-28' 
and author like '%da%';

create table tv_shows (
	prog_id int not null auto_increment,
    title char(64) not null,
    lang char(64) not null,
    official_site varchar(255),
    rating enum('G', 'PG', 'NC13', 'M18', 'R21') not null,
    user_rating float default '0.0',
    release_date date,
    image blob,
    constraint pk_prog_id primary key (prog_id),
    constraint chk_user_rating check(user_rating between 0.0 and 10.0)
);

insert into tv_shows 
(title, lang, rating, user_rating, release_date) 
values ('AI wil win', 'Chinese', 'PG', 7.5, '2025-01-25');

insert into tv_shows 
(title, lang, rating, user_rating, release_date) 
values ('James Bond', 'English', 'M18', 8.5, '2023-02-15');

insert into tv_shows 
(title, lang, rating, user_rating, release_date) 
values ('Inside Out', 'English', 'G', 8.5, '2022-02-15');

insert into tv_shows 
(title, lang, rating, user_rating, release_date) 
values ('Inside Out 2', 'English', 'G', 8.0, '2024-05-15');


select * 
from tv_shows
where user_rating >= 8.0 
or rating in ('G', 'M18', 'PG');

create table room (
	id int not null auto_increment,
    roomtype varchar(150) not null,
    price float default '150.0',
    constraint pk_room_id primary key (id)
);

create table customer (
	id int not null auto_increment,
    fullname varchar(255) not null,
    email varchar(255) not null,
	constraint pk_customer_id primary key (id)
);

create table reservation (
	id int not null auto_increment,
    start_date date,
    end_date date, 
    cost float,
    customer_id int,
    room_id int,
    constraint pk_reservation_id primary key (id),
    constraint fk_customer_id foreign key (customer_id) references customer(id),
    constraint fk_room_id foreign key (room_id) references room(id)
);

insert into room (roomtype, price) values ('standard', 150.0);
insert into room (roomtype, price) values ('deluxe', 200.0);
insert into room (roomtype, price) values ('super deluxe', 250.0);
insert into room (roomtype, price) values ('president', 300.0);
insert into room (roomtype, price) values ('suite', 350.0);

insert into customer (fullname, email) values ('Emily Quek', 'emilyquek@visa.com.sg');
insert into customer (fullname, email) values ('Zhixuan Kang', 'zhixuan@visa.com.sg');
insert into customer (fullname, email) values ('Aloysius Chen', 'aloysius@visa.com.sg');
insert into customer (fullname, email) values ('Hanyen', 'hanyen@visa.com.sg');
insert into customer (fullname, email) values ('Darryl', 'darrylng@nus.edu.sg');


select * from room;

select * from customer;

# day 22
# add addtional records
insert into tv_shows 
(title, lang, rating, user_rating, release_date) 
values ('Jap Test 1', 'Japanese', 'PG', 8.0, '2025-01-15');

insert into tv_shows 
(title, lang, rating, user_rating, release_date) 
values ('Jap Test 2', 'Japanese', 'PG', 8.0, '2025-01-15');

insert into tv_shows 
(title, lang, rating, user_rating, release_date) 
values ('Korea Test 1', 'Korea', 'PG', 8.0, '2025-01-15');

insert into tv_shows 
(title, lang, rating, user_rating, release_date) 
values ('Korea Test 2', 'Korea', 'PG', 8.0, '2025-01-15');


# day 22 - slide 3
select * from tv_shows;

select distinct lang from tv_shows;

select distinct lang, rating from tv_shows;

select count(*) from tv_shows where lang like '%English%';

select count(distinct title) from tv_shows where lang like '%Japanese';

select count(distinct title) from tv_shows where lang in ('Japanese', 'Korea');

# day 22 - slide 5

select avg(user_rating) from tv_shows 
where lang like '%Eng%';

select sum(user_rating) from tv_shows 
where lang like '%Eng%';

select sum(user_rating) / count(*) from tv_shows
where lang like '%Eng%';

select rating, count(rating) from tv_shows
group by rating;

select rating, count(rating) as cnt from tv_shows
group by rating
order by count(rating) asc;

select rating, count(rating) from tv_shows
group by rating
order by rating asc;

select rating, count(rating) as cnt from tv_shows
where lang in (select distinct lang from tv_shows where lang like '%Eng%')
group by rating
order by rating asc;

# day 22 - slide 7
select rating, count(rating) as cnt from tv_shows
group by rating
having count(rating) > 5
order by rating asc;

select * from
(select rating, count(rating) as cnt from tv_shows
group by rating
order by rating asc) as tableA
where tableA.cnt > 5;

select title , rating , lang,
max(rating) over (partition by lang ) as max_rating
from tv_shows;


select * from customer;

delete from customer;

# day 22 PM
# over partition by

create table car (
	id int not null auto_increment,
    make varchar(50),
    model varchar(50),
    cartype varchar(50),
    price float default '10000.0',
    constraint pk_car_id primary key (id)
);

insert into car (make, model, cartype, price) values ('Hyundai', 'Avante', 'sedan', 80000.0);
insert into car (make, model, cartype, price) values ('Toyota', 'Altis', 'sedan', 82850.0);
insert into car (make, model, cartype, price) values ('Ford', 'Falcom', 'low cost', 50000.0);
insert into car (make, model, cartype, price) values ('Renault', 'Megane', 'standard', 90000.0);
insert into car (make, model, cartype, price) values ('Hyundai', 'Box', 'premium', 120000.0);
insert into car (make, model, cartype, price) values ('Honda', 'Civic', 'sports', 180000.0);
insert into car (make, model, cartype, price) values ('Toyota', 'Two', 'sports', 155000.0);
insert into car (make, model, cartype, price) values ('Honda', 'Fit', 'sports', 152850.0);
insert into car (make, model, cartype, price) values ('Ford', 'Galaxy', 'standard', 79000.0);
insert into car (make, model, cartype, price) values ('Toyota', 'Penguin', 'sedan', 69000.0);
insert into car (make, model, cartype, price) values ('Renault', 'Fuego', 'sports', 65000.0);

select * from car;

select make, model, cartype, price
, max(price) over (partition by cartype)  as max_cartype
from car;

select make, model, cartype, price
, sum(price) over (partition by cartype)  as sum_cartype
from car;

select make, model, cartype, price
, sum(price) over (partition by make)  as sum_cartype
from car;

select make, model, cartype, price
, avg(price) over (partition by cartype)  as sum_cartype
from car;

select make, model, cartype, price
, avg(price) over () as overall_avg_price
, avg(price) over (partition by cartype)  as sum_cartype
from car;


create table employee (
	id int not null auto_increment,
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	email varchar(255),
	job_title varchar(100),
	department varchar(100),
	employment_date date,
	salary float,
	constraint pk_employee_id primary key (id)
);

alter table employee
add active boolean;

alter table employee
auto_increment = 1;


create table dependant(
	id int not null auto_increment,
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	birth_date date,
	relationship varchar(30),
	employee_id int,
	constraint pk_dependant_id primary key (id),
	constraint fk_dep_emp_id foreign key (employee_id) references employee(id)
);

# For GetMapping
select * from employee;

# For GetMapping
select * from employee where id = 1;

delete from employee where id = 1;

# For DeleteMapping
update employee set active = false where id = 1;

# For PostMapping
insert into employee (first_name, last_name, email, job_title, department, employment_date, salary, active) values
('Darryl', 'Ng', 'darrylng@nus.edu.sg', 'Lecturer', 'ISS', '2021-09-08', 7000.0, true);

# For UpdateMapping
update employee set
first_name = 'Alibaba',
email = 'alibaba@alibaba.com.sg',
job_title = 'CEO',
department = 'master of no one',
employment_date = '2025-01-01',
salary = '2000000.0'
where id = 1;


