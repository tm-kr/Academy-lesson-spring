package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.AlreadyExistingMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

@Controller
@RequestMapping("/register/")
public class RegisterController {	
	@RequestMapping("step1")
	public String handleStep1() {
		return "register/step1";
		//	/WEB-INF/views/ + register/step1 + .jsp
	}
	
	@RequestMapping(value="/step2", method=RequestMethod.POST)
	public String handleStep2(@RequestParam(value="agree", defaultValue="false") Boolean agree, Model model) {
		System.out.println("agree:" + agree);
		if(!agree) {
			return "redirect:/register/step1";
		}
		model.addAttribute("formData", new RegisterRequest());
		return "register/step2";
	}
	
	@RequestMapping(value="/step2", method=RequestMethod.GET)
	public String handleStep2() {
		return "redirect:/register/step1";
	}
	
	private MemberRegisterService memberRegisterService;
	
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}
	
	@RequestMapping(value="/step3", method=RequestMethod.POST)
	public String handleStep3(@ModelAttribute("formData") RegisterRequest regReq, Errors errors) {
		
		new RegisterRequestValidator().validate(regReq, errors);
		if(errors.hasErrors()) {
			return "register/step2";
		}
		
		try {
			memberRegisterService.regist(regReq);
			return "register/step3";
		}catch(AlreadyExistingMemberException e) {
			return "register/step2";
		}
	}
	
}










