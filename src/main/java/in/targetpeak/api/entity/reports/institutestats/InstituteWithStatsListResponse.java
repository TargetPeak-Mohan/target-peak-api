package in.targetpeak.api.entity.reports.institutestats;

import java.util.List;

public class InstituteWithStatsListResponse {

	List<InstituteWithStatsHolder> ResponseArray;
	int Result;
	String Message;
	int HasError;

	public InstituteWithStatsListResponse() {
		super();
	}

	public List<InstituteWithStatsHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<InstituteWithStatsHolder> responseArray) {
		ResponseArray = responseArray;
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

	@Override
	public String toString() {
		return "InstituteWithStatsListResponse [ResponseArray=" + ResponseArray + ", Result=" + Result + ", Message="
				+ Message + ", HasError=" + HasError + "]";
	}

}
