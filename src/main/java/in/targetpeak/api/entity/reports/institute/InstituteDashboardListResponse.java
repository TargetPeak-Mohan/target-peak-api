package in.targetpeak.api.entity.reports.institute;

import java.util.List;

import in.targetpeak.api.entity.reports.organization.OrganizationDashboardHolder;

public class InstituteDashboardListResponse {

	List<InstituteDashboardHolder> ResponseArray;
	int Result;
	String Message;
	int HasError;

	public InstituteDashboardListResponse() {
		super();
	}

	public List<InstituteDashboardHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<InstituteDashboardHolder> responseArray) {
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
		return "InstituteDashboardListResponse [ResponseArray=" + ResponseArray + ", Result=" + Result + ", Message="
				+ Message + ", HasError=" + HasError + "]";
	}

}
