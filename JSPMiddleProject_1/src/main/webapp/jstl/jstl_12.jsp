<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String msg="서연우임둥~~ 야호";
%>
<c:set var="msg" value="<%=msg %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Java : 문자열 제어</h1>
	<%=msg.length() %><br>
	<%=msg.substring(0,3) %><br>
	<%=msg.replace("서", "한") %>
	<h1>JSTL : 문자열 제어</h1>
	${fn:length(msg) }<br>
	${fn:substring(msg,0,3) }<br>
	${fn:replace(msg,'서','한') }
</body>
</html>