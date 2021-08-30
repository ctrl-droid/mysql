/**
 * 
 */
package com.work.model.service;

import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;

/**
 * <pre>
 * 회원 관리시스템에서 제공하기 위한 서비스 클래스
 * -- 회원 요구사항을 기반으로 제공해야하는 기능(서비스) 메서드의 형식만 분석 해보세요
 * -- 메서드이름?? , 반환타입??, 매개변수??
 * -- 회원 관리를 위한 메서드(기능) 분석
 * -- 예시: 회원 등록, 로그인
 * 
 * -- 회원들의 정보 저장 : 
 * 	>> 배열 자료 저장구조 활용 : 외부에 접근 불가 권한 선언(private), setter()제공하지 않음(등록메서드), getter() 제공하지않음(삭제메서드)
 * 		=> 회원 등록(C) 메서드
 * 		=> 회원 조회(R) 메서드
 * 		=> 회원 변경(U) 메서드
 * 		=> 회원 탈퇴(D) 메서드
 * 
 *  >> 크기 고정: 확장성이 없음
 *  >> 해결책: 
 *  	=> 최대한 많이 만들어 놓게 좋지 않을까요?? => 메모리 낭비?? 
 *  	=> *** 선택 : ?? 500개, 300개, 400개...??? => 배열크기를 객체 생성시에 크기 전달받아서 지정 
 *  	=> 이용기술 : 생성자(), 생성자(크기) 중복정의 활용, 생성자 역할(1. 멤버변수 초기화, 2. 선행처리 로직)
 *  
 *  	=> 배열의크기 => 최대 등록인원수 
 *  	=> 현재 등록된 인원수 정보??  
 *  	=> 부가 속성 추가 선언 
 *  		==> 현재 등록된 인원수 정보 및 다음에 등록하기위한 객체의 배열요소 인덱스번호, 
 *  		==> private, setter() 제공하지않음 => 등록메서드 사용, getter() 제공여부? 제공 => 현재 등록 인원수 조회
 *  	=> 처음에는 등록인원수 : 0, 1
 *  	=> 처음에 등록하는 회원의 배열요소의 저장 인덱스번호는 몇번?? : 0, 1 
 *  
 * 		=> 가변적 => 방이 다차면 => 더큰 방을 새로이 생성해서 => 기존방에 있는 녀석들을 새로운방으로 이동시키고 => io발생 => 속도느림
 * </pre>
 */
public class MemberService {
	/** 회원들의 자료 저장구조인 배열 회원타입의 멤버변수 선언: 다형성 : 배열명 members, 외부에서 접근불가 권한 */
	private Member[] members;
	
	/** 등록된 회원의 숫자 및 다음에 등록할 회원 배열요소의 위치 인덱스번호 */
	private int count;
	
	
	/**
	 * 기본생성자: 기본 배열의 크기 10개 지정
	 */
	public MemberService() {
		this(10);
	}
	
	/**
	 * 배열크기 전달받아서 해당 크기의 배열 생성 초기화 생성자
	 * @param length
	 */
	public MemberService(int length) {
		members = new Member[length];
	}
	
	/**
	 * 현재 등록된 회원의 숫자 반환
	 * @return the count 등록된 회원 숫자
	 */
	public int getCount() {
		return count;
	}

	
	/**
	 * 회원등록기능: 회원가입시 회원이 입력한 필수데이터 초기화생성자
	 * @param memberId
	 * @param memberPw
	 * @param name
	 * @param mobile
	 * @param email
	 */
	public void addMember(String memberId, String memberPw, String name, String mobile, String email) {
		//Member dto = new GeneralMember(memberId, memberPw, name, mobile, email);
		GeneralMember dto = new GeneralMember(memberId, memberPw, name, mobile, email);
		
		// 시스템에서 초기회원 가입시 일반회원에 대한 속성정보 추가 설정 로직: 가입일, 등급, [마일리지-> 1000]
		dto.setEntryDate("2021-08-30");
		dto.setGrade("G");
		dto.setMileage(1000); 
		// 부모타입 참조변수는 자식객체를 참조는 가능하지만, 부모타입이므로 자식의 멤버는 접근불가
		// 실제 일반회원객체타입으로 형변환을 통해서만 일반회원의 마일리지 설정 가능
		
		// 배열요소에 아규먼트로 전달받은 속성 + 시스템에서 추가한 속성정보를 갖는 일반회원객체 저장
		members[count++] = dto;		// count에 위치에 새로운 회원객체를 등록하고, 등록인원수를 +1 증가시킴
	}
	
	/**
	 * 회원등록기능
	 * @param dto 회원객체(일반회원, 우수회원, 관리자)
	 */
	public void addMember(Member dto) {	// 메서드의 아규먼트 다형성: 부모타입(모든 자식들을 아규먼트로 받을수있음)
		members[count++] = dto;
	}
	
	/**
	 * 전체조회
	 * @return 회원들이 저장된 배열 자료 저장구조
	 */
	public Member[] getMemberList() {
		//return null;
		//return members;  // 문제발생: 회원등록가능한 전체배열 반환받았기때문에 등록되지 않은 배열요소 null 출력
	
		/* 해결코드절차: ???
		  	1. 현재등록된 인원수 크기만큼의 회원타입의 배열 선언 및 생성
		  	2. 새로인 생성한 배열요소에 기존에 배열에 저장된 회원 숫자만큼 반복하면서
		  	3. 해당 요소에 참조(할당)
		  	4. 반복 작업이 완료되면 새로이 생성한 배열을 반환
		 */ 
		Member[] currentMembers = new Member[count]; // 1.
		for (int index = 0; index < count; index++) { // 2.
			currentMembers[index] = members[index];	// 3.
		}

		return currentMembers; 	// 4.
	}
	
	// 문자열 비교 메서드 : java.lang.String#equals(Object) : boolean
	
	// 회원상세조회(아이디): Member
	
	// 회원전체정보변경(Member): boolean
	
	// 회원 비밀번호변경(아이디, 기존암호, 변경암호): boolean
	
	// 회원탈퇴(아이디): boolean
	
	// + 로그인(아이디, 비밀번호) : 반환타입
	// 로그인 성공시 해당 회원의 등급 반환
	public String login(String memberId, String memberPw) {
		return null;
	}
	
	
	
}
