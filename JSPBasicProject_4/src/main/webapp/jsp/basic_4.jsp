<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%--
	��ũ��Ʈ��
	<% %> => �ڹ� �Ϲ� �ҽ�
	<%= %> => ȭ�鿡 ������ ��� => out.print(�ȿ� ���� �ڵ�) => ;������� �ʴ´�
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="table.css">
<style type="text/css">
.table_content{
	margin: 0px auto;
	width:600px;
}
h3{
	text-align : center;
}
</style>
</head>
<body>
	<h3>������</h3>
	<table class="table_content">
	 <tr>
	 <%
	 	for(int i=2;i<9;i++){
	 %>
	  <th><%=i+"��" %></th>
	  <%
	 	}
	  %>
	 </tr>
	 <%
	 	for(int i=1;i<=9;i++){
	 %>
	 	<tr>
	 	<%
	 		for(int j=2;j<=9;j++){
	  
	 	%>
	 		<td class="tdcenter">
	 		<%= j+"*"+i+"="+(j*1) %>
	 		</td>
	 	<% 
	 		}
	 	%>
	 	</tr>
	 <%		
	 	}
	 %>
	</table>
</body>
</html>