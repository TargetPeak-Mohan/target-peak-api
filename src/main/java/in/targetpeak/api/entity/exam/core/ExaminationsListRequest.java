package in.targetpeak.api.entity.exam.core;

public class ExaminationsListRequest {

	Integer AttendantId;
	Integer AttendantRoleId;
	Integer Action;
	Integer ExaminationId;
	Integer ExaminationBoardId;
	Integer OrganizationId;
	Integer InstituteId;
	Integer ClassId;
	String StartDate;
	String EndDate;
	Integer RecordStatus;
	Integer Offset;
	Integer Limit;
	String Search;
	String SyncDate;

	public ExaminationsListRequest() {
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

	public Integer getExaminationId() {
		return ExaminationId;
	}

	public void setExaminationId(Integer examinationId) {
		ExaminationId = examinationId;
	}

	public Integer getExaminationBoardId() {
		return ExaminationBoardId;
	}

	public void setExaminationBoardId(Integer examinationBoardId) {
		ExaminationBoardId = examinationBoardId;
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

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
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
		return "ExaminationsListRequest [AttendantId=" + AttendantId + ", AttendantRoleId=" + AttendantRoleId
				+ ", Action=" + Action + ", ExaminationId=" + ExaminationId + ", ExaminationBoardId="
				+ ExaminationBoardId + ", OrganizationId=" + OrganizationId + ", InstituteId=" + InstituteId
				+ ", ClassId=" + ClassId + ", StartDate=" + StartDate + ", EndDate=" + EndDate + ", RecordStatus="
				+ RecordStatus + ", Offset=" + Offset + ", Limit=" + Limit + ", Search=" + Search + ", SyncDate="
				+ SyncDate + "]";
	}

}
