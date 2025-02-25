import com.google.gson.JsonObject;
import org.example.Page.LoginPage;
import org.example.Page.ProductHomePage;
import org.example.Utils.Driver;
import org.example.TestData.TestData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest {
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

        LoginPage loginPage = new LoginPage(driver, testData);
        loginPage.userLoginSuccessfullyWithValidUser();
    }

    @Test
    public void userIsAbleToAddProductsToShoppingCartSuccessfully() {
        ProductHomePage productHomePage = new ProductHomePage(driver, testData);
        productHomePage.addAllProductsToShoppingCart();
        productHomePage.verifyNumberOnShoppingCartIconDisplaysCorrectly(testData.get("expectedAmountOnShoppingCartIcon").getAsInt());
        productHomePage.clickShoppingCartIcon();
        productHomePage.AllProductHasBeenAddedToCartSuccessfully();
    }

    @AfterMethod
    public void testTearDown() {
        if(driver != null) {
            driver.closeBrowser();
        }
    }
}