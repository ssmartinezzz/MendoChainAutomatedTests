package mendochain.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public  BasePage (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    protected void waitForElementToBeClickable(By locator, Duration timeout) {
        wait.withTimeout(timeout);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void click(By locator, Duration timeout) {
        waitForElementToBeClickable(locator, timeout);
        driver.findElement(locator).click();
    }

    protected void sendKeys(By locator, String text, Duration timeout) {
        waitForElementToBeClickable(locator, timeout);
        driver.findElement(locator).sendKeys(text);
    }




    public String getTitle(){
        return driver.getTitle();
    }

    public void goTo (String UrI){
        driver.get(UrI);

    }


}
