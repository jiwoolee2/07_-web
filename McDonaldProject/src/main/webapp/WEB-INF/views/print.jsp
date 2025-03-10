<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String brand = (String)request.getAttribute("brand");
%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>굉장히 중요하거덩요</title>
</head>
<body>


	<br>
	
	${ brand } <br>
	${ bestSeller }
	
</body>
</html>