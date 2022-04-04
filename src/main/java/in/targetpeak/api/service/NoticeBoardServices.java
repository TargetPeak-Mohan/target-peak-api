package in.targetpeak.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import in.targetpeak.api.dao.NoticeBoardDao;

@Service
public class NoticeBoardServices {


	//@Autowired
	//NoticeBoardDao noticeBoardDao;
	
	
	public String getNoticeBoardError(String headerMessage, String cardTitle, String cardText, Model model) {
		model.addAttribute("txtHeader", headerMessage);
		model.addAttribute("txtCardTitle", cardTitle);
		model.addAttribute("txtCardText", cardText);
		return "pages/noticeboard/error-noticeboard";

	}
	
}
