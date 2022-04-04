package in.targetpeak.api.entity.result.peak;

import java.util.List;


public class PeakExamResultStudentListResponse {

	int Result;
	String Message;
	int HasError;
	List<PeakExamResultStudentHolder> ResponseArray;

	public PeakExamResultStudentListResponse() {
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

	public List<PeakExamResultStudentHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<PeakExamResultStudentHolder> responseArray) {
		ResponseArray = responseArray;
	}

	@Override
	public String toString() {
		return "PeakExamResultStudentListResponse [Result=" + Result + ", Message=" + Message + ", HasError=" + HasError
				+ ", ResponseArray=" + ResponseArray + "]";
	}

}
