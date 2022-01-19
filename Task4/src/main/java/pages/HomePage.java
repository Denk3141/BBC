package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    @FindBy(xpath = "//div[@class='orb-nav-section orb-nav-links orb-nav-focus']//li[@class='orb-nav-newsdotcom']")
    private WebElement newsButton;

    public HomePage(WebDriver driver) {super(driver);}


    public void clickOnNewsButton() {newsButton.click();}

    public void openHomePage(String url) {
        driver.get(url);
    }

}
