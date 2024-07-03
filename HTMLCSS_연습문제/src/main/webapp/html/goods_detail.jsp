<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%
		GoodsDAO dao = GoodsDAO.newInstance();
		String no=request.getParameter("no");
		GoodsVO vo = dao.goodsDetailDate(Integer.parseInt(no));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style>
   .container{
      margin-top: 50px;
   }
   .row{
      width: 960px;
      margin: 0px auto;
   }
</style>
</head>
<body>
	<div class="container">
	 <div class="row">
	  <table class="table table-striped">
	   <tr>
	    <td width="30%" class="text-center" rowspan="5">
	     <img src="<%=vo.getGoods_poster() %>" style="width:100%" class="img-rounded">
	     </td>
	     <td colspan="2"><h3><%=vo.getGoods_name() %></h3></td>
	     </tr>
	     <tr>
	      <th>가격</th>
	      <td><%=vo.getGoods_price() %></td>
	     </tr>
	     <tr>
	      <th>할인가격</th>
	      <td><%=vo.getGoods_discount() %></td>
	     </tr>
	     <tr>
	      <th>배송비</th>
	      <td><%=vo.getGoods_delivery() %></td>
	     </tr>
	     <tr>
	      <th>조회수</th>
	      <td><%=vo.getHit() %></td>
	     </tr>
	     <tr>
	      <td colspan="2" class="text-right">
	       <input type=button value="찜" class="btn-xs btn-primary">
	       <input type=button value="좋아요" class="btn-xs btn-success">
	       <input type=button value="구매" class="btn-xs btn-info">
	       <input type=button value="목록" class="btn-xs btn-warning"
	      onclick="javascript:history.back()">
	      </td>
	     </tr>
	  </table>
	   <tr>
	    <td>
	     <pre style="white-space: pre-wrap; border:none; background-color:white;"></pre>
	     </td>
	    </tr>
	 </div>
	</div>
</body>
</html>