package cn.true123.mybatis.domain;

import java.util.Date;


/**
 * @author 
 * CREATE TABLE `student` (
  `studId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `phonenumber` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`studId`)
) ENGINE=InnoDB AUTO_INCREMENT=10101 DEFAULT CHARSET=utf8;

 *
 */
public class Student
{
	private Integer studId;
	private String name;
	private String email;
	private Date dob;
	
	private PhoneNumber phoneNumber;
	
	
	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Student() {
		
	}
	
	public Student(Integer studId) {
		this.studId = studId;
	}
	
	public Student(Integer studId, String name, String email, Date dob) {
		this.studId = studId;
		this.name = name;
		this.email = email;
		this.dob = dob;
	}

	
	
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", name=" + name + ", email=" + email + ", dob=" + dob + ", phoneNumber="
				+ phoneNumber + "]";
	}

	public Integer getStudId() {
		return studId;
	}
	public void setStudId(Integer studId) {
		this.studId = studId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
}
