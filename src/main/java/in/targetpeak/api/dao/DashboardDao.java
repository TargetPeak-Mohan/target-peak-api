package in.targetpeak.api.dao;

import in.targetpeak.api.entity.dashboard.DashboardExaminationList;
import in.targetpeak.api.entity.dashboard.DashboardPaperList;
import in.targetpeak.api.entity.dashboard.DashboardTimetableResponse;

public interface DashboardDao {

	public DashboardExaminationList getDashboardExaminationsList(int action);
	
	public DashboardPaperList getPeakExaminationsPaperList(int action,int examinationId,int organizationId);
	
	public DashboardTimetableResponse getMvpExaminationTimetable(int examinationId, int organizationId,int instituteId,int classId,int divisionId);

}
