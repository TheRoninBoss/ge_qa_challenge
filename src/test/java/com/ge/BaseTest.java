package com.ge;

import com.ge.pageobject.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.*;

public abstract class BaseTest {

    protected LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        open("https://www.saucedemo.com/");
        loginPage = page(LoginPage.class);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }
}
