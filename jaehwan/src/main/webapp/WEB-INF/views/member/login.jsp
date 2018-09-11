<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<main>
  	<section>
  		<h1>회원 로그인</h1>
  		<form method="post">
  			<table>
  				<tr>
  					<td>
  						<label>아이디 : </label>
  						<input name="username"/>
  					</td>
  				</tr>
  				<tr>
  					<td>
  						<label>비밀번호 : </label>
  						<input type="password" name="password"/>
  					</td>
  				</tr>
  				<tr>
  					<td>
  						<input type="submit" value="로그인"/>
  					</td>
  				</tr>
  			</table>
  		</form>
	</section>
	<%
    String clientId = "XMTHqpFScFytCftpQyVg";//애플리케이션 클라이언트 아이디값";
    String redirectURI = URLEncoder.encode("http://localhost:8080/jaehwan/index", "UTF-8");
    SecureRandom random = new SecureRandom();
    String state = new BigInteger(130, random).toString();
    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
    apiURL += "&client_id=" + clientId;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&state=" + state;
    session.setAttribute("state", state);
 	%>
  <a href="<%=apiURL%>"><img height="50" src="http://static.nid.naver.com/oauth/small_g_in.PNG"/></a>
</main>