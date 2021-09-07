/**
 * 
 */
package com.work.model.service;

import java.util.ArrayList;

import com.work.exception.AlreadyExistException;
import com.work.exception.InvalidDataException;
import com.work.exception.NotFoundException;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;
import com.work.util.Utility;

/**
 * <pre>
 * 회원 관리시스템에서 제공하기 위한 서비스 클래스
 * 
 * TODO: Generic ArrayList를 자료 저장구조로 사용하여 로직 변경
 * </pre>
 * @author 작성자이름
 */
public class MemberService {
	/** 
	 * 회원들의 자료 저장구조인 Generic ArrayList 외부 접근 불가 멤버변수 선언 및 생성 
	 */
	private ArrayList<Member> list = new ArrayList<Member>();
	
	/**
	 * 현재 등록된 회원의 숫자 반환
	 * @return the count 등록된 회원 숫자
	 * @author 임경혜
	 */
	public int getCount() {
		return list.size();
	}

	/** 
	 * 아이디 존재유무(저장위치) 조회
	 * -- 조회, 변경, 삭제 : 존재하면 수행
	 * -- 등록: 존재하지 않으면 수행
	 * 
	 * @param memberId 아이디
	 * @return 존재하면 해당 위치 인덱스 번호, 미존재 또는 null 인경우에는 -1
	 */
	public int exist(String memberId) {
		if (memberId == null) {	
			return -1;
		}
		
		Member dto = null;
		for (int index = 0; index < list.size(); index++) { 
			dto = list.get(index);
			if(memberId.equals(dto.getMemberId())) {
				return index;
			}
		}
		
		return -1;
	}
	
	/**
	 * 회원 등록 : 회원 가입 입력 정보 초기화 (신규 회원: 일반회원)
	 * @author 임경혜
	 * @param memberId
	 * @param memberPw
	 * @param name
	 * @param mobile
	 * @param email
	 * @throws AlreadyExistException 아이디 존재시 예외
	 * @throws InvalidDataException 아규먼트가 null 인 경우 예외
	 */
	public void addMember(String memberId, String memberPw, String name, String mobile, String email) 
			throws AlreadyExistException, InvalidDataException {
		GeneralMember dto = new GeneralMember(memberId, memberPw, name, mobile, email);
		dto.setEntryDate(Utility.getCurrentDate());
		dto.setGrade("G");
		dto.setMileage(1000); 
		addMember(dto);
	}
	
	/**
	 * 회원등록기능
	 * @author 임경혜
	 * @param dto 회원객체(일반회원, 우수회원, 관리자)
	 * @throws AlreadyExistException 아이디 중복시 예외
	 * @throws InvalidDataException 아규먼트가 null 인 경우 예외
	 */
	public void addMember(Member dto) throws AlreadyExistException, InvalidDataException {	
		if (dto == null) {
			//throw new NullPointerException("회원아이디가 미입력되었습니다.");
			throw new InvalidDataException("등록 회원의 정보가 전달되지 않았습니다.");
		}
		
		int index = exist(dto.getMemberId());	// 아규먼트로 전달받은 데이터가 null 인경우에 NullPointerException 예외발생
		
		if (index >= 0) { // 동일한 아이디 존재 예외 발생
			//throw new AlreadyExistException();
			throw new AlreadyExistException(dto.getMemberId() + " 중복된 아이디 입니다.");
		}
		
		list.add(dto);
	}
	
	/**
	 * 전체조회
	 * @return 회원들이 저장된 저장구조
	 * @author 박용연
	 * @version 1.0
	 * @throws InvalidDataException 등록된 회원이 존재하지 않는 경우 예외
	 */
//	public ArrayList<Member> getMemberList() {
//		return list;
//	}
	
	public ArrayList<Member> getMemberList() throws InvalidDataException {
		if (list.isEmpty()) {
			throw new InvalidDataException("현재 등록된 회원이 존재하지 않습니다.");
		}
		return list;
	}
	
		
	/**
	 * 회원상세조회
	 * -- 아규먼트로 전달받은 회원의 아이디가 null 여부 체킹 : 수정
	 * @param memberId 아이디
	 * @return 존재하면 해당 회원객체, 미존재시 null
	 * @throws NotFoundException 아이디 미존재시 예외
	 */
	public Member getMember(String memberId) throws NotFoundException {		
		int index = exist(memberId);
		if (index >= 0) {
			return list.get(index);
		}
		
		throw new NotFoundException(memberId + " 정보가 존재하지 않습니다.");
	}

	
	/**
     * 회원전체정보변경
     * @author 김지훈
     * @param dto 변경 회원객체
     * @return 성공시 true, 실패시 false
     * @version 1.0
     */
    public boolean updateMember(Member dto) throws NotFoundException {
        int index = exist(dto.getMemberId());
        if (index >= 0) {
            list.set(index, dto);
            return true;
        }
        throw new NotFoundException(dto.getMemberId() + " 정보가 존재하지 않습니다.");
    }
	
    /**
     * 
     * 회원 비밀번호변경(아이디, 기존암호, 변경암호
     * 
     * @param memberId
     * @param memberPw
     * @param modifyMemberPw
     * @return 성공시 true, 실패시 false
     * @author 김지훈
     * @version 1.0 
     * @throws NotFoundException 아이디 미존재시 예외
	 * @throws InvalidDataException 기존 비밀번호가 틀린 경우 예외
     */
    public boolean updateMemberPw(String memberId, String memberPw, String modifyMemberPw) 
    		throws NotFoundException, InvalidDataException {
        int index = exist(memberId);
 
        if (index >= 0) { 
        	if (list.get(index).getMemberPw().equals(memberPw)) {
        		list.get(index).setMemberPw(modifyMemberPw);
        		return true;
        	} else {
        		throw new InvalidDataException("비밀번호가 일치하지 않습니다."); 
        	}
        	
        } 
        throw new NotFoundException(memberId + " 정보가 존재하지 않습니다."); 
    }
    

