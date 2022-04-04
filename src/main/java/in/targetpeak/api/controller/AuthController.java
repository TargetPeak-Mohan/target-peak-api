package in.targetpeak.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.targetpeak.api.entity.ApiResponse;
import in.targetpeak.api.entity.authentication.LoginApiResponse;
import in.targetpeak.api.entity.authentication.UserValidateRequest;
import in.targetpeak.api.service.AuthenticationService;
import io.swagger.annotations.Api;

@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Authentication", value = "Authentication(Organization,Institute,Class,Division) Resource REST Endpoint", description = "")
@RestController
public class AuthController {

	@Autowired
	AuthenticationService authServices;

	@PostMapping("/validate")
	public LoginApiResponse validateUsers(@RequestBody UserValidateRequest request) {
		return authServices.authenticateUser(request);
	}
}
