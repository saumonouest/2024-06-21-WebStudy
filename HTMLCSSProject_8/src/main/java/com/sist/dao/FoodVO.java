package com.sist.dao;
import lombok.Data;
/*
 *	자바 / 오라클 / JSP / Spring / Spring-Boot
 */
@Data
public class FoodVO {
	private int fno;
	private String name, type, phone, address, theme, poster, content;
	private double score;
}
