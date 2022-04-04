package in.targetpeak.api.dao;

import in.targetpeak.api.entity.ApiResponse;
import in.targetpeak.api.entity.lms.syllabus.chapter.ChapterListRequest;
import in.targetpeak.api.entity.lms.syllabus.chapter.ChapterListResponse;
import in.targetpeak.api.entity.lms.syllabus.chapter.ChapterRequest;
import in.targetpeak.api.entity.lms.syllabus.topic.TopicListRequest;
import in.targetpeak.api.entity.lms.syllabus.topic.TopicListResponse;
import in.targetpeak.api.entity.lms.syllabus.topic.TopicRequest;

public interface LmsSyllabusDao {

	/***
	 * ----------------------------------------------------------------------------------
	 * 
	 * Chapter Section
	 * 
	 * ----------------------------------------------------------------------------------
	 ***/
	public ChapterListResponse fetchChapters(ChapterListRequest request);

	public ApiResponse manageChapter(ChapterRequest request);

	/***
	 * ----------------------------------------------------------------------------------
	 * 
	 * Topic Section
	 * 
	 * ----------------------------------------------------------------------------------
	 ***/
	public TopicListResponse fetchTopics(TopicListRequest request);

	public ApiResponse manageTopic(TopicRequest request);
}
