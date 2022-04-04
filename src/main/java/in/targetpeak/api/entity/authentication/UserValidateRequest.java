package in.targetpeak.api.entity.authentication;

public class UserValidateRequest {

	Integer Action;
	String MobileNo;
	String AppType;

	public UserValidateRequest(Integer action, String mobileNo, String appType) {
		super();
		Action = action;
		MobileNo = mobileNo;
		AppType = appType;
	}

	public Integer getAction() {
		return Action;
	}

	public void setAction(Integer action) {
		Action = action;
	}

	public String getMobileNo() {
		return MobileNo;
	}

	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}

	public String getAppType() {
		return AppType;
	}

	public void setAppType(String appType) {
		AppType = appType;
	}

}
