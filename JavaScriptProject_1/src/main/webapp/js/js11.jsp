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
 margin-top:50px
 }
 .row{
 margin: 0px auto;
 width: 800px
 }
 </style>
<script type="text/javascript">
window.onload=()=>{
	const sawon=[
	{"sabun":1,"name":"홍길동","sex":"남자","dept":"개발부","loc":"서울"} // SawonVO
	{"sabun":2,"name":"서연우","sex":"여자","dept":"개발부","loc":"서울"}
	{"sabun":3,"name":"이다훈","sex":"남자","dept":"으예","loc":"서울"}
	{"sabun":4,"name":"서팡우","sex":"남자","dept":"강강지","loc":"서울"}]
	// JSON => 자바스크립트의 객체 표현법
	/*
	document.write("<h1>자바스크립트의 객체 출력</h1>")
	document.write("사번:"+sawon.sabun+"<br>");
	document.write("이름:"+sawon.name+"<br>");
	document.write("성별:"+sawon.sex+"<br>");
	document.write("부서:"+sawon.dept+"<br>");
	document.write("지역:"+sawon.loc+"<br>");
	*/
	document.write("<h1>배열 데이터를 for-each를 이용한 출력</h1>")
	document.write("<div class=container>")
	document.write("<div class=row>")
	document.write("<table class=table>")
	document.write("<tr>")
	document.write("<th>사번</th>")
	document.write("<th>이름</th>")
	document.write("<th>성별</th>")
	document.write("<th>부서</th>")
	document.write("<th>근무지</th>")
	document.write("</tr>")
	
	
	sawon.forEach((vo)=>{
		document.write("<tbody>")
	})
	document.write("</tbody>")
	document.write("</table>")
	document.write("</div>")
	document.write("</div>")
}
</script>
</head>
<body>

</body>
</html>