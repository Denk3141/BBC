package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {this.driver = driver;}

    public ContactBBCNewsPage getContactBBCNewsPage() {return new ContactBBCNewsPage(driver);}

    public CoronavirusPage getCoronavirusPage() {return new CoronavirusPage(driver);}

    public HomePage getHomePage() {return new HomePage(driver);}

    public NewsPage getNewsPage() {return new NewsPage(driver);}

    public YourCoronavirusStoriesPage getYourCoronavirusStoriesPage() {return new YourCoronavirusStoriesPage(driver);}

}
