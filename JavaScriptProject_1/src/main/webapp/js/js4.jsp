<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=function(){
	let a=10
	let b=5
	
	console.log("a===b"+(a===b))
	console.log("a!==b"+(a!==b))
	console.log("a<b"+(a<b))
	console.log("a>b"+(a>b))
	console.log("a<=b"+(a<=b)
	console.log("a>=b"+(a>=b)
			
	let c="Hello"
	let d="JavaScript"
		console.log("c===d"+(c===d))
		console.log("c!==d"+(c!==d))
		console.log("c<d"+(c<d))
		console.log("c>d"+(c>d))
		console.log("c<=d"+(c<=d)
		console.log("c>=d"+(c>=d)
}
function send(){
	let frm=document.frm
	if(frm.id.value===""){
		alert("ID를 입력하세요")
		return
	}
	else if(frm.pwd.value===""){
		alert("PWD를 입력하세요")
		return
	}
	alert("ID:"+frm.id.value+"\n"
			+"Password:"+frm.pwd.value)
}
</script>
</head>
<body>
	<form name="frm">
		ID : <input type=text name=id size=10><br>
		PW : <input type=password name=pwd size=10><br>
		<input type=button value="전송" onclick="send()">
	</form>
</body>
</html>