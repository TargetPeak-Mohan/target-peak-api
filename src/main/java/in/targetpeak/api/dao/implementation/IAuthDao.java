package in.targetpeak.api.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import in.targetpeak.api.dao.AuthDao;
import in.targetpeak.api.entity.authentication.LoginApiResponse;
import in.targetpeak.api.entity.authentication.UserValidateRequest;
import in.targetpeak.api.util.ResponseMessageUtility;

@Repository
public class IAuthDao implements AuthDao{
	
	String TAG = "IAuthDao";

	@PersistenceContext
	private EntityManager entityManager;

	/***
	 * ---------------------------------------------------------------------------
	 * User Validation  Created : Mohan Shivarkar (15-09-2021) Modified :
	 * ---------------------------------------------------------------------------
	 ***/

	@Override
	public LoginApiResponse authenticateUser(UserValidateRequest request) {
	
		LoginApiResponse responseOutput = new LoginApiResponse();

		// Request & pAction Parameter Checking
		if (request == null) {
			responseOutput.setResult(0);
			responseOutput.setMessage("Invalid request ");
			responseOutput.setMessageInMarathi("अवैध विनंती");
			responseOutput.setHasError(1);
		} else if (request.getAction() == null) {
			responseOutput.setResult(0);
			responseOutput.setMessage("Action parameter missing ");
			responseOutput.setMessageInMarathi("क्रिया मापदंड गहाळ");
			responseOutput.setHasError(1);
		} else {

			try {

				/*
				 * Stored Procedure call
				 */
				StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("Authentication_ValidateUser", LoginApiResponse.class);

				/*
				 * Input Parameters with conditions
				 */

				procedureQuery.registerStoredProcedureParameter("pAction", Integer.class, ParameterMode.IN)
						.setParameter("pAction", request.getAction() == null ? 0 : request.getAction());
				procedureQuery.registerStoredProcedureParameter("pMobileNo", String.class, ParameterMode.IN)
						.setParameter("pMobileNo",request.getMobileNo() == null ? "" : request.getMobileNo());
				procedureQuery.registerStoredProcedureParameter("pAppType", String.class, ParameterMode.IN)
						.setParameter("pAppType", request.getAppType() == null ? "" : request.getAppType());


				/*
				 * Stored Procedure Execution
				 */

				procedureQuery.execute();
				@SuppressWarnings("unchecked")
				List<LoginApiResponse> responseArray = procedureQuery.getResultList();
				ResponseMessageUtility.showMessage(TAG, responseArray.toString());

				// Checking For Empty Response
				if (responseArray.isEmpty() || responseArray == null) {
					responseOutput.setResult(0);
					responseOutput.setMessage("Something went wrong");
					responseOutput.setMessageInMarathi("काहीतरी त्रुटी");
					responseOutput.setHasError(1);
				} else {
					LoginApiResponse apiResponse = responseArray.get(0);
					responseOutput.setResult(apiResponse.getResult());
					responseOutput.setMessage(apiResponse.getMessage());
					responseOutput.setMessageInMarathi(apiResponse.getMessageInMarathi());
					responseOutput.setHasError(apiResponse.getHasError());
				}

			} catch (Exception e) {
				// Checking For Exception
				responseOutput.setResult(0);
				responseOutput.setMessage("Database Error " + e);
				responseOutput.setMessageInMarathi("");
				responseOutput.setHasError(1);
			}

		}
		return responseOutput;
		
	}

}
