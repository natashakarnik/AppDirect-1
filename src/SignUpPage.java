/**
 * 
 */
package src;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Lenovo
 *
 */
public class SignUpPage {
	
	String emailAddressText = "emailAddress";
	String signUpButton = "userSignupButton";
	String baseUrl = "http://www.appdirect.com";
	String yahooSignUpLink = "yahooRegisterButton";
	String googleSignUpLink = "googleRegisterButton";
	String helpCenterLink = "Help Center";
	String privacyPolicyLink = "Privacy Policy";
	String termsAndCondition = "Terms and Conditions";
	String contact = "Contact";
	protected static WebDriverWait waiting = null;
	protected static HomePage homePage = new HomePage();
    protected static LoginPage loginPage = new LoginPage();
	
	/**
	 * Constructor
	 */
	public SignUpPage() {
   		super();
   		// TODO Auto-generated constructor stub
   	}

	/**
	 * @return the emailAddressText
	 */
	public String getEmailAddressText() {
		return emailAddressText;
	}

	/**
	 * @param emailAddressText the emailAddressText to set
	 */
	public void setEmailAddressText(String emailAddressText) {
		this.emailAddressText = emailAddressText;
	}

	/**
	 * @return the signUpButton
	 */
	public String getSignUpButton() {
		return signUpButton;
	}

	/**
	 * @param signUpButton the signUpButton to set
	 */
	public void setSignUpButton(String signUpButton) {
		this.signUpButton = signUpButton;
	}
	
	/**
	 * @return the yahooSignUpLink
	 */
	public String getYahooSignUpLink() {
		return yahooSignUpLink;
	}

	/**
	 * @param yahooSignUpLink the yahooSignUpLink to set
	 */
	public void setYahooSignUpLink(String yahooSignUpLink) {
		this.yahooSignUpLink = yahooSignUpLink;
	}
	
	/**
	 * @return the googleSignUpLink
	 */
	public String getGoogleSignUpLink() {
		return googleSignUpLink;
	}

	/**
	 * @param googleSignUpLink the googleSignUpLink to set
	 */
	public void setGoogleSignUpLink(String googleSignUpLink) {
		this.googleSignUpLink = googleSignUpLink;
	}
	
	/**
	 * @return the helpCenterLink
	 */
	public String getHelpCenterLink() {
		return helpCenterLink;
	}

	/**
	 * @param helpCenterLink the helpCenterLink to set
	 */
	public void setHelpCenterLink(String helpCenterLink) {
		this.helpCenterLink = helpCenterLink;
	}

	/**
	 * @return the privacyPolicyLink
	 */
	public String getPrivacyPolicyLink() {
		return privacyPolicyLink;
	}

	/**
	 * @param privacyPolicyLink the privacyPolicyLink to set
	 */
	public void setPrivacyPolicyLink(String privacyPolicyLink) {
		this.privacyPolicyLink = privacyPolicyLink;
	}

	/**
	 * @return the termsAndCondition
	 */
	public String getTermsAndCondition() {
		return termsAndCondition;
	}

	/**
	 * @param termsAndCondition the termsAndCondition to set
	 */
	public void setTermsAndCondition(String termsAndCondition) {
		this.termsAndCondition = termsAndCondition;
	}

	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * Method to wait for the visibility of Email Address field
	 * 
	 */
	public void waitForEmailAddressFieldVisible(WebDriver wd){
		WebDriverWait waiting = new WebDriverWait(wd, 10);
		waiting.until(ExpectedConditions.visibilityOfElementLocated(By.name(emailAddressText)));
	 }
	
	public void launchSignUpPage(WebDriver wd)
			throws Exception {
		wd.get(baseUrl);
		homePage.clickOnLogin(wd);
		loginPage.waitForSignUpLinkVisible(wd);
		loginPage.clickOnSignUp(wd);
		waitForEmailAddressFieldVisible(wd);
	}

	/**
	 * 
	 * @param emailAddress= email address to be used for sign up
	 * @throws Exception 
	 */
	public void completeSignUp(String emailAddress, WebDriver wd) throws Exception{	
		 wd.findElement(By.name(emailAddressText)).sendKeys(emailAddress);
		 wd.findElement(By.name(signUpButton)).click();		 
	}
	
	/**
	 * Method to click on Yahoo Sign Up link
	 * @param wd
	 * @throws Exception
	 */
	public void clickOnYahooSignUp(WebDriver wd) throws Exception{	
		 wd.findElement(By.id(yahooSignUpLink)).click();		 
	}
	 

	/**
	 * Method to click on Google Sign Up link
	 * @param wd
	 * @throws Exception
	 */
	public void clickOnGoogleSignUp(WebDriver wd) throws Exception{	
		 wd.findElement(By.id(googleSignUpLink)).click();		 
	}
	
	public String helpCentreLinkText(WebDriver wd) throws Exception{
		return wd.findElement(By.linkText(helpCenterLink)).getText();
	}
	
	public String privacyPolicyLinkText(WebDriver wd) throws Exception{
		return wd.findElement(By.linkText(privacyPolicyLink)).getText();
	}
	
	public String termsAndConditionText(WebDriver wd) throws Exception{
		return wd.findElement(By.linkText(termsAndCondition)).getText();
	}
	
	public String contactLinkText(WebDriver wd) throws Exception{
		return wd.findElement(By.linkText(contact)).getText();
	}
	
	public void clickHelpCentreLink(WebDriver wd) throws Exception{
		 wd.findElement(By.linkText(helpCenterLink)).click();
	}
	
	public void clickPrivacyPolicyLink(WebDriver wd) throws Exception{
		 wd.findElement(By.linkText(privacyPolicyLink)).click();
	}
	
	public void clickTermsAndCondition(WebDriver wd) throws Exception{
		 wd.findElement(By.linkText(termsAndCondition)).click();
	}
	
	public void clickContactLink(WebDriver wd) throws Exception{
		 wd.findElement(By.linkText(contact)).getText();
	}
}
