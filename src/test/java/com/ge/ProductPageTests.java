package com.ge;

import com.ge.pageobject.LoginPage;
import com.ge.pageobject.ProductsPage;
import com.google.common.collect.Ordering;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static com.ge.pageobject.ProductsPage.SortOrder.PRICE_LOW_TO_HIGH;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ProductPageTests extends BaseTest {

    @Test
    public void sortProductsByPriceTest() {
        ProductsPage productsPage =
                page(LoginPage.class).login("standard_user", "secret_sauce");

        boolean notSorted =
                Ordering.natural().isOrdered(productsPage.getPriceList());
        productsPage.sortInventory(PRICE_LOW_TO_HIGH);
        boolean sorted =
                Ordering.natural().isOrdered(productsPage.getPriceList());

        assertFalse(notSorted);
        assertTrue(sorted);
    }

    //@Test //TODO: implement
    public void addMultipleItemsToCartTest() {

    }

    //@Test //TODO: implement
    public void addSpecificItemToCartTest() {

    }
}
