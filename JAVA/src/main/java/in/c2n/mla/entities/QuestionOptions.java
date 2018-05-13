package in.c2n.mla.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QUESTION_OPTIONS")
public class QuestionOptions implements java.io.Serializable {

	private Integer id;
	private int questionId;
	private String option;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "QUESTION_ID", nullable = false)
	public int getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	@Column(name = "OPTION", nullable = false, length = 25)
	public String getOption() {
		return this.option;
	}

	public void setOption(String option) {
		this.option = option;
	}

}