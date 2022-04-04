package in.targetpeak.api.controller;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.targetpeak.api.dao.ExamDao;
import in.targetpeak.api.dao.UserDao;
import in.targetpeak.api.dao.implementation.IMasterDao;
import in.targetpeak.api.entity.admin.students.TempStuddentListResponse;
import in.targetpeak.api.entity.admin.students.TempStudentHolder;
import in.targetpeak.api.entity.admin.students.TempStudentRequest;
import in.targetpeak.api.entity.admin.users.TempUserHolder;
import in.targetpeak.api.entity.admin.users.TempUserListResponse;
import in.targetpeak.api.entity.admin.users.TempUserRequest;
import in.targetpeak.api.entity.exam.peak.PeakExamResultHolder;
import in.targetpeak.api.entity.exam.peak.PeakExamResultStatusRequest;
import in.targetpeak.api.entity.exam.peak.PeakExamResultListResponse;
import in.targetpeak.api.entity.master.classs.ClassHolder;
import in.targetpeak.api.entity.master.classs.ClassListRequest;
import in.targetpeak.api.entity.master.classs.ClassListResponse;
import in.targetpeak.api.entity.master.classs.SelectedClassHolder;
import in.targetpeak.api.entity.master.classs.SelectedClassListRepsonse;
import in.targetpeak.api.entity.master.division.DivisionHolder;
import in.targetpeak.api.entity.master.division.DivisionListRequest;
import in.targetpeak.api.entity.master.division.DivisionListResponse;
import in.targetpeak.api.entity.result.ExamRegularResultJsonHolder;
import in.targetpeak.api.entity.result.ExamRegularResultUiHolder;
import in.targetpeak.api.entity.result.ExamResultHolder;
import in.targetpeak.api.entity.result.ExamResultListResponse;
import in.targetpeak.api.entity.result.ExamResultRequest;
import in.targetpeak.api.entity.result.ExamResultUiHolder;
import in.targetpeak.api.entity.student.StudentWithStatusHolder;
import in.targetpeak.api.entity.student.StudentWithStatusListRequest;
import in.targetpeak.api.entity.student.StudentWithStatusListResponse;
import in.targetpeak.api.util.ExamUtils;
import in.targetpeak.api.util.IntergerToWordConvertor;
import io.swagger.annotations.Api;

@RequestMapping(value = "/web")
@Api(tags = "Web pages", value = "All the webpages URLs available here", description = "")
@Controller
public class WebController {

	@Autowired
	ResourceLoader resourceLoader;

	// DECLARATIONS
	@Autowired
	ExamDao examDao;

	@Autowired
	IMasterDao masterDao;

	@Autowired
	UserDao userDao;

	// region ExamResults fetch
	private static DivisionListResponse divisionListResponse = new DivisionListResponse();
	private static List<DivisionHolder> divisionHolders = new ArrayList<DivisionHolder>();

	// region ExamResults fetch
	private static TempStuddentListResponse tempStuddentListResponse = new TempStuddentListResponse();
	private static List<TempStudentHolder> tempStudentHolders = new ArrayList<TempStudentHolder>();
	private static TempUserListResponse tempUserListResponse = new TempUserListResponse();
	private static List<TempUserHolder> tempUserHolders = new ArrayList<TempUserHolder>();

	// region ExamResults fetch
	private static ExamResultListResponse examResultListResponse = new ExamResultListResponse();
	private static List<ExamResultHolder> examResultHolders = new ArrayList<ExamResultHolder>();
	private static PeakExamResultListResponse peakExamResultResponse = new PeakExamResultListResponse();
	private static List<PeakExamResultHolder> peakExamResults = new ArrayList<PeakExamResultHolder>();
	private static ArrayList<ExamRegularResultUiHolder> examRegularResultUiHolders = new ArrayList<ExamRegularResultUiHolder>();

	// region StudentsListFetch
	private static StudentWithStatusListResponse studentWithStatusListResponse = new StudentWithStatusListResponse();
	private static List<StudentWithStatusHolder> studentWithStatusHolders = new ArrayList<StudentWithStatusHolder>();

