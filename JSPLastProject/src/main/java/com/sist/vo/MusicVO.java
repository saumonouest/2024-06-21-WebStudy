package com.sist.vo;

import lombok.Data;

/*
 MNO                                       NOT NULL NUMBER(38)
 TITLE                                     NOT NULL VARCHAR2(4000)
 SINGER                                    NOT NULL VARCHAR2(4000)
 ALBUM                                              VARCHAR2(4000)
 POSTER                                    NOT NULL VARCHAR2(4000)
 STATE                                              VARCHAR2(26)
 IDCREMENT                                          NUMBER(38)
 */


@Data
public class MusicVO {
	private int mno, idcrement;
	private String title, singer, album, state, poster;
}
