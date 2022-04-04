package in.targetpeak.api.entity.master.classs;

public class ClassListRequest {

	Integer AttendantId;
	Integer AttendantRoleId;
	Integer Action;

	Integer ClassId;
	Integer EducationBoardId;
	Integer InstituteId;

	Integer RecordStatus;
	Integer Offset;
	Integer Limit;
	String Search;
	String SyncDate;

	public ClassListRequest() {
		super();
	}

	public ClassListRequest(Integer attendantId, Integer attendantRoleId, Integer action, Integer classId,
			Integer educationBoardId, Integer instituteId, Integer recordStatus, Integer offset, Integer limit,
			String search, String syncDate) {
		super();
		AttendantId = attendantId;
		AttendantRoleId = attendantRoleId;
		Action = action;
		ClassId = classId;
		EducationBoardId = educationBoardId;
		InstituteId = instituteId;
		RecordStatus = recordStatus;
		Offset = offset;
		Limit = limit;
		Search = search;
		SyncDate = syncDate;
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

	public Integer getInstituteId() {
		return InstituteId;
	}

	public void setInstituteId(Integer instituteId) {
		InstituteId = instituteId;
	}

	public Integer getRecordStatus() {
		return RecordStatus;
	}

	public void setRecordStatus(Integer recordStatus) {
		RecordStatus = recordStatus;
	}

	public Integer getOffset() {
		return Offset;
	}

	public void setOffset(Integer offset) {
		Offset = offset;
	}

	public Integer getLimit() {
		return Limit;
	}

	public void setLimit(Integer limit) {
		Limit = limit;
	}

	public String getSearch() {
		return Search;
	}

	public void setSearch(String search) {
		Search = search;
	}

	public String getSyncDate() {
		return SyncDate;
	}

	public void setSyncDate(String syncDate) {
		SyncDate = syncDate;
	}

}
