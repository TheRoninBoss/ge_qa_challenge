package com.ge.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.Wait;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    @FindBy(id = "user-name")
    private SelenideElement usernameField;
    @FindBy(id = "password")
    private SelenideElement passwordField;
    @FindBy(id = "login-button")
    private SelenideElement loginButton;

    public ProductsPage login(){
        //TODO: use data provider for users.
        Wait().until(webDriver -> usernameField.isDisplayed());
        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();
        return page(ProductsPage.class);
    }

}
