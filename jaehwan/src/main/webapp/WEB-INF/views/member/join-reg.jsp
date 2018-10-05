<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<main id="main">
	<section id="reg-section">
		<h1>회원가입 페이지</h1>
		<form method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>
						<label>사진 : </label>
						<img class="foto" src=""/>
						<input type="file" hidden="true" name="photo-file" value="사진선택"/>
						<span class="foto-button">사진선택</span>
					</td>
				</tr>
				<tr>
					<td>
						<label>아이디 : </label> 
						<input required="required" class="id-input-text" pattern="[a-zA-Z0-9]{4,20}" name="id" value="${uid }"/>
						<input	type="Button" class="id-check-button" required="required" value="중복조회" />
					</td>
				</tr>
				<tr>
					<td>
						<label>비밀번호 : </label>
						<input required="required" name="pwd" />
					</td>
				</tr>
				<tr>
					<td>
						<label>이름 : </label> 
						<input required="required" name="name" />
					</td>
				</tr>
				<tr>
					<td>
						<label>이메일 : </label> 
						<input name="email"	readonly="readonly" value="${email}"/>
					</td>
				</tr>
				<tr>
					<td>
						<label>다음 계산결과는?<img alt="계산식" name="calc" src="moonjae.jpg"></label>
						<input name="moonjae" type="text"> 
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="회원가입" />
					</td>
				</tr>
			</table>
		</form>
	</section>
</main>
<script type="text/javascript">
 window.addEventListener("load", function(){
	 var formSection = document.querySelector("#reg-section");
	 var idCheckButton = formSection.querySelector(".id-check-button");
	 var idInput = formSection.querySelector(".id-input-text");
	 var submitButton = formSection.querySelector("input[type='submit']");
	 var form = formSection.querySelector("form");
	 var fotoButton = formSection.querySelector(".foto-button");
	 var fotoInput = formSection.querySelector("input[type='file']");
	 var foto = formSection.querySelector(".foto");
	 var isDuplicated = null;
	
	fotoInput.onchange = function(e){
		var file = e.target.files[0];
		
		if(file == undefined){
			foto.removeAttribute("src");
			return;
		}
		if(file.type.indexOf("image/") < 0){
			alert("이미지만 입력해주세요.");
			foto.removeAttribute("src");
			return;
		}
		
		if(file.size > 1024*1024*10){
			alert("10MB 이하의 이미지만 사용할 수 있습니다.");
			foto.removeAttribute("src");
			return;
		}
					
		var reader = new FileReader();
		reader.onload = function(){
			var url = reader.result;
			foto.src = url;
		}
		reader.readAsDataURL(file);
	}
	 
	fotoButton.addEventListener("click", function(){ 
		  var event = new MouseEvent("click",{ 
		   'view':window, 
		   'bubbles':true, 
		   'cancelable':true
		  }); 
		  fotoInput.dispatchEvent(event); 
		 }); 

	 
/* 	 
	 fotoButton.onclick = function(){
		 fotoInput.click();
	 }
 */
	 idCheckButton.onclick = function(){
		  //ajax -> 협력자 백엔드 연락해서 알아봐야 함.
		  //협력자 URL -> /member/is-id-duplicated
		  var id = idInput.value;
		  var request = new XMLHttpRequest();
		  request.onload = function(e){
			  	var duplicated = JSON.parse(request.responseText);
				if(duplicated){
					alert("기존 회원 ID와 중복된 ID 입니다.");
					isDuplicated = true;
				}else{
					alert("사용가능한 ID 입니다.");
					isDuplicated = false;
				}
		  };
		  request.open("GET", "is-id-duplicated?id="+id, true);
		  request.send();
	 }

	 submitButton.onclick = function(e){
		 if(isDuplicated == null){
			 alert("ID 중복검사를 해주세요.");
			 e.preventDefault();;
		 }
		 else if(isDuplicated){
			 alert("이미 중복된 ID입니다. 다른 아이디를 사용해주세요.")
			 e.preventDefault();
		 }
	 }
 })
</script>
