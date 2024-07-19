<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
	EL => 표현식(브라우저에 데이터 출력) <%= %> 대체
	JSTL => 자바 제어문, 변수선언, 화면이동 => 태그형으로 변경
	JSP => 태그로 제작을 한다 (자바를 사용하지 않는다)
		HTML + Java
		=> HTML => 결과값만 출력
		   Java => 요청처리 => 결과값 전송 (Back) => 보안, 분산, 재사용이 가능
					=> 
		MV => 소스는 통일 => 파일이 많아진다
		
	EL => ${값}
			= 일반 데이터 사용이 가능 (자바 변수는 출력할 수 없다)
			  ${1234}, ${"Hello"}
			  String name="";
			  ${name} => 출력이 불가능
			  ======= 반드시 : request.setAttribute()
			  				 session.setAttribute()
			  => request.setAttribute("name","홍길동")
			  						   ====
			  	 ${name}
			  	 ======= request의 키값을 설정 => 해당값을 출력
			  	 
			  	 ${requestScope.name}
			  	 ==================== 생략이 가능
			  	 
			  => session.setAttribute("name","홍길동")
			  	 ${name}
			  	 ${sessionScope.name}
			  	 
			  => request의 키와 session의 키가 동일할 때 request가 우선순위다
			  => param / paramValues - request.getParameterValues()
			  	 ㄴrequest.getParameter()
			  	 => 사용 빈도가 거의 없다
			  	 
		JSP => 요청 => Java => 요청처리 => JSP 
									request/session에 결과값을 담아서 넘겨준다
													 ==================
													  setAttribute()
													  	|
													  ${}
		
		연산자 
			산술연산자
				+ : 산술만 처리
				+=: 문자열 결합
				${"10"+10} => Integer.parseInt()
				${null+10} => null은 0으로 취급
				/ : 정수 / 정수 = 실수
				  : div로 쓸 수 있음
				% : mod
			======= 숫자 외에 문자열 / 날짜도 비교 가능
			비교연산자
				== eq => ${vo.id==sessionScope.id}
				!= ne
				<  lt
				>  gt
				<= le
				>= ge
				
			논리연산자
				&& and
				|| or
			======= <c:id test=""> <c:when test="">
			
			=> 객체 단위 출력
			   ${객체명.변수명}
			   	 ==== ====
			   	 key명 getXxx() => ${vo.ename} => ${vo.getEname()}
			   	 
		JSTL : Tag로 자바 문법사항을 만들었다 
			   === 제어문, 화면이동, 변수선언, 날짜변환, 숫자변환(format), String 메소드 제어 (function)
			   	   ===================	=============================
			   	   		core				자바에서 주로 처리 => 결과값
			   	   <c:set> : request.setAttribute(var, value) 생성
			   	     |
			   	     var : 키
			   	     value : 값
			   	     
			   	   <c:out value=""> => JavaScript와 충돌방지
			   	   						$는 함수
			   	   <c:if test="조건문">
			   	   <c:choose>
			   	    <c:when test=""></c:when>
			   	    <c:when test=""></c:when>
			   	    <c:when test=""></c:when>
			   	    <c:otherwise></c:otherwise>
			   	   </c:choose>
			   	   <c:forEach var="" begin="" end="" step="">
			   	   					  시작	  끝		 증가
			   	   <c:forEach var="" items="" varStatus="">
			   	   					 ======== ============ 인덱스 번호
			   	   					 배열/컬렉션
			   	   <c:forTokens var="" value="" delimt="">
			   	   					   ======== =========
			   	   					   	대상		 구분자
			   	   <c:redirect url=""> : sendRedirect
			   	   <fmt:formatDate><fmt:formatNumber>
			   	   ${fn:length..
	==================> JSP Basic
						========= MV / MVC
	=> Servlet / JSP / Java / DBCP => Jquery
	=> SpringFramework / Java / MyBatis => VueJs
	=> Spring-Boot / Java / JPA => React ==> MySQL
	
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