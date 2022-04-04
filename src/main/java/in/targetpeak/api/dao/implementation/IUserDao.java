package in.targetpeak.api.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import in.targetpeak.api.dao.UserDao;
import in.targetpeak.api.entity.ApiResponse;
import in.targetpeak.api.entity.admin.students.TempStuddentListResponse;
import in.targetpeak.api.entity.admin.students.TempStudentHolder;
import in.targetpeak.api.entity.admin.students.TempStudentRequest;
import in.targetpeak.api.entity.admin.users.TempUserHolder;
import in.targetpeak.api.entity.admin.users.TempUserListResponse;
import in.targetpeak.api.entity.admin.users.TempUserRequest;
import in.targetpeak.api.entity.help.HelpHolder;
import in.targetpeak.api.entity.help.HelpRequest;
import in.targetpeak.api.entity.help.HelpResponse;
import in.targetpeak.api.entity.master.organization.OrganizationHolder;
import in.targetpeak.api.entity.master.organization.OrganizationListRequest;
import in.targetpeak.api.entity.master.organization.OrganizationListResponse;
import in.targetpeak.api.entity.master.organization.OrganizationRequest;
import in.targetpeak.api.entity.student.StudentWithStatusHolder;
import in.targetpeak.api.entity.student.StudentWithStatusListRequest;
import in.targetpeak.api.entity.student.StudentWithStatusListResponse;
import in.targetpeak.api.entity.studentsubject.StudentSubjectHolder;
import in.targetpeak.api.entity.studentsubject.StudentSubjectListRequest;
import in.targetpeak.api.entity.studentsubject.StudentSubjectListResponse;
import in.targetpeak.api.entity.studentsubject.StudentSubjectRequest;
import in.targetpeak.api.entity.user.UserHolder;
import in.targetpeak.api.entity.user.UserListRequest;
import in.targetpeak.api.entity.user.UserListResponse;
import in.targetpeak.api.entity.user.UserUpdateRequest;
import in.targetpeak.api.util.ResponseMessageUtility;

@Repository
public class IUserDao implements UserDao {
	String TAG = "IUserDao";

	@PersistenceContext
	private EntityManager entityManager;

	/***
	 * ---------------------------------------------------------------------------
	 * Users Section Created : Mohan Shivarkar (15-09-2021) Modified :
	 * ---------------------------------------------------------------------------
	 ***/

