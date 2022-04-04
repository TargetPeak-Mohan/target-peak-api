package in.targetpeak.api.dao;

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

public interface UserDao {

	public UserListResponse getUsers(UserListRequest request);

	public ApiResponse updateUsers(UserUpdateRequest request);

	public HelpResponse helpMVPUsers(HelpRequest request);

	public TempUserListResponse getAdminSearchUsers(TempUserRequest request);

	public TempStuddentListResponse getAdminSearchStudents(TempStudentRequest request);

	public StudentWithStatusListResponse getStudentsForTeachers(StudentWithStatusListRequest request);

	public StudentSubjectListResponse fetchStudentSubjectRelations(StudentSubjectListRequest request);

	public ApiResponse manageStudentSubjectRelations(StudentSubjectRequest request);

}
