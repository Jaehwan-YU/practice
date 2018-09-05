<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<header id="header">
	<h1>
		<a href="">
			<picture>
				<source srcset="/jaehwan/resources/academy/logo-test.png" media="(min-width: 700px)"/>
				<img src="/jaehwan/resources/academy/sist-logo.png" alt="쌍용강북교육센터">
			</picture>
		</a>
	</h1>
	<section id="header-buttons">
		<h1 class="hidden">헤더버튼</h1>
		<input type="button" value="검색" class="find-button button" /> <input
			type="button" value="메뉴보기" class="hamburger-button button" />
	</section>
	<aside id="login-info">
		<h1 class="hidden">메인메뉴</h1>
		<section id="profile">
			<h1 class="hidden">프로필</h1>
			<div>
				<div class="photo" style="background: url('/jaehwan/resources/images/photo-test2.jpg') no-repeat center; background-size: cover;"></div>
				<div class="uid"><span>jaehwan</span></div>
				<%-- <%=  request.getUserPrincipal().getName() %>
				${pageContext.request.userPrincipal.name} --%>
				<c:if test="${empty pageContext.request.userPrincipal}">
					<div class="auth-status"><a href="/jaehwan/member/login">로그인</a></div>
				</c:if>
				<c:if test="${not empty pageContext.request.userPrincipal}">
					<div class="auth-status"><a href="/jaehwan/member/logout">로그아웃</a></div>
				</c:if>
				<div class="notice"><span>강사공지 : </span><a href="">3</a></div>
			</div>
		</section>
		<section id="teacher-menu">
			<h1 class="hidden">메인메뉴</h1>
			<ul>
				<li><a href="/jaehwan/teacher/question/choice-reg">문제관리</a></li>
				<li><a href="">시험관리</a></li>
				<li><a href="">일정관리</a></li>
				<li><a href="">수업관리</a></li>
			</ul>
		</section>
	</aside>
</header>
<script>
	window.addEventListener("load", function() {
		var header = document.querySelector("#header");
		var hamburgerButton = header.querySelector(".hamburger-button")
		var mainMenu = header.querySelector("#teacher-menu");

		hamburgerButton.onclick = function(e) {
				header.classList.add("menu-show");
				e.stopPropagation();
		}
		
		header.onclick = function(e) {
			if(e.target.nodeName == "HEADER" && header.classList.contains("menu-show"))
				header.classList.remove("menu-show");
			else return;
		}
	});
</script>