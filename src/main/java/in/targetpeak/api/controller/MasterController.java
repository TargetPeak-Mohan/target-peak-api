package in.targetpeak.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.targetpeak.api.entity.ApiResponse;
import in.targetpeak.api.entity.master.classs.ClassListRequest;
import in.targetpeak.api.entity.master.classs.ClassListResponse;
import in.targetpeak.api.entity.master.classs.ClassRequest;
import in.targetpeak.api.entity.master.institute.InstituteListRequest;
import in.targetpeak.api.entity.master.institute.InstituteListResponse;
import in.targetpeak.api.entity.master.institute.InstituteRequest;
import in.targetpeak.api.entity.master.organization.OrganizationListRequest;
import in.targetpeak.api.entity.master.organization.OrganizationListResponse;
import in.targetpeak.api.entity.master.organization.OrganizationRequest;
import in.targetpeak.api.service.MasterService;
import io.swagger.annotations.Api;

@RequestMapping(value = "/master", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Master", value = "Master(Organization,Institute,Class,Division) Resource REST Endpoint", description = "")
@RestController
public class MasterController {

	@Autowired
	private MasterService masterService;

	@GetMapping("/organization")
	public OrganizationListResponse getOrganizationList(OrganizationListRequest request) {
		return masterService.getOrganizationList(request);
	}

	@PostMapping("/organization")
	public ApiResponse manageOrganization(@RequestBody OrganizationRequest request) {
		return masterService.manageOrganization(request);
	}

	@GetMapping("/institute")
	public InstituteListResponse getInstituteList(InstituteListRequest request) {
		return masterService.getInstituteList(request);
	}

	@PostMapping("/institute")
	public ApiResponse manageInstitute(@RequestBody InstituteRequest request) {
		return masterService.manageInstitute(request);
	}

	@GetMapping("/class")
	public ClassListResponse getClassesList(ClassListRequest request) {
		return masterService.getClassLIst(request);
	}

	@PostMapping("/class")
	public ApiResponse manageClasses(@RequestBody ClassRequest request) {
		return masterService.manageClasses(request);
	}

}
