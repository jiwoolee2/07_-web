<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="sign-up" method="post" name="login">
	<ul>
		<li>회원번호 : <input type="number" name="userNo" placeholder="회원번호를 입력해주세요"></li>
		<li>아이디 : <input name="userId" placeholder="아이디를 입력해주세요"></li>
		<li>비밀번호 : <input name="userPw" placeholder="비밀번호를 입력해주세요"></li>
		<li>이름 : <input name="userName" placeholder="이름을 입력해주세요"></li>
	</ul>
		<button>회원가입</button>
</form>
</body>
</html>