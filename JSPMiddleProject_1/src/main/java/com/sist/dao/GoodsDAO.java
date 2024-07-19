package com.sist.dao;
import java.sql.*;
import java.util.*;
import javax.sql.*;
import javax.naming.*;

public class GoodsDAO {
   private Connection conn;
   private PreparedStatement ps;
   private static GoodsDAO dao;
   
   public static GoodsDAO newInstance() {
      if(dao==null) dao=new GoodsDAO();
      return dao;
   }
   
   // 미리 생성된 Connection의 주소를 얻어온다 => 시작과 동시에 10개 생성 => maxIdle ="10"
   public void getConnection() {
      try {
         Context init = new InitialContext();
         Context c = (Context)init.lookup("java://comp/env");
         DataSource ds = (DataSource)c.lookup("jdbc/oracle");
         conn=ds.getConnection();
      } catch (Exception ex) {
         ex.printStackTrace();
      } 
   }
   // 사용후에 반환해서 재사용이 가능하게 만든다
   public void disConnection() {
      try {
         if(ps!=null) ps.close();
         if(conn!=null) conn.close();
      } catch (Exception ex) {}
   }
   // goods와 관련된 기능
   public List<GoodsVO> goodsListData(int page){
      List<GoodsVO> list = new ArrayList<GoodsVO>();
      try {
         getConnection();
         String sql ="select no,goods_name,goods_poster,goods_price ,num"
               + "     from (select no,goods_name,goods_poster,goods_price ,rownum as num "
               + "            from (select /*+ INDEX_ASC(goods_all goods_no_pk)*/no,goods_name,goods_poster,goods_price "
               + "                  from goods_all )) "
               + "     where num between ? and ?";
         ps=conn.prepareStatement(sql);
         int rowSize=12;
         int start=(rowSize*page)-(rowSize-1);
         int end = rowSize*page;
         
         ps.setInt(1, start);
         ps.setInt(2, end);
         
         ResultSet rs = ps.executeQuery();
         while(rs.next()) {
            GoodsVO vo = new GoodsVO();
            vo.setNo(rs.getInt(1));
            vo.setName(rs.getString(2));
            vo.setPoster(rs.getString(3));
            vo.setPrice(rs.getString(4));
            list.add(vo);
         }
         rs.close();
      } catch (Exception ex) {
         ex.printStackTrace();
      } finally {
         disConnection();
      }
      return list;
   }
   
   public int goodsTotalPage() {
      int total=0;
      try {
         getConnection();
         String sql = "select ceil(count(*)/12.0) from goods_all ";
         ps=conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery();
         rs.next();
         total=rs.getInt(1);
         rs.close();
      } catch (Exception ex) {
         ex.printStackTrace();
      }finally {
         disConnection();
      }
      return total;
   }
}
