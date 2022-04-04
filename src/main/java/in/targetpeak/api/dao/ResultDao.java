package in.targetpeak.api.dao;

import java.util.List;

import in.targetpeak.api.entity.exam.peak.PeakExamFinalResultListResponse;
import in.targetpeak.api.entity.exam.peak.PeakExamResultStatusRequest;
import in.targetpeak.api.entity.exam.peak.rank.RankPeakResulListResponse;
import in.targetpeak.api.entity.result.peak.PeakExamResultRequest;
import in.targetpeak.api.entity.result.peak.PeakExamResultStudentHolder;
import in.targetpeak.api.entity.result.peak.PeakExamResultStudentListResponse;
import in.targetpeak.api.entity.result.peak.PeakExamStatusListResponse;
import in.targetpeak.api.entity.result.peak.PeakExamStudentListRequest;
import in.targetpeak.api.entity.result.regular.RegularExamResultRequest;
import in.targetpeak.api.entity.result.regular.RegularExamResultSingleStudentResponse;
import in.targetpeak.api.entity.result.regular.RegularExamResultStudentHolder;
import in.targetpeak.api.entity.result.regular.RegularExamResultStudentListResponse;
import in.targetpeak.api.entity.result.regular.RegularExamStudentListRequest;
import in.targetpeak.api.entity.result.regular.ui.StudentRegularResultDetail;

public interface ResultDao {

	
	public RegularExamResultSingleStudentResponse getRegularExamResultStudent(RegularExamResultRequest request);
	
	public RegularExamResultStudentListResponse getRegularExamResultStudentTemp(RegularExamResultRequest request);
	
	public List<StudentRegularResultDetail> getStudentRegularResultDetails(String extraSubject1, String extraSubject2,
			RegularExamStudentListRequest request);
	
	public List<RegularExamResultStudentHolder> getSubjectWiseStudentRegularResultDetails(RegularExamStudentListRequest request);
	
	
	//------ PEAK REGION
	public PeakExamResultStudentListResponse getPeakExamResultStudent(PeakExamResultRequest request);
	
	public List<PeakExamResultStudentHolder> getSubjectWiseStudentPeakResultDetails(PeakExamStudentListRequest request);

	
	public PeakExamStatusListResponse getPeakExamStatus(PeakExamResultStatusRequest request);
	
	public RankPeakResulListResponse getRankPeakExamResult(int Action, int ClassId);
	
	public PeakExamFinalResultListResponse getPeakExamStudentFinalResult(int Action,int pStudentId, int ClassId,int instituteId,int organizationId);

}
