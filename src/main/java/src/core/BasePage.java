package src.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public  BasePage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
}
