package com.ge;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.ge.core.TestData;
import com.ge.pageobject.LoginPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import static com.codeborne.selenide.Selenide.*;

public abstract class BaseTest {

    protected static final TestData TEST_DATA = TestData.getInstance();
    protected final String standardUserName = TEST_DATA.getStandardUserName();
    protected final String password = TEST_DATA.getValidPassword();
    protected LoginPage loginPage;

    @BeforeSuite
    public void setUpAllureListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setUp(String browser) {
        Configuration.browser = browser;
        open(TEST_DATA.getBaseUrl());
        loginPage = page(LoginPage.class);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }
}
