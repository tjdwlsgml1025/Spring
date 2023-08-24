<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="s"%>
<html>
<head>
<title>list</title>

</head>
<body>
	<h1>메인페이지</h1>

	<!-- 로그인을 했다면 -->
	<sec:authorize access="isAuthenticated()">

		<sec:authentication property="principal.username" /> 님 환영합니다.
      <%-- <h1>${auth.username}</h1> --%>
	</sec:authorize>

	<sec:authorize access="isAnonymous()">      
      로그인이 필요합니다.         
   </sec:authorize>

</body>
</html>