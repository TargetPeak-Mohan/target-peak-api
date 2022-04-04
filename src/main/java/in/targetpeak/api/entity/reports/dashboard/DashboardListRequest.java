package in.targetpeak.api.entity.reports.dashboard;

public class DashboardListRequest {

	Integer pAttendantId;
	Integer pAttendantRoleId;
	Integer pAction;

	Integer pOrganizationId;
	Integer pInstituteId;
	Integer pClassId;
	Integer pDivisionId;
	Integer pStudentId;

	String pStartDate;
	String pEndDate;

	Integer pRecordStatus;
	Integer pOffset;
	Integer pLimit;
	String pSearch;
	String pSyncDate;

	public DashboardListRequest() {
		super();
	}

	public DashboardListRequest(Integer pAttendantId, Integer pAttendantRoleId, Integer pAction,
			Integer pOrganizationId, Integer pInstituteId, Integer pClassId, Integer pDivisionId, Integer pStudentId,
			String pStartDate, String pEndDate, Integer pRecordStatus, Integer pOffset, Integer pLimit, String pSearch,
			String pSyncDate) {
		super();
		this.pAttendantId = pAttendantId;
		this.pAttendantRoleId = pAttendantRoleId;
		this.pAction = pAction;
		this.pOrganizationId = pOrganizationId;
		this.pInstituteId = pInstituteId;
		this.pClassId = pClassId;
		this.pDivisionId = pDivisionId;
		this.pStudentId = pStudentId;
		this.pStartDate = pStartDate;
		this.pEndDate = pEndDate;
		this.pRecordStatus = pRecordStatus;
		this.pOffset = pOffset;
		this.pLimit = pLimit;
		this.pSearch = pSearch;
		this.pSyncDate = pSyncDate;
	}

	public Integer getpAttendantId() {
		return pAttendantId;
	}

	public void setpAttendantId(Integer pAttendantId) {
		this.pAttendantId = pAttendantId;
	}

	public Integer getpAttendantRoleId() {
		return pAttendantRoleId;
	}

	public void setpAttendantRoleId(Integer pAttendantRoleId) {
		this.pAttendantRoleId = pAttendantRoleId;
	}

	public Integer getpAction() {
		return pAction;
	}

	public void setpAction(Integer pAction) {
		this.pAction = pAction;
	}

	public Integer getpOrganizationId() {
		return pOrganizationId;
	}

	public void setpOrganizationId(Integer pOrganizationId) {
		this.pOrganizationId = pOrganizationId;
	}

	public Integer getpInstituteId() {
		return pInstituteId;
	}

	public void setpInstituteId(Integer pInstituteId) {
		this.pInstituteId = pInstituteId;
	}

	public Integer getpClassId() {
		return pClassId;
	}

	public void setpClassId(Integer pClassId) {
		this.pClassId = pClassId;
	}

	public Integer getpDivisionId() {
		return pDivisionId;
	}

	public void setpDivisionId(Integer pDivisionId) {
		this.pDivisionId = pDivisionId;
	}

	public Integer getpStudentId() {
		return pStudentId;
	}

	public void setpStudentId(Integer pStudentId) {
		this.pStudentId = pStudentId;
	}

	public String getpStartDate() {
		return pStartDate;
	}

	public void setpStartDate(String pStartDate) {
		this.pStartDate = pStartDate;
	}

	public String getpEndDate() {
		return pEndDate;
	}

	public void setpEndDate(String pEndDate) {
		this.pEndDate = pEndDate;
	}

	public Integer getpRecordStatus() {
		return pRecordStatus;
	}

	public void setpRecordStatus(Integer pRecordStatus) {
		this.pRecordStatus = pRecordStatus;
	}

	public Integer getpOffset() {
		return pOffset;
	}

	public void setpOffset(Integer pOffset) {
		this.pOffset = pOffset;
	}

	public Integer getpLimit() {
		return pLimit;
	}

	public void setpLimit(Integer pLimit) {
		this.pLimit = pLimit;
	}

	public String getpSearch() {
		return pSearch;
	}

	public void setpSearch(String pSearch) {
		this.pSearch = pSearch;
	}

	public String getpSyncDate() {
		return pSyncDate;
	}

	public void setpSyncDate(String pSyncDate) {
		this.pSyncDate = pSyncDate;
	}

}
