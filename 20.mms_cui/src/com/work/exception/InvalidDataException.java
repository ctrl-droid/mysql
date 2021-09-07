package com.work.exception;
/**
 * 사용자 정의 예외클래스
 * --올바르지 않은 데이터에 대한 예외 클래스
 * @author 정현아
 */
public class InvalidDataException extends Exception {
	public InvalidDataException() {
		super("데이터가 올바르지 않습니다.");
	}
	
	public InvalidDataException(String message) {
		super(message);
	}
}