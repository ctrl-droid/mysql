package com.work.exception;

/**
 * 데이터가 중복(존재)시에 예외 클래스
 * @author 박예빈
 *
 */
public class AlreadyExistException extends Exception {
	public AlreadyExistException() {
		this("이미 데이터가 존재합니다.");
	}
	
	public AlreadyExistException(String message) {
		super(message);
	}
}
