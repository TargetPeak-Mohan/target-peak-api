package in.targetpeak.api.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.targetpeak.api.dao.ResultDao;
import in.targetpeak.api.dao.UserDao;
import in.targetpeak.api.entity.result.ExamResultUiHolder;
import in.targetpeak.api.entity.result.peak.PeakExamResultRequest;
import in.targetpeak.api.entity.result.peak.PeakExamResultStudentHolder;
import in.targetpeak.api.entity.result.peak.PeakExamResultStudentListResponse;
import in.targetpeak.api.entity.result.peak.PeakExamStudentListRequest;
import in.targetpeak.api.entity.result.regular.RegularExamResultRequest;
import in.targetpeak.api.entity.result.regular.RegularExamResultStudentHolder;
import in.targetpeak.api.entity.result.regular.RegularExamResultStudentListResponse;
import in.targetpeak.api.entity.result.regular.RegularExamStudentListRequest;
import in.targetpeak.api.entity.result.regular.ui.StudentPaperResultDetail;
import in.targetpeak.api.entity.result.regular.ui.StudentRegularResultDetail;
import in.targetpeak.api.entity.student.StudentWithStatusHolder;
import in.targetpeak.api.entity.student.StudentWithStatusListRequest;
import in.targetpeak.api.entity.student.StudentWithStatusListResponse;
import in.targetpeak.api.entity.util.version.VersionListRequest;
import in.targetpeak.api.entity.util.version.VersionListResponse;
import in.targetpeak.api.service.UtilService;
import in.targetpeak.api.util.ExamUtils;
import in.targetpeak.api.util.IntergerToWordConvertor;
import io.swagger.annotations.Api;

