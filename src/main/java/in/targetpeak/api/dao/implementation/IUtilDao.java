package in.targetpeak.api.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;

import in.targetpeak.api.dao.UtilDao;
import in.targetpeak.api.entity.master.organization.OrganizationHolder;
import in.targetpeak.api.entity.util.version.VersionHolder;
import in.targetpeak.api.entity.util.version.VersionListRequest;
import in.targetpeak.api.entity.util.version.VersionListResponse;

@Repository
public class IUtilDao implements UtilDao {

	String TAG = "IUtilDao";

	//@PersistenceContext
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	/***
	 * ---------------------------------------------------------------------------
	 * AppVersion Section Created : Mohan Shivarkar (16-09-2021) Modified :
	 * ---------------------------------------------------------------------------
	 ***/
	@SuppressWarnings("unchecked")
	@Override
	public VersionListResponse getVersions(VersionListRequest request) {
		VersionListResponse responseOutput = new VersionListResponse();
		List<VersionHolder> responseArray = null;

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
				StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("Util_FetchAppVersions",
						VersionHolder.class);

				/*
				 * Input Parameters with conditions
				 */
				procedureQuery.registerStoredProcedureParameter("pAction", Integer.class, ParameterMode.IN)
						.setParameter("pAction", request.getAction() == null ? 0 : request.getAction());
				procedureQuery.registerStoredProcedureParameter("pEnvironment", String.class, ParameterMode.IN)
						.setParameter("pEnvironment", request.getEnvironment() == null ? "" : request.getEnvironment());
				procedureQuery.registerStoredProcedureParameter("pPriority", Integer.class, ParameterMode.IN)
						.setParameter("pPriority", request.getPriority() == null ? 0 : request.getPriority());

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
