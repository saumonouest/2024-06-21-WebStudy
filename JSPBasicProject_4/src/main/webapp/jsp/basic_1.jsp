<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%--
	JSP 동작 구조
	1. jsp 파일 요청 => URL 
	   http://localhost:8080/JSPBasicProject_4/jsp/basic_1.jsp
	
	2. 웹서버가 요청을 받는다
	   http
	   => 해결 => .html / .xml
	   => .jsp / servlet => 처리를 못한다
	   	  ==============
	   	  3. WAS(TomCat)로 전송
	   	  	 ==========
	   	  	 4. .jsp 파일을 => 자바로 변경
	   	  	 	a.jsp => a_jsp.java
	   	  	 	=====
	   	  	 	코딩한 내용을 => public void _jspService()에 첨부
	   	  
	5. 컴파일 => a_jsp.class
	
	6. 실행 (인터프리터)
	   out.write()에 있는 내용만 메모리 저장
	
	7. 저장된 메모리에 브라우저 읽어서 출력
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- 화면에 출력하는 태그 -->
	

</body>
</html>