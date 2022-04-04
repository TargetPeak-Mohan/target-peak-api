package in.targetpeak.api.entity.result.regular.ui;

import java.util.List;

public class StudentRegularResultJson {

	String organizationName;
	String instituteName;
	String className;
	String divisionName;
	List<StudentRegularResultDetail> studentRegularResultDetails;

	public StudentRegularResultJson() {
		super();
	}

	public StudentRegularResultJson(String organizationName, String instituteName, String className,
			String divisionName, List<StudentRegularResultDetail> studentRegularResultDetails) {
		super();
		this.organizationName = organizationName;
		this.instituteName = instituteName;
		this.className = className;
		this.divisionName = divisionName;
		this.studentRegularResultDetails = studentRegularResultDetails;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public List<StudentRegularResultDetail> getStudentRegularResultDetails() {
		return studentRegularResultDetails;
	}

	public void setStudentRegularResultDetail(List<StudentRegularResultDetail> studentRegularResultDetails) {
		this.studentRegularResultDetails = studentRegularResultDetails;
	}

	@Override
	public String toString() {
		return "StudentRegularResultJson [organizationName=" + organizationName + ", instituteName=" + instituteName
				+ ", className=" + className + ", divisionName=" + divisionName + ", studentRegularResultDetails="
				+ studentRegularResultDetails + "]";
	}

}
