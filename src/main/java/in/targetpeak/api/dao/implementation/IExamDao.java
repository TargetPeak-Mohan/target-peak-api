package in.targetpeak.api.dao.implementation;

import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import in.targetpeak.api.dao.ExamDao;
import in.targetpeak.api.entity.exam.core.ExaminationHolder;
import in.targetpeak.api.entity.exam.core.ExaminationListReponse;
import in.targetpeak.api.entity.exam.core.ExaminationsListRequest;
import in.targetpeak.api.entity.exam.peak.PeakExamResultHolder;
import in.targetpeak.api.entity.exam.peak.PeakExamResultStatusRequest;
import in.targetpeak.api.entity.exam.peak.PeakExamResultListResponse;
import in.targetpeak.api.entity.exam.regular.ExamSubjectHolder;
import in.targetpeak.api.entity.exam.regular.ExamSubjectListRequest;
import in.targetpeak.api.entity.exam.regular.ExamSubjectListResponse;
import in.targetpeak.api.entity.result.ExamResultHolder;
import in.targetpeak.api.entity.result.ExamResultListResponse;
import in.targetpeak.api.entity.result.ExamResultRequest;

@Repository
public class IExamDao implements ExamDao {

	String TAG = "IExamDao";

	@PersistenceContext
	private EntityManager entityManager;

	/***
	 * ---------------------------------------------------------------------------
	 * Organization Section Created : Mohan Shivarkar (22-11-2021) Modified :
	 * ---------------------------------------------------------------------------
	 ***/

