package in.c2n.mla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.c2n.mla.entities.QuestionnaireAnswersView;

@Repository
public interface QuestionnaireAnswersViewRepository extends JpaRepository<QuestionnaireAnswersView, Integer> {
	@Query(value = "SELECT * FROM QUESTIONNAIRE_ANSWERS_VIEW WHERE UNIX_TIMESTAMP(POST_TIME)<=:timestamp ORDER BY POST_TIME DESC LIMIT 0,:limit", nativeQuery = true)
	List<QuestionnaireAnswersView> findAllUpdatedAnswers(@Param("timestamp") final String timestamp,
			@Param("limit") final int limit);
}
