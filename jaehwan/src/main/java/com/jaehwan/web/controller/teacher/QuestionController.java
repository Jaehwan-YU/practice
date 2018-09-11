package com.jaehwan.web.controller.teacher;

import java.nio.file.attribute.UserPrincipal;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jaehwan.web.entity.Question;
import com.jaehwan.web.entity.Subject;

@Controller
@RequestMapping("/teacher/question/")
public class QuestionController {
	
	@RequestMapping("type")
	public String type(Model model/*, HttpServletRequest requestPrincipal principal*/) {
		/*request.getUserPrincipal();*/
		/*System.out.println(principal.getName());*/
		model.addAttribute("test", "예아");

		return "teacher.question.type";
	}
	
	@GetMapping("choice-reg")
	/*@RequestMapping(value="reg", method=RequestMethod.GET)*/
	public String reg() {
		
		return "teacher.question.choice-reg";
	}
	
	@PostMapping("choice-reg")
	public String reg(Question question) {
		
		return "redirect:type";
	}
	

}
