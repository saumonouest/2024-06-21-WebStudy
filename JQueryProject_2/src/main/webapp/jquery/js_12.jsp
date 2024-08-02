<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	JSON : JavaScript Object Notation
			자바스크립트 객체 표현법
			=> 자바 => 데이터를 자바스크립트로 전송
				  JSON
				  ==== 1. 웹에서 자바스크립트
				  	   2. 모바일 (kotlin)
			=> key, value 구성 => key는 중복이 불가능하다
			   =========== map
			   JSON => 라이브러리를 주로 사용 : json-simple (google), jackson(boot에 자동 첨부)
			   
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=()=>{
	let info={name:"홍길동",age:20,sex:"남자"}
	let data=JSON.stringify(info)
	console.log(data)
	let change=JSON.parse(data)
	console.log(change)
	
}
</script>
</head>
<body>

</body>
</html>