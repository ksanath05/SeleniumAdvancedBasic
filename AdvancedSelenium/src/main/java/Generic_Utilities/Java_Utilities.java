package Generic_Utilities;

import java.util.Random;

public class Java_Utilities {
	
	/**
	 * This method is used to generate random numbers to avoid duplicates
	 * 
	 * 
	 * @author Sanath
	*/
	
	public int getRandomNum() {
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		return ranNum;
	}

}
