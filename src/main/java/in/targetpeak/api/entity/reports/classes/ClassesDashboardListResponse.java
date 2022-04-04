package in.targetpeak.api.entity.reports.classes;

import java.util.List;

public class ClassesDashboardListResponse {

	List<ClassesDashboardHolder> ResponseArray;
	int Result;
	String Message;
	int HasError;

	public ClassesDashboardListResponse() {
		super();
	}

	public List<ClassesDashboardHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<ClassesDashboardHolder> responseArray) {
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
		return "ClassesDashboardListResponse [ResponseArray=" + ResponseArray + ", Result=" + Result + ", Message="
				+ Message + ", HasError=" + HasError + "]";
	}

}
