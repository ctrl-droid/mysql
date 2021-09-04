package com.work.util;

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
     * @author 임경혜
     * @author 오재욱(수정)
     * @return 기본 4자리 숫자의 보안 문자열 반환
     */
    public static String getSecureCodeNumber() {
        return getSecureCodeNumber(4);
    }
    
    
    /**
     * 아규먼트 길이의 임시 보안 문자 반환 : 8356143
     * @author 오재욱
     * @param length 임시보안문자열의 길이
     * @return length자리 숫자의 보안 문자열 반환
     */
    public static String getSecureCodeNumber(int length) {
        StringBuilder secureCode = new StringBuilder();
        Random random = new Random((long)(System.nanoTime() * Math.random())); 
        for (int index = 0; index < length; index++) {
            secureCode.append(random.nextInt(10));
        }

        return secureCode.toString();
    }

    // 아규먼트 길이의 임시 보안 영문자 반환 : ABZQYB
    /*
     * @author 오재욱
     * 랜덤으로 받은 숫자를 (char)로 형변환 해주면 아스키코드에 해당하는 알파벳으로 변환
     */
    public static String getSecureCodeString(int length) {
        StringBuilder secureCode = new StringBuilder();
        Random random = new Random((long)(System.nanoTime() * Math.random())); 
        for (int index = 0; index < length; index++) {
            secureCode.append((char)(random.nextInt(26) + 65));
        }

        return secureCode.toString();
    }
    
 // 아규먼트 길이의 임시 보안 숫자 및 영문자 혼용 반환 : 38ZB72 
    /*
     * 1. 입력받은 길이 만큼 반복문을 돌리며 secureCode에 문자열 추가
     * 2. 이 때, 매 시행마다 0 or 1의 값을 랜덤으로 갖는 숫자 mode를 받음
     * 3. mode가 0이라면 secureCode에 숫자(랜덤) 추가
     * 3-2. mode가 1이라면 secureCode에 알파벳(랜덤) 추가
     * @author 오재욱
     */
    public static String getSecureCodeNumberAndString(int length) {
        StringBuilder secureCode = new StringBuilder();
        Random random = new Random((long)(System.nanoTime() * Math.random()));
        for (int index = 0; index < length; index++) {
            int mode = random.nextInt(2);
            if (mode == 0) {
                secureCode.append(random.nextInt(10));
            } else {
                secureCode.append((char)(random.nextInt(26) + 65));
            }
        }
        return secureCode.toString();
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
