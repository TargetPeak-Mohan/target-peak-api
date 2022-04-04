package in.targetpeak.api.dao;

import in.targetpeak.api.entity.util.version.VersionListRequest;
import in.targetpeak.api.entity.util.version.VersionListResponse;

public interface UtilDao {

	public VersionListResponse getVersions(VersionListRequest request);
	
}
