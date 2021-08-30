package com.work.view;

import com.work.model.dto.Student;

public class ArrayStudentTest {
	
	/** Student Object 타입의 배열
	 * 
	 *  1: 홍길동, 88
	 *  2: 강감찬, 92
	 *  3: 이순신, 77
	 *  4: 김유신, 95
	 *  5: 유관순, 62
	 *  */
	public static void main(String[] args) {
		// 5명의 학생 객체를 생성해주세요. 올바른 생성자 사용하세요.
		
		Student s1 = new Student(1, "홍길동", 88);
		Student s2 = new Student(2, "강감찬", 92);
		Student s3 = new Student(3, "이순신", 77);
		Student s4 = new Student(4, "김유신", 95);
		Student s5 = new Student(5, "유관순", 62);
		
		// 배열을 이용해서 학생들의 성적 정보 관리
		// 학생타입의 배열객체 선언 및 생성 구현해보세요.
		
		Student[] students = new Student[5];
		
		// 생성한 배열요소에 학생들의 정보를 저장 : 등록
		students[0] = s1;
		students[1] = s2;
		students[2] = s3;
		students[3] = s4;
		students[4] = s5;
		
		// 배열요소에 저장된 학생들의 학번과 이름 정조만을 출력
		// jdk 1.4
		for (int index = 0; index < students.length; index++) {
			System.out.println(students[index].getNo() + ", " + students[index].getName());
			
		}
		System.out.println();
		
		// jdk 1.5
		for(Student s: students) {
			System.out.println(s.getNo() + ", " + s.getName());
		}
		System.out.println();
		
		// jdk 1.4, jdk 1.5 : 총점, 평균도 함께 출력해보세요.
		// 번호, 이름, 성적
		// ----------------------
		// 총점 : 000
		// 평균 : 00.0
		
		int total = 0;
		double avg = 0.0;
		
		for(Student s: students) {
			System.out.println(s.getNo() + ", " + s.getName() + ", " + s.getScore());
			total += s.getScore();
		}
		avg = (double)total / students.length; // int/int->int 82.0, double/int -> double 82.8
		System.out.println("-----------------------------");	
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + avg);
		
	}

	
	
	
	
}
