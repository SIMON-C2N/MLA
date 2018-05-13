package in.c2n.mla.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QUESTION_ANSWERS")
public class QuestionAnswers implements java.io.Serializable {

	private int questionId;
	private int userId;
	private int questionOptionId;

	@Id
	@Column(name = "QUESTION_ID", nullable = false)
	public int getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	@Column(name = "USER_ID", nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "QUESTION_OPTION_ID", nullable = false)
	public int getQuestionOptionId() {
		return this.questionOptionId;
	}

	public void setQuestionOptionId(int questionOptionId) {
		this.questionOptionId = questionOptionId;
	}
}