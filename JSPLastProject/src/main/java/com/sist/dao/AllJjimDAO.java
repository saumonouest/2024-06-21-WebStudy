package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.vo.*;
public class AllJjimDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	// insert
	public static void allJjimInsert(Map map) {
		SqlSession session=null;
		try {
			session=ssf.openSession(true);
			session.insert("allJjimInsert",map);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
	}
	
	public static int allJjimCheck(Map map) {
		int count=0;
		SqlSession session=null;
		try {
			session=ssf.openSession(true);
			count=session.selectOne("allJjimCheck",map);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return count;
	}
	/*
		<update id="JjimCountIncrement" parameterType="hashmap">
			UPDATE project_food_house SET
			jjimcount=(SELECT COUNT(*) FROM all_jjim WHERE type=#{type} AND cno=#{cno})
			WHERE fno=#{cno}
		</update>
	 */
	public static void JjimCountIncrement(Map map) {
		SqlSession session=null;
		try {
			session=ssf.openSession(true);
			session.update("JjimCountIncrement",map);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
	}
}
