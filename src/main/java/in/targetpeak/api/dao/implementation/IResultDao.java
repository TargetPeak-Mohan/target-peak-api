package in.targetpeak.api.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.targetpeak.api.dao.ResultDao;
import in.targetpeak.api.dao.UserDao;
import in.targetpeak.api.entity.exam.peak.PeakExamFinalResultHolder;
import in.targetpeak.api.entity.exam.peak.PeakExamFinalResultListResponse;
import in.targetpeak.api.entity.exam.peak.PeakExamResultHolder;
import in.targetpeak.api.entity.exam.peak.PeakExamResultListResponse;
import in.targetpeak.api.entity.exam.peak.PeakExamResultStatusRequest;
import in.targetpeak.api.entity.exam.peak.rank.RankPeakResulListResponse;
import in.targetpeak.api.entity.exam.peak.rank.RankPeakResultHolder;
import in.targetpeak.api.entity.result.peak.PeakExamResultRequest;
import in.targetpeak.api.entity.result.peak.PeakExamResultStudentHolder;
import in.targetpeak.api.entity.result.peak.PeakExamResultStudentListResponse;
import in.targetpeak.api.entity.result.peak.PeakExamStatusHolder;
import in.targetpeak.api.entity.result.peak.PeakExamStatusListResponse;
import in.targetpeak.api.entity.result.peak.PeakExamStudentListRequest;
import in.targetpeak.api.entity.result.regular.RegularExamResultRequest;
import in.targetpeak.api.entity.result.regular.RegularExamResultSingleStudentResponse;
import in.targetpeak.api.entity.result.regular.RegularExamResultStudentHolder;
import in.targetpeak.api.entity.result.regular.RegularExamResultStudentListResponse;
import in.targetpeak.api.entity.result.regular.RegularExamSingleStudentHolder;
import in.targetpeak.api.entity.result.regular.RegularExamStudentListRequest;
import in.targetpeak.api.entity.result.regular.ui.StudentPaperResultDetail;
import in.targetpeak.api.entity.result.regular.ui.StudentRegularResultDetail;
import in.targetpeak.api.entity.student.StudentWithStatusHolder;
import in.targetpeak.api.entity.student.StudentWithStatusListRequest;
import in.targetpeak.api.entity.student.StudentWithStatusListResponse;
import in.targetpeak.api.util.ExamUtils;
import in.targetpeak.api.util.IntergerToWordConvertor;

@Repository
public class IResultDao implements ResultDao {

	String TAG = "IResultDao";

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private UserDao userDao;

