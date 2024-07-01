package com.sist.dao;
import java.util.*;
import java.sql.*;

public class GoodsDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static GoodsDAO dao;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	//드라이버 등록
	public GoodsDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {}
	}
	// 오라클 연결
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception ex) {}
	}
	
	// 오라클 해제
	public void disConnection() {
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex) {}
	}
	
	// 싱글턴
	public static GoodsDAO newInstance() {
		if(dao==null)
			dao=new GoodsDAO();
		return dao;
	}
	
	// 목록 = 50개
	public List<GoodsVO> goodsListData(){
		List<GoodsVO> list = new ArrayList<GoodsVO>();
		try {
			// 1.연결 
			getConnection();
			
			// 2.오라클에 전송할 SQL 문장 제작
			String sql = "SELECT no, goods_poster, goods_name, goods_price, rownum "
					+"FROM goods_all "
					+"WHERE rownum<=50";
			
			// 3. 오라클 전송
			ps=conn.prepareStatement(sql);
			
			// 4. 결과값 받기
			ResultSet rs = ps.executeQuery();
			 
			// rs에 저장된 결과값을 list에 담기
			while(rs.next()) {
				GoodsVO vo = new GoodsVO();
				vo.setNo(rs.getInt(1));
				vo.setPoster(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setPrice(rs.getString(4));
			}
			rs.close();
		}catch(Exception ex) {
			// 오류 확인
			ex.printStackTrace();
		}
		finally {
			disConnection();
		}
		return list;
	}
	// 상세 보기 => CSS를 적용 ==> ?no=1
	public GoodsVO goodsDetailData(int no) {
		GoodsVO vo = new GoodsVO();
		try {
			getConnection();
			String sql ="SELECT no, goods_poster, goods_name, goods_price, "
					+"goods_sub, goods_delivery, goods_discount "
					+"FROM goods_all "
					+"WHERE no=?";
			
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			
			// 결과값 받기
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setPoster(rs.getString(2));
			vo.setName(rs.getString(3));
			String price = rs.getString(4);
			vo.setPrice(price);
			vo.setPrice(rs.getString(4));
			vo.setSub(rs.getString(5));
			vo.setDelivery(rs.getString(6));
			vo.setDiscount(rs.getInt(7));
			String rp=price.replaceAll("[^0-9]", "");
			vo.setRprice(Integer.parseInt(rp));

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


















