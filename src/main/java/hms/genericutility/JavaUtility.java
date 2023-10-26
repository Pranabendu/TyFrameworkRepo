package hms.genericutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	Random random = new Random();
	Date dateObj = new Date();
	SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * generate random number with in the limit of 4000 for very invocation
	 * 
	 * @return
	 */
	public int getRandomNumber() {
		int randomInt = random.nextInt(4000);
		return randomInt;
	}
	
	public String getRandomMobileNumber() {
		
		String[] ran= new String[10];
		for (int i = 0; i < 10; i++) {
			int m = random.nextInt(10);
			ran[i] = Integer.toString(m);
		}
		String mobileNo = "";
		for(String n:ran) {
			mobileNo = mobileNo+n;
		}
		return mobileNo;
	}
	
	
	/**
	 * used to get the system current date in "yyyy-MM-dd " format
	 * 
	 * @return
	 */
	public String getDate() {

		String date = sim.format(dateObj);
		return date;
	}
	
	/**
	 * used to get the system current date in "yyyy-MM-dd " format
	 * 
	 * @return
	 */
	public String getDateWithTime() {
		String dateWithTime=dateObj.toString().replace(" ", "").replace(":", "-");
		return dateWithTime;
	}

	/**
	 * used to get the required date in "yyyy-MM-dd " 
	 * format requiredDateCount is positive number , it provides upcoming date based numeric count
	 * if requiredDateCount is negative number , it provides previous date based numeric count
	 * 
	 * @param requiredDateCount
	 */
	public String getDate(int requiredDateCount) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, requiredDateCount);
		Date date = cal.getTime();
		String rdata = sim.format(date);
		return rdata;
	}
}