package in.targetpeak.api.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import in.targetpeak.api.dao.UserDao;
import in.targetpeak.api.dao.implementation.IUserDao;
import in.targetpeak.api.entity.student.StudentWithStatusHolder;
import in.targetpeak.api.entity.student.StudentWithStatusListRequest;
import in.targetpeak.api.entity.student.StudentWithStatusListResponse;

public class Test {

	@Autowired
	static UserDao userDao;

	public void main() {
		System.out.println("Its local main method");
	}

	public static void main(String[] args) {
		
		System.out.println("Check");

		/*
		 * IUserDao iUserDao=new IUserDao(); Integer AttendantId = 1; Integer
		 * AttendantRoleId = 4; Integer Action = 2;
		 * 
		 * Integer StudentId = 0; Integer UserId = 0; Integer InstituteId = 892; Integer
		 * OrganizationId = 1; Integer ClassId = 15; Integer DivisionId = 52; String DOB
		 * = ""; Integer Gender = 0;
		 * 
		 * Integer RecordStatus = 0; Integer Offset = 0; Integer Limit = 1000; String
		 * Search = ""; String SyncDate = "";
		 * 
		 * StudentWithStatusListRequest request = new
		 * StudentWithStatusListRequest(AttendantId, AttendantRoleId, Action, StudentId,
		 * UserId, InstituteId, OrganizationId, ClassId, DivisionId, DOB, Gender,
		 * RecordStatus, Offset, Limit, Search, SyncDate); StudentWithStatusListResponse
		 * studentWithStatusListResponse = iUserDao.getStudentsForTeachers(request);
		 * List<StudentWithStatusHolder> studentWithStatusHolders =
		 * studentWithStatusListResponse.getResponseArray();
		 * System.out.println(studentWithStatusHolders.toString());
		 */
		
		String myWord="ddf";
		if(!StringUtils.hasLength(myWord) || StringUtils.hasText(myWord)) 
			System.out.println("Yes");
		else
			System.out.println("No");
		
		if(StringUtils.hasText(myWord)) 
			System.out.println("Yes");
		else
			System.out.println("No");
		
	}
}
