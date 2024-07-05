package com.sist.dao;
import lombok.Data;

/*
 * 	NO			NUMBER(38,0)		No
	GOODS_GOODS_NAME	VARCHAR2(4000 BYTE)	Yes
	GOODS_SUB	VARCHAR2(4000 BYTE)	Yes
	GOODS_PRICE	VARCHAR2(26 BYTE)	Yes
	GOODS_DISCOUNT	NUMBER(38,0)	Yes
	GOODS_FIRST_PRICE	VARCHAR2(26 BYTE)	Yes
	GOODS_DELIVERY	VARCHAR2(26 BYTE)	Yes
	GOODS_POSTER	VARCHAR2(4000 BYTE)	Yes
	HIT	NUMBER(38,0)	Yes
 */
@Data
public class GoodsVO {
	private String goods_name, goods_price,goods_delivery, goods_poster;
	private int no, goods_discount, hit;
}
