package com.work.model.dto;

/**
 * <pre>
 * 회원 정보 모델링 클래스
 * -- this
 * -- 생성자
 * -- 
 * 
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
	public Member() {
		System.out.println("회원 기본 생성자 수행");
	}
	
	public Member(String memberId, String memberPw, String name, String mobile, String email) {
	    this();
	      
	    this.memberId=memberId;
	    this.memberPw=memberPw;
	    this.name = name;
	    this.mobile = mobile;
	    this.email=email;
       //System.out.println("햇니을 출력합니다");
	}
	   
	  //실습 : 회원 모든데이터 초기화 생성자
	public Member(String memberId, String memberPw, String name, String mobile, String email,         String entryDate, String grade, int mileage, String manager) {
		// this.memberId=memberId;
		//   this.memberPw=memberPw;
	    //   this.name = name;
	    //   this.mobile = mobile;
	    //   this.email=email;
		this(memberId, memberPw, name, mobile, email);
	      
	    this.entryDate=entryDate;
	    this.grade=grade;
	    this.mileage=mileage;
	    this.manager=manager;
	    //System.out.println("햇님을 출력합니다");
	            
	    //this(memberId, memberPw, name, mobile, email); 생성자 첫번째 수행문으로 위치해야함

	}

	
	
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
	
	// 회원의 이름을 변경하는 매서드: setter() 형식 준수
	public void setName(String name){
		this.name = name;
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
