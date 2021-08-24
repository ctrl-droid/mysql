package com.work.view;

public class GuGuDanTest {
	public static void main(String[] args) {
	
		// 실습: 반복문을 이용해서 영문 대문자 A ~ Z ascill code를 출력하는 프로그램을 작성
		// 출력형식 =>  A : 65
		
		System.out.println("\n 1번");
		for (int i=65; i <= 90; i++) {
			System.out.println((char)i + ": " + i);
		}
		
		System.out.println("\n 2번");
		for (int i='a'; i <= 'z'; i++) {
			System.out.println((char)i + ": " + i);   // ascii: A-65, a-97, 0-48
		}
	}
	
	
	public static void main2(String[] args) {
		System.out.println("\nfor 구문을 활용한 구구단");
		
		// 제목행 반복 출력 : dan 2 ~ 9
		for (int dan = 2; dan <= 9; dan ++) { // for 구문 내부에서 사용가능한 지역변수
			System.out.print(dan + "단\t");
		}
		// 다음 라인으로 이동
		System.out.println();
		
		// 구구단 반복 수행
		for(int step = 1; step <=9; step ++) {  // 세로 반복문 step 1 ~ 9 
			for (int dan = 2; dan <= 9; dan ++) {  // 가로 반복문 단 2 ~ 9 
				// 2*1= 2   3*1 =3 ... 9*1=9
				System.out.print(dan + "*" + step + "=" + (dan*step) + "\t");
			}
			System.out.println();
		};  // end brace 경우에는 ;(세미콜론) 생략가능
		
		// System.out.println(dan + ", " + step);  // for 구문 내부에서 사용가능한 지역변수이므로 for 문 외부에서는 사용불가
		System.out.println("\ndo-while 구문을 활용한 구구단");
		int dan =2;
		do {
			System.out.print(dan + "단\t");
			dan++;
		} while(dan <= 9);
		System.out.println();
		
		// System.out.println("dan" + dan); // 출력하면 dan = 10, 그래서 dan = 2로 초기화
		
		// int dan = 2; // 오류? 위에서 int dan=2; 동일한 이름의 변수 선언
		dan = 2;
		int step = 1;
		
		do {
			dan = 2;    // dan 초기화
			do {
				System.out.print(dan + "*" + step + "=" + (dan*step) + "\t");
				dan ++;  // dan 1 증가
			} while(dan <= 9);
			System.out.println();
			step ++;   // step 1 증가
		} while(step <=9);
		
		
		System.out.println("\nwhile 구문을 활용한 구구단");
		dan =2;
		while (dan <=9){
			System.out.print(dan + "단\t");
			dan ++;
		}
		System.out.println();
		
		dan = 2;
		step = 1;
		while (step <=9) {
			dan = 2;
			while (dan <= 9) {
				System.out.print(dan + "*" + step + "=" + (dan*step) + "\t");
				dan ++;  // dan 1 증가
			}
			System.out.println();
			step++;
		}
		
		System.out.println("\nfor 짝수단 구구단");
		
		for (dan = 1; dan <= 9; dan ++) { // for 구문 내부에서 사용가능한 지역변수
			if(dan % 2 == 0) {
				System.out.print(dan + "단\t");
			}
				
		}
		// 다음 라인으로 이동
		System.out.println();
		
		// 구구단 반복 수행
		for(step = 1; step <=9; step ++) {  // 세로 반복문 step 1 ~ 9 
			for (dan = 2; dan <= 9; dan += 2) {  // 가로 반복문 단 2 ~ 9 
				if(dan % 2 == 0) {
				System.out.print(dan + "*" + step + "=" + (dan*step) + "\t");
				}
			}
			System.out.println();
		};  // end brace 경우에는 ;(세미콜론) 생략가능
		
		
		System.out.println("\nfor 홀수 스텝 구구단");
		
		for (dan = 2; dan <= 9; dan ++) { // for 구문 내부에서 사용가능한 지역변수
			System.out.print(dan + "단\t");
		}
		// 다음 라인으로 이동
		System.out.println();
		
		// 구구단 반복 수행
		for(step = 1; step <=9; step ++) {  // 세로 반복문 step 1 ~ 9 
			if (step % 2 == 1) {
				for (dan = 2; dan <= 9; dan ++) {  // 가로 반복문 단 2 ~ 9 
					System.out.print(dan + "*" + step + "=" + (dan*step) + "\t");
				}
				System.out.println();	
			}

		};
		

		
		

		
	};
}

/*
    # 콘솔 출력
    System.out.println();  // 새로운라인이동
    System.out.println("문자열");  // 문자열 출력 후 새로운라인이동
    System.out.print("문자열");  // 문자열 출력, 라인이동X
    
    # 특수문자
    일정간격 띄우기 : \t
    새로운 라인 : \n
    
 
 
 
 */