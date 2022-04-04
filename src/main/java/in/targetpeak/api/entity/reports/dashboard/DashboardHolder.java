package in.targetpeak.api.entity.reports.dashboard;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class DashboardHolder {

	@Id
	String OrganizationCount;
	String InstituteCount;
	String InstituteCoordinatorCount;
	String ClassTeacherCount;
	String StudentsCount;
	String VideoViewCount;
	String VideoViewStudentsCount;
	String ExamResultCount;
	String ExamResultStudentsCount;
	String ExamStudentsAppearLogCount;

	public DashboardHolder() {
		super();
	}

	public DashboardHolder(String organizationCount, String instituteCount, String instituteCoordinatorCount,
			String classTeacherCount, String studentsCount, String videoViewCount, String videoViewStudentsCount,
			String examResultCount, String examResultStudentsCount, String examStudentsAppearLogCount) {
		super();
		OrganizationCount = organizationCount;
		InstituteCount = instituteCount;
		InstituteCoordinatorCount = instituteCoordinatorCount;
		ClassTeacherCount = classTeacherCount;
		StudentsCount = studentsCount;
		VideoViewCount = videoViewCount;
		VideoViewStudentsCount = videoViewStudentsCount;
		ExamResultCount = examResultCount;
		ExamResultStudentsCount = examResultStudentsCount;
		ExamStudentsAppearLogCount = examStudentsAppearLogCount;
	}

	public String getOrganizationCount() {
		return OrganizationCount;
	}

	public void setOrganizationCount(String organizationCount) {
		OrganizationCount = organizationCount;
	}

	public String getInstituteCount() {
		return InstituteCount;
	}

	public void setInstituteCount(String instituteCount) {
		InstituteCount = instituteCount;
	}

	public String getInstituteCoordinatorCount() {
		return InstituteCoordinatorCount;
	}

	public void setInstituteCoordinatorCount(String instituteCoordinatorCount) {
		InstituteCoordinatorCount = instituteCoordinatorCount;
	}

	public String getClassTeacherCount() {
		return ClassTeacherCount;
	}

	public void setClassTeacherCount(String classTeacherCount) {
		ClassTeacherCount = classTeacherCount;
	}

	public String getStudentsCount() {
		return StudentsCount;
	}

	public void setStudentsCount(String studentsCount) {
		StudentsCount = studentsCount;
	}

	public String getVideoViewCount() {
		return VideoViewCount;
	}

	public void setVideoViewCount(String videoViewCount) {
		VideoViewCount = videoViewCount;
	}

	public String getVideoViewStudentsCount() {
		return VideoViewStudentsCount;
	}

	public void setVideoViewStudentsCount(String videoViewStudentsCount) {
		VideoViewStudentsCount = videoViewStudentsCount;
	}

	public String getExamResultCount() {
		return ExamResultCount;
	}

	public void setExamResultCount(String examResultCount) {
		ExamResultCount = examResultCount;
	}

	public String getExamResultStudentsCount() {
		return ExamResultStudentsCount;
	}

	public void setExamResultStudentsCount(String examResultStudentsCount) {
		ExamResultStudentsCount = examResultStudentsCount;
	}

	public String getExamStudentsAppearLogCount() {
		return ExamStudentsAppearLogCount;
	}

	public void setExamStudentsAppearLogCount(String examStudentsAppearLogCount) {
		ExamStudentsAppearLogCount = examStudentsAppearLogCount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DashboardHolder {OrganizationCount=");
		builder.append(OrganizationCount);
		builder.append(", InstituteCount=");
		builder.append(InstituteCount);
		builder.append(", InstituteCoordinatorCount=");
		builder.append(InstituteCoordinatorCount);
		builder.append(", ClassTeacherCount=");
		builder.append(ClassTeacherCount);
		builder.append(", StudentsCount=");
		builder.append(StudentsCount);
		builder.append(", VideoViewCount=");
		builder.append(VideoViewCount);
		builder.append(", VideoViewStudentsCount=");
		builder.append(VideoViewStudentsCount);
		builder.append(", ExamResultCount=");
		builder.append(ExamResultCount);
		builder.append(", ExamResultStudentsCount=");
		builder.append(ExamResultStudentsCount);
		builder.append(", ExamStudentsAppearLogCount=");
		builder.append(ExamStudentsAppearLogCount);
		builder.append("}");
		return builder.toString();
	}

}
