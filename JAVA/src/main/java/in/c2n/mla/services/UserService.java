package in.c2n.mla.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import in.c2n.mla.entities.User;
import in.c2n.mla.repository.UserRepository;
import in.c2n.mla.vo.LoginVO;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public ResponseEntity<Page<User>> findAll(final Pageable pageable) {
		return new ResponseEntity<Page<User>>(userRepository.findAll(pageable), HttpStatus.OK);
	}

	public void saveUser(final User user) {
		userRepository.saveAndFlush(user);
	}
	
	public Object login(final LoginVO loginVO) {
		Integer loginId = userRepository.login(loginVO.getMobileNo(), loginVO.getPassword());
		
		if((Objects.nonNull(loginId)) && loginId != 0){
			return new ResponseEntity<>(HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}