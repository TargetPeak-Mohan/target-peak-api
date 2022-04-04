package in.targetpeak.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.targetpeak.api.entity.reports.classes.ClassesDashboardListResponse;
import in.targetpeak.api.entity.reports.classes.ClassesDashboardRequest;
import in.targetpeak.api.entity.reports.dashboard.DashboardListRequest;
import in.targetpeak.api.entity.reports.dashboard.DashboardListResponse;
import in.targetpeak.api.entity.reports.division.DivisionDashboardListResponse;
import in.targetpeak.api.entity.reports.division.DivisionDashboardRequest;
import in.targetpeak.api.entity.reports.institute.InstituteDashboardListResponse;
import in.targetpeak.api.entity.reports.institute.InstituteDashboardRequest;
import in.targetpeak.api.entity.reports.institutestats.InstituteWithStatsListRequest;
import in.targetpeak.api.entity.reports.institutestats.InstituteWithStatsListResponse;
import in.targetpeak.api.entity.reports.organization.OrganizationDahboardRequest;
import in.targetpeak.api.entity.reports.organization.OrganizationDashboardListResponse;
import in.targetpeak.api.service.ReportDashboardService;
import io.swagger.annotations.Api;

@RequestMapping(value = "/reports", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Reports", value = "Report Resource REST Endpoint", description = "")
@RestController
public class ReportsController {

	@Autowired
	private ReportDashboardService reportDashboardService;

	@PostMapping("/dashboard")
	public DashboardListResponse getReportDashboard(@RequestBody DashboardListRequest request) {
		return reportDashboardService.fetchDashboardReports(request);
	}

	@GetMapping("/dashboard/organization")
	public OrganizationDashboardListResponse getReportDashboardOrganization(OrganizationDahboardRequest request) {
		return reportDashboardService.fetchOrganizationDashboardReports(request);
	}

	@GetMapping("/dashboard/institute")
	public InstituteDashboardListResponse getReportDashboardInstitute(InstituteDashboardRequest request) {
		return reportDashboardService.fetchInstituteDashboardReports(request);
	}

	@GetMapping("/dashboard/classes")
	public ClassesDashboardListResponse getReportDashboardClasses(ClassesDashboardRequest request) {
		return reportDashboardService.fetchClassesDashboardReports(request);
	}

	@GetMapping("/dashboard/division")
	public DivisionDashboardListResponse getReportDashboardDivision(DivisionDashboardRequest request) {
		return reportDashboardService.fetchDivisionDashboardReports(request);
	}

	@GetMapping("/dashboard/classes/institutelist")
	public InstituteWithStatsListResponse getInstituteWithStatsList(InstituteWithStatsListRequest request) {
		return reportDashboardService.fetchInstituteWithStatsResponse(request);
	}

}
