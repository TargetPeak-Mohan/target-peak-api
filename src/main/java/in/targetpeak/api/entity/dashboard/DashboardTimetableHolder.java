package in.targetpeak.api.entity.dashboard;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DashboardTimetableHolder {

	@Id
	int TimetableId;
	int ExaminationId;
	String ExamName;
	int SubjectId;
	String SubjectName;
	int QuestionPaperId;
	String PaperName;
	String PaperDuration;
	String PositiveMarking;
	String NegativeMarking;
	int TotalQuestions;
	int MaxMarks;

	String ExamDate;
	String StartTime;
	String EndTime;
	int SortOrder;

	String TotalStudents;
	String SubjectAllotedStudents;
	String PercentSubjectAllotedStudents;

	String ExamsGiven;
	String PercentExamsGiven;

	public DashboardTimetableHolder() {
		super();
	}

	public int getTimetableId() {
		return TimetableId;
	}

	public void setTimetableId(int timetableId) {
		TimetableId = timetableId;
	}

	public int getExaminationId() {
		return ExaminationId;
	}

	public void setExaminationId(int examinationId) {
		ExaminationId = examinationId;
	}

	public String getExamName() {
		return ExamName;
	}

	public void setExamName(String examName) {
		ExamName = examName;
	}

	public int getSubjectId() {
		return SubjectId;
	}

	public void setSubjectId(int subjectId) {
		SubjectId = subjectId;
	}

	public String getSubjectName() {
		return SubjectName;
	}

	public void setSubjectName(String subjectName) {
		SubjectName = subjectName;
	}

	public int getQuestionPaperId() {
		return QuestionPaperId;
	}

	public void setQuestionPaperId(int questionPaperId) {
		QuestionPaperId = questionPaperId;
	}

	public String getPaperName() {
		return PaperName;
	}

	public void setPaperName(String paperName) {
		PaperName = paperName;
	}

	public String getPaperDuration() {
		return PaperDuration;
	}

	public void setPaperDuration(String paperDuration) {
		PaperDuration = paperDuration;
	}

	public String getPositiveMarking() {
		return PositiveMarking;
	}

	public void setPositiveMarking(String positiveMarking) {
		PositiveMarking = positiveMarking;
	}

	public String getNegativeMarking() {
		return NegativeMarking;
	}

	public void setNegativeMarking(String negativeMarking) {
		NegativeMarking = negativeMarking;
	}

	public int getTotalQuestions() {
		return TotalQuestions;
	}

	public void setTotalQuestions(int totalQuestions) {
		TotalQuestions = totalQuestions;
	}

	public int getMaxMarks() {
		return MaxMarks;
	}

	public void setMaxMarks(int maxMarks) {
		MaxMarks = maxMarks;
	}

	public String getExamDate() {
		return ExamDate;
	}

	public void setExamDate(String examDate) {
		ExamDate = examDate;
	}

	public String getStartTime() {
		return StartTime;
	}

	public void setStartTime(String startTime) {
		StartTime = startTime;
	}

	public String getEndTime() {
		return EndTime;
	}

	public void setEndTime(String endTime) {
		EndTime = endTime;
	}

	public int getSortOrder() {
		return SortOrder;
	}

	public void setSortOrder(int sortOrder) {
		SortOrder = sortOrder;
	}

	public String getTotalStudents() {
		return TotalStudents;
	}

	public void setTotalStudents(String totalStudents) {
		TotalStudents = totalStudents;
	}

	public String getSubjectAllotedStudents() {
		return SubjectAllotedStudents;
	}

	public void setSubjectAllotedStudents(String subjectAllotedStudents) {
		SubjectAllotedStudents = subjectAllotedStudents;
	}

	public String getExamsGiven() {
		return ExamsGiven;
	}

	public void setExamsGiven(String examsGiven) {
		ExamsGiven = examsGiven;
	}

	public String getPercentSubjectAllotedStudents() {
		return PercentSubjectAllotedStudents;
	}

	public void setPercentSubjectAllotedStudents(String percentSubjectAllotedStudents) {
		PercentSubjectAllotedStudents = percentSubjectAllotedStudents;
	}

	public String getPercentExamsGiven() {
		return PercentExamsGiven;
	}

	public void setPercentExamsGiven(String percentExamsGiven) {
		PercentExamsGiven = percentExamsGiven;
	}

	@Override
	public String toString() {
		return "DashboardTimetableHolder [TimetableId=" + TimetableId + ", ExaminationId=" + ExaminationId
				+ ", ExamName=" + ExamName + ", SubjectId=" + SubjectId + ", SubjectName=" + SubjectName
				+ ", QuestionPaperId=" + QuestionPaperId + ", PaperName=" + PaperName + ", PaperDuration="
				+ PaperDuration + ", PositiveMarking=" + PositiveMarking + ", NegativeMarking=" + NegativeMarking
				+ ", TotalQuestions=" + TotalQuestions + ", MaxMarks=" + MaxMarks + ", ExamDate=" + ExamDate
				+ ", StartTime=" + StartTime + ", EndTime=" + EndTime + ", SortOrder=" + SortOrder + ", TotalStudents="
				+ TotalStudents + ", SubjectAllotedStudents=" + SubjectAllotedStudents
				+ ", PercentSubjectAllotedStudents=" + PercentSubjectAllotedStudents + ", ExamsGiven=" + ExamsGiven
				+ ", PercentExamsGiven=" + PercentExamsGiven + "]";
	}

}
