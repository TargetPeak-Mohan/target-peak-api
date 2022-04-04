package in.targetpeak.api.entity.reports.division;

public class DivisionDashboardRequest {

	Integer AttendantId;
	Integer AttendantRoleId;
	Integer Action;

	Integer OrganizationId;
	Integer InstituteId;
	Integer ClassId;
	Integer DivisionId;

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

	public Integer getClassId() {
		return ClassId;
	}

	public void setClassId(Integer classId) {
		ClassId = classId;
	}

	public Integer getDivisionId() {
		return DivisionId;
	}

	public void setDivisionId(Integer divisionId) {
		DivisionId = divisionId;
	}

	public DivisionDashboardRequest() {
		super();
	}

	public DivisionDashboardRequest(Integer attendantId, Integer attendantRoleId, Integer action,
			Integer organizationId, Integer instituteId, Integer classId, Integer divisionId) {
		super();
		AttendantId = attendantId;
		AttendantRoleId = attendantRoleId;
		Action = action;
		OrganizationId = organizationId;
		InstituteId = instituteId;
		ClassId = classId;
		DivisionId = divisionId;
	}

}
