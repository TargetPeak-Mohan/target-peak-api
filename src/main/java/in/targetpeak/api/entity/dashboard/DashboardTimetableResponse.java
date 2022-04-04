package in.targetpeak.api.entity.dashboard;

import java.util.List;

public class DashboardTimetableResponse {

	int Result;
	String Message;
	int HasError;
	List<DashboardTimetableHolder> ResponseArray;

	public DashboardTimetableResponse() {
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

	public List<DashboardTimetableHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<DashboardTimetableHolder> responseArray) {
		ResponseArray = responseArray;
	}

	@Override
	public String toString() {
		return "DashboardTimetableResponse [Result=" + Result + ", Message=" + Message + ", HasError=" + HasError
				+ ", ResponseArray=" + ResponseArray + "]";
	}

}
