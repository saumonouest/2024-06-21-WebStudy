<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	자바스크립트 : Jquery는 자바스크립트 기반
			  ===================
			  MVC/JSP/Spring => 자바기반
			  MyBatis/JPA/DBCP => 오라클(SQL)
			  => 라이브러리 : 사용형식
			  
	1) 자바스크립트의 핵심
		= 변수 선언 / 연산자 / 제어문 동일
		= 함수 / 객체 모델 : 태그를 읽어서 이벤트 처리
		  ==   ============		 ======== 라이브러리 : Jquery / VueJS / ReactJS
		  예)
		  	window.onload=function(){처리}
		  	=> Jquery : $(function(){처리})
		  	=> VueJS : mounted(){}
		  	=> React : componentDidMounted(){}
		  	
		= 데이터 관리 프로그램 : 자바에서 출력 데이터를 전송 => 받아서 처리
		  ======= 단일 데이터 : 문자열 / 여러개 데이터 ([],{})
		  									======= JSON
		  Restful => 자바 <==> 자바스크립트의 통신
		  				  |
		  				 JSON
		  				자바 : List, VO
		  			자바스크립트   |		|
		  					  []   {}
		  자바는 오라클에 있는 데이터를 읽어와서 자바스크립트로 전송
		  	  ==================================
		  자바스크립트 데이터를 받아서 동적으로 화면 처리 => 데이터변경 (태그생성, 속성, CSS제어, 이벤트처리)
		  HTML / CSS => 기본 화면
		  
		  => 자바스크립트의 핵심
		  	 객체 모델 : 태그를 가지고 온다
		  	 		  document.querySelector("CSS선택자") => $("선택자")
		  	 		  ======================
		  	 		  			$
		  	 		  document.getElementById("아이디명")
		  	 		  
		  	 		  VueJS => <a href="" ref="" v-model=""> : 양방향
		  	 		  React => e.target.value
		  	 		  			 ====== 태그
		  	 		  *** 매칭
		  	 		  C / C++ , JAVA, C#
		  	 		  	
		  => 순서 (동작)
		  
		  사용자가 요청 => 클릭 / 마우스 / 키보드 => 이벤트
		  ========= 마우스 / 키보드
		  처리 => 함수 제작 (자바 => 메소드)
		  		======= 변수/연산자/제어문의 묶음
		  => 함수생성 방법
		  	 =========
		  	 1) 익명의 함수 : 함수명이 없는 상태
		  	 	function(){}
		  	 	window.onload=function(){}
		  	 	public String aaa(){}
		  	 	fun aaa():String
		  	 	def aaa
		  	 	
		  	 2) 선언적 함수 : 함수명이 있는 상태
		  		function
		  	 		  			 
		 
		 
		호출 방법 => 함수 (사용자 정의 제작) => 자동 호출은 없다 => 호출해서 사용한다
		function func_name(){} => func_name()
		let func_name=()=>{}   => func_name()
		let func_name=function(){} => func_name()
		
		function func_name(name){} => func_name("A")
		let func_name=(name)=>{}   => func_name("B")
		let func_name=function(name){} => func_name("C") => 데이터형은 매개변수 값에 따라 변경
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=function(){
	let h3=document.createElement("h3") // <h3></h3>
	let text=document.createTextNode("Hello JavaScript")
	h3.appendChild(text)
	document.body.appendChild(h3)
}
</script>
</head>
<body>

</body>
</html>