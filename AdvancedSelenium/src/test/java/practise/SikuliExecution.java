package practise;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliExecution {

	public static void main(String[] args) throws Throwable {
		
		Screen scr = new Screen();
		Pattern pattern = new Pattern("C:\\Our Folder\\AdvSeleniumSK\\Sikuli\\Minimize.png");
		scr.click(pattern);
		
		Pattern pattern1 = new Pattern("C:\\Our Folder\\AdvSeleniumSK\\Sikuli\\Searchbar.png");
		scr.click(pattern1);
		scr.type("Paint");
		
		/*Pattern google = new Pattern("C:\\Our Folder\\AdvSeleniumSK\\Sikuli\\google.png");
		scr.click(google);
		
		Pattern more = new Pattern("C:\\Our Folder\\AdvSeleniumSK\\Sikuli\\more.png");
		scr.click(more);
		
		Pattern yt = new Pattern("C:\\Our Folder\\AdvSeleniumSK\\Sikuli\\youtube.PNG");
		scr.click(yt);*/

	}

}
