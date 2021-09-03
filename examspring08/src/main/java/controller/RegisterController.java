package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.AlreadyExistingMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

@Controller
@RequestMapping(value="/register/")
public class RegisterController {
	
	@RequestMapping(value="step1")
	public String step1() {
		return "register/step1";
		//  /WEB-INF/views/register/step1.jsp
	}
	
	//@RequestMapping(value="step2", method=RequestMethod.POST)
	@PostMapping("step2")
	public String step2(@RequestParam(value="agree", defaultValue="false") Boolean agree, Model model) {
		System.out.println(agree);
		if(!agree) {
			return "redirect:/register/step1";
		}
		model.addAttribute("formData", new RegisterRequest());
		return "register/step2";
	}
	
	//@RequestMapping(value="step2", method=RequestMethod.GET)
	@GetMapping("step2")
	public String step2() {
		return "redirect:/register/step1";
	}
	
	private MemberRegisterService memberRegisterService;
	
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}
	
	@RequestMapping(value="step3", method=RequestMethod.POST)
	public String step3(@ModelAttribute("formData")RegisterRequest regReq) {
		try {
			memberRegisterService.regist(regReq);
			return "register/step3";
		}catch(AlreadyExistingMemberException e) {
			return "register/step2";
		}
	}
	
}






