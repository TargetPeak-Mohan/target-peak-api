package in.targetpeak.api.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import in.targetpeak.api.dao.MasterDao;
import in.targetpeak.api.entity.ApiResponse;
import in.targetpeak.api.entity.master.classs.ClassHolder;
import in.targetpeak.api.entity.master.classs.ClassListRequest;
import in.targetpeak.api.entity.master.classs.ClassListResponse;
import in.targetpeak.api.entity.master.classs.ClassRequest;
import in.targetpeak.api.entity.master.classs.SelectedClassHolder;
import in.targetpeak.api.entity.master.classs.SelectedClassListRepsonse;
import in.targetpeak.api.entity.master.division.DivisionHolder;
import in.targetpeak.api.entity.master.division.DivisionListRequest;
import in.targetpeak.api.entity.master.division.DivisionListResponse;
import in.targetpeak.api.entity.master.institute.InstituteHolder;
import in.targetpeak.api.entity.master.institute.InstituteListRequest;
import in.targetpeak.api.entity.master.institute.InstituteListResponse;
import in.targetpeak.api.entity.master.institute.InstituteRequest;
import in.targetpeak.api.entity.master.organization.OrganizationHolder;
import in.targetpeak.api.entity.master.organization.OrganizationListRequest;
import in.targetpeak.api.entity.master.organization.OrganizationListResponse;
import in.targetpeak.api.entity.master.organization.OrganizationRequest;
import in.targetpeak.api.entity.master.subject.SubjectHolder;
import in.targetpeak.api.entity.master.subject.SubjectListRequest;
import in.targetpeak.api.entity.master.subject.SubjectListResponse;
import in.targetpeak.api.entity.master.subject.SubjectRequest;
import in.targetpeak.api.util.ResponseMessageUtility;

@Repository
public class IMasterDao implements MasterDao {

	String TAG = "IMasterDao";

	//@PersistenceContext
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	/***
	 * ---------------------------------------------------------------------------
	 * Organization Section Created : Mohan Shivarkar (15-09-2021) Modified :
	 * ---------------------------------------------------------------------------
	 ***/

	@SuppressWarnings("unchecked")
	public OrganizationListResponse fetchOrganizationsList(OrganizationListRequest request) {

		OrganizationListResponse responseOutput = new OrganizationListResponse();
		List<OrganizationHolder> responseArray = null;

		// Request & pAction Parameter Checking
		if (request == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Invalid request ");
			responseOutput.setHasError(1);
		} else if (request.getAction() == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Action parameter missing ");
			responseOutput.setHasError(1);
		} else {

			try {
				StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("Mst_FetchOrganizations",
						OrganizationHolder.class);

				/*
				 * Input Parameters with conditions
				 */

				procedureQuery.registerStoredProcedureParameter("pAttendantId", Integer.class, ParameterMode.IN)
						.setParameter("pAttendantId", request.getAttendantId() == null ? 0 : request.getAttendantId());
				procedureQuery.registerStoredProcedureParameter("pAttendantRoleId", Integer.class, ParameterMode.IN)
						.setParameter("pAttendantRoleId",
								request.getAttendantRoleId() == null ? 0 : request.getAttendantRoleId());
				procedureQuery.registerStoredProcedureParameter("pAction", Integer.class, ParameterMode.IN)
						.setParameter("pAction", request.getAction() == null ? 0 : request.getAction());
				procedureQuery.registerStoredProcedureParameter("pOrganizationId", Integer.class, ParameterMode.IN)
						.setParameter("pOrganizationId",
								request.getOrganizationId() == null ? 0 : request.getOrganizationId());
				procedureQuery.registerStoredProcedureParameter("pRecordStatus", Integer.class, ParameterMode.IN)
						.setParameter("pRecordStatus",
								request.getRecordStatus() == null ? 0 : request.getRecordStatus());
				procedureQuery.registerStoredProcedureParameter("pOffset", Integer.class, ParameterMode.IN)
						.setParameter("pOffset", request.getOffset() == null ? 0 : request.getOffset());
				procedureQuery.registerStoredProcedureParameter("pLimit", Integer.class, ParameterMode.IN)
						.setParameter("pLimit", request.getLimit() == null ? 100 : request.getLimit());

				procedureQuery.registerStoredProcedureParameter("pSearch", String.class, ParameterMode.IN)
						.setParameter("pSearch", request.getSearch() == null ? "" : request.getSearch());

				procedureQuery.registerStoredProcedureParameter("pSyncDate", String.class, ParameterMode.IN)
						.setParameter("pSyncDate", request.getSyncDate() == null ? "" : request.getSyncDate());

				/*
				 * Stored Procedure Execution
				 */

				procedureQuery.execute();
				responseArray = procedureQuery.getResultList();

				// Checking For Empty Response
				if (responseArray.isEmpty() || responseArray == null) {
					responseOutput.setResponseArray(responseArray);
					responseOutput.setResult(0);
					responseOutput.setMessage("No Data Exists");
					responseOutput.setHasError(1);
				} else {
					responseOutput.setResponseArray(responseArray);
					responseOutput.setResult(responseArray.size());
					responseOutput.setMessage("Data Fetch Successfully");
					responseOutput.setHasError(0);
				}

			} catch (Exception e) {
				// Checking For Exception
				responseOutput.setResponseArray(responseArray);
				responseOutput.setResult(0);
				responseOutput.setMessage("Database Error " + e);
				responseOutput.setHasError(1);
			}

		}

		return responseOutput;

	}

