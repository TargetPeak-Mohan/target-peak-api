package in.targetpeak.api.entity.exam.peak;

public class PeakExamStatusRequest {

	int userId;
	int studentId;
	int organizationId;
	int instituteId;
	int classId;
	int divisionId;
	int questionPaperId;

	public PeakExamStatusRequest() {
		super();
	}

	public int getQuestionPaperId() {
		return questionPaperId;
	}

	public void setQuestionPaperId(int questionPaperId) {
		this.questionPaperId = questionPaperId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	public int getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(int divisionId) {
		this.divisionId = divisionId;
	}

	@Override
	public String toString() {
		return "PeakExamStatusRequest [userId=" + userId + ", studentId=" + studentId + ", organizationId="
				+ organizationId + ", instituteId=" + instituteId + ", classId=" + classId + ", divisionId="
				+ divisionId + ", questionPaperId=" + questionPaperId + "]";
	}

}
