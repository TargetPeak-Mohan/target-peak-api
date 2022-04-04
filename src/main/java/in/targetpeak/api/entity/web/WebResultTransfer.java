package in.targetpeak.api.entity.web;

public class WebResultTransfer {

	Integer organizationId;
	Integer instituteId;
	Integer classId;
	Integer subjectId;
	Integer userId;
	Integer studentId;
	Integer questionPaperId;
	Integer roleId;

	public WebResultTransfer(Integer organizationId, Integer instituteId, Integer classId, Integer subjectId,
			Integer userId, Integer studentId, Integer questionPaperId, Integer roleId) {
		super();
		this.organizationId = organizationId;
		this.instituteId = instituteId;
		this.classId = classId;
		this.subjectId = subjectId;
		this.userId = userId;
		this.studentId = studentId;
		this.questionPaperId = questionPaperId;
		this.roleId = roleId;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(Integer instituteId) {
		this.instituteId = instituteId;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getQuestionPaperId() {
		return questionPaperId;
	}

	public void setQuestionPaperId(Integer questionPaperId) {
		this.questionPaperId = questionPaperId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}
