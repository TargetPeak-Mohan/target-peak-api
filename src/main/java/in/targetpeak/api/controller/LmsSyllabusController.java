package in.targetpeak.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.targetpeak.api.entity.ApiResponse;
import in.targetpeak.api.entity.lms.syllabus.chapter.ChapterListRequest;
import in.targetpeak.api.entity.lms.syllabus.chapter.ChapterListResponse;
import in.targetpeak.api.entity.lms.syllabus.chapter.ChapterRequest;
import in.targetpeak.api.entity.lms.syllabus.topic.TopicListRequest;
import in.targetpeak.api.entity.lms.syllabus.topic.TopicListResponse;
import in.targetpeak.api.entity.lms.syllabus.topic.TopicRequest;
import in.targetpeak.api.service.LmsSyllabusService;
import io.swagger.annotations.Api;

@RequestMapping(value = "/lms", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "LMS", value = "LMS(Organization,Institute,Class,Division) Resource REST Endpoint", description = "")
@RestController
public class LmsSyllabusController {

	@Autowired
	private LmsSyllabusService syllabusService;

	@GetMapping("/syllabus/chapter")
	public ChapterListResponse getChaptersList(ChapterListRequest request) {
		return syllabusService.getChapterList(request);
	}

	@PostMapping("/syllabus/chapter")
	public ApiResponse manageChapter(@RequestBody ChapterRequest request) {
		return syllabusService.manageChapter(request);
	}

	@GetMapping("/syllabus/topic")
	public TopicListResponse getTopicList(TopicListRequest request) {
		return syllabusService.getTopicList(request);
	}

	@PostMapping("/syllabus/topic")
	public ApiResponse manageTopic(@RequestBody TopicRequest request) {
		return syllabusService.manageTopic(request);
	}
}
