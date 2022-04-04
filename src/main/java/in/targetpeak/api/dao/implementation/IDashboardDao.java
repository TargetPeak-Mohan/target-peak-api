package in.targetpeak.api.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import in.targetpeak.api.dao.DashboardDao;
import in.targetpeak.api.entity.dashboard.DashboardExaminationHolder;
import in.targetpeak.api.entity.dashboard.DashboardExaminationList;
import in.targetpeak.api.entity.dashboard.DashboardPaperHolder;
import in.targetpeak.api.entity.dashboard.DashboardPaperList;
import in.targetpeak.api.entity.dashboard.DashboardTimetableHolder;
import in.targetpeak.api.entity.dashboard.DashboardTimetableResponse;

@Repository
public class IDashboardDao implements DashboardDao {

	String TAG = "IDashboardDao";

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public DashboardExaminationList getDashboardExaminationsList(int action) {
		DashboardExaminationList responseOutput = new DashboardExaminationList();
		List<DashboardExaminationHolder> responseArray = null;

		try {
			StoredProcedureQuery procedureQuery = entityManager
					.createStoredProcedureQuery("App_Temp_Dashboard_Examinations", DashboardExaminationHolder.class);

			/*
			 * Input Parameters with conditions
			 */
			procedureQuery.registerStoredProcedureParameter("pAction", Integer.class, ParameterMode.IN)
					.setParameter("pAction", action);

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
			System.err.println(e);
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Database Error " + e);
			responseOutput.setHasError(1);
		}

		return responseOutput;
	}

	@SuppressWarnings("unchecked")
	@Override
	public DashboardPaperList getPeakExaminationsPaperList(int action, int examinationId,int organizationId) {
		DashboardPaperList responseOutput = new DashboardPaperList();
		List<DashboardPaperHolder> responseArray = null;

		try {
			StoredProcedureQuery procedureQuery = entityManager
					.createStoredProcedureQuery("App_Temp_Dashboard_Examinations_Papers", DashboardPaperHolder.class);

			/*
			 * Input Parameters with conditions
			 */
			procedureQuery.registerStoredProcedureParameter("pAction", Integer.class, ParameterMode.IN)
					.setParameter("pAction", action);
			procedureQuery.registerStoredProcedureParameter("pExaminationId", Integer.class, ParameterMode.IN)
					.setParameter("pExaminationId", examinationId);
			procedureQuery.registerStoredProcedureParameter("pOrganizationId", Integer.class, ParameterMode.IN)
			.setParameter("pOrganizationId", organizationId);
			procedureQuery.registerStoredProcedureParameter("pInstituteId", Integer.class, ParameterMode.IN)
			.setParameter("pInstituteId", 0);
			procedureQuery.registerStoredProcedureParameter("pClassId", Integer.class, ParameterMode.IN)
			.setParameter("pClassId", 0);
			procedureQuery.registerStoredProcedureParameter("pDivisionId", Integer.class, ParameterMode.IN)
			.setParameter("pDivisionId", 0);

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

		return responseOutput;
	}

	@SuppressWarnings("unchecked")
	@Override
	public DashboardTimetableResponse getMvpExaminationTimetable(int examinationId, int organizationId,int instituteId,
			int classId,int divisionId) {
		DashboardTimetableResponse responseOutput = new DashboardTimetableResponse();
		List<DashboardTimetableHolder> responseArray = null;

		try {
			StoredProcedureQuery procedureQuery = entityManager
					.createStoredProcedureQuery("App_Temp_Dashboard_Examinations_Papers", DashboardTimetableHolder.class);

			/*
			 * Input Parameters with conditions
			 */
			procedureQuery.registerStoredProcedureParameter("pAction", Integer.class, ParameterMode.IN)
					.setParameter("pAction", 2);
			procedureQuery.registerStoredProcedureParameter("pExaminationId", Integer.class, ParameterMode.IN)
					.setParameter("pExaminationId", examinationId);
			procedureQuery.registerStoredProcedureParameter("pOrganizationId", Integer.class, ParameterMode.IN)
			.setParameter("pOrganizationId", organizationId);
			procedureQuery.registerStoredProcedureParameter("pInstituteId", Integer.class, ParameterMode.IN)
			.setParameter("pInstituteId", instituteId);
			procedureQuery.registerStoredProcedureParameter("pClassId", Integer.class, ParameterMode.IN)
			.setParameter("pClassId", classId);
			procedureQuery.registerStoredProcedureParameter("pDivisionId", Integer.class, ParameterMode.IN)
			.setParameter("pDivisionId", divisionId);

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

		return responseOutput;
	}

}
