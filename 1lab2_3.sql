use encore;
select * from employees;

# 3. 급여가 $5,000에서 $12,000 사이에 포함되지 않는 모든 사원의 이름과 급여를 표시하는 질의를 작성하시오.
select last_name, salary 
from employees
where salary 
not in (5000<=salary, salary<=12000) ;

# 4. 1998년 2월 20일과 1998년 5월 1일 사이에 입사한 사원의 이름, 업무 ID 및 시작일을 표시하되, 시작일을 기준으로 오름차순으로 정렬하시오.
select last_name, job_id, hire_date
from employees
where hire_date like '__08%'
order by hire_date asc;

# 5. 부서 20 및 50에 속하는 모든 사원의 이름과 부서 번호를 이름을 기준으로 영문자순으로 표시하십시오.
select last_name, department_id
from employees
where department_id between 20 and 50
order by last_name;
