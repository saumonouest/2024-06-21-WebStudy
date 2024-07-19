package com.sist.model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import com.sist.dao.BoardDAO;

public class BoardDeleteModel implements Model {

	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		return "delete.jsp";
	}

}
