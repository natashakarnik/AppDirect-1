/**
 * 
 */
package src;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Lenovo
 *
 */
public class LandingPage {

	String messageText = "#idc > div";
	
	/**
	 * Constructor
	 */
	public LandingPage() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the messageText
	 */
	public String getMessageText() {
		return messageText;
	}
	/**
	 * @param messageText the messageText to set
	 */
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	
	/**
	 * Method to get Message Text displayed on Landing Page
	 * 
	 */
	public String getDisplayedMessageText(WebDriver wd){
		return wd.findElement(By.cssSelector(messageText)).getText();
	}

	
}
