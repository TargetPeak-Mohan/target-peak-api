package in.targetpeak.api.entity.exam.peak.rank;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RankPeakResultHolder {
	@Id
	int ResultId;
	int StudentId;
	int ClassId;
	int QuestionPaperId;
	int ExamScore;

	public int getResultId() {
		return ResultId;
	}

	public void setResultId(int resultId) {
		ResultId = resultId;
	}

	public int getStudentId() {
		return StudentId;
	}

	public void setStudentId(int studentId) {
		StudentId = studentId;
	}

	public int getClassId() {
		return ClassId;
	}

	public void setClassId(int classId) {
		ClassId = classId;
	}

	public int getQuestionPaperId() {
		return QuestionPaperId;
	}

	public void setQuestionPaperId(int questionPaperId) {
		QuestionPaperId = questionPaperId;
	}

	public int getExamScore() {
		return ExamScore;
	}

	public void setExamScore(int examScore) {
		ExamScore = examScore;
	}

	@Override
	public String toString() {
		return "RankPeakResultHolder [ResultId=" + ResultId + ", StudentId=" + StudentId + ", ClassId=" + ClassId
				+ ", QuestionPaperId=" + QuestionPaperId + ", ExamScore=" + ExamScore + "]";
	}

}
