package com.jaehwan.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jaehwan.web.dao.MemberDao;
import com.jaehwan.web.entity.Member;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("index")
	public String index(Model model) {
		
		Member member = memberDao.get("nayo");
		model.addAttribute("member", member);
	
		return "home.index";
	}

}
