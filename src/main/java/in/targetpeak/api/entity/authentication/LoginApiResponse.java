package in.targetpeak.api.entity.authentication;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoginApiResponse {

	@Id
	Integer Result;
	String Message;
	String MessageInMarathi;
	Integer HasError;

	public LoginApiResponse() {
		super();
	}

	public Integer getResult() {
		return Result;
	}

	public void setResult(Integer result) {
		Result = result;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public String getMessageInMarathi() {
		return MessageInMarathi;
	}

	public void setMessageInMarathi(String messageInMarathi) {
		MessageInMarathi = messageInMarathi;
	}

	public Integer getHasError() {
		return HasError;
	}

	public void setHasError(Integer hasError) {
		HasError = hasError;
	}

	@Override
	public String toString() {
		return "LoginApiResponse [Result=" + Result + ", Message=" + Message + ", MessageInMarathi=" + MessageInMarathi
				+ ", HasError=" + HasError + "]";
	}

}
