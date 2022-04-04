package in.targetpeak.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

@RequestMapping(value = "/certificate")
@Api(tags = "Dashboard Web pages", value = "All the result webpages APIs available here", description = "")
@Controller
public class CertificateController {

	
	//-- Remove EVS & Physical Education from result list
	//and add Annual exam question paper oinly in annual examList
	
	
	
}
