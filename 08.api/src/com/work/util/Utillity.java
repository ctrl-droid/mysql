package com.work.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 공통으로 사용하는 기능 모델링
 * -- 모든 메서드는 객체 생성없이 사용가능한 class 메서드로 구현
 * @author Playdata
 *
 */
public class Utillity {
	
	// 현재날짜 기본 형식 : 년도4자리-월2자리-일2자리 문자열 변환 메서드
    // 메서드명 : getCurrentDate():String
	public static String getCurrentDate() {
		// sol1
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		String currentDate = simpleDateFormat.format(new Date());
//		return currentDate;
		
		//sol2
		return getCurrentDate("yyyy-MM-dd");
		// => 밑의 getCurrentDate랑 아규먼트 받는 차이밖에 없기 떄문에 return에서 패턴을 직접 입력해도 된다. (아규먼트 안받는 애만 줄이는거 가능)
	}
	
    // 현재날짜 아규먼트 형식 : pattern
    // 메서드명 : getCurrentDate():String
	public static String getCurrentDate(String pattern) {
		// sol1
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//		String currentDate = simpleDateFormat.format(new Date());
//		return currentDate;
		
		// sol2
		return new SimpleDateFormat(pattern).format(new Date());
	}
	
    // 현재시간 : 기본 형식 : 오후 5:00 
    // 메서드명 : getCurrentTime():String
    // see api: java.util.Locale
	public static String getCurrentTime() {
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("a h:mm", Locale.KOREAN);
//		String currentDate = simpleDateFormat.format(new Date());
//		return currentDate;
		return getCurrentTime("a h:mm");
	}

    // 현재시간 : 아규먼트 형식 : pattern
    // 메서드명 : getCurrentTime():String
	public static String getCurrentTime(String pattern) {
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.KOREAN);
//		String currentDate = simpleDateFormat.format(new Date());
//		return currentDate;
		return new SimpleDateFormat(pattern, Locale.KOREAN).format(new Date());
	}
	
	// 위의 getCurrentDate + getCurrentTime
	public static String getCurrentTimeAndCurrentTime(String pattern) {
		return new SimpleDateFormat(pattern).format(new Date());
	}
	
	public static String getCurrentTimeAndCurrentTime() {
		return getCurrentTimeAndCurrentTime("yyyy.MM.dd", Locale.KOREAN);
	}
	
	public static String getCurrentTimeAndCurrentTime(String pattern, Locale locale) {
		return new SimpleDateFormat(pattern, locale).format(new Date());

	}
	
	// 공통 기능 메서드 호출 테스트
    public static void main(String[] args) {
    	// 메서드를 구현 후 테스트 해보세요
        System.out.println("현재날짜: " + getCurrentDate());
        System.out.println("현재날짜: " + getCurrentDate("yyyy.MM.dd"));

        System.out.println("현재날짜: " + getCurrentTime());
        System.out.println("현재날짜: " + getCurrentTime("HH:mm:ss"));
        
        System.out.println();
        System.out.println("현재날짜: " + getCurrentTimeAndCurrentTime()); // 기본형식 날짜 및 시간, 기본로케일 KOREA
        System.out.println("현재날짜: " + getCurrentTimeAndCurrentTime("yyyy-MM-dd", Locale.KOREA));
        System.out.println("현재날짜: " + getCurrentTimeAndCurrentTime("a h:mm", Locale.US)); // 기본형식 날짜 및 시간, 로케일 US
        System.out.println("현재날짜: " + getCurrentTimeAndCurrentTime("a h:mm", Locale.JAPAN)); 
        
    }
    
	public static void main1(String[] args) {
		// 날짜: Date 클래스에서 toString() 매서드 재정의 여부 확인
		Date today = new Date();
		System.out.println("현재날짜 : " + today); // 현재날짜: Wed Sep 16:45:20 KST 2021
		
		// 현재날짜 기본 형식 : 년도4자리-월2자리-일2자리 문자열
		// java.text.SimpleDateFormat : 날짜 형식관련 클래스
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// 메서드이름?? (Date) => String
		// see api : String format(Date date)
		String currentDate = simpleDateFormat.format(new Date());
		System.out.println("현재날짜 : " + currentDate);
		
		// 현재시간 : 오후 4:58 형식
		String currentTime = simpleDateFormat.format(new Date());
	}

}