	@SuppressWarnings("unchecked")
	public RegularExamResultSingleStudentResponse getRegularExamResultStudent(RegularExamResultRequest request) {

		RegularExamResultSingleStudentResponse responseOutput = new RegularExamResultSingleStudentResponse();
		List<RegularExamSingleStudentHolder> responseArray = null;

		// Request & pAction Parameter Checking
		if (request == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Invalid request ");
			responseOutput.setHasError(1);
		} else if (request.getAction() == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Action parameter missing ");
			responseOutput.setHasError(1);
		} else {

			try {
				StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("App_Exam_FetchResults",
						RegularExamSingleStudentHolder.class);

				/*
				 * Input Parameters with conditions
				 */

				procedureQuery.registerStoredProcedureParameter("pAttendantId", Integer.class, ParameterMode.IN)
						.setParameter("pAttendantId", request.getAttendantId() == null ? 0 : request.getAttendantId());
				procedureQuery.registerStoredProcedureParameter("pAttendantRoleId", Integer.class, ParameterMode.IN)
						.setParameter("pAttendantRoleId",
								request.getAttendantRoleId() == null ? 0 : request.getAttendantRoleId());
				procedureQuery.registerStoredProcedureParameter("pAction", Integer.class, ParameterMode.IN)
						.setParameter("pAction", request.getAction() == null ? 0 : request.getAction());

				procedureQuery.registerStoredProcedureParameter("pExaminationId", Integer.class, ParameterMode.IN)
						.setParameter("pExaminationId",
								request.getExaminationId() == null ? 0 : request.getExaminationId());
				procedureQuery.registerStoredProcedureParameter("pSubjectId", Integer.class, ParameterMode.IN)
						.setParameter("pSubjectId", request.getSubjectId() == null ? 0 : request.getSubjectId());
				procedureQuery.registerStoredProcedureParameter("pStudentId", Integer.class, ParameterMode.IN)
						.setParameter("pStudentId", request.getStudentId() == null ? 0 : request.getStudentId());

				procedureQuery.registerStoredProcedureParameter("pOrganizationId", Integer.class, ParameterMode.IN)
						.setParameter("pOrganizationId",
								request.getOrganizationId() == null ? 0 : request.getOrganizationId());
				procedureQuery.registerStoredProcedureParameter("pInstituteId", Integer.class, ParameterMode.IN)
						.setParameter("pInstituteId", request.getInstituteId() == null ? 0 : request.getInstituteId());
				procedureQuery.registerStoredProcedureParameter("pClassId", Integer.class, ParameterMode.IN)
						.setParameter("pClassId", request.getClassId() == null ? 0 : request.getClassId());
				procedureQuery.registerStoredProcedureParameter("pDivisionId", Integer.class, ParameterMode.IN)
						.setParameter("pDivisionId", request.getDivisionId() == null ? 0 : request.getDivisionId());

				procedureQuery.registerStoredProcedureParameter("pRecordStatus", Integer.class, ParameterMode.IN)
						.setParameter("pRecordStatus",
								request.getRecordStatus() == null ? 0 : request.getRecordStatus());
				procedureQuery.registerStoredProcedureParameter("pOffset", Integer.class, ParameterMode.IN)
						.setParameter("pOffset", request.getOffset() == null ? 0 : request.getOffset());
				procedureQuery.registerStoredProcedureParameter("pLimit", Integer.class, ParameterMode.IN)
						.setParameter("pLimit", request.getLimit() == null ? 100 : request.getLimit());
				procedureQuery.registerStoredProcedureParameter("pSearch", String.class, ParameterMode.IN)
						.setParameter("pSearch", request.getSearch() == null ? "" : request.getSearch());
				procedureQuery.registerStoredProcedureParameter("pSyncDate", String.class, ParameterMode.IN)
						.setParameter("pSyncDate", request.getSyncDate() == null ? "" : request.getSyncDate());

				/*
				 * Stored Procedure Execution
				 */

				procedureQuery.execute();
				responseArray = procedureQuery.getResultList();

				// Checking For Empty Response
				if (responseArray.isEmpty() || responseArray == null) {
					responseOutput.setResponseArray(responseArray);
					responseOutput.setResult(0);
					responseOutput.setMessage("No Data Exists");
					responseOutput.setHasError(1);
				} else {
					responseOutput.setResponseArray(responseArray);
					responseOutput.setResult(responseArray.size());
					responseOutput.setMessage("Data Fetch Successfully");
					responseOutput.setHasError(0);
				}

			} catch (Exception e) {
				// Checking For Exception
				responseOutput.setResponseArray(responseArray);
				responseOutput.setResult(0);
				responseOutput.setMessage("Database Error " + e);
				responseOutput.setHasError(1);
			}

		}

		return responseOutput;

	}

