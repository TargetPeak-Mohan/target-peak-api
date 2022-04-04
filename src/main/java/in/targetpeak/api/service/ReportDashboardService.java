package in.targetpeak.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.targetpeak.api.dao.ReportDashboardDao;
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

@Service
public class ReportDashboardService {

	@Autowired
	private ReportDashboardDao reportDashboardDao;

	public DashboardListResponse fetchDashboardReports(DashboardListRequest request) {
		return reportDashboardDao.fetchReportDashboard(request);
	}

	public OrganizationDashboardListResponse fetchOrganizationDashboardReports(OrganizationDahboardRequest request) {
		return reportDashboardDao.fetchOrganizationReportDashboard(request);
	}

	public InstituteDashboardListResponse fetchInstituteDashboardReports(InstituteDashboardRequest request) {
		return reportDashboardDao.fetchInstituteReportDashboard(request);
	}

	public ClassesDashboardListResponse fetchClassesDashboardReports(ClassesDashboardRequest request) {
		return reportDashboardDao.fetchClassesReportDashboard(request);
	}

	public DivisionDashboardListResponse fetchDivisionDashboardReports(DivisionDashboardRequest request) {
		return reportDashboardDao.fetchDivisionReportDashboard(request);
	}

	public InstituteWithStatsListResponse fetchInstituteWithStatsResponse(InstituteWithStatsListRequest request) {
		return reportDashboardDao.fetchInstituteWithStatsDashboard(request);
	}

}
