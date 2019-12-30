package org.example.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends PageObject {
    @FindBy(id = "username")
    private WebElementFacade emailInput;

    @FindBy(id = "password")
    private WebElementFacade passwordInput;

    @FindBy(css = "[jhitranslate='login.form.button']")
    private WebElementFacade submitButton;

    public LoginForm enterCredentials(String email, String password) {
        emailInput.type(email);
        passwordInput.type(password);
        return this;
    }

    public void submitForm() {
        submitButton.click();
    }
}
