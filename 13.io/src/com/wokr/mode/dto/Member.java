package com.wokr.mode.dto;

public class Member {
	private String memberId;
	private String memberPw;
	private String name;
	private int age;

	
	/**
	 * 기본생성자
	 */
	public Member() {
		
	}
	
	
	/**
	 * 전체 초기화 생성자
	 * @param memberId
	 * @param memberPw
	 * @param name
	 * @param age
	 */
	public Member(String memberId, String memberPw, String name, int age) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.name = name;
		this.age = age;
	}


	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}


	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	/**
	 * @return the memberPw
	 */
	public String getMemberPw() {
		return memberPw;
	}


	/**
	 * @param memberPw the memberPw to set
	 */
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
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
	 * @return the age
	 */
	public int getAge() {
		return age;
	}


	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(memberId);
		builder.append(", ");
		builder.append(memberPw);
		builder.append(", ");
		builder.append(name);
		builder.append(", ");
		builder.append(age);
		return builder.toString();
	}
	
	
	
	
	
	
	
}
