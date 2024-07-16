package com.sist.bean;

import lombok.Data;

// VO(Value , DTO, Bean => 같은 개념 
// Spring MyBatis JSP => 데이터를 모아서 한번에 전송할 목적
// 변수를 제어 => 읽기(getter) / 쓰기(setter)
// => 데이터를 해킹 방지 => 숨겨서 보내준다 => 캡슐화 => 데이터를 보호할 목적


public class MemberVO {
	private String name, sex, address, phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
 