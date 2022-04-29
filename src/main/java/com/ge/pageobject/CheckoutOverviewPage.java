package com.ge.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class CheckoutOverviewPage extends AbstractBasePage {

    @FindBy(id = "finish")
    private SelenideElement finishButton;

    public ConfirmationPage completePurchase() {
        finishButton.click();
        return page(ConfirmationPage.class);
    }

}
