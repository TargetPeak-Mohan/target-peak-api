package in.targetpeak.api.entity.result.peak;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PeakExamResultStudentHolder {

	Integer RollNo;
	String StudentName;
	String ExamName;
	Integer SubjectId;
	String SubjectName;
	Integer QuestionPaperId;
	String PaperName;
	double PositiveMarking;
	double NegativeMarking;
	String PaperCode;
	String PaperDuration;
	Integer TotalQuestions;
	double MaxMarks;
	double ExamScore;
	Integer ResultId;
	String Percentage;
	String ResultRemark;
	Integer StudentAppearLogId;
	@Id
	Integer OverallRank;
	String PeakOverAllRank;
	String PeakSansthaRank;
	String PeakInstituteRank;

	public PeakExamResultStudentHolder() {
		super();
	}

	public PeakExamResultStudentHolder(Integer rollNo, String studentName, String examName, Integer subjectId,
			String subjectName, Integer questionPaperId, String paperName, double positiveMarking,
			double negativeMarking, String paperCode, String paperDuration, Integer totalQuestions, double maxMarks,
			double examScore, Integer resultId, String percentage, String resultRemark, Integer studentAppearLogId,
			Integer overallRank) {
		super();
		RollNo = rollNo;
		StudentName = studentName;
		ExamName = examName;
		SubjectId = subjectId;
		SubjectName = subjectName;
		QuestionPaperId = questionPaperId;
		PaperName = paperName;
		PositiveMarking = positiveMarking;
		NegativeMarking = negativeMarking;
		PaperCode = paperCode;
		PaperDuration = paperDuration;
		TotalQuestions = totalQuestions;
		MaxMarks = maxMarks;
		ExamScore = examScore;
		ResultId = resultId;
		Percentage = percentage;
		ResultRemark = resultRemark;
		StudentAppearLogId = studentAppearLogId;
		OverallRank = overallRank;
	}

	public Integer getRollNo() {
		return RollNo;
	}

	public void setRollNo(Integer rollNo) {
		RollNo = rollNo;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public String getExamName() {
		return ExamName;
	}

	public void setExamName(String examName) {
		ExamName = examName;
	}

	public Integer getSubjectId() {
		return SubjectId;
	}

	public void setSubjectId(Integer subjectId) {
		SubjectId = subjectId;
	}

	public String getSubjectName() {
		return SubjectName;
	}

	public void setSubjectName(String subjectName) {
		SubjectName = subjectName;
	}

	public Integer getQuestionPaperId() {
		return QuestionPaperId;
	}

	public void setQuestionPaperId(Integer questionPaperId) {
		QuestionPaperId = questionPaperId;
	}

	public String getPaperName() {
		return PaperName;
	}

	public void setPaperName(String paperName) {
		PaperName = paperName;
	}

	public double getPositiveMarking() {
		return PositiveMarking;
	}

	public void setPositiveMarking(double positiveMarking) {
		PositiveMarking = positiveMarking;
	}

	public double getNegativeMarking() {
		return NegativeMarking;
	}

	public void setNegativeMarking(double negativeMarking) {
		NegativeMarking = negativeMarking;
	}

	public String getPaperCode() {
		return PaperCode;
	}

	public void setPaperCode(String paperCode) {
		PaperCode = paperCode;
	}

	public String getPaperDuration() {
		return PaperDuration;
	}

	public void setPaperDuration(String paperDuration) {
		PaperDuration = paperDuration;
	}

	public Integer getTotalQuestions() {
		return TotalQuestions;
	}

	public void setTotalQuestions(Integer totalQuestions) {
		TotalQuestions = totalQuestions;
	}

	public double getMaxMarks() {
		return MaxMarks;
	}

	public void setMaxMarks(double maxMarks) {
		MaxMarks = maxMarks;
	}

	public double getExamScore() {
		return ExamScore;
	}

	public void setExamScore(double examScore) {
		ExamScore = examScore;
	}

	public Integer getResultId() {
		return ResultId;
	}

	public void setResultId(Integer resultId) {
		ResultId = resultId;
	}

	public String getPercentage() {
		return Percentage;
	}

	public void setPercentage(String percentage) {
		Percentage = percentage;
	}

	public String getResultRemark() {
		return ResultRemark;
	}

	public void setResultRemark(String resultRemark) {
		ResultRemark = resultRemark;
	}

	public Integer getStudentAppearLogId() {
		return StudentAppearLogId;
	}

	public void setStudentAppearLogId(Integer studentAppearLogId) {
		StudentAppearLogId = studentAppearLogId;
	}

	public Integer getOverallRank() {
		return OverallRank;
	}

	public void setOverallRank(Integer overallRank) {
		OverallRank = overallRank;
	}

	public String getPeakOverAllRank() {
		return PeakOverAllRank;
	}

	public void setPeakOverAllRank(String peakOverAllRank) {
		PeakOverAllRank = peakOverAllRank;
	}

	public String getPeakSansthaRank() {
		return PeakSansthaRank;
	}

	public void setPeakSansthaRank(String peakSansthaRank) {
		PeakSansthaRank = peakSansthaRank;
	}

	public String getPeakInstituteRank() {
		return PeakInstituteRank;
	}

	public void setPeakInstituteRank(String peakInstituteRank) {
		PeakInstituteRank = peakInstituteRank;
	}

	@Override
	public String toString() {
		return "PeakExamResultStudentHolder [RollNo=" + RollNo + ", StudentName=" + StudentName + ", ExamName="
				+ ExamName + ", SubjectId=" + SubjectId + ", SubjectName=" + SubjectName + ", QuestionPaperId="
				+ QuestionPaperId + ", PaperName=" + PaperName + ", PositiveMarking=" + PositiveMarking
				+ ", NegativeMarking=" + NegativeMarking + ", PaperCode=" + PaperCode + ", PaperDuration="
				+ PaperDuration + ", TotalQuestions=" + TotalQuestions + ", MaxMarks=" + MaxMarks + ", ExamScore="
				+ ExamScore + ", ResultId=" + ResultId + ", Percentage=" + Percentage + ", ResultRemark=" + ResultRemark
				+ ", StudentAppearLogId=" + StudentAppearLogId + ", OverallRank=" + OverallRank + ", PeakOverAllRank="
				+ PeakOverAllRank + ", PeakSansthaRank=" + PeakSansthaRank + ", PeakInstituteRank=" + PeakInstituteRank
				+ "]";
	}

}
