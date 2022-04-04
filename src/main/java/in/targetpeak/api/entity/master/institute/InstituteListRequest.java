package in.targetpeak.api.entity.master.institute;

public class InstituteListRequest {

	Integer AttendantId;
	Integer AttendantRoleId;
	Integer Action;

	Integer InstituteId;
	Integer OrganizationId;

	Integer RecordStatus;
	Integer Offset;
	Integer Limit;
	String Search;
	String SyncDate;
	
	
	

	public InstituteListRequest(Integer attendantId, Integer attendantRoleId, Integer action, Integer instituteId,
			Integer organizationId, Integer recordStatus, Integer offset, Integer limit, String search,
			String syncDate) {
		super();
		AttendantId = attendantId;
		AttendantRoleId = attendantRoleId;
		Action = action;
		InstituteId = instituteId;
		OrganizationId = organizationId;
		RecordStatus = recordStatus;
		Offset = offset;
		Limit = limit;
		Search = search;
		SyncDate = syncDate;
	}

	public InstituteListRequest() {
		super();
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

	public Integer getInstituteId() {
		return InstituteId;
	}

	public void setInstituteId(Integer instituteId) {
		InstituteId = instituteId;
	}

	public Integer getOrganizationId() {
		return OrganizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		OrganizationId = organizationId;
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
