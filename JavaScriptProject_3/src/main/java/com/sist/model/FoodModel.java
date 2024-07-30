package com.sist.model;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.sist.controller.RequestMapping;
import com.sist.dao.*;
public class FoodModel {
	private FoodDAO dao = FoodDAO.newInstance();
	// 1. 예약, 좋아요, 찜, 아이디 중복체크, 우편번호, 채팅, 검색. . . (화면이 초기화 되면 안 되는 애들)
	@RequestMapping("js/food_find.do")
	public String food_find(HttpServletRequest request, HttpServletResponse response) {
		
		
		return "food_find.jsp"; 
			
	}
	
	// _js => javascript에서 데이터를 읽어 간다 => JSON 제작
	@RequestMapping("js/food_find_js.do")
	public void food_find_js(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		}catch (Exception e) {}
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		String addr= request.getParameter("addr");
		if(addr==null)
			addr="마포";
		
		int curpage=Integer.parseInt(page);
		List<FoodVO> list = dao.foodFindData(curpage, addr);
		int totalpage=dao.foodFindTotalPage(addr);
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		int i=0;
		JSONArray arr = new JSONArray(); // List => restful
		for(FoodVO vo :list) {
			JSONObject obj = new JSONObject(); // VO fno, name, poster, address
			obj.put("fno", vo.getFno());
			obj.put("name", vo.getName());
			obj.put("poster", vo.getPoster().replace("https", "http"));
			obj.put("address", vo.getAddress());
			if(i==0) {
				obj.put("curpage", curpage);
				obj.put("totalpage", totalpage);
				obj.put("startPage", startPage);
				obj.put("endPage", endPage);
			}
			arr.add(obj);
			i++;
		
		}
		try {
			response.setContentType("text/plain;charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			out.print(arr.toJSONString());
		}catch (Exception ex) {}
		
	}
	
	@RequestMapping("js/food_find_js.do")
	public void food_detail_js(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
























