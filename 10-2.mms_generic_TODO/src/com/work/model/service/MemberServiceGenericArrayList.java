/**
 * 
 */
package com.work.model.service;

import java.util.ArrayList;

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
 */
public class MemberServiceGenericArrayList {
	/** 
	 * 회원들의 자료 저장구조인 Generic ArrayList 외부 접근 불가 멤버변수 선언 및 생성 
	 */
	private ArrayList<Member> list = new ArrayList<Member>();
	
	/**
	 * 현재 등록된 회원의 숫자 반환
	 * @return the count 등록된 회원 숫자
	 */
	public int getCount() {
		return list.size();
	}

	
	/**
	 * 회원 등록 : 회원 가입 입력 정보 초기화 (신규 회원: 일반회원)
	 * @param memberId
	 * @param memberPw
	 * @param name
	 * @param mobile
	 * @param email
	 */
	public void addMember(String memberId, String memberPw, String name, String mobile, String email) {
		GeneralMember dto = new GeneralMember(memberId, memberPw, name, mobile, email);
		// Utility 클래스 메서드 활용한 가입당시 현재날짜로 가입일 지정
		dto.setEntryDate(Utility.getCurrentDate());
		dto.setGrade("G");
		dto.setMileage(1000); 
		addMember(dto);
	}
	
	/**
     * 회원등록기능
     * @author 오재욱
     * @param dto 회원객체(일반회원, 우수회원, 관리자)
     * @version 1.0
     */
    public void addMember(Member dto) {
        if (exist(dto.getMemberId()) == -1) {
            list.add(dto);
        } else {
            System.out.println("[등록 오류] 동일한 아이디가 존재합니다. : " + dto.getMemberId());
        }
    }
	
	/**
	 * 전체조회
	 * @return 회원들이 저장된 저장구조
	 * @author 박예빈
	 * @version 1.0 
	 */
	public ArrayList<Member> getMemberList() {
		return list;
		}
	
		
	/**
	 * 회원상세조회
	 * -- 아규먼트로 전달받은 회원의 아이디가 null 여부 체킹 : 수정
	 * @param memberId 아이디
	 * @return 존재하면 해당 회원객체, 미존재시 null
	 * @author 박예빈
	 * @version 1.0 
	 */
	public Member getMember(String memberId) {		
		int index = exist(memberId);
		if (index >= 0) {	
			return list.get(index);
		} else {
		return null; 
		}
	}
	

	/** 
	 * 아이디 존재유무(저장위치) 조회
	 * -- 조회, 변경, 삭제 : 존재하면 수행
	 * -- 등록: 존재하지 않으면 수행
	 * @author 임경혜
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
     * 회원전체정보변경
     * @author 김지훈
     * @param dto 변경 회원객체
     * @return 성공시 true, 실패시 false
     * @version 1.0
     */
    public boolean updateMember(Member dto) {
        int index = exist(dto.getMemberId());
        if (index >= 0) {
            list.set(index, dto);
            return true;
        }

        return false;
    }
	
    /**
     * 
     * 회원 비밀번호변경(아이디, 기존암호, 변경암호)
     * 
     * @param memberId
     * @param memberPw
     * @param modifyMemberPw
     * @return 성공시 true, 실패시 false
     * @author 김지훈
     * @version 1.0 
     */
    public boolean updateMemberPw(String memberId, String memberPw, String modifyMemberPw) {
        int index = exist(memberId);
        if (index >= 0 && list.get(index).getMemberPw().equals(memberPw)) {
            list.get(index).setMemberPw(modifyMemberPw);
            return true;
        }
        return false;    // 아이디가 존재하지 않거나, 기존 암호가 틀린 경우

    }
	
	/**
     * 회원 탈퇴
     * @param memberId 아이디
     * @return 성공 true, 실패 false
     * @author 정현아
     * @ver1.0
     * 회원삭제와 똑같을 것 같음
     */
    public boolean removeMember(String memberId) {
        int index = exist(memberId);
        if (index >= 0) {
            list.remove(index);
            System.out.println("삭제 완료");
            return true;
        }
        return false;
    }
	
