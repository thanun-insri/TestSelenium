package org.example.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Driver {
    private WebDriver driver;

    public void selectDriverForBrowser(String browserSelected) {
        String pathToDriver;
        if(browserSelected.equals("chrome")){
            pathToDriver = new File("src/main/resources/driver/chromedriver.exe").getAbsolutePath();
            System.setProperty("webdriver.chrome.driver", pathToDriver);
            driver = new ChromeDriver();
        }
        // else if (Firefox, Edge, ...)
    }

    public WebDriver getDriverForBrowser() {
        return driver;
    }

    public void gotoURL(String url) {
        driver.get(url);
    }

    public WebElement getElementByXpath(String locatorString) {
        return driver.findElement(By.xpath(locatorString));
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void closeBrowser() {
        driver.close();
        driver.quit();
    }
}
