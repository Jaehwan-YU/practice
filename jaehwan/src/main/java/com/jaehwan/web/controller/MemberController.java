package com.jaehwan.web.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


import com.jaehwan.web.entity.Member;
import com.newlecture.web.service.MybatisHomeService;


@Controller
@RequestMapping("/member/")
public class MemberController {
	
	//@Autowired
	private MybatisHomeService service;

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
	
	@GetMapping("join-email")
	public String joinEmail() {
		return "member.join-email";
	}
	
	@GetMapping("email-duplicated-error")
	@ResponseBody
	public String emailDuplictedError(HttpServletResponse response) {
		
		return "<script> "
				+ "alert('입력하신 이메일 주소로 이미 가입된 정보가 있습니다.'); "
				+ "location.href='join-email'"
				+ "</script>";
	}
	
	@PostMapping("join-email")
	public String joinEmail(String email, HttpServletResponse response) {
		
		boolean duplicated = service.isEmailDuplicated(email);
		
		if(duplicated)
			return "redirect:email-duplicated-error";
		/*-----------------------------------------------------------------*/
		UUID uuid = UUID.randomUUID();
		MessageDigest salt = null;
		String digest = null;
		
		try {
			salt = MessageDigest.getInstance("SHA-256");
			salt.update(uuid.toString().getBytes());
			
			byte[] key = salt.digest();
			StringBuilder builder = new StringBuilder();
			for(byte b : key) {
				builder.append(String.format("%02x", b));
			}
			digest = builder.toString();
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(digest);
		
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setFrom("noreply@eatchu.com");
			helper.setTo(email);
			helper.setSubject("내말맛집 회원가입을 위한 인증메일");
			helper.setText("<a href=\"http://211.238.142.37:8080/jaehwan/member/join-reg?id="+digest+"&em="+email+"\">가입링크</a>", true);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Cookie cookie = new Cookie("joinId", digest);
		cookie.setPath("/jaehwan/member/");
		cookie.setMaxAge(60*60*24);
		
		response.addCookie(cookie);
		
		mailSender.send(message);
		
		return "member.join-email-info";
	}
	
	@PostMapping("join-reg")
	public String joinReg(Member member,
			@RequestParam("photo-file")MultipartFile photoFile,
			HttpServletRequest request) throws IOException {
		
		String resLocation = "/resources/users/"+member.getId()+"/profile/";
		ServletContext context = request.getServletContext();
		String homeDir = context.getRealPath(resLocation);		
		String uploadedFileName = photoFile.getOriginalFilename();
		String filePath = homeDir + uploadedFileName;
		
		System.out.println(filePath);
		
		File dir = new File(homeDir);
		
		if(!dir.exists())
			dir.mkdirs();
		
		InputStream fis =  photoFile.getInputStream();
		FileOutputStream fos = new FileOutputStream(filePath);
	
		//fis에서 읽어서 fos으로 복사하기
		byte[] buf = new byte[1024];
		int size = 0;
		while((size = fis.read(buf, 0, buf.length)) > 0)
			fos.write(buf, 0, size);
		
		fis.close();
		fos.close();
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPwd = encoder.encode(member.getPwd());
		
		member.setPhoto(uploadedFileName);
		member.setPwd(encodedPwd);
		
		service.insertMember(member);
		
		return "redirect:/index";
	}

	@GetMapping("moonjae.jpg")
	public void moonjae(HttpSession session, HttpServletResponse response) throws IOException {
		
		Random rand = new Random();
		int x = rand.nextInt(100);
		int y = rand.nextInt(10);
		
/*		int x = (int) (Math.random() * 50) + 1;
		int y = (int) (Math.random() * 9) + 1;*/
		
		String fmtString = String.format("%d+%d=", x,y);
		
		// 세션 값에 넣기
		session.setAttribute("moonjae", x+y); // checker
		
		// 메모리 상의 이미지가 필요하다. 비트맵이라는 도화지
		BufferedImage img = new BufferedImage(60, 30, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = img.createGraphics();
		g.setFont(new Font("돋움", 0, 13)); // 글씨체, 스타일, 크기
		g.setColor(Color.WHITE); 
		g.fillRect(0, 0, 60, 30); 
		g.setColor(Color.BLACK); 
		g.drawString(fmtString, 5, 19);
		response.setContentType("image/png");
		ImageIO.write(img, "png", response.getOutputStream()); // 예외처리 원래는 해야 함
		
	}
}

