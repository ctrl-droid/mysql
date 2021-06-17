#8장.
use encore;

#DDL : 데이터 정의어, create table/view/procedure/function
#DML : 데이터 조작어. insert, update, delete  -> commit
#DCL : 데이터, grant, revoke

#char(10) 고정길이
#varchar(10) 가변길이

create table test1(
id varchar(20) primary key,
pwd varchar(20) not null,
name varchar(20)
);
alter table test1
add column(hire_date date);

desc test1;
insert into test1 values('aaa', '111', 'namea');
insert into test1(name, pwd, id) values('nameb', '222', 'bbb');
insert into test1(id, pwd) values('ccc', '333');
insert into test1 values('ddd', '444', null);

insert into test1 values('eee', '555', 'namee', sysdate());

select * from test1;

#다른 테이블의 구조를 복사해서 테이블 생성
create table emp
as
select * from employees where 1=0;    #행은 복사하지 말고

insert into emp
select * from employees where job_id like '%REP%';

select * from emp;

# update 테이블 set 컬럼명 = 새 값, where 조건;

update test1 set name='namec' where id='ccc';
update test1 set name='named', hire_date=sysdate() where id='ddd';
update test1 set hire_date = date('2020-05-05') where id='ddd';

#delete from 테이블 where 조건;

select * from test1;  
delete from test1 where id='ccc';

set sql_safe_updates = 0;
delete from test1;
rollback;

drop table test1;
create table test1(
id varchar(20) primary key,
pwd varchar(20) not null,
name varchar(20) default '아무개'
);

select * from test1;

insert into test1(id, pwd) values('aaa', '111');
insert into test1 values('bbb', '111', 'nameb');
update test1 set name=default where id='bbb';

#merge: 테이블 합병. A, B를 합친다 -> A에 합치는데 B에는 있고 A에 없는 줄을 A에 새로 추가하고
#A,B 양족에 다 있는 줄은 A의 행을 B의 값으로 갱신

insert into emp
select * from employees as e
on duplicate key update emp.employee_id =e.employee_id,
