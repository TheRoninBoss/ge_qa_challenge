package com.ge;

import com.ge.pageobject.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.*;

public abstract class BaseTest {

    protected LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        open("https://www.saucedemo.com/");
        loginPage = page(LoginPage.class);
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
