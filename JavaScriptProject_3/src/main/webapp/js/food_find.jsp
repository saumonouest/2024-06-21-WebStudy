<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/javascript">
.container{
   margin-top:50px;
}
.row{
   margin:0px auto;
   width:1100px
}
.a{
	white-space: nowrap;
	overflow: hidden;
	text-overflow:
}
</style>
<script type="text/javascript" src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script type="text/javascript">
window.onload=()=>{
	//http://localhost:8080/JavaScriptProject_3/js/food_find_js.do 
	// get => GET, post() => POST	
	let food_list=[]
	let startPage=0
	let endPage=0
	let curpage=0
	let totalpage=0
	let html=''
	axios.get("http://localhost:8080/JavaScriptProject_3/js/food_find_js.do")
	.then((response)=>{
		// console.log(response.data)
		// 데이터를 받는 부분
		food_list=response.data
		curpage=response.data[0].curpage
		totalpage=response.data[0].totalpage
		startPage=response.data[0].startPage
		endPage=response.data[0].endPage
	})
	// 화면 출력
	food_list.map((vo)=>{
		html+='<div class="col-sm-3">'
		+'<div class="thumbnail">'
		+'<img src="'+vo.poster+'" style="width:100%">'
		+'<p class="a">'+vo.name+'</p>'
		+'</div>'
		+'</div>'
	})
	let main=document.querySelector("#poster");
	main.innerHTML=html;
}
function imgChange() {
	let addr=document.querySelector("#addr").value;
	if(addr.trim()===""){
		alert("검색어 입력")
		document.querySelector("#addr").focus()
		return;
	}
	let html=''
	let pages=''
	axios.get("http://localhost:8080/JavaScriptProject_3/js/food_find_js.do",{
		params:{
			page:1,
			addr:addr
		}
	})
	.then((response)=>{
		// console.log(response.data)
		// 데이터를 받는 부분
		food_list=response.data
		curpage=response.data[0].curpage
		totalpage=response.data[0].totalpage
		startPage=response.data[0].startPage
		endPage=response.data[0].endPage
	})

	// 화면 출력
	food_list.map((vo)=>{
		html+='<div class="col-sm-3">'
		+'<div class="thumbnail">'
		+'<img src="'+vo.poster+'" style="width:100%">'
		+'<p class="a">'+vo.name+'</p>'
		+'</div>'
		+'</div>'
	})
		let main=document.querySelector("#poster");
		main.innerHTML=html;
		
		pages='<a href="#" class="btn btn-sm btn-danger">이전</a>'
				+curpage+" page / "+totalpage+" pages"
				+'<a href="#" class="btn btn-sm btn-success">다음</a>'
		let page=document.querySelector("#pages");
		page.innerHTML=pages
	})
	
}
</script>
</head>
<body>
	<div class="container">
	 <div class="row">
	  <input type=text i
	  d="addr" size=20 class="input-sm">
	  <input type="button" value="검색" class="btn-sm btn-danger" onclick="imgChange()">
	 </div>
	 <div style="height:10px"></div>
	  <div class="row" id="poster">
	   <div class="col-sm-8" id="poster">
	   </div>
	   
	   <div class="col-sm-4">
	   
	   </div>
	  </div>
	  <div style="height:10px"></div>
	  <div class="text-center" id="pages">
	  
	  </div>
	</div>
</body>
</html>