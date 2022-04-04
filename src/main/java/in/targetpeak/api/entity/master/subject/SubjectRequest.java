package in.targetpeak.api.entity.master.subject;

public class SubjectRequest {

	Integer AttendantId;
	Integer AttendantRoleId;
	Integer Action;
	String Language;

	Integer SubjectId;
	Integer ClassId;
	String SubjectName;
	Integer RecordStatus;

	public SubjectRequest() {
		super();
	}

	public SubjectRequest(Integer attendantId, Integer attendantRoleId, Integer action, String Language,
			Integer subjectId, Integer classId, String subjectName, Integer recordStatus) {
		super();
		AttendantId = attendantId;
		AttendantRoleId = attendantRoleId;
		Action = action;
		this.Language = Language;
		SubjectId = subjectId;
		ClassId = classId;
		SubjectName = subjectName;
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

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public Integer getSubjectId() {
		return SubjectId;
	}

	public void setSubjectId(Integer subjectId) {
		SubjectId = subjectId;
	}

	public Integer getClassId() {
		return ClassId;
	}

	public void setClassId(Integer classId) {
		ClassId = classId;
	}

	public String getSubjectName() {
		return SubjectName;
	}

	public void setSubjectName(String subjectName) {
		SubjectName = subjectName;
	}

	public Integer getRecordStatus() {
		return RecordStatus;
	}

	public void setRecordStatus(Integer recordStatus) {
		RecordStatus = recordStatus;
	}

}
