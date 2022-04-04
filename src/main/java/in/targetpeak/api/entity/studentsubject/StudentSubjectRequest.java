package in.targetpeak.api.entity.studentsubject;

public class StudentSubjectRequest {

	Integer AttendantId;
	Integer AttendantRoleId;
	Integer Action;

	Integer StudentSubjectRelationId;
	Integer StudentId;
	Integer SubjectId;
	Integer IsActive;

	public StudentSubjectRequest() {
		super();
	}

	

	public StudentSubjectRequest(Integer attendantId, Integer attendantRoleId, Integer action,
			Integer studentSubjectRelationId, Integer studentId, Integer subjectId, Integer isActive) {
		super();
		AttendantId = attendantId;
		AttendantRoleId = attendantRoleId;
		Action = action;
		StudentSubjectRelationId = studentSubjectRelationId;
		StudentId = studentId;
		SubjectId = subjectId;
		IsActive = isActive;
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

	public Integer getStudentSubjectRelationId() {
		return StudentSubjectRelationId;
	}

	public void setStudentSubjectRelationId(Integer studentSubjectRelationId) {
		StudentSubjectRelationId = studentSubjectRelationId;
	}

	public Integer getStudentId() {
		return StudentId;
	}

	public void setStudentId(Integer studentId) {
		StudentId = studentId;
	}

	public Integer getSubjectId() {
		return SubjectId;
	}

	public void setSubjectId(Integer subjectId) {
		SubjectId = subjectId;
	}



	public Integer getIsActive() {
		return IsActive;
	}



	public void setIsActive(Integer isActive) {
		IsActive = isActive;
	}

	
}
