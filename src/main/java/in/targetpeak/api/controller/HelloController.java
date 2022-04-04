package in.targetpeak.api.controller;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.targetpeak.api.callbacks.HelloCallBack;
import in.targetpeak.api.callbacks.HelloCallBackService;
import in.targetpeak.api.entity.ApiResponse;

@RestController
public class HelloController {
	String returnMessage="No message";

	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	public String sayHello() {
		return "Hello World";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/hello1")
	public String checkHeaders(@RequestHeader Map<String, String> headers) {
//		if(Authorization.isEmpty()) {
//			return "Invalid Authorization";
//		}
//		//return "Hello World";
//		return Authorization;

		System.out.println(headers.get("user"));

		return "Working....";

	}

	@GetMapping("/allheaders")
	public ResponseEntity<String> getAllHeadersAsMap(@RequestHeader Map<String, String> allHeaders) {

		// logger.info("All headers are");
		Set<Entry<String, String>> entrySet = allHeaders.entrySet();

		StringBuffer buffer = new StringBuffer();
		buffer.append("header count " + allHeaders.size() + " \n");
		for (Entry<String, String> e : entrySet) {
			// logger.info("Header " + e.getKey() + "= " + e.getValue());
			buffer.append("Header " + e.getKey() + "= " + e.getValue() + " \n");
		}

		return new ResponseEntity<String>(buffer.toString(), HttpStatus.OK);
	}

	@GetMapping(value = "/map")
	public ApiResponse getData(@RequestHeader Map<String, String> allHeaders,
			@RequestParam Map<String, String> allParams) {
		ApiResponse apiResponse = new ApiResponse();

		System.out.println(allHeaders.toString());
		String AuthorizationToken = Optional.ofNullable(allHeaders.get("authorization")).orElse("");
		if (AuthorizationToken.isEmpty()) {
			apiResponse.setMessage("Invalid token provided");
			apiResponse.setHasError(1);
			apiResponse.setResult(0);
		}

		String str = Optional.ofNullable(allParams.get("first")).orElse("");
		System.out.println(str);
		if (str.isEmpty()) {
			apiResponse.setMessage("Please provide first parameter");
			apiResponse.setHasError(1);
			apiResponse.setResult(0);
		}
		return apiResponse;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/hello/callback")
	public String testingCallbacks(int action) {
		
		HelloCallBackService.getInstance().FetchCallaback(action, new HelloCallBack() {
			
			@Override
			public void onUnknownError() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onSuccess(String successMessage) {
				returnMessage=successMessage;
			}
			
			@Override
			public void onError(String errorMessage) {
				returnMessage=errorMessage;
			}
		});
		
		return returnMessage;
	}

}
