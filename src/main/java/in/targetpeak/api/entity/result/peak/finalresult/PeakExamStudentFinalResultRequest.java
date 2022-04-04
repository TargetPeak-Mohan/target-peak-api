package in.targetpeak.api.entity.result.peak.finalresult;

public class PeakExamStudentFinalResultRequest {

	Integer AttendantId;
	Integer AttendantRoleId;
	Integer Action;
	Integer ExaminationId;
	Integer SubjectId;
	Integer StudentId;
	Integer OrganizationId;
	Integer InstituteId;
	Integer ClassId;
	Integer DivisionId;
	Integer RecordStatus;
	Integer Offset;
	Integer Limit;
	String Search;
	String SyncDate;

	public PeakExamStudentFinalResultRequest() {
		super();
	}

	public PeakExamStudentFinalResultRequest(Integer attendantId, Integer attendantRoleId, Integer action,
			Integer examinationId, Integer subjectId, Integer studentId, Integer organizationId, Integer instituteId,
			Integer classId, Integer divisionId, Integer recordStatus, Integer offset, Integer limit, String search,
			String syncDate) {
		super();
		AttendantId = attendantId;
		AttendantRoleId = attendantRoleId;
		Action = action;
		ExaminationId = examinationId;
		SubjectId = subjectId;
		StudentId = studentId;
		OrganizationId = organizationId;
		InstituteId = instituteId;
		ClassId = classId;
		DivisionId = divisionId;
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

	public Integer getExaminationId() {
		return ExaminationId;
	}

	public void setExaminationId(Integer examinationId) {
		ExaminationId = examinationId;
	}

	public Integer getSubjectId() {
		return SubjectId;
	}

	public void setSubjectId(Integer subjectId) {
		SubjectId = subjectId;
	}

	public Integer getStudentId() {
		return StudentId;
	}

	public void setStudentId(Integer studentId) {
		StudentId = studentId;
	}

	public Integer getOrganizationId() {
		return OrganizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		OrganizationId = organizationId;
	}

	public Integer getInstituteId() {
		return InstituteId;
	}

	public void setInstituteId(Integer instituteId) {
		InstituteId = instituteId;
	}

	public Integer getClassId() {
		return ClassId;
	}

	public void setClassId(Integer classId) {
		ClassId = classId;
	}

	public Integer getDivisionId() {
		return DivisionId;
	}

	public void setDivisionId(Integer divisionId) {
		DivisionId = divisionId;
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
		return "PeakExamStudentFinalResultRequest [AttendantId=" + AttendantId + ", AttendantRoleId=" + AttendantRoleId
				+ ", Action=" + Action + ", ExaminationId=" + ExaminationId + ", SubjectId=" + SubjectId
				+ ", StudentId=" + StudentId + ", OrganizationId=" + OrganizationId + ", InstituteId=" + InstituteId
				+ ", ClassId=" + ClassId + ", DivisionId=" + DivisionId + ", RecordStatus=" + RecordStatus + ", Offset="
				+ Offset + ", Limit=" + Limit + ", Search=" + Search + ", SyncDate=" + SyncDate + "]";
	}

}
