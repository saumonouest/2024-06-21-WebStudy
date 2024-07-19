package com.sist.dao;
import java.sql.*;
import java.util.*;
import javax.sql.*;
import javax.naming.*;

public class EmpDAO {
	private Connection conn;
	   // AWS => 프로젝트 => 실행 => 어떤 위치든 상관없이 실행이 가능 
	   private PreparedStatement ps; 
	   private static EmpDAO dao;
	   
	   // 싱글턴 
	   public static EmpDAO newInstance()
	   {
		   if(dao==null)
			   dao=new EmpDAO();
		   return dao;
	   }
	  
	   public void getConnection()
	   {
		   // 미리 오라클 연결해서 저장된 Connection의 주소를 얻어 온다 
		   try
		   {
			   // 1. POOL에 연결 => JNDI (Java Naming Directory Interface)
			   // 이름형식으로 탐색기를 제작 
			   Context init=new InitialContext();// 탐색기 열기 
			   Context c=(Context)init.lookup("java://comp//env");// C드라이버에 접근 
			   DataSource ds=(DataSource)c.lookup("jdbc/oracle");// 원하는 폴더선택 
			   conn=ds.getConnection();// 파일을 읽기 (주소 얻기)
		   }catch(Exception ex) 
		   {
			   ex.printStackTrace();
		   }
	   }
	   public void disConnection()
	   {
		   // 반환 => 사용후에 
		   try
		   {
			   if(ps!=null) ps.close();
			   if(conn!=null) conn.close();
		   }catch(Exception ex) {}
	   }
	   
	   public List<EmpVO> empListData(){
		   List<EmpVO> list = new ArrayList<EmpVO>();
		   try {
			   getConnection();
			   String sql="SELECT empno, ename, job, sal, hiredate "
					   +"FROM emp";
			   ps=conn.prepareStatement(sql);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next()){
				   EmpVO vo = new EmpVO();
				   vo.setEmpno(rs.getInt(1));
				   vo.setEname(rs.getString(2));
				   vo.setJob(rs.getString(3));
				   vo.setSal(rs.getInt(4));
				   vo.setHiredate(rs.getDate(5));
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
}













