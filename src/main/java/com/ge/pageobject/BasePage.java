package com.ge.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage {

    @FindBy(id = "react-burger-menu-btn")
    private SelenideElement burgerMenuButton;

    @FindBy(id = "shopping_cart_container")
    private SelenideElement shoppingCartButton;

    @FindBy(className = "title")
    private SelenideElement title;

    public String getTitle(){
        return title.text();
    }
}