	/**
     * 회원 탈퇴
     * @param memberId 아이디
     * @return 성공 true, 실패 false
     * @author 정현아
     * @ver1.0
     * 
     */
    public boolean removeMember(String memberId) throws NotFoundException {
        int index = exist(memberId);
        if (index >= 0) {
            list.remove(index);
            System.out.println("삭제 완료");
            return true;
        }
        throw new NotFoundException(memberId + " 정보가 존재하지 않습니다.");
    }
	
	/**
	 * + 로그인(아이디, 비밀번호) : 반환타입
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @return 로그인 성공시 해당 회원의 등급 반환, 미존재 또는 비밀번호가 틀린경우 null
	 * @author 박예빈
	 * @version 1.2
	 * @throws NotFoundException 아이디 미존재시 예외
	 * @throws InvalidDataException 기존 비밀번호가 틀린 경우 예외 
	 */
//	public String login(String memberId, String memberPw) 
//			throws NotFoundException, InvalidDataException {
//		
//		int index = exist(memberId);  
//		if (index == -1) {
//			throw new NotFoundException(memberId + " 정보가 존재하지 않습니다.");
//		}
//		
//		Member dto = list.get(index);  
//		if (dto.getMemberId().equals(memberId) && dto.getMemberPw().equals(memberPw)) {
//			return dto.getGrade();
//        } else (dto.getMemberId().equals(memberId) && !dto.getMemberPw().equals(memberPw)) {   
//        	throw new InvalidDataException("비밀번호가 일치하지 않습니다."); 
//	}

	
	/**
     * <pre>
     * 일반회원의 마일리지가 100,000 이상이면 우수회원 등업처리
     * -- 우수회원이 되면 기존 마일리지는 0으로 처리하고, 담당자를 배정한다
     * </pre>
     * 
     * 등업처리
     * @param memberId 아이디
     * @return 성공시 담당자 이름, 실패시 null
     * @author 정현아
     * @version 1.1
     * @throws NotFoundException 아이디 미존재시 예외
	 * @throws InvalidDataException 해당 회원의 등급이 일반회원이 아닌경우, 일반회원인데 마일리지가 100,000 미만인 경우 예외
     */
    public String updateGrade(String memberId) 
    		throws NotFoundException, InvalidDataException {
        int index = exist(memberId);
        String manager = Utility.getRandomManger();
        if (index != -1) {
            Member dto= list.get(index);
            GeneralMember g1 = (GeneralMember)dto;
            
            if (g1.getMileage() >= 100000) {
                g1.setGrade("S");
                SpecialMember specialMember = new SpecialMember(g1.getMemberId(), g1.getMemberPw(), g1.getName(), g1.getMobile(), g1.getEmail(), g1.getEntryDate(), g1.getGrade(), manager);
                list.set(index, specialMember);
                return specialMember.getManager();
            }
        }
        throw new NotFoundException(memberId + " 정보가 존재하지 않습니다.");
    }
	
    /**
     * 
     * 아이디 찾기
     * @param name 이름
     * @param mobile 휴대폰
     * @return
     * @author 김지훈
     * @version 1.0
     * @throws InvalidDataException 해당 정보가 존재하지 않는 경우 예외
     */
    public int mobileExist(String mobile) throws NotFoundException {
        if (mobile == null) {
        	throw new NotFoundException(mobile + " 정보가 존재하지 않습니다.");
        }
        
        Member dto = null;
        for (int index = 0; index < list.size(); index++) { 
            dto = list.get(index);
            if(mobile.equals(dto.getMobile())) {
                return index;
            }
        }
        throw new NotFoundException(mobile + " 정보가 존재하지 않습니다.");
    }
    
    public String findMemberId(String name, String mobile) throws NotFoundException {
        if(mobileExist(mobile) == -1) {
            String msg = "일치하는 정보가 없음";
            return msg; 
        }
        Member dto = list.get(mobileExist(mobile)); // 해당인덱스의 정보를 가져옴
        if(dto.getName() == name) {
            return dto.getMemberId();
        }
        throw new NotFoundException(mobile + " 정보가 존재하지 않습니다.");
    }
    

	/**
     * 
     * 비밀번호 찾기
     * @author 오재욱
     * @param memberId
     * @param name
     * @param mobile
     * @return 임시비밀번호 or null
     * @version 1.0
     * @throws InvalidDataException 해당 정보가 존재하지 않는 경우 예외
     */
    
    public String findMemberPw(String memberId, String name, String mobile) throws NotFoundException {
//        String tmpMemberPw = Utility.getSecureCodeNumber(); // 기본 4자리 숫자 임시비번
//        String tmpMemberPw = Utility.getSecureCodeString(3); // 6자리 숫자 임시비번
        String tmpMemberPw = Utility.getSecureCodeNumberAndString(6); // 6자리 알파벳+숫자 임시비번
        int index = exist(memberId);
        if(index != -1) {
            Member dto = list.get(index);
            if (dto.getName().equals(name) && dto.getMobile().equals(mobile)) {
                dto.setMemberPw(tmpMemberPw);
                return tmpMemberPw;
            }
        }
        throw new NotFoundException(memberId + " 정보가 존재하지 않습니다.");
    }
}




