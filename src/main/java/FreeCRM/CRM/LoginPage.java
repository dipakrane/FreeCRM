package FreeCRM.CRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase;

public class LoginPage extends TestBase {

	//Page Factory or Object repository
		@FindBy(name="username")
		WebElement username;
		@FindBy(name="password")
		WebElement password;
		@FindBy(xpath="//input[@type=\"submit\"]")
		WebElement loginbutton;
		@FindBy(xpath="//button[contains(text(),'Sign Up')]")
		WebElement signupbutton;
		@FindBy(xpath="//img[contains(@class,\"img-responsive\")]")
		WebElement crmlogo;	
		//Initializing Page Objects
		public LoginPage()
		{
			//use this or Loginpage.class
			PageFactory.initElements(driver, this);
		}
		//Defining page methods
		public String verifyPageTitle()
		{
			return(driver.getTitle());
		}
		public boolean validateCrmImage()
		{
			return crmlogo.isDisplayed();
		}
		public String login(String un, String pwd) throws InterruptedException
		{
			username.sendKeys(un);
			password.sendKeys(pwd);
			Thread.sleep(2000);
			loginbutton.click();
			String Title=driver.getTitle();
			return Title;
		}
		
}
