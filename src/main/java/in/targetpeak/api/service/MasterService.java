package in.targetpeak.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.targetpeak.api.dao.MasterDao;
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

@Service
public class MasterService {

	@Autowired
	private MasterDao masterDao;

	public OrganizationListResponse getOrganizationList(OrganizationListRequest request) {
		return masterDao.fetchOrganizationsList(request);
	}

	public ApiResponse manageOrganization(OrganizationRequest request) {
		return masterDao.manageOrganizations(request);
	}

	public InstituteListResponse getInstituteList(InstituteListRequest request) {
		return masterDao.fetchInstitutesList(request);
	}

	public ApiResponse manageInstitute(InstituteRequest request) {
		return masterDao.manageInstitute(request);
	}

	public ClassListResponse getClassLIst(ClassListRequest request) {
		return masterDao.fetchClassesList(request);
	}

	public ApiResponse manageClasses(ClassRequest request) {
		return masterDao.manageClasses(request);
	}

}
