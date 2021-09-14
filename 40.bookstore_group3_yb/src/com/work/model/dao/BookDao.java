package com.work.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.work.model.dto.Book;

/** 
 * <pre>
 * 도서테이블에 대한 DAO 클래스 
 * -- CRUD
 * -- 도서등록, 조회(도서명,저자,출판사,장르), 전제조회, 변경, 삭제
 * </pre>
 * @author 박예빈
 * @see com.work.model.dto.Book
 * @see com.work.model.service.MemberService
 */
public class BookDao {
	/** jdbc driver */
	private String driver = "oracle.jdbc.driver.OracleDriver";
	/** oracle db server */
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	/** oracle account user */
	private String user = "hr";
	/** oracle account password */
	private String password = "tiger";
	
	/**
	 * 신규 도서 등록
	 * @param dto 도서객체
	 * @return 성공시 1, 실패시 0
	 */
	public int insertBook(String bookTitle, String bookWriter, String publisher, String genre, int price, int amount) {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = "INSERT INTO book VALUES(book_no.nextval, ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, bookTitle);
			stmt.setString(2, bookWriter);
			stmt.setString(3, publisher);
			stmt.setString(4, genre);
			stmt.setInt(5, price);
			stmt.setInt(6, amount);

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
	 * 전체 도서목록 조회
	 * @return 도서리스트
	 */
	public ArrayList<Book> selectList() {
		ArrayList<Book> list = new ArrayList<Book>();
		
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
			rs = stmt.executeQuery("SELECT * FROM Book");	
			
			while(rs.next()) {	
				Book dto = new Book(); 
				dto.setBookNo(rs.getInt("book_no"));
				dto.setBookName(rs.getString("book_name"));
				dto.setBookWriter(rs.getString("book_writer"));
				dto.setBookPublisher(rs.getString("book_publisher"));
				dto.setGenre(rs.getString("genre"));
				dto.setPirce(rs.getInt("price"));
				dto.setAmount(rs.getInt("amount"));
				
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
	 * 도서 상세조회 (도서명으로 검색)
	 * @param bookName
	 * @return 해당book객체, 미존재시 null
	 */
	public Book selectOne(String bookName) {
		
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
			
			String sql = "SELECT * FROM book WHERE book_name = ?";
			stmt = conn.prepareStatement(sql);	
			stmt.setString(1, bookName); 
			rs = stmt.executeQuery(sql);	
			
			if(rs.next()) {	
				Book dto = new Book(); 
				dto.setBookNo(rs.getInt("book_no"));
				dto.setBookName(rs.getString("book_name"));
				dto.setBookWriter(rs.getString("book_writer"));
				dto.setBookPublisher(rs.getString("book_publisher"));
				dto.setGenre(rs.getString("genre"));
				dto.setPirce(rs.getInt("price"));
				dto.setAmount(rs.getInt("amount"));
				
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
	 * 도서목록 내 도서번호 검색
	 * @param bookNo 도서번호
	 * @return 존재하면 true, 없으면 false
	 */
	public boolean existBookNo(int bookNo) {
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
			String sql = "SELECT 1 FROM BOOK WHERE BOOK_NO = ?";
			stmt = conn.prepareStatement(sql);	
			stmt.setInt(1, bookNo);
			
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
	 * 도서 수정
	 * @param bookNo
	 * @param modifyAmount
	 * @return 성공시 1, 실패시 0
	 */
	public int updateBook(int bookNo, String bookTitle, String bookWriter, 
			String publisher, String genre, int price, int amount) {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(url, user, password);
			String sql = "UPDATE BOOK SET book_title = ?, book_Writer = ?, publisher = ?, genre = ?, price = ?, amount = ? WHERE book_no = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, bookTitle);
			stmt.setString(2, bookWriter);
			stmt.setString(3, publisher);
			stmt.setString(4, genre);
			stmt.setInt(5, price);
			stmt.setInt(6, amount);
			stmt.setInt(7, bookNo);
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
	 * 도서 삭제
	 * @param bookNo
	 * @return 성공시 1, 실패시 0
	 */
	public int deleteBook(int bookNo) {
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password); 
			
			String sql = "delete from book where book_no = ?";
			stmt = conn.prepareStatement(sql);	
			stmt.setInt(1, bookNo);  

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