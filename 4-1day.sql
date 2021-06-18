프로시져
===========
함수 호출
call 함수명()

set @a=10;
select @a;

use encore;
set @num=(select employee_id from employees where last_name='Abel');
select @enum;

select employee_id, salary into @enum, @sal from employees where last_name='Abel';
select @enum, @sal;

call p1(100);

call p2(100, @ename);
select @ename;

call p3(100);

call p4(175);

/*
if 조건 then
elseif 조건 then
elseif 조건 then
else 실행문;
*/

/*
부서번호 10 '개발1팀'
부서번호 20 '개발2팀'
부서번호 30 '개발3팀'
부서번호 40 '개발4팀'
이외 '디자인팀'
*/

call p5(201);   #if

call p6(201);    #case

call p7(10);    #루프

call p9(10);    #repeat

call p10(10);    #while

call cusor_test();

SET GLOBAL log_bin_trust_function_creators = 1;

select employee_id, f1(last_name, first_name) as name, salary
from employees;

