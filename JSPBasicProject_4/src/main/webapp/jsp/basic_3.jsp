<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- 
	<% 
		�ּ�
		// 
		/* */
	%>
	<%!
		�ڹ� ������ ����
		// /* */
		������ ���� => ;
	%>
	out.print(  );
	          <%= �� ��ȣ�� �� ������ ���� �� %> => ; �� ������� �ʴ´�
--%>
<%! 
	// ���� => ������ �ȴ� => ���� ������� �ʰ� => Ŭ������ ���� ���� ���
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
		out.print(res); //����
	%>
	<%= res %><%-- JSP --%>
	<%-- 
		<% �ߺ��� �� ����
		��)
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