package com.work.model.dto;

public class Book {
	/** 도서번호 */
	private int bookNo;
	/** 도서명 */
	private String bookName;
	/** 저자 */
	private String bookWriter;
	/** 출판사 */
	private String bookPublisher;
	/** 장르 */
	private String genre;
	/** 가격 */
	private int price;
	/** 수량 */
	private int amount;
	
	
	/**
	 * 기본생성자
	 */
	public Book() {
	}


	/**
	 * <pre>
	 * 도서 데이터 초기화 생성자
	 * </pre>
	 * @param bookNo
	 * @param bookName
	 * @param bookWriter
	 * @param bookPublisher
	 * @param bookGanre
	 * @param price
	 * @param amount
	 */
	public Book(int bookNo, String bookName, String bookWriter, String bookPublisher, String genre, int price,
			int amount) {
		this.bookNo = bookNo;
		this.bookName = bookName;
		this.bookWriter = bookWriter;
		this.bookPublisher = bookPublisher;
		this.genre = genre;
		this.price = price;
		this.amount = amount;
	}


	/**
	 * @return the bookNo
	 */
	public int getBookNo() {
		return bookNo;
	}


	/**
	 * @param bookNo the bookNo to set
	 */
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}


	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}


	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	/**
	 * @return the bookWriter
	 */
	public String getBookWriter() {
		return bookWriter;
	}


	/**
	 * @param bookWriter the bookWriter to set
	 */
	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}


	/**
	 * @return the bookPublisher
	 */
	public String getBookPublisher() {
		return bookPublisher;
	}


	/**
	 * @param bookPublisher the bookPublisher to set
	 */
	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}


	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}


	/**
	 * @param bookGanre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}


	/**
	 * @return the price
	 */
	public int getPirce() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPirce(int price) {
		this.price = price;
	}


	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}


	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(bookNo);
		builder.append(", ");
		builder.append(bookName);
		builder.append(", ");
		builder.append(bookWriter);
		builder.append(", ");
		builder.append(bookPublisher);
		builder.append(", ");
		builder.append(genre);
		builder.append(", ");
		builder.append(price);
		builder.append(", ");
		builder.append(amount);
		return builder.toString();
	}
	
	

}
