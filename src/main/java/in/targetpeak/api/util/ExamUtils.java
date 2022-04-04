package in.targetpeak.api.util;

import java.text.DecimalFormat;

public class ExamUtils {

	
	public static String getPercentage(int obtainedMarks,int maxMarks) {
		if(obtainedMarks==0) {
			return "0";
		}else {
			DecimalFormat df = new DecimalFormat("##.##%");
			double percent = ((double)obtainedMarks /(double) maxMarks);
			String formattedPercent = df.format(percent);
			System.out.println(formattedPercent);
			return formattedPercent;
		}
		
	}
	
	
	public static String getResultStatus(int obtainedMarks,int maxMarks) {
		DecimalFormat df = new DecimalFormat("##.##%");
		double percent = ((double)obtainedMarks /(double) maxMarks);
		//System.out.println("percent:"+percent);
		if((percent*100)>35) {
			return "Pass";
		}
		return "ATKT";
	}
	
}
