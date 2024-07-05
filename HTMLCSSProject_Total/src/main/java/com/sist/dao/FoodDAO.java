package com.sist.dao;
/*
 *	클래스의 종류(역할) => 클래스는 한 개의 기능을 수행
 *					==================== 컴포넌트
 *	VO => 데이터를 모아서 한 번에 브라우저 / 모바일로 전송
 *	DAO => 데이터베이스 연동
 *	Manager => 관리 => 데이터 수집 / Open API
 *	Service => 사용자 요청에 대한 처리
 *	Model(Controller) => 사용자 요청을 받아서 => 결과를 전송
 *	================= MVC (Spring MVC)
 *	
 */
import java.util.*;
import com.sist.database.*;
import java.sql.*;
/*			JSP프로젝트		Spring프로젝트 Spring-Boot => 개인프로젝트
 *	JDBC ===> DBCP ===> ORM ===> DataSet
 *	 |		  |			 |		 	|
 *	기본		연결 속도 		라이브러리  	자동 SQL문장을 만들어준다(JPA)
 *		Connection 관리  (데이터베이스만 연결)
 *						MyBatis
 */
public class FoodDAO {
	private Connection conn; // 오라클 연결 담당 
	private PreparedStatement ps; // SQL 문장 전송 => 실행 결과를 가지고 옴
	// 		미리 SQL 문장을 전송하고 필요한 데이터는 나중에 전송을 한다
	//						  ================== ? 값 
	private static FoodDAO dao;
	// 싱글턴 => 메모리 공간을 1개만 사용 => 메모리 누수현상을 방지, Connection을 남발하지 않는다
	// => 서버의 부하를 줄일 목적
	private DataBaseConnection dbConn = new DataBaseConnection();
	// 연결 / 해제 => 모든 데이터베이스에서 공통사용 기능 => 라이브러리화
	
	// 싱글턴
	public static FoodDAO newInstance() {
		if(dao==null)
			dao=new FoodDAO();
		return dao;
	}
	
	// 기능 수행
	public List<FoodVO> foodListData(){
		List<FoodVO> list = new ArrayList<FoodVO>();
		try {
			/*
			 *	예외처리
			 *	=====
			 *	java.sql, java.io, java.net => 컴파일 예외 (반드시 예외처리를 한다)
			 */
			
			// 연결
			conn=dbConn.getConnection();
			
			// SQL 문장 제작
			String sql="SELECT fno, name, poster, rownum "
					+"FROM food_house "
					+"WHERE rownum<=20";

			// SQL 문장 전송
			ps=conn.prepareStatement(sql);
			
			// 필요한 데이터 있는 지 확인 => ?
			// 오라클에서 실행된 결과값을 받는다
			ResultSet rs=ps.executeQuery();
			
			// List에 첨부 후 전송 준비
			while(rs.next()) {
				FoodVO vo= new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setPoster(rs.getString(3).replace("https", "http"));
				list.add(vo);
			}
			
		}catch(Exception ex) {
			System.out.println("=== 리스트 데이터 오류 발생 ===");
			ex.printStackTrace();
		}
		finally {
			dbConn.disConnection(conn, ps);
		}
		return list;
	}
}






















