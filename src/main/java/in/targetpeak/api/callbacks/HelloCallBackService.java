package in.targetpeak.api.callbacks;

public class HelloCallBackService {

	private static final String TAG = HelloCallBackService.class.getSimpleName();

	private static HelloCallBackService instance;

	public static HelloCallBackService getInstance() {
		if (instance == null) {
			System.out.println("New Instance...");
			instance = new HelloCallBackService();
		}
		System.out.println("Old Instance...");
		return instance;
	}

	public void FetchCallaback(int actionId, final HelloCallBack helloCallBack) {
		if (actionId == 1) {
			helloCallBack.onSuccess("Success Message");
		} else if (actionId == 2) {
			helloCallBack.onError("Error Message");
		}
	}

}
