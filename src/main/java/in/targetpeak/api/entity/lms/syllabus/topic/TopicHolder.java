package in.targetpeak.api.entity.lms.syllabus.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TopicHolder {

	@Id
	Integer SyllabusTopicId;
	Integer SyllabusChapterId;
	String TopicName;
	String TopicNameInMarathi;
	Integer RecordStatus;
	Integer RowCount;

	public TopicHolder() {
		super();
	}

	public Integer getRowCount() {
		return RowCount;
	}

	public void setRowCount(Integer rowCount) {
		RowCount = rowCount;
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

	@Override
	public String toString() {
		return "TopicHolder [RowCount=" + RowCount + ", SyllabusTopicId=" + SyllabusTopicId + ", SyllabusChapterId="
				+ SyllabusChapterId + ", TopicName=" + TopicName + ", TopicNameInMarathi=" + TopicNameInMarathi
				+ ", RecordStatus=" + RecordStatus + "]";
	}

}
