package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.vo.*;
public class DataBoardDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	// 기능
	public static void databoardInsert(DataBoardVO vo) {
		  SqlSession session=null;
		  try
		  {
			  session=ssf.openSession(true); 
			  session.insert("databoardRowCount", vo);
			  
		  }catch(Exception ex)
		  {
			  ex.printStackTrace();
			  System.out.println("DAO-1");
		  }
		  finally
		  {
			  if(session!=null)
				  session.close(); // 반환 (DBCP사용)
		  }
	}
	public static List<DataBoardVO> databoardListData(Map map){
		List<DataBoardVO> list = new ArrayList<DataBoardVO>();
		SqlSession session=null;
		  try
		  {
			  session=ssf.openSession(); 
			  list=session.selectList("databoardListData", map);
			  
		  }catch(Exception ex)
		  {
			  ex.printStackTrace();
			  System.out.println("DAO-1");
		  }
		  finally
		  {
			  if(session!=null)
				  session.close(); // 반환 (DBCP사용)
		  }
		  return list;
	}
	
	public static int databoardRowCount() {
		int count=0;
		SqlSession session=null;
		  try
		  {
			  session=ssf.openSession(); 
			  count=session.selectOne("databoardRowCount");
			  
		  }catch(Exception ex)
		  
		  {
			  ex.printStackTrace();
			  System.out.println("DAO-1");
		  }
		  finally
		  {
			  if(session!=null)
				  session.close(); // 반환 (DBCP사용)
		  }
		return count;
	}
}
