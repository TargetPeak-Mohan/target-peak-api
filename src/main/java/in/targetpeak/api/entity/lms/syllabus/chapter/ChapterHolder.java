package in.targetpeak.api.entity.lms.syllabus.chapter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ChapterHolder {
	
	@Id
	Integer SyllabusChapterId;
	Integer SubjectId;
	String ChapterName;
	String ChapterNameInMarathi;
	Integer RecordStatus;
	Integer RowCount;

	public ChapterHolder() {
		super();
	}

	public Integer getRowCount() {
		return RowCount;
	}

	public void setRowCount(Integer rowCount) {
		RowCount = rowCount;
	}

	public Integer getSyllabusChapterId() {
		return SyllabusChapterId;
	}

	public void setSyllabusChapterId(Integer syllabusChapterId) {
		SyllabusChapterId = syllabusChapterId;
	}

	public Integer getSubjectId() {
		return SubjectId;
	}

	public void setSubjectId(Integer subjectId) {
		SubjectId = subjectId;
	}

	public String getChapterName() {
		return ChapterName;
	}

	public void setChapterName(String chapterName) {
		ChapterName = chapterName;
	}

	public String getChapterNameInMarathi() {
		return ChapterNameInMarathi;
	}

	public void setChapterNameInMarathi(String chapterNameInMarathi) {
		ChapterNameInMarathi = chapterNameInMarathi;
	}

	

	public Integer getRecordStatus() {
		return RecordStatus;
	}

	public void setRecordStatus(Integer recordStatus) {
		RecordStatus = recordStatus;
	}

	@Override
	public String toString() {
		return "ChapterHolder [RowCount=" + RowCount + ", SyllabusChapterId=" + SyllabusChapterId + ", SubjectId="
				+ SubjectId + ", ChapterName=" + ChapterName + ", ChapterNameInMarathi=" + ChapterNameInMarathi
				+ ", RecordStatus=" + RecordStatus + "]";
	}

	

}
