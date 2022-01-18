package pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsPage extends BasePage{


    @FindBy(xpath = "//span[text()='Coronavirus'][1]")
    private WebElement coronavirusButton;


    public NewsPage(WebDriver driver) {
        super(driver);}

    public void clickOnCoronavirusButton() {coronavirusButton.click();}







}
