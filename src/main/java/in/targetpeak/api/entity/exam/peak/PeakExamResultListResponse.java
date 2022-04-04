package in.targetpeak.api.entity.exam.peak;

import java.util.List;

public class PeakExamResultListResponse {

	int Result;
	String Message;
	int HasError;
	List<PeakExamResultHolder> ResponseArray;

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

	public List<PeakExamResultHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<PeakExamResultHolder> responseArray) {
		ResponseArray = responseArray;
	}

	@Override
	public String toString() {
		return "PeakExamResultListResponse [Result=" + Result + ", Message=" + Message + ", HasError=" + HasError
				+ ", ResponseArray=" + ResponseArray + "]";
	}

}
