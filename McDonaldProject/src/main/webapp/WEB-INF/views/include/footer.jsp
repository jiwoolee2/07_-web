<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String year =
	 	new java.text.SimpleDateFormat("yyyy").format(new java.util.Date());
	%>



	<pre>
		인천광역시 남동구 용천로 87번길 23
		<%=year %>년도 information Security querySelector
	</pre>



</body>
</html>