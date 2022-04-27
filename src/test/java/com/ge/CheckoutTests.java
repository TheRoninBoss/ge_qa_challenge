package com.ge;

import com.ge.pageobject.ConfirmationPage;
import com.ge.pageobject.LoginPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertEquals;

public class CheckoutTests extends BaseTest {

    @Test
    public void completePurchaseTest() {
        ConfirmationPage confirmationPage =
                page(LoginPage.class)
                        .login("standard_user", "secret_sauce")
                        .addProductsToCart("Test.allTheThings() T-Shirt (Red)",
                                "Sauce Labs Bolt T-Shirt")
                        .viewCart()
                        .checkout()
                        .fillFirstName("Eduardo")
                        .fillLastName("Enciso")
                        .fillPostalCode("03012")
                        .continueToOverview()
                        .completePurchase();
        String confirmationTitle = confirmationPage.getTitle();

        assertEquals(confirmationTitle, "CHECKOUT: COMPLETE!");
    }

}
