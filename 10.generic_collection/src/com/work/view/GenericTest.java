package com.work.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.work.model.dto.Member;

public class GenericTest {

	public static void main(String[] args) {
		print("초기회원 5명 회원객체 생성");
		
		Member dto1 = new Member("user01", "password01", "홍길동");
		Member dto2 = new Member("user02", "password02", "유관순");
		Member dto3 = new Member("user03", "password03", "강감찬");
		Member dto4 = new Member("user04", "password04", "김유신");
		Member dto5 = new Member("user05", "password05", "홍길자");

		print("List Generic");
		ArrayList<Member> list = new ArrayList<Member>();
		
		print("등록");
		list.add(dto1);
		list.add(dto2);
		list.add(dto3);
		list.add(dto4);
		list.add(dto5);
		
		// 컴파일 오류 발생 : Member 클래스가 아니면 저장되지 않음
		// list.add("hello");
		
		print("등록회원 아이디, 이름 정보 출력");
		for (int index = 0; index < list.size(); index++) {
			Member dto = list.get(index);
			System.out.println(dto.getMemberId() + ", " + dto.getName());
		}
		
		print("Map Generic");
		// 회원들만을 위한 Map 객체 생성
		// Key(String) = Value(Member)
		HashMap<String, Member> map = new HashMap<String, Member>();
		
		print("map 회원등록");
		map.put(dto1.getMemberId(), dto1);
		map.put(dto2.getMemberId(), dto2);
		map.put(dto3.getMemberId(), dto3);
		map.put(dto4.getMemberId(), dto4);
		map.put(dto5.getMemberId(), dto5);
		
		print("map 전체회원조회: 아이디, 이름");
		// 현재 등록된 모든 객체(회원)이 키정보를 알아야먄 가능
		// get(KEY):Object
		// KEY는 unique
		// 1. map에 저장된 KEY목록을 가져오기 : keySet():Set
		// 2. Set 담겨있는 KEY들을 단방향 검색하기위해서 Iterator 객체에 담아서 가져오기
		// 3. Iterator에 가져온 객체만큼 반복하면서 : hasNext():boolean
		// 4. Iterator에서 하나씩 가져온 객체가 map에 저장된 객체를 가져오기위한 KEY 가져오기
		// 5. 가져온 KEY 정보를 map에 저장되어 있는 객체를 조회하기 위한 KEY로 사용해서 map 저장된 객체 가져오기: get(KEY):Object
		// 6. map(KEY)로 가져온 객체 정보 출력
		Set<String> keys = map.keySet();
		Iterator<String> iterator = keys.iterator();
		while (iterator.hasNext()) {
			String key = (String)iterator.next();  // 캐스팅 필요없음
			Member member = map.get(key);  // 캐스팅 필요없음
			System.out.println(member.getMemberId() + ", " + member.getName());
		}
		System.out.println();
	
		// set : 인터페이스 hashset: set을 상속받은 자식 클래스
		// 실습:
		// map에 저장된 회원들의 이름정보만을 가져와서 Set에 등록해서,set에 등록된 회원들의 전체이름 출력
		// 1.map에 저장된 회원들의 이름을 저장하기 위한 Set 객체생성
		// 2.생성한 set 객체서 map 저장된 객체의 이름 가져와서 추가하기
		// 3.set에 저장된 이름 단방향 검색위한 객체 가져오기
		// 4.단방향 객체에 저장된 회원의 이름정보 출력하기
		print("[실습] Generic 활용해서 map에 저장된 회원들의 이름을 중복제거(Set)하고 목록조회");
		//1.
		HashSet<String> memberNamesSet = new HashSet<String>();
		
		//2.
		keys = map.keySet();
		iterator = keys.iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();	//캐스팅 필요없음_아까 남탕 여탕이랑 관련이 있나?
			Member member = map.get(key);	//캐스팅 필요없음
			memberNamesSet.add(member.getName());
		}
		
		//3.
		iterator = memberNamesSet.iterator();
		
		//4.
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	
	}

	
	public static void print(String message) {
		System.out.println("\n## " + message + " ##");
		
	}
	
}
