package in.c2n.mla.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "USER")
public class User implements java.io.Serializable {

	@ApiModelProperty(required = false)
	private Integer id;
	@ApiModelProperty(notes = "Name", required = true)
	private String name;
	@ApiModelProperty(notes = "Mobile No", required = true)
	private String mobileNo;
	@ApiModelProperty(notes = "DOB - FORMAT (YYYY-MM-DD)", required = true)
	private String dob;
	@ApiModelProperty(notes = "GENDER - VALUES ('M', 'F', 'O')", required = true)
	private char gender;
	@ApiModelProperty(notes = "Password", required = true)
	private String password;
	@ApiModelProperty(notes = "Posting time", required = false)
	private Date postTime;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "NAME", nullable = false, length = 55)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "MOBILE_NO", nullable = false, length = 15)
	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Column(name = "DOB", nullable = false, length = 15)
	public String getDob() {
		return this.dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Column(name = "GENDER", nullable = false, length = 1)
	public char getGender() {
		return this.gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Column(name = "PASSWORD", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "POST_TIME", nullable = false, length = 19)
	public Date getPostTime() {
		return this.postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

}