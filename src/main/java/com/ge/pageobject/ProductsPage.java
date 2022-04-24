package com.ge.pageobject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.ElementsContainerCollection;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage{

    @FindBy(className = "inventory_list")
    private ElementsCollection inventoryItems;

    @FindBy(className = "select_container")
    private SelenideElement filterDropdown;

    public enum SortOrder {
        NAME_A_TO_Z("Name (A to Z)"),
        NAME_Z_TO_A("Name (Z to A)"),
        PRICE_LOW_TO_HIGH("Price (low to high)"),
        PRICE_HIGH_TO_LOW("Price (high to low)");
        String textValue;
        SortOrder(String textValue){
            this.textValue = textValue;
        }
    }

    public ProductsPage sortInventory(SortOrder desiredOrder) {
        //TODO: First check what's the current sort order.
        filterDropdown.selectOptionContainingText(desiredOrder.textValue);
        return this;
    }

    class InventoryItem extends ElementsContainer{

        @FindBy(className = "inventory_item_name")
        private SelenideElement inventoryItemNameLabel;

        @FindBy(className = "btn_inventory")
        private SelenideElement inventoryButton;

    }

}
