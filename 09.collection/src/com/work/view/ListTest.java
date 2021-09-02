package com.work.view;
import java.util.ArrayList;
import java.util.Date;
import com.work.model.dto.Member;
/**1. List 계열 : 순서 있음, 중복 가능
 *
 * List 계열 CRUD 메서드 => ArrayList
 1) 등록 => add(Object obj) : boolean
 2) 조회 => get(int index) : Object
 3) 변경 => set(int index, Object obj) : Object
 4) 삭제 => remove(int index) : Object , remove(Object) : boolean
 5) 크기 => size() : int
 */
public class ListTest {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		//등록 : 중복 허용, 순서 있음
		list.add("hello");
		list.add("hello");
		list.add("hello");
		list.add("hello");
		list.add("hello");
		list.add("hello");
		list.add(new Date());
		list.add(new Integer(1004));
		list.add(1004);	//자동형변환 : 기본형을 자동으로 해당 객체형으로 변환 등록
		list.add(new Member("user01", "password1", "홍길동"));
		
		//저장된 객체의 크기를 조회 출력해보세요.
		System.out.println(list.size());
		
		//조회 : 3번째 요소
		//System.out.println(list.get(int index));
		Object obj = list.get(3);
		System.out.println(obj); //해당객체.toString()
		
		//1. Member 클래스를 검색해서 출력 : toString() 재정의한 메서드 호출 사용
		//2. Member 클래스를 검색해서 회원 이름정보만을 출력 : 변경(getName())
		//if(참조변수명 instanceof 클래스명) {} 연산자를 활용
		for (int index = 0; index < list.size(); index++) {
			if(list.get(index) instanceof Member) {
				//Date, Integer, String
				//1. Member 클래스를 검색해서 출력 : toString() 재정의한 메서드 호출 사용
				System.out.println(list.get(index));	//Member#toString() 재정의한 자식객체의 재정의한 메서드로 호출
			
				//조회시에는 Object 타입이므로 instanceof 인스턴스 체크, 형변환을 해야만 자식객체의 멤버 접근 가능
				//2. Member 클래스를 검색해서 회원 이름정보만을 출력 : 변경(getName())
				//Object object = list.get(index);
				//Member dto = (Member)object;
				
				Object dto = (Member)list.get(index);
				
				Member dto1 = (Member)list.get(index);
				System.out.println(dto1.getName());

				
//				System.out.println("이름 : " + name);
			}
		}
		
		//변경 : 3번째 인덱스 요소의 객체를 회원객체로 변경
		//변경 -> set(int index, Object obj) : Object
		Object obj3 = list.set(3, new Member("user02","password02","송하늘"));
		System.out.println("변경 전 3번째 요소객체" + obj3);
	
		obj3 = list.get(3);
		System.out.println("변경 후 3번째 요소객체" + obj3);
		
		//삭제:3번째 인덱스 요소 객체 삭제
		//삭제 -> remove(int index) : Object
		obj3=list.remove(3);
		System.out.println("삭제한 3번째 요소객체" + obj3);
		
		//조회:3번째 인덱스 요소 객체
		obj3 = list.get(3);
		System.out.println("삭제 후 3번째 요소객체" + obj3);
		
		//전체객체 출력
		for (int index = 0; index < list.size(); index++) {
			System.out.println(list.get(index));
		}
	}
}