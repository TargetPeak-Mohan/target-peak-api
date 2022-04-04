package in.targetpeak.api.entity.lms.syllabus.chapter;

public class ChapterListRequest {

	Integer AttendantId;
	Integer AttendantRoleId;
	Integer Action;

	Integer ClassId;
	Integer EducationBoardId;
	Integer SyllabusChapterId;
	Integer SubjectId;

	Integer RecordStatus;
	Integer Offset;
	Integer Limit;
	String Search;
	String SyncDate;

	public ChapterListRequest() {
		super();
	}

	public ChapterListRequest(Integer attendantId, Integer attendantRoleId, Integer action, Integer classId,
			Integer educationBoardId, Integer syllabusChapterId, Integer subjectId, Integer recordStatus,
			Integer offset, Integer limit, String search, String syncDate) {
		super();
		AttendantId = attendantId;
		AttendantRoleId = attendantRoleId;
		Action = action;
		ClassId = classId;
		EducationBoardId = educationBoardId;
		SyllabusChapterId = syllabusChapterId;
		SubjectId = subjectId;
		RecordStatus = recordStatus;
		Offset = offset;
		Limit = limit;
		Search = search;
		SyncDate = syncDate;
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

	public Integer getClassId() {
		return ClassId;
	}

	public void setClassId(Integer classId) {
		ClassId = classId;
	}

	public Integer getEducationBoardId() {
		return EducationBoardId;
	}

	public void setEducationBoardId(Integer educationBoardId) {
		EducationBoardId = educationBoardId;
	}

	public Integer getSyllabusChapterId() {
		return SyllabusChapterId;
	}

	public void setSyllabusChapterId(Integer syllabusChapterId) {
		SyllabusChapterId = syllabusChapterId;
	}

	public Integer getRecordStatus() {
		return RecordStatus;
	}

	public void setRecordStatus(Integer recordStatus) {
		RecordStatus = recordStatus;
	}

	public Integer getOffset() {
		return Offset;
	}

	public void setOffset(Integer offset) {
		Offset = offset;
	}

	public Integer getLimit() {
		return Limit;
	}

	public void setLimit(Integer limit) {
		Limit = limit;
	}

	public String getSearch() {
		return Search;
	}

	public void setSearch(String search) {
		Search = search;
	}

	public String getSyncDate() {
		return SyncDate;
	}

	public void setSyncDate(String syncDate) {
		SyncDate = syncDate;
	}

	public Integer getSubjectId() {
		return SubjectId;
	}

	public void setSubjectId(Integer subjectId) {
		SubjectId = subjectId;
	}

	@Override
	public String toString() {
		return "ChapterListRequest [AttendantId=" + AttendantId + ", AttendantRoleId=" + AttendantRoleId + ", Action="
				+ Action + ", ClassId=" + ClassId + ", EducationBoardId=" + EducationBoardId + ", SyllabusChapterId="
				+ SyllabusChapterId + ", SubjectId=" + SubjectId + ", RecordStatus=" + RecordStatus + ", Offset="
				+ Offset + ", Limit=" + Limit + ", Search=" + Search + ", SyncDate=" + SyncDate + "]";
	}
	
	

}
