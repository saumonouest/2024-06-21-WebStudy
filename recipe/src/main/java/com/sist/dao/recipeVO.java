package com.sist.dao;

import lombok.Data;

/*
   RNO           NOT NULL NUMBER         
   HIT                    NUMBER         
   ID                     VARCHAR2(4000) 
   NAME          NOT NULL VARCHAR2(4000) 
   SUBNAME                VARCHAR2(4000) 
   AMOUNT                 VARCHAR2(4000) 
   TIME                   VARCHAR2(4000) 
   GRADE                  VARCHAR2(4000) 
   INGREDIENTS   NOT NULL VARCHAR2(4000) 
   STEPS         NOT NULL VARCHAR2(4000) 
   POSTER        NOT NULL VARCHAR2(4000) 
   DETAIL_POSTER NOT NULL VARCHAR2(4000) 
 */
@Data
public class recipeVO {
      private int rno, hit;
       private String id, name, subname, amount, time, grade, ingredients, steps, poster, detail_poster;

}