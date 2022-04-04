package in.targetpeak.api.entity.lms.syllabus.chapter;

import java.util.List;

import in.targetpeak.api.entity.master.classs.ClassHolder;

public class ChapterListResponse {

	int Result;
	String Message;
	int HasError;
	List<ChapterHolder> ResponseArray;

	public ChapterListResponse() {
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

	public List<ChapterHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<ChapterHolder> responseArray) {
		ResponseArray = responseArray;
	}

	@Override
	public String toString() {
		return "ChapterListResponse [Result=" + Result + ", Message=" + Message + ", HasError=" + HasError
				+ ", ResponseArray=" + ResponseArray + "]";
	}

}
