<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.sist.dao.*"%>
<%
	String type = request.getParameter("type");
	if(type==null)
		type="1";
	
	String strPage=request.getParameter("page");
	if(strPage==null)
		strPage="1";
	
	int curpage=Integer.parseInt(strPage);
	
	GoodsDAO dao = GoodsDAO.newInstance();
	List <GoodsVO> list=dao.goodsListData(Integer.parseInt(type), curpage);
	int totalpage=dao.goodsListTotalPage(Integer.parseInt(type));
	
	final int BLOCK=10;
	int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	
	if(endPage>totalpage)
		endPage=totalpage;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style>
	.container{
		margin-top:50px;
	}
	.row{
		width: 960px;
		margin:0px auto;
	}
	.a{
	    overflow: hidden;
	    text-overflow: ellipsis;
	}
</style>
</head>
<body>
	<div class="container">
	 <div class="row">
	  <div class="text-center">
	   <a href="goods_list.jsp?type=1" class="btn btn-lg btn-success">전체 상품</a>
	   <a href="food_list.jsp?type=2" class="btn btn-lg btn-info">인기 상품</a>
       <a href="food_list.jsp?type=3" class="btn btn-lg btn-warning">신상품</a>
       <a href="food_list.jsp?type=4" class="btn btn-lg btn-primary">특가상품</a>
	  </div>
	 </div>
	<div style="height:20px"></div>
	 <div class="row">
	 <%
	 	for(GoodsVO vo :list) {
	 %>
	 	<div class="col-sm-3">
	 	   <a href="goods_detail.jsp?no=<%=vo.getNo() %>&type=<%=type %>">
	 	  <div class="thumbnail">
	 	   <img src="<%=vo.getGoods_poster() %>" style="width:240px; height:240px" class="img-rounded">
	 	   <p class="a"><%=vo.getGoods_name() %></p>
	 	  </div>
	 	 </a>
	 	</div>
	 	<%
	 	}
	 	%>
	 </div>
	 <div style="height: 20px"></div>
	  <div class="row">
	   <div class="text-center">
	    <ul class="pagination">
	     <%
	      if(startPage>1){
	     %>
	     <li><a href="goods_list.jsp?type=<%=type %>&page=<%=startPage-1 %>">&lt;</a></li>
	     <%
	      }
	     	for(int i=startPage;i<=endPage;i++){
	     %>
	     <li class="<%= i==curpage?"active":""%>"><a href="goods_list.jsp?type=<%=type %>&page=<%=i %>"><%=i%></a></li>
	     <%
	     }
	     	if(endPage<totalpage)
	     {
	     %>
	     <li><a href="goods_list.jsp?type=<%=type %>&page=<%=endPage+1 %>">&gt;</a></li>
	     <%
	     }
	     %>
	    </ul>
	   </div>
	  </div>
	 </div>
</body>
</html>