	@SuppressWarnings("unchecked")
	@Override
	public UserListResponse getUsers(UserListRequest request) {

		UserListResponse responseOutput = new UserListResponse();
		List<UserHolder> responseArray = null;

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

				ResponseMessageUtility.showMessage(TAG, request.toString());
				StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("User_FetchUsers",
						UserHolder.class);

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

				procedureQuery.registerStoredProcedureParameter("pUserId", Integer.class, ParameterMode.IN)
						.setParameter("pUserId", request.getUserId() == null ? 0 : request.getUserId());
				procedureQuery.registerStoredProcedureParameter("pDOB", String.class, ParameterMode.IN)
						.setParameter("pDOB", request.getDOB() == null ? "" : request.getDOB());
				procedureQuery.registerStoredProcedureParameter("pGender", Integer.class, ParameterMode.IN)
						.setParameter("pGender", request.getGender() == null ? 0 : request.getGender());
				procedureQuery.registerStoredProcedureParameter("pPhoneVerified", Integer.class, ParameterMode.IN)
						.setParameter("pPhoneVerified",
								request.getPhoneVerified() == null ? 0 : request.getPhoneVerified());
				procedureQuery.registerStoredProcedureParameter("pEmailVerified", Integer.class, ParameterMode.IN)
						.setParameter("pEmailVerified",
								request.getEmailVerified() == null ? 0 : request.getEmailVerified());
				procedureQuery.registerStoredProcedureParameter("pDeviceLogId", Integer.class, ParameterMode.IN)
						.setParameter("pDeviceLogId", request.getDeviceLogId() == null ? 0 : request.getDeviceLogId());
				procedureQuery.registerStoredProcedureParameter("pOrganizationId", Integer.class, ParameterMode.IN)
						.setParameter("pOrganizationId",
								request.getOrganizationId() == null ? 0 : request.getOrganizationId());
				procedureQuery.registerStoredProcedureParameter("pInstituteId", Integer.class, ParameterMode.IN)
						.setParameter("pInstituteId", request.getInstituteId() == null ? 0 : request.getInstituteId());
				procedureQuery.registerStoredProcedureParameter("pClassId", Integer.class, ParameterMode.IN)
						.setParameter("pClassId", request.getClassId() == null ? 0 : request.getClassId());
				procedureQuery.registerStoredProcedureParameter("pDivisionId", Integer.class, ParameterMode.IN)
						.setParameter("pDivisionId", request.getDivisionId() == null ? 0 : request.getDivisionId());

				procedureQuery.registerStoredProcedureParameter("pRoleId", Integer.class, ParameterMode.IN)
						.setParameter("pRoleId", request.getRoleId() == null ? 0 : request.getRoleId());
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

	@Override
	public ApiResponse updateUsers(UserUpdateRequest request) {
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
				StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("User_ManageUpdateUsers",
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

				procedureQuery.registerStoredProcedureParameter("pRoleId", Integer.class, ParameterMode.IN)
						.setParameter("pRoleId", request.getRoleId() == null ? 0 : request.getRoleId());

				procedureQuery.registerStoredProcedureParameter("pUserId", Integer.class, ParameterMode.IN)
						.setParameter("pUserId", request.getUserId() == null ? 0 : request.getUserId());
				procedureQuery.registerStoredProcedureParameter("pFullName", String.class, ParameterMode.IN)
						.setParameter("pFullName", request.getFullName() == null ? "" : request.getFullName());

				procedureQuery.registerStoredProcedureParameter("pDOB", String.class, ParameterMode.IN)
						.setParameter("pDOB", request.getDOB() == null ? "" : request.getDOB());

				procedureQuery.registerStoredProcedureParameter("pGender", Integer.class, ParameterMode.IN)
						.setParameter("pGender", request.getGender() == null ? 0 : request.getGender());
				procedureQuery.registerStoredProcedureParameter("pMobileNo", String.class, ParameterMode.IN)
						.setParameter("pMobileNo", request.getMobileNo() == null ? "" : request.getMobileNo());

				procedureQuery.registerStoredProcedureParameter("pPhoneVerified", Integer.class, ParameterMode.IN)
						.setParameter("pPhoneVerified",
								request.getPhoneVerified() == null ? 0 : request.getPhoneVerified());

				procedureQuery.registerStoredProcedureParameter("pEmail", String.class, ParameterMode.IN)
						.setParameter("pEmail", request.getEmail() == null ? "" : request.getEmail());
				procedureQuery.registerStoredProcedureParameter("pEmailVerified", Integer.class, ParameterMode.IN)
						.setParameter("pEmailVerified",
								request.getEmailVerified() == null ? 0 : request.getEmailVerified());

				procedureQuery.registerStoredProcedureParameter("pUsername", String.class, ParameterMode.IN)
						.setParameter("pUsername", request.getUsername() == null ? "" : request.getUsername());
				procedureQuery.registerStoredProcedureParameter("pUserPassword", String.class, ParameterMode.IN)
						.setParameter("pUserPassword",
								request.getUserPassword() == null ? "" : request.getUserPassword());

				procedureQuery.registerStoredProcedureParameter("pOrganizationId", Integer.class, ParameterMode.IN)
						.setParameter("pOrganizationId",
								request.getOrganizationId() == null ? 0 : request.getOrganizationId());
				procedureQuery.registerStoredProcedureParameter("pInstituteId", Integer.class, ParameterMode.IN)
						.setParameter("pInstituteId", request.getInstituteId() == null ? 0 : request.getInstituteId());
				procedureQuery.registerStoredProcedureParameter("pClassId", Integer.class, ParameterMode.IN)
						.setParameter("pClassId", request.getClassId() == null ? 0 : request.getClassId());
				procedureQuery.registerStoredProcedureParameter("pDivisionId", Integer.class, ParameterMode.IN)
						.setParameter("pDivisionId", request.getDivisionId() == null ? 0 : request.getDivisionId());

				procedureQuery.registerStoredProcedureParameter("pRecordStatus", Integer.class, ParameterMode.IN)
						.setParameter("pRecordStatus",
								request.getRecordStatus() == null ? 0 : request.getRecordStatus());

				procedureQuery.registerStoredProcedureParameter("pPlatform", String.class, ParameterMode.IN)
						.setParameter("pPlatform", request.getPlatform() == null ? "" : request.getPlatform());
				procedureQuery.registerStoredProcedureParameter("pUpdatedThings", String.class, ParameterMode.IN)
						.setParameter("pUpdatedThings",
								request.getUpdatedThings() == null ? "" : request.getUpdatedThings());

				/*
				 * Stored Procedure Execution
				 */

				procedureQuery.execute();
				@SuppressWarnings("unchecked")
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
	public HelpResponse helpMVPUsers(HelpRequest request) {

		HelpResponse responseOutput = new HelpResponse();
		List<HelpHolder> responseArray = null;

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

				ResponseMessageUtility.showMessage(TAG, request.toString());
				StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("Help_MvpUsers",
						HelpHolder.class);

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

	/*
	 * ALL UserList for Admin to edit students and usersData
	 */
	@SuppressWarnings("unchecked")
	@Override
	public TempUserListResponse getAdminSearchUsers(TempUserRequest request) {

		TempUserListResponse responseOutput = new TempUserListResponse();
		List<TempUserHolder> responseArray = null;

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

				ResponseMessageUtility.showMessage(TAG, request.toString());
				StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("Admin_SearchUsers",
						TempUserHolder.class);

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

				procedureQuery.registerStoredProcedureParameter("pUserId", Integer.class, ParameterMode.IN)
						.setParameter("pUserId", request.getUserId() == null ? 0 : request.getUserId());
				procedureQuery.registerStoredProcedureParameter("pOrganizationId", Integer.class, ParameterMode.IN)
						.setParameter("pOrganizationId",
								request.getOrganizationId() == null ? 0 : request.getOrganizationId());

				procedureQuery.registerStoredProcedureParameter("pSearch", String.class, ParameterMode.IN)
						.setParameter("pSearch", request.getSearch() == null ? "" : request.getSearch());

				/*
				 * Stored Procedure Execution
				 */

				procedureQuery.execute();
				responseArray = procedureQuery.getResultList();

				// Checking For Empty Response
				if (responseArray.isEmpty() || responseArray == null) {
					responseOutput.setResponseArray(responseArray);
					responseOutput.setResult(0);
					responseOutput.setMessage("No Data Available");
					responseOutput.setHasError(1);
				} else {
					responseOutput.setResponseArray(responseArray);
					responseOutput.setResult(responseArray.size());
					int rowCount = responseArray.size();
					if (rowCount > 1) {
						responseOutput.setMessage(rowCount + " Rows Returned");
					} else {
						responseOutput.setMessage(rowCount + " Row Returned");
					}
					responseOutput.setHasError(0);
				}

			} catch (Exception e) {
				// Checking For Exception
				responseOutput.setResponseArray(responseArray);
				responseOutput.setResult(0);
				responseOutput.setMessage("Database Error ");
				responseOutput.setHasError(1);
			}

		}

		return responseOutput;
	}

	/*
	 * ALL StudentList for Admin to edit students and usersData
	 */
	@SuppressWarnings("unchecked")
	@Override
	public TempStuddentListResponse getAdminSearchStudents(TempStudentRequest request) {

		TempStuddentListResponse responseOutput = new TempStuddentListResponse();
		List<TempStudentHolder> responseArray = null;

		// Request & pAction Parameter Checking
		if (request == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Invalid Request ");
			responseOutput.setHasError(1);
		} else if (request.getAction() == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Action parameter missing ");
			responseOutput.setHasError(1);
		} else {

			try {

				ResponseMessageUtility.showMessage(TAG, request.toString());
				StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("Admin_SearchUsers",
						TempStudentHolder.class);

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

				procedureQuery.registerStoredProcedureParameter("pUserId", Integer.class, ParameterMode.IN)
						.setParameter("pUserId", request.getUserId() == null ? 0 : request.getUserId());
				procedureQuery.registerStoredProcedureParameter("pOrganizationId", Integer.class, ParameterMode.IN)
						.setParameter("pOrganizationId",
								request.getOrganizationId() == null ? 0 : request.getOrganizationId());

				procedureQuery.registerStoredProcedureParameter("pSearch", String.class, ParameterMode.IN)
						.setParameter("pSearch", request.getSearch() == null ? "" : request.getSearch());

				/*
				 * Stored Procedure Execution
				 */

				procedureQuery.execute();
				responseArray = procedureQuery.getResultList();

				// Checking For Empty Response
				if (responseArray.isEmpty() || responseArray == null) {
					responseOutput.setResponseArray(responseArray);
					responseOutput.setResult(0);
					responseOutput.setMessage("No Data Available");
					responseOutput.setHasError(1);
				} else {
					responseOutput.setResponseArray(responseArray);
					responseOutput.setResult(responseArray.size());
					int rowCount = responseArray.size();
					if (rowCount > 1) {
						responseOutput.setMessage(rowCount + " Rows Returned");
					} else {
						responseOutput.setMessage(rowCount + " Row Returned");
					}
					responseOutput.setHasError(0);
				}
			} catch (Exception e) {
				// Checking For Exception
				responseOutput.setResponseArray(responseArray);
				responseOutput.setResult(0);
				responseOutput.setMessage("Database Error ");
				ResponseMessageUtility.showErrorMessage(TAG, e);
				responseOutput.setHasError(1);
			}

		}

		return responseOutput;
	}

	/*
	 * ALL StudentList for Teacher to edit students
	 */
	@SuppressWarnings("unchecked")
	@Override
	public StudentWithStatusListResponse getStudentsForTeachers(StudentWithStatusListRequest request) {

		StudentWithStatusListResponse responseOutput = new StudentWithStatusListResponse();
		List<StudentWithStatusHolder> responseArray = null;

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

				ResponseMessageUtility.showMessage(TAG, request.toString());
				StoredProcedureQuery procedureQuery = entityManager
						.createStoredProcedureQuery("User_FetchStudentsWithStatus", StudentWithStatusHolder.class);

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

				procedureQuery.registerStoredProcedureParameter("pStudentId", Integer.class, ParameterMode.IN)
						.setParameter("pStudentId", request.getStudentId() == null ? 0 : request.getStudentId());
				procedureQuery.registerStoredProcedureParameter("pUserId", Integer.class, ParameterMode.IN)
						.setParameter("pUserId", request.getUserId() == null ? 0 : request.getUserId());
				procedureQuery.registerStoredProcedureParameter("pOrganizationId", Integer.class, ParameterMode.IN)
						.setParameter("pOrganizationId",
								request.getOrganizationId() == null ? 0 : request.getOrganizationId());
				procedureQuery.registerStoredProcedureParameter("pInstituteId", Integer.class, ParameterMode.IN)
						.setParameter("pInstituteId", request.getInstituteId() == null ? 0 : request.getInstituteId());

				procedureQuery.registerStoredProcedureParameter("pClassId", Integer.class, ParameterMode.IN)
						.setParameter("pClassId", request.getClassId() == null ? 0 : request.getClassId());
				procedureQuery.registerStoredProcedureParameter("pDivisionId", Integer.class, ParameterMode.IN)
						.setParameter("pDivisionId", request.getDivisionId() == null ? 0 : request.getDivisionId());

				procedureQuery.registerStoredProcedureParameter("pDOB", String.class, ParameterMode.IN)
						.setParameter("pDOB", request.getDOB() == null ? "" : request.getDOB());
				procedureQuery.registerStoredProcedureParameter("pGender", Integer.class, ParameterMode.IN)
						.setParameter("pGender", request.getGender() == null ? 0 : request.getGender());

				procedureQuery.registerStoredProcedureParameter("pRecordStatus", Integer.class, ParameterMode.IN)
						.setParameter("pRecordStatus",
								request.getRecordStatus() == null ? 0 : request.getRecordStatus());
				procedureQuery.registerStoredProcedureParameter("pOffset", Integer.class, ParameterMode.IN)
						.setParameter("pOffset", request.getOffset() == null ? 0 : request.getOffset());
				procedureQuery.registerStoredProcedureParameter("pLimit", Integer.class, ParameterMode.IN)
						.setParameter("pLimit", request.getLimit() == null ? 0 : request.getLimit());

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
				responseOutput.setMessage("Database Error ");
				responseOutput.setHasError(1);
				ResponseMessageUtility.showErrorMessage(TAG, e);
			}

		}

		return responseOutput;
	}

