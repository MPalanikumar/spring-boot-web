package com.techm;
/*
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.java.com.att.loginService.LoginService;
*/

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.techm.service.LoginService;

public class LoginTest {

		LoginService service = new LoginService();
		
		@Test
		public void testLoginPass() {
			assertTrue(service.validate("hello", "hello"));
		}
		@Test
		public void testLoginFail() {
			assertFalse(service.validate("hello", ""));
		}
}
