package in.targetpeak.api.entity.util.version;

import java.util.List;

public class VersionListResponse {

	int Result;
	String Message;
	int HasError;
	List<VersionHolder> ResponseArray;

	public VersionListResponse() {
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

	public List<VersionHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<VersionHolder> responseArray) {
		ResponseArray = responseArray;
	}

	@Override
	public String toString() {
		return "VersionListResponse [Result=" + Result + ", Message=" + Message + ", HasError=" + HasError
				+ ", ResponseArray=" + ResponseArray + "]";
	}

}
