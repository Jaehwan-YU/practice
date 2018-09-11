package com.jaehwan.web.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

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
	@RequestMapping("index")
	public String index(HttpServletRequest request)throws Exception{
		//String str = request.getParameter("access_token");
		String token = "AAAAOnMMeQTJi8fVx0wS7g2ZrhErtsqf0wniuAbLDBgCanPjnMhz9vAPM3rWKd3x9fc4E02xnmO8f88V6BxEyhsxBZA=";// 네이버 로그인 접근 토큰; 여기에 복사한 토큰값을 넣어줍니다.
		String header = "Bearer " + token; // Bearer 다음에 공백 추가
		String apiURL = "https://openapi.naver.com/v1/nid/me";
		URL url = new URL(apiURL);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Authorization", header);
		int responseCode = con.getResponseCode();
		BufferedReader br;
		if(responseCode==200) { // 정상 호출
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else {  // 에러 발생
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = br.readLine()) != null) {
			response.append(inputLine);
		}
		br.close();
		System.out.println(response.toString());
		return "home.index";
	}
	/*@RequestMapping("index")
	public void index1(HttpServletRequest request) throws Exception {
		
		String token = "AAAAOvy/aUbrcbOWZe6lDeHnFG0SNvzIl4j+gbsxxlIFXeXH33QhNL8lkkRnqMZTP7aar2iR3BEnklb8pTUBpmcq8kI=";// 네이버 로그인 접근 토큰; 여기에 복사한 토큰값을 넣어줍니다.
		String header = "Bearer " + token; // Bearer 다음에 공백 추가
		String apiURL = "https://openapi.naver.com/v1/nid/me";
		URL url = new URL(apiURL);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Authorization", header);
		int responseCode = con.getResponseCode();
		BufferedReader br;
		if(responseCode==200) { // 정상 호출
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else {  // 에러 발생
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = br.readLine()) != null) {
			response.append(inputLine);
		}
		br.close();
		System.out.println(response.toString());
	}*/
}
