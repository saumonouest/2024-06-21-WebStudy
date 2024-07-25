package com.sist.model;

import javax.servlet.http.HttpServletRequest;

/*
 *	MVC
 *	=> HTML / Java 분리하는 과정
 *	=> 분업 / 확장성 / 재사용
 *	=> 실제 실무에서는 MVC만 사용
 *	   => MVC 단점 : 소스가 복잡하다, Controller에 의존하는 경향이 많다
 *							  ==========================
 *							   ㄴ Controller 를 여러개 사용 => 도메인 방식
 *
 *	=> Spring => MVC Project : MVC만 사용이 가능
 *
 *	MVC
 *	 = Model : 자바와 관련된 모든 소스
 *			   DAO, VO, Service, Manager
 *	 = View : JSP / HTML / CSS / JavaScript => 중심 (태그형 프로그램)
 *			  <% %> <%= %> 사용 안 함
 *			  <c:forEach> <c:if> ${}
 *			  화면 출력 (Model에서 전송한 데이터를 출력)
 *	 = Controller : Model과 View를 연결하는 역할
 *					=> Servlet으로 제작되어 있음 (스프링에서 이미 제작 => 서블릿)
 *
 *	MVC 실행 과정
 *	1. JSP(요청) => <a>, <form>, ajax, javascript
 *	   ** JSP에서 요청 (URL) => 받을 수 있는 파일
 *							 =========== 서블릿, JSP로 받을 수 있음
 *	2. Controller가 요청값을 받는다
 *		1) 요청 값을 받는다
 *			request, response 전송
 *		2) 해당 Model을 찾는다
 *			=> 요청에 대한 처리 => 결과값을 request에 담아 준다
 *		3) 받아서 출력할 JSP를 찾는다
 *		4) JSP => request를 전송
 *		   ===================
 *			forward()를 이용 => request를 전송 
 *		==========================================
 *		** 모든 화면은 Controller임 => .do(서블릿을 나타냄)
 *		** JSP 화면만 갱신
 *
 *	3. JSP에 화면을 출력하고 Controller에 덮어쓴다
 *	>> 시작과 끝은 Controller (.do ~ .do) => 모든 URL 주소는 .do => 서블릿을 찾을 때 사용
 *
 *		request			   request
 *	JSP ======> Controller ======> Model ======> DAO
 *		request 		   request에 값을 담는다
 *		<====== Controller <====== Model <======	
 *
 */
public class ListModel {
	public String execute(HttpServletRequest request) {
		String msg="게시판 목록";
		request.setAttribute("msg", msg);
		
		return "view/list.jsp";
	}
}




















