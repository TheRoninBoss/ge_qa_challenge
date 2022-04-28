package com.ge;

import com.ge.pageobject.ConfirmationPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTests extends BaseTest {

    @Test(groups = {"all", "completePurchaseTest"})
    public void completePurchaseTest() {
        final String testTShirt = TEST_DATA.getTestProductOne();
        final String boltTShirt = TEST_DATA.getTestProductTwo();
        final String customerName = TEST_DATA.getCustomerFirstName();
        final String customerLastName = TEST_DATA.getCustomerLastName();
        final String customerPostalCode = TEST_DATA.getCuctomerPostalCode();
        final String expectedTitle = TEST_DATA.getConfirmationPageTitle();

        ConfirmationPage confirmationPage =
                loginPage
                        .login(standardUserName, password)
                        .addProductsToCart(testTShirt, boltTShirt)
                        .viewCart()
                        .checkout()
                        .fillFirstName(customerName)
                        .fillLastName(customerLastName)
                        .fillPostalCode(customerPostalCode)
                        .continueToOverview()
                        .completePurchase();
        String confirmationTitle = confirmationPage.getTitle();

        assertEquals(confirmationTitle, expectedTitle);
    }

}
