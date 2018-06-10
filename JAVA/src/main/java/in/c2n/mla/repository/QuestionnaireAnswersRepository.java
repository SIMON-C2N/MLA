package in.c2n.mla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.c2n.mla.entities.QuestionnaireAnswers;

@Repository
public interface QuestionnaireAnswersRepository extends JpaRepository<QuestionnaireAnswers, Integer> {

	QuestionnaireAnswers findOneByPostIdAndUserId(final Integer postId,final Integer userId);
}
