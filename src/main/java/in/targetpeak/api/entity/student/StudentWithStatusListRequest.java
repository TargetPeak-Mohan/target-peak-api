package in.targetpeak.api.entity.student;

public class StudentWithStatusListRequest {

	Integer AttendantId;
	Integer AttendantRoleId;
	Integer Action;

	Integer StudentId;
	Integer UserId;
	Integer InstituteId;
	Integer OrganizationId;
	Integer ClassId;
	Integer DivisionId;
	String DOB;
	Integer Gender;

	Integer RecordStatus;
	Integer Offset;
	Integer Limit;
	String Search;
	String SyncDate;

	public StudentWithStatusListRequest() {
	}

	public StudentWithStatusListRequest(int attendantId, int attendantRoleId, int action, int studentId, int userId,
			int instituteId, int organizationId, int classId, int divisionId, String dOB, int gender, int recordStatus,
			int offset, int limit, String search, String syncDate) {
		super();
		AttendantId = attendantId;
		AttendantRoleId = attendantRoleId;
		Action = action;
		StudentId = studentId;
		UserId = userId;
		InstituteId = instituteId;
		OrganizationId = organizationId;
		ClassId = classId;
		DivisionId = divisionId;
		DOB = dOB;
		Gender = gender;
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

	public Integer getStudentId() {
		return StudentId;
	}

	public void setStudentId(Integer studentId) {
		StudentId = studentId;
	}

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}

	public Integer getInstituteId() {
		return InstituteId;
	}

	public void setInstituteId(Integer instituteId) {
		InstituteId = instituteId;
	}

	public Integer getOrganizationId() {
		return OrganizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		OrganizationId = organizationId;
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

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public Integer getGender() {
		return Gender;
	}

	public void setGender(Integer gender) {
		Gender = gender;
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
		return "StudentWithStatusListRequest [AttendantId=" + AttendantId + ", AttendantRoleId=" + AttendantRoleId
				+ ", Action=" + Action + ", StudentId=" + StudentId + ", UserId=" + UserId + ", InstituteId="
				+ InstituteId + ", OrganizationId=" + OrganizationId + ", ClassId=" + ClassId + ", DivisionId="
				+ DivisionId + ", DOB=" + DOB + ", Gender=" + Gender + ", RecordStatus=" + RecordStatus + ", Offset="
				+ Offset + ", Limit=" + Limit + ", Search=" + Search + ", SyncDate=" + SyncDate + "]";
	}

}
