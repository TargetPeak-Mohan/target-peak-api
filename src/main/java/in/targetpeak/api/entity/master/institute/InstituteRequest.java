package in.targetpeak.api.entity.master.institute;

public class InstituteRequest {

	Integer AttendantId;
	Integer AttendantRoleId;
	Integer Action;

	Integer InstituteId;
	Integer OrganizationId;
	String InstituteName;
	String InstituteAlias;
	String InstituteCode;
	Integer RecordStatus;

	public InstituteRequest() {
		super();
	}

	public InstituteRequest(Integer attendantId, Integer attendantRoleId, Integer action, Integer instituteId,
			Integer organizationId, String instituteName, String instituteAlias, String instituteCode,
			Integer recordStatus) {
		super();
		AttendantId = attendantId;
		AttendantRoleId = attendantRoleId;
		Action = action;
		InstituteId = instituteId;
		OrganizationId = organizationId;
		InstituteName = instituteName;
		InstituteAlias = instituteAlias;
		InstituteCode = instituteCode;
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

	public String getInstituteName() {
		return InstituteName;
	}

	public void setInstituteName(String instituteName) {
		InstituteName = instituteName;
	}

	public String getInstituteAlias() {
		return InstituteAlias;
	}

	public void setInstituteAlias(String instituteAlias) {
		InstituteAlias = instituteAlias;
	}

	public String getInstituteCode() {
		return InstituteCode;
	}

	public void setInstituteCode(String instituteCode) {
		InstituteCode = instituteCode;
	}

	public Integer getRecordStatus() {
		return RecordStatus;
	}

	public void setRecordStatus(Integer recordStatus) {
		RecordStatus = recordStatus;
	}

}
