package com.seunghan.vending_machine_tdd.exception;

public class CoinException extends RuntimeException{
	public CoinException() {
		super();
	}

	public CoinException(String message) {
		super(message);
	}

	public CoinException(String message, Throwable cause) {
		super(message, cause);
	}

	public CoinException(Throwable cause) {
		super(cause);
	}

	protected CoinException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
