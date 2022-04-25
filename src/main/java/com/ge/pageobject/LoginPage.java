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
    @FindBy(css = "h3[data-test='error']")
    private SelenideElement badCredsMessage;

    public ProductsPage login(String username, String password) {
        //TODO: use data provider for users.
        Wait().until(webDriver -> usernameField.isDisplayed());
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        return page(ProductsPage.class);
    }

    public String getBadCredsMsg() {
        return badCredsMessage.text();
    }

}
