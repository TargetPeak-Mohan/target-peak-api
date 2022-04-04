package in.targetpeak.api.entity.exam.peak;

public class PeakExamResultStatusRequest {

	Integer Action;

	Integer OrganizationId;
	Integer InstituteId;
	Integer ClassId;
	Integer DivisionId;
	Integer QuestionPaperId;

	Integer RecordStatus;
	Integer Offset;
	Integer Limit;
	String Search;
	String SyncDate;

	public PeakExamResultStatusRequest(Integer action, Integer organizationId, Integer instituteId, Integer classId,
			Integer divisionId, Integer questionPaperId, Integer recordStatus, Integer offset, Integer limit,
			String search, String syncDate) {
		super();
		Action = action;
		OrganizationId = organizationId;
		InstituteId = instituteId;
		ClassId = classId;
		DivisionId = divisionId;
		QuestionPaperId = questionPaperId;
		RecordStatus = recordStatus;
		Offset = offset;
		Limit = limit;
		Search = search;
		SyncDate = syncDate;
	}

	public Integer getAction() {
		return Action;
	}

	public void setAction(Integer action) {
		Action = action;
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

	public Integer getQuestionPaperId() {
		return QuestionPaperId;
	}

	public void setQuestionPaperId(Integer questionPaperId) {
		QuestionPaperId = questionPaperId;
	}

	@Override
	public String toString() {
		return "PeakExamResultStatusRequest [Action=" + Action + ", OrganizationId=" + OrganizationId + ", InstituteId="
				+ InstituteId + ", ClassId=" + ClassId + ", DivisionId=" + DivisionId + ", QuestionPaperId="
				+ QuestionPaperId + ", RecordStatus=" + RecordStatus + ", Offset=" + Offset + ", Limit=" + Limit
				+ ", Search=" + Search + ", SyncDate=" + SyncDate + "]";
	}

}
