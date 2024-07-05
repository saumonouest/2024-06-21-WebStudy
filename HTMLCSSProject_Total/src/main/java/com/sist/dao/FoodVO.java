package com.sist.dao;
import lombok.Data;
/*
 *	자바 / 오라클 / JSP / Spring / Spring-Boot
 *
 *	desc table_name; 확인
 *
 *	변수명 = 컬럼명 동일
 *	=> 데이터를 브라우저로 전송할 목록 VO (~DTO) => JSP (Bean) => 자바 12장
 *	   =============== 해킹
 *		| 캡슐화 사용 => 변수 private, 메소드를 이용해서 접근 
 *
 *	데이터형 일치
 *	========= 테이블 한 개 => VO / DAO
 *		오라클 데이터형
 *		==========
 *		CHAR, VARCHAR2, CLOB => String
 *		NUMBER => int / double (NUMBER(2,1))
 *		DATE => java.util.Date (java.sql.Date)
 *				=> 오늘 날짜 : SYSDATE
 *				=> 예약일 : YY/MM/DD 아니면 TO_DATE로 변환 후에 INSERT
 *		VO => 한 개의 맛집
 *			  ======== 상세보기
 *		목록 => 여러개의 맛집
 *			  ========= VO가 여러개 => List
 *		MyBatis / JPA => 컬럼이 다르면 변경
 *
 *		goods_name 
 *
 *		@Column(name="goods_name")
 *		String name;
 */
@Data
public class FoodVO {
	private int fno;
	private String name, type, phone, address, theme, poster, content;
	private double score;
}