	/*
	 * Student To Subject Relation Logics
	 */
	@SuppressWarnings("unchecked")
	public StudentSubjectListResponse fetchStudentSubjectRelations(StudentSubjectListRequest request) {

		StudentSubjectListResponse responseOutput = new StudentSubjectListResponse();
		List<StudentSubjectHolder> responseArray = null;

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
				StoredProcedureQuery procedureQuery = entityManager
						.createStoredProcedureQuery("User_FetchStudentSubjectRelations", StudentSubjectHolder.class);

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

				procedureQuery.registerStoredProcedureParameter("pStudentId", Integer.class, ParameterMode.IN)
						.setParameter("pStudentId", request.getStudentId() == null ? 0 : request.getStudentId());
				
				procedureQuery.registerStoredProcedureParameter("pClassId", Integer.class, ParameterMode.IN)
				.setParameter("pClassId", request.getClassId() == null ? 0 : request.getClassId());

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
	public ApiResponse manageStudentSubjectRelations(StudentSubjectRequest request) {

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
						.createStoredProcedureQuery("User_ManageStudentSubjectRelations", ApiResponse.class);

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

				procedureQuery
						.registerStoredProcedureParameter("pStudentSubjectRelationId", Integer.class, ParameterMode.IN)
						.setParameter("pStudentSubjectRelationId", request.getStudentSubjectRelationId() == null ? 0
								: request.getStudentSubjectRelationId());

				procedureQuery.registerStoredProcedureParameter("pStudentId", Integer.class, ParameterMode.IN)
						.setParameter("pStudentId", request.getStudentId() == null ? 0 : request.getStudentId());

				procedureQuery.registerStoredProcedureParameter("pSubjectId", Integer.class, ParameterMode.IN)
						.setParameter("pSubjectId", request.getSubjectId() == null ? 0 : request.getSubjectId());
				
				procedureQuery.registerStoredProcedureParameter("pIsActive", Integer.class, ParameterMode.IN)
				.setParameter("pIsActive", request.getIsActive() == null ? 0 : request.getIsActive());

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
