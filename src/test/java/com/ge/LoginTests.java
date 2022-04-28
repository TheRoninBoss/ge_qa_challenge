package com.ge;

import com.ge.pageobject.LoginPage;
import com.ge.pageobject.ProductsPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class LoginTests extends BaseTest {

    private final String invalidPassword = TEST_DATA.getInvalidPassword();
    private final String expectedErrorMsg =
            TEST_DATA.getIncorrectLoginErrorMessage();

    @Test(groups = {"all", "loginTest"})
    public void loginTest() {
        ProductsPage productsPage =
                loginPage.login(standardUserName, password);

        assertEquals(productsPage.getTitle(), "PRODUCTS");
    }

    @Test(groups = {"all", "unauthorizedUserTest"})
    public void unauthorizedUserTest() {
        loginPage.login(standardUserName, invalidPassword);
        String actualErrorMsg = loginPage.getBadCredsMsg();

        assertEquals(actualErrorMsg, expectedErrorMsg);
    }

    @Test(groups = {"all", "logoutTest"})
    public void logoutTest() {
        LoginPage expectedPage = loginPage
                .login(standardUserName, password)
                .logout();

        assertNotNull(expectedPage);
    }
}
