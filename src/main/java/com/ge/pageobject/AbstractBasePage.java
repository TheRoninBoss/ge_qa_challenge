package com.ge.pageobject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.Wait;
import static com.codeborne.selenide.Selenide.page;

public abstract class AbstractBasePage {

    @FindBy(id = "react-burger-menu-btn")
    private SelenideElement burgerMenuButton;

    @FindBy(id = "shopping_cart_container")
    private SelenideElement shoppingCartButton;

    @FindBy(className = "bm-menu")
    private BurgerMenu burgerMenu;

    @FindBy(className = "title")
    private SelenideElement title;

    public String getTitle() {
        return title.text();
    }

    public LoginPage logout() {
        burgerMenuButton.click();
        burgerMenu.logout();
        return page(LoginPage.class);
    }

    public enum BurgerMenuOptions {
        ALL_ITEMS("ALL ITEMS"),
        ABOUT("ABOUT"),
        LOGOUT("LOGOUT"),
        RESET_APP_STATE("RESET APP STATE");

        private String text;

        BurgerMenuOptions(String text) {
            this.text = text;
        }

        public String getText() {
            return this.text;
        }
    }

    static class BurgerMenu extends AbstractPageFragment {

        @FindBy(className = "bm-item")
        private ElementsCollection burgerMenuItems;

        private void logout() {
            selectOption(BurgerMenuOptions.LOGOUT);
        }

        private void selectOption(BurgerMenuOptions option) {
            Wait().until(webDriver -> this.getSelf().isDisplayed());
            burgerMenuItems.filter(exactText(option.getText())).first().click();
        }
    }
}
