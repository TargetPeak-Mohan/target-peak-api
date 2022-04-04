package in.targetpeak.api.dao;

import in.targetpeak.api.entity.ApiResponse;
import in.targetpeak.api.entity.authentication.LoginApiResponse;
import in.targetpeak.api.entity.authentication.UserValidateRequest;

public interface AuthDao {

	public LoginApiResponse authenticateUser(UserValidateRequest userValidateRequest);
	
}
