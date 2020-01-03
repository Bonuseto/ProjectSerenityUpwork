package org.example.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://localhost:8080/")
public class HomePage extends PageObject {

    public static final String PAGE_URL = "http://localhost:8080/";

    @Page
    private LoginForm loginForm;

    @FindBy(id = "account-menu")
    private WebElementFacade accountMenuNavigation;

    @FindBy(css = "li a#login")
    private WebElementFacade loginMenuItem;

    @FindBy(id = "home-logged-message")
    private WebElementFacade loggedMessageLabel;

    public boolean isOpen() {
        return PAGE_URL.equals(getDriver().getCurrentUrl());
    }

    public LoginForm openLogInForm() {
        accountMenuNavigation.click();
        loginMenuItem.waitUntilPresent().click();
        return loginForm;
    }

    public String getLoginMessage() {
        return loggedMessageLabel.waitUntilPresent().getText();
    }
}
