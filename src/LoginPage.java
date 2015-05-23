package src;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Purpose of this class is to declare all of the element locator in login page
 * Along with common methods in login page
 * 
 * @author Lenovo
 *
 */
public class LoginPage {
       String signUpLink = "Sign Up";
//       protected static WebDriverWait waiting = new WebDriverWait(wd, 10);
       
       public LoginPage() {
      		super();
      		// TODO Auto-generated constructor stub
      	}

       public String getSignUpLink() {
		return signUpLink;
	}

	public void setSignUpLink(String signUpLink) {
		this.signUpLink = signUpLink;
	}

	public void waitForSignUpLinkVisible(WebDriver wd){
		WebDriverWait waiting = new WebDriverWait(wd, 10);
		waiting.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(signUpLink)));
	 }
	
	public void clickOnSignUp(WebDriver wd) throws Exception{
		wd.findElement(By.linkText(signUpLink)).click();
	}
}
