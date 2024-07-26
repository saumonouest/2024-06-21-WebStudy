package com.sist.controller;
import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.Model;

/*
 *	1. JSP / Servlet => Model 1방식
 *	   = 장점
 *			1) 서블릿 => 자바코드만으로 HTML 코드 작성 => 오류 발생할 확률이 낮음
 *			2) JSP => 자바코드만으로 HTML 코드 작성 => 오류 발생할 확률이 낮음
 *			3) 단순맨 => 자바 / HTML을 구분
 *						<% %>, <%= %> => 제어문 : for / if
 *
 *	   = 단점
 *			1) 가독성이 떨어짐 => Java + HTML
 *			2) 자바의 로직이나 데이터 베이스 => 노출이 된다 (JSP는 배포시에 모든 소스를 전달)
 *			3) 파일 1개 작업을 하기 때문에 분업이 어려움
 *			   => 만능 (HTML/CSS/JavaScript/Java/Oracle)
 *
 *     = 사용처
 *			=> 개인 기업 사이트
 *			=> 유지보수가 거의 없는 사이트
 *				=> JSP / Servlet : 확장성 / 재사용성 => 많이 떨어짐
 *			=> 개인 홈페이지 (유치원, 개인쇼핑몰, 개인 학원)
 *			=> 간단한 사이트 제작
 *     
 *  2. MVC => Model 2방식
 *  	=> JSP / Servlet => 보완
 *  		=> 1. 확장성 / 재사용 증가
 *  		=> 2. 보안이 필요한 경우 처리 (HTML/Java 완전 분리)
 *  		=> 3. 분업화 => Front-end / Back-end
 *  		=> 4. Controller로 집중적 => 서버에 부하가 많을 수 있음
 *  			  ========================================
 *  				1) Front-End의 MVC => Redux / Flux / Vuex
 *  				2) 서버를 나눠서 동시 구동 => MSA
 *  									   ==== 애자일 기법
 *  		=> 비용이 많이 들어간다
 *  		=>
.적은 유지 보수 목적 => 쉽게 수정 / 쉽게 추가
 *  		=> 모든 편집기 => 어시스트
 *  	
 *  	=> 공기업 / 금융권 / 대기업 : MVC 구조로 만들어져 있음
 *  	   ===================  ========
 *  	   스프링 / 웹스페어/ 웹로직	 스프링
 *  
 *  	   라이브러리 vs 프레임워크 => 라이브러리
 *  		|			|
 *  		완제품		레고(자바소스를 제공) => 전자정부 프레임워크, 애니 프레임워크
 *  
 *  	
 */

// Controller 는 고정 => 추가, 수정 (파일 => XML)
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String [] strCls= {
			"com.sist.model.MovieListModel",
			"com.sist.model.MovieDetailModel"
		
	};
	private String []  strCmd= {
			"list.do",
			"detail.do"
	};
	private Map clsMap=new HashMap();
	// => 1. 클래스 등록, 2. SQL 문장 등록, 3. 클라이언트 정보 등록
	// 
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
			for(int i=0;i<strCls.length;i++) {
				Class clsName=Class.forName(strCls[i]); // 클래스 정보 읽기
				// => 제어 : 리플렉션
				Object obj=clsName.getDeclaredConstructor().newInstance();
				// 클래스 메모리 할당
				// new => 결합성이 높다 (new 사용 자제) => 스프링에서는 new를 사용하지 않음
				clsMap.put(strCmd[i], obj);
				System.out.println(strCmd[i]+":"+obj);
				// 시작과 동시에 => 클래스 메모리 저장 => 변경이 없다 (싱글턴)
			}
		}catch(Exception ex) {}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * Model model1=(Model)clsMap.get("list.do"); 
		 * Model model2=(Model)clsMap.get("list.do"); 
		 * Model model3=(Model)clsMap.get("list.do"); 
		 * Model model4=(Model)clsMap.get("list.do"); 
		 * Model model5=(Model)clsMap.get("list.do"); 
		 * System.out.println("mopdel1="+model1);
		 * System.out.println("mopdel2="+model2); 
		 * System.out.println("mopdel3="+model3);
		 * System.out.println("mopdel4="+model4); 
		 * System.out.println("mopdel5="+model5);
		 */
		
		// 사용자 요청 사항 
		String cmd=request.getRequestURI();
		
		// 해당 Model 찾기 => 기능별로 나눠서 작업
		cmd=cmd.substring(cmd.lastIndexOf("/")+1);
		Model model=(Model)clsMap.get(cmd);
		
		// JSP에 전송할 데이터 받기
		String jsp=model.execute(request, response);
		
		// JSP => request 전송
		RequestDispatcher rd=request.getRequestDispatcher(jsp);
		rd.forward(request, response);
		
	}

}











