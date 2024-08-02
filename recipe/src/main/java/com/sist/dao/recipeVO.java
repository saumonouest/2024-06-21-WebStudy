package com.sist.dao;

import lombok.Data;

/*
 * CNO           NOT NULL NUMBER        
   NAME          NOT NULL VARCHAR2(200) 
   BRAND         NOT NULL VARCHAR2(200) 
   DELIVERY               VARCHAR2(30)  
   PRICE                  VARCHAR2(700) 
   POSTER        NOT NULL VARCHAR2(260) 
   DETAIL_POSTER NOT NULL VARCHAR2(260) 
 */
@Data
public class recipeVO {
      private int cno;
      private String gname,brand,price,poster,detail_poster,saleprice,origin;

}