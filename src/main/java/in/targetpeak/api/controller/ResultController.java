package in.targetpeak.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import in.targetpeak.api.entity.exam.peak.PeakExamFinalResultRequest;
import in.targetpeak.api.entity.exam.peak.PeakExamStatusRequest;
import in.targetpeak.api.entity.result.peak.PeakExamStudentListRequest;
import in.targetpeak.api.entity.result.regular.RegularExamStudentListRequest;
import in.targetpeak.api.entity.result.regular.RegularExamStudentRequest;
import in.targetpeak.api.service.ResultService;
import io.swagger.annotations.Api;

@RequestMapping(value = "/result")
@Api(tags = "Result Web pages", value = "All the result webpages APIs available here", description = "")
@Controller
public class ResultController {

	@Autowired
	ResultService resultService;
	
	
	/*
	 * @GetMapping("/getPeakStatus") public String getPeakStatus(int roleId, Model
	 * model) { String responsePage; try { if (roleId == 5) { responsePage =
	 * resultService.getPeakStatusStudent(model); } else { responsePage =
	 * resultService.getPeakErrorUnauthorizeResult(model); } } catch (Exception e) {
	 * responsePage = resultService.getPeakErrorResult(model); }
	 * 
	 * return responsePage; }
	 */


	@GetMapping("/getPeakResult")
	public String getPeakResult(int roleId, Model model) {
		String responsePage;
		try {
			if (roleId == 5) {
				responsePage = resultService.getPeakStudentResult(model);
			} else {
				responsePage = resultService.getPeakErrorUnauthorizeResult(model);
			}
		} catch (Exception e) {
			responsePage = resultService.getPeakErrorResult(model);
		}

		return responsePage;
	}

	@GetMapping("/getRegularResult")
	public String getRegularResult(int studentId, int roleId, int userId, int classId, int divisionId, Model model) {
		String responsePage = resultService.getRegularExamErrorResult(model);

		if (classId == 11 || classId == 12 || classId == 13 || classId == 19) {
			if (roleId == 5) {
				responsePage = resultService.getRegularExamEleventhStudentResult(studentId, model);
			} else if (roleId == 45) {
				responsePage = resultService.getRegularExamEleventhTeacherStudentsResult(userId, model);
			} else if (roleId == 44) {
				responsePage = resultService.getRegularExamEleventhCoordinatorResult(userId, model);
			} else {
				responsePage = resultService.getRegularExamErrorUnauthorizeResult(model);
			}
		} else if (classId == 14 || classId == 15 || classId == 16 || classId == 18) {
			if (roleId == 5) {
				// responsePage = resultService.getRegularExamEleventhStudentResult(studentId,
				// model);
			} else if (roleId == 45) {
				// responsePage =
				// resultService.getRegularExamEleventhTeacherStudentsResult(userId, model);
			} else {
				// responsePage = resultService.getRegularExamErrorUnauthorizeResult(model);
			}
		} else {

		}

		return responsePage;
	}

	// ------------------------------------------------------------------------------
	// -- REGULAR-REGION
	// ------------------------------------------------------------------------------

	// ------YET- Working Live ------
	@GetMapping("/getRegularExamStudentResult")
	public String getRegularExamStudentResult(RegularExamStudentRequest request, Model model) {
		String responsePage = resultService.getRegularExamErrorResult(model);

		int classId = request.getClassId();
		// ----- 11th 12th Open
		if (classId == 11 || classId == 12 || classId == 13 || classId == 19 || classId == 14 || classId == 15
				|| classId == 16 || classId == 18) {
			responsePage = resultService.getRegularExamStudentResult("EVS", "PHYSICAL EDUCATION", request, model);
		} else {
			responsePage = resultService.getRegularExamErrorCustom("Not available", "Result will display soon",
					"निकाल लवकरच प्रदर्शित होईल", model);
		}

		return responsePage;
	}

	// ------YET- Working Live ------
	@GetMapping("/getRegularExamStudentResultList")
	public String getRegularExamStudentResultList(RegularExamStudentListRequest request, Model model) {
		String responsePage = resultService.getRegularExamErrorResult(model);

		int classId = request.getClassId();

		// ----- 11th 12th Open
		if (classId == 5 || classId == 6 || classId == 7 || classId == 8 || classId == 9 || classId == 11
				|| classId == 12 || classId == 13 || classId == 19 || classId == 14 || classId == 15 || classId == 16
				|| classId == 18) {
//			responsePage = resultService.getRegularExamStudentsResultList("EVS", "PHYSICAL EDUCATION", userId,
//					organizationId, instituteId, classId, divisionId, examinationId, model);

			responsePage = resultService.getRegularExamStudentsResultList("EVS", "PHYSICAL EDUCATION", request, model);

		} else {
			responsePage = resultService.getRegularExamErrorCustom("Not available", "Result will display soon",
					"निकाल लवकरच प्रदर्शित होईल", model);
		}

		return responsePage;
	}

