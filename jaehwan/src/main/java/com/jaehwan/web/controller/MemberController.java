package com.jaehwan.web.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jaehwan.web.dao.MemberDao;
import com.jaehwan.web.dao.mybatis.MybatisMemberDao;
import com.jaehwan.web.entity.Member;
import com.jaehwan.web.service.MybatisHomeService;

@Controller
@RequestMapping("/member/")
public class MemberController {
	
	@Autowired
	private MybatisHomeService service;
	/*@Autowired
	private MemberDao memberDao; */
	
	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("join")
	public String join(Model model) {

		
		return "member.join";
	}
	
	@GetMapping("email-join")
	public String emailJoin(){
	
		return "member.email-join";
	}
	
	
	@GetMapping("is-id-duplicated")
	@ResponseBody
	public String isIdDuplicated(String id) {
		boolean duplicated = service.isIdDuplicated(id);
		
		if(duplicated)
			return "true";
		
		return "false";
	}
	
	@GetMapping("email-duplicated-error")
	@ResponseBody
	public String emailDuplicatedError() {
		return "<script>alert('이미 가입되어있는 이메일입니다.');location.href='email-join';</script>";
	}
	
	
	@PostMapping("email-join")
	public String emailJoin(String email, 	HttpServletResponse response){
		boolean duplicated = service.isEmailDuplicated(email);
		
		if(duplicated)
			return "redirect:email-duplicated-error";
		
		UUID uuid = UUID.randomUUID();
		MessageDigest salt = null;
		String digest = null;

		try {
			salt = MessageDigest.getInstance("SHA-256");
			salt.update(uuid.toString().getBytes());
			
			byte[] key = salt.digest();
			//바이트열을 문자열로 바꾸기 위해서 더하기가 반복되어야 한다
			StringBuilder builder = new StringBuilder();
			for(byte b : key) {
				builder.append(String.format("%02x", b));
			}
			digest = builder.toString();
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(uuid);
		System.out.println(digest);	
		System.out.println(email);
		
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setFrom("noreply@newlecture.com");
			helper.setTo(email);
			helper.setSubject("뉴렉처 회원가입을 위한 인증메일");
			helper.setText("<a href=\"http://211.238.142.41:8080/jaehwan/member/join-reg?id="
								+digest+"&em="+email+"\">가입링크</a>", true);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Cookie cookie = new Cookie("joinId", digest);
		cookie.setPath("/jaehwan/member/");
		cookie.setMaxAge(60*60*24);
		
		response.addCookie(cookie);
		
		mailSender.send(message);
		return "member.email-join-info";
	}
	
	@GetMapping("join-reg")
	public String joinReg(@RequestParam(value="id", defaultValue="") String key,
							@RequestParam(value="em", defaultValue="") String email,
							@CookieValue(value="joinId", defaultValue="") String joinId,
							Model model) {
		System.out.println(key);
		System.out.println(email);
		System.out.println(joinId);
		
		/*if(key.equals("") || joinId.equals("") || !key.equals(joinId))
			return "member.join-error";*/
		
		String uid= email.split("@")[0];
		
		model.addAttribute("uid", uid);
		model.addAttribute("email",email);
		
		return "member.join-reg";
	}
	@PostMapping("join-reg")
	public String joinReg(Member member, @RequestParam("photo-file") MultipartFile photoFile) {
		return "redirect:";
	}
	
	@GetMapping("login")
	public String login(HttpSession session) {
		return "member.login";
	}

}
