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

@Entity
@Table(name = "QUESTIONAIRE")
public class Questionaire implements java.io.Serializable {

	private Integer id;
	private Date postTime;
	private String question;
	private byte flag;
	private byte QType;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "POST_TIME", nullable = false, length = 19)
	public Date getPostTime() {
		return this.postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	@Column(name = "QUESTION", nullable = false)
	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Column(name = "FLAG", nullable = false)
	public byte getFlag() {
		return this.flag;
	}

	public void setFlag(byte flag) {
		this.flag = flag;
	}

	@Column(name = "Q_TYPE", nullable = false)
	public byte getQType() {
		return this.QType;
	}

	public void setQType(byte QType) {
		this.QType = QType;
	}

}