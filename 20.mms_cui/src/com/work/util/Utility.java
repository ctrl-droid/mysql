package com.work.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * 공통으로 사용하는 기능 모델링
 * -- 모든 메서드는 객체생성없이 사용가능한 class 메서드로 구현
 */
public class Utility {
	/**
	 * 키보드 문자열 입력반환
	 * @return 문자열
	 */
	public static String inputString() {
		String inputData = null;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			inputData = in.readLine();
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		return inputData;
	}
		
	
	/**
	 * 키보드 입력 숫자 반환
	 * @return 숫자
	 */
	public static int inputNumber() {
		String inputData = null;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			inputData = in.readLine();
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		return Integer.parseInt(inputData);
	}
	
	
	/**
	 * 현재날짜 기본 형식 : 년도4자리-월2자리-일2자리 문자열 변환 메서드
	 * @return
	 */
	public static String getCurrentDate() {
		return getCurrentDate("yyyy-MM-dd");
	}
	
	/**
	 * 현재날짜 아규먼트 형식 : pattern
	 * @param pattern
	 * @return
	 */
	public static String getCurrentDate(String pattern) {
		return new SimpleDateFormat(pattern).format(new Date());
	}
	
	/**
	 * 현재시간 : 기본 형식 : 오후 5:00 
	 * @return
	 */
	public static String getCurrentTime() {
		return getCurrentTime("a h:mm");
	}
	
	/**
	 * 현재시간 : 아규먼트 형식 : pattern
	 * @param pattern
	 * @return
	 */
	public static String getCurrentTime(String pattern) {
		return new SimpleDateFormat(pattern).format(new Date());
	}

	/**
	 * 현재 날짜 및 시간 기본형식, 기본로케일은 대한민국 변환
	 * @return
	 */
	public static String getCurrentDateAndCurrentTime() {
		return getCurrentDateAndCurrentTime("yyyy-MM-dd a h:mm", Locale.KOREA);
	}

	/**
	 * 현재 날짜 및 시간, 로케일은 전달받은 아규먼트의 형식 및 로케일반영 변환
	 * @param pattern
	 * @param locale
	 * @return
	 */
	public static String getCurrentDateAndCurrentTime(String pattern, Locale locale) {
		return new SimpleDateFormat(pattern, locale).format(new Date());
	}
	
	/**
	 * Lotto645 임의의 숫자 문자열 반환 : 
	 * @return
	 */
	public static String getRandom() {
		Random random = new Random((long)(System.nanoTime() * Math.random()));  
		return String.valueOf(random.nextInt(45) + 1);  
	}
	
	/**
	 * 임시 보안 문자 반환: 응용해서 다양하게 활용해보세요 : 8357
	 * @return 기본 4자리 숫자의 보안 문자열 반환
	 */
	public static String getSecureCodeNumber() {
		StringBuilder secureCode = new StringBuilder();
		Random random = new Random((long)(System.nanoTime() * Math.random())); 
		for (int index = 0; index < 4; index++) {
			secureCode.append(random.nextInt(10));
		}
		
		return secureCode.toString();
	}
	
	// 아규먼트 길이의 임시 보안 문자 반환 : 8356143
	public static String getSecureCodeNumber(int length) {
		return null;
	}
	
	// 아규먼트 길이의 임시 보안 영문자 반환 : ABZQYB
	public static String getSecureCodeString(int length) {
		return null;
	}
	
	// 아규머트 길이의 임시 보안 숫자 및 영문자 혼용 반환 : 38ZB72 
	public static String getSecureCodeNumberAndString(int length) {
		return null;
	}
	
	/**
	 * 복불복 이름 지정하기: 우수회원 등업시에 담당자 배정시에 활용, 오늘 청소당번 지정
	 * -- 아래코드를 api 확인하면서 코드 리뷰 해볼것!!!
	 * @return
	 */
	public static String getRandomManger() {
		String[] names = {"김미주", "김민하", "김희택", "송하늘", "신다운", "박용연"};
		Random random = new Random((long)(System.nanoTime() * Math.random())); 
		return names[random.nextInt(names.length)];
	}
	
	/**
	 * 공통 기능 메서드 테스트
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("현재날짜: " + getCurrentDate()); // 기본형식날짜
		System.out.println("현재날짜: " + getCurrentDate("yyyy.MM.dd")); // 지정한형식날짜
		System.out.println("현재날짜: " + getCurrentDate("yy/MM/dd"));
		
		System.out.println("현재날짜: " + getCurrentTime()); // 기본형식시간
		System.out.println("현재날짜: " + getCurrentTime("HH:mm:ss"));	// 지정한형식시간
		
		System.out.println();
		System.out.println("현재날짜: " + getCurrentDateAndCurrentTime()); // 기본형식 날짜 및 시간, 기본로케일 KOREA
		System.out.println("현재날짜: " + getCurrentDateAndCurrentTime("yyyy-MM-dd", Locale.KOREA));
		System.out.println("현재날짜: " + getCurrentDateAndCurrentTime("a h:mm", Locale.US));
		System.out.println("현재날짜: " + getCurrentDateAndCurrentTime("a h:mm", Locale.JAPAN));
	}
}
