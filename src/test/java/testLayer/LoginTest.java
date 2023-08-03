package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseHRMClass;
import pomPackage.PomLogin;
import testData.ExcelSheet;

public class LoginTest extends BaseHRMClass{
	
	PomLogin Log;
	
	public LoginTest() {
		
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
		
		initiate();
		screenshots("Login");
		Log = new PomLogin();
	}
	
	@Test
	public void Title() {
		
		String actual = Log.verify();
		System.out.println(actual);
		Assert.assertEquals(actual, "OrangeHRM");
		
	}
	
	@DataProvider
	public Object[][] Details(){
		
		Object Result[][] = ExcelSheet.readdata("Sheet1");
		return Result;
		
	}
	
	@Test(dataProvider="Details")
	public void Login(String name, String password) {
		
		Log.typeusername(name);
		Log.typepassword(password);
		//Log.clickloginbutton();
	}
	
	@AfterMethod
	public void close() {
		
		driver.close();
	}

}
