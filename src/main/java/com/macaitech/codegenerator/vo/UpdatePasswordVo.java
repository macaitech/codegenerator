package com.macaitech.codegenerator.vo;

import com.macaitech.codegenerator.sys.model.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdatePasswordVo extends User {
    private String rawPassword;

	public String getRawPassword() {
		return rawPassword;
	}

	public void setRawPassword(String rawPassword) {
		this.rawPassword = rawPassword;
	}
    
    
}
