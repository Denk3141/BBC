package BBC;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
public class BBCTests {

    private WebDriver driver;

    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();//создаем экзаемпляр хром драйвера
        driver.manage().window().maximize();//открыли браузер на весь экран
        driver.get("https://www.bbc.com/");//открыли сайт
    }

    @Test(priority = 2)
    public void CheckingNewsTitle() {
        driver.findElement(By.xpath("(//a[@href='https://www.bbc.com/news'])[1]")).click();
        assertTrue(driver.getPageSource().contains("UK health secretary pressed over Covid measures"));
    }

    @Test(priority = 2)
    public void CheckingNewsTitle_01() {
        driver.findElement(By.xpath("(//a[@href='https://www.bbc.com/news'])[1]")).click();
        assertTrue(driver.getPageSource().contains("Dutch enter tight lockdown over Omicron wave"));
    }

    @Test(priority = 1)
    public void ComparisonWithSearch() {
        driver.findElement(By.xpath("(//a[@href='https://www.bbc.com/news'])[1]")).click();
        driver.findElement(By.xpath("//div[@data-entityid='container-top-stories#5']")).click();
        driver.findElement(By.xpath("//button[@class='tp-close tp-active']")).click();
        driver.findElement(By.xpath("//span[@class='ssrcss-1tmabzc-IconWrapper eki2hvo6']")).click();
        driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys("Covid: French ski season in disarray as UK tourists banned");
        driver.findElement(By.xpath("//span[@data-testid='actions:search']")).click();
        driver.findElement(By.xpath("//div[@class='ssrcss-dirbxo-PromoSwitchLayoutAtBreakpoints e3z3r3u0'][1]")).click();
        assertTrue(driver.getCurrentUrl().contains("https://www.bbc.com/news/world-europe-59712015"));
    }

    @Test (priority = 2)
    public void SendUsAStoryWrongMail() {
        driver.findElement(By.xpath("//div[@class='orb-nav-section orb-nav-links orb-nav-focus']//li[@class='orb-nav-newsdotcom']")).click();
        driver.findElement(By.xpath("//span[text()='Coronavirus'][1]")).click();
        driver.findElement(By.xpath("//div[@class='blue-tit__inner gel-wrap gs-u-box-size']//span[text()='Contact BBC News']")).click();
        driver.findElement(By.xpath("//a[text()='send us a story']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//ожидание 5 сек
        driver.findElement(By.xpath("//button[@class='tp-close tp-active']")).click();//капча регистрации
        driver.findElement(By.xpath("//textarea[@placeholder='Tell us your story. ']")).sendKeys("text");
        driver.findElement(By.xpath("//input[@placeholder='Email address']")).sendKeys("mail");
        driver.findElement(By.xpath("//button[@class='button']")).click();//submit
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//неявное ожидание 10 сек
        assertTrue(driver.findElement(By.xpath("//div[text()='Email address is invalid']")).isDisplayed());
    }

    @Test (priority = 2)
    public void SendUsAStoryWrongName() {
        driver.findElement(By.xpath("//div[@class='orb-nav-section orb-nav-links orb-nav-focus']//li[@class='orb-nav-newsdotcom']")).click();
        driver.findElement(By.xpath("//span[text()='Coronavirus'][1]")).click();
        driver.findElement(By.xpath("//div[@class='blue-tit__inner gel-wrap gs-u-box-size']//span[text()='Contact BBC News']")).click();
        driver.findElement(By.xpath("//a[text()='send us a story']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//ожидание 5 сек
        driver.findElement(By.xpath("//button[@class='tp-close tp-active']")).click();//капча регистрации
        driver.findElement(By.xpath("//textarea[@placeholder='Tell us your story. ']")).sendKeys("text");
        driver.findElement(By.xpath("//input[@placeholder='Email address']")).sendKeys("mail");
        driver.findElement(By.xpath("//button[@class='button']")).click();//submit
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//неявное ожидание 10 сек
        assertTrue(driver.findElement(By.xpath("//div[@class='text-input']//div[@class='input-error-message']")).isDisplayed());
    }

    @Test (priority = 2)
    public void SendUsAStoryNoNext(){
        driver.findElement(By.xpath("//div[@class='orb-nav-section orb-nav-links orb-nav-focus']//li[@class='orb-nav-newsdotcom']")).click();
        driver.findElement(By.xpath("//span[text()='Coronavirus'][1]")).click();
        driver.findElement(By.xpath("//div[@class='blue-tit__inner gel-wrap gs-u-box-size']//span[text()='Contact BBC News']")).click();
        driver.findElement(By.xpath("//a[text()='send us a story']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//ожидание 5 сек
        driver.findElement(By.xpath("//button[@class='tp-close tp-active']")).click();//капча регистрации
        driver.findElement(By.xpath("//input[@placeholder='Email address']")).sendKeys("mail");
        driver.findElement(By.xpath("//button[@class='button']")).click();//submit
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//неявное ожидание 10 сек
        assertTrue(driver.findElement(By.xpath("//div[@class='long-text-input-container']//div[@class='input-error-message']")).isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.close();//закрытие драйвера
    }
}
