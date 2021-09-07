package com.work.view;
import com.work.exception.InvalidDataException;
public class UserExceptionTest {
	public static void main(String[] args) {
		UserExceptionTest test = new UserExceptionTest();
		try {
			test.updateGrade("G");
		} catch (InvalidDataException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			test.updateGrade("AA");
		} catch (InvalidDataException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main1(String[] args) {
		UserExceptionTest test = new UserExceptionTest();
		test.updateGrade1("G");
		test.updateGrade1("S");
		test.updateGrade1("A");
		test.updateGrade1("AA");
		test.updateGrade1("X");
	}
	
	
	public void updateGrade(String grade) throws InvalidDataException {
	
		switch(grade){
		 case "G":
		 case "S":
		 case "A":
		 	break;
		 default:
		// 	System.out.println("[데이터가 올바르지 않습니다.]" + grade);}
		//	 throw new InvalidDataException();
			 throw new InvalidDataException("[데이터가 올바르지 않습니다.]" + grade);
		
		}
	}
	
	/**
	 * 아규먼트로 받은 데이터 등급이 G,S,A가 아니면 InvalidDataException오류메세지 출력
	 * @param grade
	 */
	
	public void updateGrade1(String grade) {
		//아규먼트 등급이 G,S,A가 아니면 오류메세지 출력
		//if (!grade.equals('G')&&!grade.equals('S')&&!grade.equals('A')) {
			//System.out.println("잘못된 데이터입니다.");
		switch(grade){
		 case "G":
		 case "S":
		 case "A":
		 	break;
		 	default:
		 	System.out.println("[데이터가 올바르지 않습니다.]" + grade);}
		
		 if(!(grade.equals("G") | grade.equals("S") | grade.equals("A")) ){
		 		System.out.println("[데이터가 올바르지 않습니다.]" + grade);
		 }
	}
}