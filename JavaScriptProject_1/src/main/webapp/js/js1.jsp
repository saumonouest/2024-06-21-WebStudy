<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	자바스크립트 : 브라우저 자체에서 처리 (서버처리가 아니다)
				ㄴ브라우저에서 동적 페이지 작성 => 이벤트 (HTML/CSS => 정적페이지)
	역할 (웹 사이트)
	============
		1) HTML / CSS => 화면 UI
		==================================== 
		2) 자바스크립트 => 화면에 대한 동적 처리 => 오라클 연결이 가능 (서버측 사이드 => NodeJS)
		   => HTML/CSS를 제어 => 유효성 검사 (사용자 입력), 움직이는 화면
		   1. 사용법
		   	  = 내부 스크립트(한 개의 파일에서만 작업)
		   	  	<script type="">
		   	  	
		   	  	</script>
		   	  	
		   	  = 외부 스크립트 (여러개 파일에 적용) => .js
		   	  	=> 파일로 제작
		   	  	<script type="" src="파일명 지정"> => import
		   	  	
		   	  = 인라인 스크립트 : 태그 한 개를 제어 
		   	    <input type=button onclick="javascript:history.back()">
		   	    
		   2. 버전
		   	  ES5
		   	  	var : 변수 => 자동지정변수 => 데이터형을 사용하지 않는다
		   	  	ㄴ단점은 scope가 명확하지 않다
		   	  		  ====== 사용범위
		   	  		  
		   	  ES6
		   	  	let : 변수 => 자동지정변수 => 데이터형을 사용하지 않는다
		   	  	ㄴvar 단점을 보완 => 사용범위가 명확하다
		   	  	 {
		   	  	   => 안에서만 사용이 가능 => 메모리 해제
		   	  	 }
		   	  	 
		   	  	const : 상수형 변수 => 값을 변경할 수 없다
		   	  	람다식 : => 화살표 함수
		   	  	
		   	  	=> 예)
		   	  		function func_name(매개변수)
		   	  		{
		   	  		}
		   	  		
		   	  		let func_name=function(){}
		   	  		let func_name=()=>{} => 권장
		   	  						  == function / return을 생략할 때 주로 사용
  	  						  
		   	  	같다 (== ==> ===) 경고 (VueJS/ReactJS => 반드시 ===)
		   	  	=> 문장이 종료될 때
		   	  	
		   	    => 자바스크립트 => 자바의 라이브러리가 어느 정도 유사
		   	    	trim(), substring(), indexof... String/Number
		====================================
		3) 자바 => 데이터를 관리
		4) 오라클 => 데이터를 저장하는 공간
		====================================
		 
	1. 변수 설정
		= 데이터형을 사용하지 않는다 / 자동 지정변수 사용 / 전역변수, 지역변수 사용이 가능
			<script type="">
			변수 선언 => 전역 변수
			function aaa()
			{
				변수 선언 => 지역 변수
			}
			</script>
			
			1) 변수 설정은 초기값에 따라 자동으로 데이터형이 지정
								================
								1. number : 실수, 정수
								2. string : 문자. 문자열 => '', ""
								3. object : 배열 / 객체
								4. boolean : true / false => 숫자도 가능
											 0, 0.0 이 아닌 모든 수는 true
								5. function : 함수도 데이터형으로 취급
								6. undefined : 변수에 값이 없는 상태
								7. NaN : 연산이 안 되는 경우
								8. null : 배열, 객체에 값이 없는 경우
								
	2. 연산자
	3. 제어문 
	4. 함수
	5. 라이브러리 (내장함수)
	6. 객체지향 => DOM 
	===================
	 자바스크립트 라이브러리
	===================
	1) Jquery (Ajax)
	2) VueJS
	3) ReactJS
	4) NextJS / NodeJS
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
// 내부 스크립트
/*
 *  주석
 */
 window.onload=function(){
	// 1. 변수 설정 => 데이터형 확인
	let a = 10
	let b = 10.5
	let c ="ABC"
	led d ='DEF'
	let e = true
	let f =[1,2,3,4,5]
	let g = {"name":"홍길동","age":"25"}
	// typeof
	document.write(a+":"+typeof a+"<br>")
	document.write(b+":"+typeof b+"<br>")
	document.write(c+":"+typeof c+"<br>")
	document.write(d+":"+typeof d+"<br>")
	document.write(e+":"+typeof e+"<br>")
	document.write(f+":"+typeof f+"<br>")
	document.write(g+":"+typeof g+"<br>")
	
	
	a="abcdef";
	document.write(a+":"+typeof a+"<br>")
	
}
</script>
</head>
<body>

</body>
</html>