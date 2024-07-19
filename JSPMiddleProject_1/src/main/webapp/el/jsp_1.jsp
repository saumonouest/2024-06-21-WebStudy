<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List<String> list=new ArrayList<String>();
	list.add("서연우");
	list.add("이다훈");
	list.add("배고파");
	list.add("따흐흑");
	list.add("집 보내라");
	
	request.setAttribute("list", list );
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이름 출력</h1>
	<ul>
	<%
		for(String name:list){
	%>		
		<li><%=name %></li>
	<%	
		}
	%>
	</ul>
	<h1>이름 출력2</h1>
	<ul>
	 <c:forEach var="name" items="${list }">
	 </c:forEach>
	</ul>
</body>
</html>








