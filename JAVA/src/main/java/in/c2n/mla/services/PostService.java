package in.c2n.mla.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import in.c2n.mla.entities.PostLikes;
import in.c2n.mla.entities.PostLikesView;
import in.c2n.mla.entities.PostView;
import in.c2n.mla.entities.PostWithActiveQuestionnaireView;
import in.c2n.mla.repository.PostLikesRepository;
import in.c2n.mla.repository.PostLikesViewRepository;
import in.c2n.mla.repository.PostViewRepository;
import in.c2n.mla.repository.PostWithActiveQuestionnaireViewRepository;
import in.c2n.mla.vo.LikesVO;
import in.c2n.mla.vo.PostResponseVO;

@Service
public class PostService {

	@Autowired
	private PostLikesRepository postLikesRepository;

	@Autowired
	private PostViewRepository postViewRepository;

	@Autowired
	private PostWithActiveQuestionnaireViewRepository activeQuestionnaireViewRepository;
	
	@Autowired
	private PostLikesViewRepository postLikesViewRepository;
	
	public ResponseEntity<Page<PostWithActiveQuestionnaireView>> findAll(final Pageable pageable) {
		return new ResponseEntity<Page<PostWithActiveQuestionnaireView>>(
				activeQuestionnaireViewRepository.findAll(pageable), HttpStatus.OK);
	}

	public ResponseEntity<PostResponseVO> findAll(String timestamp, final char choice) {
		List<PostView> posts = null;
		List<PostLikesView> likes = null;
		
		if (Objects.nonNull(timestamp)) {
			timestamp = timestamp.substring(0, timestamp.length() - 3);
			if (choice == 'N') {
				posts = postViewRepository.findAllNew(timestamp,PostViewRepository.POSTS_RECORDS_PER_PAGE);
				likes = postLikesViewRepository.findAllUpdatedLikes(timestamp, PostViewRepository.POSTS_RECORDS_PER_PAGE);
			} else if(choice == 'O'){
				posts = postViewRepository.findAllOld(timestamp, PostViewRepository.POSTS_RECORDS_PER_PAGE);
			} else if(choice == 'L'){
				likes = postLikesViewRepository.findAllUpdatedLikes(timestamp, PostViewRepository.POSTS_RECORDS_PER_PAGE);
			}
		} else {
			posts = postViewRepository.findAllNewWithLimit(PostViewRepository.POSTS_RECORDS_PER_PAGE);
		}
		
		final PostResponseVO responseVO = new PostResponseVO();
		
		if(Objects.nonNull(posts)){
			responseVO.setPosts(posts);
		}
		
		if(Objects.nonNull(likes)){
			responseVO.setLikes(likes);
		}
		
		return new ResponseEntity<PostResponseVO>(responseVO, HttpStatus.OK);
	}

	public ResponseEntity<Object> likeOrDislike(final LikesVO likesVO) {
		ResponseEntity<Object> response = null;
		if (Objects.nonNull(likesVO) && ((Objects.nonNull(likesVO.getId())) && (likesVO.getId() > 0))
				&& ((Objects.nonNull(likesVO.getUserId()) && (likesVO.getUserId() > 0)))) {

			PostLikes postLikes = postLikesRepository.findOneByPostIdAndUserId(likesVO.getId(), likesVO.getUserId());
			if (Objects.nonNull(postLikes)) {
				postLikes.setFlag(likesVO.getVote().byteValue());
			} else {
				postLikes = new PostLikes();
				postLikes.setPostId(likesVO.getId());
				postLikes.setUserId(likesVO.getUserId());
				postLikes.setFlag(likesVO.getVote().byteValue());
			}

			response = new ResponseEntity<Object>(postLikesRepository.saveAndFlush(postLikes), HttpStatus.OK);
		} else {
			response = new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}

		return response;
	}
}