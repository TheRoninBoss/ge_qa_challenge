package com.ge.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class CheckoutPage extends AbstractBasePage {
    @FindBy(id = "first-name")
    private SelenideElement firstNameField;
    @FindBy(id = "last-name")
    private SelenideElement lastNameField;
    @FindBy(id = "postal-code")
    private SelenideElement postalCodeField;
    @FindBy(id = "continue")
    private SelenideElement continueButton;

    public CheckoutPage fillFirstName(String name) {
        firstNameField.sendKeys(name);
        return this;
    }

    public CheckoutPage fillLastName(String surname) {
        lastNameField.sendKeys(surname);
        return this;
    }

    public CheckoutPage fillPostalCode(String code) {
        postalCodeField.sendKeys(code);
        return this;
    }

    public CheckoutOverviewPage continueToOverview() {
        continueButton.click();
        return page(CheckoutOverviewPage.class);
    }

}
