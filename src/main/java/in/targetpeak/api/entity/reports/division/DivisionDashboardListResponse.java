package in.targetpeak.api.entity.reports.division;

import java.util.List;

import in.targetpeak.api.entity.reports.organization.OrganizationDashboardHolder;

public class DivisionDashboardListResponse {

	List<DivisionDashboardHolder> ResponseArray;
	int Result;
	String Message;
	int HasError;

	public DivisionDashboardListResponse() {
		super();
	}

	public List<DivisionDashboardHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<DivisionDashboardHolder> responseArray) {
		ResponseArray = responseArray;
	}

	public int getResult() {
		return Result;
	}

	public void setResult(int result) {
		Result = result;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public int getHasError() {
		return HasError;
	}

	public void setHasError(int hasError) {
		HasError = hasError;
	}

	@Override
	public String toString() {
		return "DivisionDashboardListResponse [ResponseArray=" + ResponseArray + ", Result=" + Result + ", Message="
				+ Message + ", HasError=" + HasError + "]";
	}

}
