package sakhaulov.jiraTests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sakhaulov.Atlassian.AtlassianPages.IndexPage;

import java.time.Duration;

@Disabled
public class AuthorizationPositiveTests extends AbstractTest{

    @Test
    @Feature("Авторизация")
    @DisplayName("Авторизация с валидными данными")
    @Severity(SeverityLevel.BLOCKER)
    void authValidDataTest() {

        getDriver().navigate().to("https://www.atlassian.com/");

        IndexPage indexPage = new IndexPage(getDriver());

        indexPage
                .clickMyAccount()
                .clickLogIn();

        TestSteps.authorize(getDriver(), TestData.LOGIN, TestData.PASSWORD);

        //Authorization assertion
        new WebDriverWait(getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains("start.atlassian.com"));
        Assertions.assertTrue(getDriver().findElements(By.xpath(".//*[contains(text(), 'sakhaulov')]")).size() > 0,
                "Ошибка авторизации");
    }
}
