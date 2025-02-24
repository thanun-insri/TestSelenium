package org.example.Page;
import com.google.gson.JsonObject;
import org.example.Locators.Locators;
import org.example.Utils.Common;
import org.example.Utils.Driver;

public class LoginPage {
    public Driver driver;
    public JsonObject testData;
    public JsonObject locators;
    public Common common;

    public LoginPage(Driver driver, JsonObject testData) {
        this.driver = driver;
        this.testData = testData;
        common = new Common(driver);

        //Declare locators instance inside each of step method file
        Locators locatorsObj = new Locators("loginPage");
        locators = locatorsObj.getLocators();
    }

    public void enterUsername(String username) {
        common.inputText(locators.get("usernameTextBox").getAsString(), username);
    }

    public void enterPassword(String password) {
        common.inputText(locators.get("passwordTextBox").getAsString(), password);
    }

    public void clickLoginButton() {
        common.clickOn(locators.get("loginButton").getAsString());
    }

    public void errorMessageDisplayedWithLoginUnsuccessfully() {
        common.elementIsDisplayed(locators.get("errorMessage").getAsString());
    }

    public void userLoginSuccessfullyWithValidUser() {
        this.enterUsername(testData.getAsJsonObject("user_valid").get("username").getAsString());
        this.enterPassword(testData.getAsJsonObject("user_valid").get("password").getAsString());
        this.clickLoginButton();
    }
}
