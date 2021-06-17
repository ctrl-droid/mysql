#게시판(num, writher, w_date, title, content). 회원가입 (id, pwd, name, email).

create table member(
id varchar(20) primary key,  #줄 대푯값
pwd varchar(20) not null,   #null 허용안함
name varchar(20) not null,
email varchar(20) unique   #중복허용안함
);

select * from member;

#3명 회원가입
insert into member values('aaa', '111', 'namea', 'aaa@mail.con');
insert into member values('bbb', '222', 'nameb','bbb@mail.con');
insert into member values('ccc', '333', 'namec','ccc@mail.con');


#게시판(num, writher, w_date, title, content) 생성
create table borad(
num int auto_increment primary key,
writer varchar(20), 
w_date datetime, 
title varchar(50),
content varchar(500), 
constraint foreign key(writer) references member(id)
);

alter table borad
rename board;

select * from board;

insert into board(writer, w_date, title, content) 
	values('aaa', sysdate(), 'title1', 'content1'); 

insert into board(writer, w_date, title, content) 
	values('abc', sysdate(), 'title1', 'content');  #member id에 abc가 없기때문에 삽입이 안됨. 근데 번호 생성은 했음.
    
insert into board(writer, w_date, title, content) 
	values('bbb', sysdate(), 'title2', 'content2'); 

delete from board where writer = 'bbb';
delete from member where id = 'bbb';
-> 삭제시 참조하는 행도 삭제하고 진행해야하기 때문에 create 시에 on delete cascade를 추가해주면 문제가 없다.

drop table board;

create table board(
num int auto_increment primary key,
writer varchar(20), 
w_date datetime, 
title varchar(50),
content varchar(500), 
constraint foreign key(writer) references member(id) on delete cascade
);

insert into board(writer, w_date, title, content) 
	values('aaa', sysdate(), 'title1', 'content1');

delete from board where writer = 'aaa';

drop table board;

#on delete set null : 부모 테이블의 행 삭제시 이 줄을 참조하는 모든 줄의 값을 null로 셋팅
create table board(
num int auto_increment primary key,
writer varchar(20), 
w_date datetime, 
title varchar(50),
content varchar(500), 
constraint foreign key(writer) references member(id) on delete set null
);

insert into board(writer, w_date, title, content) 
	values('aaa', sysdate(), 'title1', 'content1');

delete from board where writer = 'aaa';

select * from board;
