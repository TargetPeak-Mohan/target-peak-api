package in.targetpeak.api.entity.admin.students;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TempStudentHolder {

	@Id
	Integer StudentId;
	Integer UserId;
	String StudentName;
	Integer InstituteId;
	String InstituteName;
	Integer OrganizationId;
	String OrganizationName;
	Integer ClassId;
	String ClassName;
	Integer Gender;
	String RollNo;
	String AadharNo;
	String Avatar;
	String DOB;
	String Caste;
	String FathersName;
	String MothersName;
	String FatherPhone;
	String MotherPhone;
	String DivisionName;
	Integer DivisionId;
	String MobileNo;
	String Email;
	Integer RecordStatus;
	Integer LoggedInCount;

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

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public Integer getInstituteId() {
		return InstituteId;
	}

	public void setInstituteId(Integer instituteId) {
		InstituteId = instituteId;
	}

	public String getInstituteName() {
		return InstituteName;
	}

	public void setInstituteName(String instituteName) {
		InstituteName = instituteName;
	}

	public Integer getOrganizationId() {
		return OrganizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		OrganizationId = organizationId;
	}

	public String getOrganizationName() {
		return OrganizationName;
	}

	public void setOrganizationName(String organizationName) {
		OrganizationName = organizationName;
	}

	public Integer getClassId() {
		return ClassId;
	}

	public void setClassId(Integer classId) {
		ClassId = classId;
	}

	public String getClassName() {
		return ClassName;
	}

	public void setClassName(String className) {
		ClassName = className;
	}

	public Integer getGender() {
		return Gender;
	}

	public void setGender(Integer gender) {
		Gender = gender;
	}

	public String getRollNo() {
		return RollNo;
	}

	public void setRollNo(String rollNo) {
		RollNo = rollNo;
	}

	public String getAadharNo() {
		return AadharNo;
	}

	public void setAadharNo(String aadharNo) {
		AadharNo = aadharNo;
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

	public String getCaste() {
		return Caste;
	}

	public void setCaste(String caste) {
		Caste = caste;
	}

	public String getFathersName() {
		return FathersName;
	}

	public void setFathersName(String fathersName) {
		FathersName = fathersName;
	}

	public String getMothersName() {
		return MothersName;
	}

	public void setMothersName(String mothersName) {
		MothersName = mothersName;
	}

	public String getFatherPhone() {
		return FatherPhone;
	}

	public void setFatherPhone(String fatherPhone) {
		FatherPhone = fatherPhone;
	}

	public String getMotherPhone() {
		return MotherPhone;
	}

	public void setMotherPhone(String motherPhone) {
		MotherPhone = motherPhone;
	}

	public String getDivisionName() {
		return DivisionName;
	}

	public void setDivisionName(String divisionName) {
		DivisionName = divisionName;
	}

	public Integer getDivisionId() {
		return DivisionId;
	}

	public void setDivisionId(Integer divisionId) {
		DivisionId = divisionId;
	}

	public String getMobileNo() {
		return MobileNo;
	}

	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Integer getRecordStatus() {
		return RecordStatus;
	}

	public void setRecordStatus(Integer recordStatus) {
		RecordStatus = recordStatus;
	}

	public Integer getLoggedInCount() {
		return LoggedInCount;
	}

	public void setLoggedInCount(Integer loggedInCount) {
		LoggedInCount = loggedInCount;
	}

	@Override
	public String toString() {
		return "TempStudentHolder [StudentId=" + StudentId + ", UserId=" + UserId + ", StudentName=" + StudentName
				+ ", InstituteId=" + InstituteId + ", InstituteName=" + InstituteName + ", OrganizationId="
				+ OrganizationId + ", OrganizationName=" + OrganizationName + ", ClassId=" + ClassId + ", ClassName="
				+ ClassName + ", Gender=" + Gender + ", RollNo=" + RollNo + ", AadharNo=" + AadharNo + ", Avatar="
				+ Avatar + ", DOB=" + DOB + ", Caste=" + Caste + ", FathersName=" + FathersName + ", MothersName="
				+ MothersName + ", FatherPhone=" + FatherPhone + ", MotherPhone=" + MotherPhone + ", DivisionName="
				+ DivisionName + ", DivisionId=" + DivisionId + ", MobileNo=" + MobileNo + ", Email=" + Email
				+ ", RecordStatus=" + RecordStatus + ", LoggedInCount=" + LoggedInCount + "]";
	}

}
