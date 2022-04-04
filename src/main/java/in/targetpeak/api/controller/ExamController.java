package in.targetpeak.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.targetpeak.api.entity.exam.core.ExaminationListReponse;
import in.targetpeak.api.entity.exam.core.ExaminationsListRequest;
import in.targetpeak.api.entity.exam.regular.ExamSubjectListRequest;
import in.targetpeak.api.entity.exam.regular.ExamSubjectListResponse;
import in.targetpeak.api.service.ExamService;
import io.swagger.annotations.Api;

@RequestMapping(value = "/exam", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Exam", value = "Exams related all rest endpoints", description = "")
@RestController
public class ExamController {

	@Autowired
	private ExamService examService;

//	@GetMapping()
//	public ExaminationListReponse getExaminationList(ExaminationsListRequest request) {
//		return examService.fetchExaminationList(request);
//	}
//
//	@GetMapping("/subjects")
//	public ExamSubjectListResponse getExamSubjkectsLists(ExamSubjectListRequest request) {
//		return examService.fetchRegularExamSubjects(request);
//	}
//	
	
	
	
//	public ExaminationListReponse getExaminationList(ExaminationsListRequest request) {
//		return examService.fetchExaminationList(request);
//	}

	@GetMapping("/examinations")
	public ExaminationListReponse getExaminationList(ExaminationsListRequest request) {
		return examService.fetchExaminationList(request);
	}
	
	@GetMapping()
	public ExamSubjectListResponse getExamSubjkectsLists(ExamSubjectListRequest request) {
		return examService.fetchRegularExamSubjects(request);
	}

}
