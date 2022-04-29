package com.ge.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Locale.US;

public class ProductsPage extends AbstractBasePage {

    @FindBy(className = "inventory_item")
    private List<InventoryItem> inventoryItems;

    @FindBy(className = "product_sort_container")
    private SelenideElement filterDropdown;

    public ProductsPage sortInventory(SortOrder desiredOrder) {
        filterDropdown.selectOptionContainingText(
                desiredOrder.textValue);
        return this;
    }

    public List<Double> getPriceList() {
        return inventoryItems.stream()
                .map(InventoryItem::getPrice)
                .collect(Collectors.toList());
    }

    public ProductsPage addProductsToCart(String... productLabels) {
        Predicate<InventoryItem> predicate =
                item -> Arrays.asList(productLabels)
                        .contains(item.inventoryItemNameLabel.text());
        inventoryItems.stream().filter(predicate).forEach(
                InventoryItem::addToCart);
        return this;
    }

    public enum SortOrder {
        NAME_A_TO_Z("Name (A to Z)"),
        NAME_Z_TO_A("Name (Z to A)"),
        PRICE_LOW_TO_HIGH("Price (low to high)"),
        PRICE_HIGH_TO_LOW("Price (high to low)");
        String textValue;

        SortOrder(String textValue) {
            this.textValue = textValue;
        }
    }

    static class InventoryItem extends AbstractPageFragment {

        private static String ADD_TO_CART = "ADD TO CART";
        private static String REMOVE = "REMOVE";
        @FindBy(className = "inventory_item_name")
        private SelenideElement inventoryItemNameLabel;
        @FindBy(className = "inventory_item_price")
        private SelenideElement inventoryItemPriceLabel;
        @FindBy(className = "btn_inventory")
        private SelenideElement inventoryButton;

        Double getPrice() {
            String currencySymbol = Currency.getInstance(US).getSymbol();
            return Double.valueOf(
                    inventoryItemPriceLabel.text().replace(currencySymbol, ""));
        }

        void addToCart() {
            if (inventoryButton.text().equals(ADD_TO_CART)) {
                inventoryButton.click();
            }
        }

        void removeFromCart() {
            if (inventoryButton.text().equals(REMOVE)) {
                inventoryButton.click();
            }
        }
    }

}
