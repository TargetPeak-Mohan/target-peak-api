package in.targetpeak.api.entity.dashboard;

import java.util.List;

public class DashboardExaminationList {

	int Result;
	String Message;
	int HasError;
	List<DashboardExaminationHolder> ResponseArray;

	public DashboardExaminationList() {
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

	public List<DashboardExaminationHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<DashboardExaminationHolder> responseArray) {
		ResponseArray = responseArray;
	}

}
