package in.c2n.mla.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "POST_WITH_ACTIVE_QUESTIONNAIRE_VIEW")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostWithActiveQuestionnaireView implements java.io.Serializable {

	private int id;
	private String description;
	private String imageUrls;
	private String videoUrls;
	private String question;
	private String QOptions;
	private char postType;
	private String QAnswers;
	private Date postTime;
	private long totalLikesCount;

	@Column(name = "ID", nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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

	@Id
	@Column(name = "POST_TIME", nullable = false, length = 19)
	public Date getPostTime() {
		return this.postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	@Column(name = "TOTAL_LIKES_COUNT", nullable = false)
	public long getTotalLikesCount() {
		return this.totalLikesCount;
	}

	public void setTotalLikesCount(long totalLikesCount) {
		this.totalLikesCount = totalLikesCount;
	}

}