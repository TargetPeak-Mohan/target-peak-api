package in.targetpeak.api.util;

public class ResponseMessageUtility {


	public static void showMessage(String TAG, String msg) {
		System.out.println(TAG + ":" + msg);
	}
	
	public static void showErrorMessage(String TAG, Exception exp) {
		System.err.println(TAG + ":" + exp);
	}

}
