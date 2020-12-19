package com.bloomberg.clustereddata.exception;

import lombok.Data;

/**
 * @auther .: adewale.ijalana
 * @email ..: adewaleijalana@gmail.com
 * @created : 18/12/2020
 */


@Data
public class ModelAlreadyExistException extends RuntimeException {

	private String fieldOrClassName;
	private String argumentSupplied;
	private String errorCode;

	public ModelAlreadyExistException(String fieldOrClassName, String argumentSupplied) {
		super(argumentSupplied);
		this.fieldOrClassName = fieldOrClassName;
		this.argumentSupplied = argumentSupplied;
	}

	public ModelAlreadyExistException(String fieldOrClassName, String argumentSupplied,String errorCode) {
		super(argumentSupplied);
		this.fieldOrClassName = fieldOrClassName;
		this.argumentSupplied = argumentSupplied;
		this.errorCode= errorCode;
	}

	public ModelAlreadyExistException(String argumentSupplied) {
		this.argumentSupplied = argumentSupplied;

	}
}
