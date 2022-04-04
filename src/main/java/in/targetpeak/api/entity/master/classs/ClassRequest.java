package in.targetpeak.api.entity.master.classs;

public class ClassRequest {

	Integer AttendantId;
	Integer AttendantRoleId;
	Integer Action;

	Integer ClassId;
	Integer EducationBoardId;
	String ClassName;
	String SortOrder;
	Integer RecordStatus;

	public ClassRequest() {
		super();
	}

	public ClassRequest(Integer attendantId, Integer attendantRoleId, Integer action, Integer classId,
			Integer educationBoardId, String className, String sortOrder, Integer recordStatus) {
		super();
		AttendantId = attendantId;
		AttendantRoleId = attendantRoleId;
		Action = action;
		ClassId = classId;
		EducationBoardId = educationBoardId;
		ClassName = className;
		SortOrder = sortOrder;
		RecordStatus = recordStatus;
	}

	public Integer getAttendantId() {
		return AttendantId;
	}

	public void setAttendantId(Integer attendantId) {
		AttendantId = attendantId;
	}

	public Integer getAttendantRoleId() {
		return AttendantRoleId;
	}

	public void setAttendantRoleId(Integer attendantRoleId) {
		AttendantRoleId = attendantRoleId;
	}

	public Integer getAction() {
		return Action;
	}

	public void setAction(Integer action) {
		Action = action;
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

	public String getSortOrder() {
		return SortOrder;
	}

	public void setSortOrder(String sortOrder) {
		SortOrder = sortOrder;
	}

	public Integer getRecordStatus() {
		return RecordStatus;
	}

	public void setRecordStatus(Integer recordStatus) {
		RecordStatus = recordStatus;
	}

}
