package com.work.model.dto;

/**
 * <pre>
 * 회원 정보 모델링 클래스
 * -- this
 * -- 생성자
 * -- 생성자 중복 정의
 * 
 * -- 회원 도메인 속성 제약
 * 		1. 아이디 : 필수항목, 길이 30자리
 *  	2. 비밀번호 : 필수항목, 길이 10자리
 *   	3. 마일리지 : 0 ~ 십만 이내
 * 
 * </pre>
 * 
 * @author 박호두
 * @version ver.1.0
 * @since jdk1.8
 */
 
public class Member {
	
	/** 아이디 */
	private String memberId = "Guest";
	
	/** 비밀번호 */
	private String memberPw;
	
	/** 이름 */
	private String name;
	
	/** 휴대혼 */
	private String mobile;
	
	/** 이메일 */
	private String email;
	
	/** 가입일 */
	private String entryDate;
	
	/** 등급 */
	private String grade;
	
	/** 마일리지 */
	private int mileage;
	
	/** 담당자 */
	private String manager;

	/**
	 * 기본 생성자
	 */
	public Member() {
	}

	/**
	 * <pre>
	 * 회원 등록시 사용자 입력 필수데이터 초기화 생성자
	 * </pre>
	 * @param memberId 아이디
	 * @param memberPw 비번
	 * @param name 이름
	 * @param mobile 휴대폰
	 * @param email 이메일
	 */
	public Member(String memberId, String memberPw, String name, String mobile, String email) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
	}

	/**
	 * 	 * <pre>
	 * 회원 등록시 사용자 입력 모든데이터 초기화 생성자
	 * </pre>
	 * @param memberId
	 * @param memberPw
	 * @param name
	 * @param mobile
	 * @param email
	 * @param entryDate
	 * @param grade
	 * @param mileage
	 * @param manager
	 */
	public Member(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String grade, int mileage, String manager) {
		this(memberId, memberPw, name, mobile, email);
		this.entryDate = entryDate;
		this.grade = grade;
		this.mileage = mileage;
		this.manager = manager;
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
		if (isMemberId(memberId)) {
			this.memberId = memberId.trim();  // 검증시에 공백을 제거한 후 검증, 따라서 혹시 공백이 존재한다면 
			return;
		}
		
		System.out.println("[오류] 아이디는 6자리 ~ 30자리 이내로 변경가능합니다.");
		
	}
	/* 1. 아이디: 필수항목, 길이 30자리
		아이디를 검증하는 메서드 형식만 선언
		문자열 길이 반환하는 매서드 : 문자열참조변수명.length();
		- 처리로직
		1. 아규먼트로 전달받은 아이디가 null 이 아니면
		2. 아규면트로 전달받은 아이디의 공백을 제거한 문자열의 길이를 구해서
		3. 문자열의 길이가 1 ~ 30 자리 이내인지 비교해서
		4. 범위 이내이면 true
		5. 범위를 벗어나면 false 반환
	*/
		
	public boolean isMemberId(String memberId) {
		if (memberId != null) {
			int length = memberId.trim().length(); // 아규먼트로 전달받은 아이디 공백을 제거하고 검증 => 실제 변경 아이디에는 공백이 존재할 수 있음
			if (length >= 1 && length <= 30) {
				return true;
			}

		}
		return false;
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
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the entryDate
	 */
	public String getEntryDate() {
		return entryDate;
	}

	/**
	 * @param entryDate the entryDate to set
	 */
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * @return the mileage
	 */
	public int getMileage() {
		return mileage;
	}

	/**
	 * @param mileage the mileage to set
	 */
	public void setMileage(int mileage) {
		this.mileage = mileage;
		boolean result = isMileage(mileage);  // 변수를 선언해서 여러군데에서 사용여부??
		if (result) {
			this.mileage = mileage;
		} else {
			System.out.println("[오류] 마일리지는 0 ~ 100,000 이내만 가능합니다");
		}
	}
	
	// 3. 마일리지 : 0 ~ 100000 이내
	private boolean isMileage(int mileage) {
		if(mileage >= 0 && mileage <= 100000) {
			return true;
		}
		return false;
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
		return "Member [memberId=" + memberId + ", memberPw=" + memberPw + ", name=" + name + ", mobile=" + mobile
				+ ", email=" + email + ", entryDate=" + entryDate + ", grade=" + grade + ", mileage=" + mileage
				+ ", manager=" + manager + "]";
	}

	
	
	
}
