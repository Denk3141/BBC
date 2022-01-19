package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import static org.junit.Assert.assertTrue;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;

    WebDriver driver;
    ContactBBCNewsPage contactBBCNewsPage;
    CoronavirusPage coronavirusPage;
    HomePage homePage;
    NewsPage newsPage;
    YourCoronavirusStoriesPage yourCoronavirusStoriesPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);}

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User click on News button")
    public void userClickOnNewsButton() {
        homePage.clickOnNewsButton();
    }

    @And("User click on Coronavirus button")
    public void userClickOnCoronavirusButton() {
        newsPage = pageFactoryManager.getNewsPage();
        newsPage.clickOnCoronavirusButton();
    }

    @And("User click on contact BBC News button")
    public void userClickOnContactBBCNewsButton() {
        coronavirusPage = pageFactoryManager.getCoronavirusPage();
        coronavirusPage.clickOnContactBBCNewsButton();
    }

    @And("User click on send Us a story button")
    public void userClickOnSendUsAStoryButton() {
        contactBBCNewsPage = pageFactoryManager.getContactBBCNewsPage();
        contactBBCNewsPage.clickOnSendUsAStoryButton();
    }

    @And("User click on Submit")
    public void userClickOnSubmit() {
        yourCoronavirusStoriesPage = pageFactoryManager.getYourCoronavirusStoriesPage();
        yourCoronavirusStoriesPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, yourCoronavirusStoriesPage.isCloseRegisterVisible());
        yourCoronavirusStoriesPage.clickOnCloseRegister();
        yourCoronavirusStoriesPage.clickOnSubmit();
        yourCoronavirusStoriesPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, yourCoronavirusStoriesPage.isNameErrorVisibleWaiter());
    }

    @Then("User checks for an error message near the message text field")
    public void userChecksForAnErrorMessageNearTheMessageTextField() {
        assertTrue(yourCoronavirusStoriesPage.isNameErrorVisible());
    }

    @Then("User check for an error message next to the username input")
    public void userCheckForAnErrorMessageNextToTheUsernameInput() {
        assertTrue(yourCoronavirusStoriesPage.isNameErrorVisible());
    }

    @And("User typing {string} in email footer and click on Submit")
    public void userTypingMailInEmailFooterAndClickOnSubmit(final String mail) {
        yourCoronavirusStoriesPage = pageFactoryManager.getYourCoronavirusStoriesPage();
        yourCoronavirusStoriesPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, yourCoronavirusStoriesPage.isCloseRegisterVisible());
        yourCoronavirusStoriesPage.clickOnCloseRegister();
        yourCoronavirusStoriesPage.enterEmailAddress(mail);
        yourCoronavirusStoriesPage.clickOnSubmit();
        yourCoronavirusStoriesPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, yourCoronavirusStoriesPage.isNameErrorVisibleWaiter());
    }

    @Then("User check for an error message near the email field")
    public void userCheckForAnErrorMessageNearTheEmailField() {
        assertTrue(yourCoronavirusStoriesPage.isEmailErrorVisible());
    }

    @After
    public void tearDown() {
     driver.close();}

}
