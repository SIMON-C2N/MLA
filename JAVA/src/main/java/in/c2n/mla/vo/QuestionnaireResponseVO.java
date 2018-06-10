package in.c2n.mla.vo;

import java.util.ArrayList;
import java.util.List;

import in.c2n.mla.entities.QuestionnaireAnswersView;
import in.c2n.mla.entities.QuestionnaireView;

public class QuestionnaireResponseVO {
	private List<QuestionnaireView> questions = new ArrayList<QuestionnaireView>();
	private List<QuestionnaireAnswersView> old_answers_count = new ArrayList<QuestionnaireAnswersView>();

	public List<QuestionnaireView> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionnaireView> questions) {
		this.questions = questions;
	}

	public List<QuestionnaireAnswersView> getOld_answers_count() {
		return old_answers_count;
	}

	public void setOld_answers_count(List<QuestionnaireAnswersView> old_answers_count) {
		this.old_answers_count = old_answers_count;
	}

}