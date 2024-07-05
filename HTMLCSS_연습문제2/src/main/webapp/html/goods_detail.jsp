<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%
		GoodsDAO dao = GoodsDAO.newInstance();
		String no=request.getParameter("no");
		String type=request.getParameter("type");
		GoodsVO vo = dao.goodsDetailDate(Integer.parseInt(no),Integer.parseInt(type));
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
   .a{
	    white-space:nowrap;
	    overflow: hidden;
	    text-overflow: ellipsis;
	}
	#image{
		width: 100%;
		height: 350px;
		border-radius: 20px;
	}
	#title{
		font-size: 25px;
		font-weight: bold;
	}
	#sub{
		color:grey;
		text-align: center;
	}
	#percent{
		font-size: 25px; /*h3*/
		color: pink;
		font-weight: bold;
	}
	#price{
		font-size: 25px; /*h3*/
		font-weight: bold;
	}
	#psub{
		font-size: 12px;
		color: #999;
	}
	#star{
		color: orange;
		font-weight: bold;
	}
	#blod{
		font-weight: bold;
	}
	#count{
		color:gray
	}
	#sel{
		width: 100%;
		height: 40px;
	}
	#cart,#buy{
		width: 250px;
		height: 70px;
		border: 2px green solid;
		font-size: 20px;
		font-weight: bold;
		border-radius: 10px;
		box-shadow: 5px 5px 5px #A9A9A9;
	}
	#cart:hover , #buy:hover{
		cursor: pointer;
	}
	#cart{
		
		background-color: white;
		color:green;
	}
	#buy{
		background-color: green;
		color:white;
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