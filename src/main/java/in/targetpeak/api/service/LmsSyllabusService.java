package in.targetpeak.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.targetpeak.api.dao.LmsSyllabusDao;
import in.targetpeak.api.entity.ApiResponse;
import in.targetpeak.api.entity.lms.syllabus.chapter.ChapterListRequest;
import in.targetpeak.api.entity.lms.syllabus.chapter.ChapterListResponse;
import in.targetpeak.api.entity.lms.syllabus.chapter.ChapterRequest;
import in.targetpeak.api.entity.lms.syllabus.topic.TopicListRequest;
import in.targetpeak.api.entity.lms.syllabus.topic.TopicListResponse;
import in.targetpeak.api.entity.lms.syllabus.topic.TopicRequest;

@Service
public class LmsSyllabusService {

	@Autowired
	private LmsSyllabusDao lmsSyllabusDao;

	public ChapterListResponse getChapterList(ChapterListRequest request) {
		return lmsSyllabusDao.fetchChapters(request);
	}

	public ApiResponse manageChapter(ChapterRequest request) {
		return lmsSyllabusDao.manageChapter(request);
	}

	public TopicListResponse getTopicList(TopicListRequest request) {
		return lmsSyllabusDao.fetchTopics(request);
	}

	public ApiResponse manageTopic(TopicRequest request) {
		return lmsSyllabusDao.manageTopic(request);
	}

}