	public ApiResponse manageOrganizations(OrganizationRequest request) {

		ApiResponse responseOutput = new ApiResponse();

		// Request & pAction Parameter Checking
		if (request == null) {
			responseOutput.setResult(0);
			responseOutput.setMessage("Invalid request ");
			responseOutput.setHasError(1);
		} else if (request.getAction() == null) {
			responseOutput.setResult(0);
			responseOutput.setMessage("Action parameter missing ");
			responseOutput.setHasError(1);
		} else {

			try {

				/*
				 * Stored Procedure call
				 */
				StoredProcedureQuery procedureQuery = entityManager
						.createStoredProcedureQuery("Mst_ManageOrganizations", ApiResponse.class);

				/*
				 * Input Parameters with conditions
				 */

				procedureQuery.registerStoredProcedureParameter("pAttendantId", Integer.class, ParameterMode.IN)
						.setParameter("pAttendantId", request.getAttendantId() == null ? 0 : request.getAttendantId());
				procedureQuery.registerStoredProcedureParameter("pAttendantRoleId", Integer.class, ParameterMode.IN)
						.setParameter("pAttendantRoleId",
								request.getAttendantRoleId() == null ? 0 : request.getAttendantRoleId());
				procedureQuery.registerStoredProcedureParameter("pAction", Integer.class, ParameterMode.IN)
						.setParameter("pAction", request.getAction() == null ? 0 : request.getAction());

				procedureQuery.registerStoredProcedureParameter("pOrganizationId", Integer.class, ParameterMode.IN)
						.setParameter("pOrganizationId",
								request.getOrganizationId() == null ? 0 : request.getOrganizationId());

				procedureQuery.registerStoredProcedureParameter("pOrganizationName", String.class, ParameterMode.IN)
						.setParameter("pOrganizationName",
								request.getOrganizationName() == null ? "" : request.getOrganizationName());
				procedureQuery.registerStoredProcedureParameter("pOrganizationAlias", String.class, ParameterMode.IN)
						.setParameter("pOrganizationAlias",
								request.getOrganizationAlias() == null ? 100 : request.getOrganizationAlias());
				procedureQuery.registerStoredProcedureParameter("pOrganizationCode", String.class, ParameterMode.IN)
						.setParameter("pOrganizationCode",
								request.getOrganizationCode() == null ? "" : request.getOrganizationCode());
				procedureQuery.registerStoredProcedureParameter("pRecordStatus", Integer.class, ParameterMode.IN)
						.setParameter("pRecordStatus",
								request.getRecordStatus() == null ? 0 : request.getRecordStatus());

				/*
				 * Stored Procedure Execution
				 */

				procedureQuery.execute();
				List<ApiResponse> responseArray = procedureQuery.getResultList();
				ResponseMessageUtility.showMessage(TAG, responseArray.toString());

				// Checking For Empty Response
				if (responseArray.isEmpty() || responseArray == null) {
					responseOutput.setResult(0);
					responseOutput.setMessage("Something went wrong");
					responseOutput.setHasError(1);
				} else {
					ApiResponse apiResponse = responseArray.get(0);
					responseOutput.setResult(apiResponse.getResult());
					responseOutput.setMessage(apiResponse.getMessage());
					responseOutput.setHasError(apiResponse.getHasError());
				}

			} catch (Exception e) {
				// Checking For Exception
				responseOutput.setResult(0);
				responseOutput.setMessage("Database Error " + e);
				responseOutput.setHasError(1);
			}

		}
		return responseOutput;

	}

