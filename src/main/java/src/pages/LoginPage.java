package src.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import src.core.BasePage;

import java.time.Duration;

public class LoginPage extends BasePage {

    protected By usernameField = By.id("username");
    protected By passwordField = By.id("password");

    protected By signInFirstButton = By.xpath("//div[@class='home__info-container']//a//span[@class='MuiButton-label']");
    protected By signInButton = By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary']");
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickSignInButton() {
        super.click(signInButton, Duration.ofSeconds(5));
    }

    public void clickFirstSignInButton() {
        super.click(signInFirstButton, Duration.ofSeconds(5));
    }


    public void sendUsername(String username) {
        super.sendKeys(usernameField, username, Duration.ofSeconds(5));
    }

    public void sendPassword(String password) {
        super.sendKeys(passwordField, password, Duration.ofSeconds(5));
    }

    public LoggedUserPage loginUser(String username, String password) {
        clickFirstSignInButton();
        sendUsername(username);
        sendPassword(password);
        clickSignInButton();
        return new LoggedUserPage(driver, wait);
    }




}
