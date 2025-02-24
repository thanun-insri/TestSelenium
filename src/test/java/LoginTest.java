import com.google.gson.JsonObject;
import org.example.Page.LoginPage;
import org.example.Page.ProductHomePage;
import org.example.Utils.Driver;
import org.example.TestData.TestData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    private Driver driver;
    private JsonObject testData;

    @BeforeMethod
    public void openBrowserAndGoto() {
        //Get test data from testData.json file in resources folder
        TestData testDataObj = new TestData();
        testData = testDataObj.getData();

        //Get driver by select driver for Chrome
        driver = new Driver();
        driver.selectDriverForBrowser("chrome");
        driver.gotoURL(testData.get("url").getAsString());
    }

    @Test
    public void userLoginSuccessfully_standardUser() {
        LoginPage loginPage = new LoginPage(driver, testData);
        ProductHomePage productHomePage = new ProductHomePage(driver, testData);
        loginPage.enterUsername(testData.getAsJsonObject("user_valid").get("username").getAsString());
        loginPage.enterPassword(testData.getAsJsonObject("user_valid").get("password").getAsString());
        loginPage.clickLoginButton();
        productHomePage.verifyHomePage();
    }

    @Test
    public void userLoginUnsuccessfully_lockedUser() {
        LoginPage loginPage = new LoginPage(driver, testData);
        loginPage.enterUsername(testData.getAsJsonObject("user_locked").get("username").getAsString());
        loginPage.enterPassword(testData.getAsJsonObject("user_locked").get("password").getAsString());
        loginPage.clickLoginButton();
        loginPage.errorMessageDisplayedWithLoginUnsuccessfully();
    }

    @Test
    public void userLoginSuccessfully_problemUser() {
        LoginPage loginPage = new LoginPage(driver, testData);
        ProductHomePage productHomePage = new ProductHomePage(driver, testData);
        loginPage.enterUsername(testData.getAsJsonObject("user_problem").get("username").getAsString());
        loginPage.enterPassword(testData.getAsJsonObject("user_problem").get("password").getAsString());
        loginPage.clickLoginButton();
        productHomePage.verifyHomePage();
    }

    @Test
    public void userLoginSuccessfully_performanceUser() {
        LoginPage loginPage = new LoginPage(driver, testData);
        ProductHomePage productHomePage = new ProductHomePage(driver, testData);
        loginPage.enterUsername(testData.getAsJsonObject("user_performance").get("username").getAsString());
        loginPage.enterPassword(testData.getAsJsonObject("user_performance").get("password").getAsString());
        loginPage.clickLoginButton();
        productHomePage.verifyHomePage();
    }

    @Test
    public void userLoginSuccessfully_errorUser() {
        LoginPage loginPage = new LoginPage(driver, testData);
        ProductHomePage productHomePage = new ProductHomePage(driver, testData);
        loginPage.enterUsername(testData.getAsJsonObject("user_error").get("username").getAsString());
        loginPage.enterPassword(testData.getAsJsonObject("user_error").get("password").getAsString());
        loginPage.clickLoginButton();
        productHomePage.verifyHomePage();
    }

    @Test
    public void userLoginSuccessfully_visualUser() {
        LoginPage loginPage = new LoginPage(driver, testData);
        ProductHomePage productHomePage = new ProductHomePage(driver, testData);
        loginPage.enterUsername(testData.getAsJsonObject("user_visual").get("username").getAsString());
        loginPage.enterPassword(testData.getAsJsonObject("user_visual").get("password").getAsString());
        loginPage.clickLoginButton();
        productHomePage.verifyHomePage();
    }

    @AfterMethod
    public void testTearDown() {
        if (driver != null) {
            driver.closeBrowser();
        }
    }
}