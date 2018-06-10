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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.c2n.mla.services.PostService;
import in.c2n.mla.vo.LikesVO;
import in.c2n.mla.vo.PostResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@Api(value = "POST", description = "POST SERVICES", tags = "POST")
@RestController
@RequestMapping("/post")
public class PostResource {

	@Autowired
	private PostService postService;

	@ApiOperation(value = "Find out all Posts.", response = Page.class, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK") })
	@GetMapping
	public Object findAll(final @PageableDefault(size = 30) Pageable pageable) {
		return postService.findAll(pageable);
	}

	@ApiOperation(value = "Find out all new Posts.", response = PostResponseVO.class, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK") })
	@GetMapping("/new")
	public Object findAllNew(@RequestParam(name = "timestamp", required = false) final String timestamp) {
		return postService.findAll(timestamp, 'N');
	}

	@ApiOperation(value = "Find out all old Posts.", response = PostResponseVO.class, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK") })
	@GetMapping("/old")
	public Object findAllOld(@RequestParam(name = "timestamp", required = false) final String timestamp) {
		return postService.findAll(timestamp, 'O');
	}

	@ApiOperation(value = "Find out all likes updates of old Posts.", response = PostResponseVO.class, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK") })
	@GetMapping("/old/likes")
	public Object findAllLikesUpdates(@RequestParam(name = "timestamp", required = false) final String timestamp) {
		return postService.findAll(timestamp, 'L');
	}

	@ApiOperation(value = "Update Likes/Dislikes.")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 200, message = "OK") })
	@PostMapping("/likes")
	public Object likeOrDislike(@RequestBody(required = true) final LikesVO likesVO) {
		return postService.likeOrDislike(likesVO);
	}
}