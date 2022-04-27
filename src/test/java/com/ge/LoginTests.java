package com.ge;

import com.ge.pageobject.ProductsPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class LoginTests extends BaseTest {

    //TODO: use data provider.
    private static final String BAD_CREDS_ERROR_MSG =
            "Epic sadface: Username and password do not match any user in this service";


    @Test
    public void loginTest() {
        ProductsPage productsPage =
                loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "PRODUCTS");
    }

    @Test
    public void unauthorizedUserTest() {
        loginPage.login("not_an_user", "secret_sauce");
        String errorMsg = loginPage.getBadCredsMsg();
        assertEquals(errorMsg, BAD_CREDS_ERROR_MSG);
    }

    @Test
    public void logoutTest() {
        loginPage.login("standard_user", "secret_sauce")
                .logout();
        assertNotNull(loginPage);
    }
}