	public InstituteListResponse fetchInstitutesList(InstituteListRequest request) {

		InstituteListResponse responseOutput = new InstituteListResponse();
		List<InstituteHolder> responseArray = null;

		// Request & pAction Parameter Checking
		if (request == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Invalid request ");
			responseOutput.setHasError(1);
		} else if (request.getAction() == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Action parameter missing ");
			responseOutput.setHasError(1);
		} else {

			try {
				StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("Mst_FetchInstitutes",
						InstituteHolder.class);

				/*
				 * Input Parameters with conditions
				 */

				procedureQuery.registerStoredProcedureParameter("pAttendantId", Integer.class, ParameterMode.IN)
						.setParameter("pAttendantId", request.getAttendantId() == null ? 0 : request.getAttendantId());
				procedureQuery.registerStoredProcedureParameter("pAttendantRoleId", Integer.class, ParameterMode.IN)
						.setParameter("pAttendantRoleId",
								request.getAttendantRoleId() == null ? 0 : request.getAttendantRoleId());
				procedureQuery.registerStoredProcedureParameter("pAction", Integer.class, ParameterMode.IN)
						.setParameter("pAction", request.getAction() == null ? 0 : request.getAction());

				procedureQuery.registerStoredProcedureParameter("pInstituteId", Integer.class, ParameterMode.IN)
						.setParameter("pInstituteId", request.getInstituteId() == null ? 0 : request.getInstituteId());

				procedureQuery.registerStoredProcedureParameter("pOrganizationId", Integer.class, ParameterMode.IN)
						.setParameter("pOrganizationId",
								request.getOrganizationId() == null ? 0 : request.getOrganizationId());
				procedureQuery.registerStoredProcedureParameter("pRecordStatus", Integer.class, ParameterMode.IN)
						.setParameter("pRecordStatus",
								request.getRecordStatus() == null ? 0 : request.getRecordStatus());
				procedureQuery.registerStoredProcedureParameter("pOffset", Integer.class, ParameterMode.IN)
						.setParameter("pOffset", request.getOffset() == null ? 0 : request.getOffset());
				procedureQuery.registerStoredProcedureParameter("pLimit", Integer.class, ParameterMode.IN)
						.setParameter("pLimit", request.getLimit() == null ? 1000 : request.getLimit());

				procedureQuery.registerStoredProcedureParameter("pSearch", String.class, ParameterMode.IN)
						.setParameter("pSearch", request.getSearch() == null ? "" : request.getSearch());

				procedureQuery.registerStoredProcedureParameter("pSyncDate", String.class, ParameterMode.IN)
						.setParameter("pSyncDate", request.getSyncDate() == null ? "" : request.getSyncDate());

				/*
				 * Stored Procedure Execution
				 */

				procedureQuery.execute();
				responseArray = procedureQuery.getResultList();

				// Checking For Empty Response
				if (responseArray.isEmpty() || responseArray == null) {
					responseOutput.setResponseArray(responseArray);
					responseOutput.setResult(0);
					responseOutput.setMessage("No Data Exists");
					responseOutput.setHasError(1);
				} else {
					responseOutput.setResponseArray(responseArray);
					responseOutput.setResult(responseArray.size());
					responseOutput.setMessage("Data Fetch Successfully");
					responseOutput.setHasError(0);
				}

			} catch (Exception e) {
				// Checking For Exception
				responseOutput.setResponseArray(responseArray);
				responseOutput.setResult(0);
				responseOutput.setMessage("Database Error " + e);
				responseOutput.setHasError(1);
			}

		}

		return responseOutput;

	}

