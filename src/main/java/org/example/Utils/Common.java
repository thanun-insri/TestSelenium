package org.example.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Common {
    public Driver driver;
    public Common(Driver driver) {
        this.driver = driver;
    }

    public void clickOn(String elementPath) {
        WebElement element = driver.getElementByXpath(elementPath);
        element.click();
    }

    public void inputText(String elementPath, String inputText) {
        WebElement element = driver.getElementByXpath(elementPath);
        element.sendKeys(inputText);
    }

    public void elementIsDisplayed(String elementPath) {
        WebElement element = driver.getElementByXpath(elementPath);
        element.isDisplayed();
    }

    public void waitUntilElementVisible(String elementPath) {
        WebDriverWait wait = new WebDriverWait(driver.getDriverForBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementPath)));
    }

    public String getTextFromElement(String elementPath) {
        WebElement element = driver.getElementByXpath(elementPath);
        return element.getText();
    }
}
