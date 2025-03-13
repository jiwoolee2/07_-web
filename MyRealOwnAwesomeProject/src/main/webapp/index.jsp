<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>로그인/로그아웃</h1>
	
	
	
	<c:choose>
		<c:when test="${ empty loginUser }">
			<form action="login" method="post" name="login">
				아이디 : <input name="userId" placeholder="아이디를 입력해주세요">
				비밀번호 : <input name="userPw" placeholder="비밀번호를 입력해주세요">
				<button>로그인로그로그인</button>
			</form>
					
			<form action="signup-page" method="post" name="signup">
				<button>회원가입</button>
			</form>		
		</c:when>
		<c:otherwise>
			<form action="logout" METHOD="post" name="logout">
				<button>로그아웃~~~~~~~</button>
			</form>		
		</c:otherwise>
	</c:choose>
	

</body>
</html>	