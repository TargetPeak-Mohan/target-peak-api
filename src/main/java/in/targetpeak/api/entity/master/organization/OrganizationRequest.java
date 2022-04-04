package in.targetpeak.api.entity.master.organization;

public class OrganizationRequest {

	Integer AttendantId;
	Integer AttendantRoleId;
	Integer Action;

	Integer OrganizationId;
	String OrganizationName;
	String OrganizationAlias;
	String OrganizationCode;
	Integer RecordStatus;

	public OrganizationRequest() {
		super();
	}

	public OrganizationRequest(Integer attendantId, Integer attendantRoleId, Integer action, Integer organizationId,
			String organizationName, String organizationAlias, String organizationCode, Integer recordStatus) {
		super();
		AttendantId = attendantId;
		AttendantRoleId = attendantRoleId;
		Action = action;
		OrganizationId = organizationId;
		OrganizationName = organizationName;
		OrganizationAlias = organizationAlias;
		OrganizationCode = organizationCode;
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

	public Integer getOrganizationId() {
		return OrganizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		OrganizationId = organizationId;
	}

	public String getOrganizationName() {
		return OrganizationName;
	}

	public void setOrganizationName(String organizationName) {
		OrganizationName = organizationName;
	}

	public String getOrganizationAlias() {
		return OrganizationAlias;
	}

	public void setOrganizationAlias(String organizationAlias) {
		OrganizationAlias = organizationAlias;
	}

	public String getOrganizationCode() {
		return OrganizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		OrganizationCode = organizationCode;
	}

	public Integer getRecordStatus() {
		return RecordStatus;
	}

	public void setRecordStatus(Integer recordStatus) {
		RecordStatus = recordStatus;
	}

}
