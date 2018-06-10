package in.c2n.mla.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import in.c2n.mla.entities.Post;
import in.c2n.mla.entities.QuestionnaireAnswers;
import in.c2n.mla.entities.QuestionnaireAnswersView;
import in.c2n.mla.entities.QuestionnaireView;
import in.c2n.mla.repository.PostRepository;
import in.c2n.mla.repository.QuestionnaireAnswersRepository;
import in.c2n.mla.repository.QuestionnaireAnswersViewRepository;
import in.c2n.mla.repository.QuestionnaireViewRepository;
import in.c2n.mla.vo.QuestionnaireResponseVO;
import in.c2n.mla.vo.QuestionnaireVO;

@Service
public class QuestionnaireService {

	@Autowired
	private QuestionnaireViewRepository questionnaireViewRepository;

	@Autowired
	private QuestionnaireAnswersViewRepository answersViewRepository;

	@Autowired
	private QuestionnaireAnswersRepository answersRepository;

	@Autowired
	private PostRepository postRepository;

	public ResponseEntity<Page<QuestionnaireView>> findAll(final Pageable pageable) {
		return new ResponseEntity<Page<QuestionnaireView>>(questionnaireViewRepository.findAll(pageable),
				HttpStatus.OK);
	}

	public ResponseEntity<QuestionnaireResponseVO> findAll(String timestamp, final char choice) {
		List<QuestionnaireView> questions = null;
		List<QuestionnaireAnswersView> old_answer_counts = null;

		if (Objects.nonNull(timestamp)) {
			timestamp = timestamp.substring(0, timestamp.length() - 3);
			if (choice == 'N') {
				questions = questionnaireViewRepository.findAllNew(timestamp,
						QuestionnaireViewRepository.POSTS_RECORDS_PER_PAGE);
				old_answer_counts = answersViewRepository.findAllUpdatedAnswers(timestamp,
						QuestionnaireViewRepository.POSTS_RECORDS_PER_PAGE);
			} else if (choice == 'O') {
				questions = questionnaireViewRepository.findAllOld(timestamp,
						QuestionnaireViewRepository.POSTS_RECORDS_PER_PAGE);
			} else if (choice == 'L') {
				old_answer_counts = answersViewRepository.findAllUpdatedAnswers(timestamp,
						QuestionnaireViewRepository.POSTS_RECORDS_PER_PAGE);
			}
		} else {
			questions = questionnaireViewRepository
					.findAllNewWithLimit(QuestionnaireViewRepository.POSTS_RECORDS_PER_PAGE);
		}

		final QuestionnaireResponseVO responseVO = new QuestionnaireResponseVO();

		if (Objects.nonNull(questions)) {
			responseVO.setQuestions(questions);
		}

		if (Objects.nonNull(old_answer_counts)) {
			responseVO.setOld_answers_count(old_answer_counts);
		}

		return new ResponseEntity<QuestionnaireResponseVO>(responseVO, HttpStatus.OK);
	}

	public ResponseEntity<Object> updateQuestionnaireById(final QuestionnaireVO questionnaireVO) {

		ResponseEntity<Object> response = null;
		if (Objects.nonNull(questionnaireVO)
				&& ((Objects.nonNull(questionnaireVO.getId())) && (questionnaireVO.getId() > 0))
				&& ((Objects.nonNull(questionnaireVO.getUserId())) && (questionnaireVO.getUserId() > 0))) {

			Post post = postRepository.findOne(questionnaireVO.getId());
			QuestionnaireAnswers answers = answersRepository.findOneByPostIdAndUserId(questionnaireVO.getId(),
					questionnaireVO.getUserId());

			if (Objects.nonNull(post)) {
				final StringBuilder new_count = new StringBuilder();
				if (Objects.nonNull(answers)) {

					updateCount(post, answers, questionnaireVO, new_count);

					answers.setOption(questionnaireVO.getqOption());
				} else {

					updateCount(post, null, questionnaireVO, new_count);

					final Integer questionnaireId = questionnaireVO.getId();
					final Integer userId = questionnaireVO.getUserId();
					final String answer = questionnaireVO.getqOption();

					answers = new QuestionnaireAnswers(questionnaireId, answer, userId);

				}

				post.setQAnswers(new_count.toString());

				post = postRepository.saveAndFlush(post);
				answersRepository.saveAndFlush(answers);
				response = new ResponseEntity<Object>(post, HttpStatus.OK);
			} else {
				response = new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}

		} else {
			response = new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}

		return response;
	}

	private StringBuilder updateCount(final Post post, final QuestionnaireAnswers answers,
			final QuestionnaireVO questionnaireVO, final StringBuilder new_count) {
		final String[] options = post.getQOptions().split(",");
		final String[] counts = post.getQAnswers().split(",");

		for (int i = 0; i < options.length; i++) {
			if (Objects.nonNull(answers) && options[i].equals(answers.getOption())) {
				new_count.append(Integer.parseInt(counts[i]) - 1);
			} else if (options[i].equals(questionnaireVO.getqOption())) {
				new_count.append(Integer.parseInt(counts[i]) + 1);
			} else {
				new_count.append(counts[i]);
			}

			if ((i + 1) != options.length) {
				new_count.append(",");
			}
		}
		return new_count;
	}
}