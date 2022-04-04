package in.targetpeak.api.entity.util.version;

public class VersionListRequest {

	Integer Action;
	String Environment;
	Integer Priority;

	public VersionListRequest() {
		super();
	}

	public VersionListRequest(Integer action, String environment, Integer priority) {
		super();
		Action = action;
		Environment = environment;
		Priority = priority;
	}

	public Integer getAction() {
		return Action;
	}

	public void setAction(Integer action) {
		Action = action;
	}

	public String getEnvironment() {
		return Environment;
	}

	public void setEnvironment(String environment) {
		Environment = environment;
	}

	public Integer getPriority() {
		return Priority;
	}

	public void setPriority(Integer priority) {
		Priority = priority;
	}

}
