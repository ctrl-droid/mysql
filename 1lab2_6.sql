use encore;
select * from employees;

# 6. 급여가 $5,000와 $12,000 사이이고 부서 번호가 20 또는 50인 사원의 이름과 급여를 나열하도록 [3번 문제]을 수정 하고, 열 레이블을 Employee와 Monthly Salary로 각각 지정하여 실행하시오.
select last_name as Employee, salary*12 as 'Monthly Salary'
from employees
where salary between 5000 and 12000
and (department_id =20 or department_id=50);

# 7. 2094년에 입사한 모든 사원의 이름과 입사일을 표시하시오.
select last_name, hire_date
from employees
where hire_date like '__04%';

# 8. 관리자가 없는 모든 사원의 이름과 업무를 표시하시오.
select last_name, job_id
from employees
where manager_id is null;

# 9. 커미션을 받는 모든사원의 이름, 급여 및 커미션을 급여 및 커미션을 기준으로 내림차순으로 정렬하여 표시하시오.
select last_name, salary, commission_pct
from employees
where commission_pct is not null
order by commission_pct desc;

# 10. 이름의 세번째 문자가 a인 모든 사원의 이름을 표시하십시오.
select last_name
from employees
where last_name like '__a%';

# 11. 이름에 a와 e가 있는 모든사원의 이름을 표시하십시오.
select last_name
from employees
where last_name like '%a%e%' or '%e%a%';

# 12. 업무가 영업 사원 또는 사무원이면서 급여가 $2,500, $3,500 또는 $7,000가 아닌 모든 사원의 이름, 업무 및 급여를 표시하십시오.
select last_name, job_id, salary
from employees
where job_id = 'SA_REP' or job_id = 'ST_CLERK'
and salary not in (2500, 3000, 7000);

# 13. 커미션 비율이 20%인 모든 사원의 이름, 급여 및 커미션을 표시하도록 [6번 문제]을 수정하십시오
select last_name as Employee, salary*12 as 'Monthly Salary', commission_pct
from employees
where commission_pct = 0.20


