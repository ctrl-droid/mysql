package com.work.view;
import java.io.IOException;
public class IOExceptionTest {
	
	//개발자 명시적 예외처리
	public static void main(String[] args) {
		System.out.println("> 한 문자 입력 :");
		
		int data = -1;
		try {
			data = System.in.read();
			throw new IOException("개발자가 임의로 IO예외를 발생시킵니다.");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		System.out.println("입력문자 : " + data);
	}
	//예외처리를 호출 측 메서드에게 throws 전가시키는 방법
	//즉, main() 메서드에서 throws 하는 것은 실질적인 예외발생에 대한 처리를 안 하는 것임(javac에게 뻥, 개발자가 꼼수부리는 것)
	//개발 시에 예외처리가 테스트 확인 된 이후에 테스트를 위한 코드의 가독성으로 사용하기도 함.
	public static void main1(String[] args) throws IOException{
		System.out.println("> 나이입력 :");
		
		int age = System.in.read();	//checked Exception : IOException 발생에 대한 예외처리 강제
		//public abstract int read() throws IOException
		//read() 메서드에서 사용자에게 IOException 에 대한 예회처리를 throws 전가시킴
		System.out.println("나이 : " + age);	//ascii code
	}
}