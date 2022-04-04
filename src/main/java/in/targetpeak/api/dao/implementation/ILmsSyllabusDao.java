package in.targetpeak.api.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import in.targetpeak.api.dao.LmsSyllabusDao;
import in.targetpeak.api.entity.ApiResponse;
import in.targetpeak.api.entity.lms.syllabus.chapter.ChapterHolder;
import in.targetpeak.api.entity.lms.syllabus.chapter.ChapterListRequest;
import in.targetpeak.api.entity.lms.syllabus.chapter.ChapterListResponse;
import in.targetpeak.api.entity.lms.syllabus.chapter.ChapterRequest;
import in.targetpeak.api.entity.lms.syllabus.topic.TopicHolder;
import in.targetpeak.api.entity.lms.syllabus.topic.TopicListRequest;
import in.targetpeak.api.entity.lms.syllabus.topic.TopicListResponse;
import in.targetpeak.api.entity.lms.syllabus.topic.TopicRequest;
import in.targetpeak.api.entity.util.version.VersionHolder;
import in.targetpeak.api.util.ResponseMessageUtility;

@Repository
public class ILmsSyllabusDao implements LmsSyllabusDao {

	String TAG = "ILmsSyllabusDao";

	@PersistenceContext
	private EntityManager entityManager;

	/***
	 * ---------------------------------------------------------------------------
	 * Syllabus Chapter and Topic Sections here Main purpose right now is to manage
	 * them from app itself : Mohan Shivarkar (28-09-2021) Modified :
	 * ---------------------------------------------------------------------------
	 ***/

	@SuppressWarnings("unchecked")
	@Override
	public ChapterListResponse fetchChapters(ChapterListRequest request) {
		ChapterListResponse responseOutput = new ChapterListResponse();
		List<ChapterHolder> responseArray = null;

		ResponseMessageUtility.showMessage(TAG, request.toString());
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
				StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("Lms_FetchSyllabusChapters", ChapterHolder.class);

				
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
				procedureQuery.registerStoredProcedureParameter("pSyllabusChapterId", Integer.class, ParameterMode.IN)
						.setParameter("pSyllabusChapterId",
								request.getSyllabusChapterId() == null ? 0 : request.getSyllabusChapterId());
				procedureQuery.registerStoredProcedureParameter("pSubjectId", Integer.class, ParameterMode.IN)
						.setParameter("pSubjectId", request.getSubjectId() == null ? 0 : request.getSubjectId());

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
				
				ResponseMessageUtility.showMessage(TAG, ""+procedureQuery.getParameters().toString());
				//ResponseMessageUtility.showMessage(TAG, ""+procedureQuery.);

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
				}

			} catch (Exception e) {
				// Checking For Exception
				ResponseMessageUtility.showErrorMessage(TAG, e);
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
	public ApiResponse manageChapter(ChapterRequest request) {
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

				ResponseMessageUtility.showMessage(TAG, request.toString());
				/*
				 * Stored Procedure call
				 */
				StoredProcedureQuery procedureQuery = entityManager
						.createStoredProcedureQuery("Lms_ManageSyllabusChapters", ApiResponse.class);

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

				procedureQuery.registerStoredProcedureParameter("pSyllabusChapterId", Integer.class, ParameterMode.IN)
						.setParameter("pSyllabusChapterId",
								request.getSyllabusChapterId() == null ? 0 : request.getSyllabusChapterId());

				procedureQuery.registerStoredProcedureParameter("pSubjectId", String.class, ParameterMode.IN)
						.setParameter("pSubjectId", request.getSubjectId() == null ? "" : request.getSubjectId());
				procedureQuery.registerStoredProcedureParameter("pChapterName", String.class, ParameterMode.IN)
						.setParameter("pChapterNames",
								request.getChapterName() == null ? 100 : request.getChapterName());
				procedureQuery.registerStoredProcedureParameter("pChapterNameInMarathi", String.class, ParameterMode.IN)
						.setParameter("pChapterNameInMarathi",
								request.getChapterNameInMarathi() == null ? "" : request.getChapterNameInMarathi());
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
	public TopicListResponse fetchTopics(TopicListRequest request) {
		TopicListResponse responseOutput = new TopicListResponse();
		List<TopicHolder> responseArray = null;

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
						.createStoredProcedureQuery("Lms_FetchSyllabusTopics", TopicHolder.class);

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

				procedureQuery.registerStoredProcedureParameter("pSyllabusTopicId", Integer.class, ParameterMode.IN)
						.setParameter("pSyllabusTopicId",
								request.getSyllabusTopicId() == null ? 0 : request.getSyllabusTopicId());

				procedureQuery.registerStoredProcedureParameter("pSyllabusChapterId", Integer.class, ParameterMode.IN)
						.setParameter("pSyllabusChapterId",
								request.getSyllabusChapterId() == null ? 0 : request.getSyllabusChapterId());
				procedureQuery.registerStoredProcedureParameter("pSubjectId", Integer.class, ParameterMode.IN)
						.setParameter("pSubjectId", request.getSubjectId() == null ? 0 : request.getSubjectId());
				procedureQuery.registerStoredProcedureParameter("pClassId", Integer.class, ParameterMode.IN)
						.setParameter("pClassId", request.getClassId() == null ? 0 : request.getClassId());
				procedureQuery.registerStoredProcedureParameter("pEducationBoardId", Integer.class, ParameterMode.IN)
						.setParameter("pEducationBoardId",
								request.getEducationBoardId() == null ? 0 : request.getEducationBoardId());

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
	public ApiResponse manageTopic(TopicRequest request) {
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
						.createStoredProcedureQuery("Lms_ManageSyllabusChapters", ApiResponse.class);

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

				procedureQuery.registerStoredProcedureParameter("pSyllabusTopicId", Integer.class, ParameterMode.IN)
						.setParameter("pSyllabusTopicId",
								request.getSyllabusTopicId() == null ? 0 : request.getSyllabusTopicId());

				procedureQuery.registerStoredProcedureParameter("pSyllabusChapterId", Integer.class, ParameterMode.IN)
						.setParameter("pSyllabusChapterId",
								request.getSyllabusChapterId() == null ? 0 : request.getSyllabusChapterId());

				procedureQuery.registerStoredProcedureParameter("pTopicName", String.class, ParameterMode.IN)
						.setParameter("pTopicName", request.getTopicName() == null ? 100 : request.getTopicName());
				procedureQuery.registerStoredProcedureParameter("pTopicNameInMarathi", String.class, ParameterMode.IN)
						.setParameter("pTopicNameInMarathi",
								request.getTopicNameInMarathi() == null ? "" : request.getTopicNameInMarathi());
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
