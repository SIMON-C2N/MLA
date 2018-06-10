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
import in.c2n.mla.vo.UserFCMVO;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public ResponseEntity<Page<User>> findAll(final Pageable pageable) {
		return new ResponseEntity<Page<User>>(userRepository.findAll(pageable), HttpStatus.OK);
	}

	public Object saveUser(User user) {

		if (Objects.nonNull(user)) {
			if (Objects.nonNull(user.getMobileNo()) && !user.getMobileNo().isEmpty()) {
				User existing_user = userRepository.findOneByMobileNo(user.getMobileNo());

				if (Objects.nonNull(existing_user)) {
					return new ResponseEntity<>(HttpStatus.OK);
				} else {
					return new ResponseEntity<>(userRepository.saveAndFlush(user), HttpStatus.OK);
				}
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	public Object login(final LoginVO loginVO) {
		if (Objects.nonNull(loginVO)) {
			final User user = userRepository.findOneByMobileNoAndPassword(loginVO.getMobileNo(), loginVO.getPassword());

			if ((Objects.nonNull(user)) && user.getId() != 0) {
				return new ResponseEntity<>(user, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	public Object registerFCM(final UserFCMVO userFCMVO) {

		if (Objects.nonNull(userFCMVO)) {
			if (Objects.nonNull(userFCMVO.getId()) && userFCMVO.getId() > 0) {
				User user = userRepository.findOne(userFCMVO.getId());

				if (Objects.nonNull(user)) {
					if (Objects.nonNull(userFCMVO.getFcmKey())) {

						user.setFcmKey(userFCMVO.getFcmKey());

						userRepository.saveAndFlush(user);

						return new ResponseEntity<>(HttpStatus.OK);
					} else {
						return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
					}
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}

			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}