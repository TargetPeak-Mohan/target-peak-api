package in.targetpeak.api.dao;

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

public interface ReportDashboardDao {

	public DashboardListResponse fetchReportDashboard(DashboardListRequest request);
	
	public OrganizationDashboardListResponse fetchOrganizationReportDashboard(OrganizationDahboardRequest request);
	
	public InstituteDashboardListResponse fetchInstituteReportDashboard(InstituteDashboardRequest request);
	
	public ClassesDashboardListResponse fetchClassesReportDashboard(ClassesDashboardRequest request);
	
	public DivisionDashboardListResponse fetchDivisionReportDashboard(DivisionDashboardRequest request);
	
	public InstituteWithStatsListResponse fetchInstituteWithStatsDashboard(InstituteWithStatsListRequest request);

}
