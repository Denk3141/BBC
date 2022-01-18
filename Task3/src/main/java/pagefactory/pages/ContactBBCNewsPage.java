package pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactBBCNewsPage extends BasePage{


    @FindBy(xpath = "//a[text()='send us a story']")
    private WebElement sendUsAStoryButton;


    public ContactBBCNewsPage(WebDriver driver) {
        super(driver);}

    public void clickOnSendUsAStoryButton() {sendUsAStoryButton.click();}

}
