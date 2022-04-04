package in.targetpeak.api.entity.reports.institute;

public class InstituteDashboardRequest {

	Integer AttendantId;
	Integer AttendantRoleId;
	Integer Action;

	Integer OrganizationId;
	Integer InstituteId;

	public InstituteDashboardRequest() {
		super();
	}

	public InstituteDashboardRequest(Integer attendantId, Integer attendantRoleId, Integer action,
			Integer organizationId, Integer instituteId) {
		super();
		AttendantId = attendantId;
		AttendantRoleId = attendantRoleId;
		Action = action;
		OrganizationId = organizationId;
		InstituteId = instituteId;
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

	public Integer getInstituteId() {
		return InstituteId;
	}

	public void setInstituteId(Integer instituteId) {
		InstituteId = instituteId;
	}

}
