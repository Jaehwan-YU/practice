package com.jaehwan.web.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jaehwan.web.entity.Question;

@Controller
@RequestMapping("/teacher/question/")
public class QuestionController {
	
	@RequestMapping("type")
	public String type(Model model) {
		
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