	public ApiResponse manageInstitute(InstituteRequest request) {

		ApiResponse responseOutput = new ApiResponse();

		// Request & pAction Parameter Checking
		if (request == null) {
			responseOutput.setResult(0);
			responseOutput.setMessage("Invalid request ");
			responseOutput.setHasError(1);
		} else if (request.getAction() == null) {
			responseOutput.setResult(0);
			responseOutput.setMessage("Action parameter missing ");
			responseOutput.setHasError(1);
		} else {

			try {

				/*
				 * Stored Procedure call
				 */
				StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("Mst_ManageInstitutes",
						ApiResponse.class);

				/*
				 * Input Parameters with conditions
				 */

				procedureQuery.registerStoredProcedureParameter("pAttendantId", Integer.class, ParameterMode.IN)
						.setParameter("pAttendantId", request.getAttendantId() == null ? 0 : request.getAttendantId());
				procedureQuery.registerStoredProcedureParameter("pAttendantRoleId", Integer.class, ParameterMode.IN)
						.setParameter("pAttendantRoleId",
								request.getAttendantRoleId() == null ? 0 : request.getAttendantRoleId());
				procedureQuery.registerStoredProcedureParameter("pAction", Integer.class, ParameterMode.IN)
						.setParameter("pAction", request.getAction() == null ? 0 : request.getAction());

				procedureQuery.registerStoredProcedureParameter("pInstituteId", Integer.class, ParameterMode.IN)
						.setParameter("pInstituteId", request.getInstituteId() == null ? 0 : request.getInstituteId());

				procedureQuery.registerStoredProcedureParameter("pOrganizationId", Integer.class, ParameterMode.IN)
						.setParameter("pOrganizationId",
								request.getOrganizationId() == null ? 0 : request.getOrganizationId());

				procedureQuery.registerStoredProcedureParameter("pInstituteName", String.class, ParameterMode.IN)
						.setParameter("pInstituteName",
								request.getInstituteName() == null ? "" : request.getInstituteName());
				procedureQuery.registerStoredProcedureParameter("pInstituteAlias", String.class, ParameterMode.IN)
						.setParameter("pInstituteAlias",
								request.getInstituteAlias() == null ? 100 : request.getInstituteAlias());
				procedureQuery.registerStoredProcedureParameter("pInstituteCode", String.class, ParameterMode.IN)
						.setParameter("pInstituteCode",
								request.getInstituteCode() == null ? "" : request.getInstituteCode());
				procedureQuery.registerStoredProcedureParameter("pRecordStatus", Integer.class, ParameterMode.IN)
						.setParameter("pRecordStatus",
								request.getRecordStatus() == null ? 0 : request.getRecordStatus());

				/*
				 * Stored Procedure Execution
				 */

				procedureQuery.execute();
				List<ApiResponse> responseArray = procedureQuery.getResultList();
				ResponseMessageUtility.showMessage(TAG, responseArray.toString());

				// Checking For Empty Response
				if (responseArray.isEmpty() || responseArray == null) {
					responseOutput.setResult(0);
					responseOutput.setMessage("Something went wrong");
					responseOutput.setHasError(1);
				} else {
					ApiResponse apiResponse = responseArray.get(0);
					responseOutput.setResult(apiResponse.getResult());
					responseOutput.setMessage(apiResponse.getMessage());
					responseOutput.setHasError(apiResponse.getHasError());
				}

			} catch (Exception e) {
				// Checking For Exception
				responseOutput.setResult(0);
				responseOutput.setMessage("Database Error " + e);
				responseOutput.setHasError(1);
			}

		}
		return responseOutput;

	}

	@SuppressWarnings("unchecked")
	@Override
	public ClassListResponse fetchClassesList(ClassListRequest request) {

		ClassListResponse responseOutput = new ClassListResponse();
		List<ClassHolder> responseArray = null;

		// Request & pAction Parameter Checking
		if (request == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Invalid request ");
			responseOutput.setHasError(1);
		} else if (request.getAction() == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Action parameter missing ");
			responseOutput.setHasError(1);
		} else {

			try {
				StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("Mst_FetchClasses",
						ClassHolder.class);

				/*
				 * Input Parameters with conditions
				 */

				procedureQuery.registerStoredProcedureParameter("pAttendantId", Integer.class, ParameterMode.IN)
						.setParameter("pAttendantId", request.getAttendantId() == null ? 0 : request.getAttendantId());
				procedureQuery.registerStoredProcedureParameter("pAttendantRoleId", Integer.class, ParameterMode.IN)
						.setParameter("pAttendantRoleId",
								request.getAttendantRoleId() == null ? 0 : request.getAttendantRoleId());
				procedureQuery.registerStoredProcedureParameter("pAction", Integer.class, ParameterMode.IN)
						.setParameter("pAction", request.getAction() == null ? 0 : request.getAction());

				procedureQuery.registerStoredProcedureParameter("pClassId", Integer.class, ParameterMode.IN)
						.setParameter("pClassId", request.getClassId() == null ? 0 : request.getClassId());
				procedureQuery.registerStoredProcedureParameter("pEducationBoardId", Integer.class, ParameterMode.IN)
						.setParameter("pEducationBoardId",
								request.getEducationBoardId() == null ? 0 : request.getEducationBoardId());
				procedureQuery.registerStoredProcedureParameter("pInstituteId", Integer.class, ParameterMode.IN)
						.setParameter("pInstituteId", request.getInstituteId() == null ? 0 : request.getInstituteId());

				procedureQuery.registerStoredProcedureParameter("pRecordStatus", Integer.class, ParameterMode.IN)
						.setParameter("pRecordStatus",
								request.getRecordStatus() == null ? 0 : request.getRecordStatus());
				procedureQuery.registerStoredProcedureParameter("pOffset", Integer.class, ParameterMode.IN)
						.setParameter("pOffset", request.getOffset() == null ? 0 : request.getOffset());
				procedureQuery.registerStoredProcedureParameter("pLimit", Integer.class, ParameterMode.IN)
						.setParameter("pLimit", request.getLimit() == null ? 1000 : request.getLimit());

				procedureQuery.registerStoredProcedureParameter("pSearch", String.class, ParameterMode.IN)
						.setParameter("pSearch", request.getSearch() == null ? "" : request.getSearch());

				procedureQuery.registerStoredProcedureParameter("pSyncDate", String.class, ParameterMode.IN)
						.setParameter("pSyncDate", request.getSyncDate() == null ? "" : request.getSyncDate());

				/*
				 * Stored Procedure Execution
				 */

				procedureQuery.execute();
				responseArray = procedureQuery.getResultList();

				// Checking For Empty Response
				if (responseArray.isEmpty() || responseArray == null) {
					responseOutput.setResponseArray(responseArray);
					responseOutput.setResult(0);
					responseOutput.setMessage("No Data Exists");
					responseOutput.setHasError(1);
				} else {
					responseOutput.setResponseArray(responseArray);
					responseOutput.setResult(responseArray.size());
					responseOutput.setMessage("Data Fetch Successfully");
					responseOutput.setHasError(0);
				}

			} catch (Exception e) {
				// Checking For Exception
				responseOutput.setResponseArray(responseArray);
				responseOutput.setResult(0);
				responseOutput.setMessage("Database Error " + e);
				responseOutput.setHasError(1);
			}

		}

		return responseOutput;
	}
	
