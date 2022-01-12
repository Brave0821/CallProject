package edu.spring.ex08.domain;

import java.util.Date;

public class CBoardVO {

	private String bno; // 게시글 번호 
	private String ctitle; // 게시글 제목 
	private String ccontent; // 게시글 내용  
	private String cuserid; // 작성자
	private Date ccdate; // 작성일
	
	
	
	public CBoardVO() {}

	public CBoardVO(String bno, String ctitle, String ccontent, String cuserid, Date ccdate) {
		super();
		this.bno = bno;
		this.ctitle = ctitle;
		this.ccontent = ccontent;
		this.cuserid = cuserid;
		this.ccdate = ccdate;
	}

	public String getBno() {
		return bno;
	}

	public void setBno(String bno) {
		this.bno = bno;
	}

	public String getCtitle() {
		return ctitle;
	}

	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}

	public String getCcontent() {
		return ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}

	public String getCuserid() {
		return cuserid;
	}

	public void setCuserid(String cuserid) {
		this.cuserid = cuserid;
	}

	public Date getCcdate() {
		return ccdate;
	}

	public void setCcdate(Date ccdate) {
		this.ccdate = ccdate;
	}

	
	@Override
	public String toString() {
		return "CBoardVO [bno=" + bno + ", ctitle=" + ctitle + ", ccontent=" + ccontent + ", cuserid=" + cuserid
				+ ", ccdate=" + ccdate + ", getBno()=" + getBno() + ", getCtitle()=" + getCtitle() + ", getCcontent()="
				+ getCcontent() + ", getCuserid()=" + getCuserid() + ", getCcdate()=" + getCcdate() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}// end 
