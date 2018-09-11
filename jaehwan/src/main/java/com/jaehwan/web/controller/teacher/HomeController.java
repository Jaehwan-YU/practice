package com.jaehwan.web.controller.teacher;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jaehwan.web.dao.MemberDao;
import com.jaehwan.web.entity.Member;
import com.jaehwan.web.entity.Subject;
import com.jaehwan.web.service.TeacherService;

@Controller("teacheHomeController")
@RequestMapping("/teacher/")
public class HomeController {

	@Autowired
	private TeacherService teacherService ;
	
	@GetMapping("index")
	public String index(Model model) {
		List<Subject> subjects = teacherService.getSubjectList();
		model.addAttribute("subjects", subjects);
		/*Member member = memberDao.get("nayo");
		
		model.addAttribute("member", member);*/
		
		return "teacher.index";
	}
}
