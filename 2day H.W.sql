#과제
use encore;

# 연습문제 5
# 1. 그룹 함수는 여러 행에 적용되어 그룹 당 하나의 결과를 출력합니다. ( True / False ) T
# 2. 그룹 함수는 계산에 널을 포함합니다. ( True / False ) F
# 3. WHERE 절은 그룹 계산에 행을 포함시키기 전에 행을 제한합니다. ( True / False ) T
# 4. 모든 사원의 급여 최고액, 최저액, 총액 및 평균액을 표시하십시오. 열 레이블을 각각 Maximum, Minimum, Sum 및 Average 로 지정하고 결과를 정수로 반올림한 후 작성한 SQL문을 lab5_4.sql이라는 파일에 저장하십시오.
select max(salary) as Maximum, min(salary) as Minimum, sum(salary) as Sum, round(avg(salary), 1) as Average
from employees;

# 5. lab5_4.sql의 질의를 수정하여 각 업무 유형별로 급여 최고액, 최저액, 총액 및 평균액을 표시하십시오. lab5_4.sql을 lab5_5.sql로 다시 저장하고 lab5_5.sql의 명령문을 실행하십시오.
select job_id, max(salary) as Maximum, min(salary) as Minimum, sum(salary) as Sum, avg(salary) as Average
from employees
group by job_id;

# 6. 업무가 동일한 사원 수를 표시하는 질의를 작성하십시오.
select job_id, count(job_id) as 'Count(*)'
from employees
group by job_id;

# 7. 관리자는 나열하지 말고 관리자 수를 확인하십시오. 열 레이블은 Number of Managers로 지정하십시오 .힌트 : MANAGER_ID 열을 사용하여 관리자 수를 확인하십시오.
select count(manager_id) as 'Number of Managers'
from employees;

# 8. 최고 급여와 최저 급여의 차액을 표시하는 질의를 작성하고 열 레이블을 DIFFERENCE로 지정하십시오.
select max(salary) - min(salary) as 'DIFFERENCE'
from employees

# 9. 관리자 번호 및 해당 관리자에 속한 사원의 최저 급여를 표시하십시오. 관리자를 알 수 없는 사원 및 최저 급여가 $ 6,000 미만인 그룹은 제외시키고 결과를 급여에 대한 내림차순으로 정렬하십시오.
select manager_id, min(salary) 
from employees    
WHERE manager_id IS NOT NULL      
GROUP BY manager_id      
HAVING MIN(salary) > 6000      
ORDER BY MIN(salary) DESC;


# 10. 각 부서에 대해 부서 이름, 위치, 사원 수, 부서 내 모든 사원의 평균 급여를 표시하는 질의를 작성하고, 열 레이블을 각각 Name, Location, Number of People 및 Salary로 지정하십시오. 평균 급여는 소수점 둘째 자리로 반올림하십시오.
select department_name as 'Name', location as 'Location', count(department_id), avg(salary)
from employees
group by department_name;

# 11. 총 사원 수 및 2005, 2006, 2007, 2008년에 입사한 사원 수를 표시하는 질의를 작성하고 적합한 열 머리글을 작성하십시오.
select count(last_name) as 'TOTAL', count(last_name)
from employees
where hire_date in (2005, 2006, 2007, 2008)
group by hire_date;

# 12. 업무를 표시한 다음 해당 업무에 대해 부서 번호별 급여 및 부서 20, 50, 80 및 90의 급여 총액을 각각 표시하는 행렬 질의를 작성하고 각 열에 적합한 머리글을 지정하십시오.

ch6.
#1. Zlotkey와 동일한 부서에 속한 모든 사원의 이름과 입사일을 표시하는 질의를 작성하십시오. Zlotkey는 제외.
select e1.last_name, e1.hire_date
from employees e1 join employees e2
on e2.department_id = (select e1.department_id
	from employees e1
    where e1.last_name = 'Zlotkey')
and e1.last_name <> e2.last_name;

#2. 급여가 평균 급여보다 많은 모든 사원의 사원번호와 이름을 표시하는 질의를 작성하고 결과를 급여에 대해 오름차순으로 정렬하십시오.
#3. 이름에 u가 포함된 사원과 같은 부서에서 일하는 모든 사원의 사원 번호와 이름을 표시하는 질의를 작성하시오.
#4. 부서 위치 ID가 1700인 모든 사원의 이름, 부서 번호 및 업무 ID를 표시하십시오.
#5. King에게 보고하는 모든 사원의 이름과 급여를 표시하십시오.
#6. Executive 부서의 모든 사원에 대한 부서 번호, 이름 및 업무 ID를 표시하십시오.
#7. 3번 문제의 질의를 수정하여 평균 급여보다 많은 급여를 받고 이름에 u가 포함된 사원과 같은 부서에서 근무하는 모든 사원의 사원번호, 이름 및 급여를 표시하시오.
