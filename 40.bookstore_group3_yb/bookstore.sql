drop table member;

create table member(
member_id varchar(30) not null primary key,
member_pw varchar(30) not null,
name varchar(30) not null,
mobile varchar(13) not null,
email varchar(30) not null,
entry_date varchar(10) not null,
grade char(1) not null,
mileage number(6)
);

CREATE SEQUENCE book_no START WITH 1 INCREMENT BY 1 MAXVALUE 1000 CYCLE NOCACHE;

create table book(
book_no number(7) NOT NULL AUTO_INCREMENT PRIMARY KEY,
book_name varchar(50) not null,
book_writer varchar(30) not null,
book_publisher varchar(30) not null,
book_ganre char(1) not null,
price number(6) not null,
amount number(3) not null
);


create table qna(
qna_no int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
qna_writer varchar(30) not null (fk- member_id),
qna_time varchar(20) not null 
qna_question varchar(300) not null,
qna_answer varchar(300) 
);

create table sales(
sales_no int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
book_no int(10) not null (fk-book_no),
buyer 
sales_price int(6) not null,
sales boolean not null default 0
);

