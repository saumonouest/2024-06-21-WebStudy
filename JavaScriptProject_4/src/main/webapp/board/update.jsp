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
     margin-top: 50px;
  }
  .row{
    margin: 0px auto;
    width: 600px
  }
 </style>
 <script type="text/javascript" src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script type="text/javascript">
function update(){
	let name=document.querySelector("#name")// 태그 읽어올 때 쓰는 거임 이게 $() 이걸로 변경 된다함
	if(name.value.trim()===""){
		name.focus()
		return
	}
	let subject=document.querySelector("#subject")
	if(subject.value.trim()===""){
		subject.focus()
		return
	}
	let content=document.querySelector("#content")
	if(content.value.trim()===""){
		content.focus()
		return
	}
	let pwd=document.querySelector("#pwd")
	if(pwd.value.trim()===""){
		pwd.focus()
		return
	}
	// 유효성 검사 => 사용자에 입력을 유도 => NOT NULL / Primary KEY => 자바스크립트
	let no=document.querySelector("#no") // hidden
	
	// 서버 연결 => axios.get => GET, axios.post => POST
	// GET 한글처리가 없음, POST => request.setCharacterEncoding처리
	// update_ok => GET / insert_ok=> POST
	/*
		탭 : 
			1. 전송 => 받아서 출력
			2. 전송 방식 => GET/POST
			3. 데이터베이스 : SQL문장
			4. 어떤 화면을 브라우저에 출력
	*/
	axios.get('update_ok.do'),{
		params:{
			no:no.value,
			name:name.value,
			subject:subject.value,
			content:content.value,
			pwd:pwd.value // 키:실제값
		}
	}).then(function(result){
		if(result.data==='yes'){
			// 수정이 된 상태
			// 이동
			location.href="detail.do?no="+no.value
		}
		else{
			// 비밀번호 틀린 상태
			alert("비밀번호 오류\n 다시 입력")
			pwd.value=''
			pwd.focus()
		}
	})
}
</script>
</head>
<body>
<%--
   .do  ===> *.do
     list.do
     insert.do
     insert_ok.do
     detail.do 
     ===============> DispatcherServlet(Controller) 호출 
                      => service() 메소드 호출 
                      
                      
     JSP   =================== Model      ============> DAO
      .do                 @RequestMapping() <==========
      = <a>                     |
      = <form>                  |request
      = axios.get()             |
      서버에 요청                 JSP
 --%>

  <div class="container">
	  <div class="row">
	   <h3 class="text-center">수정하기</h3>
	  <!--<form method=post action="../board/update_ok.do">-->
	   <table class="table">
	     <tr>
	      <th width="15%" class="text-right">이름</th>
	      <td width="85%">
	        <input type=text id=name size=20 class="input-sm" 
	         value="${vo.name }"
	        >
	        <input type="hidden" id=no value="${vo.no }">
	      </td>
	     </tr>
	     <tr>
	      <th width="15%" class="text-right">제목</th>
	      <td width="85%">
	        <input type=text id=subject size=60 class="input-sm"
	         value="${vo.subject }"
	        >
	      </td>
	     </tr>
	     <tr>
	      <th width="15%" class="text-right">내용</th>
	      <td width="85%">
	        <textarea rows="10" cols="60" id=content>${vo.content }</textarea>
	      </td>
	     </tr>
	     <tr>
	      <th width="15%" class="text-right">비밀번호</th>
	      <td width="85%">
	        <input type=password id=pwd size=10 class="input-sm">
	      </td>
	     </tr>
	     <tr>
	       <td colspan="2" class="text-center inline">
	         <input type="button" class="btn-danger btn-sm" id="updateBtn" value="수정" onclick="">
	         <input type=button value="취소" class="btn-primary btn-sm"
	          onclick="javascript:history.back()">
	       </td>
	     </tr>
	   </table>
	  <!-- </form>  --> 
	  </div>
  </div>
</body>
</html>