/**
 * 
 */
package com.work.model.dto;

/**
 * 우수회원
 *
 */
public class SpecialMember extends Member {
	/** 우수회원 담당자 */ 
	private String manager;
	
	/** 기본 생성자 */
	public SpecialMember() {
	}

	/**
	 * <pre>
	 * 회원가입시 사용자 입력 필수데이터 초기화 생성자 : 아이디, 비밀번호, 이름, 휴대폰, 이메일
	 * </pre>
	 * @param memberId
	 * @param memberPw
	 * @param name
	 * @param mobile
	 * @param email
	 */
	public SpecialMember(String memberId, String memberPw, String name, String mobile, String email) {
		super(memberId, memberPw, name, mobile, email);
	}
	
	/**
	 * <pre>
	 * 필수데이터 초기화 생성자 : (아이디, 비밀번호, 이름, 휴대폰, 이메일) + 가입일,  등급
	 * </pre>
	 * @param memberId
	 * @param memberPw
	 * @param name
	 * @param mobile
	 * @param email
	 * @param entryDate
	 * @param grade
	 */
	public SpecialMember(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String grade) {
		super(memberId, memberPw, name, mobile, email, entryDate, grade);
	}

	/** 전체데이터 초기화 생성자 : (아이디, 비밀번호, 이름, 휴대폰, 이메일, 가입일, 등급) + 마일리지 */ 
	public SpecialMember(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String grade, String manager) {
		super(memberId, memberPw, name, mobile, email, entryDate, grade);
		this.manager = manager;
	}

	/**
	 * @return the manager
	 */
	public String getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(String manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return super.toString() + ", " + manager;
	}

}
