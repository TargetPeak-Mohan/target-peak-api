package in.targetpeak.api.entity.result.regular.ui;

import java.util.List;

import in.targetpeak.api.entity.result.regular.RegularExamResultStudentHolder;

public class StudentSubjectWiseRegularResultJson {

	String organizationName;
	String instituteName;
	String className;
	String divisionName;
	List<RegularExamResultStudentHolder> regularExamResultStudentHolders;

	public StudentSubjectWiseRegularResultJson() {
		super();
	}

	public StudentSubjectWiseRegularResultJson(String organizationName, String instituteName, String className,
			String divisionName, List<RegularExamResultStudentHolder> regularExamResultStudentHolders) {
		super();
		this.organizationName = organizationName;
		this.instituteName = instituteName;
		this.className = className;
		this.divisionName = divisionName;
		this.regularExamResultStudentHolders = regularExamResultStudentHolders;
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

	public List<RegularExamResultStudentHolder> getRegularExamResultStudentHolders() {
		return regularExamResultStudentHolders;
	}

	public void setRegularExamResultStudentHolders(
			List<RegularExamResultStudentHolder> regularExamResultStudentHolders) {
		this.regularExamResultStudentHolders = regularExamResultStudentHolders;
	}

	@Override
	public String toString() {
		return "StudentSubjectWiseRegularResultJson [organizationName=" + organizationName + ", instituteName="
				+ instituteName + ", className=" + className + ", divisionName=" + divisionName
				+ ", regularExamResultStudentHolders=" + regularExamResultStudentHolders + "]";
	}

}
