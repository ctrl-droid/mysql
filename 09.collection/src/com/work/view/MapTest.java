package com.work.view;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.work.model.dto.Member;

/**
 * ## Map 계열 CRUD 메서드 => HashMap
    => KEY:VALUE
    
	1) 등록 또는 변경  
	 => put(String key, Object value) : Object
	 => 동일한 키가 존재하지 않으면 등록
	 => 동일한 키가 존재하면 변경
	 
	2) 조회 => 전체조회는 모든 객체들의 key를 알아야만 가능
	 => get(Object key) : Object  
	 
	3) 삭제 
	 => remove(Object key): Object
	 
	4) key 목록만 조회  => 전제조회시 필요
	 => keySet() : Set
	 => Set#iterator() : Iterator => hasNext(), next() => KEY
 */
public class MapTest {

	public static void main(String[] args) {
		print("초기회원 5명 회원객체 생성");
		Member dto1 = new Member("user01", "password01", "홍길동");
		Member dto2 = new Member("user02", "password02", "유관순");
		Member dto3 = new Member("user03", "password03", "강감찬");
		Member dto4 = new Member("user04", "password04", "김유신");
		Member dto5 = new Member("user05", "password05", "홍길자");

		HashMap map = new HashMap();
		
		print("회원등록: 회원을 식별하기 위한 아아디를 키로 지정");
		map.put(dto1.getMemberId(), dto1);
		map.put(dto2.getMemberId(), dto2);
		map.put(dto3.getMemberId(), dto3);
		map.put(dto4.getMemberId(), dto4);
		map.put(dto5.getMemberId(), dto5);
		
		print("전체회원수 : " + map.size());
		
		print("회원 상세조회 : user01");
		Object obj = map.get("user01");
		if (obj != null) {
			System.out.println(obj);
		}
		
		print("회원 상세조회 : user99 미존재 회원의 아이디");
		obj = map.get("user99");
		if (obj != null) {
			System.out.println(obj);
		} else {
			print("[오류] 해당 회원의 정보를 찾을 수 없습니다.");
		}
		
		print("회원정보 전체 변경: user01, 변경비밀번호, 변경이름");
		map.put("user01", new Member("user01", "happy", "박호두"));
		
		print("회원 변경 후 상세조회: user01");
		obj = map.get("user01");
		if (obj != null) {
			System.out.println(obj);
		}
		
		print("회원 삭제: user01");
		map.remove("user01");
		
		print("회원 상세조회 : user01");
		obj = map.get("user01");
		if (obj != null) {
			System.out.println(obj);
		} else {
			print("[오류] 해당 회원의 정보를 찾을 수 없습니다.");
		}
		
		print("전체회원조회");
		// 현재 등록된 모든 객체(회원)이 키정보를 알아야먄 가능
		// get(KEY):Object
		// KEY는 unique
		// 1. map에 저장된 KEY목록을 가져오기 : keySet():Set
		Set keys = map.keySet();
		// 2. Set 담겨있는 KEY들을 단방향 검색하기위해서 Iterator 객체에 담아서 가져오기
		Iterator iterator = keys.iterator();
		// 3. Iterator에 가져온 객체만큼 반복하면서 : hasNext():boolean
		while (iterator.hasNext()) {
		// 4. Iterator에서 하나씩 가져온 객체가 map에 저장된 객체를 가져오기위한 KEY 가져오기
			String key = (String)iterator.next();
		// 5. 가져온 KEY 정보를 map에 저장되어 있는 객체를 조회하기 위한 KEY로 사용해서 map 저장된 객체 가져오기: get(KEY):Object
			Object obj2 = map.get(key);	
		// 6. map(KEY)로 가져온 객체 정보 출력
			System.out.println(obj2);
		}
	}

	public static void print(String message) {
		System.out.println("\n## " + message + " ##");
		
	}

}
