package in.targetpeak.api.entity.result;

public class ExamResultRequest {

	Integer AttendantId;
	Integer AttendantRoleId;
	Integer Action;

	Integer ResultId;
	Integer QuestionPaperId;
	Integer StudentId;

	Integer RecordStatus;
	Integer Offset;
	Integer Limit;
	String Search;
	String SyncDate;

	public ExamResultRequest() {
		super();
	}
	
	

	public ExamResultRequest(Integer attendantId, Integer attendantRoleId, Integer action, Integer resultId,
			Integer questionPaperId, Integer studentId, Integer recordStatus, Integer offset, Integer limit,
			String search, String syncDate) {
		super();
		AttendantId = attendantId;
		AttendantRoleId = attendantRoleId;
		Action = action;
		ResultId = resultId;
		QuestionPaperId = questionPaperId;
		StudentId = studentId;
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

	public Integer getResultId() {
		return ResultId;
	}

	public void setResultId(Integer resultId) {
		ResultId = resultId;
	}

	public Integer getQuestionPaperId() {
		return QuestionPaperId;
	}

	public void setQuestionPaperId(Integer questionPaperId) {
		QuestionPaperId = questionPaperId;
	}

	public Integer getStudentId() {
		return StudentId;
	}

	public void setStudentId(Integer studentId) {
		StudentId = studentId;
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

}
