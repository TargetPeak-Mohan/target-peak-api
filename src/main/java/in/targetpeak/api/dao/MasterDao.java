package in.targetpeak.api.dao;

import in.targetpeak.api.entity.ApiResponse;
import in.targetpeak.api.entity.master.classs.ClassListRequest;
import in.targetpeak.api.entity.master.classs.ClassListResponse;
import in.targetpeak.api.entity.master.classs.ClassRequest;
import in.targetpeak.api.entity.master.classs.SelectedClassListRepsonse;
import in.targetpeak.api.entity.master.institute.InstituteListRequest;
import in.targetpeak.api.entity.master.institute.InstituteListResponse;
import in.targetpeak.api.entity.master.institute.InstituteRequest;
import in.targetpeak.api.entity.master.organization.OrganizationListRequest;
import in.targetpeak.api.entity.master.organization.OrganizationListResponse;
import in.targetpeak.api.entity.master.organization.OrganizationRequest;
import in.targetpeak.api.entity.master.subject.SubjectListRequest;
import in.targetpeak.api.entity.master.subject.SubjectListResponse;
import in.targetpeak.api.entity.master.subject.SubjectRequest;

public interface MasterDao {

	/***
	 * ----------------------------------------------------------------------------------
	 * 
	 * Organization Section
	 * 
	 * ----------------------------------------------------------------------------------
	 ***/
	public OrganizationListResponse fetchOrganizationsList(OrganizationListRequest request);

	public ApiResponse manageOrganizations(OrganizationRequest request);

	/***
	 * ----------------------------------------------------------------------------------
	 * 
	 * Institute Section
	 * 
	 * ----------------------------------------------------------------------------------
	 ***/
	public InstituteListResponse fetchInstitutesList(InstituteListRequest request);

	public ApiResponse manageInstitute(InstituteRequest request);

	/***
	 * ----------------------------------------------------------------------------------
	 * 
	 * Class Section
	 * 
	 * ----------------------------------------------------------------------------------
	 ***/
	public ClassListResponse fetchClassesList(ClassListRequest request);
	
	public SelectedClassListRepsonse fetchSelectedClassesList(ClassListRequest request);

	public ApiResponse manageClasses(ClassRequest request);

	/***
	 * ----------------------------------------------------------------------------------
	 * 
	 * Subject Section
	 * 
	 * ----------------------------------------------------------------------------------
	 ***/
	public SubjectListResponse fetchSubjectList(SubjectListRequest request);

	public ApiResponse manageSubject(SubjectRequest request);
}
