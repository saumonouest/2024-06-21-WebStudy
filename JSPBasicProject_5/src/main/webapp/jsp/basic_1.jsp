<%@ page info="지시자에 대한 학습" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="16kb"%>
<%@ page import="java.io.*" %>
<%@ page import="java.text.*, java.sql.*" %>
<%--
	속성을 사용하지 않으면 디폴트 적용
--%>
<%-- 
	JSP (Java Server Page)
	1) HTML / Java => 구분 <% %> <%= %> <%! %>
	2) 지시자 : 139page
		page
			JSP의 기본 정보를 저장하고 있음
			지시자 : <%@ 지시자명 속성="값" 속성="값"... %>
						page  contentType="text/html"
				   <%@ include file="파일명"%>
				   ========================= JSP는 조립식 프로그램
				   <%@ taglib prefix="c" ... %>
				   		<c:forEach> => <core:forEach>
		 속성 
		  info : 작성자, 작성일 
		  language
		  contentType
		  extends : 확장 (상속) => 거의 사용하지 않는다
		  import : 라이브러리 읽을 때 사용
		  			생략 : java.lang
		  				  javax.servlet.http.*
		  			여러개 사용이 가능
		  			<%@ page import="java.util.*, java.io.*"%>
		  			<%@ page import="java.util.*"%>
		  			<%@ page import="java.io.*"%>
		  			*** 다른 속성은 1번만 사용이 가능 
		  			*** 속성 : 이미 지정되어 있다 (지정된 것만 사용이 가능)
		  				값은 반드시 "" 를 사용한다 => 오류 발생 
		  			*** 공백을 반드시 사용한다 
		  session : session 사용 여부 => default : true
		  			서버에 일부 정보를 저장할 경우 => 사용자 정보 저장 (로그인)
		  			=> 브라우저 종료 / 로그아웃 => 세션이 해제
		  			=> cookie : 브라우저에 저장
		  				=> 보안에 취약 : 방문한 맛집...
		  			
		  buffer : html 코드를 저장하는 공간(메모리)
		  		   => 8kb => 2배수
		  		   	  16kb
		  		   => 임시 저장 장소 : 출력 버퍼
		  autoFlush : 화면에 출력 => 이동 (이전 HTML을 지워야 한다)
		  			  => 접속자 한 사람마다 => 출력버퍼를 한 개만 사용이 가능 => true
		  			  					  ======================
		  			  
		  isThreadSafe : 쓰레드 사용 여부 => true
		  trimDirective : 에러발생 시 보여주는 페이지를 만든다 
		  				   1개만 제작
		  				   
		  WhiteSpace : 에러페이지 여부 확인 
		  				종류별로 제작이 가능 
		  				
		  errorPage
		  isErrorPage
		  pageEncoding
		taglib
		include
		
	3) 내장객체
		request
		response
		session
		out
		application
		config
		exception
		page
		pageContext
		
	4) cookie
	
	5) JSP 액션 태그 <jsp:include> <jsp:useBean> <jsp:forward>
	============================================================= Basic
	
	6) 데이터베이스 연동 / 자바빈즈
	
	7) EL / JSTL
	
	8) MVC
	============================================================= Middle
		

--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>