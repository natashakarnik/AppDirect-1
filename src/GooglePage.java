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
public class GooglePage {

	String messageText = "mbr-login-contents-openid";
	/**
	 * 
	 */
	public GooglePage() {
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
	 * Method to get Message Text displayed on Google Sign Up Page
	 * 
	 */
	public String getDisplayedMessageText(WebDriver wd){
		return wd.findElement(By.id(messageText)).getText();
		
	}

}
