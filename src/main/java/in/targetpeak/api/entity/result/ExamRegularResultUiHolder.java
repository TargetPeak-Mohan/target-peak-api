package in.targetpeak.api.entity.result;

import java.util.ArrayList;

public class ExamRegularResultUiHolder {

	String rollNo;
	String StudentName;
	ArrayList<ExamResultUiHolder> examResultUiHolders;
	Integer maximumMarks;
	Integer obtainedMarks;
	String percentage;
	String result;

	public ExamRegularResultUiHolder() {
		super();
	}

	public ExamRegularResultUiHolder(String rollNo, String studentName,
			ArrayList<ExamResultUiHolder> examResultUiHolders, Integer maximumMarks, Integer obtainedMarks,
			String percentage, String result) {
		super();
		this.rollNo = rollNo;
		StudentName = studentName;
		this.examResultUiHolders = examResultUiHolders;
		this.maximumMarks = maximumMarks;
		this.obtainedMarks = obtainedMarks;
		this.percentage = percentage;
		this.result = result;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public ArrayList<ExamResultUiHolder> getExamResultUiHolders() {
		return examResultUiHolders;
	}

	public void setExamResultUiHolders(ArrayList<ExamResultUiHolder> examResultUiHolders) {
		this.examResultUiHolders = examResultUiHolders;
	}

	public Integer getMaximumMarks() {
		return maximumMarks;
	}

	public void setMaximumMarks(Integer maximumMarks) {
		this.maximumMarks = maximumMarks;
	}

	public Integer getObtainedMarks() {
		return obtainedMarks;
	}

	public void setObtainedMarks(Integer obtainedMarks) {
		this.obtainedMarks = obtainedMarks;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ExamRegularResultUiHolder [rollNo=" + rollNo + ", StudentName=" + StudentName + ", examResultUiHolders="
				+ examResultUiHolders + ", maximumMarks=" + maximumMarks + ", obtainedMarks=" + obtainedMarks
				+ ", percentage=" + percentage + ", result=" + result + "]";
	}

}
