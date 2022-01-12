package edu.spring.ex08.domain;

import java.sql.Date;

public class FReplyVO {

	// 11.16
	
	private int freplyno; // 댓글 번호 
	private int freplybno; // 게시글 번호 
	private String freplycontent; // 댓글 내용 
	private String freplyid; //댓글 작성자 ID
	private Date freplydate; //댓글 작성/ 수정 시간.
	
	
	public FReplyVO() {}
	
	
	public FReplyVO(int freplyno, int freplybno, String freplycontent, String freplyid, Date freplydate) {
		super();
		this.freplyno = freplyno;
		this.freplybno = freplybno;
		this.freplycontent = freplycontent;
		this.freplyid = freplyid;
		this.freplydate = freplydate;
	}



	public int getFreplyno() {
		return freplyno;
	}



	public void setFreplyno(int freplyno) {
		this.freplyno = freplyno;
	}



	public int getFreplybno() {
		return freplybno;
	}



	public void setFreplybno(int freplybno) {
		this.freplybno = freplybno;
	}



	public String getFreplycontent() {
		return freplycontent;
	}



	public void setFreplycontent(String freplycontent) {
		this.freplycontent = freplycontent;
	}



	public String getFreplyid() {
		return freplyid;
	}



	public void setFreplyid(String freplyid) {
		this.freplyid = freplyid;
	}



	public Date getFreplydate() {
		return freplydate;
	}



	public void setFreplydate(Date freplydate) {
		this.freplydate = freplydate;
	}



	@Override
	public String toString() {
		return "FReplyVO [freplyno=" + freplyno + ", freplybno=" + freplybno + ", freplycontent=" + freplycontent
				+ ", freplyid=" + freplyid + ", freplydate=" + freplydate + ", getFreplyno()=" + getFreplyno()
				+ ", getFreplybno()=" + getFreplybno() + ", getFreplycontent()=" + getFreplycontent()
				+ ", getFreplyid()=" + getFreplyid() + ", getFreplydate()=" + getFreplydate() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}// end