	@Override
	public SelectedClassListRepsonse fetchSelectedClassesList(ClassListRequest request) {
		SelectedClassListRepsonse responseOutput = new SelectedClassListRepsonse();
		List<SelectedClassHolder> responseArray = null;

		// Request & pAction Parameter Checking
		if (request == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Invalid request ");
			responseOutput.setHasError(1);
		} else if (request.getAction() == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Action parameter missing ");
			responseOutput.setHasError(1);
		} else {

			try {
				StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("Mst_FetchClasses",
						SelectedClassHolder.class);

				/*
				 * Input Parameters with conditions
				 */

				procedureQuery.registerStoredProcedureParameter("pAttendantId", Integer.class, ParameterMode.IN)
						.setParameter("pAttendantId", request.getAttendantId() == null ? 0 : request.getAttendantId());
				procedureQuery.registerStoredProcedureParameter("pAttendantRoleId", Integer.class, ParameterMode.IN)
						.setParameter("pAttendantRoleId",
								request.getAttendantRoleId() == null ? 0 : request.getAttendantRoleId());
				procedureQuery.registerStoredProcedureParameter("pAction", Integer.class, ParameterMode.IN)
						.setParameter("pAction", request.getAction() == null ? 0 : request.getAction());

				procedureQuery.registerStoredProcedureParameter("pClassId", Integer.class, ParameterMode.IN)
						.setParameter("pClassId", request.getClassId() == null ? 0 : request.getClassId());
				procedureQuery.registerStoredProcedureParameter("pEducationBoardId", Integer.class, ParameterMode.IN)
						.setParameter("pEducationBoardId",
								request.getEducationBoardId() == null ? 0 : request.getEducationBoardId());
				procedureQuery.registerStoredProcedureParameter("pInstituteId", Integer.class, ParameterMode.IN)
						.setParameter("pInstituteId", request.getInstituteId() == null ? 0 : request.getInstituteId());

				procedureQuery.registerStoredProcedureParameter("pRecordStatus", Integer.class, ParameterMode.IN)
						.setParameter("pRecordStatus",
								request.getRecordStatus() == null ? 0 : request.getRecordStatus());
				procedureQuery.registerStoredProcedureParameter("pOffset", Integer.class, ParameterMode.IN)
						.setParameter("pOffset", request.getOffset() == null ? 0 : request.getOffset());
				procedureQuery.registerStoredProcedureParameter("pLimit", Integer.class, ParameterMode.IN)
						.setParameter("pLimit", request.getLimit() == null ? 1000 : request.getLimit());

				procedureQuery.registerStoredProcedureParameter("pSearch", String.class, ParameterMode.IN)
						.setParameter("pSearch", request.getSearch() == null ? "" : request.getSearch());

				procedureQuery.registerStoredProcedureParameter("pSyncDate", String.class, ParameterMode.IN)
						.setParameter("pSyncDate", request.getSyncDate() == null ? "" : request.getSyncDate());

				/*
				 * Stored Procedure Execution
				 */

				procedureQuery.execute();
				responseArray = procedureQuery.getResultList();

				// Checking For Empty Response
				if (responseArray.isEmpty() || responseArray == null) {
					responseOutput.setResponseArray(responseArray);
					responseOutput.setResult(0);
					responseOutput.setMessage("No Data Exists");
					responseOutput.setHasError(1);
				} else {
					responseOutput.setResponseArray(responseArray);
					responseOutput.setResult(responseArray.size());
					responseOutput.setMessage("Data Fetch Successfully");
					responseOutput.setHasError(0);
				}

			} catch (Exception e) {
				// Checking For Exception
				responseOutput.setResponseArray(responseArray);
				responseOutput.setResult(0);
				responseOutput.setMessage("Database Error " + e);
				responseOutput.setHasError(1);
			}

		}

		return responseOutput;
	}

