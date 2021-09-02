package com.work.model.service;

import java.util.ArrayList;

import com.work.model.dto.Member;

public class MemberServiceSimple {
	/** 자동으로 확장 가능한 객체들을 저장 관리하기 위한 자료 저장구조 */
	private ArrayList list = new ArrayList();
	
	/**
	 * 현재 등록된 회원의 숫자 반환
	 * @return the count 등록된 회원 숫자
	 */
	public int getCount() {
		return list.size();
	}
	
	/**
	 * List는 순서가 존재하고, 중복을 허용하는 자료 저장구조
	 * 따라서, get(int), set(int, Object), remove(int) 조회,변경,삭제시에 저장된 위치가 필요하고
	 * 또한, 중복을 허용하는 저장구조이므로 등록전에 동일한 아이디 정보를 갖는 객체의 존재유무를 확인할 필요가 있음
	 * List의 인덱스번호를 활용하면서, 중복되지 않는 저장구조를 활용하기 위함
	 *  -- 등록 : 미존재(-1)
	 *  -- 조회, 변경, 삭제: 존재(0이상 인덱스)
	 * 아이디 존재유무(저장위치) 조회
	 * @param memberId
	 * @return 존재하면 해당 위치 인덱스 번호, 미존재 또는 null 인경우에는 -1
	 */
	public int exist(String memberId) {
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index) instanceof Member) {
				Member dto = (Member)list.get(index);
				if (dto.getMemberId().equals(memberId)) {
					return index;
				}
			}
		}
		return -1;
	}

	/**
	 * 회원 등록
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @param name 이름
	 * @return 등록 성공시 true, 실패시 false
	 */
	public boolean addMember(String memberId, String memberPw, String name) {
		//return false;
		return addMember(new Member(memberId, memberPw, name));
	}
	
	/**
	 * 회원 등록
	 * -- 동일한 아이디 존재시에 실패
	 * 
	 * @param dto 회원
	 * @return 등록 성공시 true, 실패시 false
	 */
	public boolean addMember(Member dto) {  // 회원등록(Member)
		// 존재 유무 체킹, 몇번째 저장된 위치인지 알 필요 X
		if (exist(dto.getMemberId()) == -1) {  // 아이디가 미존재하면
			return list.add(dto);  // 전달받은 회원개체 등록하고 true 반환
		}
		
		System.out.println("[중복오류] " + dto.getMemberId() + " 사용불가 아아디입니다.");
		return false;  // 아아디가 존재하면 등록 안하고 false 반환
	}
	
	/**
	 * 상세조회
	 * @param memberId 아이디
	 * @return 존재시 해당 회원, 미존재시 null
	 */
	public Member getMember(String memberId) {
		// get(int index) : Object
		int index = exist(memberId);
		if (index >= 0) {
//			Object obj = list.get(index);
//			return (Member)obj; 
			
			return (Member)list.get(index);
			// 해당 객체의 instanceof 여부 체킹하지 않고 Member 클래스로 캐스팅 반환되는 이유는?
			// public boolean addMember(Member dto) 메서드를 통해서 리스트에 회원객체를 등록시키도록 로직이 구성되어 있어서
			// Member가 아닌 객체는 절대로 등록되지 않음. 따라서 별도의 instanceof 여부 체킹 하지 않아도 됌.
		}
		System.out.println("[오류] " + memberId + " 님은 회원 정보를 찾을 수 없음.");
		return null;
	}
	
	/**
	 * 전체회원 조회
	 * @return 전체회원 리스트
	 */
	public ArrayList getMemberList() {
		return list;
	}
	
	/**
	 * 회원 정보 전체 변경
	 * -- 성공시 메세지 출력 : 000님의 변경 성공
	 * -- 실패시 메세지 출력 : 000님의 정보를 찾을 수 없습니다.
	 * @param dto 변경 회원객체
	 */
	public void setMember(Member dto) {
		// set(int index, Object obj) : Object
		int index = exist(dto.getMemberId());
		if (index >= 0) {
			list.set(index, dto);
			System.out.println(dto.getMemberId() + " 님의 정보 변경 성공");
			return;
		} 
		System.out.println("[오류] " + dto.getMemberId() + " 님은 회원 정보를 찾을 수 없음.");
	}
	
	/**
	 * 회원 삭제
	 * -- 성공시 메세지 출력 : 000님의 삭제 성공
	 * -- 실패시 메세지 출력 : 000님의 정보를 찾을 수 없습니다.
	 * @param memberId 삭제 회원 아이디
	 */
	public void removeMember(String memberId) {
		// remove(int index) : Object , remove(Object) : boolean
		for (int index = 0; index < list.size(); index++) {
			Member dto = (Member)list.get(index);
			String tempId = dto.getMemberId();
			if (tempId == memberId) {
				list.remove(index);
				System.out.println(memberId + "님의 정보가 삭제되었습니다.");
				return;
			}
			
		}
		System.out.println("[오류] " + memberId + "님의 정보를 찾을 수 없습니다.");
	}

	/**
	 * 회원 삭제
	 * -- 삭제 회원의 아이디와(존재) 비밀번호가 동일하면 탈퇴처리 : 
	 * -- 보안이슈를 위해서 기존 암호 한번더 검증
	 * 
	 * -- 성공시 메세지 출력 : 000님의 삭제 성공
	 * -- 실패시 메세지 출력 : 000님의 정보를 찾을 수 없습니다.
	 * -- 실패시 메세지 출력 : 000님의 정보가 올바르지 않습니다.
	 * 
	 * @param memberId 삭제 회원 아이디
	 * @param memberPw 삭제 회원 비밀번호
	 */
	public void removeMember(String memberId, String memberPw) {
		int index = exist(memberId);
		Member dto = (Member)list.get(index);
		String tempId = dto.getMemberId();
		String tempPw = dto.getMemberId();
		if (tempId == memberId) {
			if (tempPw == memberPw) {
				list.remove(index);
				System.out.println(memberId + "님의 정보가 삭제되었습니다.");
				return;
			}
			System.out.println("[오류] " + memberId + "님의 비밀번호가 다릅니다.");
			return;	
		}
		System.out.println("[오류] " + memberId + "님의 정보를 찾을 수 없습니다.");
	}
	
	/**
	 * 암호 변경
	 * -- 실패시 해당 실패에 따른 메세지 출력
	 * -- 실패의 경우는 고민해보세요??
	 * @param memberId 아이디
	 * @param memberPw 기존암호
	 * @param modifyMemberPw 변경암호
	 * @return 성공시 true, 실패시 false
	 */
	public boolean updateMemberPw(String memberId, String memberPw, final String modifyMemberPw) {
		int index = exist(memberId);
		Member dto = (Member)list.get(index);
		String tempId = dto.getMemberId();
		String tempPw = dto.getMemberPw();
		if (tempId.equals(memberId)) {
			if (tempPw.equals(memberPw)) { 
				list.set(index, dto);
				System.out.println(memberId + " 님의 정보 변경 성공");
				return true;
			}
			System.out.println("[비밀번호 변경오류] "+ memberId + " 님의 비밀번호가 틀렸습니다");
			return false;
		}
		System.out.println("[오류] " + memberId + " 님의 회원 정보를 찾을 수 없음.");
		return false;
	}
}




















