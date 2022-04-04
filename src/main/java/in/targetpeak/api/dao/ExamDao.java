package in.targetpeak.api.dao;

import in.targetpeak.api.entity.exam.core.ExaminationListReponse;
import in.targetpeak.api.entity.exam.core.ExaminationsListRequest;
import in.targetpeak.api.entity.exam.peak.PeakExamResultStatusRequest;
import in.targetpeak.api.entity.exam.peak.PeakExamResultListResponse;
import in.targetpeak.api.entity.exam.regular.ExamSubjectListRequest;
import in.targetpeak.api.entity.exam.regular.ExamSubjectListResponse;
import in.targetpeak.api.entity.result.ExamResultListResponse;
import in.targetpeak.api.entity.result.ExamResultRequest;

public interface ExamDao {

	public ExamSubjectListResponse fetchRegularExamSubjects(ExamSubjectListRequest request);
	
	public ExamResultListResponse fetchExamResults(ExamResultRequest request);
	
	public PeakExamResultListResponse fetchPeakExamResults(PeakExamResultStatusRequest request);
	
	public ExaminationListReponse fetchExaminationaList(ExaminationsListRequest request);
}
