package com.automation.agentdesks.pages.constructors;

import com.automation.agentdesks.pages.signUp.SignUpAndroid;
import com.automation.agentdesks.pages.signUp.SignUpIos;
import com.automation.agentdesks.tests.BaseTest;

public class PageConstructor {

    public static void initializePageObject(String page, String platform) throws Exception {


        switch (page) {

            case "SignUp":
                if(platform.equals("Android"))
                    BaseTest.SignUpPage = new SignUpAndroid();
                else
                    BaseTest.SignUpPage = new SignUpIos();

        }

    }
}
