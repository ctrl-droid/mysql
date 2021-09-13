package com.work.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.work.model.dto.Member;

/** 
 * <pre>
 * 회원테이블에 대한 DAO 클래스 
 * -- CRUD
 * -- 회원등록, 조회, 전제조회, 변경, 삭제
 * </pre>
 * @author 박예빈
 * @see com.work.model.dto.Member
 * @see com.work.model.service.MemberService
 */
public class MemberDao {
	/** jdbc driver */
	private String driver = "oracle.jdbc.driver.OracleDriver";
	/** oracle db server */
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	/** oracle account user */
	private String user = "hr";
	/** oracle account password */
	private String password = "tiger";

	
	/**
	 * 회원 등록
	 * @param dto 회원객체
	 * @return 성공시 1, 실패시 0
	 */
	public int insertMember(Member dto) {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = null;
			
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = "INSERT INTO MEMBER VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dto.getMemberId());
			stmt.setString(2, dto.getMemberPw());
			stmt.setString(3, dto.getName());
			stmt.setString(4, dto.getMobile());
			stmt.setString(5, dto.getEmail());
			stmt.setString(6, dto.getEntryDate());
			stmt.setString(7, dto.getGrade());
			stmt.setInt(8, dto.getMileage());
			
			return stmt.executeUpdate();
			
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return 0;
	}	
	
	/**
	 * 전체회원조회
	 * @return 회원리스트
	 */
	public ArrayList<Member> selectList() {
		ArrayList<Member> list = new ArrayList<Member>();
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password); 
			stmt = conn.createStatement();	
			rs = stmt.executeQuery("SELECT * FROM MEMBER");	
			
			while(rs.next()) {	
				Member dto = new Member(); 
				dto.setMemberId(rs.getString("member_id"));
				dto.setMemberPw(rs.getString("member_pw"));
				dto.setName(rs.getString("name"));
				dto.setMobile(rs.getString("mobile"));
				dto.setEmail(rs.getString("email"));
				dto.setEntryDate(rs.getString("entry_date"));
				dto.setGrade(rs.getString("grade"));
				dto.setMileage(rs.getInt("mileage"));
				
				list.add(dto);
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

		return list;
	}
	
	/**
	 * 회원상세조회(아이디):회원
	 * @param memberId 아이디
	 * @return 회원객체, 미존재시 null
	 */
	public Member selectOne(String memberId) {
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password); 
			stmt = conn.createStatement();	
			
			String sql = "SELECT * FROM MEMBER WHERE member_id = '" + memberId + "'";
			rs = stmt.executeQuery(sql);	
			
			if(rs.next()) {	
				Member dto = new Member(); 
				dto.setMemberId(rs.getString("member_id"));
				dto.setMemberPw(rs.getString("member_pw"));
				dto.setName(rs.getString("name"));
				dto.setMobile(rs.getString("mobile"));
				dto.setEmail(rs.getString("email"));
				dto.setEntryDate(rs.getString("entry_date"));
				dto.setGrade(rs.getString("grade"));
				dto.setMileage(rs.getInt("mileage"));
				
				return dto;
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
	
	/**
	 * 등급별 전체회원 조회
	 * @param gade 등급
	 * @return 등급회원 리스트
	 */
	public ArrayList<Member> selectList(String gade) {
		ArrayList<Member> list = new ArrayList<Member>();
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password); 
			stmt = conn.createStatement();	
			
			String sql = "SELECT * FROM MEMBER WHERE grade = '" + gade + "'";
			rs = stmt.executeQuery(sql);	
			
			while(rs.next()) {	
				Member dto = new Member(); 
				dto.setMemberId(rs.getString("member_id"));
				dto.setMemberPw(rs.getString("member_pw"));
				dto.setName(rs.getString("name"));
				dto.setMobile(rs.getString("mobile"));
				dto.setEmail(rs.getString("email"));
				dto.setEntryDate(rs.getString("entry_date"));
				dto.setGrade(rs.getString("grade"));
				dto.setMileage(rs.getInt("mileage"));
				
				list.add(dto);
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

		return list;
	}	
	
	
	/**
	 * 비밀번호 변경
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @param modifyMemberPw 변경비밀번호
	 * @return 성공시 1, 실패시 0
	 */
	public int updateMemberPw(String memberId, String memberPw, String modifyMemberPw) {
	
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password); 
			
			String sql = "UPDATE MEMBER SET member_pw = ? WHERE member_id = ? AND member_pw = ?";
			stmt = conn.prepareStatement(sql);	
			stmt.setString(1, modifyMemberPw);  
			stmt.setString(2, memberId);
			stmt.setString(3, memberPw);
			
			return stmt.executeUpdate();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return 0;
	}


	
	/**
	 * 아이디 존재 유무 조회
	 * @param memberId 아이디
	 * @return 성공시 true, 실패시 false
	 */
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
			String sql = "SELECT 1 FROM MEMBER WHERE member_id = ?";
			stmt = conn.prepareStatement(sql);	
			stmt.setString(1, memberId);
			
			rs = stmt.executeQuery();	
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
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
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
			String sql = "select grade from member where member_id=? and member_pw=?";
			stmt = conn.prepareStatement(sql);	
			stmt.setString(1, memberId);
			stmt.setString(2, memberPw);
		
			rs = stmt.executeQuery();	
			
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
	
	/**
	 * 회원 삭제
	 * @param memberId
	 * @param memberPw
	 * @return 성공시 1, 실패시 0
	 */
	public int deleteMember(String memberId) {
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password); 
			
			String sql = "delete from member where member_id = ?";
			stmt = conn.prepareStatement(sql);	
			stmt.setString(1, memberId);  

			return stmt.executeUpdate();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return 0;
	}

}
	