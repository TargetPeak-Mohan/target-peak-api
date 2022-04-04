package in.targetpeak.api.entity.result.regular;

import java.util.List;

public class RegularExamResultSingleStudentResponse {

	int Result;
	String Message;
	int HasError;
	List<RegularExamSingleStudentHolder> ResponseArray;

	public RegularExamResultSingleStudentResponse() {
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

	public List<RegularExamSingleStudentHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<RegularExamSingleStudentHolder> responseArray) {
		ResponseArray = responseArray;
	}

}
