package com.jaehwan.web.controller.teacher;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jaehwan.web.entity.QuestionLevel;
import com.jaehwan.web.entity.Question;
import com.jaehwan.web.entity.Subject;
import com.newlecture.web.service.MybatisTeacherService;

@Controller
@RequestMapping("/teacher/question/")
public class QuestionController {
	
	//@Autowired
	private MybatisTeacherService service;
	
	@RequestMapping("type")
	public String type(Model model, Principal principal) {
		System.out.println(principal.getName());
		model.addAttribute("test", "예아");
		
		return "teacher.question.type";
	}
	
	@GetMapping("choice-reg")
	/*@RequestMapping(value="reg", method=RequestMethod.GET)*/
	public String reg() {
		
		return "teacher.question.choice-reg";
	}

	@GetMapping("list")
	public String list(Model model) {
		
		List<Subject> subjects = service.getSubjectList();
		List<QuestionLevel> levels = service.getLevelList();
		
		model.addAttribute("subjects", subjects);
		model.addAttribute("levels", levels);
		
		return "teacher.question.list";
	}

	
	@PostMapping("choice-reg")
	public String reg(Question question) {
		
		return "redirect:type";
	}
	

}
