package in.targetpeak.api.entity.lms.syllabus.topic;

public class TopicRequest {

	Integer AttendantId;
	Integer AttendantRoleId;
	Integer Action;

	Integer SyllabusTopicId;
	Integer SyllabusChapterId;

	String TopicName;
	String TopicNameInMarathi;
	Integer RecordStatus;

	public TopicRequest() {
		super();
	}

	public TopicRequest(Integer attendantId, Integer attendantRoleId, Integer action, Integer syllabusTopicId,
			Integer syllabusChapterId, String topicName, String topicNameInMarathi, Integer recordStatus) {
		super();
		AttendantId = attendantId;
		AttendantRoleId = attendantRoleId;
		Action = action;
		SyllabusTopicId = syllabusTopicId;
		SyllabusChapterId = syllabusChapterId;
		TopicName = topicName;
		TopicNameInMarathi = topicNameInMarathi;
		RecordStatus = recordStatus;
	}

	public Integer getAttendantId() {
		return AttendantId;
	}

	public void setAttendantId(Integer attendantId) {
		AttendantId = attendantId;
	}

	public Integer getAttendantRoleId() {
		return AttendantRoleId;
	}

	public void setAttendantRoleId(Integer attendantRoleId) {
		AttendantRoleId = attendantRoleId;
	}

	public Integer getAction() {
		return Action;
	}

	public void setAction(Integer action) {
		Action = action;
	}

	public Integer getSyllabusTopicId() {
		return SyllabusTopicId;
	}

	public void setSyllabusTopicId(Integer syllabusTopicId) {
		SyllabusTopicId = syllabusTopicId;
	}

	public Integer getSyllabusChapterId() {
		return SyllabusChapterId;
	}

	public void setSyllabusChapterId(Integer syllabusChapterId) {
		SyllabusChapterId = syllabusChapterId;
	}

	public String getTopicName() {
		return TopicName;
	}

	public void setTopicName(String topicName) {
		TopicName = topicName;
	}

	public String getTopicNameInMarathi() {
		return TopicNameInMarathi;
	}

	public void setTopicNameInMarathi(String topicNameInMarathi) {
		TopicNameInMarathi = topicNameInMarathi;
	}

	public Integer getRecordStatus() {
		return RecordStatus;
	}

	public void setRecordStatus(Integer recordStatus) {
		RecordStatus = recordStatus;
	}

}
