package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.database.*;

public class GoodsDAO {
	private Connection conn;
	private PreparedStatement ps;
	public static GoodsDAO dao; // 싱글턴
	private DataBaseConnection dbConn = new DataBaseConnection();
	
	// 싱글턴 
		public static GoodsDAO newInstance() {
			if(dao==null)
				dao=new GoodsDAO();
			return dao;
		}
	public List<GoodsVO> goodsListData(int page){
		List<GoodsVO> list = new ArrayList<GoodsVO>();
		try {
			conn=dbConn.getConnection();
			String sql= "SELECT no, goods_poster, goods_name, num "
					+"FROM (SELECT no, goods_poster, goods_name, rownum as num "
					+"FROM (SELECT no, goods_poster, goods_name "
					+"FROM goods_all ORDER BY no)) "
					+"WHERE num BETWEEN ? AND ?";
			ps=conn.prepareStatement(sql);
			int rowSize=12;
			int start=(rowSize*page)-(rowSize-1);
			int end = rowSize*page;
			ps.setInt(1,start);
			ps.setInt(2, end);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				GoodsVO vo = new GoodsVO();
				vo.setNo(rs.getInt(1));
				vo.setGoods_poster(rs.getString(2));
				vo.setGoods_name(rs.getString(3));
				list.add(vo);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			dbConn.disConnection(conn, ps);
		}
		return list;
	}
	
	public int GoodsTotalPage() {
		int total=0;
		try {
			conn=dbConn.getConnection();
			String sql="SELECT CEIL(COUNT(*)/12.0) FROM goods_all";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			
			total=rs.getInt(1);
			rs.next();
		}catch(Exception ex) {
				ex.printStackTrace();
		}
		finally {
			dbConn.disConnection(conn, ps);
		}
		return total;
	}
	
	public GoodsVO goodsDetailDate(int no) {
		GoodsVO vo = new GoodsVO();
		try {
			conn=dbConn.getConnection();
			String sql ="UPDATE goods_all SET "
					+"hit=hit+1 "
					+"WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ps.executeUpdate();
			
			sql="SELECT no, goods_name, goods_price, goods_delivery, goods_poster, goods_discount, hit "
					+"FROM goods_all "
					+"WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			
			ResultSet rs=ps.executeQuery();
			
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setGoods_name(rs.getString(2));
			vo.setGoods_price(rs.getString(3));
			vo.setGoods_delivery(rs.getString(4));
			vo.setGoods_poster(rs.getString(5).replace("https", "http"));
			vo.setGoods_discount(rs.getInt(6));
			vo.setHit(rs.getInt(7));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			dbConn.disConnection(conn, ps);
		}
		return vo;
	}
}












