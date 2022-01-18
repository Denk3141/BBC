package pagefactory.tests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class StoryFormTest extends BaseTest{



    @Test
    public void checkStoriesErrorMassage() {
        getHomePage().clickOnNewsButton();
        getNewsPage().clickOnCoronavirusButton();
        getCoronavirusPage().clickOnContactBBCNewsButton();
        getContactBBCNewsPage().clickOnSendUsAStoryButton();
        getYourCoronavirusStoriesPage().waitVisibilityOfElement(10, getYourCoronavirusStoriesPage().isCloseRegisterVisible());
        getYourCoronavirusStoriesPage().clickOnCloseRegister();
        getYourCoronavirusStoriesPage().clickOnSubmit();
        getYourCoronavirusStoriesPage().waitForPageLoadComplete(10);
        getYourCoronavirusStoriesPage().waitVisibilityOfElement(10, getYourCoronavirusStoriesPage().isNameErrorVisibleWaiter());
        assertTrue(getYourCoronavirusStoriesPage().isStoryErrorVisible());
    }

    @Test
    public void checkNameErrorMassage() {
        getHomePage().clickOnNewsButton();
        getNewsPage().clickOnCoronavirusButton();
        getCoronavirusPage().clickOnContactBBCNewsButton();
        getContactBBCNewsPage().clickOnSendUsAStoryButton();
        getYourCoronavirusStoriesPage().waitVisibilityOfElement(10, getYourCoronavirusStoriesPage().isCloseRegisterVisible());
        getYourCoronavirusStoriesPage().clickOnCloseRegister();
        getYourCoronavirusStoriesPage().clickOnSubmit();
        getYourCoronavirusStoriesPage().waitForPageLoadComplete(10);
        getYourCoronavirusStoriesPage().waitVisibilityOfElement(10, getYourCoronavirusStoriesPage().isNameErrorVisibleWaiter());
        assertTrue(getYourCoronavirusStoriesPage().isNameErrorVisible());
    }

    @Test
    public void checkEmailErrorMassage() {
        getHomePage().clickOnNewsButton();
        getNewsPage().clickOnCoronavirusButton();
        getCoronavirusPage().clickOnContactBBCNewsButton();
        getContactBBCNewsPage().clickOnSendUsAStoryButton();
        getYourCoronavirusStoriesPage().waitVisibilityOfElement(10, getYourCoronavirusStoriesPage().isCloseRegisterVisible());
        getYourCoronavirusStoriesPage().clickOnCloseRegister();
        getYourCoronavirusStoriesPage().enterEmailAddress("mail");
        getYourCoronavirusStoriesPage().clickOnSubmit();
        getYourCoronavirusStoriesPage().waitForPageLoadComplete(10);
        getYourCoronavirusStoriesPage().waitVisibilityOfElement(10, getYourCoronavirusStoriesPage().isNameErrorVisibleWaiter());
        assertTrue(getYourCoronavirusStoriesPage().isEmailErrorVisible());
    }
}
