<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%
	// ����Ǵ� ���� = �������� => �ʱ�ȭ�� �ؼ� ����Ѵ�
	int a=10;
	int b=20;
	// import ���� ����ϴ� ��� => 123page
	java.util.Date date=new java.util.Date();
	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		out.print(a+b);
	%>
	<%=a+b %>
	<br>
	<%= sdf.format(date) %>
	<%-- 
	155page => <%= ���� | �޼ҵ� %> => �Ϲ� ���ڿ� / ���� / ������
	--%>
	<br>
	<%= a %>&nbsp;<%=a*b %>
	<br>
	<%="Hello JSP"/*��¹�*/%>
	<br>
	<%=10 %>
	<%--
		�ּ� : JSP ��ü �ּ�
		<%
		 // /* */
		%>	
	--%>
</body>
</html>