	@SuppressWarnings("unchecked")
	public RegularExamResultStudentListResponse getRegularExamResultStudentTemp(RegularExamResultRequest request) {

		RegularExamResultStudentListResponse responseOutput = new RegularExamResultStudentListResponse();
		List<RegularExamResultStudentHolder> responseArray = null;

		// System.out.println("Request:"+request.toString());

		// Request & pAction Parameter Checking
		if (request == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Invalid request ");
			responseOutput.setHasError(1);
		} else if (request.getAction() == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Action parameter missing ");
			responseOutput.setHasError(1);
		} else {

			try {
				StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("App_Exam_FetchResults",
						RegularExamResultStudentHolder.class);

				/*
				 * Input Parameters with conditions
				 */

				procedureQuery.registerStoredProcedureParameter("pAttendantId", Integer.class, ParameterMode.IN)
						.setParameter("pAttendantId", request.getAttendantId() == null ? 0 : request.getAttendantId());
				procedureQuery.registerStoredProcedureParameter("pAttendantRoleId", Integer.class, ParameterMode.IN)
						.setParameter("pAttendantRoleId",
								request.getAttendantRoleId() == null ? 0 : request.getAttendantRoleId());
				procedureQuery.registerStoredProcedureParameter("pAction", Integer.class, ParameterMode.IN)
						.setParameter("pAction", request.getAction() == null ? 0 : request.getAction());

				procedureQuery.registerStoredProcedureParameter("pExaminationId", Integer.class, ParameterMode.IN)
						.setParameter("pExaminationId",
								request.getExaminationId() == null ? 0 : request.getExaminationId());
				procedureQuery.registerStoredProcedureParameter("pSubjectId", Integer.class, ParameterMode.IN)
						.setParameter("pSubjectId", request.getSubjectId() == null ? 0 : request.getSubjectId());
				procedureQuery.registerStoredProcedureParameter("pStudentId", Integer.class, ParameterMode.IN)
						.setParameter("pStudentId", request.getStudentId() == null ? 0 : request.getStudentId());

				procedureQuery.registerStoredProcedureParameter("pOrganizationId", Integer.class, ParameterMode.IN)
						.setParameter("pOrganizationId",
								request.getOrganizationId() == null ? 0 : request.getOrganizationId());
				procedureQuery.registerStoredProcedureParameter("pInstituteId", Integer.class, ParameterMode.IN)
						.setParameter("pInstituteId", request.getInstituteId() == null ? 0 : request.getInstituteId());
				procedureQuery.registerStoredProcedureParameter("pClassId", Integer.class, ParameterMode.IN)
						.setParameter("pClassId", request.getClassId() == null ? 0 : request.getClassId());
				procedureQuery.registerStoredProcedureParameter("pDivisionId", Integer.class, ParameterMode.IN)
						.setParameter("pDivisionId", request.getDivisionId() == null ? 0 : request.getDivisionId());

				procedureQuery.registerStoredProcedureParameter("pRecordStatus", Integer.class, ParameterMode.IN)
						.setParameter("pRecordStatus",
								request.getRecordStatus() == null ? 0 : request.getRecordStatus());
				procedureQuery.registerStoredProcedureParameter("pOffset", Integer.class, ParameterMode.IN)
						.setParameter("pOffset", request.getOffset() == null ? 0 : request.getOffset());
				procedureQuery.registerStoredProcedureParameter("pLimit", Integer.class, ParameterMode.IN)
						.setParameter("pLimit", request.getLimit() == null ? 100 : request.getLimit());
				procedureQuery.registerStoredProcedureParameter("pSearch", String.class, ParameterMode.IN)
						.setParameter("pSearch", request.getSearch() == null ? "" : request.getSearch());
				procedureQuery.registerStoredProcedureParameter("pSyncDate", String.class, ParameterMode.IN)
						.setParameter("pSyncDate", request.getSyncDate() == null ? "" : request.getSyncDate());

				/*
				 * Stored Procedure Execution
				 */

				procedureQuery.execute();
				responseArray = procedureQuery.getResultList();

				// Checking For Empty Response
				if (responseArray.isEmpty() || responseArray == null) {
					responseOutput.setResponseArray(responseArray);
					responseOutput.setResult(0);
					responseOutput.setMessage("No Data Exists");
					responseOutput.setHasError(1);
				} else {
					responseOutput.setResponseArray(responseArray);
					responseOutput.setResult(responseArray.size());
					responseOutput.setMessage("Data Fetch Successfully");
					responseOutput.setHasError(0);
				}

			} catch (Exception e) {
				// Checking For Exception
				responseOutput.setResponseArray(responseArray);
				responseOutput.setResult(0);
				responseOutput.setMessage("Database Error " + e);
				responseOutput.setHasError(1);
			}

		}

		return responseOutput;

	}

