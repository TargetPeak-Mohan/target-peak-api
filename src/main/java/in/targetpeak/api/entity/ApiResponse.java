package in.targetpeak.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
public class ApiResponse {

	@Id
	Integer Result;
	String Message;
	Integer HasError;
	
	

	public ApiResponse() {
		super();
	}

	public ApiResponse(Integer result, String message, Integer hasError) {
		super();
		Result = result;
		Message = message;
		HasError = hasError;
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

	public Integer getHasError() {
		return HasError;
	}

	public void setHasError(Integer hasError) {
		HasError = hasError;
	}

	@Override
	public String toString() {
		return "VersionListResponse [Result=" + Result + ", Message=" + Message + ", HasError=" + HasError + "]";
	}
}
