<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Date date = new Date();
%>
<c:set var="date" value="<%=date %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Java : 날짜 출력</h3>
	<%=date %>
	<%=new SimpleDateFormat("yyyy-MM-dd").format(date) %>
	<h3>EL : 날짜출력</h3>
	${date }
	<fmt:formatDate value="${date }" pattern="yyyy-MM-dd"/>
	<h3>Java: 숫자 변환</h3>
	<%= 1234567 %><br>
	<%
		DecimalFormat d = new DecimalFormat("###,###,###");
	%>
	<%=d.format(1234567) %>
	<h3>JSTL : 숫자변환</h3>
	${1234567 }<br>
	<fmt:formatNumber value="${1234567 }" type="currency"/>
	<%-- 자바, 오라클에서 변환 출력 TO_CHAR() --%>
</body>
</html>








