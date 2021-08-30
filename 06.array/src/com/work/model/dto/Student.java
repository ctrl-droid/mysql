package com.work.model.dto;

/**
 * 학생 도메인 클래스
 * -- 속성 목록
 * 1. 번호
 * 2. 이름
 * 3. 성적
 * 
 * -- 적용기술 : 캡슐화, 기본생성사(), 필수생성자(), 전체생성자(), [toString]
 * 
 * @date 2021. 8. 30.
 * @version 1.0
 */

public class Student {
	private int no;
	private String name;
	private int score;
	
	public Student() {
	}

	
	/**
	 * @param no
	 * @param name
	 */
	public Student(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	
	/**
	 * @param no
	 * @param name
	 * @param score
	 */
	public Student(int no, String name, int score) {
		this(no, name);
		this.score = score;
	}

	/**
	 * @return the no
	 */
	public int getNo() {
		return no;
	}

	/**
	 * @param no the no to set
	 */
	public void setNo(int no) {
		this.no = no;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}


	@Override
	public String toString() {
		return no + ", " + name + ", " + score;
	}
	
	
}
