use encore;

select e.employee_id, e.last_name, e.manager_id, m.employee_id, m.last_name
from employees e join employees m
on e.manager_id = m.employee_id
where e.employee_id= 175;

#last_name이 Abel인 사람보다 월급을 많이 받는 사람들의 사번, 이름, 월급을 출력하라 
select employee_id, last_name, salary
from employees
where salary > (select salary from employees where last_name='Abel');


create table job_grades(
gra char(1) primary key,
lowest_sal int ,
highest_sal int
);

insert into job_grades values('A', 1000, 2999);
insert into job_grades values('B', 3000, 5999);
insert into job_grades values('C', 6000, 9999);
insert into job_grades values('D', 10000, 14999);
insert into job_grades values('E', 15000, 24999);
insert into job_grades values('F', 25000, 40000);
desc job_grades;

select * from job_grades;

select employee_id, last_name, salary, gra
from employees e join job_grades j
on e.salary between j.lowest_sal and j.highest_sal;




