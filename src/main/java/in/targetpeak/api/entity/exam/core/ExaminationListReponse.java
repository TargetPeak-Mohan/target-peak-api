package in.targetpeak.api.entity.exam.core;

import java.util.List;

public class ExaminationListReponse {

	int Result;
	String Message;
	int HasError;
	List<ExaminationHolder> ResponseArray;

	public ExaminationListReponse() {
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

	public List<ExaminationHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<ExaminationHolder> responseArray) {
		ResponseArray = responseArray;
	}

	@Override
	public String toString() {
		return "ExaminationListReponse [Result=" + Result + ", Message=" + Message + ", HasError=" + HasError
				+ ", ResponseArray=" + ResponseArray + "]";
	}

}
