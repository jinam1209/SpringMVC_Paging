package com.myweb.domain;

public class MemberVO {
	private String email;
	private String pwd;
	private String nickname;
	private String regdate;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "MemberVO [email=" + email + ", pwd=" + pwd + ", nickname=" + nickname + ", regdate=" + regdate + "]";
	}
	
}