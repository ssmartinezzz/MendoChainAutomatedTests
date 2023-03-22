package mendochain.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.Assertion;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public BasePage page;
    public Assertion hardAssert;

    @BeforeMethod
    public void setUpTest() {
       driver = new ChromeDriver();
       wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       driver.manage().window().maximize();
       page = new BasePage(driver, wait);
       hardAssert = new Assertion();
    }

    @AfterMethod
    public void close() {
        driver.close();
        driver.quit();
    }

}
