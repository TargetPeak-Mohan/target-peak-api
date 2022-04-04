package in.targetpeak.api.entity.reports.dashboard;

import java.util.ArrayList;
import java.util.List;

public class DashboardListResponse {

	List<DashboardHolder> ResponseArray;
	int Result;
	String Message;
	int HasError;

	public DashboardListResponse() {
		super();
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

	public List<DashboardHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<DashboardHolder> responseArray) {
		ResponseArray = responseArray;
	}

	@Override
	public String toString() {
		return "DashboardListResponse [Result=" + Result + ", Message=" + Message + ", HasError=" + HasError
				+ ", ResponseArray=" + ResponseArray + "]";
	}

}
