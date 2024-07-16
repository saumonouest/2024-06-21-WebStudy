package com.sist.dao2;

import lombok.Data;

@Data
public class FoodVO {
/*
 FNO                                       NOT NULL NUMBER
 NAME                                      NOT NULL VARCHAR2(200)
 TYPE                                      NOT NULL VARCHAR2(200)
 PHONE                                              VARCHAR2(30)
 ADDRESS                                            VARCHAR2(700)
 SCORE                                              NUMBER(2,1)
 THEME                                              CLOB
 POSTER                                    NOT NULL VARCHAR2(260)
 CONTENT                                            CLOB
 */
	private int fno;
	private String name,type,phone,address,theme,poster,content;
	private double score;
}
