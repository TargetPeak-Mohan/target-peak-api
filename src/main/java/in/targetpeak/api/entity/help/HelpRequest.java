package in.targetpeak.api.entity.help;

public class HelpRequest {

	Integer AttendantId;
	Integer AttendantRoleId;
	Integer Action;

	public HelpRequest() {
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

}
