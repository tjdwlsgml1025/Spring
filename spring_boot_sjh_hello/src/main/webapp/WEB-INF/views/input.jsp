<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/board/confirm" method ="GET">
	국어:<input type ="text" name="kor">
	수학:<input type ="text" name="math">
	영어:<input type ="text" name="eng">
	
	<input type ="submit" value="전송">
</form>

</body>
</html>