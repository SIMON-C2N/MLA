package in.c2n.mla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.c2n.mla.entities.QuestionnaireView;

@Repository
public interface QuestionnaireViewRepository extends JpaRepository<QuestionnaireView, Integer> {
	int POSTS_RECORDS_PER_PAGE = 30;

	@Query(nativeQuery = true, value = "SELECT * FROM QUESTIONNAIRE_VIEW LIMIT 0,:limit")
	List<QuestionnaireView> findAllNewWithLimit(@Param("limit") final int limit);

	@Query(value = "SELECT * FROM QUESTIONNAIRE_VIEW WHERE UNIX_TIMESTAMP(POST_TIME)>:timestamp ORDER BY POST_TIME DESC LIMIT 0,:limit", nativeQuery = true)
	List<QuestionnaireView> findAllNew(@Param("timestamp") final String timestamp, @Param("limit") final int limit);

	@Query(value = "SELECT * FROM QUESTIONNAIRE_VIEW WHERE UNIX_TIMESTAMP(POST_TIME)<:timestamp ORDER BY POST_TIME DESC LIMIT 0,:limit", nativeQuery = true)
	List<QuestionnaireView> findAllOld(@Param("timestamp") final String timestamp, @Param("limit") final int limit);
	
	
}