	/**
	 * + 로그인(아이디, 비밀번호) : 반환타입
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @return 로그인 성공시 해당 회원의 등급 반환, 미존재 또는 비밀번호가 틀린경우 null
	 * @author 박예빈
	 * @version 1.2
	 */
	public String login(String memberId, String memberPw) {
		int index = exist(memberId);  
		if (index == -1) {
			return null;
		}
		
		Member dto = list.get(index);  
		
//		String tempId = dto.getMemberId();  
//		String tempPw = dto.getMemberPw();  
		
		if (dto.getMemberId().equals(memberId) && dto.getMemberPw().equals(memberPw)) {
			return dto.getGrade();
			}
			// System.out.println("[오류] "+ memberId + " 님의 비밀번호가 틀립니다");
		// System.out.println("[오류] " + memberId + " 님의 회원 정보를 찾을 수 없음.");
		return null;
	}

	
	/**
     * <pre>
     * 일반회원의 마일리지가 100,000 이상이면 우수회원 등업처리
     * -- 우수회원이 되면 기존 마일리지는 0으로 처리하고, 담당자를 배정한다
     * </pre>
     * 
     * 1. 전체회원목록을 싹 훑으며, 마일리지가 100,000이상인 Member객체를 탐색.
     * 2. 100,000만이 넘는 Member정보가 나타나면, 그 정보를 Member dto(참조변수) 객체로 빼온다.
     * 3. 빼온 Member객체의 마일리지를 0으로 수정 + 담당자를 배정+우수회원으로 해준다.
     *         -문제 발생. GeneralMember.setMileage() / SpecialMember().setManager() 
     * 4. 수정된 Member 객체를 원래 자리로 다시 끼워넣기(기존의 데이터를 대체하기, list.set(index, Object obj))
     * 정보를 빼서 뚝딱뚝딱하고 다시 원래 자리로 끼워넣는다.
     * 
     * 
     * Member dto = new GeneralMember(어쩌구);
     * GeneralMember g1 = (GeneralMember) dto(아규먼트); //다운캐스팅
     * 
     * 등업처리
     * @param memberId 아이디
     * @return 성공시 담당자 이름, 실패시 null
     * @author 정현아
     * @version 1.1
     */
    public String updateGrade(String memberId) {
        int index = exist(memberId);
//        Utility utility = new Utility();  //매니저 이름을 부르는 메서드가 utility안에 있음
                                            //Utility안에서 이미 static으로 고정해놨기 때문에 182번을 주석처리하고
                                            //184를 utility->Utility
        String manager = Utility.getRandomManger();
        if (index != -1) {
            Member dto= list.get(index);
            GeneralMember g1 = (GeneralMember)dto;
//            System.out.println(g1);
            if(g1.getMileage()>=100000) {
                g1.setGrade("S");
//                dto=g1;
                SpecialMember specialMember = new SpecialMember(g1.getMemberId(), g1.getMemberPw(), g1.getName(), g1.getMobile(), g1.getEmail(), g1.getEntryDate(), g1.getGrade(), manager);
                list.set(index, specialMember);
                return specialMember.getManager();
            }
        }
        return null;
    }
	
    /**
     * 
     * 아이디 찾기
     * @param name 이름
     * @param mobile 휴대폰
     * @return
     * @author 김지훈
     * @version 1.0
     */
    public int mobileExist(String mobile) {
        if (mobile == null) {
            return -1;
        }
        Member dto = null;
        for (int index = 0; index < list.size(); index++) { 
            dto = list.get(index);
            if(mobile.equals(dto.getMobile())) {
                return index;
            }
        }
        return -1;
    }
    
    public String findMemberId(String name, String mobile) {
        if(mobileExist(mobile) == -1) {
            String msg = "일치하는 정보가 없음";
            return msg; 
        }
        Member dto = list.get(mobileExist(mobile)); // 해당인덱스의 정보를 가져옴
        if(dto.getName() == name) {
            return dto.getMemberId();
        }
        return null;
    }
    

	/**
     * 1. 아이디를 검사(입력한 아이디에 해당하는 정보가 리스트에 있는지 체크)
     * 2. 이름 검사 + 핸드폰번호 검사 => 정보가 일치해야만 임시비밀번호를 발급
     * 3. 기존에 저장된 회원정보의 비밀번호로 실제로 발급된 임시비밀번호로 변경
     * 
     * 비밀번호 찾기
     * -- 해당 정보의 회원이 존재하면 임시암호를 발급하여 발급된 암호로 기존 암호를 변경
     * -- 변경 후 임시암호를 반환
     * -- 임시암호는 Utility 메서드를 구현 활용할것
     * 
     * -- 해당 정보의 회원이 존재하지 않으면 null 반환
     * @author 오재욱
     * @param memberId
     * @param name
     * @param mobile
     * @return 임시비밀번호 or null
     * @version 1.0
     */
    
    public String findMemberPw(String memberId, String name, String mobile) {
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

        return null;
    }
}





