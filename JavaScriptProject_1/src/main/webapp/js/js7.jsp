<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
window.onload=()=>{
	// 화면에 html이 실행되면 수행하는 함수 : 리턴형을 사용하지 않는다, 매개변수에 데이터형을 사용하지 않는다
	/* let a=prompt("정수입력:") // 입력 값을 받는 경우
	console.log("a="+a)
	if(a%2==0){
		document.write(a+"=> 짝수")
	}
	else{
		document.write(a+"=> 홀수")
	}
	 */
	let user=prompt("ID 입력")
	if(user==="admin"){
		document.write("관리자 입장")
	}
	else{
		document.write("일반사용자")
	}
}
</script>
</head>
<body>

</body>
</html>