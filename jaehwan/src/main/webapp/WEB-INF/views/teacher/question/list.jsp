<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main>
<section>
	<h1>검색분류</h1>
	<ul>
		<li>
			<label>교과목</label> 
			<select>
			<c:forEach var="subject" items="${subjects}">
				<option>${subject.title}</option>
			</c:forEach>
			</select>
		</li>
		<li>
			<label>난이도</label> 
			<select>
				<c:forEach var="level" items="${levels}">
					<option>${level.name}</option>
				</c:forEach>
			</select>
		</li>
		<li>
			<label>검색어</label>
			<input />
		</li>
	</ul>
</section>
<section>
	<h1>문제목록</h1>
	<div></div>
	<div></div>
	<div></div>
</section>
</main>