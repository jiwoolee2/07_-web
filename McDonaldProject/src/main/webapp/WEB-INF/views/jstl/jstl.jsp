<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- -> 이거 쓰는 이유? : JSP상에서 if문 for문 편하게 쓰려고  --> 
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>JSTL이란...></h1>
	
	<p>
		JSP Standard Tag Library의 약어 JSP에서 사용할 수 있는 커스텀 액션 태그 <br>
		공통적으로 사용해야하는 코듣들을 보다 쉽게 사용할 수 있도록 태그화해서 표준으로 제공하는 라이브러리 모음
	</p>
	
	<hr>
	
	<p>
		JSTL을 사용하기 위해선 먼저 라이브러리를 추가해준 후 <br>
		JSTL을 사용하고자 하는 JSP페이지 상단에 선언을 해 주어야함 !! <br>
	</p>
		
	<% if(true) { %>	
		ABCDE
	<%} %>	
	<!-- -> 이렇게 쓰면 굉장히 불편함요 -->	
	
	<h2>Core 라이브러리 실천압축핵심요약 빠르게 배우고 넘어가기</h2>
	
	<p>
		if라는 태그를 작성하여 조건문을 만들어 낼 수 있음! <br>
		- java에서의 단일 if문과 똑같은 역할을 할 수 있는 태그 <br>
		- 조건식은 test속성의 값으로 작성
		- 조건식을 만들 때 반드시 EL 구문으로 작성 !!!!!!!!!!!!
	</p>
	
	<c:if test="${1 lt 2 }">
		<strong>1이 2보다 작습니다!!!!!!!!!!!</strong>
	</c:if>
		
	<!-- 출력 X -->
	<c:if test="${1 gt 2 }">
		<strong>1이 2보다 큽니다!!!!!!!!!!!</strong>
	</c:if>
		
	<c:if test="${'안녕하세요' ne '반갑습니다' }">
		<mark>안녕하세요와 반갑습니다는 같지 않습니다.</mark>
	</c:if>
		
	
	<h3> 2) choose, when, otherwise </h3>	
	<!-- choose내부에는 when, otherwise만 가능, 주석도 안됨  -->	
	
	<!-- point라는 키값으로 Value가 넘어옴  -->	
	<!-- 
		point 사용량이 100이하라면 일반회원이라고 출력해주고 싶음
		point 사용량이 300이하라면 우수회원이라고 출력해주고 싶음
		요 앞에 두 케이스에 걸리지 않을 시 최우수회원이라고 출력해주고 싶음
	 -->
	<c:choose>
		<c:when test="${point le 100}">
			일반회원 <br>
		</c:when>
		<c:when test="${point le 300}">
			<label style="color:gold">우수회원</label>
		</c:when>
		<c:otherwise>
			<mark style="color:pink">최우수회원</mark>
		</c:otherwise>
	</c:choose>	
		
	<h3> 3) 반복문 - forEach </h3>
	
	<pre>
		[ 표현법 ]
		for loop문
		&lt;c:forEach var = "속성명" begin = "초기값" end = "끝값" step = "증가시킬값(생략 가능)"&gt;
			반복적으로 실행할 내용
		&lt;c:/forEach&gt;
		
		&lt;c:forEach var = "속성명" item = "순차적으로 접근할 배열 또는 컬렉션" &gt;
			반복적으로 실행할 내용
		&lt;c:/forEach&gt;
	</pre>
	
	<c:forEach var="i" begin="0" end="9">
		${i}
	</c:forEach>
	<br>
	
	<c:forEach var="i" begin="1" end="6">
		<h${i}>이런 것도 가능</h${i}>
	</c:forEach>
	
	
	<br>
	
	<hr>
	<ul>
		<c:forEach var="c" items="${ colors }">
			<li style = "color:${c}">${c}
		</c:forEach>
	</ul>
	
	
	<hr>
	
	
	<h3>회원목록</h3>
	<!-- 
		caption,
		thead, tbody, tfoot
		tr
		th, td
	
	 -->
	
	<table class="table table-dark">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>아이디</th>
				<th>가입일</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${ empty requestScope.users }">
					<tr>
						<td colspan="4">조회결과가 존재하지 않습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
               		<c:forEach items="${ requestScope.users }" var = "user">
	                  <tr>
	                     <td>${ user.userNo }</td>
	                     <td>${ user.userName }</td>
	                     <td>${ user.userId }</td>
	                     <td>${ user.enrollDate }</td>
	                  </tr>
               </c:forEach>
            </c:otherwise>
			</c:choose>
		
		</tbody>	
		
	
	
	</table>
	
	
	
	

	
	
	
	
	
	<br><br><br><br><br><br><br><br><br><br><br><br>
	
	
	
	
		
		
		
</body>
</html>