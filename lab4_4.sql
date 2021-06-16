


# 4. 이름에 a(소문자)가 포함된 모든 사원의 이름과 부서 이름을 표시하시오.
select e.last_name, e.department_id
from employees e, departments d
where e.department_id = d.department_id
and last_name like '%a%';

# 5. Toronto에서 근무하는 모든 사원의 이름, 업무, 부서 번호 및 부서 이름을 표시하는 질의를 작성하십시오.
select e.last_name, e.job_id, e.department_id, d.department_name 
from employees e, departments d
where e.department_id = d.department_id
and d.location_id = toronto;

# 6. 사원의 이름 및 사원 번호를 관리자의 이름 및 관리자 번호화 함께 표시하고 각각의 열 레이블을 Employee, Emp#, Manager, Mgr#로 지정하십시오.
select e.last_name as 'Employee'. e.employee_id as 'EMP#', 
m.last_name as 'Manager', m.employee_id as 'Mgr#'
from employees e, employees m
where e.manager = m.employee_id;


# 7. 6번을 수정하되 King을 포함하여 관리자가 없는 모든 사원을 표시하도록 하고 결과를 사원 번호를 기준으로 정렬하십시오.


# 8. 지정한 사원의 이름, 부서 번호 및 지정한 사원과 동일한 부서에서 근무하는 모든 사원을 표시하도록 질의를 작성하고 각 열에 적합한 레이블을 지정하십시오.

# 9. JOB_GRADES 테이블의 구조를 표시하고 모든 사원의 이름, 업무, 부서 이름, 급여 및 등급을 표시하는 질의를 작성하십시오.

# 10. Davies라는 사원보다 늦게 입사한 사원의 이름과 입사일을 표시하는 질의를 작성하십시오.

# 11. 관리자보다 먼저 입사한 모든 사원의 이름 및 입사일을 관리자의 이름 및 입사일과 함께 표시하고 열 레이블을 각각 Employee, Emp Hired, <anager, Mgr Hired로 지정하십시오.