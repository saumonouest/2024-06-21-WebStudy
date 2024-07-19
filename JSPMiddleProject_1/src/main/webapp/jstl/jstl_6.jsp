<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List<String> names = new ArrayList<String>();
	List<String> sex = new ArrayList<String>();
	
	names.add("서연우"); sex.add("여자");
	names.add("이다훈"); sex.add("남자");
	names.add("맹주희"); sex.add("여자");
	names.add("정유엽"); sex.add("남자");
	names.add("심은우"); sex.add("남자");
	
	request.setAttribute("names", names);
	request.setAttribute("sex", sex);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>자바 : for</h1>
	<ul>
	 <%
	 	for(int i=0;i<names.size();i++){
	 %>		
	 	<li><%=names.get(i) %>-<%=sex.get(i) %></li>
	 <%	
	 	}
	 %>
	</ul>
	<h1>JSTL : for</h1>
	<ul>
	 <c:forEach var="name" items="${names }" varStatus="s">
		 <li>${name }-${sex[s.index] }</li>
	 </c:forEach>
	</ul>
</body>
</html>










