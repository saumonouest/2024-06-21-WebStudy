package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.dao.*;
public class FoodDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static FoodDAO dao;
	private DbcpConnection dbConn = new DbcpConnection();
	public static FoodDAO newInstance() {
		if(dao==null)
			dao = new FoodDAO();
		return dao;
	}
	
	public List<FoodVO> foodListData(int page){
		List<FoodVO> list = new ArrayList<FoodVO>();
		try {
			conn=dbConn.getConnection();
			String sql="SELECT fno, name, poster, num "
					+"FROM (SELECT fno, name, poster, rownum as num "
					+"FROM (SELECT fno, name, poster "
					+"FROM food_house ORDER BY fno ASC)) "
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
				vo.setPoster(rs.getString(3).replace("https", "http"));
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
	
	public int foodTotalPage() {
		int total = 0;
		try {
			conn=dbConn.getConnection();
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
			dbConn.disConnection(conn, ps);
		}
		return total;
	}
	
	public FoodVO foodDetailData(int fno) {
		FoodVO vo = new FoodVO();
		try {
			conn=dbConn.getConnection();
			String sql="SELECT fno, name, score, hit, type, phone, address, theme, poster, content "
					+"FROM food_house "
					+"WHERE fno="+fno;
			ps=conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			rs.next();
			vo.setFno(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setScore(rs.getDouble(3));
			vo.setHit(rs.getInt(4));
			vo.setType(rs.getString(5));
			vo.setPoster(rs.getString(6).replace("https", "http"));
			vo.setAddress(rs.getString(7));
			vo.setTheme(rs.getString(8));
			vo.setPhone(rs.getString(9));
			vo.setContent(rs.getString(10));
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


















