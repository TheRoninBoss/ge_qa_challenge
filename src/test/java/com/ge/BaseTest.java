package com.ge;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.GlobalTextReport;
import com.ge.core.TestData;
import com.ge.pageobject.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import static com.codeborne.selenide.Selenide.*;

@Listeners({GlobalTextReport.class})
public abstract class BaseTest {

    protected static final TestData TEST_DATA = TestData.getInstance();
    protected final String standardUserName = TEST_DATA.getStandardUserName();
    protected final String password = TEST_DATA.getValidPassword();
    protected LoginPage loginPage;

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
