package FreeCRM.CRM;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import TestBase.TestBase;
public class LoginPageTest  extends TestBase{
	LoginPage loginpage;
	public LoginPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		TestBase.initialization();
		loginpage=new LoginPage();
	}
	@Test(priority=1)
	public void LoginPageTitleTest()
	{
		String title=loginpage.verifyPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	@Test(priority=3)
	public void validateCrmImageTest()
	{
		boolean flag=loginpage.validateCrmImage();
		Assert.assertTrue(flag);
	}
	@Test(priority=2)
	public void loginTest() throws InterruptedException
	{
		String Title=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(Title, "CRMPRO");
	}
	@AfterMethod
	public void tearDown()
	{
			driver.quit();
	
	}	
}
