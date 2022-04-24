package com.ge;

import com.ge.pageobject.LoginPage;
import com.ge.pageobject.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class SauceDemoTest {

    @Test
    public void test() {
        open("https://www.saucedemo.com/");
        ProductsPage productsPage = page(LoginPage.class).login();
        Assert.assertEquals(productsPage.getTitle(), "PRODUCTS");
    }
}
