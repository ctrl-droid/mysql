/*
Q.저장 프로시저를 사용하여 다음 기능을 구형하시오.
<member>
회원가입(id, pwd, name, email) -> 테이블에 insert
정보수정(id, new_pwd) -> update
내정보확인(id) -> id로 검색한 결과 출력
탈퇴(id) -> id가 동일한 행 delete

<board>
글쓰기(작성자, title, content) -> insert
글번호로검색(글번호) -> 글번호로 select하여 출력
글작성자로검색(작성자) -> 작성자로 select하여 출력
제목으로 검색(단어) - > 제목을 like 로 select하여 출력
*/

#member 관련함수 호출문
select * from member;
select * from board;

#회원가입
call mem_join('aaa', '111', 'namea', 'aaa@email.com');
call mem_join('ccc', '333', 'namec', 'ccc@email.com');
call mem_join('bbb', '222', 'nameb', 'bbb@email.com');

call mem_write('aaa', sysdate(), 'title1', 'content1');
 
#id로 회원검색
call get_member('ccc'); 
call get_member('aaa'); 

#전체검색
call get_members(); 

#수정
call edit_member('aaa', '1234');

#삭제
call del_member('ccc');