<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%--
	JSP �����ֱ� 
		=> _jspInit() : web.xml�� ȯ�� ���� : �����ڿ� ������ ����
		=> _jspService() : doGet() / doPost() => ����(���ǹ�)
		  ============== JSP���� �ڵ��� �ҽ��� �޼ҵ� �ȿ� ÷��
						 =============== _jspService()�� ����
		=> _jspDestroy() : �޸� ���� 
		
	public void _jspService(HttpServletRequest request, HttpServletResponse response)   
   {
    PageContext pageContext;
    HttpSession session = null;
    ServletContext application;
    ServletConfig config;
    JspWriter out = null;
    Object page = this; // ���� ��ü
    =============================
    ���Ⱑ JSP �ڵ� ��ġ
    JSP�� Ŭ���� ������ �ƴ϶� => _jspService() �������� �ڵ� 
    =============================
    }
    
    => �ڹ����� => ����Ŭ SQL ���� => HTML / CSS
    
    113page JSP ����
    ===============
    JSP ��ũ��Ʈ�� ���� ����
    1) JSP�� �ڹ� + HTML�� ȥ��
    			  ==== CSS / JavaScript
       => �� ������ ����
       <% %> : ��ũ��Ʈ�� => �Ϲ� �ڹ� �ڵ�
       					  ���� ���� => ��������
       					  �޼ҵ� ȣ��
       					  Ŭ���� �޸� �Ҵ�
       					  ��� / ������ 
       					  
       <%= %> : ǥ���� => ������ ��� out.println()
       =========================================== �޼ҵ� �������� ���� 
       <%! %> : ����� => ���󵵴� ���� ����
       					�޼ҵ带 JSP���� ����� ���, ������� ����
       					class ������ ����
       
       class basic_005f2_jsp extends HttpJspBase{
       		=============================
       			�������
       			<%! %>
       		=============================
       			������
       		=============================
        		�޼ҵ�
        		public void _jspInit(){}
        		public void _jsp
    
    
--%>
<%--  
	public void _jspService(HttpServletRequest request, HttpServletResponse response)   
   {
--%>
	<% 
	
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		int age=10;
	%>
	<%= age %>
</body>
</html>
<%--
	}
--%>