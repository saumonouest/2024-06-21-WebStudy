package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.vo.*;

public class FoodDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf=CreateSqlSessionFactory.getSsf();
	}
	public static List<FoodVO> foodListData(Map map){
		List<FoodVO> list = new ArrayList<FoodVO>();
		SqlSession session=null;
		try {
			session=ssf.openSession();
			list=session.selectList("foodListData", map);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return list;
	}
	
	public static int foodTotalPage() {
		int total=0;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			total=session.selectOne("foodTotalPage");
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null)
				session.close();
		}
		return total;
	}
	
	public static FoodVO foodDetailData(int fno) {
		FoodVO vo = new FoodVO();
		SqlSession session=null;
		try
		   {
			   session=ssf.openSession();
			   // 조회수 증가 
			   session.update("foodHitIncrement",fno);
			   session.commit(); // insert,update,delete
			   
			   // 데이터 읽기 
			   vo=session.selectOne("foodDetailData",fno);
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   if(session!=null)
				   session.close();
		   }
		   return vo;
	   }
	
	public static List<FoodVO> foodFindListData(Map map)
	   {
		   List<FoodVO> list=new ArrayList<FoodVO>();
		   SqlSession session=null;
		   try
		   {
			   session=ssf.openSession();
			   list=session.selectList("foodFindListData",map);
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   if(session!=null)
				   session.close();
		   }
		   return list;
	   }
	public static int foodFindTotalPage(String ss)
	   {
		   int total=0;
		   SqlSession session=null;
		   try
		   {
			   session=ssf.openSession();
			   total=session.selectOne("foodFindTotalPage",ss);
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   if(session!=null)
				   session.close();
		   }
		   return total;
	   }
	 
}
