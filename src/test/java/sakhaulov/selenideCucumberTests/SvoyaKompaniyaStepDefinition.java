package sakhaulov.selenideCucumberTests;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;

public class SvoyaKompaniyaStepDefinition {

    private WebDriver driver;

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1280x720";
    }

    @Given("I've selected Chelyabinsk as my location")
    public void iVeSelectedChelyabinskAsMyLocation() {
        open("https://chelyabinsk.svoya-kompaniya.ru/");
    }

    @When("I click on location button at the page header")
    public void iClickOnLocationButtonAtThePageHeader() {
        $(By.cssSelector("div.location")).hover();
    }

    @And("Pick {string} in the drop-down menu")
    public void pickAtTheModalWindow(String city) throws InterruptedException {
        $(By.xpath(String.format("//a[contains(.,'%s')]", city))).click();
    }

    @Then("My location changed to {string}")
    public void myLocationChangedTo(String city) {
        $(By.cssSelector("span.location__text")).shouldHave(text(city));
    }

}
