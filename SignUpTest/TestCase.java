package SignUpTest;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;

import src.HomePage;
import src.LandingPage;
import src.LoginPage;
import src.SignUpPage;
import src.YahooPage;

/**
 * AppDirect Sign Up cases
 * @author Lenovo
 *
 */
public class TestCase {
	public static WebDriver wd = null;
	protected static String result;
	protected static HomePage homePage = new HomePage();
	protected static LoginPage loginPage = new LoginPage();
	protected static SignUpPage signUpPage = new SignUpPage();
	protected static LandingPage landingPage = new LandingPage();
	protected static YahooPage yahooPage = new YahooPage();
	public static String generatedString = null;

	@BeforeTest
	@Parameters("browser")
	public static void setup(String browser) throws Exception {
		//Check if parameter passed from TestNG is 'firefox'		 
        if(browser.equalsIgnoreCase("firefox")){ 
        //create firefox instance
            wd = new FirefoxDriver();
 
        } 
        //Check if parameter passed as 'chrome' 
        else if(browser.equalsIgnoreCase("chrome")){ 
            //set path to chromedriver.exe 
            System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe"); 
            //create chrome instance 
            wd = new ChromeDriver(); 
        } 
        else if(browser.equalsIgnoreCase("ie")){
 
            //set path to IEdriver.exe 
            System.setProperty("webdriver.ie.driver","C:\\IEdriver.exe"); 
            //create ie instance 
            wd = new InternetExplorerDriver();
        }
        else{ 
            //If no browser passed throw exception 
            throw new Exception("Browser is not correct");
        }
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@BeforeMethod
	public static void setupBeforeEveryTest() throws Exception {
		generatedString = RandomStringUtils.randomAlphanumeric(10);
		signUpPage.launchSignUpPage(wd);
	}

	/**
	 * 
	 * Test case to verify successful sign up
	 */
	@Test(groups = {"P1"})
	public void successfulSignUpTest() throws Exception {
		signUpPage.completeSignUp(generatedString+"@def.com", wd);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(
				landingPage
						.getDisplayedMessageText(wd)
						.contains(
								"We have sent a verification email to "
										+ generatedString
										+ "@def.com. Please check your inbox and click the link to activate your account."),
				"Sign Up was not successful");
	}

	/**
	 * 
	 * Test case to verify Yahoo sign up
	 */
	@Test(groups = {"P1"})
	public void yahooSignUpTest() throws Exception {
		signUpPage.clickOnYahooSignUp(wd);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(
				yahooPage.getDisplayedMessageText(wd).contains(
						"Sign in to www.appdirect.com"),
				"Yahoo Sign Up page is not displayed");
		Assert.assertTrue(
				yahooPage.getDisplayedMessageText(wd).contains(
						"with your Yahoo ID"),
				"Yahoo Sign Up page is not displayed");
	}
	
	/**
	 * 
	 * Test case to verify Google sign up
	 */
	@Test(groups = {"P1"})
	public void googleSignUpTest() throws Exception {
		signUpPage.clickOnGoogleSignUp(wd);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(
				yahooPage.getDisplayedMessageText(wd).contains(
						"Sign in to www.appdirect.com"),
				"Google Sign Up page is not displayed");
		Assert.assertTrue(
				yahooPage.getDisplayedMessageText(wd).contains(
						"with your Google ID"),
				"Google Sign Up page is not displayed");
	}
	
	/**
	 * This test case is to validate success message on using 
	 * invalid email address to sign up
	 * 
	 * For testing purpose I am generating random string for email id
	 * So this test case essentially repeats successful login test
	 * @throws Exception
	 */
	@Test(groups = {"P2"})
	public void invalidEmailSignUpTest() throws Exception {
		signUpPage.completeSignUp(generatedString+"@def.com", wd);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(
				landingPage
						.getDisplayedMessageText(wd)
						.contains(
								"We have sent a verification email to "
										+ generatedString
										+ "@def.com. Please check your inbox and click the link to activate your account."),
				"Invalid email id sign up was not successful");
	}
	
	/**
	 * Test case to verify footer link
	 * @throws Exception
	 */
	@Test(groups = {"P2"})
	public void footerLinkTest() throws Exception {
		Assert.assertTrue(
				signUpPage
						.helpCentreLinkText(wd).
						contains(
								"Help Center"),
				"Help Centre Link was not present");
		Assert.assertTrue(
				signUpPage
						.privacyPolicyLinkText(wd).
						contains(
								"Privacy Policy"),
				"Privacy Policy Link was not present");
		Assert.assertTrue(
				signUpPage
						.termsAndConditionText(wd).
						contains(
								"Terms and Conditions"),
				"Terms and condition Link was not present");
		Assert.assertTrue(
				signUpPage
						.contactLinkText(wd).
						contains(
								"Contact"),
				"Contact Link was not present");
	}
	
	/**
	 * Test case to verify message with incorrect email format
	 * @throws Exception
	 */
	@Test(groups = {"P2"})
	public void incorrectFormatSignUpTest() throws Exception {
		signUpPage.completeSignUp("abcd", wd);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(
				wd.getPageSource().contains(
								"Please enter an email address"),
				"Error message on entering incorrect format is not displayed");
	}
	
	/**
	 * Test case to verify message when already registered email address is used
	 * 
	 * @throws Exception
	 */
	@Test(groups = {"P2"})
	public void alreadyRegisteredEmailIdSignUpTest() throws Exception {
		signUpPage.completeSignUp(generatedString+"@def.com", wd);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(
				landingPage
						.getDisplayedMessageText(wd)
						.contains(
								"We have sent a verification email to "
										+ generatedString
										+ "@def.com. Please check your inbox and click the link to activate your account."),
				"Sign Up was not successful");
		signUpPage.launchSignUpPage(wd);
		signUpPage.completeSignUp(generatedString+"@def.com", wd);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(
				wd.getPageSource().contains(
								"This email address has already been registered in our system. Please register with a new email address"),
				"Error message on entering same email address is not displayed");
	}
	
	/**
	 * Assumption - The gmail account used in this test exists and the password is "test"
	 * @throws Exception
	 */
	@Test(groups = {"P3"})
	public void alreadyRegisteredGoogleEmailIdSignUpTest() throws Exception {
		signUpPage.completeSignUp(generatedString+"@gmail.com", wd);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(
				landingPage
						.getDisplayedMessageText(wd)
						.contains(
								"We have sent a verification email to "
										+ generatedString
										+ "@gmail.com. Please check your inbox and click the link to activate your account."),
				"Sign Up was not successful");
		signUpPage.launchSignUpPage(wd);
		signUpPage.clickOnGoogleSignUp(wd);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.findElement(By.id("login-username")).sendKeys(generatedString+"@gmail.com");
		wd.findElement(By.id("login-passwd")).sendKeys("test");
		wd.findElement(By.id("login-signin")).click();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(
				wd.getPageSource().contains(
								"This email address has already been registered in our system. Please register with a new email address"),
				"Error message on entering same email address is not displayed");
	}
	
	/**
	 * Assumption - The yahoo account used in this test exists and the password is "test"
	 * @throws Exception
	 */
	@Test(groups = {"P3"})
	public void alreadyRegisteredYahooEmailIdSignUpTest() throws Exception {
		signUpPage.completeSignUp(generatedString+"@yahoo.com", wd);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(
				landingPage
						.getDisplayedMessageText(wd)
						.contains(
								"We have sent a verification email to "
										+ generatedString
										+ "@yahoo.com. Please check your inbox and click the link to activate your account."),
				"Sign Up was not successful");
		signUpPage.launchSignUpPage(wd);
		signUpPage.clickOnYahooSignUp(wd);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.findElement(By.id("login-username")).sendKeys(generatedString+"@yahoo.com");
		wd.findElement(By.id("login-passwd")).sendKeys("test");
		wd.findElement(By.id("login-signin")).click();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(
				wd.getPageSource().contains(
								"This email address has already been registered in our system. Please register with a new email address"),
				"Error message on entering same email address is not displayed");
	}
	
	/**
	 * Assumption - The yahoo account used in this test exists and the password is "test"
	 * @throws Exception
	 */
	@Test(groups = {"P3"})
	public void alreadyRegisteredThroughYahooEmailSignUpTest() throws Exception {
		signUpPage.clickOnYahooSignUp(wd);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.findElement(By.id("login-username")).sendKeys(generatedString+"@yahoo.com");
		wd.findElement(By.id("login-passwd")).sendKeys("test");
		wd.findElement(By.id("login-signin")).click();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		signUpPage.launchSignUpPage(wd);
		signUpPage.completeSignUp(generatedString+"@yahoo.com", wd);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Assert.assertTrue(
				wd.getPageSource().contains(
								"This email address has already been registered in our system. Please register with a new email address"),
				"Error message on entering same email address is not displayed");
	}
	
	/**
	 * Test case to verify message with blank email address
	 * @throws Exception
	 */
	@Test(groups = {"P3"})
	public void blankEmailSignUpTest() throws Exception {
		signUpPage.completeSignUp(" ", wd);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(
				wd.getPageSource().contains(
								"Please enter an email address"),
				"Error message on entering blank email address is not displayed");
	}
	
	/**
	 * Test case to verify max characters in email address field
	 * @throws Exception
	 */
	@Test(groups = {"P2"})
	public void maxCharEmailIdSignUpTest() throws Exception {
		generatedString = RandomStringUtils.randomAlphanumeric(248);
		signUpPage.completeSignUp(generatedString+"@def.com", wd);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(
				landingPage
						.getDisplayedMessageText(wd)
						.contains(
								"We have sent a verification email to "
										+ generatedString
										+ "@def.com. Please check your inbox and click the link to activate your account."),
				"Sign Up was not successful");
		
		generatedString = RandomStringUtils.randomAlphanumeric(249);
		signUpPage.launchSignUpPage(wd);		
		signUpPage.completeSignUp(generatedString+"@def.com", wd);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(
				wd.getPageSource().contains(
								"Please enter an email address"),
				"Error message on entering blank email address is not displayed");
	}
	
	/**
	 * Test case to verify footer link navigation
	 * @throws Exception
	 */
	@Test(groups = {"P2"})
	public void footerLinkNavigationTest() throws Exception {
		signUpPage.clickHelpCentreLink(wd);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(
				wd.getPageSource().contains(
								"Help Center Page"),
				"Help Centre Page is not displayed");
		signUpPage.launchSignUpPage(wd);	
		signUpPage.clickPrivacyPolicyLink(wd);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(
				wd.getPageSource().contains(
								"Privacy Policy"),
				"Privacy Policy Page is not displayed");
		signUpPage.launchSignUpPage(wd);	
		signUpPage.clickTermsAndCondition(wd);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(
				wd.getPageSource().contains(
								"Terms and Conditions"),
				"Terms and condition Page is not displayed");
		signUpPage.launchSignUpPage(wd);
		signUpPage.clickContactLink(wd);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(
				wd.getPageSource().contains(
								"Contact"),
				"Contact Page is not displayed");
	}
	@AfterClass
	public static void teardown() {
		wd.close();
		wd.quit();

	}

}
