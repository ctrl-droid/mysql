package com.work.model.dto;

/**
 * <pre>
 * Q&A 모델링
 * </pre>
 * @author 박예빈
 * @version ver.1.0
 * @since jdk1.8
 */
public class Qna {
	/** 글번호 */
	private int qnaNo;
	/** 작성자 */
	private String qnaWriter;
	/** 작성일시 */
	private String qnaTime;
	/** 질문내용 */
	private String qnaQuestion;
	/** 답변 */
	private String qnaAnswer;

	
	
	/**
	 * 기본생성자
	 */
	public Qna() {
	}


	/**
	 * <pre>
	 * Q&A 데이터 필수 초기화 생성자
	 * </pre>
	 * @param qnaNo
	 * @param qnaWriter
	 * @param qnaQuestion
	 */
	public Qna(String qnaWriter, String qnaQuestion) {
		this.qnaWriter = qnaWriter;
		this.qnaQuestion = qnaQuestion;
	}

	
	
	/**
	 * <pre>
	 * Q&A 데이터 생성자
	 * </pre>
	 * @param qnaNo
	 * @param qnaWriter
	 * @param qnaTime
	 * @param qnaQuestion
	 */
	public Qna(int qnaNo, String qnaWriter, String qnaQuestion) {
		this(qnaWriter, qnaQuestion);
		this.qnaNo = qnaNo;

	}
	
	
	/**
	 * <pre>
	 * Q&A 데이터 생성자
	 * </pre>
	 * @param qnaNo
	 * @param qnaWriter
	 * @param qnaTime
	 * @param qnaQuestion
	 */
	public Qna(int qnaNo, String qnaWriter, String qnaTime, String qnaQuestion) {
		this(qnaWriter, qnaQuestion);
		this.qnaNo = qnaNo;
		this.qnaTime = qnaTime;
	}
	
	
	/**
	 * <pre>
	 * Q&A 데이터 초기화 생성자
	 * </pre>
	 * @param qnaNo
	 * @param qnaWriter
	 * @param qnaTime
	 * @param qnaQuestion
	 */
	public Qna(int qnaNo, String qnaWriter, String qnaTime, String qnaQuestion, String qnaAnswer) {
		this(qnaNo, qnaWriter, qnaTime, qnaQuestion);
		this.qnaAnswer = qnaAnswer;
	}


	/**
	 * @return the qnaNo
	 */
	public int getQunNo() {
		return qnaNo;
	}



	/**
	 * @param qnaNo the qnaNo to set
	 */
	public void setQunNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}



	/**
	 * @return the qnaWriter
	 */
	public String getQnaWriter() {
		return qnaWriter;
	}



	/**
	 * @param qnaWriter the qnaWriter to set
	 */
	public void setQnaWriter(String qnaWriter) {
		this.qnaWriter = qnaWriter;
	}



	/**
	 * @return the qnaTime
	 */
	public String getQnaTime() {
		return qnaTime;
	}



	/**
	 * @param qnaTime the qnaTime to set
	 */
	public void setQnaTime(String qnaTime) {
		this.qnaTime = qnaTime;
	}



	/**
	 * @return the qnaQuestion
	 */
	public String getQnaQuestion() {
		return qnaQuestion;
	}



	/**
	 * @param qnaQuestion the qnaQuestion to set
	 */
	public void setQnaQuestion(String qnaQuestion) {
		this.qnaQuestion = qnaQuestion;
	}



	/**
	 * @return the qnaAnswer
	 */
	public String getQnaAnswer() {
		return qnaAnswer;
	}



	/**
	 * @param qnaAnswer the qnaAnswer to set
	 */
	public void setQnaAnswer(String qnaAnswer) {
		this.qnaAnswer = qnaAnswer;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(qnaNo);
		builder.append(", ");
		builder.append(qnaWriter);
		builder.append(", ");
		builder.append(qnaTime);
		builder.append(", ");
		builder.append(qnaQuestion);
		builder.append(", ");
		builder.append(qnaAnswer);
		return builder.toString();
	}
	
	
	
	
	
	

}
