/**
 * 
 */
package com.work.model.dto;

import com.sun.media.sound.InvalidDataException;

/**
 * <pre>
 *	일반회원
 * </pre>
 * 
 * @see com.work.model.dto.Member
 */
public class GeneralMember extends Member { 
	// Member의 모든 멤버 자동 상속, 부모로부터 상속받은 private 멤버변수 접근 불가, public setter()/getter(), toString()
	// 현재 생성자가 한개도 정의되어 있지 않으므로 javac 자동으로 기본생성자를 제공함

	/** 일반회원 마일리지 */
	private int mileage;
	
	/** 기본 생성자 */
	public GeneralMember() {
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
	public GeneralMember(String memberId, String memberPw, String name, String mobile, String email) {
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
	public GeneralMember(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String grade) {
		super(memberId, memberPw, name, mobile, email, entryDate, grade);
	}

	/** 전체데이터 초기화 생성자 : (아이디, 비밀번호, 이름, 휴대폰, 이메일, 가입일, 등급) + 마일리지 */ 
	public GeneralMember(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String grade, int mileage) throws InvalidDataException{
		super(memberId, memberPw, name, mobile, email, entryDate, grade);
		
		if (mileage >= 0 && mileage <= 100000) {
			this.mileage = mileage;
		} else {
			throw new InvalidDataException("마일리지 범위를 벗어났습니다.[0~100000] :" + mileage);
		}
		
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
	}

	// Object => Member => 상속받은 toString() GeneralMember 자식클래스에서 부
	@Override
	public String toString() {
		return super.toString() + ", " + mileage;
		
		// memberId는 private 이기 때문에 자식이 직접 접근 불가 : 오류 => setter(), getter()
		//return getMemberId() + ", " + getMemberPw() + ", " + getName() + ", " + getMobile() + 
		//		", " + getEmail() + ", " + getEntryDate() + ", " + getGrade() + ", " + mileage; 
	}
	
}










