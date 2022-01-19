package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoronavirusPage extends BasePage{

    @FindBy(xpath = "//div[@class='blue-tit__inner gel-wrap gs-u-box-size']//span[text()='Contact BBC News']")
    private WebElement contactBBCNewsButton;


    public CoronavirusPage(WebDriver driver) {
        super(driver);}

    public void clickOnContactBBCNewsButton() {contactBBCNewsButton.click();}


}
