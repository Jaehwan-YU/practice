<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<main>
	<section id="category">
		<h1>카테고리 관리메뉴</h1>
		<div>
			<div><input type="checkbox" id="recent"><label for="recent">최근설정</label></div>
			<div>객관식문제(<a href="">변경</a>)</div>
			<div><a href="">교과목관리</a></div>
		</div>
		<ul>
			<li>
				<label>교과목</label> 
				<select>
						<option>과목 선택</option>
						<option>자바 기초</option>
				</select>
			</li>
			<li>
				<label>교과단원</label> 
				<select>
						<option>단원 선택</option>
						<option>제어구조</option>
				</select>
			</li>
			<li>
				<label>난이도</label> 
				<select>
						<option>난이도 선택</option>
						<option>하</option>
						<option>중</option>
						<option>상</option>
				</select>
			</li>
		</ul>
	</section>
</main>