package in.targetpeak.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.targetpeak.api.service.DashboardServices;
import io.swagger.annotations.Api;

@RequestMapping(value = "/dashboard")
@Api(tags = "Dashboard Web pages", value = "All the result webpages APIs available here", description = "")
@Controller
public class DashboardController {

	@Autowired
	DashboardServices dashboardServices;

	@GetMapping("")
	public String getDashboardScreen(Model model) {
		return "pages/dashboard/dashboard-home";
	}

	@GetMapping("/getPeakExaminationsList")
	public String getDashboardPeakExaminationsList(Model model) {
		String responsePage = dashboardServices.getDashboardPeakExaminationsList(model);
		return responsePage;
	}
	
	@GetMapping("/getPeakExaminationsPaperList")
	public String getPeakExaminationsPaperList(int examinationId,int organizationId,Model model) {
		String responsePage = dashboardServices.getPeakExaminationsPaperList(model, examinationId,organizationId);
		return responsePage;
	}
	
	
	@GetMapping("/getMvpExaminationsList")
	public String getDashboardMvpExaminationsList(Model model) {
		String responsePage = dashboardServices.getDashboardMvpExaminationsList(model);
		return responsePage;
	}
	
	
	@GetMapping("/getMvpExaminationTimetable")
	public String getMvpExaminationTimetable(int examinationId,int classId,Model model) {
		String responsePage = dashboardServices.getMvpExaminationTimetable(model,examinationId,1,classId);
		return responsePage;
	}
}
