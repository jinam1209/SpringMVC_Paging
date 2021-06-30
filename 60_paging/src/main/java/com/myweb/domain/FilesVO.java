package com.myweb.domain;

public class FilesVO {
	private String uuid;
	private String savedir;
	private String fname;
	private int ftype;
	private int pno;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getSavedir() {
		return savedir;
	}
	public void setSavedir(String savedir) {
		this.savedir = savedir;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getFtype() {
		return ftype;
	}
	public void setFtype(int ftype) {
		this.ftype = ftype;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	
}
