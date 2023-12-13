package practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utilities.Excel_Utilities;

public class DataProviderEx3 {
	
	@Test(dataProvider="getData")
	public void bookTickets(String src,String dest)
	{
	
		System.out.println("book tickets from"+src+"to "+dest);
	}

@DataProvider
	public Object[][] getData() throws Throwable
	{
	Excel_Utilities elib=new Excel_Utilities();
	Object[][] value = elib.readMultipleData("Sheet1");
	
		return value;
		
	
}

}
