<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%
	String color="";
	request.setCharacterEncoding("UTF-8");
	String sel= request.getParameter("color");
	if(sel==null)
		sel="���";
	
	if(sel.equals("�Ķ���")){
		color="blue";
	}
	else if(sel.equals("�����")){
		color="yellow";
	}
	else if(sel.equals("�ʷϻ�")){
		color="green";
	}
	else if(sel.equals("������")){
		color="black";
	}
	else if(sel.equals("������")){
		color="red";
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body bgcolor="<%=color %>">
   <form method="post" action="basic_8.jsp">
	<select name="color">
	 <option>�Ķ���</option>
	 <option>�����</option>
	 <option>�ʷϻ�</option>
	 <option>������</option>
	 <option>������</option>
	</select>
	<button>����</button>
	</form>
</body>
</html>