package com.automation.agentdesks.pages.signUp;

import com.automation.agentdesks.Base;
import com.automation.agentdesks.pages.interfaces.SignUpInterface;
import com.automation.agentdesks.tests.BaseTest;
import org.openqa.selenium.By;

public abstract class SignUpBase extends BaseTest implements SignUpInterface {

    public void waitUntilWebPageIsDisplayedInAndroid(String Xpath){
        Base.waitForElementToLoad(Xpath);
    }

}