	@Override
	public ApiResponse manageClasses(ClassRequest request) {
		ApiResponse responseOutput = new ApiResponse();

		// Request & pAction Parameter Checking
		if (request == null) {
			responseOutput.setResult(0);
			responseOutput.setMessage("Invalid request ");
			responseOutput.setHasError(1);
		} else if (request.getAction() == null) {
			responseOutput.setResult(0);
			responseOutput.setMessage("Action parameter missing ");
			responseOutput.setHasError(1);
		} else {

			try {

				/*
				 * Stored Procedure call
				 */
				StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("Mst_ManageClasses",
						ApiResponse.class);

				/*
				 * Input Parameters with conditions
				 */

				procedureQuery.registerStoredProcedureParameter("pAttendantId", Integer.class, ParameterMode.IN)
						.setParameter("pAttendantId", request.getAttendantId() == null ? 0 : request.getAttendantId());
				procedureQuery.registerStoredProcedureParameter("pAttendantRoleId", Integer.class, ParameterMode.IN)
						.setParameter("pAttendantRoleId",
								request.getAttendantRoleId() == null ? 0 : request.getAttendantRoleId());
				procedureQuery.registerStoredProcedureParameter("pAction", Integer.class, ParameterMode.IN)
						.setParameter("pAction", request.getAction() == null ? 0 : request.getAction());

				procedureQuery.registerStoredProcedureParameter("pClassId", Integer.class, ParameterMode.IN)
						.setParameter("pClassId", request.getClassId() == null ? 0 : request.getClassId());

				procedureQuery.registerStoredProcedureParameter("pEducationBoardId", Integer.class, ParameterMode.IN)
						.setParameter("pEducationBoardId",
								request.getEducationBoardId() == null ? 0 : request.getEducationBoardId());

				procedureQuery.registerStoredProcedureParameter("pClassName", String.class, ParameterMode.IN)
						.setParameter("pClassName", request.getClassName() == null ? "" : request.getClassName());
				procedureQuery.registerStoredProcedureParameter("pSortOrder", String.class, ParameterMode.IN)
						.setParameter("pSortOrder", request.getSortOrder() == null ? 100 : request.getSortOrder());
				procedureQuery.registerStoredProcedureParameter("pRecordStatus", Integer.class, ParameterMode.IN)
						.setParameter("pRecordStatus",
								request.getRecordStatus() == null ? 0 : request.getRecordStatus());

				/*
				 * Stored Procedure Execution
				 */

				procedureQuery.execute();
				List<ApiResponse> responseArray = procedureQuery.getResultList();
				ResponseMessageUtility.showMessage(TAG, responseArray.toString());

				// Checking For Empty Response
				if (responseArray.isEmpty() || responseArray == null) {
					responseOutput.setResult(0);
					responseOutput.setMessage("Something went wrong");
					responseOutput.setHasError(1);
				} else {
					ApiResponse apiResponse = responseArray.get(0);
					responseOutput.setResult(apiResponse.getResult());
					responseOutput.setMessage(apiResponse.getMessage());
					responseOutput.setHasError(apiResponse.getHasError());
				}

			} catch (Exception e) {
				// Checking For Exception
				responseOutput.setResult(0);
				responseOutput.setMessage("Database Error " + e);
				responseOutput.setHasError(1);
			}

		}
		return responseOutput;
	}

