package edu.spring.ex08.domain;

import java.util.Date;

public class NBoardVO {
	
	private String bno; // 게시글 번호 
	private String ntitle; // 게시글 제목
	private String ncontent;// 게시글 내용 
	private String nuserid; // 작성자
	private Date ncdate; // 작성일 
	
	
	// 11-25 게시판 검색 추가.
	
//	private String type; // 검색 타입.
//	private String keyword; // 검색 타입.
//	
	

	public NBoardVO() {}



	public NBoardVO(String bno, String ntitle, String ncontent, String nuserid, Date ncdate) {
		super();
		this.bno = bno;
		this.ntitle = ntitle;
		this.ncontent = ncontent;
		this.nuserid = nuserid;
		this.ncdate = ncdate;
	}



	public String getBno() {
		return bno;
	}



	public void setBno(String bno) {
		this.bno = bno;
	}



	public String getNtitle() {
		return ntitle;
	}



	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}



	public String getNcontent() {
		return ncontent;
	}



	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}



	public String getNuserid() {
		return nuserid;
	}



	public void setNuserid(String nuserid) {
		this.nuserid = nuserid;
	}



	public Date getNcdate() {
		return ncdate;
	}



	public void setNcdate(Date ncdate) {
		this.ncdate = ncdate;
	}



	@Override
	public String toString() {
		return "NBoardVO [bno=" + bno + ", ntitle=" + ntitle + ", ncontent=" + ncontent + ", nuserid=" + nuserid
				+ ", ncdate=" + ncdate + ", getBno()=" + getBno() + ", getNtitle()=" + getNtitle() + ", getNcontent()="
				+ getNcontent() + ", getNuserid()=" + getNuserid() + ", getNcdate()=" + getNcdate() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}



}// end BoardVO ()
