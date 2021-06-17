use encore;

create table emp1
as
select employee_id as emp_id, last_name as name, salary as sal, 
department_id as dept_id
from employees
where 1=0;

desc emp1;
select * from emp1;

alter table emp1   #alter table : 테이블 구조를 수정. 컬럼추가, 컬럼삭제, 컬럼수정, 제약조건 추가
add primary key(emp_id);

alter table emp1
add foreign key(dept_id) references departments(department_id);
#dept_id에 포린키를 추가. 그리고 뎁트아이디는 이파트먼츠테이블의 디파트먼트 아이디를 참고하겠다는 뜻

insert into emp1 values(200, 'aaa', 5000, 70);   
#디파트먼트 테이블의 디파트먼트아이디를 참조한다.
#이 문장이 실행된다는 것은 사번=프라이머리키 가 아니라는 뜻.

select * from emp1; 

create table emp1
as
select employee_id as emp_id, last_name as name, salary as sal, 
department_id as dept_id
from employees
where 1=0;

desc emp1;

#update문
#update 테이블명 set 컬럼1=val1, 컬럼2=val2...
select * from emp1;
update emp1 set salary=15000 where name='Tucker';

#delete 행 삭제
#delete from 테이블명 where 삭제조건
delete from emp1 where name='Tucker';
delete from emp1 where dept_id='70';