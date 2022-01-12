package edu.spring.ex08.domain;

import java.util.Date;

public class FBoardVO {
//jsp단이랑 맞춰야한다. .////
	private String bno; /// 게시글 번호 
	private String ftitle; // 게시글 제목 
	private String fcontent; // 게시글 내용 
	private String fuserid; // 작성자 
	private Date fcdate; // 작성일 
	
	
	public FBoardVO() {}


	public FBoardVO(String bno, String ftitle, String fcontent, String fuserid, Date fcdate) {
		super();
		this.bno = bno;
		this.ftitle = ftitle;
		this.fcontent = fcontent;
		this.fuserid = fuserid;
		this.fcdate = fcdate;
	}


	public String getBno() {
		return bno;
	}


	public void setBno(String bno) {
		this.bno = bno;
	}


	public String getFtitle() {
		return ftitle;
	}


	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}


	public String getFcontent() {
		return fcontent;
	}


	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}


	public String getFuserid() {
		return fuserid;
	}


	public void setFuserid(String fuserid) {
		this.fuserid = fuserid;
	}


	public Date getFcdate() {
		return fcdate;
	}


	public void setFcdate(Date fcdate) {
		this.fcdate = fcdate;
	}


	@Override
	public String toString() {
		return "FBoardVO [bno=" + bno + ", ftitle=" + ftitle + ", fcontent=" + fcontent + ", fuserid=" + fuserid
				+ ", fcdate=" + fcdate + ", getBno()=" + getBno() + ", getFtitle()=" + getFtitle() + ", getFcontent()="
				+ getFcontent() + ", getFuserid()=" + getFuserid() + ", getFcdate()=" + getFcdate() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}// end FBoardVO
