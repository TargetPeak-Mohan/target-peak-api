package in.targetpeak.api.service;

import in.targetpeak.api.callbacks.PeakResultCallback;
import in.targetpeak.api.dao.ExamDao;
import in.targetpeak.api.dao.ResultDao;
import in.targetpeak.api.dao.UserDao;
import in.targetpeak.api.dao.implementation.IMasterDao;
import in.targetpeak.api.entity.admin.students.TempStuddentListResponse;
import in.targetpeak.api.entity.admin.students.TempStudentHolder;
import in.targetpeak.api.entity.admin.students.TempStudentRequest;
import in.targetpeak.api.entity.admin.users.TempUserHolder;
import in.targetpeak.api.entity.admin.users.TempUserListResponse;
import in.targetpeak.api.entity.admin.users.TempUserRequest;
import in.targetpeak.api.entity.exam.peak.PeakExamFinalResultHolder;
import in.targetpeak.api.entity.exam.peak.PeakExamFinalResultListResponse;
import in.targetpeak.api.entity.exam.peak.PeakExamFinalResultRequest;
import in.targetpeak.api.entity.exam.peak.PeakExamResultHolder;
import in.targetpeak.api.entity.exam.peak.PeakExamResultStatusRequest;
import in.targetpeak.api.entity.exam.peak.PeakExamResultListResponse;
import in.targetpeak.api.entity.exam.peak.PeakExamStatusRequest;
import in.targetpeak.api.entity.exam.peak.rank.RankPeakResulListResponse;
import in.targetpeak.api.entity.exam.peak.rank.RankPeakResultHolder;
import in.targetpeak.api.entity.master.classs.ClassListRequest;
import in.targetpeak.api.entity.master.classs.SelectedClassHolder;
import in.targetpeak.api.entity.master.classs.SelectedClassListRepsonse;
import in.targetpeak.api.entity.master.institute.InstituteListRequest;
import in.targetpeak.api.entity.master.institute.InstituteListResponse;
import in.targetpeak.api.entity.master.subject.SubjectListRequest;
import in.targetpeak.api.entity.master.subject.SubjectListResponse;
import in.targetpeak.api.entity.result.ExamRegularResultJsonHolder;
import in.targetpeak.api.entity.result.ExamRegularResultUiHolder;
import in.targetpeak.api.entity.result.ExamResultHolder;
import in.targetpeak.api.entity.result.ExamResultListResponse;
import in.targetpeak.api.entity.result.ExamResultRequest;
import in.targetpeak.api.entity.result.ExamResultUiHolder;
import in.targetpeak.api.entity.result.peak.PeakExamResultStudentHolder;
import in.targetpeak.api.entity.result.peak.PeakExamStatusHolder;
import in.targetpeak.api.entity.result.peak.PeakExamStatusListResponse;
import in.targetpeak.api.entity.result.peak.PeakExamStudentListRequest;
import in.targetpeak.api.entity.result.peak.ui.StudentSubjectWisePeakResultJson;
import in.targetpeak.api.entity.result.regular.RegularExamResultRequest;
import in.targetpeak.api.entity.result.regular.RegularExamResultSingleStudentResponse;
import in.targetpeak.api.entity.result.regular.RegularExamResultStudentHolder;
import in.targetpeak.api.entity.result.regular.RegularExamResultStudentListResponse;
import in.targetpeak.api.entity.result.regular.RegularExamSingleStudentHolder;
import in.targetpeak.api.entity.result.regular.RegularExamStudentListRequest;
import in.targetpeak.api.entity.result.regular.RegularExamStudentRequest;
import in.targetpeak.api.entity.result.regular.ui.StudentRegularResultDetail;
import in.targetpeak.api.entity.result.regular.ui.StudentRegularResultJson;
import in.targetpeak.api.entity.result.regular.ui.StudentSubjectWiseRegularResultJson;
import in.targetpeak.api.entity.student.StudentWithStatusHolder;
import in.targetpeak.api.entity.student.StudentWithStatusListRequest;
import in.targetpeak.api.entity.student.StudentWithStatusListResponse;
import in.targetpeak.api.util.ExamUtils;
import in.targetpeak.api.util.IntergerToWordConvertor;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ResultService {

	/***
	 * ---------------------------------------------------------------------------
	 * DECLARATIONS
	 * ---------------------------------------------------------------------------
	 ***/
	@Autowired
	ExamDao examDao;

	@Autowired
	IMasterDao masterDao;

	@Autowired
	UserDao userDao;

	@Autowired
	ResultDao resultDao;

	/***
	 * ---------------------------------------------------------------------------
	 * MVP REGULAR EXAM REGION
	 * ---------------------------------------------------------------------------
	 ***/

	// ----- LIVE -----
	public String getRegularExamStudentResult(String extraSubject1, String extraSubject2,
			RegularExamStudentRequest request, Model model) {

		// -----NEEDED PARAMETERS
		int studentId = request.getStudentId();
		int examinationId = request.getExaminationId();

		// ----- FETCHING STUDENT DATA -----
		TempStudentRequest vRequest = new TempStudentRequest(studentId, 5, 3, 0, 0, "");
		TempStuddentListResponse tempStuddentListResponse = userDao.getAdminSearchStudents(vRequest);
		List<TempStudentHolder> tempStudentHolders = tempStuddentListResponse.getResponseArray();
		TempStudentHolder studentHolder = tempStudentHolders.get(0);

		// ----- PASSING PARAMETERS TO UI
		model.addAttribute("studentName", studentHolder.getStudentName());
		model.addAttribute("instituteName", studentHolder.getInstituteName());
		model.addAttribute("motherName", studentHolder.getMothersName());
		model.addAttribute("className", studentHolder.getClassName());
		model.addAttribute("divisionName", studentHolder.getDivisionName());
		int gender = studentHolder.getGender();
		if (gender == 1)
			model.addAttribute("gender", "Male");
		else if (gender == 2)
			model.addAttribute("gender", "Female");
		else
			model.addAttribute("gender", "Other");

		// ------ GETTING RESULT DATA ------
		RegularExamResultRequest examResultRequest = new RegularExamResultRequest(1, 5, 1, examinationId, 0, studentId,
				0, 0, 0, 0, 1, 0, 100, "", "");
		RegularExamResultSingleStudentResponse examResultStudentListResponse = resultDao
				.getRegularExamResultStudent(examResultRequest);

		System.out.println(examResultRequest.toString());

		if (examResultStudentListResponse.getHasError() == 1) {
			System.out.println(examResultStudentListResponse.getMessage());
			return getRegularExamErrorResult(model);
		} else {
			List<RegularExamSingleStudentHolder> examResultStudentHolders = examResultStudentListResponse
					.getResponseArray();
			// ----- Making of final UI output -----
			int i;
			int totalMarks = 0;
			int makrsObtained = 0;
			boolean isPass = true;

			List<ExamResultUiHolder> examResultUiHolders = new ArrayList<ExamResultUiHolder>();
			ArrayList<String> paperNames = new ArrayList<String>();

			for (i = 0; i < examResultStudentHolders.size(); i++) {
				RegularExamSingleStudentHolder examResultStudentHolder = examResultStudentHolders.get(i);

				// -----Check forexisting subjects
				String currentPaperName = examResultStudentHolder.getPaperName();
				if (paperNames.contains(currentPaperName)) {

				} else {
					Integer serialNo = (i + 1);
					String subjectName = examResultStudentHolder.getPaperName();
					String maxMarks = String.valueOf((int) examResultStudentHolder.getMaxMarks());
					String obtainedMarks = String.valueOf((int) examResultStudentHolder.getExamScore());
					String obtainedInWords = IntergerToWordConvertor
							.convertWithCasing(examResultStudentHolder.getExamScore());

					if (examResultStudentHolder.getResultRemark().equals("Fail"))
						isPass = false;
					totalMarks = totalMarks + (int) examResultStudentHolder.getMaxMarks();
					makrsObtained = makrsObtained + (int) examResultStudentHolder.getExamScore();

					ExamResultUiHolder examResultUiHolder = new ExamResultUiHolder(serialNo, subjectName, maxMarks,
							obtainedMarks, obtainedInWords);
					examResultUiHolders.add(examResultUiHolder);
					paperNames.add(currentPaperName);
				}

			}

			// ----- ADDING TWO EXTRA SUBJECTS -----
			examResultUiHolders.add(new ExamResultUiHolder((i + 1), extraSubject1, "", "", ""));
			examResultUiHolders.add(new ExamResultUiHolder((i + 2), extraSubject2, "", "", ""));

			model.addAttribute("maximumMarks", totalMarks);
			model.addAttribute("obtainedMarks", makrsObtained);
			model.addAttribute("obtainedMarksInWords", IntergerToWordConvertor.convertWithCasing(makrsObtained));

			model.addAttribute("percentage", ExamUtils.getPercentage(makrsObtained, totalMarks));
			model.addAttribute("result", isPass ? ExamUtils.getResultStatus(makrsObtained, totalMarks) : "ATKT");

			model.addAttribute("examResultUiHolders", examResultUiHolders);
		}

		return "pages/result/regular/mvp-student-result";
	}

	public String getRegularExamStudentsResultList(String extraSubject1, String extraSubject2,
			RegularExamStudentListRequest request, Model model) {

		try {

			System.out.println("Request:" + request.toString());

			// --FINAL MODEL-PASS-UI
			List<StudentRegularResultDetail> studentRegularResultDetails = new ArrayList<StudentRegularResultDetail>();
			// --NEEDED PARAMETERS
			int _instituteId = request.getInstituteId();
			int _organizationId = request.getOrganizationId();
			int _classId = request.getClassId();
			int _divisionId = request.getDivisionId();
			int _examinationId = request.getExaminationId();
			String _organizationName = request.getOrganizationName();
			String _instituteName = request.getInstituteName();
			String _className = request.getClassName();
			String _divisionName = request.getDivisionName();

			InstituteListRequest instituteListRequest = new InstituteListRequest(1, 4, 1, _instituteId, _organizationId,
					1, 0, 10, "", "");
			InstituteListResponse instituteListResponse = masterDao.fetchInstitutesList(instituteListRequest);
			_instituteName = instituteListResponse.getResponseArray().get(0).getInstituteName();
			// sfds

			String uploadDir = new ClassPathResource(".").getFile().getAbsolutePath();
			System.out.println("UploadDir : " + uploadDir);

			// --MAKING OF FILE-NAME
			String fileName = _examinationId + "" + _organizationId + "" + _instituteId + "" + _classId + ""
					+ _divisionId + ".json";

			// --CHECKING OF FILE-EXISTS/NOT
			File resultFile = new File(uploadDir + "/" + fileName);
			if (resultFile.exists()) {
				System.out.println("Exists ");
				ObjectMapper mapper = new ObjectMapper();
				StudentRegularResultJson studentRegularResultJson = mapper.readValue(resultFile,
						StudentRegularResultJson.class);
				System.out.println(studentRegularResultJson.toString());
				studentRegularResultDetails = studentRegularResultJson.getStudentRegularResultDetails();

			} else {

				studentRegularResultDetails = resultDao.getStudentRegularResultDetails(extraSubject1, extraSubject2,
						request);

				ObjectMapper mapper = new ObjectMapper();
				StudentRegularResultJson obj = new StudentRegularResultJson(_organizationName, _instituteName,
						_className, _divisionName, studentRegularResultDetails);
				File newResultFile = new File(uploadDir + "/" + fileName);
				newResultFile.createNewFile();
				mapper.writeValue(newResultFile, obj);
				System.out.println(newResultFile.getAbsolutePath() + " File created");

			}

			model.addAttribute("studentRegularResultDetails", studentRegularResultDetails);
			model.addAttribute("instituteName", _instituteName);

			String _classDivisionName = _className + "-" + _divisionName;
			model.addAttribute("className", _classDivisionName);
			model.addAttribute("divisionName", _divisionName);

		} catch (Exception e) {
			System.err.println(e);
			// TODO: handle exception
		}

		return "pages/result/regular/mvp-student-result-list";
	}

	public String getSubjectWiseRegularExamStudentsResultList(RegularExamStudentListRequest request, Model model) {

		try {

			// System.out.println("Service Called....");
			// --FINAL MODEL-PASS-UI
			List<RegularExamResultStudentHolder> regularExamResultStudentHolders = new ArrayList<RegularExamResultStudentHolder>();
			// --NEEDED PARAMETERS
			int _instituteId = request.getInstituteId();
			int _organizationId = request.getOrganizationId();
			int _classId = request.getClassId();
			int _divisionId = request.getDivisionId();
			int _subjectId = request.getSubjectId();
			int _examinationId = request.getExaminationId();
			String _organizationName = request.getOrganizationName();
			String _instituteName = request.getInstituteName();
			String _className = request.getClassName();
			String _divisionName = request.getDivisionName();

			InstituteListRequest instituteListRequest = new InstituteListRequest(1, 4, 1, _instituteId, _organizationId,
					1, 0, 10, "", "");
			InstituteListResponse instituteListResponse = masterDao.fetchInstitutesList(instituteListRequest);
			_instituteName = instituteListResponse.getResponseArray().get(0).getInstituteName();

			SubjectListRequest subjectListRequest = new SubjectListRequest(1, 4, "en", 1, _subjectId, _classId, 0, 0,
					100, "", "");
			SubjectListResponse subjectListResponse = masterDao.fetchSubjectList(subjectListRequest);
			String _subjectName = subjectListResponse.getResponseArray().get(0).getSubjectName();

			String uploadDir = new ClassPathResource(".").getFile().getAbsolutePath();
			System.out.println("UploadDir : " + uploadDir);

			// --MAKING OF FILE-NAME
			String fileName = _subjectId + "-" + _examinationId + "" + _organizationId + "" + _instituteId + ""
					+ _classId + "" + _divisionId + ".json";

			// --CHECKING OF FILE-EXISTS/NOT
			File resultFile = new File(uploadDir + "/" + fileName);
			if (resultFile.exists()) {
				System.out.println("Exists ");
				ObjectMapper mapper = new ObjectMapper();
				StudentSubjectWiseRegularResultJson studentSubjectWiseRegularResultJson = mapper.readValue(resultFile,
						StudentSubjectWiseRegularResultJson.class);
				System.out.println(studentSubjectWiseRegularResultJson.toString());
				regularExamResultStudentHolders = studentSubjectWiseRegularResultJson
						.getRegularExamResultStudentHolders();

			} else {

				regularExamResultStudentHolders = resultDao.getSubjectWiseStudentRegularResultDetails(request);

				ObjectMapper mapper = new ObjectMapper();
				StudentSubjectWiseRegularResultJson obj = new StudentSubjectWiseRegularResultJson(_organizationName,
						_instituteName, _className, _divisionName, regularExamResultStudentHolders);
				File newResultFile = new File(uploadDir + "/" + fileName);
				newResultFile.createNewFile();
				mapper.writeValue(newResultFile, obj);
				System.out.println(newResultFile.getAbsolutePath() + " File created");

			}

			model.addAttribute("regularExamResultStudentHolders", regularExamResultStudentHolders);
			model.addAttribute("instituteName", _instituteName);

			String _examName = regularExamResultStudentHolders.get(0).getExamName();
			int _maxMarks = (int) regularExamResultStudentHolders.get(0).getMaxMarks();
			model.addAttribute("examName", _examName);
			model.addAttribute("maxMarks", _maxMarks);

			String _classDivisionName = _className + "-" + _divisionName;
			model.addAttribute("className", _classDivisionName);
			model.addAttribute("divisionName", _divisionName);
			model.addAttribute("subjectName", _subjectName);

		} catch (Exception e) {
			System.err.println(e);
		}

		return "pages/result/regular/mvp-subjectwise-student-result-list";
	}

	// -- NOT YET USED
	public String getRegularExamEleventhStudentResult(int studentId, Model model) {
		// ----- FETCHING STUDENT DATA
		Integer vAttendantId = studentId;
		Integer vAttendantRoleId = 5;
		Integer vAction = 3;

		Integer vUserId = 0;
		Integer vOrganizationId = 0;
		String vSearch = "";
		TempStudentRequest vRequest = new TempStudentRequest(vAttendantId, vAttendantRoleId, vAction, vUserId,
				vOrganizationId, vSearch);
		TempStuddentListResponse tempStuddentListResponse = userDao.getAdminSearchStudents(vRequest);
		List<TempStudentHolder> tempStudentHolders = tempStuddentListResponse.getResponseArray();
		TempStudentHolder studentHolder = tempStudentHolders.get(0);

		// ----- FETCHING EXAM RESULTS
		Integer AttendantId = 1;
		Integer AttendantRoleId = 5;
		Integer Action = 3;

		Integer ResultId = 0;
		Integer QuestionPaperId = 0;
		Integer StudentId = studentId;

		Integer RecordStatus = 1;
		Integer Offset = 0;
		Integer Limit = 100;
		String Search = "";
		String SyncDate = "";
		ExamResultRequest request = new ExamResultRequest(AttendantId, AttendantRoleId, Action, ResultId,
				QuestionPaperId, StudentId, RecordStatus, Offset, Limit, Search, SyncDate);
		// System.out.println(request.toString());
		ExamResultListResponse examResultListResponse = examDao.fetchExamResults(request);
		// System.out.println(examResultListResponse.toString());
		List<ExamResultHolder> examResultHolders = examResultListResponse.getResponseArray();
		ArrayList<ExamResultUiHolder> examResultUiHolders = new ArrayList<ExamResultUiHolder>();
		ArrayList<String> subjectList = new ArrayList<String>();
		int i;
		int totalMarks = 0;
		int makrsObtained = 0;
		boolean isPass = true;
		for (i = 0; i < examResultHolders.size(); i++) {
			ExamResultHolder examResultHolder = examResultHolders.get(i);
			// Ignore Demo-EnglishPaper
			if (examResultHolder.getQuestionPaperId() == 576 || examResultHolder.getQuestionPaperId() == 577
					|| examResultHolder.getQuestionPaperId() == 579 || examResultHolder.getQuestionPaperId() == 580
					|| examResultHolder.getQuestionPaperId() == 581 || examResultHolder.getQuestionPaperId() == 583
					|| examResultHolder.getQuestionPaperId() == 584 || examResultHolder.getQuestionPaperId() == 585) {
				// leave this QuestionPaper as this is demo
			} else {
				Integer serialNo = (i + 1);
				// String subjectName = examResultHolder.getSubjectName();
				String subjectName = examResultHolder.getPaperName();

				int maxMarks = 0;

				double positiveMarks = examResultHolder.getPositiveMarking() == null ? 0.0
						: examResultHolder.getPositiveMarking();
				int postiveMark = (int) positiveMarks;
				// System.out.println(postiveMark);
				maxMarks = (examResultHolder.getTotalQuestions() * postiveMark);
				// totalMarks = totalMarks + maxMarks;
				double data = examResultHolder.getExamScore() * positiveMarks;
				int examScore = (int) data;

				// Check Whether Single Subject Attempted Or Not
				if (examScore < 17) {
					isPass = false;
					System.out.println("isPass=false");
				}

				Integer obtainedMarks = examScore;
				// makrsObtained = makrsObtained + obtainedMarks;

				String obtainedInWords = IntergerToWordConvertor.convertWithCasing(examScore);

				ExamResultUiHolder examResultUiHolder = new ExamResultUiHolder(serialNo, subjectName,
						String.valueOf(maxMarks), String.valueOf(obtainedMarks), obtainedInWords);

				if (subjectList.contains(subjectName)) {
					// System.out.println("exists");
				} else {
					totalMarks = totalMarks + maxMarks;
					makrsObtained = makrsObtained + obtainedMarks;
					examResultUiHolders.add(examResultUiHolder);
					subjectList.add(subjectName);
				}

			}

		}

		// --ADDING TWO MORE SUBJECTS
		examResultUiHolders.add(new ExamResultUiHolder((i + 1), "EVS", "", "", ""));
		examResultUiHolders.add(new ExamResultUiHolder((i + 2), "Physical Education", "", "", ""));

		if (examResultUiHolders.size() < 6) {
			isPass = false;
		}

		model.addAttribute("maximumMarks", totalMarks);
		model.addAttribute("obtainedMarks", makrsObtained);
		model.addAttribute("obtainedMarksInWords", IntergerToWordConvertor.convertWithCasing(makrsObtained));

		model.addAttribute("percentage", ExamUtils.getPercentage(makrsObtained, totalMarks));
		model.addAttribute("result", isPass ? ExamUtils.getResultStatus(makrsObtained, totalMarks) : "ATKT");

		System.out.println(examResultHolders.toString());
		model.addAttribute("className", studentHolder.getClassName());
		model.addAttribute("divisionName", studentHolder.getDivisionName());

		int Gender = studentHolder.getGender();
		// System.out.println(Gender);
		if (Gender == 1) {
			model.addAttribute("gender", "Male");
		} else if (Gender == 2) {
			model.addAttribute("gender", "Female");
		} else {
			model.addAttribute("gender", "Other");
		}

		model.addAttribute("studentName", studentHolder.getStudentName());
		model.addAttribute("instituteName", studentHolder.getInstituteName());
		model.addAttribute("motherName", studentHolder.getMothersName());
		model.addAttribute("examResultUiHolders", examResultUiHolders);

		return "pages/result/result-single1";
	}

	public String getRegularExamEleventhTeacherStudentsResult(int userId, Model model) {
		// TODO : Create StduentsWithResults-->PDFFile-->SaveOnServer

		try {

			int ClassId = 0;
			String ClassName = "";

			ArrayList<ExamRegularResultUiHolder> examRegularResultUiHolders = new ArrayList<ExamRegularResultUiHolder>();

			// start- Getting UserData
			Integer vAttendantId = 1;
			Integer vAttendantRoleId = 4;
			Integer vAction = 4;

			Integer vUserId = userId;
			Integer vOrganizationId = 1;
			String vSearch = "";

			TempUserRequest vRequest = new TempUserRequest(vAttendantId, vAttendantRoleId, vAction, vUserId,
					vOrganizationId, vSearch);
			TempUserListResponse tempUserListResponse = userDao.getAdminSearchUsers(vRequest);
			List<TempUserHolder> tempUserHolders = tempUserListResponse.getResponseArray();
			TempUserHolder tempUserHolder = tempUserHolders.get(0);
			// end - Getting UserData

			// start - creating fileName
			// String serverPath = "attachments/results/";
			// String uploadDir = new
			// ClassPathResource("attachments/results/").getFile().getAbsolutePath();
			String uploadDir = new ClassPathResource(".").getFile().getAbsolutePath();
			System.out.println("UploadDir : " + uploadDir);

			int OrganizationId = tempUserHolder.getOrganizationId();
			int InstituteId = tempUserHolder.getInstituteId();
			ClassId = tempUserHolder.getClassId();
			int DivisionId = tempUserHolder.getDivisionId();
			String instituteName = tempUserHolder.getInstituteName();
			ClassName = tempUserHolder.getClassName();
			String divisionName = tempUserHolder.getDivisionName();

			String fileName = OrganizationId + "" + InstituteId + "" + ClassId + "" + DivisionId + ".json";

			// String filePath = serverPath + fileName;

			// end - creating fileName

			// --start--checkFileExists
			File resultFile = new File(uploadDir + "/" + fileName);
			if (resultFile.exists()) {
				System.out.println("Exists ");
				ObjectMapper mapper = new ObjectMapper();
				ExamRegularResultJsonHolder obj = mapper.readValue(resultFile, ExamRegularResultJsonHolder.class);
				examRegularResultUiHolders = obj.getExamRegularResultUiHolders();
			} else {
				System.out.println("Exists Failed");
//					File newResultFile = new File(uploadDir + "/" + fileName);
//					newResultFile.createNewFile();
//					System.out.println(newResultFile.getAbsolutePath() + " File created");

				// --start--startedMainLogic

				Integer AttendantId = 1;
				Integer AttendantRoleId = 4;
				Integer Action = 2;

				Integer StudentId = 0;
				Integer UserId = 0;
				// Integer InstituteId = instituteId;
				// Integer OrganizationId = organizationId;
				// Integer ClassId = classId;
				// Integer DivisionId = divisionId;
				String DOB = "";
				Integer Gender = 0;

				Integer RecordStatus = 0;
				Integer Offset = 0;
				Integer Limit = 1000;
				String Search = "";
				String SyncDate = "";

				StudentWithStatusListRequest request = new StudentWithStatusListRequest(AttendantId, AttendantRoleId,
						Action, StudentId, UserId, InstituteId, OrganizationId, ClassId, DivisionId, DOB, Gender,
						RecordStatus, Offset, Limit, Search, SyncDate);
				StudentWithStatusListResponse studentWithStatusListResponse = userDao.getStudentsForTeachers(request);
				List<StudentWithStatusHolder> studentWithStatusHolders = studentWithStatusListResponse
						.getResponseArray();

				model.addAttribute("studentWithStatusHolders", studentWithStatusHolders);

				// --Creating new list for ExamUiHolder
				// --We want whole result in one collection
				// ArrayList<ExamRegularResultUiHolder> examRegularResultUiHolders = new
				// ArrayList<ExamRegularResultUiHolder>();
				int k = 0;
				for (StudentWithStatusHolder studentWithStatusHolder : studentWithStatusHolders) {
					System.out.println("Row:" + k);
					System.out.println(studentWithStatusHolder.getRollNo() + studentWithStatusHolder.getStudentName());
					ExamRegularResultUiHolder examRegularResultUiHolder = new ExamRegularResultUiHolder();

					// Fetching Result for EachStduent
					Integer vvvAttendantId = 1;
					Integer vvvAttendantRoleId = 5;
					Integer vvvAction = 3;
					Integer vResultId = 0;
					Integer vQuestionPaperId = 0;
					Integer vStudentId = studentWithStatusHolder.getStudentId();
					Integer vRecordStatus = 1;
					Integer vOffset = 0;
					Integer vLimit = 100;
					String vvvvSearch = "";
					String vSyncDate = "";
					ExamResultRequest examResultRequest = new ExamResultRequest(vvvAttendantId, vvvAttendantRoleId,
							vvvAction, vResultId, vQuestionPaperId, vStudentId, vRecordStatus, vOffset, vLimit,
							vvvvSearch, vSyncDate);
					System.out.println("vStudentId : " + vStudentId);
					ExamResultListResponse examResultListResponse = examDao.fetchExamResults(examResultRequest);
					List<ExamResultHolder> examResultHolders = examResultListResponse.getResponseArray();

					ArrayList<ExamResultUiHolder> examResultUiHolders = new ArrayList<ExamResultUiHolder>();
					ArrayList<String> subjectList = new ArrayList<String>();
					int j;
					int totalMarks = 0;
					int makrsObtained = 0;
					boolean isPass = true;

					for (j = 0; j < examResultHolders.size(); j++) {
						ExamResultHolder examResultHolder = examResultHolders.get(j);
						// Ignore Demo-EnglishPaper
						if (examResultHolder.getQuestionPaperId() == 576 || examResultHolder.getQuestionPaperId() == 577
								|| examResultHolder.getQuestionPaperId() == 579
								|| examResultHolder.getQuestionPaperId() == 580
								|| examResultHolder.getQuestionPaperId() == 581
								|| examResultHolder.getQuestionPaperId() == 583
								|| examResultHolder.getQuestionPaperId() == 584
								|| examResultHolder.getQuestionPaperId() == 585) {
							// leave this QuestionPaper as this is demo

						} else {
							Integer serialNo = (j + 1);
							// String subjectName = examResultHolder.getSubjectName();
							String subjectName = examResultHolder.getPaperName().toUpperCase();
							System.out.println(subjectName);

							int maxMarks = 0;

							double positiveMarks = examResultHolder.getPositiveMarking() == null ? 1.0
									: examResultHolder.getPositiveMarking();
							int postiveMark = (int) positiveMarks;

							// System.out.println(postiveMark);

							maxMarks = (examResultHolder.getTotalQuestions() * postiveMark);

							double data = examResultHolder.getExamScore() * positiveMarks;
							int examScore = (int) data;

							// Check Whether Single Subject Attempted Or Not
							if (examScore < 17) {
								isPass = false;
								// System.out.println("isPass=false");
							}

							Integer obtainedMarks = examScore;

							String obtainedInWords = IntergerToWordConvertor.convertWithCasing(examScore);

							ExamResultUiHolder examResultUiHolder = new ExamResultUiHolder(serialNo, subjectName,
									String.valueOf(maxMarks), String.valueOf(obtainedMarks), obtainedInWords);

							if (subjectList.contains(subjectName)) {
								// System.out.println("exists");
							} else {
								totalMarks = totalMarks + maxMarks;
								makrsObtained = makrsObtained + obtainedMarks;
								examResultUiHolders.add(examResultUiHolder);
								subjectList.add(subjectName);
							}

						}

					}

					if (examResultUiHolders.size() < 6) {
						isPass = false;
					}

					examRegularResultUiHolder.setRollNo(studentWithStatusHolder.getRollNo());
					examRegularResultUiHolder.setStudentName(studentWithStatusHolder.getStudentName());
					examRegularResultUiHolder.setExamResultUiHolders(examResultUiHolders);
					examRegularResultUiHolder.setMaximumMarks(totalMarks);
					examRegularResultUiHolder.setObtainedMarks(makrsObtained);
					examRegularResultUiHolder
							.setPercentage(ExamUtils.getPercentage(makrsObtained, totalMarks) == null ? "0"
									: ExamUtils.getPercentage(makrsObtained, totalMarks));
					examRegularResultUiHolder
							.setResult(isPass ? ExamUtils.getResultStatus(makrsObtained, totalMarks) : "ATKT");

					examRegularResultUiHolders.add(examRegularResultUiHolder);
					k++;

				}

				try {

					ObjectMapper mapper = new ObjectMapper();
					ExamRegularResultJsonHolder obj = new ExamRegularResultJsonHolder(OrganizationId, InstituteId,
							ClassId, DivisionId, examRegularResultUiHolders);

					// mapper.writeValue(new File(filePath), obj);
					File newResultFile = new File(uploadDir + "/" + fileName);
					newResultFile.createNewFile();
					mapper.writeValue(newResultFile, obj);
					System.out.println(newResultFile.getAbsolutePath() + " File created");

				} catch (Exception e) {
					System.err.println(e);
				}
				// --end--startedMainLogic

			}

			// --end--checkFileExists

			// --start--final
			if (examRegularResultUiHolders == null) {
				return "pages/error/nodatafound";
			} else {

				System.out.println("examRegularResultUiHolders" + examRegularResultUiHolders.toString());
				model.addAttribute("examRegularResultUiHolders", examRegularResultUiHolders);
				model.addAttribute("instituteName", instituteName);

				String ClassDivisionName = ClassName + "-" + divisionName;
				model.addAttribute("className", ClassDivisionName);
				model.addAttribute("divisionName", divisionName);

			}

			return "pages/result/result-mvp-teacher-students1";

		} catch (Exception e) {
			System.err.println(e);
			return getRegularExamErrorResult(model);
		}

	}

	public String getRegularExamEleventhCoordinatorResult(int userId, Model model) {
		// ------------------------------------------------------
		// Current Working Region
		// ------------------------------------------------------

		try {

			// start- Getting UserData
			Integer vAttendantId = 1;
			Integer vAttendantRoleId = 4;
			Integer vAction = 4;

			Integer vUserId = userId;
			Integer vOrganizationId = 1;
			String vSearch = "";

			TempUserRequest vRequest = new TempUserRequest(vAttendantId, vAttendantRoleId, vAction, vUserId,
					vOrganizationId, vSearch);

			TempUserListResponse tempUserListResponse = userDao.getAdminSearchUsers(vRequest);
			List<TempUserHolder> tempUserHolders = tempUserListResponse.getResponseArray();

			TempUserHolder tempUserHolder = tempUserHolders.get(0);
			System.out.println(tempUserHolder.toString());

			Integer OrganizationId = tempUserHolder.getOrganizationId();
			Integer InstituteId = tempUserHolder.getInstituteId();
			Integer ClassId = tempUserHolder.getClassId();
			Integer DivisionId = tempUserHolder.getDivisionId();
			String instituteName = tempUserHolder.getInstituteName();
			String className = tempUserHolder.getClassName();
			String divisionName = tempUserHolder.getDivisionName();

			model.addAttribute("organizationId", OrganizationId);
			model.addAttribute("instituteName", instituteName);
			model.addAttribute("InstituteId", InstituteId);
			model.addAttribute("instituteName", instituteName);
			// end - Getting UserData

			// start -Getting Classes
			ClassListRequest classListRequest = new ClassListRequest(1, 4, 3, 0, 19, InstituteId, 1, 0, 100, "", "");

			SelectedClassListRepsonse selectedClassListRepsonse = masterDao.fetchSelectedClassesList(classListRequest);
			List<SelectedClassHolder> classHolders = selectedClassListRepsonse.getResponseArray();

			List<SelectedClassHolder> selectedClassHolders = new ArrayList<SelectedClassHolder>();
			for (SelectedClassHolder selectedClassHolder : classHolders) {
				if (selectedClassHolder.getClassId() == 14 || selectedClassHolder.getClassId() == 15
						|| selectedClassHolder.getClassId() == 16 || selectedClassHolder.getClassId() == 18) {
					selectedClassHolders.add(selectedClassHolder);
				}
			}

			// end - Getting Classes

			// start - Setting Data
			model.addAttribute("selectedClassHolders", selectedClassHolders);

			// end - Setting data

			return "pages/result/result-regular-classes";

		} catch (Exception e) {
			System.err.println(e);
			return getRegularExamErrorResult(model);
		}

	}

	public String getRegularExamErrorResult(Model model) {
		model.addAttribute("txtHeader", "Something went wrong!");
		model.addAttribute("txtCardTitle", "Database error");
		model.addAttribute("txtCardText", "डेटाबेस त्रुटी");
		return "pages/error/error-result";
	}

	public String getRegularExamErrorUnauthorizeResult(Model model) {
		System.out.println("else Called");
		model.addAttribute("txtHeader", "Something went wrong!");
		model.addAttribute("txtCardTitle", "Unauthorize access");
		model.addAttribute("txtCardText", "अनधिकृत प्रवेश");
		return "pages/error/error-result";

	}

	public String getRegularExamErrorCustom(String headerMessage, String cardTitle, String cardText, Model model) {
		System.out.println("else Called");
		model.addAttribute("txtHeader", headerMessage);
		model.addAttribute("txtCardTitle", cardTitle);
		model.addAttribute("txtCardText", cardText);
		return "pages/error/error-result";

	}

	/***
	 * ---------------------------------------------------------------------------
	 * PEAK EXAM REGION
	 * ---------------------------------------------------------------------------
	 ***/
	public String getPeakExamStudentResult(String extraSubject1, String extraSubject2,
			RegularExamStudentRequest request, Model model) {

//		// -----NEEDED PARAMETERS
//		int studentId = request.getStudentId();
//		int examinationId = request.getExaminationId();
//
//		// ----- FETCHING STUDENT DATA -----
//		TempStudentRequest vRequest = new TempStudentRequest(studentId, 5, 3, 0, 0, "");
//		TempStuddentListResponse tempStuddentListResponse = userDao.getAdminSearchStudents(vRequest);
//		List<TempStudentHolder> tempStudentHolders = tempStuddentListResponse.getResponseArray();
//		TempStudentHolder studentHolder = tempStudentHolders.get(0);
//
//		// ----- PASSING PARAMETERS TO UI
//		model.addAttribute("studentName", studentHolder.getStudentName());
//		model.addAttribute("instituteName", studentHolder.getInstituteName());
//		model.addAttribute("motherName", studentHolder.getMothersName());
//		model.addAttribute("className", studentHolder.getClassName());
//		model.addAttribute("divisionName", studentHolder.getDivisionName());
//		int gender = studentHolder.getGender();
//		if (gender == 1)
//			model.addAttribute("gender", "Male");
//		else if (gender == 2)
//			model.addAttribute("gender", "Female");
//		else
//			model.addAttribute("gender", "Other");
//
//		// ------ GETTING RESULT DATA ------
//		RegularExamResultRequest examResultRequest = new RegularExamResultRequest(1, 5, 1, examinationId, 0, studentId,
//				0, 0, 0, 0, 1, 0, 100, "", "");
//		RegularExamResultStudentListResponse examResultStudentListResponse = resultDao
//				.getRegularExamResultStudent(examResultRequest);
//		System.out.println(examResultRequest.toString());
//
//		if (examResultStudentListResponse.getHasError() == 1) {
//			System.out.println(examResultStudentListResponse.getMessage());
//			return getRegularExamErrorResult(model);
//		} else {
//			List<RegularExamResultStudentHolder> examResultStudentHolders = examResultStudentListResponse
//					.getResponseArray();
//			// ----- Making of final UI output -----
//			int i;
//			int totalMarks = 0;
//			int makrsObtained = 0;
//			boolean isPass = true;
//
//			List<ExamResultUiHolder> examResultUiHolders = new ArrayList<ExamResultUiHolder>();
//			for (i = 0; i < examResultStudentHolders.size(); i++) {
//				RegularExamResultStudentHolder examResultStudentHolder = examResultStudentHolders.get(i);
//				Integer serialNo = (i + 1);
//				String subjectName = examResultStudentHolder.getPaperName();
//				String maxMarks = String.valueOf((int) examResultStudentHolder.getMaxMarks());
//				String obtainedMarks = String.valueOf((int) examResultStudentHolder.getExamScore());
//				String obtainedInWords = IntergerToWordConvertor
//						.convertWithCasing(examResultStudentHolder.getExamScore());
//
//				if (examResultStudentHolder.getResultRemark().equals("Fail"))
//					isPass = false;
//				totalMarks = totalMarks + (int) examResultStudentHolder.getMaxMarks();
//				makrsObtained = makrsObtained + (int) examResultStudentHolder.getExamScore();
//
//				ExamResultUiHolder examResultUiHolder = new ExamResultUiHolder(serialNo, subjectName, maxMarks,
//						obtainedMarks, obtainedInWords);
//				examResultUiHolders.add(examResultUiHolder);
//			}
//
//			// ----- ADDING TWO EXTRA SUBJECTS -----
//			examResultUiHolders.add(new ExamResultUiHolder((i + 1), extraSubject1, "", "", ""));
//			examResultUiHolders.add(new ExamResultUiHolder((i + 2), extraSubject2, "", "", ""));
//
//			model.addAttribute("maximumMarks", totalMarks);
//			model.addAttribute("obtainedMarks", makrsObtained);
//			model.addAttribute("obtainedMarksInWords", IntergerToWordConvertor.convertWithCasing(makrsObtained));
//
//			model.addAttribute("percentage", ExamUtils.getPercentage(makrsObtained, totalMarks));
//			model.addAttribute("result", isPass ? ExamUtils.getResultStatus(makrsObtained, totalMarks) : "ATKT");
//
//			model.addAttribute("examResultUiHolders", examResultUiHolders);
//		}

		return "pages/result/regular/mvp-student-result";
	}

	// Result For Specific Subject of PEAK
	public String getSubjectWisePeakExamStudentsResultList(PeakExamStudentListRequest request, Model model) {

		try {

			// System.out.println("Service Called....");
			// --FINAL MODEL-PASS-UI
			List<PeakExamResultStudentHolder> regularExamResultStudentHolders = new ArrayList<PeakExamResultStudentHolder>();
			// --NEEDED PARAMETERS
			int _instituteId = request.getInstituteId();
			int _organizationId = request.getOrganizationId();
			int _classId = request.getClassId();
			int _divisionId = request.getDivisionId();
			int _subjectId = request.getSubjectId();
			int _examinationId = request.getExaminationId();
			String _organizationName = request.getOrganizationName();
			String _instituteName = request.getInstituteName();
			String _className = request.getClassName();
			String _divisionName = request.getDivisionName();

			InstituteListRequest instituteListRequest = new InstituteListRequest(1, 4, 1, _instituteId, _organizationId,
					1, 0, 10, "", "");
			InstituteListResponse instituteListResponse = masterDao.fetchInstitutesList(instituteListRequest);
			_instituteName = instituteListResponse.getResponseArray().get(0).getInstituteName();

			String uploadDir = new ClassPathResource(".").getFile().getAbsolutePath();
			System.out.println("UploadDir : " + uploadDir);

			// --MAKING OF FILE-NAME
			String fileName = "peak-" + _subjectId + "-" + _examinationId + "" + _organizationId + "" + _instituteId
					+ "" + _classId + "" + _divisionId + ".json";

			// --CHECKING OF FILE-EXISTS/NOT
//			File resultFile = new File(uploadDir + "/" + fileName);
//			if (resultFile.exists()) {
//				System.out.println("Exists ");
//				ObjectMapper mapper = new ObjectMapper();
//				StudentSubjectWisePeakResultJson studentSubjectWiseRegularResultJson = mapper.readValue(resultFile,
//						StudentSubjectWisePeakResultJson.class);
//				System.out.println(studentSubjectWiseRegularResultJson.toString());
//				regularExamResultStudentHolders = studentSubjectWiseRegularResultJson.getPeakExamResultStudentHolders();
//
//			} else {

			regularExamResultStudentHolders = resultDao.getSubjectWiseStudentPeakResultDetails(request);

//				ObjectMapper mapper = new ObjectMapper();
//				StudentSubjectWisePeakResultJson obj = new StudentSubjectWisePeakResultJson(_organizationName, _instituteName, _className, _divisionName, regularExamResultStudentHolders);
//				File newResultFile = new File(uploadDir + "/" + fileName);
//				newResultFile.createNewFile();
//				mapper.writeValue(newResultFile, obj);
//				System.out.println(newResultFile.getAbsolutePath() + " File created");

			// }

			model.addAttribute("regularExamResultStudentHolders", regularExamResultStudentHolders);
			model.addAttribute("instituteName", _instituteName);

			String _examName = regularExamResultStudentHolders.get(0).getExamName();
			Integer _maxMarks = (int) regularExamResultStudentHolders.get(0).getMaxMarks();
			model.addAttribute("examName", _examName);
			model.addAttribute("maxMarks", _maxMarks);

			String _classDivisionName = _className + "-" + _divisionName;
			model.addAttribute("className", _classDivisionName);
			model.addAttribute("divisionName", _divisionName);
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			model.addAttribute("timestamp", timestamp);
		} catch (Exception e) {
			System.err.println(e);
		}

		return "pages/result/peak/peak-subjectwise-student-result-list";
	}

	public void getPeakResult(int roleId, Model model, final PeakResultCallback peakResultCallback) {
		System.out.println("Called");
		System.out.println(roleId);
//		if (roleId == 5) {
//			peakResultCallback.onStudentResult("studentResult");
//		} else if (roleId == 2) {
//			peakResultCallback.onStudentResult("message");
//		}else {
//			System.out.println("else Called");
//			model.addAttribute("txtHeader","Something went wrong!");
//			model.addAttribute("txtCardTitle","Unauthorize access");
//			model.addAttribute("txtCardText","अनधिकृत प्रवेश");
//			peakResultCallback.onResultError("pages/error/error-result");
//		}
	}

	public String getPeakStudentResult(Model model) {
		System.out.println("else Called");
		model.addAttribute("txtHeader", "Student Result!");
		model.addAttribute("txtCardTitle", "Ghya Student Result");
		model.addAttribute("txtCardText", "अनधिकृत प्रवेश");
		return "pages/error/error-result";

	}

	public String getPeakExamStatus(PeakExamStatusRequest request, Model model) {

		// ----- Working
		try {

			Integer Action = 2;

			Integer OrganizationId = request.getOrganizationId();
			Integer InstituteId = request.getInstituteId();
			Integer ClassId = request.getClassId();
			Integer DivisionId = request.getDivisionId();
			Integer QuestionPaperId = request.getQuestionPaperId();

			Integer RecordStatus = 1;
			Integer Offset = 0;
			Integer Limit = 999;
			String Search = "";
			String SyncDate = "";

			PeakExamResultStatusRequest peakExamResultStatusRequest = new PeakExamResultStatusRequest(Action,
					OrganizationId, InstituteId, ClassId, DivisionId, QuestionPaperId, RecordStatus, Offset, Limit,
					Search, SyncDate);
			System.out.println(peakExamResultStatusRequest.toString());
			// PeakExamResultListResponse peakExamResultResponse =
			// examDao.fetchPeakExamResults(peakExamResultRequest);
			PeakExamStatusListResponse peakExamResultResponse = new PeakExamStatusListResponse();
			peakExamResultResponse = resultDao.getPeakExamStatus(peakExamResultStatusRequest);
			List<PeakExamStatusHolder> peakExamStatusHolders = peakExamResultResponse.getResponseArray();
			System.out.println(peakExamStatusHolders.toString());

			PeakExamStatusHolder peakExamStatusHolder = peakExamStatusHolders.get(0);
			String paperName = peakExamStatusHolder.getPaperName();

			int totalStudents = 0;
			int attendedStudents = 0;
			int remainingStudents = 0;

			totalStudents = peakExamStatusHolders.size();
			for (PeakExamStatusHolder holder : peakExamStatusHolders) {
				if (holder.getResultCount() > 0) {
					attendedStudents = attendedStudents + 1;
				} else {
					remainingStudents = remainingStudents + 1;
				}
			}

			model.addAttribute("peakExamStatusHolders", peakExamStatusHolders);
			model.addAttribute("paperName", paperName);

			model.addAttribute("totalStudents", totalStudents);
			model.addAttribute("attendedStudents", attendedStudents);
			model.addAttribute("remainingStudents", remainingStudents);

		} catch (Exception e) {
			System.err.println(e);
		}

		return "pages/result/result-peak-table-students";

	}

	public String getPeakErrorResult(Model model) {
		model.addAttribute("txtHeader", "Something went wrong!");
		model.addAttribute("txtCardTitle", "Database error");
		model.addAttribute("txtCardText", "डेटाबेस त्रुटी");
		return "pages/error/error-result";
	}

	public String getPeakErrorUnauthorizeResult(Model model) {
		System.out.println("else Called");
		model.addAttribute("txtHeader", "Something went wrong!");
		model.addAttribute("txtCardTitle", "Unauthorize access");
		model.addAttribute("txtCardText", "अनधिकृत प्रवेश");
		return "pages/error/error-result";

	}

	public String getPeakToppersList(int Action, int ClassId, Model model) {

		RankPeakResulListResponse rankPeakResulListResponse = resultDao.getRankPeakExamResult(1, 1);
		List<RankPeakResultHolder> rankPeakResultHolders = rankPeakResulListResponse.getResponseArray();
		System.out.println(rankPeakResultHolders.toString());

		model.addAttribute("rankPeakResultHolders", rankPeakResultHolders);

		return "pages/result/peak/peak-rank-results";
	}

	public String getPeakExamStudentFinalResult(PeakExamFinalResultRequest request, Model model) {
		// TODO Auto-generated method stub
		System.out.println(request.toString());

		int studentId = request.getStudentId();
		int classId = request.getClassId();
		int instituteId = request.getInstituteId();
		int organizationId = request.getOrganizationId();
		System.out.println("InstituteID:" + instituteId);

		PeakExamFinalResultListResponse peakExamFinalResultListResponse = resultDao.getPeakExamStudentFinalResult(1,
				studentId, classId, instituteId, organizationId);

//		String studentName="Bhavesh Avinash Nikam";
//		String instituteName="Arts & Commerce College, Soygaon, Tal. Malegaon";
//		String className="XI - 11th - Science";
//		String divisionName="A";
//		String districtName="Nashik";
//		String stateName="Maharashtra";

		List<PeakExamFinalResultHolder> peakExamFinalResultHolders = peakExamFinalResultListResponse.getResponseArray();
		PeakExamFinalResultHolder peakExamFinalResultHolder = peakExamFinalResultHolders.get(0);

		String totalStudents = peakExamFinalResultHolder.getTotalStudents();
		String studentName = peakExamFinalResultHolder.getStudentName();
		String instituteName = peakExamFinalResultHolder.getInstituteName();
		String className = peakExamFinalResultHolder.getClassName();
		String divisionName = peakExamFinalResultHolder.getDivisionName();

		String districtName = "Nashik";
		String stateName = "Maharashtra";

		String totalQuestions = peakExamFinalResultHolder.getTotalQuestions();
		String maximumMarks = peakExamFinalResultHolder.getTotalQuestions();

		model.addAttribute("totalStudents", totalStudents);
		model.addAttribute("studentName", studentName);
		model.addAttribute("instituteName", instituteName);
		model.addAttribute("className", className);
		model.addAttribute("divisionName", divisionName);
		model.addAttribute("districtName", districtName);
		model.addAttribute("stateName", stateName);
		model.addAttribute("totalQuestions", totalQuestions);
		model.addAttribute("maximumMarks", maximumMarks);

		// --Initialize variables
		int Peak1_ExamScore = 0;
		int Peak2_ExamScore = 0;
		int Peak3_ExamScore = 0;
		int Peak4_ExamScore = 0;
		int Peak5_ExamScore = 0;
		int Peak6_ExamScore = 0;
		int Peak7_ExamScore = 0;
		int Peak8_ExamScore = 0;

		String Peak1_Score = "NA";
		String Peak1_InstituteRank = "NA";
		String Peak1_SansthaRank = "NA";
		String Peak1_DistrictRank = "NA";
		String Peak1_StateRank = "NA";
		String Peak1_InstituteMaxScore = "NA";
		String Peak1_SansthaMaxScore = "NA";
		String Peak1_MaxScore = "NA";

		String Peak2_Score = "NA";
		String Peak2_InstituteRank = "NA";
		String Peak2_SansthaRank = "NA";
		String Peak2_DistrictRank = "NA";
		String Peak2_StateRank = "NA";
		String Peak2_InstituteMaxScore = "NA";
		String Peak2_SansthaMaxScore = "NA";
		String Peak2_MaxScore = "NA";

		String Peak3_Score = "NA";
		String Peak3_InstituteRank = "NA";
		String Peak3_SansthaRank = "NA";
		String Peak3_DistrictRank = "NA";
		String Peak3_StateRank = "NA";
		String Peak3_InstituteMaxScore = "NA";
		String Peak3_SansthaMaxScore = "NA";
		String Peak3_MaxScore = "NA";

		String Peak4_Score = "NA";
		String Peak4_InstituteRank = "NA";
		String Peak4_SansthaRank = "NA";
		String Peak4_DistrictRank = "NA";
		String Peak4_StateRank = "NA";
		String Peak4_InstituteMaxScore = "NA";
		String Peak4_SansthaMaxScore = "NA";
		String Peak4_MaxScore = "NA";

		String Peak5_Score = "NA";
		String Peak5_InstituteRank = "NA";
		String Peak5_SansthaRank = "NA";
		String Peak5_DistrictRank = "NA";
		String Peak5_StateRank = "NA";
		String Peak5_InstituteMaxScore = "NA";
		String Peak5_SansthaMaxScore = "NA";
		String Peak5_MaxScore = "NA";

		String Peak6_Score = "NA";
		String Peak6_InstituteRank = "NA";
		String Peak6_SansthaRank = "NA";
		String Peak6_DistrictRank = "NA";
		String Peak6_StateRank = "NA";
		String Peak6_InstituteMaxScore = "NA";
		String Peak6_SansthaMaxScore = "NA";
		String Peak6_MaxScore = "NA";

		String Peak7_Score = "NA";
		String Peak7_InstituteRank = "NA";
		String Peak7_SansthaRank = "NA";
		String Peak7_DistrictRank = "NA";
		String Peak7_StateRank = "NA";
		String Peak7_InstituteMaxScore = "NA";
		String Peak7_SansthaMaxScore = "NA";
		String Peak7_MaxScore = "NA";

		String Peak8_Score = "NA";
		String Peak8_InstituteRank = "NA";
		String Peak8_SansthaRank = "NA";
		String Peak8_DistrictRank = "NA";
		String Peak8_StateRank = "NA";
		String Peak8_InstituteMaxScore = "NA";
		String Peak8_SansthaMaxScore = "NA";
		String Peak8_MaxScore = "NA";

		Peak1_InstituteMaxScore = String.valueOf(peakExamFinalResultHolder.getPeak1InstituteMaxScore());
		Peak1_SansthaMaxScore = String.valueOf(peakExamFinalResultHolder.getPeak1SansthaMaxScore());
		Peak1_MaxScore = String.valueOf(peakExamFinalResultHolder.getPeak1MaxScore());

		Peak2_InstituteMaxScore = String.valueOf(peakExamFinalResultHolder.getPeak2InstituteMaxScore());
		Peak2_SansthaMaxScore = String.valueOf(peakExamFinalResultHolder.getPeak2SansthaMaxScore());
		Peak2_MaxScore = String.valueOf(peakExamFinalResultHolder.getPeak2MaxScore());

		Peak3_InstituteMaxScore = String.valueOf(peakExamFinalResultHolder.getPeak3InstituteMaxScore());
		Peak3_SansthaMaxScore = String.valueOf(peakExamFinalResultHolder.getPeak3SansthaMaxScore());
		Peak3_MaxScore = String.valueOf(peakExamFinalResultHolder.getPeak3MaxScore());

		Peak4_InstituteMaxScore = String.valueOf(peakExamFinalResultHolder.getPeak4InstituteMaxScore());
		Peak4_SansthaMaxScore = String.valueOf(peakExamFinalResultHolder.getPeak4SansthaMaxScore());
		Peak4_MaxScore = String.valueOf(peakExamFinalResultHolder.getPeak4MaxScore());

		Peak5_InstituteMaxScore = String.valueOf(peakExamFinalResultHolder.getPeak5InstituteMaxScore());
		Peak5_SansthaMaxScore = String.valueOf(peakExamFinalResultHolder.getPeak5SansthaMaxScore());
		Peak5_MaxScore = String.valueOf(peakExamFinalResultHolder.getPeak5MaxScore());

		Peak6_InstituteMaxScore = String.valueOf(peakExamFinalResultHolder.getPeak6InstituteMaxScore());
		Peak6_SansthaMaxScore = String.valueOf(peakExamFinalResultHolder.getPeak6SansthaMaxScore());
		Peak6_MaxScore = String.valueOf(peakExamFinalResultHolder.getPeak6MaxScore());

		Peak7_InstituteMaxScore = String.valueOf(peakExamFinalResultHolder.getPeak7InstituteMaxScore());
		Peak7_SansthaMaxScore = String.valueOf(peakExamFinalResultHolder.getPeak7SansthaMaxScore());
		Peak7_MaxScore = String.valueOf(peakExamFinalResultHolder.getPeak7MaxScore());

		Peak8_InstituteMaxScore = String.valueOf(peakExamFinalResultHolder.getPeak8InstituteMaxScore());
		Peak8_SansthaMaxScore = String.valueOf(peakExamFinalResultHolder.getPeak8SansthaMaxScore());
		Peak8_MaxScore = String.valueOf(peakExamFinalResultHolder.getPeak8MaxScore());

		for (PeakExamFinalResultHolder item : peakExamFinalResultHolders) {
			int examinationId = item.getExaminationId();
			if (examinationId == 10) {
				Peak1_ExamScore = item.getExamScore() == "NA" ? 0 : Integer.parseInt(item.getExamScore());
				Peak1_Score = String.valueOf(item.getExamScore());
				Peak1_InstituteRank = String.valueOf(item.getPeakInstituteRank());
				Peak1_SansthaRank = String.valueOf(item.getPeakSansthaRank());
				Peak1_DistrictRank = String.valueOf(item.getPeakSansthaRank());
				Peak1_StateRank = String.valueOf(item.getPeakOverAllRank());

			} else if (examinationId == 11) {
				Peak2_ExamScore = item.getExamScore() == "NA" ? 0 : Integer.parseInt(item.getExamScore());
				Peak2_Score = String.valueOf(item.getExamScore());
				Peak2_InstituteRank = String.valueOf(item.getPeakInstituteRank());
				Peak2_SansthaRank = String.valueOf(item.getPeakSansthaRank());
				Peak2_DistrictRank = String.valueOf(item.getPeakSansthaRank());
				Peak2_StateRank = String.valueOf(item.getPeakOverAllRank());

			} else if (examinationId == 12) {
				Peak3_ExamScore = item.getExamScore() == "NA" ? 0 : Integer.parseInt(item.getExamScore());
				Peak3_Score = String.valueOf(item.getExamScore());
				Peak3_InstituteRank = String.valueOf(item.getPeakInstituteRank());
				Peak3_SansthaRank = String.valueOf(item.getPeakSansthaRank());
				Peak3_DistrictRank = String.valueOf(item.getPeakSansthaRank());
				Peak3_StateRank = String.valueOf(item.getPeakOverAllRank());

			} else if (examinationId == 13) {
				Peak4_ExamScore = item.getExamScore() == "NA" ? 0 : Integer.parseInt(item.getExamScore());
				Peak4_Score = String.valueOf(item.getExamScore());
				Peak4_InstituteRank = String.valueOf(item.getPeakInstituteRank());
				Peak4_SansthaRank = String.valueOf(item.getPeakSansthaRank());
				Peak4_DistrictRank = String.valueOf(item.getPeakSansthaRank());
				Peak4_StateRank = String.valueOf(item.getPeakOverAllRank());

			} else if (examinationId == 14) {
				Peak5_ExamScore = item.getExamScore() == "NA" ? 0 : Integer.parseInt(item.getExamScore());
				Peak5_Score = String.valueOf(item.getExamScore());
				Peak5_InstituteRank = String.valueOf(item.getPeakInstituteRank());
				Peak5_SansthaRank = String.valueOf(item.getPeakSansthaRank());
				Peak5_DistrictRank = String.valueOf(item.getPeakSansthaRank());
				Peak5_StateRank = String.valueOf(item.getPeakOverAllRank());

			} else if (examinationId == 19) {
				Peak6_ExamScore = item.getExamScore() == "NA" ? 0 : Integer.parseInt(item.getExamScore());
				Peak6_Score = String.valueOf(item.getExamScore());
				Peak6_InstituteRank = String.valueOf(item.getPeakInstituteRank());
				Peak6_SansthaRank = String.valueOf(item.getPeakSansthaRank());
				Peak6_DistrictRank = String.valueOf(item.getPeakSansthaRank());
				Peak6_StateRank = String.valueOf(item.getPeakOverAllRank());

			} else if (examinationId == 20) {
				Peak7_ExamScore = item.getExamScore() == "NA" ? 0 : Integer.parseInt(item.getExamScore());
				Peak7_Score = String.valueOf(item.getExamScore());
				Peak7_InstituteRank = String.valueOf(item.getPeakInstituteRank());
				Peak7_SansthaRank = String.valueOf(item.getPeakSansthaRank());
				Peak7_DistrictRank = String.valueOf(item.getPeakSansthaRank());
				Peak7_StateRank = String.valueOf(item.getPeakOverAllRank());

			} else if (examinationId == 21) {
				Peak8_ExamScore = item.getExamScore() == "NA" ? 0 : Integer.parseInt(item.getExamScore());
				Peak8_Score = String.valueOf(item.getExamScore());
				Peak8_InstituteRank = String.valueOf(item.getPeakInstituteRank());
				Peak8_SansthaRank = String.valueOf(item.getPeakSansthaRank());
				Peak8_DistrictRank = String.valueOf(item.getPeakSansthaRank());
				Peak8_StateRank = String.valueOf(item.getPeakOverAllRank());

			}
		}

		model.addAttribute("Peak1_Score", Peak1_Score);
		model.addAttribute("Peak1_InstituteRank", Peak1_InstituteRank);
		model.addAttribute("Peak1_SansthaRank", Peak1_SansthaRank);
		model.addAttribute("Peak1_DistrictRank", Peak1_DistrictRank);
		model.addAttribute("Peak1_StateRank", Peak1_StateRank);
		model.addAttribute("Peak1_InstituteMaxScore", Peak1_InstituteMaxScore);
		model.addAttribute("Peak1_SansthaMaxScore", Peak1_SansthaMaxScore);
		model.addAttribute("Peak1_MaxScore", Peak1_MaxScore);

		model.addAttribute("Peak2_Score", Peak2_Score);
		model.addAttribute("Peak2_InstituteRank", Peak2_InstituteRank);
		model.addAttribute("Peak2_SansthaRank", Peak2_SansthaRank);
		model.addAttribute("Peak2_DistrictRank", Peak2_DistrictRank);
		model.addAttribute("Peak2_StateRank", Peak2_StateRank);
		model.addAttribute("Peak2_InstituteMaxScore", Peak2_InstituteMaxScore);
		model.addAttribute("Peak2_SansthaMaxScore", Peak2_SansthaMaxScore);
		model.addAttribute("Peak2_MaxScore", Peak2_MaxScore);

		model.addAttribute("Peak3_Score", Peak3_Score);
		model.addAttribute("Peak3_InstituteRank", Peak3_InstituteRank);
		model.addAttribute("Peak3_SansthaRank", Peak3_SansthaRank);
		model.addAttribute("Peak3_DistrictRank", Peak3_DistrictRank);
		model.addAttribute("Peak3_StateRank", Peak3_StateRank);
		model.addAttribute("Peak3_InstituteMaxScore", Peak3_InstituteMaxScore);
		model.addAttribute("Peak3_SansthaMaxScore", Peak3_SansthaMaxScore);
		model.addAttribute("Peak3_MaxScore", Peak3_MaxScore);

		model.addAttribute("Peak4_Score", Peak4_Score);
		model.addAttribute("Peak4_InstituteRank", Peak4_InstituteRank);
		model.addAttribute("Peak4_SansthaRank", Peak4_SansthaRank);
		model.addAttribute("Peak4_DistrictRank", Peak4_DistrictRank);
		model.addAttribute("Peak4_StateRank", Peak4_StateRank);
		model.addAttribute("Peak4_InstituteMaxScore", Peak4_InstituteMaxScore);
		model.addAttribute("Peak4_SansthaMaxScore", Peak4_SansthaMaxScore);
		model.addAttribute("Peak4_MaxScore", Peak4_MaxScore);

		model.addAttribute("Peak5_Score", Peak5_Score);
		model.addAttribute("Peak5_InstituteRank", Peak5_InstituteRank);
		model.addAttribute("Peak5_SansthaRank", Peak5_SansthaRank);
		model.addAttribute("Peak5_DistrictRank", Peak5_DistrictRank);
		model.addAttribute("Peak5_StateRank", Peak5_StateRank);
		model.addAttribute("Peak5_InstituteMaxScore", Peak5_InstituteMaxScore);
		model.addAttribute("Peak5_SansthaMaxScore", Peak5_SansthaMaxScore);
		model.addAttribute("Peak5_MaxScore", Peak5_MaxScore);

		model.addAttribute("Peak6_Score", Peak6_Score);
		model.addAttribute("Peak6_InstituteRank", Peak6_InstituteRank);
		model.addAttribute("Peak6_SansthaRank", Peak6_SansthaRank);
		model.addAttribute("Peak6_DistrictRank", Peak6_DistrictRank);
		model.addAttribute("Peak6_StateRank", Peak6_StateRank);
		model.addAttribute("Peak6_InstituteMaxScore", Peak6_InstituteMaxScore);
		model.addAttribute("Peak6_SansthaMaxScore", Peak6_SansthaMaxScore);
		model.addAttribute("Peak6_MaxScore", Peak6_MaxScore);

		model.addAttribute("Peak7_Score", Peak7_Score);
		model.addAttribute("Peak7_InstituteRank", Peak7_InstituteRank);
		model.addAttribute("Peak7_SansthaRank", Peak7_SansthaRank);
		model.addAttribute("Peak7_DistrictRank", Peak7_DistrictRank);
		model.addAttribute("Peak7_StateRank", Peak7_StateRank);
		model.addAttribute("Peak7_InstituteMaxScore", Peak7_InstituteMaxScore);
		model.addAttribute("Peak7_SansthaMaxScore", Peak7_SansthaMaxScore);
		model.addAttribute("Peak7_MaxScore", Peak7_MaxScore);

		model.addAttribute("Peak8_Score", Peak8_Score);
		model.addAttribute("Peak8_InstituteRank", Peak8_InstituteRank);
		model.addAttribute("Peak8_SansthaRank", Peak8_SansthaRank);
		model.addAttribute("Peak8_DistrictRank", Peak8_DistrictRank);
		model.addAttribute("Peak8_StateRank", Peak8_StateRank);
		model.addAttribute("Peak8_InstituteMaxScore", Peak8_InstituteMaxScore);
		model.addAttribute("Peak8_SansthaMaxScore", Peak8_SansthaMaxScore);
		model.addAttribute("Peak8_MaxScore", Peak8_MaxScore);

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		model.addAttribute("timestamp", timestamp);

		if (organizationId == 1) {
			model.addAttribute("organizationImage", "https://revoeducation.in/0.0.6/assets/img/mvp.jpg");
		} else if (organizationId == 5) {
			model.addAttribute("organizationImage", "https://revoeducation.in/0.0.6/assets/img/sangamner.jpg");
		}

		int totalMarksObtained = Peak1_ExamScore + Peak2_ExamScore + Peak3_ExamScore + Peak4_ExamScore + Peak5_ExamScore
				+ Peak6_ExamScore + Peak7_ExamScore + Peak8_ExamScore;
		String percentage = ExamUtils.getPercentage(totalMarksObtained, Integer.parseInt(maximumMarks));
		// System.out.println(timestamp);

		return "pages/result/peak/peak-result-certificate";
	}

}
