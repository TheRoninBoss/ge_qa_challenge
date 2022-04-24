package com.ge;

import com.ge.pageobject.LoginPage;
import com.ge.pageobject.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;

public class LoginTests extends BaseTest{

    @Test
    public void loginTest() {
        ProductsPage productsPage = page(LoginPage.class).login("standard_user","secret_sauce");
        Assert.assertEquals(productsPage.getTitle(), "PRODUCTS");
    }
}
