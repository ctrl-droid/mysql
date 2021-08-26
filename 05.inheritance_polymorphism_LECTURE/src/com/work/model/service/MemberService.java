/**
 * 
 */
package com.work.model.service;

/**
 * <pre>
 * 회원 관리시스템에서 제공하기 위한 서비스 클래스
 * -- 회원 요구사항을 기반으로 제공해야하는 기능(서비스) 메서드의 형식만 분석 해보세요
 * -- 회원 관리를 위한 메서드(기능) 분석
 * -- 예시: 회원 등록, 로그인
 * 
 * </pre>
 */
public class MemberService {
	// + 회원등록기능(아이디, 비밀번호, 이름, 휴대폰, 이메일) : 반환타입
	public void addMember(String memberId, String memberPw, String name, String mobile, String email) {
		
	}
	
	// + 로그인(아이디, 비밀번호) : 반환타입
	// 로그인 성공시 해당 회원의 등급 반환
	public String login(String memberId, String memberPw) {
		return null;
	}
	
}
