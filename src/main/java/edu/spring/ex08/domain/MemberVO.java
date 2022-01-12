package edu.spring.ex08.domain;

public class MemberVO {

	private String userid;
	private String password;
	private String email;
	private String phone;
	
	public MemberVO() {}

	public MemberVO(String userid, String password, String email, String phone) {
		super();
		this.userid = userid;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", password=" + password + ", email=" + email + ", phone=" + phone
				+ ", getUserid()=" + getUserid() + ", getPassword()=" + getPassword() + ", getEmail()=" + getEmail()
				+ ", getPhone()=" + getPhone() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}// end
