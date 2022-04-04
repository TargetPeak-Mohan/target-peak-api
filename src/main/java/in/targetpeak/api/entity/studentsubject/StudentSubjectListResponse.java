package in.targetpeak.api.entity.studentsubject;

import java.util.List;

import in.targetpeak.api.entity.util.version.VersionHolder;

public class StudentSubjectListResponse {

	int Result;
	String Message;
	int HasError;
	List<StudentSubjectHolder> ResponseArray;

	public StudentSubjectListResponse() {
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

	public List<StudentSubjectHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<StudentSubjectHolder> responseArray) {
		ResponseArray = responseArray;
	}

	@Override
	public String toString() {
		return "StudentSubjectListResponse [Result=" + Result + ", Message=" + Message + ", HasError=" + HasError
				+ ", ResponseArray=" + ResponseArray + "]";
	}

}
