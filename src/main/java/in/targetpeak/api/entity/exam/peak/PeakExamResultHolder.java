package in.targetpeak.api.entity.exam.peak;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PeakExamResultHolder {

	@Id
	int StudentId;
	String RollNo;
	String StudentName;
	String AttemptCount;

	public PeakExamResultHolder() {
		super();
	}

	public int getStudentId() {
		return StudentId;
	}

	public void setStudentId(int studentId) {
		StudentId = studentId;
	}

	public String getRollNo() {
		return RollNo;
	}

	public void setRollNo(String rollNo) {
		RollNo = rollNo;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public String getAttemptCount() {
		return AttemptCount;
	}

	public void setAttemptCount(String attemptCount) {
		AttemptCount = attemptCount;
	}

	@Override
	public String toString() {
		return "PeakExamResultHolder [StudentId=" + StudentId + ", RollNo=" + RollNo + ", StudentName=" + StudentName
				+ ", AttemptCount=" + AttemptCount + "]";
	}

}