@RequestMapping(value = "/util", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Util", value = "Version(Android-User,Android-Admin,Web-Panel) Resource REST Endpoint", description = "")
@RestController
public class UtilController {

	@Autowired
	private UtilService utilService;

	@Autowired
	private ResultDao resultDao;

	@Autowired
	private UserDao userDao;

	@GetMapping("/version")
	public VersionListResponse getVersionList(VersionListRequest request) {
		return utilService.getVersionList(request);
	}

//	@PostMapping("/test")
//	public RegularExamResultStudentListResponse getExamResultStudentListResponse(
//			@RequestBody RegularExamResultRequest examResultRequest) {
//		RegularExamResultStudentListResponse examResultStudentListResponse = resultDao
//				.getRegularExamResultStudent(examResultRequest);
//
//		List<RegularExamResultStudentHolder> resultStudentHolders = examResultStudentListResponse.getResponseArray();
//
////		Integer AttendantId = 1;
////		Integer AttendantRoleId = 4;
////		Integer Action = 2;
////
////		Integer StudentId = 0;
////		Integer UserId = 0;
////		// Integer InstituteId = instituteId;
////		// Integer OrganizationId = organizationId;
////		// Integer ClassId = classId;
////		// Integer DivisionId = divisionId;
////		String DOB = "";
////		Integer Gender = 0;
////
////		Integer RecordStatus = 0;
////		Integer Offset = 0;
////		Integer Limit = 1000;
////		String Search = "";
////		String SyncDate = "";
////		StudentWithStatusListRequest request = new StudentWithStatusListRequest(AttendantId, AttendantRoleId,
////				Action, StudentId, UserId, 892, 1, 11, 52, DOB, Gender,
////				RecordStatus, Offset, Limit, Search, SyncDate);
////		StudentWithStatusListResponse studentWithStatusListResponse = userDao.getStudentsForTeachers(request);
////		List<StudentWithStatusHolder> studentWithStatusHolders = studentWithStatusListResponse
////				.getResponseArray();
////		
////		
////		for (RegularExamResultStudentHolder regularExamResultStudentHolder : resultStudentHolders) {
////			
////		}
////		
////		
//
//		return examResultStudentListResponse;
//	}

//	@PostMapping("/students")
//	public List<StudentRegularResultDetail> studentWithStatusListResponse(
//			@RequestBody RegularExamStudentListRequest request) {
//
//		// --Adding Extra Subjects If Needed
//		String extraSubject1 = "EVS";
//		String extraSubject2 = "PHYSICAL EDUCATION";
//
//		List<StudentRegularResultDetail> studentDetails = new ArrayList<StudentRegularResultDetail>();
//
//		// ----- START -----
//
//		// --Collecting RequestParameters
//		int _instituteId = request.getInstituteId();
//		int _organizationId = request.getOrganizationId();
//		int _classId = request.getClassId();
//		int _divisionId = request.getDivisionId();
//		int _examinationId = request.getExaminationId();
//
//		// --Getting StudentData
//		StudentWithStatusListRequest statusListRequest = new StudentWithStatusListRequest(1, 4, 2, 0, 0, _instituteId,
//				_organizationId, _classId, _divisionId, "", 0, 0, 0, 1000, "", "");
//		StudentWithStatusListResponse studentWithStatusListResponse = userDao.getStudentsForTeachers(statusListRequest);
//		List<StudentWithStatusHolder> studentWithStatusHolders = studentWithStatusListResponse.getResponseArray();
//
//		for (StudentWithStatusHolder studentWithStatusHolder : studentWithStatusHolders) {
//
//			// --Filling ResultRequired-RequestParameters
//			int _studentId = studentWithStatusHolder.getStudentId();
//			String _rollNo = studentWithStatusHolder.getRollNo();
//			String _studentName = studentWithStatusHolder.getStudentName();
//			String _motherName = studentWithStatusHolder.getMothersName();
//			String _gender = studentWithStatusHolder.getGender() == 1 ? "Male" : "Female";
//			List<StudentPaperResultDetail> _studentPaperResultDetails = new ArrayList<StudentPaperResultDetail>();
//			Integer _maximumMarks = 0;
//			Integer _obtainedMarks = 0;
//			String _percentage = "0%";
//			String _result = "Pass";
//
//			// --Getting StudentWise-SubjectWise-ResultList
//			RegularExamResultRequest examResultRequest = new RegularExamResultRequest(1, 5, 1, _examinationId, 0,
//					_studentId, 0, 0, 0, 0, 1, 0, 100, "", "");
//			RegularExamResultStudentListResponse regularExamResultStudentListResponse = resultDao
//					.getRegularExamResultStudent(examResultRequest);
//			List<RegularExamResultStudentHolder> examResultStudentHolders = regularExamResultStudentListResponse
//					.getResponseArray();
//
//			// --Making Final ResultUIHolder
//			int i;
//			int totalMarks = 0;
//			int makrsObtained = 0;
//			boolean isPass = true;
//
//			// List<ExamResultUiHolder> _examResultUiHolders = new
//			// ArrayList<ExamResultUiHolder>();
//			for (i = 0; i < examResultStudentHolders.size(); i++) {
//
//				// --MAKING OF MODEL CLASS
//				RegularExamResultStudentHolder examResultStudentHolder = examResultStudentHolders.get(i);
//				Integer serialNo = (i + 1);
//				String paperName = examResultStudentHolder.getPaperName();
//				;
//				String maxMarks = String.valueOf((int) examResultStudentHolder.getMaxMarks());
//				String examScore = String.valueOf((int) examResultStudentHolder.getExamScore());
//				String obtainedInWords = IntergerToWordConvertor
//						.convertWithCasing(examResultStudentHolder.getExamScore());
//				String resultRemark = examResultStudentHolder.getResultRemark();
//
//				// --PARAMETERS TO ADD AFTER LOOP
//				if (examResultStudentHolder.getResultRemark().equals("Fail"))
//					isPass = false;
//				totalMarks = totalMarks + (int) examResultStudentHolder.getMaxMarks();
//				makrsObtained = makrsObtained + (int) examResultStudentHolder.getExamScore();
//
//				StudentPaperResultDetail studentPaperResultDetails = new StudentPaperResultDetail(serialNo, paperName,
//						maxMarks, examScore, obtainedInWords, resultRemark);
//				_studentPaperResultDetails.add(studentPaperResultDetails);
//			}
//
//			// ----- ADDING TWO EXTRA PAPERS -----
//			_studentPaperResultDetails.add(new StudentPaperResultDetail((i + 1), extraSubject1, "", "", "", ""));
//			_studentPaperResultDetails.add(new StudentPaperResultDetail((i + 2), extraSubject2, "", "", "", ""));
//
//			_maximumMarks = totalMarks;
//			_obtainedMarks = makrsObtained;
//			_percentage = ExamUtils.getPercentage(makrsObtained, totalMarks);
//			_result = isPass ? ExamUtils.getResultStatus(makrsObtained, totalMarks) : "ATKT";
//
//			// --Adding EachStudent Result - StduentsList
//			StudentRegularResultDetail studentDetail = new StudentRegularResultDetail(_rollNo, _studentName,
//					_motherName, _gender, _studentPaperResultDetails, _maximumMarks, _obtainedMarks, _percentage,
//					_result);
//			studentDetails.add(studentDetail);
//		}
//
//		// ----- END -----
//
//		return studentDetails;
//
//	}
//
//	@PostMapping("/students/subjects")
//	public List<RegularExamResultStudentHolder> getSubjectWiseStudentWithStatusListResponse(
//			@RequestBody RegularExamStudentListRequest request) {
//		// ----- START -----
//
//		// --Collecting RequestParameters
//		int _instituteId = request.getInstituteId();
//		int _organizationId = request.getOrganizationId();
//		int _classId = request.getClassId();
//		int _divisionId = request.getDivisionId();
//		int _subjectId = request.getSubjectId();
//		int _examinationId = request.getExaminationId();
//
//		RegularExamResultRequest examResultRequest = new RegularExamResultRequest(1, 5, 3, _examinationId, _subjectId,0,
//				_organizationId, _instituteId, _classId, _divisionId,
//				1, 0, 100, "", "");
//		RegularExamResultStudentListResponse regularExamResultStudentListResponse = resultDao.getRegularExamResultStudent(
//				examResultRequest);
//		List<RegularExamResultStudentHolder> examResultStudentHolders = regularExamResultStudentListResponse
//				.getResponseArray();
//
//		// ----- END -----
//
//		return examResultStudentHolders;
//
//	}
//	
//	@PostMapping("/peak/students/subjects")
//	public List<PeakExamResultStudentHolder> getSubjectWiseStudentWithStatusListResponse(
//			@RequestBody PeakExamStudentListRequest request) {
//		// ----- START -----
//
//		// --Collecting RequestParameters
//		int _instituteId = request.getInstituteId();
//		int _organizationId = request.getOrganizationId();
//		int _classId = request.getClassId();
//		int _divisionId = request.getDivisionId();
//		int _subjectId = request.getSubjectId();
//		int _examinationId = request.getExaminationId();
//
//		PeakExamResultRequest examResultRequest = new PeakExamResultRequest(1, 5, 3, _examinationId, _subjectId,0,
//				_organizationId, _instituteId, _classId, _divisionId,
//				1, 0, 100, "", "");
//		PeakExamResultStudentListResponse peakExamResultStudentListResponse = resultDao.getPeakExamResultStudent(examResultRequest);
//		List<PeakExamResultStudentHolder> examResultStudentHolders = peakExamResultStudentListResponse.getResponseArray();
//
//		// ----- END -----
//
//		return examResultStudentHolders;
//
//	}

}
