package SalesforceModules;

import mobileutil.MobileKeywords2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobjects.SalesforceObjects.*;
import step_definitions.RunCukesTest;
import utilities.*;

import static mobileutil.MobileKeywords2.click;
import static utilities.KeywordUtil.takeScreenshotAndAttachInReport;


public class ForecastingModule {
    public static void clickOnSetup(String logStep) throws InterruptedException {
        if (!KeywordUtil.isWebElementVisible(ForecastingPage.setupTitle, logStep)) {
            KeywordUtil.waitForVisible(ForecastingPage.setupIcon);
            KeywordUtil.click(ForecastingPage.setupIcon, "Click on setup Icon at top right side.");
            KeywordUtil.waitForVisible(ForecastingPage.setupOption);
            KeywordUtil.click(ForecastingPage.setupOption, "Click on setup option.");
            KeywordUtil.waitForVisible(ForecastingPage.setupTitle);
        }
    }

    public static void clickAndEnterValue(String logStep, String searchValue) throws InterruptedException {
        KeywordUtil.inputText(ForecastingPage.setupSearch, searchValue, logStep);
        KeywordUtil.isWebElementVisible(ForecastingPage.searchSetupOption(searchValue), "Searched option is visible");
        takeScreenshotAndAttachInReport();
        KeywordUtil.click(ForecastingPage.userOption, "Click on " + searchValue + " option.");
        KeywordUtil.isWebElementVisible(ForecastingPage.usersPage, "Users page is visible.");
    }

    public static void clickOnEditOption() throws InterruptedException {
        GlobalUtil.getDriver().switchTo().frame((WebElement) GlobalUtil.getDriver().findElement(By.xpath("//iframe[@title='All Users ~ Salesforce - Developer Edition']")));
        takeScreenshotAndAttachInReport();
        KeywordUtil.isWebElementVisible(ForecastingPage.loggedInUser, "Logged in user is visible.");
        KeywordUtil.click(ForecastingPage.loggedInUser, "Click on Logged in user");
        GlobalUtil.getDriver().switchTo().defaultContent();
    }

    public static void scrollToAllowForecast() throws InterruptedException {
        KeywordUtil.waitForVisible(ForecastingPage.userGeneralInfo);
        GlobalUtil.getDriver().switchTo().frame((WebElement) GlobalUtil.getDriver().findElement(By.xpath("//iframe[@title='User Edit: Sukanya Jagtap ~ Salesforce - Developer Edition']")));
        KeywordUtil.scrollingToElementofAPage(ForecastingPage.allowForecasting, "Scroll to Allow forecasting option.");
        takeScreenshotAndAttachInReport();
        KeywordUtil.waitForVisible(ForecastingPage.allowForecasting);
        if (GlobalUtil.getDriver().findElement(By.xpath("//*[@name='forecast_enabled']")).getAttribute("checked") == null) {
            KeywordUtil.click(ForecastingPage.allowForecastingCheckbox, "Click on allow Forecasting Checkbox.");
            KeywordUtil.scrollingToElementofAPage(ForecastingPage.saveButton, "Scroll to save option.");
            KeywordUtil.waitForVisible(ForecastingPage.saveButton);
            takeScreenshotAndAttachInReport();
            KeywordUtil.click(ForecastingPage.saveButton, "Click on save option.");
        } else {
            GlobalUtil.getDriver().findElement(ForecastingPage.allowForecastingChecked).getAttribute("checked").equals("checked");
            takeScreenshotAndAttachInReport();
        }
        KeywordUtil.isWebElementVisible(ForecastingPage.allowForecastingChecked, "Verify Forecast access is given to user.");
    }

    public static void closeTheUserGeneralInfoPage() throws InterruptedException {
        KeywordUtil.scrollingToElementofAPage(ForecastingPage.closeButton, "Scroll to close option.");
        KeywordUtil.waitForVisible(ForecastingPage.closeButton);
        KeywordUtil.click(ForecastingPage.closeButton, "Click on close option.");
        KeywordUtil.isWebElementVisible(ForecastingPage.usersPage, "User move to previous user page.");
        takeScreenshotAndAttachInReport();
        GlobalUtil.getDriver().switchTo().defaultContent();
    }


}
