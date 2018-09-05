package com.newlecture.web.config;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.jaehwan.web.dao.MemberRoleDao;
import com.jaehwan.web.dao.mybatis.MybatisMemberRoleDao;
import com.jaehwan.web.entity.MemberRole;

@Component
public class NewlectuerAuthenticationSuccessHandler implements AuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		String memberId = authentication.getName();
		
		MemberRoleDao memberRoleDao = new MybatisMemberRoleDao();
		
		List<MemberRole> memberRoles = memberRoleDao.get(memberId);
		
	}

}
