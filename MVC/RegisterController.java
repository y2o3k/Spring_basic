package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller 
public class RegisterController {
	//@RequestMapping(value = "/register/save ", method=RequestMethod.GET) //신규회원 가입 
	//@RequestMapping("/Register/add")
	@GetMapping("/register/add") //4.3부터 추가
	public String register() {
		return "registerForm"; 
		
	}
	
	//@RequestMapping(value ="/register/save", method=RequestMethod.POST)// 신규회원 가입 
	//@PostMapping("/register/save")
	@PostMapping("/register/save")
	public String save (@ModelAttribute("user") User user, Model m) throws Exception{
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못", "UTF-8");
			m.addAttribute("msg", msg);
			return "redirect:/register/add"; //신규회원 가입화면으로 이동(redir
			
			
		}
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return true; 
	}
}
