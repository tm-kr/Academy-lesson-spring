package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	public HelloController() {
		System.out.println("HelloController()");
	}
	
	@RequestMapping(value="/hello")
	public String hello(HttpServletRequest req) {
		
		String name = req.getParameter("name");
		System.out.println(name);
		
		req.setAttribute("name", name);
		return "hello";
	}
	
	@RequestMapping(value="/hello2")
	public String hello2(Model model, String name) {
		model.addAttribute("name", name);
		return "hello";
	}
	
	@RequestMapping(value="/hello3")
	public String hello3(Model model, @RequestParam(value="name", required=false) String name) {
		model.addAttribute("name", name);
		return "hello";
	}

}
