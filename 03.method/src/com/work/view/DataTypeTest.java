package com.work.view;

/**
 * 데이터 타입 테스트 클래스
 * 
 * --자바 기본형 자동 타입캐스팅
 * byte(8bit) => short(16bit)/char(16bit) => int(32bit) => float(32bit) => double(64bit)
 * 
 * -- 형변환 불가 기본형 : boolean(값의 크기를 갖는 것이 아니라 참/거짓)
 */
public class DataTypeTest {

	public static void main(String[] args) {
		int no = 5;      //int = int: 같은타입 자동할당
		long no2 = no;   //long = int : 기억공간이 큰타입 자동 할당
		//int no3 = no2;   //int = long : 다른타입, 기억공간이 작은 타입, 오류발생		
		int no4 = (int)no2;
		
		float f1 = 5;        //float = int : 기억공간이 큰 타입 자동 할당
		//float f2 = 5.3;    // float = double: 다른타입, 기억공간이 작은 타입, 오료발생
		float f2 = 5.3F;     // 해결1: 5.3 데이터를 float 지정
		float f3 = (float)5.3;   //해결2: 명시적인 형변환을 통해서
		int f4 = (int)5.3;   //해결3: 실수형을 정수형으로 명시적인 형변환 통해서 할당, 
							 //   	  정수부분만 저장됨. 따라서 실수이하 숫자는 버림처리(데이터 손실)
		System.out.println("f3=" + f3);
		System.out.println("f4=" + f4);
		
		int a = '0';
		System.out.println("a=" + a);  // ascii: A-65, a-97, 0-48
	} 
}
