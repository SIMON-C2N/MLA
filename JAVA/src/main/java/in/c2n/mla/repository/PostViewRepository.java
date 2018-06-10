package in.c2n.mla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.c2n.mla.entities.PostView;

@Repository
public interface PostViewRepository extends JpaRepository<PostView, Integer> {

	int POSTS_RECORDS_PER_PAGE = 30;
	
	
	@Query(nativeQuery = true, value = "SELECT * FROM POST_VIEW LIMIT 0,:limit")
	List<PostView> findAllNewWithLimit(@Param("limit") final int limit);

	@Query(value = "SELECT * FROM POST_VIEW WHERE UNIX_TIMESTAMP(POST_TIME)>:timestamp ORDER BY POST_TIME DESC LIMIT 0,:limit", nativeQuery = true)
	List<PostView> findAllNew(@Param("timestamp") final String timestamp, @Param("limit") final int limit);

	@Query(value = "SELECT * FROM POST_VIEW WHERE UNIX_TIMESTAMP(POST_TIME)<:timestamp ORDER BY POST_TIME DESC LIMIT 0,:limit", nativeQuery = true)
	List<PostView> findAllOld(@Param("timestamp") final String timestamp,
			@Param("limit") final int limit);
}