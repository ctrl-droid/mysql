package com.work.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.wokr.mode.dto.Member;
import com.work.util.Utility;

public class FileIOTest {
	// File 객체를 이용해서 현재 폴더에 있는 파일(member_list.txt)의 내용을 읽어오기
	public static void main(String[] args) {
		// File로부터 라인단위 읽어오기
		try {
			BufferedReader in = new BufferedReader(new FileReader("member_list.txt"));
			String data = null;
			while ((data = in.readLine()) != null) {
				System.out.println(data);
			}
		
		} catch (FileNotFoundException e) {  // FileReader 때문에 예외처리
			e.printStackTrace();
		} catch (IOException e) {   // in.readLine 때문에 예외처리
			e.printStackTrace();
		}
	}
	
	
	// File 객체를 이용해서 파일 처리 : 속성정보 핸들링, 폴더 생성, 삭제
	public static void main2(String[] args) {
		File file = new File("member_list.txt");
		System.out.println(file.isFile());  	 // true
		System.out.println(file.isDirectory());  // false
		System.out.println(file.canRead());  	 // true
		System.out.println(file.canWrite());  	 // true
		
		System.out.println();
		File configDir = new File("config");
		configDir.mkdir();  // 현재 폴더 밑에 config라는 폴더를 생성
		System.out.println(configDir.isDirectory());  // true
		System.out.println(configDir.getAbsolutePath());
		System.out.println(configDir.getPath());
		System.out.println(configDir.getParent());
		
		// configDir 폴더 삭제!
		configDir.delete();
	}
	
	
	/*
	 * Utility 구현한 문자열 입력, 숫자 입력 메서드를 활용
	 * - Utility.inputString()
	 * - Utility.inputNumber()
	 */
	public static void main1(String[] args) {
		System.out.print(">> 아이디 : ");
		String memberId = Utility.inputString();
		
		System.out.print(">> 비밀번호 : ");
		String memberPw = Utility.inputString();
		
		System.out.print(">> 이름 : ");
		String name = Utility.inputString();
		
		System.out.print(">> 나이 : ");
		int age = Utility.inputNumber();
		
		// 입력받은 데이터로 회원 객체 생성
		Member dto = new Member(memberId, memberPw, name, age);
		
		// 입력받은 데이터 회원 객체 출력
		System.out.println(dto);   // 이대로만하면 날라감. 그래서 파일에 출력
		
		// 회원객체 정보를 파일에 출력
		/*
		 *  1. 출력스트림
		    2. char단위 : 한글자출력
			3. 파일(java.io.Rile)
			4. Node Stream : FileWriter => 한글자출력
		       Process Stream : PrintWriter => 라인단위출력
		 * 
		 */
		
		PrintWriter out = null;
		try {
			// 파일 라인단위 출력 스트림 객체 생성
			out = new PrintWriter(new FileWriter("member_list.txt", true));
//			out = new PrintWriter(new FileWriter("member_list.txt"));  //파일로출력. 파일만들 떄 권한이 있/없때문에 try,catch
			// 출력 스트림을 통해서 회원객체의 정보를 라인단위로 출력
			out.println(dto.toString());  //콘솔창에 출력할때만 toString 생략가능. 
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			out.close();  // 출력 스트림 자원해제
		}
 
		
			
		
		
		
		
		
		
		
		
		
		
		
	}

}
