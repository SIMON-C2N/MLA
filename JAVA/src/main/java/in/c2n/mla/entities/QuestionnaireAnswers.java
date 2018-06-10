package in.c2n.mla.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QUESTIONNAIRE_ANSWERS")
public class QuestionnaireAnswers implements java.io.Serializable {

	private Integer id;
	private int postId;
	private String option;
	private int userId;

	public QuestionnaireAnswers() {
		// TODO Auto-generated constructor stub
	}

	public QuestionnaireAnswers(int postId, String option, int userId) {
		this.postId = postId;
		this.option = option;
		this.userId = userId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "POST_ID", nullable = false)
	public int getPostId() {
		return this.postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	@Column(name = "`OPTION`", nullable = false)
	public String getOption() {
		return this.option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	@Column(name = "USER_ID", nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}