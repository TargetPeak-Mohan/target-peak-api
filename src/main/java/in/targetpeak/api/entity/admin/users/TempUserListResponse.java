package in.targetpeak.api.entity.admin.users;

import java.util.List;

public class TempUserListResponse {

	int Result;
	String Message;
	int HasError;
	List<TempUserHolder> ResponseArray;

	public TempUserListResponse() {
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

	public List<TempUserHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<TempUserHolder> responseArray) {
		ResponseArray = responseArray;
	}

	@Override
	public String toString() {
		return "TempUserListResponse [Result=" + Result + ", Message=" + Message + ", HasError=" + HasError
				+ ", ResponseArray=" + ResponseArray + "]";
	}

}
