package in.targetpeak.api.entity.noticeboard;

public class NoticeBoardOtherUserRequest {

	int userId;
	int organizationId;
	String organizationName;
	int instituteId;
	String instituteName;
	int classId;
	String className;
	int divisionId;
	String divisionName;

	public NoticeBoardOtherUserRequest() {
		super();
	}

	public NoticeBoardOtherUserRequest(int userId, int organizationId, String organizationName, int instituteId,
			String instituteName, int classId, String className, int divisionId, String divisionName) {
		super();
		this.userId = userId;
		this.organizationId = organizationId;
		this.organizationName = organizationName;
		this.instituteId = instituteId;
		this.instituteName = instituteName;
		this.classId = classId;
		this.className = className;
		this.divisionId = divisionId;
		this.divisionName = divisionName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

}
