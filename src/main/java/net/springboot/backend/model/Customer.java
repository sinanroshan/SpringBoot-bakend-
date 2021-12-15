package net.springboot.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@Column(name = "phone")
	private String phoneNo;
	
	@Column(name = "fName")
	private String firstName;
	
	@Column(name = "sName")
	private String secondName;
	
	@Column(name = "EmailId")
	private String emailid;
	
	@Column(name = "password1")
	private String pass1;

	public Customer(String phoneNo, String firstName, String secondName, String emailid, String pass1) {
		super();
		this.phoneNo = phoneNo;
		this.firstName = firstName;
		this.secondName = secondName;
		this.emailid = emailid;
		this.pass1 = pass1;

	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPass1() {
		return pass1;
	}

	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}

	
}
