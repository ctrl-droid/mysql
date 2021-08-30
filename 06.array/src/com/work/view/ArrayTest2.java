package com.work.view;

public class ArrayTest2 {
	
	// 2차원 배열 선언 + 생성 + 명시적초기화
	public static void main(String[] args) {
		int[][] scores = {
				{90, 80, 70, 60, 50}, {80, 70, 60}, {80, 70, 60, 50}
		};   // 밑에꺼 뻘짓 안해도 됌!
		
		// 2차원 저장된 값을 출력 
		for (int row = 0, total = 0; row < scores.length; row++) {    // 각반만큼 반복
			total = 0;	// 해당 반의 총점을 누적 계산하기 전에 0으로 초기화
			System.out.println((row + 1) + "반 ");
			for (int col = 0; col < scores[row].length; col++) {    // 해당 반의 학생수만큼 반복
				total += scores[row][col];  // 해당 반의 학생의 성적을 해당반의 총점에 누적
				System.out.println((col + 1) + "번: " + scores[row][col]);
						
				}
			// 각 반의 총점과 평균을 계산해서 출력
			System.out.println((row + 1) + "반 총점 :"+ total);
			System.out.println((row + 1) + "반 평균 :"+ (total / scores[row].length)); // 해당 반의 총점 / 해당반의 학생 수
			System.out.println();
			}
		
	}
	
	
	public static void main2(String[] args) {
		// 1반 학생성적: 90, 80, 70, 60, 50
		// 2반 학생성적: 80, 70, 60
		// 3반 학생성적: 80, 70, 60, 50
		
		// 각반마다 학생수가 다르기 떄문에 
		// 2차원 행마다 열의 크기를 다르게 지정생성 방법
		int[][] scores = new int[3][1];
		
		// 각행마다 열의 크기 지정
		scores[0] = new int[5];  // 0행 1반
		scores[1] = new int[3];  // 1행 2반
		scores[2] = new int[4];  // 2행 3반
		
		scores[0][0] = 90;  // 0행 1반 / 0열 1번
		scores[0][1] = 80;  // 0행 1반 / 1열 2번
		scores[0][2] = 70;  // 0행 1반 / 2열 3번
		scores[0][3] = 60;  // 0행 1반 / 3열 4번
		scores[0][4] = 50;  // 0행 1반 / 4열 5번
		
		scores[1][0] = 80;  // 2반 1번
		scores[1][1] = 70; 
		scores[1][2] = 60;  
		
		scores[2][0] = 80;  // 3반 1번
		scores[2][1] = 70; 
		scores[2][2] = 60;
		scores[2][3] = 50;
		
		
		
		// 2차원 저장된 값을 출력 
		for (int row = 0, total = 0; row < scores.length; row++) {    // 각반만큼 반복
			total = 0;	// 해당 반의 총점을 누적 계산하기 전에 0으로 초기화
			System.out.println((row + 1) + "반 ");
			for (int col = 0; col < scores[row].length; col++) {    // 해당 반의 학생수만큼 반복
				total += scores[row][col];  // 해당 반의 학생의 성적을 해당반의 총점에 누적
				System.out.println((col + 1) + "번: " + scores[row][col]);
				
			}
			// 각 반의 총점과 평균을 계산해서 출력
			System.out.println((row + 1) + "반 총점 :"+ total);
			System.out.println((row + 1) + "반 평균 :"+ (total / scores[row].length)); // 해당 반의 총점 / 해당반의 학생 수
			System.out.println();
		}
		
		
		// 2차원 배열을 이용해서 학생성적을 저장하고, 각반마다 총점과 평균(정수형) 출력하는 프로그램 작성
		// 형식:
		// 1반:
		// 90
		// 80
		// ...
		// 1반 총점 : 000
		// 2반 평균 : 000
		
		// 2반
		// ...
		
		// 3반
		// ...

		
		
		
		
	}
	
	public static void main1(String[] args) {
		// 2차원 배열: 행마다 열의 크기가 동일한 2차원 배열
		int[][] nos = new int[3][2];
		
		nos[0][0] = 100;
		nos[0][1] = 90;
		
		nos[1][0] = 80;
		nos[0][1] = 70;
		
		nos[2][0] = 60;
		nos[2][1] = 50;
		
		
		// -- 2차원배열명.length 변수 = 2차원 배열의 행크기 저장된 변수
		// -- 2차원배열명[행번호].length = 해당행의 열크기가 저장된 변수
		
		// 2차원 배열에 저장된 모든 값을 출력
		for (int row = 0; row < nos.length; row++) {
			for (int col = 0; col < nos[row].length; col++) {
				System.out.println(nos[row][col] + "\t");
				
			}
			System.out.println();
		}
		
	}
}
