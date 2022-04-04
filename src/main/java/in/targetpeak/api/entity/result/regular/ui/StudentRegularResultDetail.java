package in.targetpeak.api.entity.result.regular.ui;

import java.util.List;

public class StudentRegularResultDetail {

	String RollNo;
	String StudentName;
	String motherName;
	String gender;
	List<StudentPaperResultDetail> studentPaperResultDetails;
	Integer MaximumMarks;
	Integer ObtainedMarks;
	String Percentage;
	String Result;

	public StudentRegularResultDetail() {
		super();
	}

	public StudentRegularResultDetail(String rollNo, String studentName, String motherName, String gender,
			List<StudentPaperResultDetail> studentPaperResultDetails, Integer maximumMarks, Integer obtainedMarks,
			String percentage, String result) {
		super();
		RollNo = rollNo;
		StudentName = studentName;
		this.motherName = motherName;
		this.gender = gender;
		this.studentPaperResultDetails = studentPaperResultDetails;
		MaximumMarks = maximumMarks;
		ObtainedMarks = obtainedMarks;
		Percentage = percentage;
		Result = result;
	}

	public String getRollNo() {
		return RollNo;
	}

	public void setRollNo(String rollNo) {
		RollNo = rollNo;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<StudentPaperResultDetail> getStudentPaperResultDetails() {
		return studentPaperResultDetails;
	}

	public void setStudentPaperResultDetails(List<StudentPaperResultDetail> studentPaperResultDetails) {
		this.studentPaperResultDetails = studentPaperResultDetails;
	}

	public Integer getMaximumMarks() {
		return MaximumMarks;
	}

	public void setMaximumMarks(Integer maximumMarks) {
		MaximumMarks = maximumMarks;
	}

	public Integer getObtainedMarks() {
		return ObtainedMarks;
	}

	public void setObtainedMarks(Integer obtainedMarks) {
		ObtainedMarks = obtainedMarks;
	}

	public String getPercentage() {
		return Percentage;
	}

	public void setPercentage(String percentage) {
		Percentage = percentage;
	}

	public String getResult() {
		return Result;
	}

	public void setResult(String result) {
		Result = result;
	}

	@Override
	public String toString() {
		return "StudentRegularResultDetail [RollNo=" + RollNo + ", StudentName=" + StudentName + ", motherName="
				+ motherName + ", gender=" + gender + ", studentPaperResultDetails=" + studentPaperResultDetails
				+ ", MaximumMarks=" + MaximumMarks + ", ObtainedMarks=" + ObtainedMarks + ", Percentage=" + Percentage
				+ ", Result=" + Result + "]";
	}

}