	@SuppressWarnings("unchecked")
	public DivisionListResponse fetchDivisionsList(DivisionListRequest request) {

		DivisionListResponse responseOutput = new DivisionListResponse();
		List<DivisionHolder> responseArray = null;

		// Request & pAction Parameter Checking
		if (request == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Invalid request ");
			responseOutput.setHasError(1);
		} else if (request.getAction() == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Action parameter missing ");
			responseOutput.setHasError(1);
		} else {

			try {
				StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("Mst_FetchDivisions",
						DivisionHolder.class);

				/*
				 * Input Parameters with conditions
				 */

				procedureQuery.registerStoredProcedureParameter("pAttendantId", Integer.class, ParameterMode.IN)
						.setParameter("pAttendantId", request.getAttendantId() == null ? 0 : request.getAttendantId());
				procedureQuery.registerStoredProcedureParameter("pAttendantRoleId", Integer.class, ParameterMode.IN)
						.setParameter("pAttendantRoleId",
								request.getAttendantRoleId() == null ? 0 : request.getAttendantRoleId());
				procedureQuery.registerStoredProcedureParameter("pAction", Integer.class, ParameterMode.IN)
						.setParameter("pAction", request.getAction() == null ? 0 : request.getAction());

				procedureQuery.registerStoredProcedureParameter("pInstituteId", Integer.class, ParameterMode.IN)
						.setParameter("pInstituteId", request.getInstituteId() == null ? 0 : request.getInstituteId());

				procedureQuery.registerStoredProcedureParameter("pClassId", Integer.class, ParameterMode.IN)
						.setParameter("pClassId", request.getClassId() == null ? 0 : request.getClassId());

				procedureQuery.registerStoredProcedureParameter("pRecordStatus", Integer.class, ParameterMode.IN)
						.setParameter("pRecordStatus",
								request.getRecordStatus() == null ? 0 : request.getRecordStatus());
				procedureQuery.registerStoredProcedureParameter("pOffset", Integer.class, ParameterMode.IN)
						.setParameter("pOffset", request.getOffset() == null ? 0 : request.getOffset());
				procedureQuery.registerStoredProcedureParameter("pLimit", Integer.class, ParameterMode.IN)
						.setParameter("pLimit", request.getLimit() == null ? 1000 : request.getLimit());

				procedureQuery.registerStoredProcedureParameter("pSearch", String.class, ParameterMode.IN)
						.setParameter("pSearch", request.getSearch() == null ? "" : request.getSearch());

				procedureQuery.registerStoredProcedureParameter("pSyncDate", String.class, ParameterMode.IN)
						.setParameter("pSyncDate", request.getSyncDate() == null ? "" : request.getSyncDate());

				/*
				 * Stored Procedure Execution
				 */

				procedureQuery.execute();
				responseArray = procedureQuery.getResultList();

				// Checking For Empty Response
				if (responseArray.isEmpty() || responseArray == null) {
					responseOutput.setResponseArray(responseArray);
					responseOutput.setResult(0);
					responseOutput.setMessage("No Data Exists");
					responseOutput.setHasError(1);
				} else {
					responseOutput.setResponseArray(responseArray);
					responseOutput.setResult(responseArray.size());
					responseOutput.setMessage("Data Fetch Successfully");
					responseOutput.setHasError(0);
				}

			} catch (Exception e) {
				// Checking For Exception
				responseOutput.setResponseArray(responseArray);
				responseOutput.setResult(0);
				responseOutput.setMessage("Database Error " + e);
				responseOutput.setHasError(1);
			}

		}

		return responseOutput;
	}

	@SuppressWarnings("unchecked")
	@Override
	public SubjectListResponse fetchSubjectList(SubjectListRequest request) {
		SubjectListResponse responseOutput = new SubjectListResponse();
		List<SubjectHolder> responseArray = null;

		// Request & pAction Parameter Checking
		if (request == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Invalid request ");
			responseOutput.setHasError(1);
		} else if (request.getAction() == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Action parameter missing ");
			responseOutput.setHasError(1);
		} else {

			try {
				StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("Mst_FetchSubjects",
						SubjectHolder.class);

				/*
				 * Input Parameters with conditions
				 */

				procedureQuery.registerStoredProcedureParameter("pAttendantId", Integer.class, ParameterMode.IN)
						.setParameter("pAttendantId", request.getAttendantId() == null ? 0 : request.getAttendantId());
				procedureQuery.registerStoredProcedureParameter("pAttendantRoleId", Integer.class, ParameterMode.IN)
						.setParameter("pAttendantRoleId",
								request.getAttendantRoleId() == null ? 0 : request.getAttendantRoleId());
				procedureQuery.registerStoredProcedureParameter("pLanguage", String.class, ParameterMode.IN)
						.setParameter("pLanguage", request.getLanguage() == null ? "" : request.getLanguage());

				procedureQuery.registerStoredProcedureParameter("pAction", Integer.class, ParameterMode.IN)
						.setParameter("pAction", request.getAction() == null ? 0 : request.getAction());

				procedureQuery.registerStoredProcedureParameter("pSubjectId", Integer.class, ParameterMode.IN)
						.setParameter("pSubjectId", request.getSubjectId() == null ? 0 : request.getSubjectId());
				procedureQuery.registerStoredProcedureParameter("pClassId", Integer.class, ParameterMode.IN)
						.setParameter("pClassId", request.getClassId() == null ? 0 : request.getClassId());

				procedureQuery.registerStoredProcedureParameter("pRecordStatus", Integer.class, ParameterMode.IN)
						.setParameter("pRecordStatus",
								request.getRecordStatus() == null ? 0 : request.getRecordStatus());
				procedureQuery.registerStoredProcedureParameter("pOffset", Integer.class, ParameterMode.IN)
						.setParameter("pOffset", request.getOffset() == null ? 0 : request.getOffset());
				procedureQuery.registerStoredProcedureParameter("pLimit", Integer.class, ParameterMode.IN)
						.setParameter("pLimit", request.getLimit() == null ? 1000 : request.getLimit());

				procedureQuery.registerStoredProcedureParameter("pSearch", String.class, ParameterMode.IN)
						.setParameter("pSearch", request.getSearch() == null ? "" : request.getSearch());

				procedureQuery.registerStoredProcedureParameter("pSyncDate", String.class, ParameterMode.IN)
						.setParameter("pSyncDate", request.getSyncDate() == null ? "" : request.getSyncDate());

				/*
				 * Stored Procedure Execution
				 */

				procedureQuery.execute();
				responseArray = procedureQuery.getResultList();

				// Checking For Empty Response
				if (responseArray.isEmpty() || responseArray == null) {
					responseOutput.setResponseArray(responseArray);
					responseOutput.setResult(0);
					responseOutput.setMessage("No Data Exists");
					responseOutput.setHasError(1);
				} else {
					responseOutput.setResponseArray(responseArray);
					responseOutput.setResult(responseArray.size());
					responseOutput.setMessage("Data Fetch Successfully");
					responseOutput.setHasError(0);
				}

			} catch (Exception e) {
				// Checking For Exception
				responseOutput.setResponseArray(responseArray);
				responseOutput.setResult(0);
				responseOutput.setMessage("Database Error " + e);
				responseOutput.setHasError(1);
			}

		}

		return responseOutput;
	}

