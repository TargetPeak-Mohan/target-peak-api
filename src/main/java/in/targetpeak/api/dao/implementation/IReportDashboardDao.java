package in.targetpeak.api.dao.implementation;

import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import in.targetpeak.api.dao.ReportDashboardDao;
import in.targetpeak.api.entity.reports.classes.ClassesDashboardHolder;
import in.targetpeak.api.entity.reports.classes.ClassesDashboardListResponse;
import in.targetpeak.api.entity.reports.classes.ClassesDashboardRequest;
import in.targetpeak.api.entity.reports.dashboard.DashboardHolder;
import in.targetpeak.api.entity.reports.dashboard.DashboardListRequest;
import in.targetpeak.api.entity.reports.dashboard.DashboardListResponse;
import in.targetpeak.api.entity.reports.division.DivisionDashboardHolder;
import in.targetpeak.api.entity.reports.division.DivisionDashboardListResponse;
import in.targetpeak.api.entity.reports.division.DivisionDashboardRequest;
import in.targetpeak.api.entity.reports.institute.InstituteDashboardHolder;
import in.targetpeak.api.entity.reports.institute.InstituteDashboardListResponse;
import in.targetpeak.api.entity.reports.institute.InstituteDashboardRequest;
import in.targetpeak.api.entity.reports.institutestats.InstituteWithStatsHolder;
import in.targetpeak.api.entity.reports.institutestats.InstituteWithStatsListRequest;
import in.targetpeak.api.entity.reports.institutestats.InstituteWithStatsListResponse;
import in.targetpeak.api.entity.reports.organization.OrganizationDahboardRequest;
import in.targetpeak.api.entity.reports.organization.OrganizationDashboardHolder;
import in.targetpeak.api.entity.reports.organization.OrganizationDashboardListResponse;
import in.targetpeak.api.util.ResponseMessageUtility;

/**
 * -----------------------------------------------------------------------------------------------
 * Developed By : Mohan Shivarkar
 * 
 * Created date : 14/09/2021 Modified date : 17/10/2021
 * -----------------------------------------------------------------------------------------------
 * 
 * 1.Getting Reports Dashboard Count From Here
 * 
 *
 * 2.OrganizationDashboard dynamic for MVP
 * ------------------------------------------------------------------------------------------------
 ***/

//@Transactional
@Repository
public class IReportDashboardDao implements ReportDashboardDao {

