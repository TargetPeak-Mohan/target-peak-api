package in.targetpeak.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.targetpeak.api.dao.UtilDao;
import in.targetpeak.api.entity.util.version.VersionListRequest;
import in.targetpeak.api.entity.util.version.VersionListResponse;

@Service
public class UtilService {

	@Autowired
	UtilDao utilDao;

	public VersionListResponse getVersionList(VersionListRequest request) {
		return utilDao.getVersions(request);
	}
}
