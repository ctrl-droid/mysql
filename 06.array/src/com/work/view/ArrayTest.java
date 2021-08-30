package com.work.view;

public class ArrayTest {
	
	//실습
	public static void main(String[] args) {
		// 학생 5명의 성적을 관리하는 프로그램
		// 1번: 홍길동, 2번: 강감찬, 3번:이순신, 4번:김유신, 5번:유관순
		// 1번: 88, 2번: 92, 3번: 77, 4번: 95, 5번: 62
		// 출력형식
		// 1번: 홍길동 00
		// 2번: 강감찬 00
		// 총첨 : 000
		// 평균 : 00.0
		
		// 변경: 학생클래스 설계
		String[] names = {"홍길동", "강감찬", "이순신", "김유신", "유관순"};
		int[] scores = {88, 92, 77, 95, 62};
		
		int total = 0;
		double avg = 0.0;
		
		for (int index = 0; index < names.length; index++) {
			total += scores[index];
			System.out.println((index+1) + "번" + names[index] + "\t" + scores[index]);
		}
		
		avg = (double)total / scores.length; // int/int->int 82.0, double/int -> double 82.8
		
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + avg);
	} //이건 순서대로만 쓴거고 이제 객체타입으로 넘어가보자!!



	
	public static void main2(String[] args) {
		//홍길동, 강감찬, 이순신 이름정보를 갖는 배열을 선언+생성+명시적초기화 방법을 이용해서 구현하시오.
		String[] names = new String[] {"홍길동", "강감찬", "이순신"};
		String[] names2 = {"홍길동", "강감찬", "이순신"};
		
		//출력요청 :
		//1번 : 홍길동
		//2번 : 강감찬
		//3번 : 이순신
		
		for (int index = 0; index < names.length; index++) {
			System.out.println((index + 1) + "번:" + names[index]);
		}
	
		System.out.println();

		for (int index = 0; index < 5; index++) {   // 0, 1, 2 => 정상출력 => 3요소접근시에 예외발생 => 예외메세지출력 => 프로그램강제종료
			System.out.println((index + 1) + "번:" + names[index]);
		}
		
		System.out.println("프로그램 정상 종료");
	}

	public static void main1(String[] args) {
		
		// 학생 5명의 성적 : 88, 92, 77, 95, 62
		//1. 선언 + 2. 생성 동시 수행
		int[] nos = new int[5]; //배열객체 생성순서: 메모리 할당->기본값초기화->[명시적초기화]->참조값할당
		
		//3. 배열요소 값 출력
		for (int index = 0; index<nos.length; index++) {
			System.out.println(nos[index]);
		}
		System.out.println();
		
		//3. 배열요소 값 할당
		nos[0]=88;
		nos[1]=92;
		nos[2]=77;
		nos[3]=95;
		nos[4]=62;
		
		for (int index = 0; index<nos.length; index++) {
			System.out.println(nos[index]);
		}
		System.out.println();
		
		//학생 5명의 성적
		//1. 선언 + 2. 생성 동시 수행 +3. 명시적 초기화
		int[] nos2 = new int[] {88, 92, 77, 95, 62};
		//jdk1.4 : 반복횟수를 개발자가 명시적으로 지정 가능
		for (int index = 0; index<2; index++) {
			System.out.println(nos2[index]);
		}
		System.out.println();
		
		//jdk1.5 향상된 for 구문
		//array, collection api
		//배열크기를 지정하지 않음, 배열 또는 collection에 저장된 갯수만큼(items) 반복 수행
		//형식:(타입 변수명 : 배열명 또는 collection 참조 변수명) {}
		for(int no: nos2) {
			System.out.println(no + "\t");
		}
		System.out.println();
	}
}
