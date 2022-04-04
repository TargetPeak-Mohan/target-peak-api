package in.targetpeak.api.entity.lms.syllabus.chapter;

public class ChapterRequest {

	Integer AttendantId;
	Integer AttendantRoleId;
	Integer Action;

	Integer SyllabusChapterId;
	Integer SubjectId;
	String ChapterName;
	String ChapterNameInMarathi;
	Integer RecordStatus;

	public ChapterRequest() {
		super();
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

	public Integer getSyllabusChapterId() {
		return SyllabusChapterId;
	}

	public void setSyllabusChapterId(Integer syllabusChapterId) {
		SyllabusChapterId = syllabusChapterId;
	}

	public Integer getSubjectId() {
		return SubjectId;
	}

	public void setSubjectId(Integer subjectId) {
		SubjectId = subjectId;
	}

	public String getChapterName() {
		return ChapterName;
	}

	public void setChapterName(String chapterName) {
		ChapterName = chapterName;
	}

	public String getChapterNameInMarathi() {
		return ChapterNameInMarathi;
	}

	public void setChapterNameInMarathi(String chapterNameInMarathi) {
		ChapterNameInMarathi = chapterNameInMarathi;
	}

	public Integer getRecordStatus() {
		return RecordStatus;
	}

	public void setRecordStatus(Integer recordStatus) {
		RecordStatus = recordStatus;
	}

}