	// ------YET- Working Live ------
	@GetMapping("/getSubjectWiseRegularExamStudentResultList")
	public String getSubjectWiseRegularExamStudentResultList(RegularExamStudentListRequest request, Model model) {
		String responsePage = resultService.getRegularExamErrorResult(model);

		System.out.println("InstituteName:" + request.getInstituteName());
		System.out.println("ClassName:" + request.getClassName());

		System.out.println("request:" + request.toString());

		int classId = request.getClassId();
		int examinationId = request.getExaminationId();
		
		//ByPASS for PEAK Subject wise Results
		if(examinationId==0) {
			int userId=request.getUserId();
			int organizationId=request.getOrganizationId();
			String organizationName=request.getOrganizationName();
			int instituteId=request.getInstituteId();
			String instituteName=request.getInstituteName();
			//int classId;
			String className=request.getClassName();
			int divisionId=request.getDivisionId();
			String divisionName=request.getDivisionName();
			int subjectId=request.getSubjectId();
			//int examinationId;
			PeakExamStudentListRequest examStudentListRequest=new PeakExamStudentListRequest(userId, organizationId, organizationName, instituteId, instituteName, classId, className, divisionId, divisionName, subjectId, examinationId);
			responsePage = resultService.getSubjectWisePeakExamStudentsResultList(examStudentListRequest, model);
		}else {
			
			// ----- 11th 12th Open
			if (classId == 5 || classId == 6 || classId == 7 || classId == 8 || classId == 9 || classId == 11
					|| classId == 12 || classId == 13 || classId == 19 || classId == 14 || classId == 15 || classId == 16
					|| classId == 18) {

				responsePage = resultService.getSubjectWiseRegularExamStudentsResultList(request, model);

			} else {
				responsePage = resultService.getRegularExamErrorCustom("Not available", "Result will display soon",
						"निकाल लवकरच प्रदर्शित होईल", model);
			}
			
		}
		return responsePage;
	}

	// ------------------------------------------------------------------------------
	// -- PEAK-REGION
	// ------------------------------------------------------------------------------

	//-----Status-----
	@GetMapping("/getPeakExamStudentStatus")
	public String getPeakExamStudentStatus(PeakExamStatusRequest request, Model model) {
		String responsePage = resultService.getRegularExamErrorResult(model);
		responsePage = resultService.getRegularExamErrorCustom("Not available", "Result will display soon",
				"निकाल लवकरच प्रदर्शित होईल", model);
		return responsePage;
	}
	
	@GetMapping("/getPeakExamStudentListStatus")
	public String getPeakExamStudentListStatus(PeakExamStatusRequest request, Model model) {
		String responsePage = resultService.getRegularExamErrorResult(model);
//		responsePage = resultService.getRegularExamErrorCustom("Not available", "Result will display soon",
//				"निकाल लवकरच प्रदर्शित होईल", model);
		//responsePage=resultService.getPeakExamStudentListStatus(request, model);
		responsePage=resultService.getPeakExamStatus(request, model);
		return responsePage;
	}
	
	@GetMapping("/getPeakExamStudentResult")
	public String getPeakExamStudentResult(RegularExamStudentRequest request, Model model) {
		String responsePage = resultService.getRegularExamErrorResult(model);
		responsePage = resultService.getRegularExamErrorCustom("Not available", "Result will display soon",
				"निकाल लवकरच प्रदर्शित होईल", model);
		return responsePage;
	}

	@GetMapping("/getPeakExamStudentResultList")
	public String getPeakExamStudentResultList(PeakExamStudentListRequest request, Model model) {
		String responsePage = resultService.getRegularExamErrorResult(model);
//		responsePage = resultService.getRegularExamErrorCustom("Not available", "Result will display soon",
//				"निकाल लवकरच प्रदर्शित होईल", model);

		responsePage = resultService.getSubjectWisePeakExamStudentsResultList(request, model);
		return responsePage;
	}

	@GetMapping("/getSubjectWisePeakExamStudentResultList")
	public String getSubjectWisePeakExamStudentResultList(PeakExamStudentListRequest request, Model model) {
		String responsePage = resultService.getRegularExamErrorResult(model);
		responsePage = resultService.getRegularExamErrorCustom("Not available", "Result will display soon",
				"निकाल लवकरच प्रदर्शित होईल", model);
		return responsePage;

//		String responsePage = resultService.getRegularExamErrorResult(model);
//
//		int classId = request.getClassId();
//
//		responsePage = resultService.getSubjectWisePeakExamStudentsResultList(request, model);

		// return responsePage;

	}

	
	//
	//-- PEAK - RANK _CALCULATION
	//
	
	@GetMapping("/getPeakToppersList")
	public String getPeakToppersList(int ClassId, Model model) {
		String responsePage = resultService.getRegularExamErrorResult(model);
		responsePage = resultService.getPeakToppersList(1, ClassId, model);
		return responsePage;
	} 
	
	@GetMapping("/getPeakExamStudentFinalResult")
	public String getPeakExamStudentFinalResult(PeakExamFinalResultRequest request, Model model) {
		String responsePage = resultService.getRegularExamErrorResult(model);
		responsePage = resultService.getPeakExamStudentFinalResult(request, model);
		return responsePage;
	} 
	
}
