use encore;
#if함수
#if(수식, 참일때실행문, 거짓일때실행문)
select if(hire_date like '2005%', last_name, '2005년 입사 아님')
from employees;

#ifnull(컬럼/값, 널일때실행문)
select last_name, commission_pct, 12*salary+12*salary*commission_pct
from employees;

select last_name, commission_pct, 
12*salary+12*salary*ifnull(commission_pct, 0)
from employees;

#nullif(exp1, exp2): exp1과 exp2가 같으면 null, 같지 않으면 exp1 반환
select last_name, length(last_name), first_name, length(first_name),
nullif(length(last_name), length(first_name))
from employees;

#case문: 비교할 조건이 여러개 일때 사용
/*
case exp
   when 값1 then 실행문
   when 값2 then 실행문
   when 값3 then 실행문
   else 실행문
end as '컬럼별칭'
*/

select department_id, 
case department_id 
	when 10 then '10번 부서'
	when 20 then '20번 부서'
    when 30 then '30번 부서'
    else '이외 부서'
end as '부서명'
from employees;

#bit_length : 할당된 bit 크기 또는 문자 크기를 반환
select bit_length('가나다'), length('가나다')
from dual;

#concat : 문자열을 이어줌
select concat_ws(' / ', last_name, first_name) name
from employees;