	@SuppressWarnings("unchecked")
	@Override
	public ExamSubjectListResponse fetchRegularExamSubjects(ExamSubjectListRequest request) {

		ExamSubjectListResponse responseOutput = new ExamSubjectListResponse();
		List<ExamSubjectHolder> responseArray = null;

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
				StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("Exam_FetchSubjects",
						ExamSubjectHolder.class);

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

				procedureQuery.registerStoredProcedureParameter("pInstituteId", Integer.class, ParameterMode.IN)
						.setParameter("pInstituteId", request.getInstituteId() == null ? 0 : request.getInstituteId());
				procedureQuery.registerStoredProcedureParameter("pClassId", Integer.class, ParameterMode.IN)
						.setParameter("pClassId", request.getClassId() == null ? 0 : request.getClassId());

				procedureQuery.registerStoredProcedureParameter("pExamTypeId", Integer.class, ParameterMode.IN)
						.setParameter("pExamTypeId", request.getExamTypeId() == null ? 0 : request.getExamTypeId());

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
	public ExamResultListResponse fetchExamResults(ExamResultRequest request) {

		ExamResultListResponse responseOutput = new ExamResultListResponse();
		List<ExamResultHolder> responseArray = null;

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
				StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("Exam_FetchResults",
						ExamResultHolder.class);

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

				procedureQuery.registerStoredProcedureParameter("pResultId", Integer.class, ParameterMode.IN)
						.setParameter("pResultId", request.getResultId() == null ? 0 : request.getResultId());

				procedureQuery.registerStoredProcedureParameter("pQuestionPaperId", Integer.class, ParameterMode.IN)
						.setParameter("pQuestionPaperId",
								request.getQuestionPaperId() == null ? 0 : request.getQuestionPaperId());
				procedureQuery.registerStoredProcedureParameter("pStudentId", Integer.class, ParameterMode.IN)
						.setParameter("pStudentId", request.getStudentId() == null ? 0 : request.getStudentId());

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

	@SuppressWarnings("unchecked")
	@Override
	public PeakExamResultListResponse fetchPeakExamResults(PeakExamResultStatusRequest request) {

		PeakExamResultListResponse responseOutput = new PeakExamResultListResponse();
		List<PeakExamResultHolder> responseArray = null;

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
				StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("Exam_FetchPeakResults",
						PeakExamResultHolder.class);

				/*
				 * Input Parameters with conditions
				 */

				procedureQuery.registerStoredProcedureParameter("pAction", Integer.class, ParameterMode.IN)
						.setParameter("pAction", request.getAction() == null ? 0 : request.getAction());

				procedureQuery.registerStoredProcedureParameter("pOrganizationId", Integer.class, ParameterMode.IN)
						.setParameter("pOrganizationId",
								request.getOrganizationId() == null ? 0 : request.getOrganizationId());

				procedureQuery.registerStoredProcedureParameter("pInstituteId", Integer.class, ParameterMode.IN)
						.setParameter("pInstituteId", request.getInstituteId() == null ? 0 : request.getInstituteId());

				procedureQuery.registerStoredProcedureParameter("pClassId", Integer.class, ParameterMode.IN)
						.setParameter("pClassId", request.getClassId() == null ? 0 : request.getClassId());

				procedureQuery.registerStoredProcedureParameter("pDivisionId", Integer.class, ParameterMode.IN)
						.setParameter("pDivisionId", request.getDivisionId() == null ? 0 : request.getDivisionId());

				procedureQuery.registerStoredProcedureParameter("pQuestionPaperId", Integer.class, ParameterMode.IN)
						.setParameter("pQuestionPaperId",
								request.getQuestionPaperId() == null ? 0 : request.getQuestionPaperId());

				procedureQuery.registerStoredProcedureParameter("pRecordStatus", Integer.class, ParameterMode.IN)
						.setParameter("pRecordStatus",
								request.getRecordStatus() == null ? 0 : request.getRecordStatus());
				procedureQuery.registerStoredProcedureParameter("pOffset", Integer.class, ParameterMode.IN)
						.setParameter("pOffset", request.getOffset() == null ? 0 : request.getOffset());
				procedureQuery.registerStoredProcedureParameter("pLimit", Integer.class, ParameterMode.IN)
						.setParameter("pLimit", request.getLimit() == null ? 500 : request.getLimit());

				procedureQuery.registerStoredProcedureParameter("pSearch", String.class, ParameterMode.IN)
						.setParameter("pSearch", request.getSearch() == null ? "" : request.getSearch());

				procedureQuery.registerStoredProcedureParameter("pSyncDate", String.class, ParameterMode.IN)
						.setParameter("pSyncDate", request.getSyncDate() == null ? "" : request.getSyncDate());

				/*
				 * Stored Procedure Execution
				 */

				procedureQuery.execute();
				responseArray = procedureQuery.getResultList();
				System.out.println(responseArray.toString());

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
					System.out.println("Available");
					
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

	/***
	 * ---------------------------------------------------------------------------
	 * GetExaminationsList Date:01-02-2022
	 * ---------------------------------------------------------------------------
	 ***/
	@SuppressWarnings("unchecked")
	public ExaminationListReponse fetchExaminationaList(ExaminationsListRequest request) {
		ExaminationListReponse responseOutput = new ExaminationListReponse();
		List<ExaminationHolder> responseArray = null;

		System.out.println("ExaminationsListRequest :"+request.toString());
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
						.createStoredProcedureQuery("App_Exam_FetchExaminations", ExaminationHolder.class);

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

				procedureQuery.registerStoredProcedureParameter("pExaminationId", Integer.class, ParameterMode.IN)
						.setParameter("pExaminationId",
								request.getExaminationId() == null ? 0 : request.getExaminationId());
				procedureQuery.registerStoredProcedureParameter("pExaminationBoardId", Integer.class, ParameterMode.IN)
						.setParameter("pExaminationBoardId",
								request.getExaminationBoardId() == null ? 0 : request.getExaminationBoardId());
				procedureQuery.registerStoredProcedureParameter("pOrganizationId", Integer.class, ParameterMode.IN)
						.setParameter("pOrganizationId",
								request.getOrganizationId() == null ? 0 : request.getOrganizationId());
				procedureQuery.registerStoredProcedureParameter("pInstituteId", Integer.class, ParameterMode.IN)
						.setParameter("pInstituteId", request.getInstituteId() == null ? 0 : request.getInstituteId());
				procedureQuery.registerStoredProcedureParameter("pClassId", Integer.class, ParameterMode.IN)
						.setParameter("pClassId", request.getClassId() == null ? 0 : request.getClassId());

				procedureQuery.registerStoredProcedureParameter("pStartDate", String.class, ParameterMode.IN)
						.setParameter("pStartDate", request.getStartDate() == null ? 0 : request.getStartDate());
				procedureQuery.registerStoredProcedureParameter("pEndDate", String.class, ParameterMode.IN)
						.setParameter("pEndDate", request.getEndDate() == null ? 0 : request.getEndDate());

				procedureQuery.registerStoredProcedureParameter("pRecordStatus", Integer.class, ParameterMode.IN)
						.setParameter("pRecordStatus",
								request.getRecordStatus() == null ? 0 : request.getRecordStatus());
				procedureQuery.registerStoredProcedureParameter("pOffset", Integer.class, ParameterMode.IN)
						.setParameter("pOffset", request.getOffset() == null ? 0 : request.getOffset());
				procedureQuery.registerStoredProcedureParameter("pLimit", Integer.class, ParameterMode.IN)
						.setParameter("pLimit", request.getLimit() == null ? 0 : request.getLimit());
				procedureQuery.registerStoredProcedureParameter("pSearch", String.class, ParameterMode.IN)
						.setParameter("pSearch", request.getSearch() == null ? 0 : request.getSearch());
				procedureQuery.registerStoredProcedureParameter("pSyncDate", String.class, ParameterMode.IN)
						.setParameter("pSyncDate", request.getSyncDate() == null ? 0 : request.getSyncDate());

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

}
