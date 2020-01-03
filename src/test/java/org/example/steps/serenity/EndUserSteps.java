package org.example.steps.serenity;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.example.pages.HomePage;
import org.fluentlenium.core.annotation.Page;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EndUserSteps {
    @Page
    private HomePage homePage;

    @Step
    public void navigateToTheHomePage(String browser) {
        if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", ".\\src\\geckodriver.exe");
            WebDriver driver = new FirefoxDriver();
            driver.navigate().to("http://localhost:8080/");
        }
        else if (browser.equals( "chrome")){
            System.setProperty("webdriver.chrome.driver", ".\\src\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.navigate().to("http://localhost:8080/");
        }
       /* if (!homePage.isOpen()) {
            homePage.open();
        }*/
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