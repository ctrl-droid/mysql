package com.work.view;

/**
 * ## Wrapper Class ##
    -- java.lang.Integer
    -- java.lang.Boolean
 	-- 기본형  <--> 객체형 변환 클래스
 * @author 박호두
 *
 */
public class WrapperTest {
	
	// 테스트2 : invalid-1 : 아규먼트 숫자의 갯수가 2와 같이 않은 경우, 
	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("[오류] 사용법에 따라 다시 수행하시기 바랍니다.");
			System.out.println("[사용법] java 클래스이름 숫자1 숫자2");
			System.exit(0);
		}
		
		// 미해결 : 문자입력시 수행중 오류발생 : java.lang.NumberFormatException: For input string: "aaa"
		// 예외처리에서 진행
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
	}
	
	// 프로그램 실행시에 2개 숫자데이터를 입력받아서 덧셈결과를 출력
	// 형식 : 숫자1 + 숫자2 = 덧셈결과 
	// 테스트1 : valid

	public static void main3(String[] args) {
		if(args.length == 2) {
			int num1 = Integer.parseInt(args[0]);
			int num2 = Integer.parseInt(args[1]);
			
			System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
		} else {
			System.out.println("[오류] 사용법에 따라 다시 수행하시기 바랍니다.");
			System.out.println("[사용법] java 클래스이름 숫자1 숫자2");
		}
		
	}
	
	// 자바어플리케이션 실행하면서 main() 메서드에 아규먼트 전달하는 방법 및 사용하기
	// 자바프로그램실행방법:
	// dos > java [options] main()가 있는 시작 클래스명
	// dos > java [options] main()가 있는 시작 클래스명 데어터1 데이터2 "데이터3"
	// eclipse > Run as > Run Configuration > Program arguments > Argument 입력 > 실행
	
	public static void main2(String[] args) {
		System.out.println("args.lenght: " + args.length);
	}

	public static void main1(String[] args) {
		// int 숫자 기본형을 => Integer 객체 변환
		// "숫자" 숫자형식의 문자열을 => Integer 객체 변환
		
		Integer intObj1 = new Integer(100);
		Integer intObj2 = new Integer("200");
		
		int data1 = intObj1.intValue();
		int data2 = intObj2.intValue();
		
		// 객체를 생성하지 않고 "숫자" 숫자형식의 문자열을 int 타입으로 변환
		// see api : static int parseInt(String s)
		int data3 = Integer.parseInt("100");
		int data4 = Integer.parseInt("200");

	}

}
