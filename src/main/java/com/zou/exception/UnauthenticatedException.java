package com.zou.exception;

/**
 * 身份认证异常
 * @author liugh
 * @since 2018-05-06
 */
public class UnauthenticatedException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnauthenticatedException(String msg) {
        super(msg);
    }

    public UnauthenticatedException() {
        super();
    }
}
