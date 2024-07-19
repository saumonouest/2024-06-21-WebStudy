<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%--
       prefix="c"
 --%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  

<%--
	JSTL (JSP Standard Tab Library)
		  => 태그로 제어문, String, 날짜, 숫자 . . . 화면 이동 => jstl-1.2.jar
		  => 자바문법을 태그로 제작 (사용자 정의)
		  => EL / JSTL => JSP 화면 출력
		  => 1. core : 제어문, 변수 선언, 화면 이동
		  		제어문
		  			반복문
		  			 <c:forEach>
		  			조건문 
		  			 <c:if> => 단점은 else가 없다
		  			선택문
		  			 <c/choose>
		  			  <c:when></c:when>
		  			  <c:when></c:when>
		  			  <c:others
		  			
		  	 2. fmt : 날짜 변환, 숫자 변환
		  	 3. fn : String 메소르를 처리
		  	 =========
		  	 4. xml
		  	 5. sql
		  	 ========= 노출 => 순수 자바 (DAO)
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>일반 자바 for문</h3>
	<%
		for(int i=1;i<=10;i++){
	%>		
		<%=i %>&nbsp;
	<%		
		}
	%>
	<h3>JSTL의 forEach문</h3>
	 <c:forEach var="i" begin="1" end="10">
	 ${i }&nbsp;
	 </c:forEach>
</body>
</html>











