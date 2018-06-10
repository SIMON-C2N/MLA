package in.c2n.mla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.c2n.mla.entities.PostLikes;

@Repository
public interface PostLikesRepository extends JpaRepository<PostLikes, Integer> {
	Long countByPostIdAndUserId(final int postId, final int userId);

	PostLikes findOneByPostIdAndUserId(final int postId, final int userId);
}