/* SQL Script File: member.sql

	# 회원 속성 : 자바 클래스에서는 멤버변수, 타입 멤버변수명, 순서(생성자 아규먼트 순서), 변수명규칙 소문자시작+합성어대문자시작 => memberId
	1. 아이디		문자열		30byte(한글 10글자)
	2. 비밀번호	문자열		20자리
	3. 이름		문자열		30자리
	4. 휴대폰		문자열		13자리	(형식 : 010-1234-1234) 
	5. 이메일		문자열		30자리
	6. 가입일		문자열		10자리	(형식 : yyyy-mm-dd, 2021-09-08)
	7. 등급		문자열		1자리		(종류: G,S,A)
	8. 마일리지	정수		6자리		(최대: 0 ~ 100,000 => 999999)
	9. 담당자		문자열		30자리
	
	
	# 회원 속송 : 데이터베이스 테이블에서는 컬럼명, 타입(길이) 컬럼명 + 제약, 순서, 컬럼명 자동으로 모두 대문자 모두 대문자_합성어모두대문자 => MEMBER_ID
	
	
	
	
*/

-- 회원 테이블 생성
create table member(
member_Id varchar(30) not null primary key,
member_Pw varchar(20) not null,
name varchar(30) not null,
mobile varchar(13) not null,
email varchar(30) not null,
entry_Date varchar(10) not null,
grade char(1) not null,
mileage number(6),
manager varchar(30)
);

insert into member values('user01', 'password01', '홍길동', '010-1234-1000', 'user01@work.com', '2020-12-15', 'G', '50000', null);
insert into member values('user02', 'password02', '강감찬', '010-1234-2000', 'user02@work.com', '2021-01-05', 'G', '950000', null);
insert into member values('user03', 'password03', '이순신', '010-1234-3000', 'user03@work.com', '2020-11-15', 'S', null, '강동원');
insert into member values('user04', 'password04', '김유신', '010-1234-4000', 'user04@work.com', '2021-01-05', 'S', null, '김하린');
insert into member values('administrator', 'admin1004', '유관순', '010-1234-5000', 'administrator@work.com', '2020-04-01', 'A', null, null);

commit;

-- 전체 회원조회
select * from member;

-- 등급별 전제회원 조회
select * from member where grade = 'G';

-- 회원상세조회 
select * from member where member_id = 'user01';

-- 로그인(아이디, 비번) : ?? 등급, *, 등급 + 이름
select * from member where member_id = 'user01' and member_pw = 'password01';
select grade from member where member_id = 'user01' and member_pw = 'password01';

-- 아이디찾기
select member_id from member where name = '홍길동' and mobile = '010-1234-1000';

-- 비번찾기
select member_pw from member where member_id = 'user01' and name = '홍길동' and mobile = '010-1234-1000';

-- 비밀번호변경
update member set member_pw = 'modify_password02' where member_id = 'user02' and member_pw = 'password02'; 
select * from member where member_id = 'user02';

-- 회원전체정보변경
-- 내정보(사용자) :
-- 변경가능컬럼 : 비밀번호, 이름, 휴대혼, 이메일
-- 변경불가컬럼 : 아이디, 마일리지, 가입일, 담당자
update member set member_pw = 'happy02', name = '김철수' where member_id = 'user02'; 

-- 관리자 : 모든 회원들의 정보를 제어 권한
-- 변경가능컬럼 : 비밀번호, 이름, 휴대혼, 이메일, 마일리지, 가입일, 담당자
-- 변경불가컬럼 : 아이디

-- 우수회원등업
update member 
set mileage=0, grade = 'S', manager='담당자이름'
where member_id = 'user02' and grade='G' and mileage >= 100000; 

-- 1. select, 2. update
select member_id from member where grade='G' and mileage >= 100000;
update member mileage=0, grade = 'S', manager='담당자이름' where member_id = 'user02';
