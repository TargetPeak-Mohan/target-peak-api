package in.targetpeak.api.entity.reports.organization;

import java.util.List;

public class OrganizationDashboardListResponse {

	List<OrganizationDashboardHolder> ResponseArray;
	int Result;
	String Message;
	int HasError;

	public OrganizationDashboardListResponse() {
		super();
	}

	public List<OrganizationDashboardHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<OrganizationDashboardHolder> responseArray) {
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
		return "OrganizationDashboardListResponse [ResponseArray=" + ResponseArray + ", Result=" + Result + ", Message="
				+ Message + ", HasError=" + HasError + "]";
	}

}
