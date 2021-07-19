use movie_reserve;

select * from member;
select * from movie;
select * from theater;
select * from seat;

insert into member(id,pwd,name,tel,point) values('admin', '1234', '관리자','000-000-0000','0');
insert into member(id,pwd,name,tel,point) values('test1', '111', '테스터1','010-111-111','0');
insert into member(id,pwd,name,tel,point) values('test2', '222', '테스터2','010-222-222','0');
insert into member(id,pwd,name,tel,point) values('test4', '444', '테스터4','010-444-444','0');

insert into movie(name,date,director,actor) values('해리포터와 마법사의 돌', '2021.06.28', '조앤롤링', '말포이');
insert into movie(name,date,director,actor) values('어벤져스', '2021.06.30', '캡틴아메리카', '아이언맨');

insert into theater(name,date,movie_code) values('A관', '2021.06.29 10:00', 2);
insert into theater(name,date,movie_code) values('B관', '2021.07.01 15:30', 1);
insert into theater(name,date,movie_code) values('D관', '2021.07.02 07:00', 1);
#test1이 1번 영화 A1 자리 선택

update seat set name='A1' where theater_code = 4;

drop table reserve;
drop table seat;
drop table theater;
drop table movie;
drop table member;



