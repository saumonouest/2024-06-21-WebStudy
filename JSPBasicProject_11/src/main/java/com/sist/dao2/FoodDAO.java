package com.sist.dao2;

import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class FoodDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static FoodDAO dao;
	
	public static FoodDAO newInstance() {
		if(dao==null)
			dao=new FoodDAO();
		return dao;	
	}
	
	public void getConnection()	{
		try {
			Context init = new InitialContext(); // 탐색기 열기 
			Context c = (Context) init.lookup("java://comp//env");
			DataSource ds = (DataSource)c.lookup("jdbc/oracle");
			conn=ds.getConnection();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// 반환 => POOL (Connection 객체 관리 영역)
	public void disConnection()	{
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex) {}
	}
	
	public List<FoodVO> foodListData(int page){
		List<FoodVO> list = new ArrayList<FoodVO>();
		try {
			getConnection();
			String sql="SELECT fno, name, poster, num "
					+"FROM (SELECT fno, name, poster, rownum as num "
					+"FROM (SELECT fno, name, poster "
					+"FROM food_house)) "
					+"WHERE num BETWEEN ? AND ?";
			ps=conn.prepareStatement(sql);
			int rowSize=12;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				FoodVO vo = new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setPoster(rs.getString(3));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			disConnection();
		}
		return list;
	}
	
	public int foodTotalPage() {
		int total=0;
		try {
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/12.0) FROM food_house";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			disConnection();
		}
		return total;
	}
	
	// 상세보기
	public FoodVO foodDetailData(int fno) {
		FoodVO vo = new FoodVO();
		try {
			getConnection();
			String sql="SELECT fno, name, phone, address, poster, content "
					+"FROM food_house "
					+"WHERE fno="+fno;
			ps=conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			rs.next();
			vo.setFno(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setPhone(rs.getString(3));
			vo.setAddress(rs.getString(4));
			vo.setPoster(rs.getString(5));
			vo.setContent(rs.getString(6));
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			disConnection();
		}
		return vo;
	}
}
