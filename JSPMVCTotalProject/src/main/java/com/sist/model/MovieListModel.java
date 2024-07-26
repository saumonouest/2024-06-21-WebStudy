package com.sist.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.manager.*;
/*
 *	관련 클래스가 많은 경우 : 한 개로 모아서 처리 => 인터페이스
 *	
 *	1. 여러개 => 한개로 묶음
 *	   변수 여러개 => 배열
 *	   클래스 여러개 => 인터페이스
 *
 *	2. 메소드 여러개 => 구분자 (임의로 결정, 제공하는 구분자)
 *						  =========
 *
 *	3. 재사용, 확장성, 가독성, 최적화
 */
public class MovieListModel implements Model {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String title="";
		String type=request.getParameter("type");
		if(type==null)
			type="1";
		int index=Integer.parseInt(type);
		if(index==1) {
			title="일별 박스오피스";
		}
		else if(index==2) {
			title="실시간 예매율";
		}
		else if(index==3) {
			title="좌석 점유율";
		}
		MovieManager mm = new MovieManager();
		List<MovieVO> list = mm.movieListData(index);
		request.setAttribute("list", list);
		request.setAttribute("title", title);
		return "../movie/list.jsp";
	}
	
		
}
