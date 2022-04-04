package in.targetpeak.api.entity.result.regular;

import java.util.List;

import in.targetpeak.api.entity.result.ExamResultHolder;

public class RegularExamResultStudentListResponse {

	int Result;
	String Message;
	int HasError;
	List<RegularExamResultStudentHolder> ResponseArray;

	public RegularExamResultStudentListResponse() {
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

	public List<RegularExamResultStudentHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<RegularExamResultStudentHolder> responseArray) {
		ResponseArray = responseArray;
	}

	@Override
	public String toString() {
		return "RegularExamResultStudentListResponse [Result=" + Result + ", Message=" + Message + ", HasError="
				+ HasError + ", ResponseArray=" + ResponseArray + "]";
	}

}
