package in.targetpeak.api.entity.user;

public class UserListRequest {

	Integer AttendantId;
	Integer AttendantRoleId;
	Integer Action;

	Integer UserId;
	String DOB;
	Integer Gender;
	Integer PhoneVerified;
	Integer EmailVerified;
	Integer DeviceLogId;
	Integer OrganizationId;
	Integer InstituteId;
	Integer ClassId;
	Integer DivisionId;

	Integer RoleId;
	Integer RecordStatus;
	Integer Offset;
	Integer Limit;
	String Search;
	String SyncDate;

	public UserListRequest() {
		super();
	}

	public UserListRequest(Integer attendantId, Integer attendantRoleId, Integer action, Integer userId, String dOB,
			Integer gender, Integer PhoneVerified, Integer EmailVerified, Integer deviceLogId, Integer organizationId,
			Integer instituteId, Integer classId, Integer divisionId, Integer roleId, Integer recordStatus,
			Integer offset, Integer limit, String search, String syncDate) {
		super();
		AttendantId = attendantId;
		AttendantRoleId = attendantRoleId;
		Action = action;
		UserId = userId;
		DOB = dOB;
		Gender = gender;
		this.PhoneVerified = PhoneVerified;
		this.EmailVerified = EmailVerified;
		DeviceLogId = deviceLogId;
		OrganizationId = organizationId;
		InstituteId = instituteId;
		ClassId = classId;
		DivisionId = divisionId;
		RoleId = roleId;
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

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
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

	public Integer getPhoneVerified() {
		return PhoneVerified;
	}

	public void setPhoneVerified(Integer phoneVerified) {
		PhoneVerified = phoneVerified;
	}

	public Integer getEmailVerified() {
		return EmailVerified;
	}

	public void setEmailVerified(Integer emailVerified) {
		EmailVerified = emailVerified;
	}

	public Integer getDeviceLogId() {
		return DeviceLogId;
	}

	public void setDeviceLogId(Integer deviceLogId) {
		DeviceLogId = deviceLogId;
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

	public Integer getRoleId() {
		return RoleId;
	}

	public void setRoleId(Integer roleId) {
		RoleId = roleId;
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
		return "UserListRequest [AttendantId=" + AttendantId + ", AttendantRoleId=" + AttendantRoleId + ", Action="
				+ Action + ", UserId=" + UserId + ", DOB=" + DOB + ", Gender=" + Gender + ", PhoneVerified="
				+ PhoneVerified + ", EmailVerified=" + EmailVerified + ", DeviceLogId=" + DeviceLogId
				+ ", OrganizationId=" + OrganizationId + ", InstituteId=" + InstituteId + ", ClassId=" + ClassId
				+ ", DivisionId=" + DivisionId + ", RoleId=" + RoleId + ", RecordStatus=" + RecordStatus + ", Offset="
				+ Offset + ", Limit=" + Limit + ", Search=" + Search + ", SyncDate=" + SyncDate + "]";
	}

}
