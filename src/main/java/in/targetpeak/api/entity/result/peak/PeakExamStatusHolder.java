package in.targetpeak.api.entity.result.peak;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PeakExamStatusHolder {

	@Id
	int StudentId;
	int RollNo;
	String StudentName;
	String PaperName;
	int ResultCount;

	// String AverageResult;
	public PeakExamStatusHolder() {
		super();
	}

	public int getStudentId() {
		return StudentId;
	}

	public void setStudentId(int studentId) {
		StudentId = studentId;
	}

	public int getRollNo() {
		return RollNo;
	}

	public void setRollNo(int rollNo) {
		RollNo = rollNo;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public int getResultCount() {
		return ResultCount;
	}

	public void setResultCount(int resultCount) {
		ResultCount = resultCount;
	}

	public String getPaperName() {
		return PaperName;
	}

	public void setPaperName(String paperName) {
		PaperName = paperName;
	}

	@Override
	public String toString() {
		return "PeakExamStatusHolder [StudentId=" + StudentId + ", RollNo=" + RollNo + ", StudentName=" + StudentName
				+ ", PaperName=" + PaperName + ", ResultCount=" + ResultCount + "]";
	}

}
