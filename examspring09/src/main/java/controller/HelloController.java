package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController { //컨트롤러

	@RequestMapping(value="/hello")
	public String hello(
			Model model,
			@RequestParam(value="name", required=false) String name) {
		
		model.addAttribute("greeting", "안녕하세요~" + name+"님ㅋㅋㅋ"); //모델
		return "hello"; //뷰
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(HttpServletRequest req) {
		int n1 = Integer.parseInt(req.getParameter("n1"));
		int n2 = Integer.parseInt(req.getParameter("n2"));
		
		req.setAttribute("ret", n1 + n2);
		
		return "add";
	}
	
	@RequestMapping(value="/add2", method=RequestMethod.GET)
	public String add(Model model, int n1, int n2) {

		//서비스 객체 기능~ 결과를 받으면
		model.addAttribute("ret", n1 + n2);
		
		return "add";
	}
	
	@RequestMapping(value="/add3", method=RequestMethod.GET)
	@ResponseBody //뷰를 사용하지 않고 바로 문자열을 응답함
	public String add(int n1, int n2) {
		return "브라우저에 바로 응답:" + (n1 + n2);
	}
}












