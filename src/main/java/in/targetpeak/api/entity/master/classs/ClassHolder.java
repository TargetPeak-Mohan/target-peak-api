package in.targetpeak.api.entity.master.classs;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClassHolder {

	
	@Id
	Integer ClassId;
	Integer EducationBoardId;
	String ClassName;
	Integer SortOrder;
	Integer IsActive;
	Integer RecordStatus;
	String AddedBy;
	String ModifiedBy;
	String EducationBoardName;
	String EducationBoardNameAlias;
	Integer RowCount;

	public ClassHolder() {
		super();
	}

	public Integer getRowCount() {
		return RowCount;
	}

	public void setRowCount(Integer rowCount) {
		RowCount = rowCount;
	}

	public Integer getClassId() {
		return ClassId;
	}

	public void setClassId(Integer classId) {
		ClassId = classId;
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

	public Integer getSortOrder() {
		return SortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		SortOrder = sortOrder;
	}

	public Integer getIsActive() {
		return IsActive;
	}

	public void setIsActive(Integer isActive) {
		IsActive = isActive;
	}

	public Integer getRecordStatus() {
		return RecordStatus;
	}

	public void setRecordStatus(Integer recordStatus) {
		RecordStatus = recordStatus;
	}

	public String getAddedBy() {
		return AddedBy;
	}

	public void setAddedBy(String addedBy) {
		AddedBy = addedBy;
	}

	public String getModifiedBy() {
		return ModifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		ModifiedBy = modifiedBy;
	}

	public String getEducationBoardName() {
		return EducationBoardName;
	}

	public void setEducationBoardName(String educationBoardName) {
		EducationBoardName = educationBoardName;
	}

	public String getEducationBoardNameAlias() {
		return EducationBoardNameAlias;
	}

	public void setEducationBoardNameAlias(String educationBoardNameAlias) {
		EducationBoardNameAlias = educationBoardNameAlias;
	}

	@Override
	public String toString() {
		return "ClassHolder [RowCount=" + RowCount + ", ClassId=" + ClassId + ", EducationBoardId=" + EducationBoardId
				+ ", ClassName=" + ClassName + ", SortOrder=" + SortOrder + ", IsActive=" + IsActive + ", RecordStatus="
				+ RecordStatus + ", AddedBy=" + AddedBy + ", ModifiedBy=" + ModifiedBy + ", EducationBoardName="
				+ EducationBoardName + ", EducationBoardNameAlias=" + EducationBoardNameAlias + "]";
	}

}
