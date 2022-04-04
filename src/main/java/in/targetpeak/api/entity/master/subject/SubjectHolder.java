package in.targetpeak.api.entity.master.subject;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SubjectHolder {

	@Id
	Integer SubjectId;
	Integer ClassId;
	String SubjectName;
	Integer RecordStatus;
	Integer IsActive;
	String AddedBy;
	String Created;
	Integer EducationBoardId;
	String ClassName;
	Integer RowCount;

	public SubjectHolder() {
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

	public Integer getIsActive() {
		return IsActive;
	}

	public void setIsActive(Integer isActive) {
		IsActive = isActive;
	}

	public String getAddedBy() {
		return AddedBy;
	}

	public void setAddedBy(String addedBy) {
		AddedBy = addedBy;
	}

	public String getCreated() {
		return Created;
	}

	public void setCreated(String created) {
		Created = created;
	}

	public Integer getEducationBoardId() {
		return EducationBoardId;
	}

	public void setEducationBoardId(Integer educationBoardId) {
		EducationBoardId = educationBoardId;
	}

	public String getClassName() {
		return ClassName;
	}

	public void setClassName(String className) {
		ClassName = className;
	}

	

	@Override
	public String toString() {
		return "SubjectHolder [RowCount=" + RowCount + ", SubjectId=" + SubjectId + ", ClassId=" + ClassId
				+ ", SubjectName=" + SubjectName + ", RecordStatus=" + RecordStatus + ", IsActive=" + IsActive
				+ ", AddedBy=" + AddedBy + ", Created=" + Created + ", EducationBoardId=" + EducationBoardId
				+ ", ClassName=" + ClassName  + "]";
	}

}
