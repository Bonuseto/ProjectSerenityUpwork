package org.example.steps;

import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.example.steps.serenity.EndUserSteps;

public class DefinitionSteps {
    @Steps
    private EndUserSteps userSteps;

    @Given("^User is on a Home page$")
    public void userIsOnAHomePage() {
        userSteps.navigateToTheHomePage();
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
