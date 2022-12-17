package com.ibik.pbo.teori.jdbc.dao.students;

public class Students {
	
	private Integer id;
	private String npm;
	private String firstname;
	private String middlename;
	private String lastname;
	private String email;
	private String birthdate;
	
	
	public String getNpm() {
		return npm;
	}
	public void setNpm(String npm) {
		this.npm = npm;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
