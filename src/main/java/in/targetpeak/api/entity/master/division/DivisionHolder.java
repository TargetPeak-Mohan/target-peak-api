package in.targetpeak.api.entity.master.division;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DivisionHolder {

	
	@Id
	Integer DivisionId;
	String DivisionName;
	Integer SortOrder;
	Integer RowCount;

	public DivisionHolder() {
		super();
	}

	public DivisionHolder(Integer rowCount, Integer divisionId, String divisionName, Integer sortOrder) {
		super();
		RowCount = rowCount;
		DivisionId = divisionId;
		DivisionName = divisionName;
		SortOrder = sortOrder;
	}

	public Integer getRowCount() {
		return RowCount;
	}

	public void setRowCount(Integer rowCount) {
		RowCount = rowCount;
	}

	public Integer getDivisionId() {
		return DivisionId;
	}

	public void setDivisionId(Integer divisionId) {
		DivisionId = divisionId;
	}

	public String getDivisionName() {
		return DivisionName;
	}

	public void setDivisionName(String divisionName) {
		DivisionName = divisionName;
	}

	public Integer getSortOrder() {
		return SortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		SortOrder = sortOrder;
	}

	@Override
	public String toString() {
		return "DivisionHolder [DivisionId=" + DivisionId + ", DivisionName=" + DivisionName + ", SortOrder="
				+ SortOrder + ", RowCount=" + RowCount + "]";
	}
	
	

}
