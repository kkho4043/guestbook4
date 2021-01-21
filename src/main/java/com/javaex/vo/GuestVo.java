package com.javaex.vo;

public class GuestVo {
	public int guestno;
	public String name;
	public String password;
	public String content;
	public String date;

	public GuestVo() {
	}

	public GuestVo(int guestno, String name, String password, String content, String date) {
		this.guestno = guestno;
		this.name = name;
		this.password = password;
		this.content = content;
		this.date = date;
	}

	public GuestVo(int guestno, String name, String content, String date) {
		this.guestno = guestno;
		this.name = name;
		this.content = content;
		this.date = date;
	}

	public GuestVo(String name, String password, String content) {
		this.name = name;
		this.password = password;
		this.content = content;
	}

	public GuestVo(int guestno, String name, String content) {
		this.guestno = guestno;
		this.name = name;
		this.content = content;
	}

	public int getGuestno() {
		return guestno;
	}

	public void setGuestno(int guestno) {
		this.guestno = guestno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
