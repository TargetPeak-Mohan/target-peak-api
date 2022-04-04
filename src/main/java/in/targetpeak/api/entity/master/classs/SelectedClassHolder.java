package in.targetpeak.api.entity.master.classs;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SelectedClassHolder {

	@Id
	Integer ClassId;
	Integer EducationBoardId;
	String ClassName;
	Integer SortOrder;
	Integer RowCount;

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

	public Integer getRowCount() {
		return RowCount;
	}

	public void setRowCount(Integer rowCount) {
		RowCount = rowCount;
	}

	@Override
	public String toString() {
		return "SelectedClassHolder [ClassId=" + ClassId + ", EducationBoardId=" + EducationBoardId + ", ClassName="
				+ ClassName + ", SortOrder=" + SortOrder + ", RowCount=" + RowCount + "]";
	}

}
