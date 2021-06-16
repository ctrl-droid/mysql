# 1. 급여가 $12,000를 넘는 사원의 이름과 급여를 표시하는 질의를 작성하시오.
use encore;

select last_name, salary 
from employees
where salary >=12000 ;

# 2. 사원번호가 176인 사원의 이름과 부서 번호를 표시하는 질의를 작성하시오.
select last_name, department_id 
from employees
where employee_id = 149;