use encore;
select * from employees;
select * from departments;
select department_id, department_name 
from departments
where department_id<50;

select last_name, 12*salary, salary + 300 as salary2
from employees;

select last_name, job_id, salary, commission_pct
from employees;

select last_name, 'aaa', salary, salary+300 'sal 2'
from employees;

select distinct department_id from employees;

desc employees; 

select employee_id, last_name, job_id, department_id
from employees
where department_id=90;

select last_name, salary
from employees
where salary between 2500 and 3500;

select employee_id, last_name, salary, manager_id
from employees
where manager_id in(100,101,201);

select first_name
from employees
where first_name like '_o%';

select last_name, hire_date
from employees
where hire_date like '__05%';

select last_name, salary
from employees
where salary >=12000
and job_id like '%MAN%';

select last_name, job_id, department_id, hire_date
from employees
order by hire_date desc;

select employees.employee_id, employees.last_name, 
	employees.department_id, departments.department_id,
    departments.location_id
from employees, departments
where employees.department_id = departments.department_id;

select e.employee_id, e.last_name, e.department_id,
d.department_id, d.location_id
from employees e, departments d
where e.department_id = d.department_id;

select department_id, department_name,
location_id, city
from departments
natural join locations;

select e.last_name, e.department_id, d.department_name
from employees e
left outer join departments d
on (e.department_id = d.department_id) ;

select e.last_name, e.department_id, d.department_name
from employees e
right outer join departments d
on (e.department_id = d.department_id) ;

select e.last_name, e.department_id, d.department_name
from employees e
full outer join departments d
on (e.department_id = d.department_id) ;
