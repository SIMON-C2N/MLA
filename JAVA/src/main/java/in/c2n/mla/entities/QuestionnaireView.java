package in.c2n.mla.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QUESTIONNAIRE_VIEW")
public class QuestionnaireView implements java.io.Serializable {

	private int id;
	private String question;
	private String QOptions;
	private String QAnswers;
	private Date postTime;

	@Id
	@Column(name = "ID", nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Column(name = "Q_ANSWERS", nullable = false)
	public String getQAnswers() {
		return this.QAnswers;
	}

	public void setQAnswers(String QAnswers) {
		this.QAnswers = QAnswers;
	}

	@Column(name = "POST_TIME", nullable = false, length = 19)
	public Date getPostTime() {
		return this.postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

}