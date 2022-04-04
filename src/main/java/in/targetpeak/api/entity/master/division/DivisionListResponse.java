package in.targetpeak.api.entity.master.division;

import java.util.List;

public class DivisionListResponse {

	int Result;
	String Message;
	int HasError;
	List<DivisionHolder> ResponseArray;

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

	public List<DivisionHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<DivisionHolder> responseArray) {
		ResponseArray = responseArray;
	}

	@Override
	public String toString() {
		return "DivisionListResponse [Result=" + Result + ", Message=" + Message + ", HasError=" + HasError
				+ ", ResponseArray=" + ResponseArray + "]";
	}

}
