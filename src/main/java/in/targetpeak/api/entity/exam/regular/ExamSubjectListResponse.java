package in.targetpeak.api.entity.exam.regular;

import java.util.List;

import in.targetpeak.api.entity.help.HelpHolder;

public class ExamSubjectListResponse {

	int Result;
	String Message;
	int HasError;
	List<ExamSubjectHolder> ResponseArray;

	public ExamSubjectListResponse() {
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

	public List<ExamSubjectHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<ExamSubjectHolder> responseArray) {
		ResponseArray = responseArray;
	}

	@Override
	public String toString() {
		return "RegularExamSubjectListResponse [Result=" + Result + ", Message=" + Message + ", HasError=" + HasError
				+ ", ResponseArray=" + ResponseArray + "]";
	}

}
