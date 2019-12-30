package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.HomePage;
import org.fluentlenium.core.annotation.Page;
import org.assertj.core.api.Assertions;
import org.junit.Assert;

public class EndUserSteps {
    @Page
    private HomePage homePage;

    @Step
    public void navigateToTheHomePage() {
        if (!homePage.isOpen()) {
            homePage.open();
        }
    }

    @Step
    public void loginAs(String email, String password) {
        Assertions.assertThat(homePage.isOpen())
                .as("Home page is not currently open")
                .isTrue();
        homePage.openLogInForm()
                .enterCredentials(email, password)
                .submitForm();
    }

    @Step
    public void verifyMessageAppearsOnTheHomePage(String expectedMessage) {
        final String message = homePage.getLoginMessage();
        Assert.assertEquals(expectedMessage, message);
    }
}