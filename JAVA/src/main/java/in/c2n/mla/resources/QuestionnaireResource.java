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

import in.c2n.mla.services.QuestionnaireService;
import in.c2n.mla.vo.QuestionnaireResponseVO;
import in.c2n.mla.vo.QuestionnaireVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "QUESTIONNAIRE", description = "QUESTIONNAIRE SERVICES", tags = "QUESTIONNAIRE")
@RestController
@RequestMapping("/questionnaire")
@CrossOrigin
public class QuestionnaireResource {

	@Autowired
	private QuestionnaireService questionnaireService;

	@ApiOperation(value = "Find out all Questionnaire.", response = Page.class, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK") })
	@GetMapping
	public Object findAll(@PageableDefault final Pageable pageable) {
		return questionnaireService.findAll(pageable);
	}

	@ApiOperation(value = "Find out all new Questionnaire.", response = QuestionnaireResponseVO.class, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK") })
	@GetMapping("/new")
	public Object findAllNew(@RequestParam(name = "timestamp", required = false) final String timestamp) {
		return questionnaireService.findAll(timestamp, 'N');
	}

	@ApiOperation(value = "Find out all old Questionnaire.", response = QuestionnaireResponseVO.class, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK") })
	@GetMapping("/old")
	public Object findAllOld(@RequestParam(name = "timestamp", required = false) final String timestamp) {
		return questionnaireService.findAll(timestamp, 'O');
	}

	@ApiOperation(value = "Find out all answers updates of old Questionnaire.", response = QuestionnaireResponseVO.class, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK") })
	@GetMapping("/old/answers")
	public Object findAllLikesUpdates(@RequestParam(name = "timestamp", required = false) final String timestamp) {
		return questionnaireService.findAll(timestamp, 'L');
	}

	@ApiOperation(value = "Update Questionnaire answers.")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Questionnaire-Post Not Found."),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 200, message = "OK") })
	@PostMapping("/answers")
	public Object likeOrDislike(@RequestBody(required = true) final QuestionnaireVO questionnaireVO) {
		return questionnaireService.updateQuestionnaireById(questionnaireVO);
	}
}