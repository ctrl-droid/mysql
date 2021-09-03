package com.work.view;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import com.work.model.dto.Member;

/*
 * ## Set 계열 CRUD 메서드 => HashSet
	 1) 등록 => add(Object obj) : boolean
	 4) 삭제 => remove(Object) : boolean
	 5) 크기 => size() : int

	 2) 조회 => ?
	 3) 변경 => ?
			 
	 6) 기타 메서드	:
		전체 저장객체 삭제 => clear() : void
		저장객체 단방향 검색 => iterator() : Iterator
 */

public class SetTest {

	public static void main(String[] args) {
		print("초기회원 5명 회원객체 생성");
		Member dto1 = new Member("user01", "password01", "홍길동");
		Member dto2 = new Member("user02", "password02", "유관순");
		Member dto3 = new Member("user03", "password03", "강감찬");
		Member dto4 = new Member("user04", "password04", "김유신");
		Member dto5 = new Member("user05", "password05", "홍길자");
		
		HashSet set = new HashSet();
		
		print("회원등록");
		set.add(dto1);
		set.add(dto2);
		set.add(dto3);
		set.add(dto4);
		set.add(dto5);
		
		
		print("등록회원수 : " + set.size());
		
		
		print("회원삭제: user01");
		set.remove(new Member("user01", "xxx", "ccc"));  //같은 객체 삭제 기준은 equals(), 즉, memberId가 같으면 삭제처리 
		
		
		print("회원삭제: user02");
		Member dto = new Member();  // 이렇게 불편하게 객체삭제 해야돼?
		dto.setMemberId("user02");  // 생성자 중복정의 => Member(String memberId){}
		set.remove(dto);
		
		
		print("등록회원수 : " + set.size());
		
		
		print("단방향 검색 : 전체조회");
		Iterator iterator = set.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		
		/**
		 * 1. iterator에 객체가 있을때까지 반복하면서
		 * 2. 순서대로 객체를 가져와서 : Object
		 * 3. 가져온 객체의 반환타입이 Object 이므로 Member 객체의 instanceof 인지 배교해서
		 * 4. Member 객체의 instanceof 이면 Member 객체타입으로 캐스팅(형변환하면서)
		 * 5. 혀변환 회원객체의 아이디가 "user03" 인지 비교해서
		 * 6. 아이디가 "user03"이면 해당 객체가 조회하는 객체이므로 출력
		 */
		print("단방향 검색 : 상세 조회 : user03");
		boolean isFind = false;
		iterator = set.iterator(); // 이미 eof까지 내려가있기 때문에 다시 iterator 가져오기
		while (iterator.hasNext()) {
			Object obj = iterator.next();
			if (obj instanceof Member) {
				Member member = (Member)obj;
				if (member.getMemberId().equals("user03")) {
					isFind = true;
					System.out.println(member);
				}
			}
		}
		
		if (!isFind) {
			print("[오류] user03 회원정보가 존재하지 않음");
		}
		
		
		print("단방향 검색 : 삭제 : user03");
		iterator = set.iterator();
		isFind = false;
		while (iterator.hasNext()) {
			Object obj1 = iterator.next();
			if (obj1 instanceof Member) {
				Member member = (Member)obj1;
				if (member.getMemberId().equals("user03")) {
//					set.remove(obj1);
					iterator.remove();
					isFind = true;
					print("삭제 완료");
				}
			}
		}
		if (!isFind) {
			print("[오류] user03 회원정보가 존재하지 않음");
		}
		
		
		print("단방향 검색 : 삭제 후 전체조회");
		iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		
		
	}
	
	public static void main1(String[] args) {
		HashSet set = new HashSet();
		
		print("등록");
		System.out.println(set.add("hello"));
		System.out.println(set.add("hello"));
		System.out.println(set.add("hello"));
		System.out.println(set.add(1004));
		System.out.println(set.add(new Integer("1004")));
		System.out.println(set.add(new Date()));
		System.out.println(set.add(new Member("user01", "aaa", "bbb")));
		System.out.println(set.add(new Member("user02", "aaa", "bbb")));
		System.out.println(set.add(new Member("user01", "aaa", "bbb")));
		
		print("등록 객체 숫자 : " + set.size());
		
		print("삭제");
		System.out.println(set.remove("hello"));
		System.out.println(set.remove("HELLO"));
		System.out.println(set.remove(1004));
		System.out.println(set.remove(new Member("user01", "aaa", "bbb")));
		
		print("등록 객체 숫자 : " + set.size());
	}
	
	public static void print(String message) {
		System.out.println("\n##" + message + "##");
	}

}
