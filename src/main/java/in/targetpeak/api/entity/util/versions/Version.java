package in.targetpeak.api.entity.util.versions;

public class Version {

	Integer id;
	String environment;

	public Version() {
		super();
	}

	public Version(Integer id, String environment) {
		super();
		this.id = id;
		this.environment = environment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	@Override
	public String toString() {
		return "Version [id=" + id + ", environment=" + environment + "]";
	}

}
