package com.automation.agentdesks.pages.signUp;

import com.automation.agentdesks.Base;
import com.automation.agentdesks.libCommon.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

public class SignUpAndroid extends SignUpBase {

    public static String installAppButton = "install-app";
    public static String emailButton = "com.agentdesks.android.crm:id/email_string";
    public static String emailTextField = "com.agentdesks.android.crm:id/agentNameText";
    public static String passwordTextField = "com.agentdesks.android.crm:id/agentPasswordText";
    public static String loginButton = "com.agentdesks.android.crm:id/email_sign_in";


    @Override
    public void tapOnOpenAppButton() {

         Assert.assertTrue("Failed to tap on Open App button", findElementByIdAndClick(installAppButton));
        Logger.logComment("Clicked on the Open app button displayed within chrome browser");

    }

    @Override
    public void checkLoginPageIsDisplayed() {

        Logger.logAction("Check login screen is displayed");
        Assert.assertTrue("Login Page is not displayed", isElementDisplayedById(emailTextField));
        Logger.logComment("Login screen is displayed");

    }

    @Override
    public void tapOnEmailButton() {
        Logger.logAction("Click on the Login with Email button");
        Assert.assertTrue("Failed to tap on Login with Email button", findElementByIdAndClick(emailButton));
        Logger.logComment("Clicked on Login with Email button");
    }

    @Override
    public void enterNameInEmail() {
        Logger.logAction("Enter email address in email text field");
        Assert.assertTrue("email text field not displayed", isElementDisplayedById(emailTextField));
        selectElementById(emailTextField);
        sendTextById("test@test.in", emailTextField);
        Assert.assertTrue("Invalid email id format", checkEmailFormat(emailTextField));
        Logger.logComment("Entered email address in the email text field");
    }

    @Override
    public void enterPassword() throws Exception {
        Logger.logAction("Enter password in password text field");
        Assert.assertTrue("email text field not displayed", isElementDisplayedById(emailTextField));
        selectElementById(passwordTextField);
        sendTextById("test@test.in", passwordTextField);
        dismissAndroidKeyboard();
        sleep(500);
        Logger.logComment("Entered password  in the password text field");

    }

    @Override
    public void tapOnLoginButton() {
        Logger.logAction("Click on Login button");
        Assert.assertTrue("Failed to tap on Login button", findElementByIdAndClick(loginButton));
        Logger.logAction("Clicked on Login button");
    }
}
