package in.targetpeak.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.targetpeak.api.dao.UserDao;
import in.targetpeak.api.entity.ApiResponse;
import in.targetpeak.api.entity.admin.students.TempStuddentListResponse;
import in.targetpeak.api.entity.admin.students.TempStudentRequest;
import in.targetpeak.api.entity.admin.users.TempUserListResponse;
import in.targetpeak.api.entity.admin.users.TempUserRequest;
import in.targetpeak.api.entity.help.HelpRequest;
import in.targetpeak.api.entity.help.HelpResponse;
import in.targetpeak.api.entity.student.StudentWithStatusListRequest;
import in.targetpeak.api.entity.student.StudentWithStatusListResponse;
import in.targetpeak.api.entity.studentsubject.StudentSubjectListRequest;
import in.targetpeak.api.entity.studentsubject.StudentSubjectListResponse;
import in.targetpeak.api.entity.studentsubject.StudentSubjectRequest;
import in.targetpeak.api.entity.user.UserListRequest;
import in.targetpeak.api.entity.user.UserListResponse;
import in.targetpeak.api.entity.user.UserUpdateRequest;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public UserListResponse getUsersList(UserListRequest request) {
		return userDao.getUsers(request);
	}

	public ApiResponse updateUser(UserUpdateRequest request) {
		return userDao.updateUsers(request);
	}

	public HelpResponse helpMVPUsers(HelpRequest request) {
		return userDao.helpMVPUsers(request);
	}

	public TempUserListResponse getAdminSearchUsers(TempUserRequest request) {
		return userDao.getAdminSearchUsers(request);
	}

	public TempStuddentListResponse getAdminSearchStudents(TempStudentRequest request) {
		return userDao.getAdminSearchStudents(request);
	}

	public StudentWithStatusListResponse getStudentListWithStatus(StudentWithStatusListRequest request) {
		return userDao.getStudentsForTeachers(request);
	}

	public StudentSubjectListResponse getStudentStudentSubjectRelations(StudentSubjectListRequest request) {
		return userDao.fetchStudentSubjectRelations(request);
	}

	public ApiResponse manageStudentSubjectRelation(StudentSubjectRequest request) {
		return userDao.manageStudentSubjectRelations(request);
	}

}
