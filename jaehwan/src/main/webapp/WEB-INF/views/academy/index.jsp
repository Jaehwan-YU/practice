<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1{
		display: none;
	}
	h2{
		margin: 0px;
		padding: 0px;
	}
	
	#main-slide {
	position: relative;
	color: #fff;
	height: 400px;
	width: 100%;
	}
	
	#info-box {
		position:absolute;
		background: rgba(255,255,255,0.4);
		color: black;
		right:5%;
		top:5%;
		width: 300px;
		height: 90%;
		font-size: 0.8em;
		vertical-align: middle;
	}
	#info-box div {
		text-align: left;
		height: 40%;
		width: 90%;
		margin: 0 auto;
		background: rgba(255,255,255,0.4);
	}
	
	#hrd-net-review {
		position: absolute;
		top: 400px;
		width: 100%;
		background: #e9e9e9;
	}
	#hrd-net-review table{
		margin: auto;
	}
	.carousel {
		width: 100%;
		height: 100%;
	}
	
	.carousel > ul {
		display: flex;
		position:relative;
		height: 100%;
		width: 300%;
		left: 0%;
		transition: 1s;
	}
	
	.carousel > ul > li:first-child {
		background: url("/jaehwan/resources/images/111.jpeg") no-repeat center;
		background-size: cover;
		min-width: 33.333333333333%;
		height: 100%;
	}
		
	.carousel > ul > li:nth-child(2) {
		background: url("/jaehwan/resources/images/222.jpeg") no-repeat center;
		background-size: cover;
		min-width: 33.333333333333%;
		height: 100%;
	}
	.carousel > ul > li:last-child {
		background: url("/jaehwan/resources/images/333.jpeg") no-repeat center;
		background-size: cover;
		min-width: 33.333333333333%;
		height: 100%;
	}
	.slide-paginator-box {
		position: absolute;
		display: flex;
		bottom: 10px;
		left: 50%;
		transform: translateX(-50%);
	}
	.paginator {
		position: relative;
		display: block;
		margin: 2px;
		padding: 0;
		width: 30px;
		height: 10px;
		background:  rgb(169,209,142);
		border: 1px solid rgb(112,173,71);
		border-radius: 10px;
	}
	
</style>
<script>
	window.addEventListener("load", function(){
		var mainSlide = document.querySelector("#main-slide");
		var carousel = mainSlide.querySelector(".carousel");
		var ul = carousel.querySelector("ul");
		var pos = 0;

		ul.onclick = function(){
		 
		 if(pos > -200)
			 pos -= 100;
		 else
			 pos = 0;
		 
		 ul.style.left = pos+'%';
		}

	})
</script>
</head>
<body>
	<section id="main-slide">
		<h1>메인 슬라이드</h1>
		<div class="carousel">
			<ul>
				<li></li>
				<li></li>
				<li></li>
			</ul>
		</div>
		<div class="slide-paginator-box">
			<span class="paginator"></span> <span
				class="paginator"></span> <span class="paginator"></span>
		</div>
		<section id="info-box">
			<h1>학원 전달사항</h1>
			<div>
				<h2>공지사항</h2>
				<ul>
					<li><a href="">2018년 재직자 주말교육...</a></li>
					<li><a href="">5월 휴무일 안내</a></li>
					<li><a href="">[평일교육]2018년 재...</a></li>
					<li><a href="">2018년 재직자(사업주 ...</a></li>
				</ul>
				<span><a href="">더보기</a></span>
			</div>
			<div>
				<h2>취업현황</h2>
				<ul>
					<li><a href="">김** : 동인정보기술 주식회사</a></li>
					<li><a href="">김** : 포스코 ICT</a></li>
					<li><a href="">장** : 메리츠화재 해상보험</a></li>
					<li><a href="">김** : ㈜첨단</a></li>
				</ul>
				<span><a href="">더보기</a></span>
			</div>
		</section>
	</section>
	<section id="hrd-net-review">
		<h1>수강후기</h1>
		<table>
			<tr>
				<th rowspan="2">HRD-Net 고용노동부 수강후기</th>
				<td>전공자가 아니라서 처음에는 겁을 먹고 시작했는데...</td>
				<td>2018년 07월 애자일 기법에 기반한 클라우드 과정...</td>
			</tr>
			<tr>
				<td>전공자가 아니라서 처음에는 겁을 먹고 시작했는데...</td>
				<td>2018년 07월 애자일 기법에 기반한 클라우드 과정...</td>
			</tr>
		</table>
	</section>
</body>
</html>