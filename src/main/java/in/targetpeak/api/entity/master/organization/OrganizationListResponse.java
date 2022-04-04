package in.targetpeak.api.entity.master.organization;

import java.util.List;

public class OrganizationListResponse {

	int Result;
	String Message;
	int HasError;
	List<OrganizationHolder> ResponseArray;

	public OrganizationListResponse() {
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

	public List<OrganizationHolder> getResponseArray() {
		return ResponseArray;
	}

	public void setResponseArray(List<OrganizationHolder> responseArray) {
		ResponseArray = responseArray;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrganizationListResponse [Result=");
		builder.append(Result);
		builder.append(", Message=");
		builder.append(Message);
		builder.append(", HasError=");
		builder.append(HasError);
		builder.append(", ResponseArray=");
		builder.append(ResponseArray);
		builder.append("]");
		return builder.toString();
	}

}
