package in.targetpeak.api.entity.result;

public class ExamResultUiHolder {

	Integer serialNo;
	String subjectName;
	String maxMarks;
	String obtainedMarks;
	String obtainedInWords;

	public ExamResultUiHolder() {
		super();
	}

	public ExamResultUiHolder(Integer serialNo, String subjectName, String maxMarks, String obtainedMarks,
			String obtainedInWords) {
		super();
		this.serialNo = serialNo;
		this.subjectName = subjectName;
		this.maxMarks = maxMarks;
		this.obtainedMarks = obtainedMarks;
		this.obtainedInWords = obtainedInWords;
	}

	public Integer getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}

	public String getObtainedMarks() {
		return obtainedMarks;
	}

	public void setObtainedMarks(String obtainedMarks) {
		this.obtainedMarks = obtainedMarks;
	}

	public String getObtainedInWords() {
		return obtainedInWords;
	}

	public void setObtainedInWords(String obtainedInWords) {
		this.obtainedInWords = obtainedInWords;
	}

	@Override
	public String toString() {
		return "ExamResultUiHolder [serialNo=" + serialNo + ", subjectName=" + subjectName + ", maxMarks=" + maxMarks
				+ ", obtainedMarks=" + obtainedMarks + ", obtainedInWords=" + obtainedInWords + "]";
	}

}
