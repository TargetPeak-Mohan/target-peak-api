package in.targetpeak.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.targetpeak.api.dao.ExamDao;
import in.targetpeak.api.entity.exam.core.ExaminationListReponse;
import in.targetpeak.api.entity.exam.core.ExaminationsListRequest;
import in.targetpeak.api.entity.exam.regular.ExamSubjectListRequest;
import in.targetpeak.api.entity.exam.regular.ExamSubjectListResponse;

@Service
public class ExamService {

	@Autowired
	private ExamDao examDao;

	public ExamSubjectListResponse fetchRegularExamSubjects(ExamSubjectListRequest request) {
		return examDao.fetchRegularExamSubjects(request);
	}

	public ExaminationListReponse fetchExaminationList(ExaminationsListRequest request) {
		return examDao.fetchExaminationaList(request);
	}

}
