package in.c2n.mla.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.c2n.mla.entities.User;
import in.c2n.mla.services.UserService;
import in.c2n.mla.vo.LoginVO;
import in.c2n.mla.vo.UserFCMVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@Api(value = "USER", description = "User Services", tags = "USER")
@RestController
@RequestMapping("/user")
public class UserResource {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "Find out all the users.", response = Page.class, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK") })
	@GetMapping
	public Object findAll(@PageableDefault(size = 50) final Pageable pageable) {
		return userService.findAll(pageable);
	}

	@ApiOperation(value = "User Registration.", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK") })
	@PostMapping
	public Object saveUser(@RequestBody(required = true) User user) {
		return userService.saveUser(user);
	}

	@ApiOperation(value = "User Login.", consumes = MediaType.APPLICATION_JSON_VALUE, response = User.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "User not found.") })
	@PostMapping("/login")
	public Object login(@RequestBody(required = true) final LoginVO loginVO) {
		return userService.login(loginVO);
	}

	@ApiOperation(value = "User FCM Registration.", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad Request") })
	@PostMapping("/fcm")
	public Object registerFCMKey(@RequestBody(required = true) UserFCMVO userFCMVO) {
		return userService.registerFCM(userFCMVO);
	}
}