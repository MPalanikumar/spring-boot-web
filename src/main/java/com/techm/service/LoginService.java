package com.techm.service;

public class LoginService {

	public boolean validate(String uname, String password) {
		if(uname!="" && password!="") {
			return true;
		}
		return false;
	}

	
}
