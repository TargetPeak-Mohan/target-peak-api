package in.targetpeak.api.entity.result.peak.ui;

import java.util.List;

import in.targetpeak.api.entity.result.peak.PeakExamResultStudentHolder;

public class StudentSubjectWisePeakResultJson {

	String organizationName;
	String instituteName;
	String className;
	String divisionName;
	List<PeakExamResultStudentHolder> peakExamResultStudentHolders;

	public StudentSubjectWisePeakResultJson() {
		super();
	}

	public StudentSubjectWisePeakResultJson(String organizationName, String instituteName, String className,
			String divisionName, List<PeakExamResultStudentHolder> peakExamResultStudentHolders) {
		super();
		this.organizationName = organizationName;
		this.instituteName = instituteName;
		this.className = className;
		this.divisionName = divisionName;
		this.peakExamResultStudentHolders = peakExamResultStudentHolders;
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

	public List<PeakExamResultStudentHolder> getPeakExamResultStudentHolders() {
		return peakExamResultStudentHolders;
	}

	public void setPeakExamResultStudentHolders(List<PeakExamResultStudentHolder> peakExamResultStudentHolders) {
		this.peakExamResultStudentHolders = peakExamResultStudentHolders;
	}

	@Override
	public String toString() {
		return "StudentSubjectWisePeakResultJson [organizationName=" + organizationName + ", instituteName="
				+ instituteName + ", className=" + className + ", divisionName=" + divisionName
				+ ", peakExamResultStudentHolders=" + peakExamResultStudentHolders + "]";
	}

}
