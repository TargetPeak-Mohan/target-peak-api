package in.targetpeak.api.entity.result.peak;

import java.util.List;

public class PeakExamStatusListResponse {

	int Result;
	String Message;
	int HasError;
	List<PeakExamStatusHolder> ResponseArray;

	public PeakExamStatusListResponse() {
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

	public List<PeakExamStatusHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<PeakExamStatusHolder> responseArray) {
		ResponseArray = responseArray;
	}

	@Override
	public String toString() {
		return "PeakExamStatusListResponse [Result=" + Result + ", Message=" + Message + ", HasError=" + HasError
				+ ", ResponseArray=" + ResponseArray + "]";
	}

}
