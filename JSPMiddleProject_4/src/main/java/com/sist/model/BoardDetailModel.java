package com.sist.model;
// 요청처리 후에 결과값을 JSP로 전송 : Model
// 오라클 연결 / 데이터를 모은다 / 전송
//  DAO			VO 		 Model   ==> Model
/*
 * 1. GIT
 * 2. 데이터베이스 설계 => 정규화
 * 3. ERD
 * 4. 유스케이스 다이어그램
 * 5. UI => 화면
 * 6. 구현
 * 7. 테스팅
 * 8. 배포 ==> AWS
 */
/*
 *  JSP => Java : URL 주소로 Java는 호출이 불가능
 *  	request 객체를 전송
 * 
 * 	JSP => JSP : URL 주소로 값을 전송이 가능
 *  JSP => Servlet : URL 주소로 값을 전송이 가능 
 */
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.text.*;
import com.sist.dao.*;

public class BoardDetailModel implements Model {
	public String execute (HttpServletRequest request) { // _OK가 들어가면 리스폰스가 필요한 거임 화면 바꿔주는 애들
		String no = request.getParameter("no");
		BoardDAO dao = BoardDAO.newInstance();
		BoardVO vo = dao.boardDetailData(Integer.parseInt(no));
		
		request.setAttribute("vo", vo);
		
		return "detail.jsp";
	} 
}