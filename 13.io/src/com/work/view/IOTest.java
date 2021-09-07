package com.work.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOTest {
	
	// 표준 키보드 입력 byte => InputStreamReader character => BufferedReader#readline() : String
	public static void main3(String[] args) {
		// 표준 모니터 출력
		System.out.print(">> 자기소개 입력 [Ctrl+Z 입력 끝]: ");
		
		// 표준 키보드 입력 => byte => InputStreamReader character => BufferedReader 라인단위 String
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			String inputData = null;  // String타입이니까
			
			while ((inputData = in.readLine()) != null) {  // char 기본형이 null이기 떄문에 내가 원할 때 강제종료 시키게끔 while문 작성
				System.out.println("[입력데이터] " + inputData);  // (char)inputData 할 필요없으니까  char 지워!
			}
			
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}
	
	
	// 표준 키보드 입력 byte => InputStreamReader character : char. 한글 깨짐 해결 (but, 한 글자만 반응하기 떄문에 여러글자는??)
	public static void main(String[] args) {
		// 표준 모니터 출력
		System.out.print(">> 한문자 입력: ");
		
		// 표준 키보드 입력 => byte => InputStreamReader character
		try {
			InputStreamReader in = new InputStreamReader(System.in);
			
			int inputData = in.read();
			System.out.println("[입력데이터] " + inputData + " : " + (char)inputData);
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}
	

	// 표준 입출력 : 키보드 입력, 모니터 출력
	public static void main1(String[] args) {
		// 표준 모니터 출력
		System.out.print(">> 한문자 입력: ");
		
		// 표준 키보드 입력
		try {
			int inputData = System.in.read();
			System.out.println("[입력데이터] " + inputData + " : " + (char)inputData);
		} catch (IOException e) {
			e.printStackTrace(); // 개발시에 디버그 목적으로 출력. 보안상의 이슈가 발생. 실제서비스시에는 배포ㄴㄴ
		}
	}

	
	
}
