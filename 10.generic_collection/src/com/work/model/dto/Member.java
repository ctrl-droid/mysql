package com.work.model.dto;

import java.util.Objects;

/**
 * <pre>
 * 회원 도메인 클래스
 * -- 도메인 속성 : 아이디(memberId), 비번(memberPw), 이름(name)
 * -- encapsulation(set/get), overloading constructor, 
 * 	  Object#toString() overriding
 * </pre>
 * @author 박호두
 * @since jdk1.8
 *
 */
public class Member {
	// 도메인 속성
	/** 아아디 6자리 ~ 30자리, 식별키(not null, unique) */ 
	private String memberId;
	
	/** 비밀번호 6자리 ~ 30자리, 필수(not null) */
	private String memberPw;
	
	/** 이름 2자리 ~ 20자리, 필수(not null) */
	private String name;   
	
	
	/**
	 * 기본 생성사
	 */
	public Member() {

	}

	
	/**
	 * 전체 초기화 생성자 (overloading constructor)
	 * @param 아이디 : memberId
	 * @param 비밀번호 : memberPw
	 * @param 이름 : name
	 */
	public Member(String memberId, String memberPw, String name) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.name = name;
	}

	
	// encapsulation(set/get)
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(memberId);
		builder.append(", ");
		builder.append(memberPw);
		builder.append(", ");
		builder.append(name);
		return builder.toString();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(memberId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(memberId, other.memberId);
	}
	

	
}
