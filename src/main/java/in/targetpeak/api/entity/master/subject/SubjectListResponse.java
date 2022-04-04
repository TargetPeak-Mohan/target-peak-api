package in.targetpeak.api.entity.master.subject;

import java.util.List;

public class SubjectListResponse {

	int Result;
	String Message;
	int HasError;
	List<SubjectHolder> ResponseArray;

	public SubjectListResponse() {
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

	public List<SubjectHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<SubjectHolder> responseArray) {
		ResponseArray = responseArray;
	}

	@Override
	public String toString() {
		return "SubjectListResponse [Result=" + Result + ", Message=" + Message + ", HasError=" + HasError
				+ ", ResponseArray=" + ResponseArray + "]";
	}

}
