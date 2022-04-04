package in.targetpeak.api.entity.master.classs;

import java.util.List;

public class SelectedClassListRepsonse {

	int Result;
	String Message;
	int HasError;
	List<SelectedClassHolder> ResponseArray;

	public SelectedClassListRepsonse() {
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

	public List<SelectedClassHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<SelectedClassHolder> responseArray) {
		ResponseArray = responseArray;
	}

	@Override
	public String toString() {
		return "SelectedClassListRepsonse [Result=" + Result + ", Message=" + Message + ", HasError=" + HasError
				+ ", ResponseArray=" + ResponseArray + "]";
	}

	
	
}