	// --------------------------
	// -- SYLLABUS --
	// --------------------------

	// --------------------------
	// -- EXAMS : REGULAR(MVP Results,PEAK Results--Students/Teachers both) --
	// handled from RoleId & QuestionId
	// --------------------------

	// Reference URL
	// --http://revoeducation.in:8080/api-4.0.4/web/exam/peak
	// --?organizationId=1&instituteId=892&classId=11&subjectId=367&userId=42854&studentId=0&questionPaperId=428&roleId=4

	// organizationId=1&instituteId=892&classId=11&subjectId=367&userId=42854&studentId=0&questionPaperId=428&roleId=4

	@GetMapping("/exam/peak")
	public String peakExamResult(int organizationId, int instituteId, int classId, int subjectId, int userId,
			int studentId, int questionPaperId, int roleId, Model model) {
		try {

			if (roleId == 5) {

				String txtMessage = "Sorry No data available";
				model.addAttribute("txtMessageInMarathi", "क्षमस्व कोणताही डेटा उपलब्ध नाही");
				model.addAttribute("txtMessage", txtMessage);
				return "pages/error/error-exam-peak";

			}
			if (roleId == 45) {

				// Getting UserData
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

				PeakExamResultStatusRequest request = new PeakExamResultStatusRequest(1, organizationId, instituteId, classId,
						tempUserHolder.getDivisionId(), questionPaperId, 1, 0, 100, "", "");

				PeakExamResultListResponse peakExamResultResponse = examDao.fetchPeakExamResults(request);
				List<PeakExamResultHolder> peakExamResults = peakExamResultResponse.getResponseArray();
				System.out.println(peakExamResults.toString());
				model.addAttribute("peakExamResults", peakExamResults);

				return "pages/result/result-peak-table-students";

//				Integer AttendantId = 1;
//				Integer AttendantRoleId = 4;
//				Integer Action = 4;
//
//				DivisionListRequest request = new DivisionListRequest(AttendantId, AttendantRoleId, Action, instituteId,
//						classId, 1, 0, 100, "", "");

				/*
				 * DivisionListRequest request = new DivisionListRequest(AttendantId,
				 * AttendantRoleId, Action, 892, 11, 1, 0, 100, "", "");
				 */

//				DivisionListResponse divisionListResponse = masterDao.fetchDivisionsList(request);
//				List<DivisionHolder> divisionHolders = divisionListResponse.getResponseArray();
//				
//				if (divisionListResponse.getHasError() == 1) {
//					String txtMessage = "No data available this class for your College";
//					model.addAttribute("txtMessage", txtMessage);
//					model.addAttribute("txtMessageInMarathi",
//							"तुमच्या कॉलेजसाठी या वर्गासाठी कोणताही डेटा उपलब्ध नाही");
//					return "pages/error/error-exam-peak";
//				} else {
//					model.addAttribute("divisionHolders", divisionHolders);
//
//					model.addAttribute("organizationId", organizationId);
//					model.addAttribute("instituteId", instituteId);
//					model.addAttribute("classId", classId);
//					model.addAttribute("subjectId", subjectId);
//					model.addAttribute("userId", userId);
//					model.addAttribute("studentId", studentId);
//					model.addAttribute("questionPaperId", questionPaperId);
//					model.addAttribute("roleId", roleId);
//
//					// return "pages/error/error-exam-peak";
//					return "pages/result/result-peak-teacher";
//				}
//				

			} else if (roleId == 44) {

				// ------------------------------------------------------
				// Current Working Region
				// ------------------------------------------------------

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
				//System.out.println(tempUserHolder.toString());

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
				model.addAttribute("questionPaperId", questionPaperId);
				// end - Getting UserData

				// start -Getting Classes
				ClassListRequest classListRequest = new ClassListRequest(1, 4, 3, 0, 19, InstituteId, 1, 0, 100, "",
						"");

				SelectedClassListRepsonse selectedClassListRepsonse = masterDao.fetchSelectedClassesList(classListRequest);
				List<SelectedClassHolder> selectedClassHolders = selectedClassListRepsonse.getResponseArray();
				//System.out.println(selectedClassHolders.toString());
				// end - Getting Classes

				// start - Setting Data
				model.addAttribute("selectedClassHolders", selectedClassHolders);
				// end - Setting data

				return "pages/result/result-peak-classes";
				
			} else {
				String txtMessage = "Currently available for teachers only";
				model.addAttribute("txtMessage", txtMessage);
				model.addAttribute("txtMessageInMarathi", "सध्या फक्त शिक्षकांसाठी उपलब्ध आहे");
				return "pages/error/error-exam-peak";
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
			model.addAttribute("errorMessage", e);
			return "pages/error/somethingwentwrong";
		}
	}

	@GetMapping("/exam/peak/students")
	public String peakExamStudentResultList(int action, int organizationId, int instituteId, int classId,
			int divisionId, int subjectId, int userId, int studentId, int questionPaperId, int roleId, Model model) {
		try {

			PeakExamResultStatusRequest request = new PeakExamResultStatusRequest(1, organizationId, instituteId, classId,
					divisionId, questionPaperId, 1, 0, 100, "", "");
			peakExamResultResponse = examDao.fetchPeakExamResults(request);
			peakExamResults = peakExamResultResponse.getResponseArray();
			System.out.println(peakExamResults.toString());
			model.addAttribute("peakExamResults", peakExamResults);

			return "pages/result/result-peak-table-students";
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
			model.addAttribute("errorMessage", e);
			return "pages/error/somethingwentwrong";
		}
	}

	// ---------------It is working result
	@GetMapping("/exam/regular")
	public String regularExamResult(int studentId, int roleId, int userId, int classId, Model model) {
		try {

			if (roleId == 5) {
				if (classId == 14 || classId == 15 || classId == 16 || classId == 18) {

					// Student Region
					// --REQUEST
					Integer vAttendantId = studentId;
					Integer vAttendantRoleId = roleId;
					Integer vAction = 3;

					Integer vUserId = 0;
					Integer vOrganizationId = 0;
					String vSearch = "";
					TempStudentRequest vRequest = new TempStudentRequest(vAttendantId, vAttendantRoleId, vAction,
							vUserId, vOrganizationId, vSearch);
					TempStuddentListResponse tempStuddentListResponse = userDao.getAdminSearchStudents(vRequest);
					List<TempStudentHolder> tempStudentHolders = tempStuddentListResponse.getResponseArray();
					TempStudentHolder studentHolder = tempStudentHolders.get(0);

					// FETCHING EXAM RESULTS
					// --REQUEST
					Integer AttendantId = 1;
					Integer AttendantRoleId = roleId;
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
						if (examResultHolder.getQuestionPaperId() == 330 || examResultHolder.getQuestionPaperId() == 331
								|| examResultHolder.getQuestionPaperId() == 332
								|| examResultHolder.getQuestionPaperId() == 333
								|| examResultHolder.getQuestionPaperId() == 349) {
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
							double data = examResultHolder.getExamScore();
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
					model.addAttribute("obtainedMarksInWords",
							IntergerToWordConvertor.convertWithCasing(makrsObtained));

					model.addAttribute("percentage", ExamUtils.getPercentage(makrsObtained, totalMarks));
					model.addAttribute("result",
							isPass ? ExamUtils.getResultStatus(makrsObtained, totalMarks) : "ATKT");

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
					// return "pages/error/error-exam-regular-mvp";

					// End Student Region
				} else {
					model.addAttribute("errorMessage", "Only available for 12th Students");
					return "pages/error/error-exam-regular-mvp";
				}
			}

			else if (roleId == 45) {

				if (classId == 14 || classId == 15 || classId == 16 || classId == 18) {

					// TODO : Create StduentsWithResults-->PDFFile-->SaveOnServer

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
					int ClassId = tempUserHolder.getClassId();
					int DivisionId = tempUserHolder.getDivisionId();
					String instituteName = tempUserHolder.getInstituteName();
					String className = tempUserHolder.getClassName();
					String divisionName = tempUserHolder.getDivisionName();

					String fileName = OrganizationId + "" + InstituteId + "" + ClassId + "" + DivisionId + ".json";

					// String filePath = serverPath + fileName;

					// end - creating fileName

					// --start--checkFileExists
					File resultFile = new File(uploadDir + "/" + fileName);
					if (resultFile.exists()) {
						System.out.println("Exists ");
						ObjectMapper mapper = new ObjectMapper();
						ExamRegularResultJsonHolder obj = mapper.readValue(resultFile,
								ExamRegularResultJsonHolder.class);
						examRegularResultUiHolders = obj.getExamRegularResultUiHolders();
					} else {
						System.out.println("Exists Failed");
//							File newResultFile = new File(uploadDir + "/" + fileName);
//							newResultFile.createNewFile();
//							System.out.println(newResultFile.getAbsolutePath() + " File created");

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

						StudentWithStatusListRequest request = new StudentWithStatusListRequest(AttendantId,
								AttendantRoleId, Action, StudentId, UserId, InstituteId, OrganizationId, ClassId,
								DivisionId, DOB, Gender, RecordStatus, Offset, Limit, Search, SyncDate);
						StudentWithStatusListResponse studentWithStatusListResponse = userDao
								.getStudentsForTeachers(request);
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
							System.out.println(
									studentWithStatusHolder.getRollNo() + studentWithStatusHolder.getStudentName());
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
							ExamResultRequest examResultRequest = new ExamResultRequest(vvvAttendantId,
									vvvAttendantRoleId, vvvAction, vResultId, vQuestionPaperId, vStudentId,
									vRecordStatus, vOffset, vLimit, vvvvSearch, vSyncDate);
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
								if (examResultHolder.getQuestionPaperId() == 330
										|| examResultHolder.getQuestionPaperId() == 331
										|| examResultHolder.getQuestionPaperId() == 332
										|| examResultHolder.getQuestionPaperId() == 333
										|| examResultHolder.getQuestionPaperId() == 349) {
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

									// System.out.println(
									// examResultHolder.getQuestionPaperId() + subjectName + "(" + maxMarks + ")");

									// totalMarks = totalMarks + maxMarks;

									double data = examResultHolder.getExamScore();
									int examScore = (int) data;

									// Check Whether Single Subject Attempted Or Not
									if (examScore < 17) {
										isPass = false;
										// System.out.println("isPass=false");
									}

									Integer obtainedMarks = examScore;
									// makrsObtained = makrsObtained + obtainedMarks;

									String obtainedInWords = IntergerToWordConvertor.convertWithCasing(examScore);

									ExamResultUiHolder examResultUiHolder = new ExamResultUiHolder(serialNo,
											subjectName, String.valueOf(maxMarks), String.valueOf(obtainedMarks),
											obtainedInWords);

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
							ExamRegularResultJsonHolder obj = new ExamRegularResultJsonHolder(OrganizationId,
									InstituteId, ClassId, DivisionId, examRegularResultUiHolders);

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

						String ClassName = "";
						if (classId == 14) {
							ClassName = "XII - 12th - Science";
						} else if (classId == 15) {
							ClassName = "XII - 12th - Commerce";
						} else if (classId == 16) {
							ClassName = "XII - 12th - Arts";
						} else if (classId == 18) {
							ClassName = "XII - HSVC";
						}
						String ClassDivisionName = ClassName + "-" + divisionName;
						model.addAttribute("className", ClassDivisionName);
						model.addAttribute("divisionName", divisionName);

						// }

						return "pages/result/result-mvp-teacher-students1";

					}
					// --end--final

				} else {
					model.addAttribute("errorMessage", "Only available for 12th Students");
					return "pages/error/error-exam-regular-mvp";
				}

			} else if (roleId == 44) {

				// ------------------------------------------------------
				// Current Working Region
				// ------------------------------------------------------

				// start- Getting UserData
				Integer vAttendantId = 1;
				Integer vAttendantRoleId = 4;
				Integer vAction = 4;

				Integer vUserId = userId;
				Integer vOrganizationId = 1;
				String vSearch = "";

				TempUserRequest vRequest = new TempUserRequest(vAttendantId, vAttendantRoleId, vAction, vUserId,
						vOrganizationId, vSearch);

				tempUserListResponse = userDao.getAdminSearchUsers(vRequest);
				tempUserHolders = tempUserListResponse.getResponseArray();
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
				ClassListRequest classListRequest = new ClassListRequest(1, 4, 3, 0, 19, InstituteId, 1, 0, 100, "",
						"");

				SelectedClassListRepsonse selectedClassListRepsonse = masterDao
						.fetchSelectedClassesList(classListRequest);
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

			} else {
				model.addAttribute("errorMessage", "Only available for 12th Students");
				return "pages/error/error-exam-regular-mvp";
			}

		} catch (Exception e) {
			System.err.println(e);
			model.addAttribute("errorMessage", e);
			return "pages/error/somethingwentwrong";
		}
		// 12th EXAM RESULT ONLY (classId=12)
		// return "pages/error/nodatafound";
	}

	@GetMapping("/exam/regular/result/url")
	public String regularExamResultStudents(int action, int organizationId, int instituteId, int classId,
			int divisionId, String instituteName, String className, String divisionName, Model model) {
		try {

//			DivisionListRequest divisionListRequest = new DivisionListRequest(1, 4, 4, instituteId, classId, 1, 0, 100,
//					"", "");
//			divisionListResponse = masterDao.fetchDivisionsList(divisionListRequest);
//			divisionHolders = divisionListResponse.getResponseArray();
//			for (int i = 0; i < divisionHolders.size(); i++) {
//				DivisionHolder divisionHolder = divisionHolders.get(i);

			examRegularResultUiHolders = new ArrayList<ExamRegularResultUiHolder>();

			// *******SERVER PATH******************

			// String serverPath = "C:\\Users\\TargetPeak-Mohan\\Desktop\\results\\";
			String serverPath = "https://revoeducation.in/mvp-results/";
			// String serverPath = "/root/Documents/targetpeak/mvp/results/";
			// *******SERVER PATH******************

			// String fileName = organizationId + "" + instituteId + classId + "" +
			// divisionHolder.getDivisionId()+ ".json";
			String fileName = organizationId + "" + instituteId + classId + "" + divisionId + ".json";
			String filePath = serverPath + fileName;

			ObjectMapper mapper = new ObjectMapper();
			ExamRegularResultJsonHolder obj = mapper.readValue(new URL(filePath), ExamRegularResultJsonHolder.class);

			// JSON string to Java Object

			examRegularResultUiHolders = obj.getExamRegularResultUiHolders();

			if (examRegularResultUiHolders == null) {
				return "pages/error/nodatafound";
			} else {

				model.addAttribute("examRegularResultUiHolders", examRegularResultUiHolders);
				model.addAttribute("instituteName", instituteName);

				String ClassName = "";
				if (classId == 14) {
					ClassName = "XII - 12th - Science";
				} else if (classId == 15) {
					ClassName = "XII - 12th - Commerce";
				} else if (classId == 16) {
					ClassName = "XII - 12th - Arts";
				} else if (classId == 17) {
					ClassName = "XII - HSVC";
				}
				String ClassDivisionName = ClassName + "-" + divisionName;
				model.addAttribute("className", ClassDivisionName);
				model.addAttribute("divisionName", divisionName);

				// }

				return "pages/result/result-mvp-teacher-students1";

			}

		} catch (Exception e) {
			System.err.println(e);
			return "pages/error/somethingwentwrong";
		}
		// return "pages/error/nodatafound";
	}

	@GetMapping("/checkpath")
	public void checkPath() {
		boolean available = false;
		File file;
		try {

			Resource resource = resourceLoader.getResource("classpath:attachments/results/19001452.json");
			if (resource.exists()) {
				available = true;
			} else {
				available = false;
			}

			/*
			 * file = new ClassPathResource("attachments/results/19001452.json").getFile();
			 * if (file.exists()) { available = true; }
			 */

			System.out.println(available);
		} catch (Exception e) {
			System.err.println(e);
		}

	}

	// ---------------It is working result
	// code------------------------------------------------
	// ########################################################################################
	@GetMapping("/exam/regular/result/check")
	// @GetMapping("/exam/regular/result")
	public String regularExamResultStudentsTemp(int action, int organizationId, int instituteId, int classId,
			int divisionId, String instituteName, String className, String divisionName, Model model) {
		try {

			examRegularResultUiHolders = new ArrayList<ExamRegularResultUiHolder>();

			// *******SERVER PATH******************
			String serverPath = "attachments/results/";
			// *******SERVER PATH******************

			String fileName = organizationId + "" + instituteId + classId + "" + divisionId + ".json";
			String filePath = serverPath + fileName;

			// file = new ClassPathResource(filePath).getFile();
			// File resultFile = new File(filePath);

			File resultFile = null;
			try {
				System.out.println(filePath);
				resultFile = new ClassPathResource(filePath).getFile();
			} catch (Exception e) {
				// TODO: handle exception
			}

			if (!(resultFile == null)) {

				if (resultFile.exists()) {
					System.out.println("Exists");
					ObjectMapper mapper = new ObjectMapper();

					// JSON file to Java object
					ExamRegularResultJsonHolder obj = mapper.readValue(resultFile, ExamRegularResultJsonHolder.class);
					examRegularResultUiHolders = obj.getExamRegularResultUiHolders();

					if (examRegularResultUiHolders == null) {
						return "pages/error/nodatafound";
					} else {

						model.addAttribute("examRegularResultUiHolders", examRegularResultUiHolders);
						model.addAttribute("instituteName", instituteName);

						String ClassName = "";
						if (classId == 14) {
							ClassName = "XII - 12th - Science";
						} else if (classId == 15) {
							ClassName = "XII - 12th - Commerce";
						} else if (classId == 16) {
							ClassName = "XII - 12th - Arts";
						} else if (classId == 18) {
							ClassName = "XII - 12th - HSVC";
						}
						String ClassDivisionName = ClassName + "-" + divisionName;
						model.addAttribute("className", ClassDivisionName);
						model.addAttribute("divisionName", divisionName);

						// }

						return "pages/result/result-mvp-teacher-students1";

					}

				}

			} else {
				return "pages/error/nodatafound";
			}

		} catch (Exception e) {
			System.err.println(e);
			return "pages/error/somethingwentwrong";
		}

		return "pages/error/nodatafound";
	}

	// @GetMapping("/exam/regular/result/check")
	@GetMapping("/exam/regular/result")
	public String regularExamResultStudentsTempCheck(int action, int organizationId, int instituteId, int classId,
			int divisionId, String instituteName, String className, String divisionName, Model model) {
		try {

			ArrayList<ExamRegularResultUiHolder> examRegularResultUiHolders = new ArrayList<ExamRegularResultUiHolder>();

			// ******* SERVER PATH ******************
			String serverPath = "C:\\Users\\TargetPeak-Mohan\\Desktop\\results\\";
			// String serverPath = "attachments/results/";
			// ******* SERVER PATH ******************

			// ******* FILE PATH ******************
			String fileName = organizationId + "" + instituteId + classId + "" + divisionId + ".json";
			String filePath = serverPath + fileName;
			// ******* FILE PATH ******************

			// --region FileCheck
			File resultFile = new File(filePath);
			if (resultFile.exists()) {
				System.out.println("File already Exists");
				ObjectMapper mapper = new ObjectMapper();
				ExamRegularResultJsonHolder obj = mapper.readValue(resultFile, ExamRegularResultJsonHolder.class);
				examRegularResultUiHolders = obj.getExamRegularResultUiHolders();

			} else {

				// ---StudentData Fetching
				// Request
				Integer AttendantId = 1;
				Integer AttendantRoleId = 4;
				Integer Action = 2;

				Integer StudentId = 0;
				Integer UserId = 0;
				Integer InstituteId = instituteId;
				Integer OrganizationId = organizationId;
				Integer ClassId = classId;
				Integer DivisionId = divisionId;
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
					Integer vAttendantId = 1;
					Integer vAttendantRoleId = 5;
					Integer vAction = 3;
					Integer vResultId = 0;
					Integer vQuestionPaperId = 0;
					Integer vStudentId = studentWithStatusHolder.getStudentId();
					Integer vRecordStatus = 1;
					Integer vOffset = 0;
					Integer vLimit = 100;
					String vSearch = "";
					String vSyncDate = "";
					ExamResultRequest examResultRequest = new ExamResultRequest(vAttendantId, vAttendantRoleId, vAction,
							vResultId, vQuestionPaperId, vStudentId, vRecordStatus, vOffset, vLimit, vSearch,
							vSyncDate);
					ExamResultListResponse examResultListResponse = examDao.fetchExamResults(examResultRequest);
					List<ExamResultHolder> examResultHolders = examResultListResponse.getResponseArray();

					ArrayList<ExamResultUiHolder> examResultUiHolders = new ArrayList<ExamResultUiHolder>();
					int j;
					int totalMarks = 0;
					int makrsObtained = 0;
					boolean isPass = true;

					for (j = 0; j < examResultHolders.size(); j++) {
						ExamResultHolder examResultHolder = examResultHolders.get(j);
						// Ignore Demo-EnglishPaper
						if (examResultHolder.getQuestionPaperId() == 330 || examResultHolder.getQuestionPaperId() == 331
								|| examResultHolder.getQuestionPaperId() == 332
								|| examResultHolder.getQuestionPaperId() == 333
								|| examResultHolder.getQuestionPaperId() == 349) {
							// leave this QuestionPaper as this is demo
						} else {
							Integer serialNo = (j + 1);
							// String subjectName = examResultHolder.getSubjectName();
							String subjectName = examResultHolder.getPaperName().toUpperCase();

							int maxMarks = 0;

							double positiveMarks = examResultHolder.getPositiveMarking() == null ? 1.0
									: examResultHolder.getPositiveMarking();
							int postiveMark = (int) positiveMarks;

							// System.out.println(postiveMark);

							maxMarks = (examResultHolder.getTotalQuestions() * postiveMark);

							// System.out.println(
							// examResultHolder.getQuestionPaperId() + subjectName + "(" + maxMarks + ")");

							totalMarks = totalMarks + maxMarks;

							double data = examResultHolder.getExamScore();
							int examScore = (int) data;

							// Check Whether Single Subject Attempted Or Not
							if (examScore < 17) {
								isPass = false;
								// System.out.println("isPass=false");
							}

							Integer obtainedMarks = examScore;
							makrsObtained = makrsObtained + obtainedMarks;

							String obtainedInWords = IntergerToWordConvertor.convertWithCasing(examScore);

							ExamResultUiHolder examResultUiHolder = new ExamResultUiHolder(serialNo, subjectName,
									String.valueOf(maxMarks), String.valueOf(obtainedMarks), obtainedInWords);
							// System.out.println(examResultUiHolder.toString());
							examResultUiHolders.add(examResultUiHolder);

						}

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
					ExamRegularResultJsonHolder obj = new ExamRegularResultJsonHolder(organizationId, instituteId,
							classId, divisionId, examRegularResultUiHolders);
					mapper.writeValue(new File(filePath), obj);
					System.out.println(filePath + "Created....");

				} catch (Exception e) {
					System.err.println(e);
				}

			}

			if (examRegularResultUiHolders == null) {
				return "pages/error/nodatafound";
			} else {

				model.addAttribute("examRegularResultUiHolders", examRegularResultUiHolders);
				model.addAttribute("instituteName", instituteName);

				String ClassName = "";
				if (classId == 14) {
					ClassName = "XII - 12th - Science";
				} else if (classId == 15) {
					ClassName = "XII - 12th - Commerce";
				} else if (classId == 16) {
					ClassName = "XII - 12th - Arts";
				} else if (classId == 17) {
					ClassName = "XII - HSVC";
				}
				String ClassDivisionName = ClassName + "-" + divisionName;
				model.addAttribute("className", ClassDivisionName);
				model.addAttribute("divisionName", divisionName);

				// }

				return "pages/result/result-mvp-teacher-students1";

			}

		} catch (Exception e) {
			System.err.println(e);
			return "pages/error/somethingwentwrong";
		}

	}

	@GetMapping("/exam/regular/divisions")
	public String regularExamDivisions(int organizationId, int instituteId, String instituteName, int classId,
			String className, Model model) {
		DivisionListRequest divisionListRequest = new DivisionListRequest(1, 4, 4, instituteId, classId, 1, 0, 100, "",
				"");
		DivisionListResponse divisionListResponse = masterDao.fetchDivisionsList(divisionListRequest);
		List<DivisionHolder> divisionHolders = divisionListResponse.getResponseArray();

		model.addAttribute("organizationId", organizationId);
		model.addAttribute("instituteId", instituteId);
		model.addAttribute("instituteName", instituteName);
		model.addAttribute("classId", classId);
		model.addAttribute("className", className);

		model.addAttribute("divisionHolders", divisionHolders);

		return "pages/result/result-regular-class-divisions";
	}
	
	
	@GetMapping("/exam/peak/divisions")
	public String peakExamDivisions(int organizationId, int instituteId,  int classId,int questionPaperId, Model model) {
		
		DivisionListRequest divisionListRequest = new DivisionListRequest(1, 4, 4, instituteId, classId, 1, 0, 100, "",
				"");
		DivisionListResponse divisionListResponse = masterDao.fetchDivisionsList(divisionListRequest);
		List<DivisionHolder> divisionHolders = divisionListResponse.getResponseArray();
		
		model.addAttribute("organizationId", organizationId);
		model.addAttribute("instituteId", instituteId);
		model.addAttribute("classId", classId);
		
		model.addAttribute("subjectId", 0);
		model.addAttribute("userId", 0);
		model.addAttribute("studentId", 0);
		model.addAttribute("questionPaperId", questionPaperId);
		model.addAttribute("roleId", 44);

		model.addAttribute("divisionHolders", divisionHolders);

		return "pages/result/result-peak-class-divisions";
	}

	@GetMapping("/exam/regular/divisions/result")
	public String regularExamDivisionsResults(int organizationId, int instituteId, int classId, int divisionId,
			String instituteName, String className, String divisionName, Model model) {

		try {

			ArrayList<ExamRegularResultUiHolder> examRegularResultUiHolders = new ArrayList<ExamRegularResultUiHolder>();

			String uploadDir = new ClassPathResource(".").getFile().getAbsolutePath();
			System.out.println("UploadDir : " + uploadDir);

			String fileName = organizationId + "" + instituteId + "" + classId + "" + divisionId + ".json";

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
						Action, StudentId, UserId, instituteId, organizationId, classId, divisionId, DOB, Gender,
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
						if (examResultHolder.getQuestionPaperId() == 330 || examResultHolder.getQuestionPaperId() == 331
								|| examResultHolder.getQuestionPaperId() == 332
								|| examResultHolder.getQuestionPaperId() == 333
								|| examResultHolder.getQuestionPaperId() == 349) {
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

							// System.out.println(
							// examResultHolder.getQuestionPaperId() + subjectName + "(" + maxMarks + ")");

							// totalMarks = totalMarks + maxMarks;

							double data = examResultHolder.getExamScore();
							int examScore = (int) data;

							// Check Whether Single Subject Attempted Or Not
							if (examScore < 17) {
								isPass = false;
								// System.out.println("isPass=false");
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
					ExamRegularResultJsonHolder obj = new ExamRegularResultJsonHolder(organizationId, instituteId,
							classId, divisionId, examRegularResultUiHolders);

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

				String ClassName = "";
				if (classId == 14) {
					ClassName = "XII - 12th - Science";
				} else if (classId == 15) {
					ClassName = "XII - 12th - Commerce";
				} else if (classId == 16) {
					ClassName = "XII - 12th - Arts";
				} else if (classId == 18) {
					ClassName = "XII - HSVC";
				}
				String ClassDivisionName = ClassName + "-" + divisionName;
				model.addAttribute("className", ClassDivisionName);
				model.addAttribute("divisionName", divisionName);

				// }

				return "pages/result/result-mvp-teacher-students1";

			}
			// --end--final

		} catch (Exception e) {
			System.err.println(e);
			return "pages/error/somethingwentwrong";
		}

	}

}
