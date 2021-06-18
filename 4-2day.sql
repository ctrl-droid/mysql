#함수
SET GLOBAL log_bin_trust_function_creators = 1;

select employee_id, f1(last_name, first_name) as name, salary
from employees;

select f2(employee_id) as name from employees;
select f2(100);


#트리거 : insert, update, delete 동작이 실행될떄마다 이 동작 전이나 후에 실행할 코드를 등록하는 방법
/*
create trigger 트리거이름
after/before insert/update/delete
on 테이블이름
[for each row] 
*/

delimiter $$
create trigger insert_emp_trig
after insert
on emp1
for each row
begin
	set @msg = concat(new.name, '님 새로 추가됨');    #new.name/old.name : 트리거에서 사용하는 값
end$$
delimiter ;
-> emp1에 insert할떄마다 실행

insert into emp1 values(300,'aaa',10000,80);
select @msg;

create table emp1_backup(
num int auto_increment primary key,
id int,
cmd varchar(20),
old_sal int,
new_sal int
);

delimiter $$
create trigger emp1_trig
after insert
on emp1
for each row
begin
	insert into emp1_backup(id, cmd, new_sal) values(new.emp_id, 'insert', new.sal);
end$$
delimiter ;

insert into emp1 values(301,'bbb',15000,80);
select @msg;

select * from emp1_backup;

delimiter $$
create trigger emp1_trig2
after update
on emp1
for each row
begin
	insert into emp1_backup(id, cmd, old_sal, new_sal) 
    values(old.emp_id, 'update', old.sal, new.sal);
end$$
delimiter ;

update emp1 set sal=20000 where emp_id=300;

delimiter $$
create trigger emp1_trig3
before delete
on emp1
for each row
begin
	insert into emp1_backup(id, cmd, old_sal, new_sal) 
    values(old.emp_id, 'delete', old.sal);
end$$
delimiter ;

delete from emp1 where emp_id>=145 and emp_id<150;
