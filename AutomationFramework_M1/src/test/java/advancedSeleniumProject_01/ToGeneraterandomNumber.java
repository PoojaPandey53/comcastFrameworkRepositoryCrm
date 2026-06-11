package advancedSeleniumProject_01;

import java.util.Random;

public class ToGeneraterandomNumber {
	
	
	public static void main(String[] args) {
		
		//generate random number 
		Random r = new Random();
	     int value = r.nextInt(1000);
		System.out.println(value);
		
	}
	
	
}
