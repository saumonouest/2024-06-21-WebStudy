package com.sist.dao;

import lombok.Data;

/*
	FNO	NUMBER
	NAME	VARCHAR2(200 BYTE)
	TYPE	VARCHAR2(200 BYTE)
	PHONE	VARCHAR2(30 BYTE)
	ADDRESS	VARCHAR2(700 BYTE)
	SCORE	NUMBER(2,1)
	THEME	CLOB
	POSTER	VARCHAR2(260 BYTE)
	CONTENT	CLOB
	HIT	NUMBER
	JJIMCOUNT	NUMBER
	LIKECOUNT	NUMBER
 */
@Data
public class FoodVO {
	private int fno, hit, jjimcount, likecount;
	private String name, type, phone, address, theme, poster, content;
	private Double score;
}
