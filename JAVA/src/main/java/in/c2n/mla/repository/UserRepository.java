package in.c2n.mla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.c2n.mla.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT id from User WHERE mobileNo=:mobileNo AND password=:password")
	public Integer login(@Param("mobileNo") final String mobileNo, @Param("password") final String password);
}