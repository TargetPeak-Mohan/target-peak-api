package in.targetpeak.api.entity.result;

import java.util.ArrayList;

public class ExamRegularResultJsonHolder {

	int organizationId;
	int instituteId;
	int classId;
	int divisionId;

	ArrayList<ExamRegularResultUiHolder> examRegularResultUiHolders;

	public ExamRegularResultJsonHolder() {
		super();
	}

	public ExamRegularResultJsonHolder(int organizationId, int instituteId, int classId, int divisionId,
			ArrayList<ExamRegularResultUiHolder> examRegularResultUiHolders) {
		super();
		this.organizationId = organizationId;
		this.instituteId = instituteId;
		this.classId = classId;
		this.divisionId = divisionId;
		this.examRegularResultUiHolders = examRegularResultUiHolders;
	}

	public int getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	public int getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(int divisionId) {
		this.divisionId = divisionId;
	}

	public ArrayList<ExamRegularResultUiHolder> getExamRegularResultUiHolders() {
		return examRegularResultUiHolders;
	}

	public void setExamRegularResultUiHolders(ArrayList<ExamRegularResultUiHolder> examRegularResultUiHolders) {
		this.examRegularResultUiHolders = examRegularResultUiHolders;
	}

}
