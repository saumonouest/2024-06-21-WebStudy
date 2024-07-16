<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- 
	<% 
		주석
		// 
		/* */
	%>
	<%!
		자바 문법을 적용
		// /* */
		문장이 종료 => ;
	%>
	out.print(  );
	          <%= 위 괄호에 들어갈 내용이 여기 들어감 %> => ; 을 사용하지 않는다
--%>
<%! 
	// 선언문 => 노출이 된다 => 거의 사용하지 않고 => 클래스를 직접 만들어서 사용
	public int add(int a, int b){
	return a+b;
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		int res=add(10,20);
		out.print(res); //서블릿
	%>
	<%= res %><%-- JSP --%>
	<%-- 
		<% 중복할 수 없음
		예)
		<%
		if(){
		
		}
		%>
		<%
		else if() {
		
		}
		%>
		<%
		else if() {
		
		}
		%>
		

	--%>
</body>
</html>