package Login;

import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CalMethod {
	
	SimpleDateFormat sdf = new SimpleDateFormat();
	Calendar cal;
	
	public int getBookedDate(String startDate, String endDate) {
		double days = 0;
		
		cal = Calendar.getInstance();
		String strD = startDate;
		String endD = endDate;
		
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date sDate = null;
		Date eDate = null;
		
		try {
			sDate = sdf.parse(strD);
			eDate = sdf.parse(endD);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		days = (eDate.getTime() - sDate.getTime()) / ( 24 * 60 * 60 *1000);
		
		return (int) days;
	}
	public Date StringToDate(String inputdate) {
		
		
		cal = Calendar.getInstance();
		String strD = inputdate;
		
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = null;
		
		try {
			date = sdf.parse(strD);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}

}