	String TAG = "IReportDashboardDao";

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public DashboardListResponse fetchReportDashboard(DashboardListRequest request) {

		DashboardListResponse responseOutput = new DashboardListResponse();
		List<DashboardHolder> responseArray = null;

		// Request & pAction Parameter Checking
		if (request == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Invalid request ");
			responseOutput.setHasError(1);
		} else if (request.getpAction() == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("pAction parameter missing ");
			responseOutput.setHasError(1);
		} else {

			try {
				StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("Report_MobileDashboard",
						DashboardHolder.class);

				Field[] fields = request.getClass().getDeclaredFields();

				for (Field field : fields) {
					Field field1 = request.getClass().getDeclaredField(field.getName());
					field1.setAccessible(true);
					Object value = field1.get(request);
					// ResponseMessageUtility.showMessage(TAG,field.getName()+" : "+value);
					procedureQuery.registerStoredProcedureParameter(field.getName(), field.getType(), ParameterMode.IN)
							.setParameter(field.getName(), value);
				}

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

		System.out.println(responseOutput.toString());
		return responseOutput;

	}

	@SuppressWarnings("unchecked")
	@Override
	public OrganizationDashboardListResponse fetchOrganizationReportDashboard(OrganizationDahboardRequest request) {
		OrganizationDashboardListResponse responseOutput = new OrganizationDashboardListResponse();
		List<OrganizationDashboardHolder> responseArray = null;

		// Request & pAction Parameter Checking
		if (request == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Invalid request ");
			responseOutput.setHasError(1);
		} else if (request.getAction() == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("pAction parameter missing ");
			responseOutput.setHasError(1);
		} else {

			try {
				StoredProcedureQuery procedureQuery = entityManager
						.createStoredProcedureQuery("Report_OrganizationDashboard", OrganizationDashboardHolder.class);

				Field[] fields = request.getClass().getDeclaredFields();

				for (Field field : fields) {
					Field field1 = request.getClass().getDeclaredField(field.getName());
					field1.setAccessible(true);
					Object value = field1.get(request);
					// ResponseMessageUtility.showMessage(TAG,field.getName()+" : "+value);
					procedureQuery.registerStoredProcedureParameter(field.getName(), field.getType(), ParameterMode.IN)
							.setParameter(field.getName(), value);
				}

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

		System.out.println(responseOutput.toString());
		return responseOutput;
	}

	@SuppressWarnings("unchecked")
	@Override
	public InstituteDashboardListResponse fetchInstituteReportDashboard(InstituteDashboardRequest request) {
		InstituteDashboardListResponse responseOutput = new InstituteDashboardListResponse();
		List<InstituteDashboardHolder> responseArray = null;

		// Request & pAction Parameter Checking
		if (request == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Invalid request ");
			responseOutput.setHasError(1);
		} else if (request.getAction() == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("pAction parameter missing ");
			responseOutput.setHasError(1);
		} else {

			try {
				StoredProcedureQuery procedureQuery = entityManager
						.createStoredProcedureQuery("Report_InstituteDashboard", InstituteDashboardHolder.class);

				Field[] fields = request.getClass().getDeclaredFields();

				for (Field field : fields) {
					Field field1 = request.getClass().getDeclaredField(field.getName());
					field1.setAccessible(true);
					Object value = field1.get(request);
					// ResponseMessageUtility.showMessage(TAG,field.getName()+" : "+value);
					procedureQuery.registerStoredProcedureParameter(field.getName(), field.getType(), ParameterMode.IN)
							.setParameter(field.getName(), value);
				}

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

		System.out.println(responseOutput.toString());
		return responseOutput;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClassesDashboardListResponse fetchClassesReportDashboard(ClassesDashboardRequest request) {
		ClassesDashboardListResponse responseOutput = new ClassesDashboardListResponse();
		List<ClassesDashboardHolder> responseArray = null;

		// Request & pAction Parameter Checking
		if (request == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Invalid request ");
			responseOutput.setHasError(1);
		} else if (request.getAction() == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("pAction parameter missing ");
			responseOutput.setHasError(1);
		} else {

			try {
				StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("Report_ClassDashboard",
						ClassesDashboardHolder.class);

				Field[] fields = request.getClass().getDeclaredFields();

				for (Field field : fields) {
					Field field1 = request.getClass().getDeclaredField(field.getName());
					field1.setAccessible(true);
					Object value = field1.get(request);
					// ResponseMessageUtility.showMessage(TAG,field.getName()+" : "+value);
					procedureQuery.registerStoredProcedureParameter(field.getName(), field.getType(), ParameterMode.IN)
							.setParameter(field.getName(), value);
				}

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

		System.out.println(responseOutput.toString());
		return responseOutput;
	}

	@SuppressWarnings("unchecked")
	@Override
	public DivisionDashboardListResponse fetchDivisionReportDashboard(DivisionDashboardRequest request) {
		DivisionDashboardListResponse responseOutput = new DivisionDashboardListResponse();
		List<DivisionDashboardHolder> responseArray = null;

		// Request & pAction Parameter Checking
		if (request == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Invalid request ");
			responseOutput.setHasError(1);
		} else if (request.getAction() == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("pAction parameter missing ");
			responseOutput.setHasError(1);
		} else {

			try {
				StoredProcedureQuery procedureQuery = entityManager
						.createStoredProcedureQuery("Report_DivisionDashboard", DivisionDashboardHolder.class);

				Field[] fields = request.getClass().getDeclaredFields();

				for (Field field : fields) {
					Field field1 = request.getClass().getDeclaredField(field.getName());
					field1.setAccessible(true);
					Object value = field1.get(request);
					// ResponseMessageUtility.showMessage(TAG,field.getName()+" : "+value);
					procedureQuery.registerStoredProcedureParameter(field.getName(), field.getType(), ParameterMode.IN)
							.setParameter(field.getName(), value);
				}

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

		System.out.println(responseOutput.toString());
		return responseOutput;
	}

	@SuppressWarnings("unchecked")
	@Override
	public InstituteWithStatsListResponse fetchInstituteWithStatsDashboard(InstituteWithStatsListRequest request) {
		InstituteWithStatsListResponse responseOutput = new InstituteWithStatsListResponse();
		List<InstituteWithStatsHolder> responseArray = null;

		// Request & pAction Parameter Checking
		if (request == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("Invalid request ");
			responseOutput.setHasError(1);
		} else if (request.getAction() == null) {
			responseOutput.setResponseArray(responseArray);
			responseOutput.setResult(0);
			responseOutput.setMessage("pAction parameter missing ");
			responseOutput.setHasError(1);
		} else {

			try {
				StoredProcedureQuery procedureQuery = entityManager
						.createStoredProcedureQuery("Report_FetchInstitutes", InstituteWithStatsHolder.class);

				Field[] fields = request.getClass().getDeclaredFields();

				for (Field field : fields) {
					Field field1 = request.getClass().getDeclaredField(field.getName());
					field1.setAccessible(true);
					Object value = field1.get(request);
					ResponseMessageUtility.showMessage(TAG,field.getName()+" : "+value);
					procedureQuery.registerStoredProcedureParameter(field.getName(), field.getType(), ParameterMode.IN)
							.setParameter(field.getName(), value);
				}

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

		System.out.println(responseOutput.toString());
		return responseOutput;
	}

}
