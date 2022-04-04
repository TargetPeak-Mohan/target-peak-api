package in.targetpeak.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.targetpeak.api.dao.AuthDao;
import in.targetpeak.api.entity.ApiResponse;
import in.targetpeak.api.entity.authentication.LoginApiResponse;
import in.targetpeak.api.entity.authentication.UserValidateRequest;

@Service
public class AuthenticationService {

	@Autowired
	private AuthDao authDao;

	public LoginApiResponse authenticateUser(UserValidateRequest request) {
		return authDao.authenticateUser(request);
	}

}
