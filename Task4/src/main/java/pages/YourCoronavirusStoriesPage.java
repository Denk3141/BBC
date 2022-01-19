package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourCoronavirusStoriesPage extends BasePage{


    @FindBy(xpath = "//input[@placeholder='Email address']")
    private WebElement emailAddress;

    @FindBy(xpath = "//button[@class='button']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='text-input']//div[@class='input-error-message']")
    private WebElement nameError;

    @FindBy(xpath = "//div[@class='long-text-input-container']//div[@class='input-error-message']")
    private WebElement storyError;

    @FindBy(xpath = "//div[text()='Email address is invalid']")
    private WebElement emailError;

    @FindBy(xpath = "//button[@aria-label='Close']")
    private WebElement closeRegister;



    public YourCoronavirusStoriesPage(WebDriver driver) {
        super(driver);}

    public void enterEmailAddress(final String enterEmail) {emailAddress.sendKeys(enterEmail);}

    public void clickOnSubmit() {submitButton.click();}

    public boolean isNameErrorVisible() {return nameError.isDisplayed();}

    public boolean isStoryErrorVisible() {return storyError.isDisplayed();}

    public boolean isEmailErrorVisible() {return emailError.isDisplayed();}

    public void clickOnCloseRegister() {closeRegister.click();}

    public WebElement isCloseRegisterVisible() {return closeRegister;}

    public WebElement isNameErrorVisibleWaiter() {return nameError;}

}
