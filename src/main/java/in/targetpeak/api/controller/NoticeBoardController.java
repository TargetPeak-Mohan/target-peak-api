package in.targetpeak.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.targetpeak.api.entity.noticeboard.NoticeBoardOtherUserRequest;
import in.targetpeak.api.entity.noticeboard.NoticeBoardStudentRequest;
import in.targetpeak.api.service.NoticeBoardServices;
import io.swagger.annotations.Api;

@RequestMapping(value = "/noticeboard", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Notice Board", value = "Notice Board related all rest endpoints", description = "")
@Controller
public class NoticeBoardController {

	@Autowired
	NoticeBoardServices noticeBoardServices;

	@GetMapping("/getStudentNoticeBoard")
	public String getStudentNoticeBoard(NoticeBoardStudentRequest request, Model model) {
		String responsePage = noticeBoardServices.getNoticeBoardError("Under Development", "NoticeBoard will live soon",
				"नोटिसबोर्ड लवकरच लाइव्ह होईल", model);
		return responsePage;
	}

	@GetMapping("/getOtherUserNoticeBoard")
	public String getOtherUserNoticeBoard(NoticeBoardOtherUserRequest request, Model model) {
		String responsePage = noticeBoardServices.getNoticeBoardError("Under Development", "NoticeBoard will live soon",
				"नोटिसबोर्ड लवकरच लाइव्ह होईल", model);
		return responsePage;
	}

}
