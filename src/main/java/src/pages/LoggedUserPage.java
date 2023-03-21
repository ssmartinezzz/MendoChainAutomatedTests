package src.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import src.core.BasePage;

import java.time.Duration;

public class LoggedUserPage extends BasePage {
    protected By logoutButton = By.xpath("//div[@class='nav-item']//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary']//span[@class='MuiButton-label']");
    protected By burgerMenu = By.xpath("//button[@class='navbar-toggler collapsed']");
    protected By optionsMenu = By.xpath("//button[@class='navbar-toggler']");
    protected By uploadAWine = By.linkText("Upload a wine");


    public LoggedUserPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickLogoutButton() {
        super.click(logoutButton, Duration.ofSeconds(5));
    }

    public void clickBurgerMenu() {
        super.click(burgerMenu, Duration.ofSeconds(5));
    }
    public void clickOptionsMenu() {
        super.click(optionsMenu, Duration.ofSeconds(5));
    }

    public void clickUploadWine() {
        super.click(uploadAWine, Duration.ofSeconds(5));
    }

    public void openOptions() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(burgerMenu));
        if (element.isDisplayed()) {
            clickBurgerMenu();
        }
        clickOptionsMenu();
    }

    public createWinePage createWine() {
        openOptions();
        clickUploadWine();
        return new createWinePage(driver, wait);
    }


    public LoginPage logOut() {
        clickLogoutButton();
        return new LoginPage(driver, wait);
    }
}
