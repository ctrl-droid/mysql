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
	
	// 2. [생성자]
	
	
	// 3. 매서드
	// [modifiers] 반환타입 메서드명 ([매개변수타입 매개변수명, 매개변수타입 매개변수명] {}
	
	// 회원이름을 반환하는 매서드: 아규먼트 없음, 반환타입 있음
	public String getName() {
		return name;
	}
	
	// 회원의 마일리지를 변경하는 매서드: 아규먼트 있음, 반환타입 없음
	public void setMileage(int modifyMileage) {
		mileage = modifyMileage;
	}
	
	// 현재회원의 모든 정보를 출력하는 매서드: 아규먼트 없음, 반환타입 없음
	public void printMember() {
		System.out.println("아이디:"+ memberId);
		System.out.println("비밀번호:"+ memberPw);
		System.out.println("이름:"+ name);
		System.out.println("휴대폰:"+ mobile);
		System.out.println("이메일:"+ email);
		System.out.println("가입일:"+ entryDate);
		System.out.println("등급:"+ grade);
		System.out.println("마일리지:"+ mileage);
		System.out.println("담장자:"+ manager);
		System.out.println();
		
	}
	
}
