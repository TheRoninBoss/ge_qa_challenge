package com.ge.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.Currency;
import java.util.List;
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
                .map(item -> item.getPrice())
                .collect(Collectors.toList());
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
    }

}
