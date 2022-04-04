package in.targetpeak.api.entity.master.subject;

public class SubjectListRequest {

	Integer AttendantId;
	Integer AttendantRoleId;
	String Language;
	Integer Action;

	Integer SubjectId;
	Integer ClassId;

	Integer RecordStatus;
	Integer Offset;
	Integer Limit;
	String Search;
	String SyncDate;

	public SubjectListRequest() {
		super();
	}

	public SubjectListRequest(Integer attendantId, Integer attendantRoleId, String Language, Integer action,
			Integer subjectId, Integer classId, Integer recordStatus, Integer offset, Integer limit, String search,
			String syncDate) {
		super();
		AttendantId = attendantId;
		AttendantRoleId = attendantRoleId;
		this.Language = Language;
		Action = action;
		SubjectId = subjectId;
		ClassId = classId;
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

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public Integer getAction() {
		return Action;
	}

	public void setAction(Integer action) {
		Action = action;
	}

	public Integer getSubjectId() {
		return SubjectId;
	}

	public void setSubjectId(Integer subjectId) {
		SubjectId = subjectId;
	}

	public Integer getClassId() {
		return ClassId;
	}

	public void setClassId(Integer classId) {
		ClassId = classId;
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

	@Override
	public String toString() {
		return "SubjectListRequest [AttendantId=" + AttendantId + ", AttendantRoleId=" + AttendantRoleId + ", Language="
				+ Language + ", Action=" + Action + ", SubjectId=" + SubjectId + ", ClassId=" + ClassId
				+ ", RecordStatus=" + RecordStatus + ", Offset=" + Offset + ", Limit=" + Limit + ", Search=" + Search
				+ ", SyncDate=" + SyncDate + "]";
	}

}
