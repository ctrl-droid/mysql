9장
#테이블 생성

/*
create table 이름(
컬럼명 타입(크기) [제약조건],
컬럼명 타입(크기) [제약조건],
컬럼명 타입(크기) [제약조건]
);
*/

타입
정수 : int(interger)
실수 : float
문자 : char(크기) -고정크기 / varchar(크기)-가변크기
대용량 텍스트: longtext(4gb)
날짜: date(년-월-일) / datetime(년-월-일 시:분:초)

create table test2(
num int auto_increment primary key,
name varchar(20) not null,
addr varchar(50) default '서울',
w_date datetime default now(),
msg varchar(200)
);

desc test2;
select * from test2;

insert into test2(name, msg) values('aaa', 'hello');
insert into test2(name, addr, msg) values('bbb', '안양', '안녕하세요');

#테이블 수정 : 테이블 구조 변경. 컬럼추가, 컬럼삭제, 컬럼의 타입이나 크기를 변경(값이 없을떄)
#컬럼추가
alter table 테이블명
add (컬럼명 타입(크기))

alter table test2
add (pwd varchar(10)); 

#컬럼변경(타입이나 크기 변경)
alter table 테이블명
modify (컬럼명 새타입(새크기));

alter table test2
modify pwd varchar(20);   #크기를 크게 바꾸는 건 가능하지만 작게는 힘듬.

#컬럼 삭제
alter table 테이블명
drop column 컬럼명;

alter table test2
drop column pwd;

#컬럼명 변경
alter table 테이블명
change 원컬럼명 새컬럼명 타입;

alter table test2
change msg hello_msg varchar(200);

alter table test2
add (col1 char(10));
alter table test2
add (col2 char(10));

/* drop column은 한번에 컬럼 하나만 삭제가능
alter table test2
drop column col2, col2;
*/

#테이블 이름 변경
alter table test2
rename new_test2;

desc new_test2;

select * from new_test2;
delete from new_test2;   #delete는 rollback이 되지만
rollback;

truncate table new_test2;  #전체행 삭제. rollback 안됨.