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
                loginPage.login(standardUserName, password);

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
        final String testTShirt = TEST_DATA.getTestProductOne();
        final String boltTShirt = TEST_DATA.getTestProductTwo();
        final String bikeLight = TEST_DATA.getTestProductThree();

        ProductsPage productsPage =
                loginPage.login(standardUserName, password);
        final String[] products = {testTShirt, boltTShirt, bikeLight};

        var itemsInCart = productsPage
                .addProductsToCart(products)
                .viewCart()
                .getCartItems();

        Assert.assertEqualsNoOrder(itemsInCart, Arrays.asList(products));
    }

    @Test(groups = {"all", "addSpecificItemToCartTest"})
    public void addSpecificItemToCartTest() {
        final String item = TEST_DATA.getTestProductOnesie();
        ProductsPage productsPage =
                loginPage.login(standardUserName, password);
        
        var itemsInCart = productsPage
                .addProductsToCart(item)
                .viewCart()
                .getCartItems();

        Assert.assertEquals(itemsInCart, List.of(item));
    }
}
