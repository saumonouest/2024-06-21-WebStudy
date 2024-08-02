<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" scr="ajax.js"></script>
<script type="text/javascript">
function send(){
	sendRequest('sub.jsp',null,ok,'post')
}
function ok(){ 
	// then(), success:function()
	/*
		readyState
		0 => 서버 연결 준비
		1 => 서버 연결 => open()
		2 => 서버 연결 완료
		3 => 데이터 전송 준비 => send()
		4 => 데이터 전송 완료
	*/
	
	if(httpRequest.readyState==4){
		if(httpRequest.status==200){
			let div=document.querySelector("#print")
			alert(httpRequest.responseText)
			div.textContent=httpRequest.responseText
			// HTML 자체 읽기 => responseText
			// XML => responseXML
		}
	}
}
</script>
</head>
<body>
	<button onclick="send()">전송</button>
	<div id="print"></div>
</body>
</html>