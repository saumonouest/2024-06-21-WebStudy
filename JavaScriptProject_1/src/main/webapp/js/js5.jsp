<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	논리 연산자 : &&, ||
		(조건) && (조건) => 범위 포함, 기간 포함
		====     ===
		  |       |
		  =========
		     |
		    결과값 : true / false
		    
		    
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=function(){
	let i=(6<7) && (6===7)
	console.log("i="=i)
	let j=(6<7) || (6===7)
	console.log("j="+j)
	
	let k=10;
	console.log("k="+k)
	k+=20
	console.log("k="+k)
	k-=10
	console.log("k="+k)
	
	let m=(6%2==0)?"짝수":"홀수"
	console.log("m="+m)
	
}
</script>
</head>
<body>

</body>
</html>