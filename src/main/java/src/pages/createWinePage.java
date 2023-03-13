package src.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import src.core.BasePage;

import java.time.Duration;

public class createWinePage extends BasePage {
    protected By varietyField = By.id("variety_name");
    protected By contentField = By.id("content");
    protected  By alcoholField = By.id("alcohol");
    protected By brandField = By.id("brand_name-label");
    protected By lotField = By.id("lote");
    protected By yearField = By.id("year");

    protected By uploadButton = By.xpath("//div[@class='btn-submit']//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary']");

    public createWinePage(WebDriver driver) {
        super(driver);
    }

    public void sendVarietyName(String varietyName) {
        super.sendKeys(varietyField, varietyName, Duration.ofSeconds(10));
    }

    public void sendContent(String content) {
        super.sendKeys(contentField, content, Duration.ofSeconds(10));
    }

    public void sendAlcohol(String alcohol) {
        super.sendKeys(alcoholField, alcohol, Duration.ofSeconds(10));
    }
    public void sendBrand(String brand) {
        super.sendKeys(brandField, brand, Duration.ofSeconds(10));
    }

    public void sendLot(String lot) {
        super.sendKeys(lotField, lot, Duration.ofSeconds(10));
    }

    public void sendYear(String year) {
        super.sendKeys(yearField, year, Duration.ofSeconds(10));
    }

    public void clickUploadButton() {
        super.click(uploadButton, Duration.ofSeconds(10));
    }

    public void uploadAWine(String varietyName, String content, String alcohol, String brand, String lot, String year) {
        sendVarietyName(varietyName);
        sendContent(content);
        sendAlcohol(alcohol);
        sendBrand(brand);
        sendLot(lot);
        sendYear(year);
        clickUploadButton();
    }





}
