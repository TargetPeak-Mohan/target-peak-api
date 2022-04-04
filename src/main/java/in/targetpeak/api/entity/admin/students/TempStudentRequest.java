package in.targetpeak.api.entity.admin.students;

public class TempStudentRequest {

	Integer AttendantId;
	Integer AttendantRoleId;
	Integer Action;

	Integer UserId;
	Integer OrganizationId;
	String Search;

	public TempStudentRequest() {
		super();
	}

	public TempStudentRequest(Integer attendantId, Integer attendantRoleId, Integer action, Integer userId,
			Integer organizationId, String search) {
		super();
		AttendantId = attendantId;
		AttendantRoleId = attendantRoleId;
		Action = action;
		UserId = userId;
		OrganizationId = organizationId;
		Search = search;
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

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}

	public String getSearch() {
		return Search;
	}

	public void setSearch(String search) {
		Search = search;
	}

	public Integer getOrganizationId() {
		return OrganizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		OrganizationId = organizationId;
	}

}
