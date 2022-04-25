package com.ge.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends AbstractBasePage {

    @FindBy(className = "inventory_item")
    private List<InventoryItem> inventoryItems;

    @FindBy(className = "select_container")
    private SelenideElement filterDropdown;

    public ProductsPage sortInventory(SortOrder desiredOrder) {
        //TODO: First check what's the current sort order.
        filterDropdown.selectOptionContainingText(desiredOrder.textValue);
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

        @FindBy(className = "inventory_item_name")
        private SelenideElement inventoryItemNameLabel;

        @FindBy(className = "btn_inventory")
        private SelenideElement inventoryButton;

    }

}
