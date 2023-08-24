<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> <!-- 시큐리티태그라이브러리 -->

<html>
<head>
<title>list</title>

</head>
<body>
	<h1>유저 페이지</h1>

	<p>principal: <sec:authentication property="principal"/></p>
	<p><sec:authentication property="principal.username"/> 님 환영합니다</p>
	
		
	<p><a href="<c:url value="/" />">홈</a></p> 
	

</body>
</html>