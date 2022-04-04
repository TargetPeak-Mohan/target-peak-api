package in.targetpeak.api.entity.admin.users;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TempUserHolder {

	@Id
	Integer UserId;
	String FullName;
	String Avatar;
	String DOB;
	Integer Gender;
	String MobileNo;
	Integer PhoneVerified;
	String Email;
	Integer EmailVerified;
	String Country;
	String Username;
	String UserPassword;
	Double BalanceAmount;
	Integer ReferredBy;
	String ReferralCode;
	Integer RoleId;
	Integer OrganizationId;
	Integer InstituteId;
	Integer ClassId;
	Integer DivisionId;
	String OrganizationName;
	String InstituteName;
	String ClassName;
	String DivisionName;
	Integer JioMeetUserId;
	Integer RecordStatus;
	String AddedBy;
	String ModifiedBy;
	String Created;
	String Modified;
	Integer StduentCount;
	Integer LoggedInCount;

	public TempUserHolder() {
		super();
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

	public String getAvatar() {
		return Avatar;
	}

	public void setAvatar(String avatar) {
		Avatar = avatar;
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

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
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

	public Double getBalanceAmount() {
		return BalanceAmount;
	}

	public void setBalanceAmount(Double balanceAmount) {
		BalanceAmount = balanceAmount;
	}

	public Integer getReferredBy() {
		return ReferredBy;
	}

	public void setReferredBy(Integer referredBy) {
		ReferredBy = referredBy;
	}

	public String getReferralCode() {
		return ReferralCode;
	}

	public void setReferralCode(String referralCode) {
		ReferralCode = referralCode;
	}

	public Integer getRoleId() {
		return RoleId;
	}

	public void setRoleId(Integer roleId) {
		RoleId = roleId;
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

	public String getOrganizationName() {
		return OrganizationName;
	}

	public void setOrganizationName(String organizationName) {
		OrganizationName = organizationName;
	}

	public String getInstituteName() {
		return InstituteName;
	}

	public void setInstituteName(String instituteName) {
		InstituteName = instituteName;
	}

	public String getClassName() {
		return ClassName;
	}

	public void setClassName(String className) {
		ClassName = className;
	}

	public String getDivisionName() {
		return DivisionName;
	}

	public void setDivisionName(String divisionName) {
		DivisionName = divisionName;
	}

	public Integer getJioMeetUserId() {
		return JioMeetUserId;
	}

	public void setJioMeetUserId(Integer jioMeetUserId) {
		JioMeetUserId = jioMeetUserId;
	}

	public Integer getRecordStatus() {
		return RecordStatus;
	}

	public void setRecordStatus(Integer recordStatus) {
		RecordStatus = recordStatus;
	}

	public String getAddedBy() {
		return AddedBy;
	}

	public void setAddedBy(String addedBy) {
		AddedBy = addedBy;
	}

	public String getModifiedBy() {
		return ModifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		ModifiedBy = modifiedBy;
	}

	public String getCreated() {
		return Created;
	}

	public void setCreated(String created) {
		Created = created;
	}

	public String getModified() {
		return Modified;
	}

	public void setModified(String modified) {
		Modified = modified;
	}

	public Integer getStduentCount() {
		return StduentCount;
	}

	public void setStduentCount(Integer stduentCount) {
		StduentCount = stduentCount;
	}
	
	

	public Integer getLoggedInCount() {
		return LoggedInCount;
	}

	public void setLoggedInCount(Integer loggedInCount) {
		LoggedInCount = loggedInCount;
	}

	@Override
	public String toString() {
		return "TempUserHolder [UserId=" + UserId + ", FullName=" + FullName + ", Avatar=" + Avatar + ", DOB=" + DOB
				+ ", Gender=" + Gender + ", MobileNo=" + MobileNo + ", PhoneVerified=" + PhoneVerified + ", Email="
				+ Email + ", EmailVerified=" + EmailVerified + ", Country=" + Country + ", Username=" + Username
				+ ", UserPassword=" + UserPassword + ", BalanceAmount=" + BalanceAmount + ", ReferredBy=" + ReferredBy
				+ ", ReferralCode=" + ReferralCode + ", RoleId=" + RoleId + ", OrganizationId=" + OrganizationId
				+ ", InstituteId=" + InstituteId + ", ClassId=" + ClassId + ", DivisionId=" + DivisionId
				+ ", OrganizationName=" + OrganizationName + ", InstituteName=" + InstituteName + ", ClassName="
				+ ClassName + ", DivisionName=" + DivisionName + ", JioMeetUserId=" + JioMeetUserId + ", RecordStatus="
				+ RecordStatus + ", AddedBy=" + AddedBy + ", ModifiedBy=" + ModifiedBy + ", Created=" + Created
				+ ", Modified=" + Modified + ", StduentCount=" + StduentCount + ", LoggedInCount=" + LoggedInCount
				+ "]";
	}

	

}
