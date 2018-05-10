package com.automation.agentdesks.tests;

import com.automation.agentdesks.Base;
import com.automation.agentdesks.Labels;
import io.appium.java_client.TouchAction;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import sun.jvm.hotspot.ui.tree.SimpleTreeGroupNode;

public class LoginToTheWebPage  extends BaseTest {


    @Test
    public void testLoginWebPage() throws Exception {

       // SignUpPage.waitUntilWebPageIsDisplayedInAndroid(Labels.id);
        SignUpPage.tapOnOpenAppButton();
        if(platform.equals("iOS"))
            SignUpPage.tapOnEmailButton();
        SignUpPage.checkLoginPageIsDisplayed();
        SignUpPage.enterNameInEmail();
        SignUpPage.enterPassword();
        SignUpPage.tapOnLoginButton();
    }



}
