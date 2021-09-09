package com.work.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.work.model.dto.Member;

/**
 * 회원테이블에 대한 Dao 클래스
 * -- CRUD
 * -- 회원등록, 조회, 전체조회, 변경, 삭제
 *
 */
public class MemberDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private String user = "hr";
	private String password = "tiger";
	
	
	/* 전체회원조회
	 *  1. 드라이버 로딩 =>  ClassNotFoundException 
	 *  
		2. DB 서버연결  => Jdbc관련 SQLException
		3. SQL 통로개설
		4. SQL수행요청  => 주의사항 : sql 구문 맨뒤에 ;(세미콜론) 표기해서는 안됨******
		5. 결과처리
		
		6. 자원해제 => 무조건!!, SQLException
	 */
	public ArrayList<Member> selectList() {
		// 회원들의 정보를 담을 자료저장구조 객체 선언 및 생성
		ArrayList<Member> list = new ArrayList<Member>();
		
		// 1. 드라이버 로딩 => ClassNotFoundException
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 2. DB 서버연결 
		Connection conn = null;
		// 3. SQL 통로개설 : 동적 SQL 수행 
		Statement stmt = null;
		// 4. SQL수행요청
		ResultSet rs = null;	
		
		try {
			conn = DriverManager.getConnection(url, user, password);  // 2
			stmt = conn.createStatement();  // 3
			rs = stmt.executeQuery("select * from member");  // 4
			while(rs.next()) {  // 5. 결과처리
				Member dto = new Member();  // 기본생성자
				dto.setMemberId(rs.getString("member_id"));
				dto.setMemberPw(rs.getString("member_pw"));
				dto.setName(rs.getString("name"));
				dto.setMobile(rs.getString("mobile"));
				dto.setEmail(rs.getString("email"));
				dto.setEntryDate(rs.getString("entry_date"));
				dto.setGrade(rs.getString("grade"));
				dto.setMileage(rs.getInt("mileage"));
				dto.setManager(rs.getString("manager"));
				
				// 생성한 회원객체를 ArrayList에 추가
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 자원해제
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	// 회원상세조회(아이디) 회원
	// "'" + 아규먼트데이터 + "'" => 데이터 앞뒤에 sql 구문의 문자열을 위해서 '(단일 인용부호)를 부가해야하는 불편함이 있음
	public Member selectOne(String memberId) {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 2. DB 서버연결 
		Connection conn = null;
		// 3. SQL 통로개설 : 동적 SQL 수행 
		Statement stmt = null;
		// 4. SQL수행요청
		ResultSet rs = null;	
		
		try {
			conn = DriverManager.getConnection(url, user, password);  // 2
			stmt = conn.createStatement();  // 3
			String sql = "select * from member where member_id = '" + memberId + "'";
			rs = stmt.executeQuery(sql);  // 4
			if(rs.next()) {  // 5. 결과처리
				Member dto = new Member();  // 기본생성자
				dto.setMemberId(rs.getString("member_id"));
				dto.setMemberPw(rs.getString("member_pw"));
				dto.setName(rs.getString("name"));
				dto.setMobile(rs.getString("mobile"));
				dto.setEmail(rs.getString("email"));
				dto.setEntryDate(rs.getString("entry_date"));
				dto.setGrade(rs.getString("grade"));
				dto.setMileage(rs.getInt("mileage"));
				dto.setManager(rs.getString("manager"));
				
				return dto;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 자원해제
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	* "비밀번호 변경"
	* 아규먼트 : 아이디, 기존비번, 변경비번
	* 반환타입:
	* => 성공 1, 실패 0
	* => 
	*/
	
	public int updateMemberPw(String memberId, String memberPw, String modifyMemberPw) {
		// 1. 드라이버 로딩 => ClassNotFoundException
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2. DB 서버연결
		Connection conn = null;
		// 3. SQL 통로개설 : 동적 SQL 수행
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(url, user, password); // 2
			String sql = "update member set member_pw = ? where member_id = ? and member_pw = ?";
			stmt = conn.prepareStatement(sql); // 3. 전용통로 개설시 sql 구문을 전달
			stmt.setString(1, modifyMemberPw);   //미완성의 통로이므로 반드시 매핑되는 순서대로 값을 설정,순서/개수/인덱스번호는 1부터시작
			stmt.setString(2, memberId);
			stmt.setString(3, memberPw);
			return stmt.executeUpdate(); //전용통로이므로 실행시에 sql 아규먼트 지정금지(**중요*)
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 자원해제
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	
	// 회원등록 
	public int insertMember(Member dto) {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2. DB 서버연결
		Connection conn = null;
		// 3. SQL 통로개설 : 동적 SQL 수행
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			String sql = "insert into member values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dto.getMemberId());
			stmt.setString(2, dto.getMemberPw());
			stmt.setString(3, dto.getName());
			stmt.setString(4, dto.getMobile());
			stmt.setString(5, dto.getEmail());
			stmt.setString(6, dto.getEntryDate());
			stmt.setString(7, dto.getGrade());
			stmt.setInt(8, dto.getMileage());
			stmt.setString(9, dto.getManager());

			return stmt.executeUpdate(); //전용통로이므로 실행시에 sql 아규먼트 지정금지(**중요*)
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 자원해제
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	return 0;	
	}

	// 아이디 존재유무
	// 메서드 이름
	// 아규먼트
	// 반환타입
	// 메서드 선언 및 코드 구현
	public boolean existMemberId(String memberId) {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			String sql = "select 1 from member where member_id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberId);
			
			rs = stmt.executeQuery();   // sql 아규먼트로 쓰기 절.대.금.ㅈ!!!!
			
			return rs.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	return false;
	}

	
	/**
	 * 로그인
	 * @param memberId
	 * @param memberPw
	 * @return 성공시 해당회원 등급, 실패시 null
	 */
	public String login(String memberId, String memberPw) {
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			String sql = "select grade from member where member_id = ? and member_pw = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberId);
			stmt.setString(2, memberPw);
			
			rs = stmt.executeQuery();   // sql 아규먼트로 쓰기 절.대.금.ㅈ!!!!
			if (rs.next()) {
				return rs.getString("grade");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	return null;
	}
	
}
