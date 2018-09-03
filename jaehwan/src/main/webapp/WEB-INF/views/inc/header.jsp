<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<style>
/* --------- reset style ---------------------------------------------- */
body {
	margin: 0px;
}

#header {
	margin: 0px;
	padding: 0px;
}

h1 {
	margin: 0px;
	padding: 0px;
}

ul {
	margin: 0px;
	padding: 0px;
}

li {
	list-style: none;
	margin: 0px;
	padding: 0px;
}

a {
	text-decoration: none;
}
/* ---------- common style --------------------------------------------- */
.hidden {
	display: none;
}

/*---------- component style ------------------------------------------- */
.button {
	width: 24px;
	height: 24px;
	overflow: hidden;
	text-indent: -999px;
	border: 0px;
	padding: 0px;
}

.hamburger-button {
	background: url("/jaehwan/resources/images/icon-set.png") no-repeat 0px
		0px;
}

.find-button {
	background: url("/jaehwan/resources/images/icon-set.png") no-repeat
		-24px 0px;
}
.photo {
	width: 150px;
	height: 150px;
	border: 3px solid #fff;
	border-radius: 75px;
	display: inline-block;
	box-shadow: 0px 0px 3px 1px #999;
}

.photo-sm {

}
/* ---------- header style --------------------------------------------- */
#header {
	border-bottom: 1px solid #a9a9a9;
	width: 100%;
	height: 45px;
	position: relative;
}

#header > h1{
	display: inline-block;
	position: absolute;
	left: 10px;
	top: 10px;
}

#header #login-info {
	display: block;
	position: fixed;
	height: 100%;
	width: 80%;
	right: -80%;
	top: 0px;
	background: #ffffff;
	z-index: 1;
	transition: 500ms right ease;
}

#header.menu-show #login-info {
	right: 0%;
}

#header:after {
	content: "";
	position: fixed;
	display: block;
	top: 0px;
	left: 0px;
	width: 100%;
	height: 0%;
	background: #000;
	opacity: 0;
	transition: 500ms opacity ease;
}

#header.menu-show:after {
	height: 100%;
	opacity: 0.7;
}

#teacher-menu a {
	color: black;
	font-family: 맑은 고딕, arial;
	font-weight: bold;
}

#teacher-menu ul {
	margin-top: 10%;
	margin-left: 5%;
}

#teacher-menu li {
	margin-bottom: 3%;
}

#header-buttons{
	position: absolute;
	top: 0%;
	right: 0%;
	height: 100%;
	line-height: 45px;
	padding-right: 10px;
}

#profile{
	padding-top: 10px;
	text-align: center;
}

@media all and (min-width: 700px){
	
} 

</style>

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