package in.targetpeak.api.entity.reports.institutestats;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InstituteWithStatsHolder {

	@Id
	Integer InstituteId;
	Integer OrganizationId;
	String InstituteName;
	String InstituteAlias;
	String InstituteCode;
	Integer TotalStudentsCount;
	Integer VerifiedStudentsCount;
	Integer LoggedInStudentsCount;
	Integer RowCount;

	public InstituteWithStatsHolder() {
		super();
	}

	public Integer getInstituteId() {
		return InstituteId;
	}

	public void setInstituteId(Integer instituteId) {
		InstituteId = instituteId;
	}

	public Integer getOrganizationId() {
		return OrganizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		OrganizationId = organizationId;
	}

	public String getInstituteName() {
		return InstituteName;
	}

	public void setInstituteName(String instituteName) {
		InstituteName = instituteName;
	}

	public String getInstituteAlias() {
		return InstituteAlias;
	}

	public void setInstituteAlias(String instituteAlias) {
		InstituteAlias = instituteAlias;
	}

	public String getInstituteCode() {
		return InstituteCode;
	}

	public void setInstituteCode(String instituteCode) {
		InstituteCode = instituteCode;
	}

	public Integer getTotalStudentsCount() {
		return TotalStudentsCount;
	}

	public void setTotalStudentsCount(Integer totalStudentsCount) {
		TotalStudentsCount = totalStudentsCount;
	}

	public Integer getVerifiedStudentsCount() {
		return VerifiedStudentsCount;
	}

	public void setVerifiedStudentsCount(Integer verifiedStudentsCount) {
		VerifiedStudentsCount = verifiedStudentsCount;
	}

	public Integer getLoggedInStudentsCount() {
		return LoggedInStudentsCount;
	}

	public void setLoggedInStudentsCount(Integer loggedInStudentsCount) {
		LoggedInStudentsCount = loggedInStudentsCount;
	}

	public Integer getRowCount() {
		return RowCount;
	}

	public void setRowCount(Integer rowCount) {
		RowCount = rowCount;
	}

	@Override
	public String toString() {
		return "InstituteWithStatsHolder [InstituteId=" + InstituteId + ", OrganizationId=" + OrganizationId
				+ ", InstituteName=" + InstituteName + ", InstituteAlias=" + InstituteAlias + ", InstituteCode="
				+ InstituteCode + ", TotalStudentsCount=" + TotalStudentsCount + ", VerifiedStudentsCount="
				+ VerifiedStudentsCount + ", LoggedInStudentsCount=" + LoggedInStudentsCount + ", RowCount=" + RowCount
				+ "]";
	}

}
