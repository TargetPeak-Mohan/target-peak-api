package in.targetpeak.api.entity.result.peak;

public class PeakExamStudentRequest {

	int studentId;
	int organizationId;
	String organizationName;
	int instituteId;
	String instituteName;
	int classId;
	String className;
	int divisionId;
	String divisionName;
	int examinationId;

	public PeakExamStudentRequest() {
		super();
	}

	public PeakExamStudentRequest(int studentId, int organizationId, String organizationName, int instituteId,
			String instituteName, int classId, String className, int divisionId, String divisionName,
			int examinationId) {
		super();
		this.studentId = studentId;
		this.organizationId = organizationId;
		this.organizationName = organizationName;
		this.instituteId = instituteId;
		this.instituteName = instituteName;
		this.classId = classId;
		this.className = className;
		this.divisionId = divisionId;
		this.divisionName = divisionName;
		this.examinationId = examinationId;
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

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public int getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(int divisionId) {
		this.divisionId = divisionId;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public int getExaminationId() {
		return examinationId;
	}

	public void setExaminationId(int examinationId) {
		this.examinationId = examinationId;
	}

}
