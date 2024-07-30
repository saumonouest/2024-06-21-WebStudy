<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top:50px;
}
.row{
   margin:0px auto;
   width:960px
}
</style>
<script type="text/javascript">
window.onload=()=>{
	let h3=document.querySelector("#title")
	h3.textContent="사원 목록"
	
	
	let hong={"sabun":1,"name":"홍길동","dept":"개발부"}
	let html='<tr>'
			+"<td>사번</td>"
			+"<td>"+hong.sabun+"</td>"
			+"<td>이름</td>"
			+"<td>"+hong.name+"</td>"
			+"<td>부서</td>"
			+"<td>"+hong.dept+"</td>"
			+"</tr>"
	
	let tbody=document.querySelector(".table tbody")
	tbody.innerHTML=html
	
	// 스타일 변경
	// background-color => backgroundColor margin-top => marginTop
	//document.body.style.backgroundColor="blue"
	document.body.style['backgroundColor']='pink'

}
</script>
</head>
<body>
	<div class="container">
	 <h3 class="text-center">사원 목록</h3>
	 <div class="row">
	  <table class="table">
	   <tbody>
	   
	   </tbody>
	  </table>
	 </div>
	</div>
</body>
</html>