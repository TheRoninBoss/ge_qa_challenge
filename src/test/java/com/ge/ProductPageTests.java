package com.ge;

import com.ge.pageobject.ProductsPage;
import com.google.common.collect.Ordering;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.ge.pageobject.ProductsPage.SortOrder.PRICE_LOW_TO_HIGH;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ProductPageTests extends BaseTest {

    @Test(groups = {"all", "sortProductsByPriceTest"})
    public void sortProductsByPriceTest() {
        ProductsPage productsPage =
                loginPage.login("standard_user", "secret_sauce");

        boolean notSorted =
                Ordering.natural().isOrdered(productsPage.getPriceList());
        productsPage.sortInventory(PRICE_LOW_TO_HIGH);
        boolean sorted =
                Ordering.natural().isOrdered(productsPage.getPriceList());

        assertFalse(notSorted);
        assertTrue(sorted);
    }

    @Test(groups = {"all", "addMultipleItemsToCartTest"})
    public void addMultipleItemsToCartTest() {
        ProductsPage productsPage =
                loginPage.login("standard_user", "secret_sauce");
        final String[] products =
                {"Test.allTheThings() T-Shirt (Red)", "Sauce Labs Bolt T-Shirt", "Sauce Labs Bike Light"};

        var itemsInCart = productsPage
                .addProductsToCart(products)
                .viewCart()
                .getCartItems();

        Assert.assertEqualsNoOrder(itemsInCart, Arrays.asList(products));
    }

    @Test(groups = {"all", "addSpecificItemToCartTest"})
    public void addSpecificItemToCartTest() {
        ProductsPage productsPage =
                loginPage.login("standard_user", "secret_sauce");
        final String item = "Sauce Labs Onesie";

        var itemsInCart = productsPage
                .addProductsToCart(item)
                .viewCart()
                .getCartItems();

        Assert.assertEquals(itemsInCart, List.of(item));
    }
}
