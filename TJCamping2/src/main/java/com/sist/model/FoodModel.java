package com.sist.model;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.vo.*;
import com.sist.controller.RequestMapping;
import com.sist.dao.*;

public class FoodModel {
	@RequestMapping("food/list.do")
	public String food_list(HttpServletRequest request, HttpServletResponse response) {
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		
		Map map = new HashMap();
		
		int rowSize=20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		
		map.put("start", start);
		map.put("end", end);
		
		List<FoodVO> fList = FoodDAO.foodListData(map);
		int totalpage=FoodDAO.foodTotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		request.setAttribute("fList", fList);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		
		request.setAttribute("main_jsp", "../food/list.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("food/detail_before.do")
	   public String food_detail_before(HttpServletRequest request,HttpServletResponse response)
	   {
		   String fno=request.getParameter("fno");
		   String type=request.getParameter("type");
		   // 쿠키 
		   Cookie cookie=new Cookie("food_"+fno, fno);
		   cookie.setMaxAge(60*60*24);
		   cookie.setPath("/");
		   // 브라우저로 전송 
		   response.addCookie(cookie);
		   return "redirect:../food/detail.do?fno="+fno+"&type="+type;
	   }
	
	// 상세보기
	   @RequestMapping("food/find.do")
	   public String food_find(HttpServletRequest request,HttpServletResponse response)
	   {
		   try
		   {
			   request.setCharacterEncoding("UTF-8");
		   }catch(Exception ex) {}
		   String ss=request.getParameter("ss");
		   if(ss==null)
			   ss="마포";
		   String page=request.getParameter("page");
		   if(page==null)
			   page="1";
		   int curpage=Integer.parseInt(page);
		   int rowSize=20;
		   int start=(rowSize*curpage)-(rowSize-1);
		   int end=(rowSize*curpage);
		   
		   Map map=new HashMap();
		   map.put("start",start);
		   map.put("end", end);
		   map.put("ss", ss);
		   // 데이터 읽기
		   List<FoodVO> fList=FoodDAO.foodFindListData(map);
		   int totalpage=FoodDAO.foodFindTotalPage(ss);
		   // 총페이지 읽기 
		   final int BLOCK=10;
		   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		   if(endPage>totalpage)
			   endPage=totalpage;
		   
		   request.setAttribute("curpage", curpage);
		   request.setAttribute("totalpage", totalpage);
		   request.setAttribute("startPage", startPage);
		   request.setAttribute("endPage", endPage);
		   request.setAttribute("fList", fList);
		   request.setAttribute("ss", ss);
		   // BLOCK별 처리 
		   request.setAttribute("main_jsp", "../food/find.jsp");
		   return "../main/main.jsp";
	   }
}
