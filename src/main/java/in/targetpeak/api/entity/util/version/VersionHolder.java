package in.targetpeak.api.entity.util.version;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VersionHolder {

	@Id
	Integer AppVersionId;
	String Environment;
	String VersionNo;
	String Description;
	Integer Priority;
	String Created;

	public VersionHolder() {
		super();
	}

	public Integer getAppVersionId() {
		return AppVersionId;
	}

	public void setAppVersionId(Integer appVersionId) {
		AppVersionId = appVersionId;
	}

	public String getEnvironment() {
		return Environment;
	}

	public void setEnvironment(String environment) {
		Environment = environment;
	}

	public String getVersionNo() {
		return VersionNo;
	}

	public void setVersionNo(String versionNo) {
		VersionNo = versionNo;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Integer getPriority() {
		return Priority;
	}

	public void setPriority(Integer priority) {
		Priority = priority;
	}

	public String getCreated() {
		return Created;
	}

	public void setCreated(String created) {
		Created = created;
	}

	@Override
	public String toString() {
		return "VersionHolder [AppVersionId=" + AppVersionId + ", Environment=" + Environment + ", VersionNo="
				+ VersionNo + ", Description=" + Description + ", Priority=" + Priority + ", Created=" + Created + "]";
	}

}
