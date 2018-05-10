package com.automation.agentdesks.pages.signUp;

import com.automation.agentdesks.libCommon.Logger;
import io.appium.java_client.TouchAction;
import org.junit.Assert;
import org.openqa.selenium.By;



public class SignUpIos extends SignUpBase{

    public static String loginButton = "Login";
    public static String loginWithEmailButton = "Login with email";
    public static String emailTextField = "com.agentdesks.android.crm:id/agentNameText";
    public static String passwordFieldXpath = "//XCUIElementTypeApplication[@name=\"Agentdesks\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeSecureTextField";
    public static String emailAddressXpath = "//XCUIElementTypeApplication[@name=\"Agentdesks\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeTextField";
    public static String emailAdressXpathTextField = "//XCUIElementTypeApplication[@name=\"Agentdesks\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeTextField/XCUIElementTypeTextField";
    @Override
    public void checkLoginPageIsDisplayed() {
        Logger.logAction("Check login screen is displayed");
        Assert.assertTrue("Login Page is not displayed", isElementDisplayedById(emailAddressXpath));
        Logger.logComment("Login screen is displayed");
    }

    @Override
    public void tapOnOpenAppButton() {

        Logger.logAction("Tap on the Open App, OPEN button with in the Safari brower and App store ");
        TouchAction action = new TouchAction(driver); // unable to identify the elements in appium  inspector so hardcoded with cordinates
        action.tap(208, 371).perform();
        driver.context("NATIVE_APP");  // Switch to native app, after navigating to the url and tapping on Open app button it naviagtes to the installed app in mobile device
        driver.findElement(By.id("Open")).click(); // tap on the open button in web page
        sleep(5000);
        driver.findElement(By.id("OPEN")).click(); // tap on OPEN button within the app store
        Logger.logComment("Clicked on the Open App, OPEN button");
    }

    @Override
    public void tapOnEmailButton() {

        Logger.logAction("Tap on the login and Login with Email button");
        Assert.assertTrue("Failed to tap on Login button", findElementByIdAndClick(loginButton));
        Assert.assertTrue("Failed to tap on Login button", findElementByIdAndClick(loginWithEmailButton));
        Logger.logComment("Clicked on the login and Login with Email button");
    }

    @Override
    public void enterNameInEmail() {
        Logger.logAction("Enter email address in email text field");
        Assert.assertTrue("email text field not displayed", findElementByXpathAndClick(emailAddressXpath));
        sendTextById("test@test.in", emailAddressXpath);
        Assert.assertTrue("Invalid email id format", checkEmailFormat(emailAddressXpath));
        Logger.logComment("Entered email address in the email text field");

    }

    @Override
    public void enterPassword() {
        Logger.logAction("Enter password in password text field");
        Assert.assertTrue("email text field not displayed",findElementByXpathAndClick(passwordFieldXpath) );
        sendTextById("test@test.in", passwordFieldXpath);
        Logger.logComment("Entered password  in the password text field");

    }

    @Override
    public void tapOnLoginButton() {
        Logger.logAction("Tap on Login button");
        Assert.assertTrue("Failed to tap on Login button", findElementByIdAndClick(loginButton));
        Logger.logComment("Clicked on Login button");
    }



}
