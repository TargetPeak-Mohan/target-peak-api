package in.targetpeak.api.entity.master.institute;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InstituteHolder {

	@Id
	Integer InstituteId;
	Integer OrganizationId;
	String InstituteName;
	String InstituteAlias;
	String InstituteCode;
	Integer RowCount;

	public InstituteHolder() {
		super();
	}

	public Integer getRowCount() {
		return RowCount;
	}

	public void setRowCount(Integer rowCount) {
		RowCount = rowCount;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InstituteHolder [RowCount=");
		builder.append(RowCount);
		builder.append(", InstituteId=");
		builder.append(InstituteId);
		builder.append(", OrganizationId=");
		builder.append(OrganizationId);
		builder.append(", InstituteName=");
		builder.append(InstituteName);
		builder.append(", InstituteAlias=");
		builder.append(InstituteAlias);
		builder.append(", InstituteCode=");
		builder.append(InstituteCode);
		builder.append("]");
		return builder.toString();
	}

}
