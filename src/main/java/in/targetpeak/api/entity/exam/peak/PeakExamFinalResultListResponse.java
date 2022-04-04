package in.targetpeak.api.entity.exam.peak;

import java.util.List;

public class PeakExamFinalResultListResponse {

	int Result;
	String Message;
	int HasError;
	List<PeakExamFinalResultHolder> ResponseArray;

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

	public List<PeakExamFinalResultHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<PeakExamFinalResultHolder> responseArray) {
		ResponseArray = responseArray;
	}

	@Override
	public String toString() {
		return "PeakExamFinalResultListResponse [Result=" + Result + ", Message=" + Message + ", HasError=" + HasError
				+ ", ResponseArray=" + ResponseArray + "]";
	}

}
