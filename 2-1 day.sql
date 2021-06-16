use encore;

#5장.(p.233)

#그룹함수 : 전체로 묶어서 아웃풋
select avg(salary), max(salary), min(salary), sum(salary)
from employees
where job_id like '%REP%';

#단일행 함수 : 개별적으로 아웃풋
select ucase(last_name), last_name
from employees;

#count함수 : 줄을 세줌
select count(commission_pct)
from employees
where department_id=80;

#그룹함수는 널인값을 빼고 계산
#infull(p1, p2) : p1 컬럼이 null이면 p2로 대체
select avg(ifnull(commission_pct, 0))   #커미션이 널인 값을 0으로 대체
from employees;

select department_id, avg(salary)
from employees
group by department_id
order by avg(salary) desc;

select department_id, job_id, sum(salary)
from employees
group by department_id, job_id;

select department_id, max(salary)
from employees
group by department_id
having max(salary)>10000;

select job_id, sum(salary) payroll
from employees
where job_id not like '%REP%'
group by job_id
having sum(salary) > 13000
order by sum(salary);



#6장.

#서브 쿼리
select last_name
from employees 
where salary> (select salary 
	from employees 
	where last_name = 'Abel');

#단일 행 서브쿼리에는 단일 행 연산자를 사용하고 다중 행 서브 쿼리에는 다중 행 연산자를 사용한다.

select last_name, job_id, salary
from employees
where job_id = (select job_id
	from employees
    where employee_id = 141)
    
and salary > (select salary
	from employees
    where employee_id = 143);
    
select last_name, job_id, salary
from employees
where salary = (select min(salary)
	from employees);

select employee_id, last_name, job_id, salary
from employees
where salary < any(select salary
	from employees
    where job_id = 'it_prog')
and job_id <> 'it_prog';


select employee_id, last_name, job_id, salary
from employees
where salary < all(select salary
	from employees
    where job_id = 'it_prog')
and job_id <> 'it_prog';







