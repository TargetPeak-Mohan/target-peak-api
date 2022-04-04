package in.targetpeak.api.entity.result;

import java.util.List;


public class ExamResultListResponse {

	int Result;
	String Message;
	int HasError;
	List<ExamResultHolder> ResponseArray;

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

	public List<ExamResultHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<ExamResultHolder> responseArray) {
		ResponseArray = responseArray;
	}

	@Override
	public String toString() {
		return "ExamResultListResponse [Result=" + Result + ", Message=" + Message + ", HasError=" + HasError
				+ ", ResponseArray=" + ResponseArray + "]";
	}

}
