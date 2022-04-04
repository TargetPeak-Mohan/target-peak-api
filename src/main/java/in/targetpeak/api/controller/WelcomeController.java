package in.targetpeak.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import com.google.common.util.concurrent.Service;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import in.targetpeak.api.dao.ExamDao;
import in.targetpeak.api.dao.UserDao;
import in.targetpeak.api.dao.UtilDao;
import in.targetpeak.api.entity.admin.students.TempStuddentListResponse;
import in.targetpeak.api.entity.admin.students.TempStudentHolder;
import in.targetpeak.api.entity.admin.students.TempStudentRequest;
import in.targetpeak.api.entity.result.ExamResultHolder;
import in.targetpeak.api.entity.result.ExamResultListResponse;
import in.targetpeak.api.entity.result.ExamResultRequest;
import in.targetpeak.api.entity.result.ExamResultUiHolder;
import in.targetpeak.api.entity.util.version.VersionHolder;
import in.targetpeak.api.entity.util.version.VersionListRequest;
import in.targetpeak.api.entity.util.version.VersionListResponse;
import in.targetpeak.api.entity.util.versions.Version;
import in.targetpeak.api.service.UtilService;
import in.targetpeak.api.service.WelcomeService;
import in.targetpeak.api.util.ExamUtils;
import in.targetpeak.api.util.IntergerToWordConvertor;
import io.swagger.annotations.Api;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RequestMapping(value = "/welcome")
@Api(tags = "Welcome", value = "Authentication(Organization,Institute,Class,Division) Resource REST Endpoint", description = "")
@Controller
public class WelcomeController {
	// @Autowired
	// private UtilService utilService;

	@Autowired
	UtilDao utilDao;

	@Autowired
	ExamDao examDao;

	@Autowired
	UserDao userDao;

	private static VersionListResponse response = new VersionListResponse();
	private static List<Version> versions = new ArrayList<Version>();
	private static List<VersionHolder> versionHolders = new ArrayList<VersionHolder>();

	// region ExamResults fetch
	private static TempStuddentListResponse tempStuddentListResponse = new TempStuddentListResponse();
	private static List<TempStudentHolder> tempStudentHolders = new ArrayList<TempStudentHolder>();

	// region ExamResults fetch
	private static ExamResultListResponse examResultListResponse = new ExamResultListResponse();
	private static List<ExamResultHolder> examResultHolders = new ArrayList<ExamResultHolder>();

	static {
		// versions.add(new Version(1, "android"));
		// versions.add(new Version(2, "web"));
		// versions.add(new Version(3, "react"));

		/*
		 * VersionListRequest request = new VersionListRequest(1, "android", 1);
		 * UtilService utilService1 =new UtilService(); VersionListResponse response =
		 * utilService1.getVersionList(request); List<VersionHolder> versionholders =
		 * response.getResponseArray(); ArrayList<Version> versions = new
		 * ArrayList<Version>(); for (VersionHolder versionHolder : versionholders) {
		 * versions.add(new Version(versionHolder.getAppVersionId(),
		 * versionHolder.getEnvironment())); }
		 */

	}

	@GetMapping("/test")
	public String welcome(Model model) {
		response = utilDao.getVersions(new VersionListRequest(1, "android", 1));
		versionHolders = response.getResponseArray();
		System.out.println(versions.toString());
		model.addAttribute("versionHolders", versionHolders);
		return "/welcome";
	}

	@GetMapping("/test/result")
	public String result(Model model) {
		response = utilDao.getVersions(new VersionListRequest(1, "android", 1));
		versionHolders = response.getResponseArray();
		System.out.println(versions.toString());
		model.addAttribute("versionHolders", versionHolders);
		return "pages/result/result-single";
	}

