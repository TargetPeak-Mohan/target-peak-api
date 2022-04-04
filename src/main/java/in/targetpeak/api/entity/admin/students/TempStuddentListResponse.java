package in.targetpeak.api.entity.admin.students;

import java.util.List;

public class TempStuddentListResponse {

	int Result;
	String Message;
	int HasError;
	List<TempStudentHolder> ResponseArray;

	public TempStuddentListResponse() {
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

	public List<TempStudentHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<TempStudentHolder> responseArray) {
		ResponseArray = responseArray;
	}

}
