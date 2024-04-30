package step_definitions;

import SalesforceModules.ForecastingModule;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.KeywordUtil;

import java.util.HashMap;

import static utilities.KeywordUtil.catchAssertError;
import java.util.Map;

public class SalesForceForecasting {
    public static HashMap<String, String> dataMap = new HashMap<String, String>();
    public static String forecastName = KeywordUtil.generateRandomName();

    public static void main(String[] args) {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    @Given("^Read the test data  \"([^\"]*)\" from Excel for Forecasting$")
    public void read_the_test_data_from_Excel(String arg1) {
        try {
            KeywordUtil.cucumberTagName = "Web";
            dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", arg1);
        } catch (Throwable e) {
            GlobalUtil.e = e;
            GlobalUtil.errorMsg = e.getMessage();
            Assert.fail(e.getMessage());
        }

    }

    @When("Check Forecast access for logged in User")
    public void checkForecastAccessForLoggedInUser() throws InterruptedException {
        try {
            ForecastingModule.clickAndEnterValue("Enter the value in search field", "Users");
            ForecastingModule.clickOnEditOption();
            ForecastingModule.scrollToAllowForecast();
            ForecastingModule.closeTheUserGeneralInfoPage();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    @And("Assign a Role to the Forecast User")
    public void assignARoleToTheForecastUser() {
        try {
            ForecastingModule.clickAndEnterValue("Enter the value in search field", "Roles");
            ForecastingModule.selectValueFromSampleRoleHierarchies();
            ForecastingModule.selectRolesFromHierarchy("CEO", "Assign");
            ForecastingModule.assignRolesToUser();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    @Then("Create Users Hierarchy for Forecast")
    public void createNewUserHierarchy() {
        try {
            ForecastingModule.clickAndEnterValue("Enter the value in search field", "Users");
            ForecastingModule.clickUsers("Click on Users option");
            ForecastingModule.clickOnNewUser("Click on new user");
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    @And("Check users shown in the Forecasts Hierarchy")
    public void checkUsersShownInTheForecastsHierarchy() {
        try {
            ForecastingModule.clickAndEnterValue("Enter the value in search field", "Forecasts Hierarchy");
            ForecastingModule.verifyRoleAssignToUSer();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    @And("Enable Forecast Settings for first-time user logging")
    public void forecastSettings() {
        try {
            ForecastingModule.clickOnSetup("Setup page is opened");
            ForecastingModule.closePrevioustab();
            ForecastingModule.clickAndEnterValue("Enter the value in search field", "Forecasts Settings");
            ForecastingModule.forecastSettingsOption("Click on Forecasts Settings");
            ForecastingModule.enableForecasts("Click on Forecasts toggle button");
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    @And("Create Forecast Type with Opportunities")
    public void createForecastTypeWithOpportunities() {
        try {
            ForecastingModule.clickOnSetup("Setup page is opened");
            ForecastingModule.clickAndEnterValue("Enter the value in search field", "Forecasts Settings");
            ForecastingModule.createForecastTypeWithOpportunities(forecastName);
        } catch (Exception e) {
            catchAssertError(e);
        }
    }


    @And("Create Forecast Type with Opportunities and Product")
    public void createForecastTypeWithOpportunitiesAndProduct() {
        try {
            ForecastingModule.clickAndEnterValue("Enter the value in search field", "Forecasts Settings");
            ForecastingModule.createForecastTypeWithOpportunitiesandProduct(forecastName);
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    @And("Choose forecast range and show or hide quotas from the forecast")
    public void chooseForecastRangeOrShowHideQuotasFromTheForecast() {
        try {
            ForecastingModule.clickAndEnterValue("Enter the value in search field", "Forecasts Settings");
            ForecastingModule.chooseaDefaultDateRange();
            ForecastingModule.chooseaDefaultQuotas();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    @And("Verify Forecast on Manager Users Dashboard")
    public void verifyForecastOnManagerUsersDashboard() {
        try {
            ForecastingModule.verifyForecastonManagerUsersDashboard();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    @And("Verify Forecast on Teams Users Dashboard")
    public void verifyForecastOnTeamsUsersDashboard() {
        try {
            ForecastingModule.verifyForecastonTeamsUsersDashboard();
        } catch (Exception e) {
            catchAssertError(e);
        }

    }
    @And("Navigate to forecast settings page")
    public void navigateToForecastSettingsPage() {
        try {
            ForecastingModule.clickAndEnterValue("Enter the value in search field", "Forecasts Settings");
        } catch (Exception e) {
            catchAssertError(e);
        }
    }
    @Then("Validate Forecast settings page is loaded")
    public void validateForecastSettingsPageIsLoaded() {
        try {
            ForecastingModule.validateForecastSettingsPageShouldBeLoaded();
        }
        catch (Exception e) {
            catchAssertError(e);
        }
    }
    @And("Activate Created Forecast")
    public void activateCreatedForecast() {
        try {
            ForecastingModule.clickAndEnterValue("Enter the value in search field", "Forecasts Settings");
            ForecastingModule.validateForecastSettingsPageShouldBeLoaded();
            ForecastingModule.clickOnShowActionsOfForecast(forecastName);
            ForecastingModule.selectActivateFromActions();
            ForecastingModule.clickOnAppLauncherIconAndSearchForForecast();
            ForecastingModule.validateForecastingPageIsLoaded();
            ForecastingModule.validateActivatedForecastIsAvailable(forecastName);
            ForecastingModule.clickOnSetup("Setup page is opened");
            KeywordUtil.switchToWindow();
        }
        catch (Exception e) {
            catchAssertError(e);
        }
    }
    @And("Assign Forecast Quotes To User")
    public void assignForecastQuotesToUser() {
        try{
            ForecastingModule.clickAndEnterValue("Enter the value in search field", "Forecasts Quotas");
            ForecastingModule.validateForecastQuotasPageIsLoaded();
            ForecastingModule.selectAllRoleBasedForecasts();
            ForecastingModule.clickOnEditSelectedRows();
            ForecastingModule.validateEditQuotasDialogIsDisplayed();
            ForecastingModule.enterQuotaValueAndClickOnSaveButton("3000");
            ForecastingModule.validateQuotasSavedDialogIsDisplayed();
            KeywordUtil.BrowserRefresh();
            KeywordUtil.delay(3000);
            ForecastingModule.clickOnAppLauncherIconAndSearchForForecast();
            ForecastingModule.validateForecastingPageIsLoaded();
            ForecastingModule.navigateToForecastType("Automation");
            ForecastingModule.validateUserAbleToSeeTheEditedQuota("3,000");
            ForecastingModule.clickOnSetup("Setup page is opened");
            KeywordUtil.switchToWindow();
        }
        catch (Exception e) {
            catchAssertError(e);
        }
    }
    }

