package in.targetpeak.api.entity.user;

public class UserUpdateRequest {

	Integer AttendantId;
	Integer AttendantRoleId;
	Integer Action;
	Integer RoleId;

	Integer UserId;
	String FullName;
	String DOB;
	Integer Gender;
	String MobileNo;
	Integer PhoneVerified;
	String Email;
	Integer EmailVerified;
	String Username;
	String UserPassword;

	Integer OrganizationId;
	Integer InstituteId;
	Integer ClassId;
	Integer DivisionId;
	Integer RecordStatus;

	String Platform;
	String UpdatedThings;

	public UserUpdateRequest() {
		super();
	}

	public UserUpdateRequest(Integer attendantId, Integer attendantRoleId, Integer action, Integer roleId,
			Integer userId, String fullName, String dOB, Integer gender, String mobileNo, Integer phoneVerified,
			String email, Integer emailVerified, String username, String userPassword, Integer organizationId,
			Integer instituteId, Integer classId, Integer divisionId, Integer recordStatus, String platform,
			String updatedThings) {
		super();
		AttendantId = attendantId;
		AttendantRoleId = attendantRoleId;
		Action = action;
		RoleId = roleId;
		UserId = userId;
		FullName = fullName;
		DOB = dOB;
		Gender = gender;
		MobileNo = mobileNo;
		PhoneVerified = phoneVerified;
		Email = email;
		EmailVerified = emailVerified;
		Username = username;
		UserPassword = userPassword;
		OrganizationId = organizationId;
		InstituteId = instituteId;
		ClassId = classId;
		DivisionId = divisionId;
		RecordStatus = recordStatus;
		Platform = platform;
		UpdatedThings = updatedThings;
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

	public Integer getRoleId() {
		return RoleId;
	}

	public void setRoleId(Integer roleId) {
		RoleId = roleId;
	}

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
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

	public String getMobileNo() {
		return MobileNo;
	}

	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}

	public Integer getPhoneVerified() {
		return PhoneVerified;
	}

	public void setPhoneVerified(Integer phoneVerified) {
		PhoneVerified = phoneVerified;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Integer getEmailVerified() {
		return EmailVerified;
	}

	public void setEmailVerified(Integer emailVerified) {
		EmailVerified = emailVerified;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
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

	public String getPlatform() {
		return Platform;
	}

	public void setPlatform(String platform) {
		Platform = platform;
	}

	public String getUpdatedThings() {
		return UpdatedThings;
	}

	public void setUpdatedThings(String updatedThings) {
		UpdatedThings = updatedThings;
	}

}
