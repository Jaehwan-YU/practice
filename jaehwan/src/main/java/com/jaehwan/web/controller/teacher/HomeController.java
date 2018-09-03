package com.jaehwan.web.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("teacheHomeController")
@RequestMapping("/teacher/")
public class HomeController {

	@GetMapping("index")
	public String index() {
		return "teacher.index";
	}
}
