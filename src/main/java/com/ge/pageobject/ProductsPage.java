package com.ge.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage {

    @FindBy(id = "react-burger-menu-btn")
    private SelenideElement burgerMenuButton;

    @FindBy(className = "title")
    private SelenideElement title;

    public String getTitle(){
        return title.text();
    }

}
