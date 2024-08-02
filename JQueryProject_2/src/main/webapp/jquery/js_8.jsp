<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	브라우저 내장 객체 = 계층형 구조(트리)
	============
		window : 브라우저
		   |
	=========================
	|		|		|		|
document history location frame

document : 화면출력 담당 
history : 이동기록
location : 
frame :
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=()=>{
	let btn=document.querySelector("button")
	btn.addEventListener('click',()=>{
		window.open('js_7.jsp','winname','width=500','height=700','scrollbars=yes')
	})
}
</script>
</head>
<body>
	<button>클릭</button>
</body>
</html>