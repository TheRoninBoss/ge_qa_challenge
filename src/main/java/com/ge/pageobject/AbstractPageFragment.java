package com.ge.pageobject;

import com.codeborne.selenide.ElementsContainer;

import static com.codeborne.selenide.Selenide.page;

public abstract class AbstractPageFragment extends ElementsContainer {

    /**
     * Initialize a Page Object fields annotated with @FindBy, etc.
     */
    public static <PageObjectClass, T extends PageObjectClass> PageObjectClass item(
            T pageObject) {
        return page(pageObject);
    }

}
