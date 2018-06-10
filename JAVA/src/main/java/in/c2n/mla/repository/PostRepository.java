package in.c2n.mla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.c2n.mla.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
	
}