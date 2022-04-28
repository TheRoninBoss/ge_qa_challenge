package com.ge;

import com.ge.core.TestData;
import com.ge.pageobject.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.*;

public abstract class BaseTest {

    protected LoginPage loginPage;
    protected TestData testData = TestData.getInstance();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        open(testData.getBaseUrl());
        loginPage = page(LoginPage.class);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }
}
