package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.AuthInfo;
import spring.AuthService;
import spring.IdPasswordNotMatchingException;
import spring.LoginCommand;

@Controller
@RequestMapping("/login")
public class LoginController {

	private AuthService authService;
		
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String form(LoginCommand loginCommand, @CookieValue(value="REMEMBER", required=false) Cookie cookie) {
		if(cookie != null) {
			loginCommand.setEmail(cookie.getValue());
			loginCommand.setRememberEmail(true);
		}
		return "login/loginForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(
			LoginCommand loginCommand, 
			Errors errors, 
			HttpSession session, 
			HttpServletResponse response) {
		
		new LoginCommandValidator().validate(loginCommand, errors);
		if(errors.hasErrors()) {
			return "login/loginForm";
		}
		
		try {
			AuthInfo authInfo = authService.authenticate(
					loginCommand.getEmail(), loginCommand.getPassword());
			//이 인증된 정보는 이 후 세션에 담을 것임
			session.setAttribute("authInfo", authInfo); //세션에 인증정보 저장
			
			//쿠키로 이메일을 브라우저에 저장
			Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getEmail());
			rememberCookie.setPath("/");
			if(loginCommand.isRememberEmail()) {
				rememberCookie.setMaxAge(60*60*24*30); //한달 유지
			} else {
				rememberCookie.setMaxAge(0);
			}
			response.addCookie(rememberCookie);
			
			return "login/loginSuccess";
		}catch(IdPasswordNotMatchingException e) {
			errors.reject("IdPasswordNotMatching"); //글로벌 에러코드
			return "login/loginForm";
		}
	}
	
	
}
















