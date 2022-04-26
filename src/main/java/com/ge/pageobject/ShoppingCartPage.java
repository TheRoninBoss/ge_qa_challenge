package com.ge.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCartPage extends AbstractBasePage {

    @FindBy(className = "cart_item")
    private List<CartItem> cartItems;
    @FindBy(id = "checkout")
    private SelenideElement checkoutButton;

    public List<String> getCartItems() {
        return cartItems.stream()
                .map(item -> item.inventoryItemNameLabel.text())
                .collect(
                        Collectors.toList());
    }

    static class CartItem extends AbstractPageFragment {

        @FindBy(className = "inventory_item_name")
        private SelenideElement inventoryItemNameLabel;

    }

}
