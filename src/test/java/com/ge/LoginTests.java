package com.ge;

import com.ge.pageobject.ProductsPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class LoginTests extends BaseTest {

    @Test(groups = {"all", "loginTest"})
    public void loginTest() {
        String username = testData.getStandardUserName();
        String password = testData.getValidPassword();

        ProductsPage productsPage =
                loginPage.login(username, password);

        assertEquals(productsPage.getTitle(), "PRODUCTS");
    }

    @Test(groups = {"all", "unauthorizedUserTest"})
    public void unauthorizedUserTest() {
        String username = testData.getStandardUserName();
        String invalidPassword = testData.getInvalidPassword();
        String expectedErrorMsg = testData.getIncorrectLoginErrorMessage();

        loginPage.login(username, invalidPassword);
        String actualErrorMsg = loginPage.getBadCredsMsg();
        
        assertEquals(actualErrorMsg, expectedErrorMsg);
    }

    @Test(groups = {"all", "logoutTest"})
    public void logoutTest() {
        String username = testData.getStandardUserName();
        String password = testData.getValidPassword();

        loginPage.login(username, password)
                .logout();

        assertNotNull(loginPage);
    }
}
