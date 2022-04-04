package in.targetpeak.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import in.targetpeak.api.dao.DashboardDao;
import in.targetpeak.api.dao.MasterDao;
import in.targetpeak.api.entity.dashboard.DashboardExaminationHolder;
import in.targetpeak.api.entity.dashboard.DashboardExaminationList;
import in.targetpeak.api.entity.dashboard.DashboardPaperHolder;
import in.targetpeak.api.entity.dashboard.DashboardPaperList;
import in.targetpeak.api.entity.dashboard.DashboardTimetableHolder;
import in.targetpeak.api.entity.dashboard.DashboardTimetableResponse;
import in.targetpeak.api.entity.master.organization.OrganizationHolder;
import in.targetpeak.api.entity.master.organization.OrganizationListRequest;
import in.targetpeak.api.util.ExamUtils;

@Service
public class DashboardServices {

	@Autowired
	DashboardDao dashboardDao;
	@Autowired
	MasterDao masterDao;

	public String getDashboardPeakExaminationsList(Model model) {
		DashboardExaminationList dashboardExaminationList = dashboardDao.getDashboardExaminationsList(1);
		List<DashboardExaminationHolder> dashboardExaminationHolders = dashboardExaminationList.getResponseArray();
		OrganizationListRequest request = new OrganizationListRequest(1, 4, 1, 0, 1, 0, 100, "", "");
		List<OrganizationHolder> organizationHolders = masterDao.fetchOrganizationsList(request).getResponseArray();
		System.out.println(organizationHolders.toString());
		System.out.println(dashboardExaminationHolders.toString());
		model.addAttribute("dashboardExaminationHolders", dashboardExaminationHolders);
		model.addAttribute("organizationHolders", organizationHolders);

		return "pages/dashboard/dashboard-examination-list";
	}

	public String getPeakExaminationsPaperList(Model model, int examinationId, int organizationId) {
		DashboardPaperList dashboardPaperList = dashboardDao.getPeakExaminationsPaperList(1, examinationId,
				organizationId);
		List<DashboardPaperHolder> dashboardPaperHolders = dashboardPaperList.getResponseArray();

		Integer totalStudentsCount = 0;
		Integer totalSingleAttemptCount = 0;
		Integer totalMultipleAttemptCount = 0;
		for (DashboardPaperHolder dashboardPaperHolder : dashboardPaperHolders) {
			totalStudentsCount += dashboardPaperHolder.getTotalStudents();
			totalSingleAttemptCount += dashboardPaperHolder.getTotalUniqueAttendees();
			totalMultipleAttemptCount += dashboardPaperHolder.getTotalAttendees();
		}
		String examName = dashboardPaperHolders.get(0).getExamName();
		String organizationName = dashboardPaperHolders.get(0).getOrganizationName();
		model.addAttribute("examName", examName);
		model.addAttribute("organizationName", organizationName);
		model.addAttribute("dashboardPaperHolders", dashboardPaperHolders);
		model.addAttribute("totalStudentsCount", totalStudentsCount);
		model.addAttribute("totalSingleAttemptCount", totalSingleAttemptCount);
		model.addAttribute("totalMultipleAttemptCount", totalMultipleAttemptCount);
		model.addAttribute("percentageOfAttendees",
				ExamUtils.getPercentage(totalSingleAttemptCount, totalStudentsCount));
		return "pages/dashboard/dashboard-examination-paper-list";
	}

	// Region MVP
	public String getDashboardMvpExaminationsList(Model model) {
		DashboardExaminationList dashboardExaminationList = dashboardDao.getDashboardExaminationsList(2);
		List<DashboardExaminationHolder> dashboardExaminationHolders = dashboardExaminationList.getResponseArray();
		System.out.println(dashboardExaminationHolders.toString());
		int classId = dashboardExaminationHolders.get(0).getClassId();
		model.addAttribute("dashboardExaminationHolders", dashboardExaminationHolders);
		model.addAttribute("classId", classId);

		return "pages/dashboard/dashboard-mvp-examination-list";
	}

	public String getMvpExaminationTimetable(Model model, int examinationId, int organizationId, int classId) {
		DashboardTimetableResponse dashboardTimetableResponse = dashboardDao.getMvpExaminationTimetable(examinationId,
				organizationId, 0, classId, 0);
		List<DashboardTimetableHolder> dashboardTimetableHolders = dashboardTimetableResponse.getResponseArray();
		System.out.println(dashboardTimetableResponse.toString());
		model.addAttribute("dashboardTimetableHolders", dashboardTimetableHolders);
		DashboardTimetableHolder timetableHolder = dashboardTimetableHolders.get(0);
		String examName = timetableHolder.getExamName();
		String totalStudents = timetableHolder.getTotalStudents();

		model.addAttribute("examName", examName);
		model.addAttribute("totalStudents", totalStudents);
		return "pages/dashboard/dashboard-mvp-examination-timetable";
	}

}
