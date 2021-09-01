package com.work.view;

import java.util.StringTokenizer;

public class StringTest {
	
	//문자열 토큰링 처리
	public static void main(String[] args) {
		String data = "user01, password01, 홍길동";	//csv
		
		//java.lang.String#split()
		//String[] split(String regex)
		//String[] split(String regex, int limit)
		String[] dataTokens = data.split(",");
		for (int index = 0; index < dataTokens.length; index++) {
			System.out.println(dataTokens[index]);
		}
		
		//java.lang.StringTokenizer class
		StringTokenizer tokens = new StringTokenizer(data, ",");
		while(tokens.hasMoreTokens()) {
			System.out.println("countTokens():" + tokens.countTokens());
			String tokenData = tokens.nextToken();
			System.out.println(tokenData);
		}
	}

	
	// StringBuffer(jdk1.0), StringBuilder(jdk1.5) : 가변문자열, new 필수
	public static void main2(String[] args) {
		StringBuilder msg1 = new StringBuilder("hello");
		StringBuilder msg2 = new StringBuilder("hello");
		StringBuilder msg3 = new StringBuilder("hello");
		
		msg1.append("안녕하세요").append("감사해요").append("잘있어요").append("다시만나요");
		System.out.println(msg1);
		
		// StringBuilder의 부모클래스가 누구?
		// see api : public final class StringBuilder extends Object
		// StringBuilder의 문자열을 String 타입으로 변환이 필요
		String msg = msg1.toString();
		
	}
	
	public static void main1(String[] args) {
		String msg1 = "hello";  // new 사용하지않고 객체생성 가능
		String msg2 = "hello";
		String msg3 = new String("hello");  // new 사용해서 객체생성 가능
		String msg4 = new String("hello");
		
		for (int index = 1; index <= 100; index++) {
			msg1 += index;  // hello + 1, ... hello + 100
		}
		
		System.out.println("\n## == 연산자 이용 문자열 비교");
		System.out.println(msg1 == msg2);  // true
		System.out.println(msg1 == msg3);  // false  => 같은 문자열인데
		System.out.println(msg1 == msg4);  // false  => 같은 문자열인데

		System.out.println("\n## equals() 메서드 이용 문자열 비교");
		System.out.println(msg1.equals(msg2));  // true
		System.out.println(msg1.equals(msg3));  // true
		System.out.println(msg1.equals(msg4));  // true
	}

}
