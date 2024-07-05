package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.database.*;
public class GoodsDAO {
	private Connection conn;
	private PreparedStatement ps;
	public static GoodsDAO dao;
	private DataBaseConnection dbConn = new DataBaseConnection();
	private String [] tabs = {"","goods_all","goods_best", "goods_new", "goods_special"};
	
	public static GoodsDAO newInstance() {
		if(dao==null)
			dao=new GoodsDAO();
		return dao;
	}
	
	public List<GoodsVO> goodsFindData(int type,int page){
		List<GoodsVO> list = new ArrayList<GoodsVO>();
		try {
			conn=dbConn.getConnection();
			String sql="SELECT no, goods_poster, goods_name, num "
					+"FROM (SELECT no, goods_poster, goods_name, rownum as num "
					+"FROM (SELECT no, goods_poster, goods_name "
					+"FROM "+tabs[type]+")) "
					+"WHERE num BETWEEN ? AND ?";
			
			ps=conn.prepareStatement(sql);
			int rowSize=12;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			
			ps.setInt(2, start);
			ps.setInt(3, end);

			// 결과값
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				GoodsVO vo = new GoodsVO();
				vo.setNo(rs.getInt(1));
				vo.setGoods_name(rs.getString(2));
				vo.setGoods_poster(rs.getString(3).replace("https", "http"));
				list.add(vo);
			}
			rs.close();
					
		}catch(Exception ex) {
			System.out.println("=== 파인드 데이터 오류 발생 ===");
			ex.printStackTrace();
		}
		finally {
			dbConn.disConnection(conn, ps);
		}
		return list;
	}
	
	public int goodsFindTotalPage(int type) {
		int total=0;
		try {
			conn=dbConn.getConnection();
			String sql="SELECT CEIL(COUNT(*)/12.0) "
					+"FROM "+tabs[type];
			ps=conn.prepareStatement(sql);
			ps.setString(1, tabs[type]);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			dbConn.disConnection(conn, ps);
		}
		return total;
	}
	
	 public List<GoodsVO> goodsListData(int type,int page){
		 List<GoodsVO> list = new ArrayList<GoodsVO>();
		 try {
			 conn=dbConn.getConnection();
			 String sql ="SELECT no, goods_poster, goods_name, num "
					 +"FROM (SELECT no, goods_poster, goods_name, rownum as num "
					 +"FROM (SELECT no, goods_poster, goods_name "
					 +"FROM "+tabs[type]+"))"
					 +"WHERE num BETWEEN ? AND ?";
			 
			 
			 ps=conn.prepareStatement(sql);
			 int rowSize=12;
			 int start=(rowSize*page)-(rowSize-1);
			 int end=rowSize*page;
			 
			 ps.setInt(1, start);
			 ps.setInt(2, end);
			 
			 ResultSet rs=ps.executeQuery();
			 while(rs.next()) {
				 GoodsVO vo = new GoodsVO();
				 vo.setNo(rs.getInt(1));
				 vo.setGoods_poster(rs.getString(2).replace("https", "http"));
				 vo.setGoods_name(rs.getString(3));
				 list.add(vo);
			 }
			 rs.close();
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }
		 finally {
			 dbConn.disConnection(conn, ps);
		 }
		 return list;
	 }
	 
	 public int goodsListTotalPage(int type) {
		 int total=0;
		 try {
			 // 테이블 / 컬럼 => 문자열 결합 => setString() => ''
			 conn=dbConn.getConnection();
			 String sql="SELECT CEIL(COUNT(*)/12.0) "
					 +"FROM "+tabs[type];
			 
			 ps=conn.prepareStatement(sql);
			
			 ResultSet rs=ps.executeQuery();
			 rs.next();
			 total=rs.getInt(1);
			 rs.close();
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }
		 finally {
			 dbConn.disConnection(conn, ps);
		 }
		 return total;
		 
	 }
	 public GoodsVO goodsDetailDate(int no,int type) {
			GoodsVO vo = new GoodsVO();
			try {
				conn=dbConn.getConnection();
				String sql="SELECT no, goods_name, goods_price, goods_delivery, goods_poster, goods_discount, hit "
						+"FROM "+tabs[type];
				ps=conn.prepareStatement(sql);
				ps.setInt(1, type);
				
				ResultSet rs=ps.executeQuery();
				
				rs.next();
				vo.setNo(rs.getInt(1));
				vo.setGoods_name(rs.getString(2));
				vo.setGoods_price(rs.getString(3));
				vo.setGoods_delivery(rs.getString(4));
				vo.setGoods_poster(rs.getString(5).replace("https", "http"));
				vo.setGoods_discount(rs.getInt(6));
				vo.setHit(rs.getInt(7));
			
				rs.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			finally {
				dbConn.disConnection(conn, ps);
			}
			return vo;
		}
}
























