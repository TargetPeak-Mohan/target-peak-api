package in.targetpeak.api.entity.exam.core;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExaminationHolder {

	@Id
	Integer ExaminationId;
	Integer ExaminationBoardId;
	Integer OrganizationId;
	Integer InstituteId;
	Integer ClassId;
	String ExamName;
	String ExamDescription;

	String StartDate;
	String EndDate;
	Integer RecordStatus;
	Integer IsActive;

	public ExaminationHolder() {
		super();
	}

	public Integer getExaminationId() {
		return ExaminationId;
	}

	public void setExaminationId(Integer examinationId) {
		ExaminationId = examinationId;
	}

	public Integer getExaminationBoardId() {
		return ExaminationBoardId;
	}

	public void setExaminationBoardId(Integer examinationBoardId) {
		ExaminationBoardId = examinationBoardId;
	}

	public Integer getOrganizationId() {
		return OrganizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		OrganizationId = organizationId;
	}

	public Integer getInstituteId() {
		return InstituteId;
	}

	public void setInstituteId(Integer instituteId) {
		InstituteId = instituteId;
	}

	public Integer getClassId() {
		return ClassId;
	}

	public void setClassId(Integer classId) {
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

	public Integer getRecordStatus() {
		return RecordStatus;
	}

	public void setRecordStatus(Integer recordStatus) {
		RecordStatus = recordStatus;
	}

	public Integer getIsActive() {
		return IsActive;
	}

	public void setIsActive(Integer isActive) {
		IsActive = isActive;
	}

	@Override
	public String toString() {
		return "ExaminationHolder [ExaminationId=" + ExaminationId + ", ExaminationBoardId=" + ExaminationBoardId
				+ ", OrganizationId=" + OrganizationId + ", InstituteId=" + InstituteId + ", ClassId=" + ClassId
				+ ", ExamName=" + ExamName + ", ExamDescription=" + ExamDescription + ", StartDate=" + StartDate
				+ ", EndDate=" + EndDate + ", RecordStatus=" + RecordStatus + ", IsActive=" + IsActive + "]";
	}

}
