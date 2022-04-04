package in.targetpeak.api.entity.lms.syllabus.topic;

import java.util.List;

import in.targetpeak.api.entity.lms.syllabus.chapter.ChapterHolder;

public class TopicListResponse {

	int Result;
	String Message;
	int HasError;
	List<TopicHolder> ResponseArray;

	public TopicListResponse() {
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

	public List<TopicHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<TopicHolder> responseArray) {
		ResponseArray = responseArray;
	}

	@Override
	public String toString() {
		return "TopicListResponse [Result=" + Result + ", Message=" + Message + ", HasError=" + HasError
				+ ", ResponseArray=" + ResponseArray + "]";
	}

}