	@GetMapping("/test/result1")
	public String result1(int studentId, int roleId, int userId, int classId, Model model) {

		try {
			if (classId == 14 || classId == 15 || classId == 16 || classId == 18) {
				// FETCHING STUDENT DETAILS

				// --REQUEST
				Integer vAttendantId = studentId;
				Integer vAttendantRoleId = roleId;
				Integer vAction = 3;

				Integer vUserId = 0;
				Integer vOrganizationId = 0;
				String vSearch = "";
				TempStudentRequest vRequest = new TempStudentRequest(vAttendantId, vAttendantRoleId, vAction, vUserId,
						vOrganizationId, vSearch);
				tempStuddentListResponse = userDao.getAdminSearchStudents(vRequest);
				tempStudentHolders = tempStuddentListResponse.getResponseArray();
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
				examResultListResponse = examDao.fetchExamResults(request);
				// System.out.println(examResultListResponse.toString());
				examResultHolders = examResultListResponse.getResponseArray();
				ArrayList<ExamResultUiHolder> examResultUiHolders = new ArrayList<ExamResultUiHolder>();
				int i;
				int totalMarks = 0;
				int makrsObtained = 0;
				boolean isPass = true;
				for (i = 0; i < examResultHolders.size(); i++) {
					ExamResultHolder examResultHolder = examResultHolders.get(i);
					// Ignore Demo-EnglishPaper
					if (examResultHolder.getQuestionPaperId() == 330) {
						// leave this QuestionPaper as this is demo
					} else {
						Integer serialNo = (i + 1);
						// String subjectName = examResultHolder.getSubjectName();
						String subjectName = examResultHolder.getPaperName();

						int maxMarks = 0;

						double positiveMarks = examResultHolder.getPositiveMarking() == null ? 0.0
								: examResultHolder.getPositiveMarking();
						int postiveMark = (int) positiveMarks;

						System.out.println(postiveMark);

						maxMarks = (examResultHolder.getTotalQuestions() * postiveMark);

						totalMarks = totalMarks + maxMarks;

						double data = examResultHolder.getExamScore();
						int examScore = (int) data;

						// Check Whether Single Subject Attempted Or Not
						if (examScore < 17) {
							isPass = false;
							System.out.println("isPass=false");
						}

						Integer obtainedMarks = examScore;
						makrsObtained = makrsObtained + obtainedMarks;

						String obtainedInWords = IntergerToWordConvertor.convertWithCasing(examScore);

						examResultUiHolders.add(new ExamResultUiHolder(serialNo, subjectName, String.valueOf(maxMarks),
								String.valueOf(obtainedMarks), obtainedInWords));
					}

				}

				// --ADDING TWO MORE SUBJECTS
				examResultUiHolders.add(new ExamResultUiHolder((i + 1), "EVS", "", "", ""));
				examResultUiHolders.add(new ExamResultUiHolder((i + 2), "Physical Education", "", "", ""));

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
		} catch (Exception e) {
			return "pages/error/somethingwentwrong";
		}
		// 12th EXAM RESULT ONLY (classId=12)
		return "pages/error/nodatafound";
	}

	@GetMapping("/test/result2")
	public String result2(Model model) {
		response = utilDao.getVersions(new VersionListRequest(1, "android", 1));
		versionHolders = response.getResponseArray();
		System.out.println(versions.toString());
		model.addAttribute("versionHolders", versionHolders);
		return "pages/result/result-single2";
	}

	@GetMapping("/welcome1")
	public String welcome1(Model model) {
		response = utilDao.getVersions(new VersionListRequest(1, "android", 1));
		versionHolders = response.getResponseArray();
		System.out.println(versions.toString());
		model.addAttribute("versionHolders", versionHolders);
		return "welcome1";
	}

	@GetMapping("/progressbar")
	public String showProgressbar(Model model) {
		// response = utilDao.getVersions(new VersionListRequest(1, "android", 1));
		// versionHolders = response.getResponseArray();
		// System.out.println(versions.toString());
		// model.addAttribute("versionHolders", versionHolders);
		return "/common/progressbar";
	}

	@RequestMapping("/progressbar/test")
	public ResponseBodyEmitter handleRequest() {

		final ResponseBodyEmitter emitter = new ResponseBodyEmitter();
		ExecutorService service = Executors.newSingleThreadExecutor();
		service.execute(() -> {
			for (int i = 0; i < 1000; i++) {
				try {
					// an HttpMessageConverter will convert BigDecimal in proper format
					emitter.send(new BigDecimal(i));
					emitter.send(" - ", MediaType.TEXT_PLAIN);

					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
					emitter.completeWithError(e);
					return;
				}
			}
			emitter.complete();
		});

		return emitter;
	}

	@RequestMapping("/progressbar/test1")
	public ResponseBodyEmitter handleRequest1() {

		final ResponseBodyEmitter emitter = new ResponseBodyEmitter();
		ExecutorService service = Executors.newSingleThreadExecutor();
		service.execute(() -> {

			for (int i = 0; i < 101; i++) {

				try {

					if(i==100) {
						emitter.send("Done", MediaType.TEXT_PLAIN);
					}else {
						emitter.send("common/progressbar", MediaType.APPLICATION_XML);
					}	

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			emitter.complete();
		});

		return emitter;
	}

}
