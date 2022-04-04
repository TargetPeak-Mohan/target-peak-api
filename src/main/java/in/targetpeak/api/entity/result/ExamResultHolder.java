package in.targetpeak.api.entity.result;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExamResultHolder {

	@Id
	Integer ResultId;
	Integer QuestionPaperId;
	Integer StudentId;
	Double ExamScore;
	String ResultRemark;
	Integer StudentAppearLogId;
	Integer OverallRank;
	Integer AcademicYearId;
	Integer ExaminationTypeId;
	Integer SubjectId;
	String PaperName;
	String PaperCode;
	Integer PaperDuration;
	Double PositiveMarking;
	Double NegativeMarking;
	Integer ClassId;
	String SubjectName;
	Integer TotalQuestions;

	public Integer getResultId() {
		return ResultId;
	}

	public void setResultId(Integer resultId) {
		ResultId = resultId;
	}

	public Integer getQuestionPaperId() {
		return QuestionPaperId;
	}

	public void setQuestionPaperId(Integer questionPaperId) {
		QuestionPaperId = questionPaperId;
	}

	public Integer getStudentId() {
		return StudentId;
	}

	public void setStudentId(Integer studentId) {
		StudentId = studentId;
	}

	public Double getExamScore() {
		return ExamScore;
	}

	public void setExamScore(Double examScore) {
		ExamScore = examScore;
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

	public Integer getAcademicYearId() {
		return AcademicYearId;
	}

	public void setAcademicYearId(Integer academicYearId) {
		AcademicYearId = academicYearId;
	}

	public Integer getExaminationTypeId() {
		return ExaminationTypeId;
	}

	public void setExaminationTypeId(Integer examinationTypeId) {
		ExaminationTypeId = examinationTypeId;
	}

	public Integer getSubjectId() {
		return SubjectId;
	}

	public void setSubjectId(Integer subjectId) {
		SubjectId = subjectId;
	}

	public String getPaperName() {
		return PaperName;
	}

	public void setPaperName(String paperName) {
		PaperName = paperName;
	}

	public String getPaperCode() {
		return PaperCode;
	}

	public void setPaperCode(String paperCode) {
		PaperCode = paperCode;
	}

	public Integer getPaperDuration() {
		return PaperDuration;
	}

	public void setPaperDuration(Integer paperDuration) {
		PaperDuration = paperDuration;
	}

	public Double getPositiveMarking() {
		return PositiveMarking;
	}

	public void setPositiveMarking(Double positiveMarking) {
		PositiveMarking = positiveMarking;
	}

	public Double getNegativeMarking() {
		return NegativeMarking;
	}

	public void setNegativeMarking(Double negativeMarking) {
		NegativeMarking = negativeMarking;
	}

	public Integer getClassId() {
		return ClassId;
	}

	public void setClassId(Integer classId) {
		ClassId = classId;
	}

	public String getSubjectName() {
		return SubjectName;
	}

	public void setSubjectName(String subjectName) {
		SubjectName = subjectName;
	}

	public Integer getTotalQuestions() {
		return TotalQuestions;
	}

	public void setTotalQuestions(Integer totalQuestions) {
		TotalQuestions = totalQuestions;
	}

	@Override
	public String toString() {
		return "ExamResultHolder [ResultId=" + ResultId + ", QuestionPaperId=" + QuestionPaperId + ", StudentId="
				+ StudentId + ", ExamScore=" + ExamScore + ", ResultRemark=" + ResultRemark + ", StudentAppearLogId="
				+ StudentAppearLogId + ", OverallRank=" + OverallRank + ", AcademicYearId=" + AcademicYearId
				+ ", ExaminationTypeId=" + ExaminationTypeId + ", SubjectId=" + SubjectId + ", PaperName=" + PaperName
				+ ", PaperCode=" + PaperCode + ", PaperDuration=" + PaperDuration + ", PositiveMarking="
				+ PositiveMarking + ", NegativeMarking=" + NegativeMarking + ", ClassId=" + ClassId + ", SubjectName="
				+ SubjectName + ", TotalQuestions=" + TotalQuestions + "]";
	}

}
