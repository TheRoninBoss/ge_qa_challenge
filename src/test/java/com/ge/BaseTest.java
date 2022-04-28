package com.ge;

import com.ge.core.TestData;
import com.ge.pageobject.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.*;

public abstract class BaseTest {

    protected static final TestData TEST_DATA = TestData.getInstance();
    protected final String standardUserName = TEST_DATA.getStandardUserName();
    protected final String password = TEST_DATA.getValidPassword();
    protected LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        open(TEST_DATA.getBaseUrl());
        loginPage = page(LoginPage.class);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }
}
