package in.targetpeak.api.entity.master.organization;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrganizationHolder {

	@Id
	Integer OrganizationId;
	String OrganizationName;
	String OrganizationAlias;
	String OrganizationCode;
	Integer RecordStatus;
	Integer RowCount;

	public OrganizationHolder() {
		super();
	}

	public Integer getRowCount() {
		return RowCount;
	}

	public void setRowCount(Integer rowCount) {
		RowCount = rowCount;
	}

	public Integer getOrganizationId() {
		return OrganizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		OrganizationId = organizationId;
	}

	public String getOrganizationName() {
		return OrganizationName;
	}

	public void setOrganizationName(String organizationName) {
		OrganizationName = organizationName;
	}

	public String getOrganizationAlias() {
		return OrganizationAlias;
	}

	public void setOrganizationAlias(String organizationAlias) {
		OrganizationAlias = organizationAlias;
	}

	public String getOrganizationCode() {
		return OrganizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		OrganizationCode = organizationCode;
	}

	public Integer getRecordStatus() {
		return RecordStatus;
	}

	public void setRecordStatus(Integer recordStatus) {
		RecordStatus = recordStatus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrganizationHolder [RowCount=");
		builder.append(RowCount);
		builder.append(", OrganizationId=");
		builder.append(OrganizationId);
		builder.append(", OrganizationName=");
		builder.append(OrganizationName);
		builder.append(", OrganizationAlias=");
		builder.append(OrganizationAlias);
		builder.append(", OrganizationCode=");
		builder.append(OrganizationCode);
		builder.append(", RecordStatus=");
		builder.append(RecordStatus);
		builder.append("]");
		return builder.toString();
	}

}
