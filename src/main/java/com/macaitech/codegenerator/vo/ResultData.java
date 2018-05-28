package com.macaitech.codegenerator.vo;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class ResultData<T> extends Result {
    private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
    
    
}
