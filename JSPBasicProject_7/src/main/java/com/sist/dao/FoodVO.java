package com.sist.dao;

import lombok.Data;

public class FoodVO {
   private int fno;
   private String name,type,phone,address,theme,poster,content;
   private double score;
public int getFno() {
	return fno;
}
public void setFno(int fno) {
	this.fno = fno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getTheme() {
	return theme;
}
public void setTheme(String theme) {
	this.theme = theme;
}
public String getPoster() {
	return poster;
}
public void setPoster(String poster) {
	this.poster = poster;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public double getScore() {
	return score;
}
public void setScore(double score) {
	this.score = score;
}
}
