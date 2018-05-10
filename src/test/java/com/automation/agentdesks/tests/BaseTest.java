package com.automation.agentdesks.tests;

import com.automation.agentdesks.Base;
import com.automation.agentdesks.pages.signUp.SignUpBase;
import org.testng.annotations.BeforeClass;

import static com.automation.agentdesks.pages.constructors.PageConstructor.initializePageObject;

public class BaseTest extends Base {

    public static SignUpBase SignUpPage;

    @BeforeClass

    public static  void setUp() throws Exception {

        Base.setUp();
        initializePageObject("SignUp", Base.platform);

    }
}