	@Override
	public ApiResponse manageSubject(SubjectRequest request) {
		ApiResponse responseOutput = new ApiResponse();

		// Request & pAction Parameter Checking
		if (request == null) {
			responseOutput.setResult(0);
			responseOutput.setMessage("Invalid request ");
			responseOutput.setHasError(1);
		} else if (request.getAction() == null) {
			responseOutput.setResult(0);
			responseOutput.setMessage("Action parameter missing ");
			responseOutput.setHasError(1);
		} else {

			try {

				/*
				 * Stored Procedure call
				 */
				StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("Mst_ManageClasses",
						ApiResponse.class);

				/*
				 * Input Parameters with conditions
				 */

				procedureQuery.registerStoredProcedureParameter("pAttendantId", Integer.class, ParameterMode.IN)
						.setParameter("pAttendantId", request.getAttendantId() == null ? 0 : request.getAttendantId());
				procedureQuery.registerStoredProcedureParameter("pAttendantRoleId", Integer.class, ParameterMode.IN)
						.setParameter("pAttendantRoleId",
								request.getAttendantRoleId() == null ? 0 : request.getAttendantRoleId());
				procedureQuery.registerStoredProcedureParameter("pAction", Integer.class, ParameterMode.IN)
						.setParameter("pAction", request.getAction() == null ? 0 : request.getAction());

				procedureQuery.registerStoredProcedureParameter("pLanguage", String.class, ParameterMode.IN)
						.setParameter("pLanguage", request.getLanguage() == null ? "en" : request.getLanguage());

				procedureQuery.registerStoredProcedureParameter("pSubjectId", Integer.class, ParameterMode.IN)
						.setParameter("pSubjectId", request.getSubjectId() == null ? 0 : request.getSubjectId());

				procedureQuery.registerStoredProcedureParameter("pClassId", Integer.class, ParameterMode.IN)
						.setParameter("pClassId", request.getClassId() == null ? 0 : request.getClassId());
				procedureQuery.registerStoredProcedureParameter("pSubjectName", String.class, ParameterMode.IN)
						.setParameter("pSubjectName", request.getSubjectName() == null ? "" : request.getSubjectName());

				procedureQuery.registerStoredProcedureParameter("pRecordStatus", Integer.class, ParameterMode.IN)
						.setParameter("pRecordStatus",
								request.getRecordStatus() == null ? 0 : request.getRecordStatus());

				/*
				 * Stored Procedure Execution
				 */

				procedureQuery.execute();
				List<ApiResponse> responseArray = procedureQuery.getResultList();
				ResponseMessageUtility.showMessage(TAG, responseArray.toString());

				// Checking For Empty Response
				if (responseArray.isEmpty() || responseArray == null) {
					responseOutput.setResult(0);
					responseOutput.setMessage("Something went wrong");
					responseOutput.setHasError(1);
				} else {
					ApiResponse apiResponse = responseArray.get(0);
					responseOutput.setResult(apiResponse.getResult());
					responseOutput.setMessage(apiResponse.getMessage());
					responseOutput.setHasError(apiResponse.getHasError());
				}

			} catch (Exception e) {
				// Checking For Exception
				responseOutput.setResult(0);
				responseOutput.setMessage("Database Error " + e);
				responseOutput.setHasError(1);
			}

		}
		return responseOutput;
	}

	
}
