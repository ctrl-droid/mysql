package com.work.exception;

/**
 * 데이터가 존배하지 않을시에 예외 클래스
 * @author 박예빈
 *
 */
public class NotFoundException extends Exception {
	public NotFoundException() {
		super("데이터가 존재하지 않습니다.");
	}
	
	public NotFoundException(String message) {
		super(message);
	}

}
