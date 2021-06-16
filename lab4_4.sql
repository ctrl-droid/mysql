#Q1. 모든 사원의 이름, 부서 번호, 부서 이름을 표시하는 질의를 작성하십시오.
select e.last_name, e.department_id, d.department_name
from employees e, departments d
where e.department_id = d.department_id;

#Q2.부서 80에 속하는 모든 업무의 고유 목록을 작성하고 출력 결과에 부서의 위치를 포함시키십시오.
select e.job_id, d.location_id
from employees e, departments d
where e.department_id = d.department_id
and d.department_id =80;
 
#Q3.커미션을 받는 사원의 이름, 부서 이름, 위치 ID 및 도시를 표시하는 질의를 작성하십시오.
select last_name, department_id, d.location_id, city
from employees e join departments d
on e.department_id = d.department_id
join locations l
on d.location_id = l.location_id
where commission_pct is not null; 

# 4. 이름에 a(소문자)가 포함된 모든 사원의 이름과 부서 이름을 표시하시오.
select last_name, department_id
from employees join departments
using(department_id)
where last_name like '%a%'
and not last_name like 'a%';


# 5. Toronto에서 근무하는 모든 사원의 이름, 업무, 부서 번호 및 부서 이름을 표시하는 질의를 작성하십시오.
select last_name, job_id, department_id, department_name 
from employees join departments
using(department_id)
join locations
using(location_id)
where city = 'toronto';

# 6. 사원의 이름 및 사원 번호를 관리자의 이름 및 관리자 번호화 함께 표시하고 각각의 열 레이블을 Employee, Emp#, Manager, Mgr#로 지정하십시오.
select e.last_name as 'Employee', e.employee_id as 'EMP#', 
m.last_name as 'Manager', m.employee_id as 'Mgr#'
from employees join employees
where e.manager = m.employee_id;

select e.last_name as 'Employee', e.employee_id as 'EMP#', 
m.last_name as 'Manager', m.employee_id as 'Mgr#'
from employees e join employees m
on e.manager_id = m.employee_id;

# 7. 6번을 수정하되 King을 포함하여 관리자가 없는 모든 사원을 표시하도록 하고 결과를 사원 번호를 기준으로 정렬하십시오.
select e.last_name as 'Employee', e.employee_id as 'EMP#', 
m.last_name as 'Manager', m.employee_id as 'Mgr#'
from employees e left outer join employees m
on e.manager_id = m.employee_id;

# 8. 지정한 사원의 이름, 부서 번호 및 지정한 사원과 동일한 부서에서 근무하는 모든 사원을 표시하도록 질의를 작성하고 각 열에 적합한 레이블을 지정하십시오.
select e.last_name, e.department_id, c.last_name as colleague
from employees e join employees c
on e.department_id = c.department_id
where e.last_name <> c.last_name;

# 9. JOB_GRADES 테이블의 구조를 표시하고 모든 사원의 이름, 업무, 부서 이름, 급여 및 등급을 표시하는 질의를 작성하십시오.
desc job_grades;
select last_name, job_id, department_name, salary, gra
from employees join departments
using (department_id)
join job_grades
on salary between lowest_sal and highest_sal;

# 10. Davies라는 사원보다 늦게 입사한 사원의 이름과 입사일을 표시하는 질의를 작성하십시오.
select e2.last_name, e2.hire_date
from employees e1 join employees e2
on e1.hire_date < e2.hire_date
where e1.last_name = 'Davies';

# 11. 관리자보다 먼저 입사한 모든 사원의 이름 및 입사일을 관리자의 이름 및 입사일과 함께 표시하고 열 레이블을 각각 Employee, Emp Hired, Manager, Mgr Hired로 지정하십시오.
select e.last_name as 'Employee', e.hire_date as 'Emp Hired', m.last_name as 'Manager', m.hire_date as 'Mgr Hired'
from employees e join employees m
on e.hire_date < m.hire_date;


