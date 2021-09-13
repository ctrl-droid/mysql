package com.work.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.work.model.dto.Qna;

/** 
 * <pre>
 * Q&A 테이블에 대한 DAO 클래스 
 * -- CRUD
 * -- Q&A등록, 조회(회원), 전체조회(관리자), 변경, 삭제
 * </pre>
 * @author 박예빈
 * @see com.work.model.dto.Qna
 * @see com.work.model.service.MemberService
 */
public class QnaDao {
	/** jdbc driver */
	private String driver = "oracle.jdbc.driver.OracleDriver";
	/** oracle db server */
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	/** oracle account user */
	private String user = "hr";
	/** oracle account password */
	private String password = "tiger";
	
	/**
	 * 신규 Q&A 등록
	 * @param dto 도서객체
	 * @return 성공시 1, 실패시 0
	 */
	public int insertQna(Qna dto) {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = "INSERT INTO qna VALUES(qna_no.nextval, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dto.getQnaWriter());
			stmt.setString(2, dto.getQnaTime());
			stmt.setString(3, dto.getQnaQuestion());
			stmt.setString(4, dto.getQnaAnswer());
			
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
		
		} return 0;
	}
	
	
	/**
	 * 전체 Q&A 목록 조회 (관리자용)
	 * @return Q&A 리스트
	 */
	public ArrayList<Qna> selectList() {
		ArrayList<Qna> list = new ArrayList<Qna>();
		
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
			rs = stmt.executeQuery("SELECT * FROM qna");	
			
			while(rs.next()) {	
				Qna dto = new Qna(); 
				dto.setQunNo(rs.getInt("qna_no"));
				dto.setQnaWriter(rs.getString("qna_writer"));
				dto.setQnaTime(rs.getString("qna_time"));
				dto.setQnaQuestion(rs.getString("qna_question"));
				dto.setQnaAnswer(rs.getString("qna_answer"));
				
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
	 * qna 상세조회 (회원 본인이 쓴 내용 상세조회)
	 * @param bookName
	 * @return 해당book객체, 미존재시 null
	 */
	public Qna selectOne(String qnaWriter) {
		
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
			
			String sql = "SELECT * FROM qna WHERE qna_writer = ?";
			stmt = conn.prepareStatement(sql);	
			stmt.setString(1, qnaWriter); 
			rs = stmt.executeQuery(sql);	
			
			if(rs.next()) {	
				Qna dto = new Qna(); 
				dto.setQunNo(rs.getInt("qna_no"));
				dto.setQnaWriter(rs.getString("qna_writer"));
				dto.setQnaTime(rs.getString("qna_time"));
				dto.setQnaQuestion(rs.getString("qna_question"));
				dto.setQnaAnswer(rs.getString("qna_answer"));
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
	 * qna 수정
	 * @param qnaNo
	 * @param qnaWriter
	 * @param modifyQnaQuestion
	 * @return 성공시 1, 실패시 0
	 */
	public int updateQna(int qnaNo, String qnaWriter, String modifyQnaQuestion) {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = "UPDATE qna SET qna_question = ? WHERE qna_no = ? and qna_writer=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, modifyQnaQuestion);
			stmt.setInt(2, qnaNo);
			stmt.setString(3, qnaWriter);

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
	 * qna 삭제
	 * @param bookNo
	 * @return 성공시 1, 실패시 0
	 */
	public int deleteQna(int qnaNo, String qnaWriter) {
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password); 
			
			String sql = "delete from qna where qna_no = ? and qna_writer = ?";
			stmt = conn.prepareStatement(sql);	
			stmt.setInt(1, qnaNo); 
			stmt.setString(2, qnaWriter);

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
