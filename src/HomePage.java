/**
 * 
 */
package src;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Purpose of this class is to declare all of the element locator in home page
 * Along with common methods in home page
 * 
 * @author Lenovo
 *
 */
public class HomePage {
	
	String loginLink = "Login";
//	protected static WebDriver wd = new FirefoxDriver();

	public HomePage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLoginLink() {
		return loginLink;
	}

	public void setLoginLink(String loginLink) {
		this.loginLink = loginLink;
	}
	
	public void clickOnLogin(WebDriver wd) throws Exception{
		wd.findElement(By.linkText(loginLink)).click();
	}

}
