package com.work.view;

public class IfSwitchTest {
	
	/*
	 *  학생의 성적에 따른 등급을 출력하는 매서드 구현
	 *  -- 요구사항
	 *  1. 학생의 성적은 0 ~ 100점
	 *  2.  90 ~ 100 : 등급 A
	 *  	80 ~ 89  : 등급 B
	 *    	70 ~ 79  : 등급 C
	 *      60 ~ 69  : 등급 D
	 *      0 ~ 59   : 등급 F
	 *      
	 *  3. 출력방식:
	 *  -- valid:
	 *  성적 00은 등급 000입니다.
	 *  => 출력형식 변경 여부
	 *  => [성적] 00 [등급] 00
	 *  
	 *  -- invalid:
	 *  [오류] 오류메세지 출력
	 *  
	 *  4. if 구문 활용
	 *  
	 *  5. switch 구문 활용
	 *      
	 */
	public static void main(String[] args) {
		int score = 92;
		
		System.out.println("if 구문 활용");
		String grade = null;
		
		if (score >= 0 && score <= 100) {
			if (score >= 90) { // if (score >= 90 & score <= 100)
				//System.out.println("성적 " + score + "은 등급" + "A" + "입니다.");
				grade = "A";
			} else if(score >= 80) {
				grade = "B";
				//System.out.println("성적 " + score + "은 등급" + "B" + "입니다.");
			} else if(score >= 70) {
				grade = "C";
				
			} else if(score >= 60) {
				grade = "D";
				
			} else {
				grade = "F";
				
			}
			
			//System.out.println("성적 " + score + "은 등급" + grade + "입니다.");
			System.out.println("[성적]"+ score + "[등급]" + grade );  // 유지보수 관리
			
		} else {
			System.out.println("[오류] 성적은 0 ~ 100점 이내만 가능합니다. :" + score);
		}
		
		
		 System.out.println("\nswitch 구문 활용");
		 if (score >= 0 && score <= 100) {
			 switch(score / 10) {
			 case 10:
				 grade = "A";
				 break;
			 case 9:
				 grade = "B";
				 break;
			 case 8:
				 grade = "C";
				 break;
			 case 7:
				 grade = "D";
				 break;
			 case 6:
				 grade = "E";
				 break;
			 default :
				 grade = "F";
			
			 }
			 
			 System.out.println("[성적]"+ score + "[등급]" + grade );
			 
		} else {
			System.out.println("[오류] 성적은 0 ~ 100점 이내만 가능합니다. :" + score);
		}
		 
	}
}
