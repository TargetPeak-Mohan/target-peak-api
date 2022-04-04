package in.targetpeak.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.targetpeak.api.dao.UtilDao;
import in.targetpeak.api.entity.util.version.VersionHolder;
import in.targetpeak.api.entity.util.version.VersionListRequest;
import in.targetpeak.api.entity.util.version.VersionListResponse;
import in.targetpeak.api.entity.util.versions.Version;

@Service
public class WelcomeService {

	@Autowired
	UtilDao utilDao;

	public List<Version> getVersionList() {

		VersionListRequest request = new VersionListRequest(1, "android", 1);
		UtilService utilService1 = new UtilService();
		VersionListResponse response = utilService1.getVersionList(request);
		
		List<VersionHolder> versionholders = response.getResponseArray();
		ArrayList<Version> versions = new ArrayList<Version>();
		for (VersionHolder versionHolder : versionholders) {
			versions.add(new Version(versionHolder.getAppVersionId(), versionHolder.getEnvironment()));
		}
		
		
		return versions;

	}

}
