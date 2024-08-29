package com.sist.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class AdminDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf = CreateSqlSessionFactory.getSsf();
	}
	public static int boycheck() {
		SqlSession session = null;
		int btotal=0;
		
		try {
			session=ssf.openSession(true);
			btotal=session.selectOne("boycheck");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return btotal;
	}
	public static int girlcheck() {
		SqlSession session = null;
		int gtotal=0;
		
		try {
			session=ssf.openSession(true);
			gtotal=session.selectOne("girlcheck");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return gtotal;
	}
	public static int totalcheck() {
		SqlSession session = null;
		int total=0;
		
		try {
			session=ssf.openSession(true);
			total=session.selectOne("totalcheck");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return total;
	}
}
