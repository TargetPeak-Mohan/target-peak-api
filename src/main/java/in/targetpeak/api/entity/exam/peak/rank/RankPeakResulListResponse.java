package in.targetpeak.api.entity.exam.peak.rank;

import java.util.List;

public class RankPeakResulListResponse {

	int Result;
	String Message;
	int HasError;
	List<RankPeakResultHolder> ResponseArray;

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

	public List<RankPeakResultHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<RankPeakResultHolder> responseArray) {
		ResponseArray = responseArray;
	}

	@Override
	public String toString() {
		return "RankPeakResulListResponse [Result=" + Result + ", Message=" + Message + ", HasError=" + HasError
				+ ", ResponseArray=" + ResponseArray + "]";
	}

}
