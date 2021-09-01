package com.work.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 공통으로 사용하는 기능 모델링
 * -- 모든 메서드는 객체 생성없이 사용가능한 class 메서드로 구현
 * @author Playdata
 *
 */
public class Utility {
	// 현재날짜 기본 형식 : 년도4자리-월2자리-일2자리 문자열 변환 메서드
	// 메서드명 : getCurrentDate():String
	
	// 현재날짜 아규먼트 형식 : pattern
	// 메서드명 : getCurrentDate():String
	
	// 현재시간 : 기본 형식 : 오후 5:00 
	// 메서드명 : getCurrentTime():String
	// see api: java.util.Locale
	
	// 현재시간 : 아규먼트 형식 : pattern
	// 메서드명 : getCurrentTime():String
	
		
	// 공통 기능 메서드 호출 테스트
	public static void main(String[] args) {
		// 메서드를 구현 후 테스트 해보세요
		System.out.println("현재날짜: " + getCurrentDate());
		System.out.println("현재날짜: " + getCurrentDate("yyyy.MM.dd"));
		
		System.out.println("현재날짜: " + getCurrentTime());
		System.out.println("현재날짜: " + getCurrentTime("HH:mm:ss"));
		
	}

	public static void main1(String[] args) {
		// 날짜: Date 클래스에서 toString() 메서드 재정의 여부 확인
		// see api: dow mon dd hh:mm:ss zzz yyy
		Date today = new Date();
		System.out.println("현재날짜: " + today); // 현재날짜: Wed Sep 01 16:45:20 KST 2021
		
		// 현재날짜 기본 형식 : 년도4자리-월2자리-일2자리 문자열 
		// java.text.SimpleDateFormat : 날짜 형식관련 클래스
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// 메서드이름??(Date) => String
		// see api : String	format(Date date)
		String currentDate = simpleDateFormat.format(new Date());
		System.out.println("현재날짜: " + currentDate);  // 현재날짜: 2021-09-01
		
		// 현재시간: 오후 4:58 형식 
	}
}

