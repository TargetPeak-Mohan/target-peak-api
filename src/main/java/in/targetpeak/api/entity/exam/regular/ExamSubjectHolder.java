package in.targetpeak.api.entity.exam.regular;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExamSubjectHolder {

	@Id
	Integer SubjectId;
	Integer ClassId;
	String SubjectName;
	Integer RecordStatus;
	String AvailableIn;
	Integer IsActive;
	Integer RowCount;

	public ExamSubjectHolder() {
		super();
	}

	public Integer getRowCount() {
		return RowCount;
	}

	public void setRowCount(Integer rowCount) {
		RowCount = rowCount;
	}

	public Integer getSubjectId() {
		return SubjectId;
	}

	public void setSubjectId(Integer subjectId) {
		SubjectId = subjectId;
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

	public Integer getRecordStatus() {
		return RecordStatus;
	}

	public void setRecordStatus(Integer recordStatus) {
		RecordStatus = recordStatus;
	}

	public String getAvailableIn() {
		return AvailableIn;
	}

	public void setAvailableIn(String availableIn) {
		AvailableIn = availableIn;
	}

	public Integer getIsActive() {
		return IsActive;
	}

	public void setIsActive(Integer isActive) {
		IsActive = isActive;
	}

	@Override
	public String toString() {
		return "RegularExamSubjectHolder [RowCount=" + RowCount + ", SubjectId=" + SubjectId + ", ClassId=" + ClassId
				+ ", SubjectName=" + SubjectName + ", RecordStatus=" + RecordStatus + ", AvailableIn=" + AvailableIn
				+ ", IsActive=" + IsActive + "]";
	}

}
