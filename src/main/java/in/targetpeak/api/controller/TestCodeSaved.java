package in.targetpeak.api.controller;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.targetpeak.api.entity.result.ExamRegularResultJsonHolder;
import in.targetpeak.api.entity.result.ExamRegularResultUiHolder;
import in.targetpeak.api.entity.result.ExamResultHolder;
import in.targetpeak.api.entity.result.ExamResultRequest;
import in.targetpeak.api.entity.result.ExamResultUiHolder;
import in.targetpeak.api.entity.student.StudentWithStatusHolder;
import in.targetpeak.api.entity.student.StudentWithStatusListRequest;
import in.targetpeak.api.util.ExamUtils;
import in.targetpeak.api.util.IntergerToWordConvertor;

public class TestCodeSaved {

	//File resultFile = new File(filePath);
//	if (resultFile.exists()) {
//		System.out.println("Exists");
//		ObjectMapper mapper = new ObjectMapper();
//
//		// JSON file to Java object
//		//ExamRegularResultJsonHolder obj = mapper.readValue(resultFile, ExamRegularResultJsonHolder.class);
//
//		// JSON URL to Java object
//		ExamRegularResultJsonHolder obj = mapper.readValue(new URL(serverPath),
//				ExamRegularResultJsonHolder.class);
//
//		// JSON string to Java Object
//		// Staff obj = mapper.readValue("{'name' : 'mkyong'}", Staff.class);
//
//		examRegularResultUiHolders = obj.getExamRegularResultUiHolders();
//
//	} else {
//
//		// ---StudentData Fetching
//		// Request
//		Integer AttendantId = 1;
//		Integer AttendantRoleId = 4;
//		Integer Action = 2;
//
//		Integer StudentId = 0;
//		Integer UserId = 0;
//		Integer InstituteId = instituteId;
//		Integer OrganizationId = organizationId;
//		Integer ClassId = classId;
//		Integer DivisionId = divisionId;
//		String DOB = "";
//		Integer Gender = 0;
//
//		Integer RecordStatus = 0;
//		Integer Offset = 0;
//		Integer Limit = 1000;
//		String Search = "";
//		String SyncDate = "";
//
//		StudentWithStatusListRequest request = new StudentWithStatusListRequest(AttendantId,
//				AttendantRoleId, Action, StudentId, UserId, InstituteId, OrganizationId, ClassId,
//				DivisionId, DOB, Gender, RecordStatus, Offset, Limit, Search, SyncDate);
//		studentWithStatusListResponse = userDao.getStudentsForTeachers(request);
//		studentWithStatusHolders = studentWithStatusListResponse.getResponseArray();
//
//		model.addAttribute("studentWithStatusHolders", studentWithStatusHolders);
//
//		// --Creating new list for ExamUiHolder
//		// --We want whole result in one collection
//		// ArrayList<ExamRegularResultUiHolder> examRegularResultUiHolders = new
//		// ArrayList<ExamRegularResultUiHolder>();
//		int k = 0;
//		for (StudentWithStatusHolder studentWithStatusHolder : studentWithStatusHolders) {
//			System.out.println("Row:" + k);
//			System.out.println(
//					studentWithStatusHolder.getRollNo() + studentWithStatusHolder.getStudentName());
//			ExamRegularResultUiHolder examRegularResultUiHolder = new ExamRegularResultUiHolder();
//
//			// Fetching Result for EachStduent
//			Integer vAttendantId = 1;
//			Integer vAttendantRoleId = 5;
//			Integer vAction = 3;
//			Integer vResultId = 0;
//			Integer vQuestionPaperId = 0;
//			Integer vStudentId = studentWithStatusHolder.getStudentId();
//			Integer vRecordStatus = 1;
//			Integer vOffset = 0;
//			Integer vLimit = 100;
//			String vSearch = "";
//			String vSyncDate = "";
//			ExamResultRequest examResultRequest = new ExamResultRequest(vAttendantId, vAttendantRoleId,
//					vAction, vResultId, vQuestionPaperId, vStudentId, vRecordStatus, vOffset, vLimit,
//					vSearch, vSyncDate);
//			examResultListResponse = examDao.fetchExamResults(examResultRequest);
//			examResultHolders = examResultListResponse.getResponseArray();
//
//			ArrayList<ExamResultUiHolder> examResultUiHolders = new ArrayList<ExamResultUiHolder>();
//			int j;
//			int totalMarks = 0;
//			int makrsObtained = 0;
//			boolean isPass = true;
//
//			for (j = 0; j < examResultHolders.size(); j++) {
//				ExamResultHolder examResultHolder = examResultHolders.get(j);
//				// Ignore Demo-EnglishPaper
//				if (examResultHolder.getQuestionPaperId() == 330
//						|| examResultHolder.getQuestionPaperId() == 331
//						|| examResultHolder.getQuestionPaperId() == 332
//						|| examResultHolder.getQuestionPaperId() == 333
//						|| examResultHolder.getQuestionPaperId() == 349) {
//					// leave this QuestionPaper as this is demo
//				} else {
//					Integer serialNo = (j + 1);
//					// String subjectName = examResultHolder.getSubjectName();
//					String subjectName = examResultHolder.getPaperName().toUpperCase();
//
//					int maxMarks = 0;
//
//					double positiveMarks = examResultHolder.getPositiveMarking() == null ? 1.0
//							: examResultHolder.getPositiveMarking();
//					int postiveMark = (int) positiveMarks;
//
//					// System.out.println(postiveMark);
//
//					maxMarks = (examResultHolder.getTotalQuestions() * postiveMark);
//
//					// System.out.println(
//					// examResultHolder.getQuestionPaperId() + subjectName + "(" + maxMarks + ")");
//
//					totalMarks = totalMarks + maxMarks;
//
//					double data = examResultHolder.getExamScore();
//					int examScore = (int) data;
//
//					// Check Whether Single Subject Attempted Or Not
//					if (examScore < 17) {
//						isPass = false;
//						// System.out.println("isPass=false");
//					}
//
//					Integer obtainedMarks = examScore;
//					makrsObtained = makrsObtained + obtainedMarks;
//
//					String obtainedInWords = IntergerToWordConvertor.convertWithCasing(examScore);
//
//					ExamResultUiHolder examResultUiHolder = new ExamResultUiHolder(serialNo, subjectName,
//							String.valueOf(maxMarks), String.valueOf(obtainedMarks), obtainedInWords);
//					// System.out.println(examResultUiHolder.toString());
//					examResultUiHolders.add(examResultUiHolder);
//
//				}
//
//			}
//
//			// --ADDING TWO MORE SUBJECTS
//			// examResultUiHolders.add(new ExamResultUiHolder((i + 1), "EVS", "", "", ""));
//			// examResultUiHolders.add(new ExamResultUiHolder((i + 2), "Physical Education",
//			// "", "", ""));
//			// endregion
//			// System.out.println(examResultUiHolders.toString());
//
//			// --Adding all data to one collection now
//			// Setting StudentData
//
//			examRegularResultUiHolder.setRollNo(studentWithStatusHolder.getRollNo());
//			examRegularResultUiHolder.setStudentName(studentWithStatusHolder.getStudentName());
//			examRegularResultUiHolder.setExamResultUiHolders(examResultUiHolders);
//			examRegularResultUiHolder.setMaximumMarks(totalMarks);
//			examRegularResultUiHolder.setObtainedMarks(makrsObtained);
//			examRegularResultUiHolder
//					.setPercentage(ExamUtils.getPercentage(makrsObtained, totalMarks) == null ? "0"
//							: ExamUtils.getPercentage(makrsObtained, totalMarks));
//			examRegularResultUiHolder
//					.setResult(isPass ? ExamUtils.getResultStatus(makrsObtained, totalMarks) : "ATKT");
//
//			examRegularResultUiHolders.add(examRegularResultUiHolder);
//			k++;
//
//		}
//
//		// System.out.println(examRegularResultUiHolders.toString());
//
//		try {
//
//			ObjectMapper mapper = new ObjectMapper();
//			ExamRegularResultJsonHolder obj = new ExamRegularResultJsonHolder(organizationId, instituteId,
//					classId,divisionId, examRegularResultUiHolders);
//			// 13891452;
//			// String fileName = organizationId + "" + instituteId + classId + "" +
//			// divisionId + ".json";
//			mapper.writeValue(new File(filePath), obj);
//			String jsonInString = mapper.writeValueAsString(obj);
//			System.out.println(filePath +"Created....");
//
//		} catch (Exception e) {
//			System.err.println(e);
//		}
//
//	}
	
	
}
