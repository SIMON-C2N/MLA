package in.c2n.mla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.c2n.mla.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findOneByMobileNoAndPassword(final String mobileNo, final String password);

	public User findOneByMobileNo(final String mobileNo);
}