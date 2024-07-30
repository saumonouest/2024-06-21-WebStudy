<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	변수 설정 => 식별자
		1) 알파벳으로 시작한다 (대소문자 구분)
		2) 숫자 사용이 가능 (앞에 사용 금지)
		3) 키워드는 사용할 수 없음
			(if, var, let, const ..)
		4) 특수문자 사용이 가능 ( _, $) _를 주로 사용
		5) 변수명에 공백은 사용할 수 없음
		
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=function(){
	/*let a=10;
	console.log("a="+a)
	a++
	console.log("a="+a)
	
	let b=10;
	console.log("b="+b)
	b--
	console.log("b="+b)
	*/
	let c=10
	let d=c++
	// c는 d에 값을 대입 후 c는 한 개를 증가
	document.write("c="+c+",d="+d+"<br>") // 브라우저에 출력
=
	// 부정 연산자 : boolean => true => false, false => true
	let k=false;
	document.write("변경 전 k="+k+"<br>")
	k=!k
	document.write("변경 후 k="+k+"<br>")
	
	// 형변환 연산자
	let m=1
	document.write("변경 전 m="+m+","+typeof m+ "<br>")
	m=!m // boolean으로 변환 (!=boolean)
	document.write("변경 후 m="+m+","+typeof m+ "<br>")
	// 0, 0.0이 아닌 모든 숫자는 true
	// number, boolean는 언제든 변경이 가능 
	document.write(Boolean(1)+","+Boolean(0)+","+Boolean(1.0)+","+Boolean(0.0))
	
	let name="홍길동"
	document.write("name="+typeof name+"<br>")
	document.write("name="+typeof Boolean(name)+","+Boolean(name)+"<br>")
	
	let addr=null
	document.write("addr="+typeof addr+"<br>")
	
	/*
		window
		  |
		=================
		|		|		|
	document  history  location
	브라우저의 
	출력되는 
	영역
	
	
	
	*/
	
	
}
</script>
</head>
<body>

</body>
</html>