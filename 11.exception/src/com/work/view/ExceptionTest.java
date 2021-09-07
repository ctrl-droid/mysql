package com.work.view;

public class ExceptionTest {
	//명시적 다중 예외처리
	//다중 예외처리시에 sub예외 -> super예외 순서대로 캐치처리해야함
	public static void main(String[] args) {
		String[] names = {"홍길동","강감찬"};
		
		for (int index = 0; index < 5; index++) {
			try {
				String message = null;
				System.out.println("message 문자열 길이: " + message.length());		//NullPointerException 발생
				
				int result = 5/0;
				int no = Integer.parseInt("abc");	//숫자가 아닌 문자열을 int 형변환시에 NumberFormatException 발생
				
				System.out.println(names[index]);	//오류가 발생할 코드
				//String message = null;
				//System.out.println("message 문자열 길이: " + message.length());		//NullPointerException 발생
			} catch(ArrayIndexOutOfBoundsException e) {	//오류발생시 뜨는 구문
				String message = e.getMessage();	//출력할 메세지를 위의 구문과 엮어서 하겠음을 선언
				System.out.println("[오류메세지]" + message);	//출력
				break;	//할 일 다하고 나오기
			} catch (NullPointerException e) {
				System.out.println("[오류메세지]" + e.getMessage());
				System.exit(0);	//예외메세지 출력하고 나서 프로그램 종료 -> 따라서 finally 등 이후 로직 수행하지 않음
			} catch (Exception e) {	//개발자가 처리 가능한 예외 부모클래스 : 공통예외처리
				System.out.println("[오류클래스]" + e.getClass().getName());
				System.out.println("[오류메세지]" + e.getMessage());
			} finally {
				System.out.println("[반드시 수행하는 로직입니다.");	//다 끝나고 할 줄 알았는데 종료 전에 이걸 출력하고 끝난다.
				//경우에 따라서 finally 로직이 수행되지 않을 수도 있음
				//1. System.exit(int) catch 처리 부분에서 프로그램 종료
				//2. finally 로직 수행중 예외 발생
			}
			System.out.println();
	}
		System.out.println("정상종료");
	}
	
	//명시적 다중 예외처리
	public static void main2(String[] args) {
		String[] names = {"홍길동","강감찬","이순신"};
		
		//names 배열을 5번 반복하면서 순서대로 저장된 이름 정보 출력
		for (int index = 0; index < 5; index++) {
			try {System.out.println(names[index]);	//오류가 발생할 코드
		} catch(ArrayIndexOutOfBoundsException e) {	//오류발생시 뜨는 구문
			String message = e.getMessage();	//출력할 메세지를 위의 구문과 엮어서 하겠음을 선언
			System.out.println("[오류메세지]" + message);	//출력
			break;	//할 일 다하고 나오기
		} finally {
			System.out.println("[반드시 수행하는 로직입니다.");	//다 끝나고 할 줄 알았는데 종료 전에 이걸 출력하고 끝난다.
		}
			System.out.println();
	}
		System.out.println("정상종료");
	}
	
	//예외 발생
	public static void main1(String[] args) {
		// "홍길동","강감찬","이순신" 정보를 저장한 배열 선언 + 생성 + 명시적 초기화 동시수행
		String[] names = {"홍길동","강감찬","이순신"};
		
		//names 배열을 5번 반복하면서 순서대로 저장된 이름 정보 출력
		for (int index = 0; index < 5; index++) {
			System.out.println(names[index]);
		}
		
		System.out.println("정상종료");
		
	}
}