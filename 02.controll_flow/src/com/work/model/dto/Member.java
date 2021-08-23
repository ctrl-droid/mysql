package com.work.model.dto;

/**
 * <pre>
 * 회원 정보 모델링 클래스
 * </pre>
 * 
 * @author 박호두
 * @version ver.1.0
 * @since jdk1.8
 */
 
public class Member {
	// 멤버변수 선언형식
	// [modifiers] 타입 멤버변수명 [= 명시적초기값];
	
	/** 아이디 */
	public String memberId = "Guest";
	
	/** 비밀번호 */
	public String memberPw;
	
	/** 이름 */
	public String name;
	
	/** 휴대혼 */
	public String mobile;
	
	/** 이메일 */
	public String email;
	
	/** 가입일 */
	public String entryDate;
	
	/** 등급 */
	public String grade;
	
	/** 마일리지 */
	public int mileage;
	
	/** 담당자 */
	public String manager;
	
	// [생성자]
	
	
	// 매서드

}
