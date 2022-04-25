package com.ge;

import com.ge.pageobject.LoginPage;
import com.ge.pageobject.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTest{

    //TODO: use data provider.
    private static final String BAD_CREDS_ERROR_MSG = "Epic sadface: Username and password do not match any user in this service";


//    @Test
    public void loginTest() {
        ProductsPage productsPage = page(LoginPage.class).login("standard_user","secret_sauce");
        assertEquals(productsPage.getTitle(), "PRODUCTS");
    }

//    @Test
    public void unauthorizedUserTest() {
        LoginPage loginPage = page(LoginPage.class);
        loginPage.login("not_an_user", "secret_sauce");
        String errorMsg = loginPage.getBadCredsMsg();
        assertEquals(errorMsg,BAD_CREDS_ERROR_MSG);
    }

    @Test
    public void logoutTest() {
        ProductsPage productsPage = page(LoginPage.class).login("standard_user","secret_sauce");
        productsPage.printInventory();
        assertEquals(productsPage.getInventoryItemQty(), 6);
    }
}