	public List<StudentRegularResultDetail> getStudentRegularResultDetails(String extraSubject1, String extraSubject2,
			RegularExamStudentListRequest request) {
		// --Adding Extra Subjects If Needed
		// String extraSubject1 = "EVS";
		// String extraSubject2 = "PHYSICAL EDUCATION";

		List<StudentRegularResultDetail> studentDetails = new ArrayList<StudentRegularResultDetail>();

		// ----- START -----

		// --Collecting RequestParameters
		int _instituteId = request.getInstituteId();
		int _organizationId = request.getOrganizationId();
		int _classId = request.getClassId();
		int _divisionId = request.getDivisionId();
		int _examinationId = request.getExaminationId();

		// --Getting StudentData
		StudentWithStatusListRequest statusListRequest = new StudentWithStatusListRequest(1, 4, 2, 0, 0, _instituteId,
				_organizationId, _classId, _divisionId, "", 0, 0, 0, 1000, "", "");
		System.out.println("Request:" + statusListRequest.toString());
		StudentWithStatusListResponse studentWithStatusListResponse = userDao.getStudentsForTeachers(statusListRequest);
		List<StudentWithStatusHolder> studentWithStatusHolders = studentWithStatusListResponse.getResponseArray();

		for (StudentWithStatusHolder studentWithStatusHolder : studentWithStatusHolders) {

			// --Filling ResultRequired-RequestParameters
			int _studentId = studentWithStatusHolder.getStudentId();
			String _rollNo = studentWithStatusHolder.getRollNo();
			String _studentName = studentWithStatusHolder.getStudentName();
			String _motherName = studentWithStatusHolder.getMothersName();
			String _gender = studentWithStatusHolder.getGender() == 1 ? "Male" : "Female";
			List<StudentPaperResultDetail> _studentPaperResultDetails = new ArrayList<StudentPaperResultDetail>();
			Integer _maximumMarks = 0;
			Integer _obtainedMarks = 0;
			String _percentage = "0%";
			String _result = "Pass";

			// --Getting StudentWise-SubjectWise-ResultList
			RegularExamResultRequest examResultRequest = new RegularExamResultRequest(1, 5, 4, _examinationId, 0,
					_studentId, 0, 0, 0, 0, 1, 0, 100, "", "");
			RegularExamResultStudentListResponse regularExamResultStudentListResponse = getRegularExamResultStudentTemp(
					examResultRequest);

			List<RegularExamResultStudentHolder> examResultStudentHolders = regularExamResultStudentListResponse
					.getResponseArray();

			// --DECLARATION-PARAMETERS TO ADD AFTER LOOP
			int i;
			int totalMarks = 0;
			int makrsObtained = 0;
			boolean isPass = true;

			// List<ExamResultUiHolder> _examResultUiHolders = new
			// ArrayList<ExamResultUiHolder>();

			ArrayList<String> paperNames = new ArrayList<String>();

			for (i = 0; i < examResultStudentHolders.size(); i++) {

				// --MAKING OF MODEL CLASS
				RegularExamResultStudentHolder examResultStudentHolder = examResultStudentHolders.get(i);

				// -----Check forexisting subjects
				String currentPaperName = examResultStudentHolder.getPaperName();
				if (paperNames.contains(currentPaperName)) {

				} else {

					Integer serialNo = (i + 1);
					String paperName = examResultStudentHolder.getPaperName();
					String maxMarks = String.valueOf((int) examResultStudentHolder.getMaxMarks());
					String examScore = String.valueOf((int) examResultStudentHolder.getExamScore());
					String obtainedInWords = IntergerToWordConvertor
							.convertWithCasing(examResultStudentHolder.getExamScore());
					String resultRemark = examResultStudentHolder.getResultRemark();

					// --DEFINATION-PARAMETERS TO ADD AFTER LOOP
					if (examResultStudentHolder.getResultRemark().equals("Fail"))
						isPass = false;
					totalMarks = totalMarks + (int) examResultStudentHolder.getMaxMarks();
					makrsObtained = makrsObtained + (int) examResultStudentHolder.getExamScore();

					StudentPaperResultDetail studentPaperResultDetails = new StudentPaperResultDetail(serialNo,
							paperName, maxMarks, examScore, obtainedInWords, resultRemark);
					_studentPaperResultDetails.add(studentPaperResultDetails);
					paperNames.add(paperName);
				}

			}

			// ----- ADDING TWO EXTRA PAPERS -----
			_studentPaperResultDetails.add(new StudentPaperResultDetail((i + 1), extraSubject1, "", "", "", ""));
			_studentPaperResultDetails.add(new StudentPaperResultDetail((i + 2), extraSubject2, "", "", "", ""));

			_maximumMarks = totalMarks;
			_obtainedMarks = makrsObtained;
			_percentage = ExamUtils.getPercentage(makrsObtained, totalMarks);
			_result = isPass ? ExamUtils.getResultStatus(makrsObtained, totalMarks) : "ATKT";

			// --Adding EachStudent Result - StduentsList
			StudentRegularResultDetail studentDetail = new StudentRegularResultDetail(_rollNo, _studentName,
					_motherName, _gender, _studentPaperResultDetails, _maximumMarks, _obtainedMarks, _percentage,
					_result);
			studentDetails.add(studentDetail);
		}

		// ----- END -----

		return studentDetails;
	}

