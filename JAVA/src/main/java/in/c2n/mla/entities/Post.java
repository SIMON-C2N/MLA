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
@Table(name = "POST")
public class Post implements java.io.Serializable {

	private Integer id;
	private String description;
	private String imageUrls;
	private String videoUrls;
	private String question;
	private String QOptions;
	private byte QFlag;
	private Date postTime;
	private char postType;
	private String QAnswers;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "DESCRIPTION", nullable = false, length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "IMAGE_URLS", nullable = false, length = 65535)
	public String getImageUrls() {
		return this.imageUrls;
	}

	public void setImageUrls(String imageUrls) {
		this.imageUrls = imageUrls;
	}

	@Column(name = "VIDEO_URLS", nullable = false, length = 65535)
	public String getVideoUrls() {
		return this.videoUrls;
	}

	public void setVideoUrls(String videoUrls) {
		this.videoUrls = videoUrls;
	}

	@Column(name = "QUESTION", nullable = false, length = 65535)
	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Column(name = "Q_OPTIONS", nullable = false)
	public String getQOptions() {
		return this.QOptions;
	}

	public void setQOptions(String QOptions) {
		this.QOptions = QOptions;
	}

	@Column(name = "Q_FLAG", nullable = false)
	public byte getQFlag() {
		return this.QFlag;
	}

	public void setQFlag(byte QFlag) {
		this.QFlag = QFlag;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "POST_TIME", nullable = false, length = 19)
	public Date getPostTime() {
		return this.postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	@Column(name = "POST_TYPE", nullable = false, length = 1)
	public char getPostType() {
		return this.postType;
	}

	public void setPostType(char postType) {
		this.postType = postType;
	}

	@Column(name = "Q_ANSWERS", nullable = false)
	public String getQAnswers() {
		return this.QAnswers;
	}

	public void setQAnswers(String QAnswers) {
		this.QAnswers = QAnswers;
	}

}