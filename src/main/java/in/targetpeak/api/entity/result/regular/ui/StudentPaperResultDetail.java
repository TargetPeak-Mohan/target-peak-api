package in.targetpeak.api.entity.result.regular.ui;


public class StudentPaperResultDetail {

	Integer serialNo;
	String paperName;
	String maxMarks;
	String examScore;
	String obtainedInWords;
	String resultRemark;

	public StudentPaperResultDetail() {
		super();
	}

	public StudentPaperResultDetail(Integer serialNo, String paperName, String maxMarks, String examScore,
			String obtainedInWords, String resultRemark) {
		super();
		this.serialNo = serialNo;
		this.paperName = paperName;
		this.maxMarks = maxMarks;
		this.examScore = examScore;
		this.obtainedInWords = obtainedInWords;
		this.resultRemark = resultRemark;
	}

	public Integer getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public String getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}

	public String getExamScore() {
		return examScore;
	}

	public void setExamScore(String examScore) {
		this.examScore = examScore;
	}

	public String getObtainedInWords() {
		return obtainedInWords;
	}

	public void setObtainedInWords(String obtainedInWords) {
		this.obtainedInWords = obtainedInWords;
	}

	public String getResultRemark() {
		return resultRemark;
	}

	public void setResultRemark(String resultRemark) {
		this.resultRemark = resultRemark;
	}

	@Override
	public String toString() {
		return "StudentPaperResultDetails [serialNo=" + serialNo + ", paperName=" + paperName + ", maxMarks=" + maxMarks
				+ ", examScore=" + examScore + ", obtainedInWords=" + obtainedInWords + ", resultRemark=" + resultRemark
				+ "]";
	}

}
