package in.targetpeak.api.entity.master.classs;

import java.util.List;

public class ClassListResponse {

	int Result;
	String Message;
	int HasError;
	List<ClassHolder> ResponseArray;

	public ClassListResponse() {
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

	public List<ClassHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<ClassHolder> responseArray) {
		ResponseArray = responseArray;
	}

	@Override
	public String toString() {
		return "ClassListResponse [Result=" + Result + ", Message=" + Message + ", HasError=" + HasError
				+ ", ResponseArray=" + ResponseArray + "]";
	}
	
	
	
}
