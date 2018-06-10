package in.c2n.mla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.c2n.mla.entities.PostWithActiveQuestionnaireView;

@Repository
public interface PostWithActiveQuestionnaireViewRepository
		extends JpaRepository<PostWithActiveQuestionnaireView, Integer> {

	@Query(value = "SELECT * FROM POST_WITH_ACTIVE_QUESTIONNAIRE_VIEW WHERE UNIX_TIMESTAMP(POST_TIME)>:timestamp ORDER BY POST_TIME DESC", nativeQuery = true)
	List<PostWithActiveQuestionnaireView> findAllNew(@Param("timestamp") final String timestamp);

	@Query(value = "SELECT * FROM POST_WITH_ACTIVE_QUESTIONNAIRE_VIEW WHERE UNIX_TIMESTAMP(POST_TIME)<:timestamp ORDER BY POST_TIME DESC", nativeQuery = true)
	List<PostWithActiveQuestionnaireView> findAllOld(@Param("timestamp") final String timestamp);
}