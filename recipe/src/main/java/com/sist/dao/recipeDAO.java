package com.sist.dao;
import java.util.*;
import java.sql.*;
public class recipeDAO {
   private Connection conn;
   private PreparedStatement ps;
   private static recipeDAO dao;
   private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
   
   // 드라이버 등록 
   public recipeDAO()
   {
      try
      {
         Class.forName("oracle.jdbc.driver.OracleDriver");
      }catch(Exception ex) {}
   }
   
   // 연결 
   public void getConnection()
   {
      try
      {
         conn=DriverManager.getConnection(URL,"hr","happy");
      }catch(Exception ex) {}
   }
   // 해제 
   public void disConnection()
   {
      try
      {
         if(ps!=null) ps.close();
         if(conn!=null) conn.close();
      }catch(Exception ex) {}
   }
   // 싱글턴
   public static recipeDAO newInstance()
   {
      if(dao==null)
         dao=new recipeDAO();
      return dao;
   }
   // 기능 
   /*
    *       CNO           NOT NULL NUMBER        
         NAME          NOT NULL VARCHAR2(200) 
         BRAND         NOT NULL VARCHAR2(200) 
         DELIVERY               VARCHAR2(30)  
         PRICE                  VARCHAR2(700) 
         POSTER        NOT NULL VARCHAR2(260) 
         DETAIL_POSTER NOT NULL VARCHAR2(260) 
    */
   public void cgoodsInsert(recipeVO vo)
   {
      try
      {
         getConnection();
         String sql="INSERT INTO camp_goods(cno,gname,brand,price,saleprice,origin,poster,detail_poster) "
                 +"VALUES(cg_cno_seq.nextval,?,?,?,?,?,?,?)";
         ps=conn.prepareStatement(sql);
         ps.setString(1,vo.getGname() );
         ps.setString(2, vo.getBrand());
         ps.setString(3, vo.getPrice());
         ps.setString(4, vo.getSaleprice());
         ps.setString(5, vo.getOrigin());
         ps.setString(6, "http:"+vo.getPoster());
         ps.setString(7, vo.getDetail_poster());
         
         ps.executeUpdate();
      }catch(Exception ex)
      {
         ex.printStackTrace();
      }
      finally
      {
         disConnection();
      }
   }
}