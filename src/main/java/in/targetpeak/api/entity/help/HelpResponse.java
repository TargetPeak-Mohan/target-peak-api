package in.targetpeak.api.entity.help;

import java.util.List;

public class HelpResponse {

	int Result;
	String Message;
	int HasError;
	List<HelpHolder> ResponseArray;

	public HelpResponse() {
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

	public List<HelpHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<HelpHolder> responseArray) {
		ResponseArray = responseArray;
	}

	@Override
	public String toString() {
		return "HelpResponse [Result=" + Result + ", Message=" + Message + ", HasError=" + HasError + ", ResponseArray="
				+ ResponseArray + "]";
	}

}
