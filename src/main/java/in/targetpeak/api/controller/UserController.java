package in.targetpeak.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import in.targetpeak.api.service.UserService;
import io.swagger.annotations.Api;

@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "User", value = "Help Users(Show concern person to users if any problem with detailsResource REST Endpoint", description = "")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping()
	public UserListResponse getUsersList(UserListRequest request) {
		return userService.getUsersList(request);
	}

	@PostMapping("/update")
	public ApiResponse updateUserData(@RequestBody UserUpdateRequest request) {
		return userService.updateUser(request);
	}

	@GetMapping("/help")
	public HelpResponse helpMvpUsers(HelpRequest request) {
		return userService.helpMVPUsers(request);
	}

	@GetMapping("/search/user")
	public TempUserListResponse fetchAdminSearchUsers(TempUserRequest request) {
		return userService.getAdminSearchUsers(request);
	}

	@GetMapping("/search/student")
	public TempStuddentListResponse fetchStudentSearchUsers(TempStudentRequest request) {
		return userService.getAdminSearchStudents(request);
	}

	@GetMapping("/students")
	public StudentWithStatusListResponse getUserStudentWithStatusList(StudentWithStatusListRequest request) {
		return userService.getStudentListWithStatus(request);
	}

	/* STudent-SUbject-Relation */
	@GetMapping("/student/subjectrelations")
	public StudentSubjectListResponse getStudentSubjectRelations(StudentSubjectListRequest request) {
		return userService.getStudentStudentSubjectRelations(request);
	}

	@PostMapping("/student/subjectrelations")
	public ApiResponse manageStudentSubjectRelations(@RequestBody StudentSubjectRequest request) {
		return userService.manageStudentSubjectRelation(request);
	}

}
