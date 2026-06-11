package genericUtility;

import java.util.Date;
import java.util.Random;

/**
 * this class consist of methods related to java
 */
public class JavaUtility {

	/**
	 * this method is used to generate random numbers
	 * 
	 * @return
	 */
	public int toGenerateRandomNumber() {
		Random r = new Random();
		int value = r.nextInt(1000);
		return value;

	}

	public String toGenerateSystemDateAndTimeInformat() {

		Date d = new Date();
		String date[] = d.toString().split(" ");
		String day = date[0];
		String month = date[1];
		String date1 = date[2];
		String time = date[3].replace(":", "-");
		String year = date[5];

		String finalDate = day + " " + month + " " + date1 + " " + time + " " + year;

		return finalDate;

	}

}
