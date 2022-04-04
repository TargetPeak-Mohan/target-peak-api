package in.targetpeak.api.entity.user;

import java.util.List;

public class UserListResponse {

	int Result;
	String Message;
	int HasError;
	List<UserHolder> ResponseArray;

	public UserListResponse() {
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

	public List<UserHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<UserHolder> responseArray) {
		ResponseArray = responseArray;
	}

	@Override
	public String toString() {
		return "UserListResponse [Result=" + Result + ", Message=" + Message + ", HasError=" + HasError
				+ ", ResponseArray=" + ResponseArray + "]";
	}

}
