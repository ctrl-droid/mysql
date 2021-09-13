package com.work.model.dto;

/**
 * <pre>
 * 판매 모델링
 * </pre>
 * @author 박예빈
 * @version ver.1.0
 * @since jdk1.8
 */
public class Sales {
	/** 주문번호 */
	private int salesNo;
	/** 도서번호 */
	private int bookNo;
	/** 구매자 */
	private String buyer;
	/** 구매수량 */
	private int salesPrice;
	/** 구매일자 */
	private String buyDate;

	
	
	/**
	 * 기본생성자
	 */
	public Sales() {
	}



	/**
	 * <pre>
	 * 데이터 초기화 생성자
	 * </pre>
	 * @param salesNo
	 * @param bookNo
	 * @param buyer
	 * @param salesPrice
	 * @param buyAmount
	 */
	public Sales(int salesNo, int bookNo, String buyer, int salesPrice, String buyDate) {
		this.salesNo = salesNo;
		this.bookNo = bookNo;
		this.buyer = buyer;
		this.salesPrice = salesPrice;
		this.buyDate = buyDate;
	}



	/**
	 * @return the salesNo
	 */
	public int getSalesNo() {
		return salesNo;
	}



	/**
	 * @param salesNo the salesNo to set
	 */
	public void setSalesNo(int salesNo) {
		this.salesNo = salesNo;
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
	 * @return the buyer
	 */
	public String getBuyer() {
		return buyer;
	}



	/**
	 * @param buyer the buyer to set
	 */
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}



	/**
	 * @return the salesPrice
	 */
	public int getSalesPrice() {
		return salesPrice;
	}



	/**
	 * @param salesPrice the salesPrice to set
	 */
	public void setSalesPrice(int salesPrice) {
		this.salesPrice = salesPrice;
	}



	/**
	 * @return the buyAmount
	 */
	public String getBuyDate() {
		return buyDate;
	}



	/**
	 * @param buyAmount the buyAmount to set
	 */
	public void setBuyAmount(String buyDate) {
		this.buyDate = buyDate;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(salesNo);
		builder.append(", ");
		builder.append(bookNo);
		builder.append(", ");
		builder.append(buyer);
		builder.append(", ");
		builder.append(salesPrice);
		builder.append(", ");
		builder.append(buyDate);
		return builder.toString();
	}


	
	
	

	
	
}
