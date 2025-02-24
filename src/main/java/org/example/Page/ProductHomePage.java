package org.example.Page;
import com.google.gson.JsonObject;
import org.example.Locators.Locators;
import org.example.Utils.Common;
import org.example.Utils.Driver;
import org.testng.Assert;

public class ProductHomePage {
    public Driver driver;
    public JsonObject testData;
    public JsonObject locators;
    public Common common;

    public ProductHomePage(Driver driver, JsonObject testData) {
        this.driver = driver;
        this.testData = testData;
        this.common = new Common(driver);

        //Declare locators instance inside each of step method file
        Locators locatorsObj = new Locators("productHomePage");
        locators = locatorsObj.getLocators();
    }

    public void verifyHomePage() {
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL does not match after login!");
    }

    public void addAllProductsToShoppingCart() {
        String[] addButtonLocatorList = {   locators.get("addToCartButton_sauce-labs-backpack").getAsString(),
                                            locators.get("addToCartButton_sauce-labs-bolt-t-shirt").getAsString(),
                                            locators.get("addToCartButton_sauce-labs-onesie").getAsString(),
                                            locators.get("addToCartButton_sauce-labs-bike-light").getAsString(),
                                            locators.get("addToCartButton_sauce-labs-fleece-jacket").getAsString(),
                                            locators.get("addToCartButton_test-allthethings").getAsString() };
        String[] removeButtonLocatorList = {    locators.get("removeButton_sauce-labs-backpack").getAsString(),
                                                locators.get("removeButton_sauce-labs-bolt-t-shirt").getAsString(),
                                                locators.get("removeButton_sauce-labs-onesie").getAsString(),
                                                locators.get("removeButton_sauce-labs-bike-light").getAsString(),
                                                locators.get("removeButton_sauce-labs-fleece-jacket").getAsString(),
                                                locators.get("removeButton_test-allthethings").getAsString() };
        for (int i=0; i<addButtonLocatorList.length; i++) {
            common.waitUntilElementVisible(addButtonLocatorList[i]);
            common.clickOn(addButtonLocatorList[i]);
            common.waitUntilElementVisible(removeButtonLocatorList[i]);
        }
    }

    public void verifyNumberOnShoppingCartIconDisplaysCorrectly(int expectedAmount) {
        int actualAmount = Integer.parseInt(common.getTextFromElement(locators.get("amountOnShoppingCartIcon").getAsString()));
        Assert.assertEquals(actualAmount, expectedAmount, "Amount in shopping carts is not the same as expected.");
    }

    public void clickShoppingCartIcon() {
        common.clickOn(locators.get("shoppingCartIcon").getAsString());
    }

    public void AllProductHasBeenAddedToCartSuccessfully() {
        String[] addedProductNameList = { "Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)",
                                          "Sauce Labs Fleece Jacket", "Sauce Labs Bike Light" };
        for (String s : addedProductNameList) {
            String addedProductNameLocator = (locators.get("addedProductNameInCartPage").getAsString()).replace("$productName",s);
            common.elementIsDisplayed(addedProductNameLocator);
        }
    }
}