	public List<RegularExamResultStudentHolder> getSubjectWiseStudentRegularResultDetails(
			RegularExamStudentListRequest request) {

		// ----- START -----

		// --Collecting RequestParameters
		int _instituteId = request.getInstituteId();
		int _organizationId = request.getOrganizationId();
		int _classId = request.getClassId();
		int _divisionId = request.getDivisionId();
		int _subjectId = request.getSubjectId();
		int _examinationId = request.getExaminationId();

		RegularExamResultRequest examResultRequest = new RegularExamResultRequest(1, 5, 3, _examinationId, _subjectId,
				0, _organizationId, _instituteId, _classId, _divisionId, 1, 0, 100, "", "");
		RegularExamResultStudentListResponse regularExamResultStudentListResponse = new RegularExamResultStudentListResponse();
		regularExamResultStudentListResponse = getRegularExamResultStudentTemp(examResultRequest);
		List<RegularExamResultStudentHolder> examResultStudentHolders = new ArrayList<RegularExamResultStudentHolder>();
		examResultStudentHolders = regularExamResultStudentListResponse.getResponseArray();

		System.out.println("DAO:" + examResultStudentHolders.toString());

		// ----- END -----

		return examResultStudentHolders;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PeakExamResultStudentListResponse getPeakExamResultStudent(PeakExamResultRequest request) {
		PeakExamResultStudentListResponse responseOutput = new PeakExamResultStudentListResponse();
		List<PeakExamResultStudentHolder> responseArray = null;

		// Request & pAction Parameter Checking
		if (request == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Invalid request ");
			responseOutput.setHasError(1);
		} else if (request.getAction() == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Action parameter missing ");
			responseOutput.setHasError(1);
		} else {

			try {
				StoredProcedureQuery procedureQuery = entityManager
						.createStoredProcedureQuery("App_Exam_Peak_FetchResults", PeakExamResultStudentHolder.class);

				/*
				 * Input Parameters with conditions
				 */

				procedureQuery.registerStoredProcedureParameter("pAttendantId", Integer.class, ParameterMode.IN)
						.setParameter("pAttendantId", request.getAttendantId() == null ? 0 : request.getAttendantId());
				procedureQuery.registerStoredProcedureParameter("pAttendantRoleId", Integer.class, ParameterMode.IN)
						.setParameter("pAttendantRoleId",
								request.getAttendantRoleId() == null ? 0 : request.getAttendantRoleId());
				procedureQuery.registerStoredProcedureParameter("pAction", Integer.class, ParameterMode.IN)
						.setParameter("pAction", request.getAction() == null ? 0 : request.getAction());

				procedureQuery.registerStoredProcedureParameter("pExaminationId", Integer.class, ParameterMode.IN)
						.setParameter("pExaminationId",
								request.getExaminationId() == null ? 0 : request.getExaminationId());
				procedureQuery.registerStoredProcedureParameter("pSubjectId", Integer.class, ParameterMode.IN)
						.setParameter("pSubjectId", request.getSubjectId() == null ? 0 : request.getSubjectId());
				procedureQuery.registerStoredProcedureParameter("pStudentId", Integer.class, ParameterMode.IN)
						.setParameter("pStudentId", request.getStudentId() == null ? 0 : request.getStudentId());

				procedureQuery.registerStoredProcedureParameter("pOrganizationId", Integer.class, ParameterMode.IN)
						.setParameter("pOrganizationId",
								request.getOrganizationId() == null ? 0 : request.getOrganizationId());
				procedureQuery.registerStoredProcedureParameter("pInstituteId", Integer.class, ParameterMode.IN)
						.setParameter("pInstituteId", request.getInstituteId() == null ? 0 : request.getInstituteId());
				procedureQuery.registerStoredProcedureParameter("pClassId", Integer.class, ParameterMode.IN)
						.setParameter("pClassId", request.getClassId() == null ? 0 : request.getClassId());
				procedureQuery.registerStoredProcedureParameter("pDivisionId", Integer.class, ParameterMode.IN)
						.setParameter("pDivisionId", request.getDivisionId() == null ? 0 : request.getDivisionId());

				procedureQuery.registerStoredProcedureParameter("pRecordStatus", Integer.class, ParameterMode.IN)
						.setParameter("pRecordStatus",
								request.getRecordStatus() == null ? 0 : request.getRecordStatus());
				procedureQuery.registerStoredProcedureParameter("pOffset", Integer.class, ParameterMode.IN)
						.setParameter("pOffset", request.getOffset() == null ? 0 : request.getOffset());
				procedureQuery.registerStoredProcedureParameter("pLimit", Integer.class, ParameterMode.IN)
						.setParameter("pLimit", request.getLimit() == null ? 100 : request.getLimit());
				procedureQuery.registerStoredProcedureParameter("pSearch", String.class, ParameterMode.IN)
						.setParameter("pSearch", request.getSearch() == null ? "" : request.getSearch());
				procedureQuery.registerStoredProcedureParameter("pSyncDate", String.class, ParameterMode.IN)
						.setParameter("pSyncDate", request.getSyncDate() == null ? "" : request.getSyncDate());

				/*
				 * Stored Procedure Execution
				 */

				procedureQuery.execute();
				responseArray = procedureQuery.getResultList();

				// Checking For Empty Response
				if (responseArray.isEmpty() || responseArray == null) {
					responseOutput.setResponseArray(responseArray);
					responseOutput.setResult(0);
					responseOutput.setMessage("No Data Exists");
					responseOutput.setHasError(1);
				} else {
					responseOutput.setResponseArray(responseArray);
					responseOutput.setResult(responseArray.size());
					responseOutput.setMessage("Data Fetch Successfully");
					responseOutput.setHasError(0);
				}

			} catch (Exception e) {
				// Checking For Exception
				System.err.println(e);
				responseOutput.setResponseArray(responseArray);
				responseOutput.setResult(0);
				responseOutput.setMessage("Database Error " + e);
				responseOutput.setHasError(1);
			}

		}

		return responseOutput;
	}

	@Override
	public List<PeakExamResultStudentHolder> getSubjectWiseStudentPeakResultDetails(
			PeakExamStudentListRequest request) {
		// ----- START -----

		// --Collecting RequestParameters
		int _instituteId = request.getInstituteId();
		int _organizationId = request.getOrganizationId();
		int _classId = request.getClassId();
		int _divisionId = request.getDivisionId();
		int _subjectId = request.getSubjectId();
		int _examinationId = request.getExaminationId();

		PeakExamResultRequest examResultRequest = new PeakExamResultRequest(1, 5, 3, _examinationId, _subjectId, 0,
				_organizationId, _instituteId, _classId, _divisionId, 1, 0, 100, "", "");

		PeakExamResultStudentListResponse peakExamResultStudentListResponse = getPeakExamResultStudent(
				examResultRequest);
		List<PeakExamResultStudentHolder> examResultStudentHolders = peakExamResultStudentListResponse
				.getResponseArray();

		System.out.println("DAO:" + examResultStudentHolders.toString());

		// ----- END -----

		return examResultStudentHolders;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PeakExamStatusListResponse getPeakExamStatus(PeakExamResultStatusRequest request) {
		PeakExamStatusListResponse responseOutput = new PeakExamStatusListResponse();
		List<PeakExamStatusHolder> responseArray = null;

		// Request & pAction Parameter Checking
		if (request == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Invalid request ");
			responseOutput.setHasError(1);
		} else if (request.getAction() == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Action parameter missing ");
			responseOutput.setHasError(1);
		} else {

			try {
				StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("Exam_FetchPeakResults",
						PeakExamStatusHolder.class);

				/*
				 * Input Parameters with conditions
				 */

				procedureQuery.registerStoredProcedureParameter("pAction", Integer.class, ParameterMode.IN)
						.setParameter("pAction", request.getAction() == null ? 0 : request.getAction());

				procedureQuery.registerStoredProcedureParameter("pOrganizationId", Integer.class, ParameterMode.IN)
						.setParameter("pOrganizationId",
								request.getOrganizationId() == null ? 0 : request.getOrganizationId());

				procedureQuery.registerStoredProcedureParameter("pInstituteId", Integer.class, ParameterMode.IN)
						.setParameter("pInstituteId", request.getInstituteId() == null ? 0 : request.getInstituteId());

				procedureQuery.registerStoredProcedureParameter("pClassId", Integer.class, ParameterMode.IN)
						.setParameter("pClassId", request.getClassId() == null ? 0 : request.getClassId());

				procedureQuery.registerStoredProcedureParameter("pDivisionId", Integer.class, ParameterMode.IN)
						.setParameter("pDivisionId", request.getDivisionId() == null ? 0 : request.getDivisionId());

				procedureQuery.registerStoredProcedureParameter("pQuestionPaperId", Integer.class, ParameterMode.IN)
						.setParameter("pQuestionPaperId",
								request.getQuestionPaperId() == null ? 0 : request.getQuestionPaperId());

				procedureQuery.registerStoredProcedureParameter("pRecordStatus", Integer.class, ParameterMode.IN)
						.setParameter("pRecordStatus",
								request.getRecordStatus() == null ? 0 : request.getRecordStatus());
				procedureQuery.registerStoredProcedureParameter("pOffset", Integer.class, ParameterMode.IN)
						.setParameter("pOffset", request.getOffset() == null ? 0 : request.getOffset());
				procedureQuery.registerStoredProcedureParameter("pLimit", Integer.class, ParameterMode.IN)
						.setParameter("pLimit", request.getLimit() == null ? 500 : request.getLimit());

				procedureQuery.registerStoredProcedureParameter("pSearch", String.class, ParameterMode.IN)
						.setParameter("pSearch", request.getSearch() == null ? "" : request.getSearch());

				procedureQuery.registerStoredProcedureParameter("pSyncDate", String.class, ParameterMode.IN)
						.setParameter("pSyncDate", request.getSyncDate() == null ? "" : request.getSyncDate());

				/*
				 * Stored Procedure Execution
				 */

				procedureQuery.execute();
				responseArray = procedureQuery.getResultList();
				System.out.println(responseArray.toString());

				// Checking For Empty Response
				if (responseArray.isEmpty() || responseArray == null) {
					responseOutput.setResponseArray(responseArray);
					responseOutput.setResult(0);
					responseOutput.setMessage("No Data Exists");
					responseOutput.setHasError(1);
				} else {
					responseOutput.setResponseArray(responseArray);
					responseOutput.setResult(responseArray.size());
					responseOutput.setMessage("Data Fetch Successfully");
					responseOutput.setHasError(0);
					System.out.println("Available");

				}

			} catch (Exception e) {
				// Checking For Exception
				responseOutput.setResponseArray(responseArray);
				responseOutput.setResult(0);
				responseOutput.setMessage("Database Error " + e);
				responseOutput.setHasError(1);
			}

		}

		return responseOutput;
	}

	@SuppressWarnings("unchecked")
	@Override
	public RankPeakResulListResponse getRankPeakExamResult(int Action, int ClassId) {
		RankPeakResulListResponse responseOutput = new RankPeakResulListResponse();
		List<RankPeakResultHolder> responseArray = null;

		try {
			StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("App_Exam_FetchPeakTopers",
					RankPeakResultHolder.class);

			/*
			 * Input Parameters with conditions
			 */

			procedureQuery.registerStoredProcedureParameter("pAction", Integer.class, ParameterMode.IN)
					.setParameter("pAction", Action);

			procedureQuery.registerStoredProcedureParameter("pClassId", Integer.class, ParameterMode.IN)
					.setParameter("pClassId", ClassId);
			/*
			 * Stored Procedure Execution
			 */

			procedureQuery.execute();
			responseArray = procedureQuery.getResultList();
			System.out.println(responseArray.toString());

			// Checking For Empty Response
			if (responseArray.isEmpty() || responseArray == null) {
				responseOutput.setResponseArray(responseArray);
				responseOutput.setResult(0);
				responseOutput.setMessage("No Data Exists");
				responseOutput.setHasError(1);
			} else {
				responseOutput.setResponseArray(responseArray);
				responseOutput.setResult(responseArray.size());
				responseOutput.setMessage("Data Fetch Successfully");
				responseOutput.setHasError(0);
				System.out.println("Available");

			}

		} catch (Exception e) {
			System.err.println(e);
			// Checking For Exception
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Database Error " + e);
			responseOutput.setHasError(1);
		}

		return responseOutput;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PeakExamFinalResultListResponse getPeakExamStudentFinalResult(int Action, int StudentId, int ClassId,int InstituteId,int organizationId) {
		PeakExamFinalResultListResponse responseOutput = new PeakExamFinalResultListResponse();
		List<PeakExamFinalResultHolder> responseArray = null;

		try {
			StoredProcedureQuery procedureQuery = entityManager
					.createStoredProcedureQuery("App_Exam_Peak_FetchFinalResult", PeakExamFinalResultHolder.class);

			/*
			 * Input Parameters with conditions
			 */

			procedureQuery.registerStoredProcedureParameter("pAction", Integer.class, ParameterMode.IN)
					.setParameter("pAction", Action);

			procedureQuery.registerStoredProcedureParameter("pStudentId", Integer.class, ParameterMode.IN)
					.setParameter("pStudentId", StudentId);

			procedureQuery.registerStoredProcedureParameter("pClassId", Integer.class, ParameterMode.IN)
					.setParameter("pClassId", ClassId);
			
			procedureQuery.registerStoredProcedureParameter("pInstituteId", Integer.class, ParameterMode.IN)
			.setParameter("pInstituteId", InstituteId);
			
			procedureQuery.registerStoredProcedureParameter("pOrganizationId", Integer.class, ParameterMode.IN)
			.setParameter("pOrganizationId", organizationId);
			/*
			 * Stored Procedure Execution
			 */

			procedureQuery.execute();
			responseArray = procedureQuery.getResultList();
			System.out.println("IDaoResult:" + responseArray.toString());

			// Checking For Empty Response
			if (responseArray.isEmpty() || responseArray == null) {
				responseOutput.setResponseArray(responseArray);
				responseOutput.setResult(0);
				responseOutput.setMessage("No Data Exists");
				responseOutput.setHasError(1);
			} else {
				responseOutput.setResponseArray(responseArray);
				responseOutput.setResult(responseArray.size());
				responseOutput.setMessage("Data Fetch Successfully");
				responseOutput.setHasError(0);
			}

		} catch (Exception e) {
			System.err.println(e);
			// Checking For Exception
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Database Error " + e);
			responseOutput.setHasError(1);
		}

		return responseOutput;
	}

}
