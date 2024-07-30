<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	이항연산자
		= 산술연산자 (+,-,*,/,%)
			+ : 산술, 문자열 결합
			/ : 0으로 나눌 수 없음, 정수/정수 = 실수
			% : 왼쪽 부호를 따라 감
			
		= 비교연산자
		= 논리연산자
		= 대입연산자
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=function(){
	let a=5;
	let b=2;
	
	console.log("a+b="+(a+b))
	console.log("a-b="+(a-b))
	console.log("a*b="+(a*b))
	console.log("a/b="+(a/b))
	console.log("a%b="+(a%b))
	
	let c="10"
	let f=20;
	console.log("c+f="+(c+f))
	console.log("c+f="+(parseInt(c)+f))
	
	let m='A'
	let n=1
	console.log("m+n="+(m+n))
	console.log("m*n="+(m*n))
	
	function caLc(){
		let f=document.querySelector("#first").value
		console.log("f="+f+","+typeof f)
		let s=document.querySelector("#second").value
		console.log("s="+s+","+typeof s)
		
		document.querySelector("#result").value=Number(f)+parseInt(s)
		
	}
}
</script>
</head>
<body>
 첫번째 정수 : <input type=text id="first" size=10><br>
 두번째 정수 : <input type=text id="second" size=10><br>
 <input type=button value="계산" onclick="caLc()"><br>
 결과 : <input type=text id="result" size=10 readonly><br>
</body>
</html>