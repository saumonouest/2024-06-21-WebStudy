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
       RNO           NOT NULL NUMBER         
      HIT                    NUMBER         
      ID                     VARCHAR2(4000) 
      NAME          NOT NULL VARCHAR2(4000) 
      SUBNAME                VARCHAR2(4000) 
      AMOUNT                 VARCHAR2(4000) 
      TIME                   VARCHAR2(4000) 
      GRADE                  VARCHAR2(4000) 
      INGREDIENTS   NOT NULL VARCHAR2(4000) 
      STEPS         NOT NULL VARCHAR2(4000) 
      POSTER        NOT NULL VARCHAR2(4000) 
      DETAIL_POSTER NOT NULL VARCHAR2(4000) 
    */
   public void cgoodsInsert(recipeVO vo)
   {
      try
      {
         getConnection();
         String sql="INSERT INTO recipe(rno,hit, id,name,subname,amount,time,grade,ingredients,steps,poster,detail_poster) "
                 +"VALUES(re_cno_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";
         ps=conn.prepareStatement(sql);
         ps.setInt(1,vo.getRno() );
         ps.setInt(2, vo.getHit());
         ps.setString(3, vo.getId());
         ps.setString(4, vo.getName());
         ps.setString(5, vo.getSubname());
         ps.setString(6, vo.getAmount());
         ps.setString(7, vo.getTime());
         ps.setString(8, vo.getGrade());
         ps.setString(9, vo.getIngredients());
         ps.setString(10, vo.getSteps());
         ps.setString(11, "http:"+vo.getPoster());
         ps.setString(12, vo.getDetail_poster());
         
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