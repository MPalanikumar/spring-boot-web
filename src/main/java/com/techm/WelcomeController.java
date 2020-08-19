package com.techm;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techm.service.LoginService;

@Controller
public class WelcomeController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";
	
	LoginService service = new LoginService();

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "Login";
	}
	
	@RequestMapping("/Login")
	protected String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String password = request.getParameter("pass");
		
		if(service.validate(uname, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			
			return "welcome";
			
		}else {
			return "Login";
		}
		
		
	}
	
	@RequestMapping("/Logout")
	protected String getOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.invalidate();
		return "Login";
		
		
	}

}
