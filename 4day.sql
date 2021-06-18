use encore;
뷰 : 가상 테이블  -> 쓰기 작업은 ㄴㄴ
1. 복잡한 쿼리를 가상 테이블인 뷰로 만들면 사용이 간단해 진다.
2. 보안(사용자의 레벨에 따라 접ㄱㄴ 레벨을 분류할 수 있음)
3. 데이터의 독립성을 유지

create [or replace] view 뷰이름
as 
서브쿼리

create view view_80
as
select employee_id as emp_id, last_name as name, salary
from employees
where department_id = 80;

select * from view_80;

update view_80 set name='aaa' where emp_id=145;
select last_name from employees where employee_id=145; #->뷰로 쓰기 작업 하지 마라

create or replace view emp_view
as
select last_name, department_name, city, salary
from employees join departments
using(department_id)
join locations
using(location_id);

select * from emp_view;


인덱스 : 빠른 검색을 제공하기 위해 지정된 컬럼값을 완전 B트리로 구성
제약조건 primary key, unique을 만들면 자동 생성됨
인덱스 설정할 컬럼: 수정, 삭제가 잘 일어나지 않고 테이블에 많은 수의 행이 있지만 
검색 where 잘해서 사용하는 컬럼으로 이 컬럼으로 검색된 행이 몇 줄 안되는 컬럼.

create index 인덱스명 on 테이블명(컬럼명);

