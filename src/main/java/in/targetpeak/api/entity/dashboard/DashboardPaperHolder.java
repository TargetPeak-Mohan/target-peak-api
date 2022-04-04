package in.targetpeak.api.entity.dashboard;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DashboardPaperHolder {

	@Id
	int TimetableId;
	int ExaminationId;
	String ExamName;
	int SubjectId;
	int QuestionPaperId;
	String ExamDate;
	String StartTime;
	String EndTime;
	int SortOrder;
	String OrganizationName;
	String ClassName;
	int TotalStudents;
	int TotalUniqueAttendees;
	int TotalAttendees;

	public DashboardPaperHolder() {
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

	public int getSubjectId() {
		return SubjectId;
	}

	public void setSubjectId(int subjectId) {
		SubjectId = subjectId;
	}

	public int getQuestionPaperId() {
		return QuestionPaperId;
	}

	public void setQuestionPaperId(int questionPaperId) {
		QuestionPaperId = questionPaperId;
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

	public String getClassName() {
		return ClassName;
	}

	public void setClassName(String className) {
		ClassName = className;
	}

	public int getTotalUniqueAttendees() {
		return TotalUniqueAttendees;
	}

	public void setTotalUniqueAttendees(int totalUniqueAttendees) {
		TotalUniqueAttendees = totalUniqueAttendees;
	}

	public int getTotalAttendees() {
		return TotalAttendees;
	}

	public void setTotalAttendees(int totalAttendees) {
		TotalAttendees = totalAttendees;
	}

	public int getTotalStudents() {
		return TotalStudents;
	}

	public void setTotalStudents(int totalStudents) {
		TotalStudents = totalStudents;
	}

	public String getExamName() {
		return ExamName;
	}

	public void setExamName(String examName) {
		ExamName = examName;
	}

	public String getOrganizationName() {
		return OrganizationName;
	}

	public void setOrganizationName(String organizationName) {
		OrganizationName = organizationName;
	}

	@Override
	public String toString() {
		return "DashboardPaperHolder [TimetableId=" + TimetableId + ", ExaminationId=" + ExaminationId + ", ExamName="
				+ ExamName + ", SubjectId=" + SubjectId + ", QuestionPaperId=" + QuestionPaperId + ", ExamDate="
				+ ExamDate + ", StartTime=" + StartTime + ", EndTime=" + EndTime + ", SortOrder=" + SortOrder
				+ ", OrganizationName=" + OrganizationName + ", ClassName=" + ClassName + ", TotalStudents="
				+ TotalStudents + ", TotalUniqueAttendees=" + TotalUniqueAttendees + ", TotalAttendees="
				+ TotalAttendees + "]";
	}

}
