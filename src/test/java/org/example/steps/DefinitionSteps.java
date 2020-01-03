package org.example.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.example.steps.serenity.EndUserSteps;
import org.openqa.selenium.WebDriver;

public class DefinitionSteps {

    @Steps
    private EndUserSteps userSteps;

    WebDriver driver;

    @Given("User likes to browse with '(.*)'")
    public void userIsOnAHomePage(String browser) {
        userSteps.navigateToTheHomePage(browser);
    }

    @When("^User login with '(.*)' and '(.*)'$")
    public void userLoginWithEmailAndPassword(String email, String password) {
        userSteps.loginAs(email, password);
    }

    @Then("^appears message '(.*?)' on a home page$")
    public void appearsMessageOnAHomePage(String message) {
        userSteps.verifyMessageAppearsOnTheHomePage(message);
    }
}
