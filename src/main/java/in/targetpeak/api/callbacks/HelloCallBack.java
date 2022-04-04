package in.targetpeak.api.callbacks;

public interface HelloCallBack {

	public void onSuccess(String successMessage);

	public void onError(String errorMessage);

	public void onUnknownError();

}
