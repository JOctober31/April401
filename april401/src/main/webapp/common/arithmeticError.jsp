<%--
       파일명:uri
	작성자:
	작성일:2020. 2. 20.	
	isErrorPage="true": 나는 ErrorPage
	ie( 512byte 미만이면 IE page를 보여 준다.)
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	isErrorPage="true"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
	<h2>에러 페이지:ArithmeticException</h2>
	<hr/>
	<p>요청 처리 과정에서 에러가 발생 했습니다.
	빠른 시간 내에 문제를 처리하도록 하겠습니다.</p>
	
	에러타입:<%=exception.getClass().getName() %><br/>
	에러메시지:<%=exception.getMessage() %>                       
                                             	                                                                  
</body>
</html>