package com.ge;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {

    @BeforeTest
    public void setUp(){
        open("https://www.saucedemo.com/");
    }

    @AfterTest
    public void tearDown(){
        closeWebDriver();
    }
}
