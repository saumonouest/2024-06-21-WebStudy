<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%--
	�ڹ� ���� ���
	���
	if / if ~ else / if~else if~else
	
	if
	=> ������ / �Ϲ� ����� ����
		if(admin==1) => ������������
		else => ����������
	while / for / break
	while : ���ѽ�ũ��
	for : ���
	break : ������ 
	
	if~else if~else
	=> ���� ���
	
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	// 1 ~ 100���� => ¦���� / Ȧ���� / ��ü��
	int sum=0, even=0, odd=0;
	for(int i=1;i<=100;i++){
		sum+=i;
		if(i%2==0)
			even+=1;
		else
			odd+=1;
	}
%>
	<%= "1~100���� ����:"+sum %><br>
	<%= "1~100���� ¦����:"+even %><br>
	<%= "1~100���� Ȧ����:"+odd%><br>
</body>
</html>