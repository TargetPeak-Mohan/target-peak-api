package in.targetpeak.api.entity.dashboard;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DashboardExaminationHolder {

	@Id
	int ExaminationId;
	int ExaminationBoardId;
	int OrganizationId;
	int InstituteId;
	int ClassId;
	String ClassName;
	String ExamName;
	String ExamDescription;
	String StartDate;
	String EndDate;
	int RecordStatus;
	int TotalUniqueAttendees;
	int TotalAttendees;

	public DashboardExaminationHolder() {
		super();
	}

	public int getExaminationId() {
		return ExaminationId;
	}

	public void setExaminationId(int examinationId) {
		ExaminationId = examinationId;
	}

	public int getExaminationBoardId() {
		return ExaminationBoardId;
	}

	public void setExaminationBoardId(int examinationBoardId) {
		ExaminationBoardId = examinationBoardId;
	}

	public int getOrganizationId() {
		return OrganizationId;
	}

	public void setOrganizationId(int organizationId) {
		OrganizationId = organizationId;
	}

	public int getInstituteId() {
		return InstituteId;
	}

	public void setInstituteId(int instituteId) {
		InstituteId = instituteId;
	}

	public int getClassId() {
		return ClassId;
	}

	public void setClassId(int classId) {
		ClassId = classId;
	}

	public String getExamName() {
		return ExamName;
	}

	public void setExamName(String examName) {
		ExamName = examName;
	}

	public String getExamDescription() {
		return ExamDescription;
	}

	public void setExamDescription(String examDescription) {
		ExamDescription = examDescription;
	}

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}

	public int getRecordStatus() {
		return RecordStatus;
	}

	public void setRecordStatus(int recordStatus) {
		RecordStatus = recordStatus;
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

	public String getClassName() {
		return ClassName;
	}

	public void setClassName(String className) {
		ClassName = className;
	}

	@Override
	public String toString() {
		return "DashboardExaminationHolder [ExaminationId=" + ExaminationId + ", ExaminationBoardId="
				+ ExaminationBoardId + ", OrganizationId=" + OrganizationId + ", InstituteId=" + InstituteId
				+ ", ClassId=" + ClassId + ", ClassName=" + ClassName + ", ExamName=" + ExamName + ", ExamDescription="
				+ ExamDescription + ", StartDate=" + StartDate + ", EndDate=" + EndDate + ", RecordStatus="
				+ RecordStatus + ", TotalUniqueAttendees=" + TotalUniqueAttendees + ", TotalAttendees=" + TotalAttendees
				+ "]";
	}

}
